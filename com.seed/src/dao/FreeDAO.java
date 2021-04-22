package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.FreeDTO;

public class FreeDAO {

	// 싱글톤
	private static FreeDAO instance = new FreeDAO();
	
	public static FreeDAO getInstance() {
		return instance;
	}
	
	// 컨넥션풀에서 컨넥션을 구해오는 메소드
	private Connection getConnection() throws Exception{
		Context init = new InitialContext();
  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
  		return ds.getConnection();
	}
	
	// 글 작성 : 원문작성
	public int insert(FreeDTO board) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();

String sql="insert into model2 values(model2_seq.nextval,?,?,?,?,sysdate,";	
       sql+="model2_seq.nextval,?,?,?)";

       		pstmt = con.prepareStatement(sql);
       		//pstmt.setInt(1, 0); // stop // model2_seq.nextval이 board_num이야. 자동으로 첨부되서 해줄 필요없어.
       		pstmt.setString(1, board.getName());
       		pstmt.setString(2, board.getBoard_category());
       		pstmt.setString(3, board.getBoard_subject());
       		pstmt.setString(4, board.getBoard_content());
       		pstmt.setInt(5, 0);		// board_view
       		pstmt.setInt(6, 0);     // board_like
       		pstmt.setInt(7, 0);     // board_hate
       		result = pstmt.executeUpdate();		// SQL문 실행 
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try { pstmt.close(); }catch(Exception e) {}
			if(con!=null) try { con.close(); }catch(Exception e) {}
		}
		return result;
	}
	
	// 총 데이터 갯수 구하기
	public int getCount() {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql="select count(*) from model2";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();		// SQL문 실행
			
			if(rs.next()) {
				result = rs.getInt("count(*)");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try { rs.close(); }catch(Exception e) {}
			if(pstmt!=null) try { pstmt.close(); }catch(Exception e) {}
			if(con!=null) try { con.close(); }catch(Exception e) {}
		}
		return result;
	}
	
	// 글 목록
	public List<FreeDTO> getList(int start, int end){
		List<FreeDTO> list = new ArrayList<FreeDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();

String sql="select * from (select rownum rnum, board.*  from ";
	   sql+=" (select * from model2 order by board_re_ref desc,";
	   sql+=" board_re_seq asc) board ) ";
	   sql+=" where rnum>=? and rnum<=?";
	   
	   		pstmt = con.prepareStatement(sql);
	   		pstmt.setInt(1, start);
	   		pstmt.setInt(2, end);
	   		rs = pstmt.executeQuery();		// SQL문 실행
	   		
	   		while(rs.next()) {
	   			FreeDTO board = new FreeDTO();
	   			board.setBoard_num(rs.getInt("board_num"));
	   			board.setName(rs.getString("board_name"));
	   			board.setBoard_category(rs.getString("board_category"));
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
			if(rs!=null) try { rs.close(); }catch(Exception e) {}
			if(pstmt!=null) try { pstmt.close(); }catch(Exception e) {}
			if(con!=null) try { con.close(); }catch(Exception e) {}
		}
		return list;
	}
	
	// 조회수 증가
	public void readcountUpdate(int board_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
String sql="update model2 set board_readcount=board_readcount+1 ";
       sql+=" where board_num = ?";		

       		pstmt = con.prepareStatement(sql);
       		pstmt.setInt(1, board_num);
       		pstmt.executeUpdate();		// SQL문 실행
       
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try { pstmt.close(); }catch(Exception e) {}
			if(con!=null) try { con.close(); }catch(Exception e) {}
		}
	}
	
	// 상세 페이지
	public FreeDTO getDetail(int board_num) {
		FreeDTO board = new FreeDTO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql="select * from model2 where board_num=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			rs = pstmt.executeQuery();		// SQL문 실행
			
			if(rs.next()) {
				board.setBoard_num(rs.getInt("board_num"));
	   			board.setName(rs.getString("board_name"));
	   			board.setBoard_category(rs.getString("board_category"));
	   			board.setBoard_subject(rs.getString("board_subject"));
	   			board.setBoard_content(rs.getString("board_content"));
	   			board.setBoard_register(rs.getTimestamp("board_register"));
	   			board.setBoard_view(rs.getInt("board_view"));
	   			board.setBoard_like(rs.getInt("board_like"));
	   			board.setBoard_hate(rs.getInt("board_hate"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try { rs.close(); }catch(Exception e) {}
			if(pstmt!=null) try { pstmt.close(); }catch(Exception e) {}
			if(con!=null) try { con.close(); }catch(Exception e) {}
		}
		return board;
	}
}