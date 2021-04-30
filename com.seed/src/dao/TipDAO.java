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
	
	// 글 수정
	public int update(TipDTO dto) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			String sql="update tip set board_category=?, board_subject=?, board_content=? ";
					sql+=" where board_num=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getBoard_category());
			pstmt.setString(2, dto.getBoard_subject());
			pstmt.setString(3, dto.getBoard_content());
			pstmt.setInt(4, dto.getBoard_num());
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();}catch(Exception e) {}
			if(con!=null) try {con.close();}catch(Exception e) {}
		}
		
		return result;
	}
	
	// 글삭제 ( pw가 MemberDAO에 있어서 그쪽에서 참조하는 바람에 일단 만들고 여기는 사본)
	// 글 상세 페이지에 pw가 없기 때문에 공통으로 포함된 부분이 없음.
	// 다른 부분으로 확인하거나 삭제시 비교구문 자체를 사용하지 않아야?
	public int delete(int board_num) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			String sql="delete from tip where board_num=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			result = pstmt.executeUpdate();
			System.out.println("삭제된 갯수:"+result);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt !=null ) try {pstmt.close(); } catch (Exception e) {}
			if(con !=null) try {con.close(); } catch (Exception e) {}
		}
		
		return result;
	}
	
	
	// 댓글 작성
	
	public int commentInsert(TipDTO re_board) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			String sql="insert into tip_re values(tip_re_seq.nextval,?,?,sysdate,?,?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, re_board.getName());
			pstmt.setString(2, re_board.getRe_content());
			pstmt.setInt(3, 0);
			pstmt.setInt(4, 0);
			pstmt.setInt(5, 0);
			pstmt.setInt(6, 0);
			pstmt.setInt(7, 0);
			pstmt.setInt(8, re_board.getBoard_num());
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
	public int getRe_Count() {
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
	
	// WeeklyBest
	public List<TipDTO> getWeeklyBestList(){
		List<TipDTO> list = new ArrayList<TipDTO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql="select * from (select rownum rnum, tip.*from ";
					sql+="(select * from tip order by board_view desc) tip) where rnum<6";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				TipDTO dto = new TipDTO();
				dto.setBoard_num(rs.getInt("board_num"));
				dto.setBoard_category(rs.getString("board_category"));
				dto.setName(rs.getString("name"));
				dto.setBoard_subject(rs.getString("board_subject"));
				dto.setBoard_content(rs.getString("board_content"));
				dto.setBoard_register(rs.getTimestamp("board_register"));
				dto.setBoard_view(rs.getInt("board_view"));
				dto.setBoard_like(rs.getInt("board_like"));
				dto.setBoard_hate(rs.getInt("board_hate"));
				
				list.add(dto);		
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
