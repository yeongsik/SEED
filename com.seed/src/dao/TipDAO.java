package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.TipDTO;

public class TipDAO {
	
	// 싱글톤
	private static TipDAO instance = new TipDAO();
	
	public static TipDAO getInstance() {
		return instance;
	}
	
	// 커넥션풀 구해오기
	private Connection getConnection() throws Exception{
  		Context init = new InitialContext();
  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
  		return ds.getConnection();
	}
	
	//글작성 - 원문
	public int insert(TipDTO board) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();

String sql="insert into tip values(tip_seq.nextval,?,?,?,?,sysdate,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getBoard_category());
			pstmt.setString(2, board.getName());
			pstmt.setString(3, board.getBoard_subject());
			pstmt.setString(4, board.getBoard_content());
			pstmt.setInt(5, 0);		//view
			pstmt.setInt(6, 0);		//like
			pstmt.setInt(7, 0);		//hate
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();}catch(Exception e) {}
			if(con!=null) try {con.close();}catch(Exception e) {}
		}
		
		return result;
	}
	
	// 총 데이터 개수 구하기
	public int getCount() {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql="select count(*) from tip";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();				// SQL문 실행
			
			if(rs.next()) {
//				result = rs.getInt(1);
				result = rs.getInt("count(*)");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();}catch(Exception e) {}
			if(pstmt!=null) try {pstmt.close();}catch(Exception e) {}
			if(con!=null) try {con.close();}catch(Exception e) {}
		}

		return result;
	}
	
	// 글목록
	public List<TipDTO> getList(int start, int end){
		List<TipDTO> list = new ArrayList<TipDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();

			String sql="select * from (select rownum rnum, tip.* from ";
					sql+="(select * from tip order by board_register desc) tip )";
					sql+=" where rnum>=? and rnum<=?";
					
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				TipDTO board = new TipDTO();
				board.setBoard_num(rs.getInt("board_num"));
				board.setBoard_category(rs.getString("board_category"));
				board.setName(rs.getString("name"));
				board.setBoard_subject(rs.getString("board_subject"));
				board.setBoard_content(rs.getString("board_content"));
				board.setBoard_register(rs.getTimestamp("board_register"));
				board.setBoard_view(rs.getInt("board_view"));
				board.setBoard_like(rs.getInt("board_like"));
				board.setBoard_hate(rs.getInt("board_hate"));
				
				list.add(board);
				
			}
					
					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();}catch(Exception e) {}
			if(pstmt!=null) try {pstmt.close();}catch(Exception e) {}
			if(con!=null) try {con.close();}catch(Exception e) {}
		}
		
		return list;
	}
	
	
	
}
