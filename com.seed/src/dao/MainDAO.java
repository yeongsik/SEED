package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class MainDAO {
private static MainDAO instance = new MainDAO();
	
	public static MainDAO getInstance() {
		return instance;
	}
	
	private Connection getConnection() throws Exception{
		Context init = new InitialContext();
  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
  		return ds.getConnection();
	}
	
	public JSONArray weeklyBestList(String table_name) {
		System.out.println("weeklyBestList");
		JSONArray list = new JSONArray();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con= getConnection();
			String sql = "select * from (select rownum rnum , board.* from"
					+ " (select * from "+table_name
					+ " where board_register between sysdate-7 and sysdate"
					+ " order by board_view desc) board )"
					+ " where rnum >= 1 and rnum <=10 ";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Timestamp board_reg = rs.getTimestamp("board_register");
				String board_register = format.format(board_reg);
				System.out.println(board_register);
				
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("board_num", rs.getString("board_num"));
				jsonObject.put("board_subject", rs.getString("board_subject"));
				jsonObject.put("name", rs.getString("name"));
				jsonObject.put("board_register", board_register);
				list.add(jsonObject);
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
}
