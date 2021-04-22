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
	
	// 조회수 증가
	public void readcountUpdate(int board_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql="update tip set board_view=board_view+1 ";
					sql+="where board_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();}catch(Exception e) {}
			if(con!=null) try {con.close();}catch(Exception e) {}
		}
		
	}
	
	// 상세 페이지 (select문을 사용하기 위해서는 메소드 앞에 자료형이 반드시 와야하는데 한사람이 작성한 상세정보를 돌려줄때는 DTO 두개 이상일경우는 LIST 사용)
	public TipDTO getDetail(int board_num) {
		TipDTO dto = new TipDTO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql="select * from tip where board_num=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);			// 형변환 했기 때문에 int로 받을 수 있음
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setBoard_num(rs.getInt("board_num"));
				dto.setBoard_category(rs.getString("board_category"));
				dto.setName(rs.getString("name"));
				dto.setBoard_subject(rs.getString("board_subject"));
				dto.setBoard_content(rs.getString("board_content"));
				dto.setBoard_register(rs.getTimestamp("board_register"));
				dto.setBoard_view(rs.getInt("board_view"));
				dto.setBoard_like(rs.getInt("board_like"));
				dto.setBoard_hate(rs.getInt("board_hate"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();}catch(Exception e) {}
			if(pstmt!=null) try {pstmt.close();}catch(Exception e) {}
			if(con!=null) try {con.close();}catch(Exception e) {}
		}

		return dto;
	}
	
	
	
}
