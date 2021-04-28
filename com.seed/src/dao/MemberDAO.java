package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.MemberDTO;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	private Connection getConnection() throws Exception {
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
		return ds.getConnection();
	}
	
	public int memberAuth (String id , String pw) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = "select * from member where id = ? and pw =? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result =1;
			} else {
				result =-1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if ( rs != null) try { rs.close(); } catch (Exception e) {}
			if ( pstmt != null) try { pstmt.close(); } catch (Exception e) {}
			if ( con != null) try { con.close(); } catch (Exception e) {}
		}
		
		return result;
	}
	
	public MemberDTO getMember (String id) {
		MemberDTO member = new MemberDTO();
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
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setPw(rs.getString("pw"));
				member.setProfile(rs.getString("profile"));
				member.setSignup_date(rs.getTimestamp("signup_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs !=null) try {rs.close(); } catch (Exception e) {}
			if(pstmt !=null ) try {pstmt.close(); } catch (Exception e) {}
			if(con !=null) try {con.close(); } catch (Exception e) {}
		}
		return member;
	}
	
	// 글삭제
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
	
	
	
}
