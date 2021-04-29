package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.ldap.PagedResultsControl;
import javax.sql.DataSource;

import model.MemberDTO;
import model.QnADTO;

public class QnADAO {
	 
	private static QnADAO instance = new QnADAO();
	
	public static QnADAO getInstance() {
		return instance;
	}
	
	private Connection getConnection() throws Exception {
		Context init = new InitialContext();
  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
  		return ds.getConnection();
	}
	
	public int memberInsert(QnADTO member) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			String sql = "insert into member values(?,?,?,sysdate,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPw());
			pstmt.setString(4, member.getProfile());
			
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
			if(con != null) try {con.close();}catch(Exception e) {}
		}
		
		return result;
	}
	
	public int memberCheck(String id, String pw) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql ="select * from member where id=? and pw=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {	// 회원인증 성공
				return 1;
			} else {		// 회원인증 실패
				return -1;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();}catch(Exception e) {}
			if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
			if(con != null) try {con.close();}catch(Exception e) {}
		}
		
		return result;
	}
	
	public int idCheck(String id) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql = "select * from member where id=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {		// 중복 ID
				result = 1;
			} else {			// 사용 가능한 ID
				result = -1;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();}catch(Exception e) {}
			if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
			if(con != null) try {con.close();}catch(Exception e) {}
		}
		
		return result;
	}
	
	public int nameCheck(String id) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql = "select * from member where name=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {		// 중복 ID
				result = 1;
			} else {			// 사용 가능한 ID
				result = -1;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();}catch(Exception e) {}
			if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
			if(con != null) try {con.close();}catch(Exception e) {}
		}
		
		return result;
	}
	
	public String getUserName(String id) {
		QnADTO member = new QnADTO();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql = "select * from member where id=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member.setName(rs.getString("name"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();}catch(Exception e) {}
			if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
			if(con != null) try {con.close();}catch(Exception e) {}
		}
		
		return member.getName();
	}
	
	public int insert(QnADTO board) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			String sql = "insert into qa values(board_num_seq.nextval,?,?,?,?,sysdate,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getBoard_category());
			pstmt.setString(2, board.getName());
			pstmt.setString(3, board.getBoard_subject());
			pstmt.setString(4, board.getBoard_content());
			pstmt.setInt(5, 0);
			pstmt.setInt(6, 0);
			pstmt.setInt(7, 0);
			
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try {pstmt.close();}catch(Exception e) {}
			if(con!=null) try {con.close();}catch(Exception e) {}
		}
		
		return result;
	}
	
	public int getCount() {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql = "select count(*) from qa";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("count(*)");
			}
		} catch(Exception e)  {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();}catch(Exception e) {}
			if(pstmt!=null) try {pstmt.close();}catch(Exception e) {}
			if(con!=null) try {con.close();}catch(Exception e) {}
		}
		
		return result;
	}
	
	public List<QnADTO> getList(int start, int end) {
		List<QnADTO> list = new ArrayList<QnADTO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql = "select * from (select rownum rnum, board.* from ";
			  sql += " (select * from qa order by board_num desc ) board ) ";
			  sql += " where rnum>=? and rnum<=?";
			  
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				QnADTO board = new QnADTO();
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
		} catch(Exception e)  {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();}catch(Exception e) {}
			if(pstmt!=null) try {pstmt.close();}catch(Exception e) {}
			if(con!=null) try {con.close();}catch(Exception e) {}
		}
		
		return list;
	}
	
	// 조회수 증가
	public void viewUpdate(int board_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			String sql = "update qa set board_view=board_view+1 where board_num=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try {pstmt.close();}catch(Exception e) {}
			if(con!=null) try {con.close();}catch(Exception e) {}
		}
	}
	
	public QnADTO getDetail(int board_num) {
		QnADTO board = new QnADTO();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql = "select * from qa where board_num=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board.setBoard_num(rs.getInt("board_num"));
				board.setBoard_category(rs.getString("board_category"));
				board.setName(rs.getString("name"));
				board.setBoard_subject(rs.getString("board_subject"));
				board.setBoard_content(rs.getString("board_content"));
				board.setBoard_register(rs.getTimestamp("board_register"));
				board.setBoard_view(rs.getInt("board_view"));
				board.setBoard_like(rs.getInt("board_like"));
				board.setBoard_hate(rs.getInt("board_hate"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();}catch(Exception e) {}
			if(pstmt!=null) try {pstmt.close();}catch(Exception e) {}
			if(con!=null) try {con.close();}catch(Exception e) {}
		}
		
		return board;
	}
	
	public int update(QnADTO board) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			String sql ="update qa set board_category=?,board_subject=?,board_content=? where board_num=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getBoard_category());
			pstmt.setString(2, board.getBoard_subject());
			pstmt.setString(3, board.getBoard_content());
			pstmt.setInt(4, board.getBoard_num());
			
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
 		} finally {
 			if(pstmt!=null) try {pstmt.close();}catch(Exception e) {}
			if(con!=null) try {con.close();}catch(Exception e) {}
 		}
		
		return result;
	}
	
	// 추천 수 증가
	public int likeUpdate(int board_num) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			String sql ="update qa set board_like=board_like+1 where board_num=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
 		} finally {
 			if(pstmt!=null) try {pstmt.close();}catch(Exception e) {}
			if(con!=null) try {con.close();}catch(Exception e) {}
 		}
		return result;
	}
	
	// 추천 수 감소
		public int likeDownUpdate(int board_num) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql ="update qa set board_like=board_like-1 where board_num=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, board_num);
				pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
	 		} finally {
	 			if(pstmt!=null) try {pstmt.close();}catch(Exception e) {}
				if(con!=null) try {con.close();}catch(Exception e) {}
	 		}
			return result;
		}
	
		// 반대 수 증가
		public int hateUpdate(int board_num) {
			int result = 0;
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql ="update qa set board_hate=board_hate+1 where board_num=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, board_num);
				result = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
	 		} finally {
	 			if(pstmt!=null) try {pstmt.close();}catch(Exception e) {}
				if(con!=null) try {con.close();}catch(Exception e) {}
	 		}
			
			return result;
		}
		
		// 반대 수 증가
		public int hateDownUpdate(int board_num) {
			int result = 0;
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql ="update qa set board_hate=board_hate-1 where board_num=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, board_num);
				result = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
	 		} finally {
	 			if(pstmt!=null) try {pstmt.close();}catch(Exception e) {}
				if(con!=null) try {con.close();}catch(Exception e) {}
	 		}
			
			return result;
		}
	
		public int delete(int board_num) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql ="delete from qa where board_num=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, board_num);
				
				result = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
	 		} finally {
	 			if(pstmt!=null) try {pstmt.close();}catch(Exception e) {}
				if(con!=null) try {con.close();}catch(Exception e) {}
	 		}
			
			return result;
		}
	
	
		public List<QnADTO> getWeeklyBest() {
			List<QnADTO> list = new ArrayList<QnADTO>();
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = getConnection();
				
				String sql = "select * from (select rownum rnum, board.* from ";
				  sql += " (select * from qa order by board_like desc ) board ) ";
				  sql += " where rnum<6";
				  
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();

				while(rs.next()) {
					QnADTO board = new QnADTO();
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
			} catch(Exception e)  {
				e.printStackTrace();
			} finally {
				if(rs!=null) try {rs.close();}catch(Exception e) {}
				if(pstmt!=null) try {pstmt.close();}catch(Exception e) {}
				if(con!=null) try {con.close();}catch(Exception e) {}
			}
			
			return list;
	
		}
	
		// --------------------------------------------------- comment function 
		public int commentInsert(QnADTO board) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql = "insert into qa_re values(re_num_seq.nextval,?,?,sysdate,?,?,?,?,?,?)";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, board.getName());
				pstmt.setString(2, board.getRe_content());
				pstmt.setInt(3, board.getRe_like());
				pstmt.setInt(4, board.getRe_hate());
				pstmt.setInt(5, 0);
				pstmt.setInt(6, 0);
				pstmt.setInt(7, 0);
				pstmt.setInt(8, board.getBoard_num());
				
				result = pstmt.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt!=null) try {pstmt.close();}catch(Exception e) {}
				if(con!=null) try {con.close();}catch(Exception e) {}
			}
			
			return result;
		}
		
		public int commentModify(int re_num, QnADTO comment) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql ="update qa_re set re_content=?, re_register=sysdate where board_num=? and re_num=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, comment.getRe_content());
				pstmt.setInt(2, comment.getBoard_num());
				pstmt.setInt(3, comment.getRe_num());
				
				result = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
	 		} finally {
	 			if(pstmt!=null) try {pstmt.close();}catch(Exception e) {}
				if(con!=null) try {con.close();}catch(Exception e) {}
	 		}
			
			return result;
		}
		
	
		public int commentDelete(int board_num, int re_num) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql ="delete from qa_re where board_num=? and re_num=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, board_num);
				pstmt.setInt(2, re_num);
				
				result = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
	 		} finally {
	 			if(pstmt!=null) try {pstmt.close();}catch(Exception e) {}
				if(con!=null) try {con.close();}catch(Exception e) {}
	 		}
			
			return result;
		}
	
		public List<QnADTO> getComment(int board_num) {
			List<QnADTO> list = new ArrayList<QnADTO>();
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = getConnection();
				
				String sql = "select * from qa_re where board_num=? order by re_num asc";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, board_num);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					QnADTO board = new QnADTO();
					board.setRe_num(rs.getInt("re_num"));
					board.setRe_name(rs.getString("re_name"));
					board.setRe_content(rs.getString("re_content"));
					board.setRe_register(rs.getTimestamp("re_register"));
					board.setRe_like(rs.getInt("re_like"));
					board.setRe_hate(rs.getInt("re_hate"));
					board.setRe_ref(rs.getInt("re_ref"));
					board.setRe_lev(rs.getInt("re_lev"));
					board.setRe_seq(rs.getInt("re_seq"));
					board.setBoard_num(rs.getInt("board_num"));
					
					list.add(board);
				}
			} catch(Exception e)  {
				e.printStackTrace();
			} finally {
				if(rs!=null) try {rs.close();}catch(Exception e) {}
				if(pstmt!=null) try {pstmt.close();}catch(Exception e) {}
				if(con!=null) try {con.close();}catch(Exception e) {}
			}
			
			return list;
		}
		
		public int getCountContentFromQA(String user_name) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = getConnection();
				
				String sql = "select count(*) from qa where name=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user_name);
					
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					result = rs.getInt("count(*)");
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(rs != null) try {rs.close();}catch(Exception e) {}
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
				
			}
			
			return result;
		}
		
		public int getCountContentFromFree(String user_name) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = getConnection();
				
				String sql = "select count(*) from free where name=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user_name);
					
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					result = rs.getInt("count(*)");
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(rs != null) try {rs.close();}catch(Exception e) {}
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
				
			}
			
			return result;
		}
		
		public int getCountContentFromLive(String user_name) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = getConnection();
				
				String sql = "select count(*) from live where name=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user_name);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					result = rs.getInt("count(*)");
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(rs != null) try {rs.close();}catch(Exception e) {}
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
				
			}
			
			return result;
		}
		
		public int getCountContentFromNews(String user_name) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = getConnection();
				
				String sql = "select count(*) from news where name=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user_name);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					result = rs.getInt("count(*)");
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(rs != null) try {rs.close();}catch(Exception e) {}
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
				
			}
			
			return result;
		}
		
		public int getCountContentFromTip(String user_name) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = getConnection();
				
				String sql = "select count(*) from tip where name=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user_name);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					result = rs.getInt("count(*)");
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(rs != null) try {rs.close();}catch(Exception e) {}
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
				
			}
			
			return result;
		}
		
		public int getCountCommentFromQA(String user_name) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = getConnection();
				
				String sql = "select count(*) from qa_re where re_name=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user_name);
					
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					result = rs.getInt("count(*)");
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(rs != null) try {rs.close();}catch(Exception e) {}
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
				
			}
			
			return result;
		}
		
		public int getCountCommentFromFree(String user_name) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = getConnection();
				
				String sql = "select count(*) from free_re where name=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user_name);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					result = rs.getInt("count(*)");
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(rs != null) try {rs.close();}catch(Exception e) {}
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
				
			}
			
			return result;
		}
		
		public int getCountCommentFromLive(String user_name) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = getConnection();
				
				String sql = "select count(*) from live_re where name=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user_name);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					result = rs.getInt("count(*)");
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(rs != null) try {rs.close();}catch(Exception e) {}
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
				
			}
			
			return result;
		}
		
		public int getCountCommentFromNews(String user_name) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = getConnection();
				
				String sql = "select count(*) from news_re where name=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user_name);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					result = rs.getInt("count(*)");
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(rs != null) try {rs.close();}catch(Exception e) {}
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
				
			}
			
			return result;
		}
		
		public int getCountCommentFromTip(String user_name) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = getConnection();
				
				String sql = "select count(*) from tip_re where name=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user_name);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					result = rs.getInt("count(*)");
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(rs != null) try {rs.close();}catch(Exception e) {}
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
				
			}
			
			return result;
		}
		
		
		public MemberDTO getMemberIdPw(String user_name) {
			MemberDTO member = new MemberDTO();
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = getConnection();
				
				String sql = "select id,pw from member where name=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user_name);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					member.setId(rs.getString("id"));
					member.setPw(rs.getString("pw"));
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(rs != null) try {rs.close();}catch(Exception e) {}
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
				
			}
			
			return member;
		}
		
		public int changeUserName(String before_name, String after_name, String after_pw) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql = "update member set name=?, pw=? where name=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, after_name);
				pstmt.setString(2, after_pw);
				pstmt.setString(3, before_name);
				
				result = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
				
			}
			
			return result;
		}
		
		public int changeContentNameAtQA(String after_user_name, String before_user_name) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql = "update qa set name=? where name=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, after_user_name);
				pstmt.setString(2, before_user_name);
				
				result = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
				
			}
			
			return result;
		}
		
		public int changeContentNameAtFREE(String after_user_name, String before_user_name) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql = "update free set name=? where name=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, after_user_name);
				pstmt.setString(2, before_user_name);
				
				result = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
				
			}
			
			return result;
		}
		
		public int changeContentNameAtLIVE(String after_user_name, String before_user_name) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql = "update live set name=? where name=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, after_user_name);
				pstmt.setString(2, before_user_name);
				
				result = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
				
			}
			
			return result;
		}
		
		public int changeContentNameAtTIP(String after_user_name, String before_user_name) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql = "update tip set name=? where name=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, after_user_name);
				pstmt.setString(2, before_user_name);
				
				result = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
				
			}
			
			return result;
		}
		
		public int changeContentNameAtNEWS(String after_user_name, String before_user_name) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql = "update news set name=? where name=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, after_user_name);
				pstmt.setString(2, before_user_name);
				
				result = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
				
			}
			
			return result;
		}
		
		
		public int changeCommentNameAtQA_RE(String after_user_name, String before_user_name) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql = "update qa_re set re_name=? where re_name=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, after_user_name);
				pstmt.setString(2, before_user_name);
				
				result = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
				
			}
			
			return result;
		}
		
		public int changeCommentNameAtFREE_RE(String after_user_name, String before_user_name) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql = "update free_re set name=? where name=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, after_user_name);
				pstmt.setString(2, before_user_name);
				
				result = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
				
			}
			
			return result;
		}
		
		public int changeCommentNameAtLIVE_RE(String after_user_name, String before_user_name) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql = "update live_re set name=? where name=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, after_user_name);
				pstmt.setString(2, before_user_name);
				
				result = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
				
			}
			
			return result;
		}
		
		public int changeCommentNameAtTIP_RE(String after_user_name, String before_user_name) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql = "update tip_re set name=? where name=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, after_user_name);
				pstmt.setString(2, before_user_name);
				
				result = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
				
			}
			
			return result;
		}
		
		public int changeCommentNameAtNEWS_RE(String after_user_name, String before_user_name) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql = "update news_re set name=? where name=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, after_user_name);
				pstmt.setString(2, before_user_name);
				
				result = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
				
			}
			
			return result;
		}
		
		public int getMemberDays(String user_name) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = getConnection();
				
				String sql = "select to_char(sysdate, 'yyyymmdd') - to_char(signup_date, 'yyyymmdd') 가입일수 from member where name=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user_name);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					result = rs.getInt("가입일수");
				} 
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(rs != null) try {rs.close();}catch(Exception e) {}
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
			}
			
			return result;
		}
		
		
		public int DeleteMember(String user_name) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql = "delete from member where name=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user_name);
				
				result = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
			}
			
			return result;
		}
		
		public int DeleteContentAtQA(String user_name) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql = "delete from qa where name=?";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user_name);
				
				result = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
			}
			
			return result;
		}
		
		public int DeleteContentAtFREE(String user_name) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql = "delete from free where name=?";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user_name);
				
				result = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
			}
			
			return result;
		}
		
		public int DeleteContentAtLIVE(String user_name) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql = "delete from live where name=?";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user_name);
				
				result = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
			}
			
			return result;
		}
		
		public int DeleteContentAtTIP(String user_name) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql = "delete from tip where name=?";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user_name);
				
				result = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
			}
			
			return result;
		}
		
		public int DeleteContentAtNEWS(String user_name) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql = "delete from news where name=?";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user_name);
				
				result = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
			}
			
			return result;
		}
		
		public int DeleteCommentAtFREE_RE(String user_name) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql = "delete from free_re where name=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user_name);
				
				result = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
			}
			
			return result;
		}
		
		public int DeleteCommentAtLIVE_RE(String user_name) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql = "delete from live_re where name=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user_name);
				
				result = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
			}
			
			return result;
		}
		
		public int DeleteCommentAtTIP_RE(String user_name) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql = "delete from tip_re where name=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user_name);
				
				result = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
			}
			
			return result;
		}
		
		public int DeleteCommentAtNEWS_RE(String user_name) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql = "delete from news_re where name=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user_name);
				
				result = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
			}
			
			return result;
		}
		
		public int DeleteCommentAtQA_RE(String user_name) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql = "delete from qa_re where re_name=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user_name);
				
				result = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(con != null) try {con.close();}catch(Exception e) {}
			}
			
			return result;
		}
		
		
}

