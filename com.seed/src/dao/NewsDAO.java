package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.NewsDTO;

public class NewsDAO {
	
	private static NewsDAO instance = new NewsDAO();
	
	public static NewsDAO getInstance() {
		return instance;
	}
	
	private Connection getConnection() throws Exception{
		Context init = new InitialContext();
  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
  		return ds.getConnection();
	}
	
	public int newsWrite(NewsDTO news) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "insert into news values (news_seq.nextval,?,?,?,?,sysdate,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, news.getBoard_category());
			pstmt.setString(2, news.getName());
			pstmt.setString(3, news.getBoard_subject());
			pstmt.setString(4, news.getBoard_content());
			pstmt.setInt(5, 0);
			pstmt.setInt(6, 0);
			pstmt.setInt(7, 0);
			result=pstmt.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if ( pstmt != null) { try { pstmt.close(); } catch (Exception e) { } } 
			if ( con != null) { try { con.close(); } catch (Exception e) { } } 
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
			String sql = "select count(*) from news";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("count(*)");
			}
		} catch (Exception e) {
			
		} finally {
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		return result;
	}
	
	public List<NewsDTO> getList (int start , int end) {
		List<NewsDTO> list = new ArrayList<NewsDTO> ();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con=getConnection();
			String sql = "select * from (select rownum rnum, board.* from "
						+ " (select * from news order by board_num desc) board ) "
						+ " where rnum >=? and rnum <=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				NewsDTO news = new NewsDTO();
				news.setBoard_num(rs.getInt("board_num"));
				news.setBoard_category(rs.getString("board_category"));
				news.setName(rs.getString("name"));
				news.setBoard_subject(rs.getString("board_subject"));
				news.setBoard_content(rs.getString("board_content"));
				news.setBoard_register(rs.getTimestamp("board_register"));
				news.setBoard_view(rs.getInt("board_view"));
				news.setBoard_like(rs.getInt("board_like"));
				news.setBoard_hate(rs.getInt("board_hate"));
				
				list.add(news);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		return list;
	}
	//조회수 증가
	public void viewUpdate(int board_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = "update news set board_view = board_view+1 where board_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
	}
	
	public NewsDTO getDetail(int board_num) {
		NewsDTO news = new NewsDTO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con=getConnection();
			String sql = "select * from news where board_num=?";
			pstmt =con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				news.setBoard_num(rs.getInt("board_num"));
				news.setBoard_category(rs.getString("board_category"));
				news.setName(rs.getString("name"));
				news.setBoard_subject(rs.getString("board_subject"));
				news.setBoard_content(rs.getString("board_content"));
				news.setBoard_view(rs.getInt("board_view"));
				news.setBoard_like(rs.getInt("board_like"));
				news.setBoard_hate(rs.getInt("board_hate"));
				news.setBoard_register(rs.getTimestamp("board_register"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		return news;
	}
}
