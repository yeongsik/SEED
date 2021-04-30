package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.LiveDTO;
import model.Live_reDTO;

public class LiveDAO {

	private static LiveDAO instance = new LiveDAO();
	
	public static LiveDAO getInstance() {
		return instance;
	}
	
	private Connection getConnection() throws Exception{
		Context init = new InitialContext();
  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
  		return ds.getConnection();
	}
	
	public int insert(LiveDTO live) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();

String sql="insert into live values(live_seq.nextval,?,?,?,?,sysdate,?,?,?)";	
       
      		pstmt = con.prepareStatement(sql);
       		pstmt.setString(1, live.getBoard_category());
       		pstmt.setString(2, live.getName());
       		pstmt.setString(3, live.getBoard_subject());
       		pstmt.setString(4, live.getBoard_content());
       		pstmt.setInt(5, 0);		
       		pstmt.setInt(6, 0);    
       		pstmt.setInt(7, 0);     
       		result = pstmt.executeUpdate();		
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try { pstmt.close(); }catch(Exception e) {}
			if(con!=null) try { con.close(); }catch(Exception e) {}
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
			
			String sql="select count(*) from live";
			
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
	
	
	// 글목록
	public List<LiveDTO> getList(int start, int end){
		List<LiveDTO> list = new ArrayList<LiveDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();

String sql="select * from (select rownum rnum, board.*  from ";
	   sql+=" (select * from live order by board_register desc) board )";
	   sql+=" where rnum>=? and rnum<=?";	
	   
	   		pstmt = con.prepareStatement(sql);
	   		pstmt.setInt(1, start);
	   		pstmt.setInt(2, end);
	   		rs = pstmt.executeQuery();	
	   		
	   		while(rs.next()) {
	   			LiveDTO live = new LiveDTO();
	   			live.setBoard_num(rs.getInt("board_num"));
	   			live.setBoard_category(rs.getString("board_category"));
	   			live.setName(rs.getString("name"));
	   			live.setBoard_subject(rs.getString("board_subject"));
	   			live.setBoard_content(rs.getString("board_content"));
	   			live.setBoard_register(rs.getTimestamp("board_register"));
	   			live.setBoard_view(rs.getInt("board_view"));
	   			live.setBoard_like(rs.getInt("board_like"));
	   			live.setBoard_hate(rs.getInt("board_hate"));
	   			
	   			list.add(live);
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
	
	public void readcountUpdate(int board_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
String sql="update live set board_view=board_view+1 ";
       sql+=" where board_num = ?";		

       		pstmt = con.prepareStatement(sql);
       		pstmt.setInt(1, board_num);
       		pstmt.executeUpdate();		
       
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try { pstmt.close(); }catch(Exception e) {}
			if(con!=null) try { con.close(); }catch(Exception e) {}
		}
		
	}
	//상세
	public LiveDTO getDetail(int board_num) {
		LiveDTO live = new LiveDTO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql="select * from live where board_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			
			rs = pstmt.executeQuery();	
			
			if(rs.next()) {
				live.setBoard_num(rs.getInt("board_num"));
				live.setBoard_category(rs.getString("board_category"));
				live.setName(rs.getString("name"));
				live.setBoard_subject(rs.getString("board_subject"));
				live.setBoard_content(rs.getString("board_content"));
				live.setBoard_register(rs.getTimestamp("board_register"));
				live.setBoard_view(rs.getInt("board_view"));
				live.setBoard_like(rs.getInt("board_like"));
				live.setBoard_hate(rs.getInt("board_hate"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try { rs.close(); }catch(Exception e) {}
			if(pstmt!=null) try { pstmt.close(); }catch(Exception e) {}
			if(con!=null) try { con.close(); }catch(Exception e) {}
		}
		
		return live;
	}
	//수정
	public int update(LiveDTO board) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
	String sql="update live set board_name=?, board_subject=?,";
	       sql+="board_content=? where board_num = ?";
	       
	       pstmt = con.prepareStatement(sql);
	       pstmt.setString(1, board.getName());
	       pstmt.setString(2, board.getBoard_subject());
	       pstmt.setString(3, board.getBoard_content());
	       pstmt.setInt(4, board.getBoard_num());
	       result = pstmt.executeUpdate();	// SQL문 실행
	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try { pstmt.close(); }catch(Exception e) {}
			if(con!=null) try { con.close(); }catch(Exception e) {}
		}		
		
		return result;
	}
	
	//삭제
	public int delete(int board_num) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			String sql="delete from live where board_num=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			result = pstmt.executeUpdate();		// SQL문 실행
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try { pstmt.close(); }catch(Exception e) {}
			if(con!=null) try { con.close(); }catch(Exception e) {}
		}
		
