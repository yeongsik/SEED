// DAO(Data Access Object)

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.FreeDTO;

public class FreeDAO {

	// 싱글톤
	private static FreeDAO instance = new FreeDAO();
	
	public static FreeDAO getInstance() {
		return instance;
	}
	
	// DB연동
	public static Connection getConnection () {
        String user = "seed";
        String pw = "1234";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection conn = null;
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(url, user, pw);
            System.out.println("성공");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
	}
	
	// 글 작성 : 원문작성
	public int insert(FreeDTO board) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
									// =board_num 자동첨부
			String sql="insert into free values(free_seq.nextval,?,?,?,?,sysdate,?,?,?)";
       
       		pstmt = con.prepareStatement(sql);
       		pstmt.setString(1, board.getName());
       		pstmt.setString(2, board.getBoard_category());
       		pstmt.setString(3, board.getBoard_subject());
       		pstmt.setString(4, board.getBoard_content());
       		pstmt.setInt(5, 0);		// board_view
       		pstmt.setInt(6, 0);     // board_like
       		pstmt.setInt(7, 0);     //board_hate
       		
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
			
			String sql="select count(*) from free";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();	// SQL문 실행
			
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
	
	// 글 목록 : 데이터 10개씩 추출
	public List<FreeDTO> getList(int start, int end){
		List<FreeDTO> list = new ArrayList<FreeDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql="select * from ";
			   sql+=" (select rownum rnum, free.* from free order by board_num desc)";
			   sql+=" where rnum>=? and rnum<=?";
	   
	   		pstmt = con.prepareStatement(sql);
	   		pstmt.setInt(1, start);
	   		pstmt.setInt(2, end);
	   		rs = pstmt.executeQuery();	// SQL문 실행
	   		
	   		while(rs.next()) {
	   			FreeDTO board = new FreeDTO();
	   			board.setBoard_num(rs.getInt("board_num"));
	   			board.setName(rs.getString("name"));
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
	
	// 조회 수 증가
	public void viewUpdate(int board_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			String sql="update free set board_view=board_view+1 where board_num=?";

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
	
	// 상세 페이지 : 본문
	public FreeDTO getDetail(int board_num) {
		FreeDTO board = new FreeDTO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql="select * from free where board_num=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			rs = pstmt.executeQuery();		// SQL문 실행
			
			if(rs.next()) {
				board.setBoard_num(rs.getInt("board_num"));
	   			board.setName(rs.getString("name"));
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
	
	// 글 수정
		public int update(FreeDTO board) {
			int result = 0;
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
			String sql="update free set board_category=?,board_subject=?,board_content=? where board_num=?";
				   
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, board.getBoard_category());
				pstmt.setString(2, board.getBoard_subject());
				pstmt.setString(3, board.getBoard_content());
				pstmt.setInt(4, board.getBoard_num());
				result = pstmt.executeUpdate();		// SQL문 실행
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(pstmt != null) { try { pstmt.close();}catch(Exception e) {} }
				if(con != null) { try { con.close();}catch(Exception e) {} }
			}
			return result;
		}
		
		// 글 삭제
		public int delete(int board_num) {
			int result = 0;
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql = "delete from free where board_num=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, board_num);
				result = pstmt.executeUpdate();		// SQL문 실행
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(pstmt != null) { try { pstmt.close();}catch(Exception e) {} }
				if(con != null) { try { con.close();}catch(Exception e) {} }
			}
			return result;
		}
		
//		// 댓글 작성
//		public int reply(ReplyDTO board) {
//			int result = 0;
//			
//			// 부모글에 대한 정보
//			int ref = board.getRef();
//			int re_step = board.getRe_step();
//			int re_level = board.getRe_level();
//			
//			Connection con = null;
//			PreparedStatement pstmt = null;
//			
//			try {
//				con = getConnection();
//				
//				String sql="update board set re_step=re_step+1 ";
//				       sql+=" where ref=? and re_step > ?";
//				       
//				pstmt = con.prepareStatement(sql);
//				pstmt.setInt(1, ref);
//				pstmt.setInt(2, re_step);
//				pstmt.executeUpdate();		// SQL문 실행
//				
//		  sql="insert into board values(board_seq.nextval,?,?,?,?,";
//	      sql+="sysdate,?,?,?,?,?,?)";
//	      
//	      		pstmt = con.prepareStatement(sql);
//	      		pstmt.setString(1, board.getWriter());
//	      		pstmt.setString(2, board.getEmail());
//	      		pstmt.setString(3, board.getSubject());
//	      		pstmt.setString(4, board.getPasswd());
//	      		pstmt.setInt(5, 0);					// readcount
//	      		pstmt.setInt(6, ref);				// ref
//	      		pstmt.setInt(7, re_step+1);			// re_step
//	      		pstmt.setInt(8, re_level+1);		// re_level
//	      		pstmt.setString(9, board.getContent());
//	      		pstmt.setString(10, board.getIp());
//	      		
//	      		result = pstmt.executeUpdate();		// SQL문 실행
//				
//			}catch(Exception e) {
//				e.printStackTrace();
//			}finally {
//				if(pstmt != null) { try { pstmt.close();}catch(Exception e) {} }
//				if(con != null) { try { con.close();}catch(Exception e) {} }
//			}
//			return result;
//		}
	}