		return result;
	}
	// 댓글 작성
		public int LiveReply(Live_reDTO liveRe) {
			int result = 0;
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
		
			    
	  String sql="insert into live_re values(live_re_seq.nextval,?,?,sysdate,?,?,live_re_seq.nextval?, ";
	   sql+=" ?,?,?)";
	   
	   			pstmt = con.prepareStatement(sql);
	   			pstmt.setString(1, liveRe.getName());
	   			pstmt.setString(2, liveRe.getRe_content());
	   			pstmt.setInt(3, 0);
	   			pstmt.setInt(4, 0);
	   			pstmt.setInt(5, 0);    	
	   			pstmt.setInt(6, 0);  	
	   			pstmt.setInt(7, liveRe.getBoard_num());
	   			result = pstmt.executeUpdate();	
	   
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(pstmt!=null) try { pstmt.close(); }catch(Exception e) {}
				if(con!=null) try { con.close(); }catch(Exception e) {}
			}
			
			return result;
		}
		
		//댓글 리스트
		public List<Live_reDTO> getLiveReList (int board_num) {
			List<Live_reDTO> liveReList = new ArrayList<Live_reDTO>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = getConnection();
				String sql = "select * from live_re where board_num=? order by";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, board_num);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(rs!=null) try { rs.close(); }catch(Exception e) {}
				if(pstmt!=null) try { pstmt.close(); }catch(Exception e) {}
				if(con!=null) try { con.close(); }catch(Exception e) {}
			}
			
			
			return liveReList;
		}
		public int getLiveReCount(int board_num ) {
			int result = 0;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = getConnection();
				String sql = "select count(*) from live_re where board_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, board_num);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					rs.getInt(1);
				}
				
				
			}catch(Exception e) {
				
			}finally {
				if(rs!=null) try { rs.close(); }catch(Exception e) {}
				if(pstmt!=null) try { pstmt.close(); }catch(Exception e) {}
				if(con!=null) try { con.close(); }catch(Exception e) {}
			}
			
			
			return result;
		}
		
		public List<LiveDTO> getWeeklyBest() {
			List<LiveDTO> list = new ArrayList<LiveDTO>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = getConnection();
				String sql = "select * from (select rownum rnum, board.* from ";
				sql += " (select * from live order by board_view desc) board ) where rnum<6";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					LiveDTO live = new LiveDTO();
					live.setBoard_num(rs.getInt("board_num"));
					live.setBoard_category(rs.getString("board_category"));
					live.setBoard_subject(rs.getString("board_subject"));
					live.setBoard_content(rs.getString("board_content"));
					live.setBoard_register(rs.getTimestamp("board_register"));
					live.setBoard_view(rs.getInt("board_view"));
					live.setBoard_view(rs.getInt("board_like"));
					live.setBoard_view(rs.getInt("board_hate"));
					
					list.add(live);
				}
				
				
			}catch(Exception e) {
				
			}finally {
				if(rs!=null) try { rs.close(); }catch(Exception e) {}
				if(pstmt!=null) try { pstmt.close(); }catch(Exception e) {}
				if(con!=null) try { con.close(); }catch(Exception e) {}
			}
			
			
			return list;
		}
		
	
}
