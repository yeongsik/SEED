package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.ShareDTO;

public class ShareDAO {
	
	private static ShareDAO instance = new ShareDAO();
	
	public static ShareDAO getInstance() {
		return instance;
	}
	
	private Connection getConnection() throws Exception{
  		Context init = new InitialContext();
  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
  		return ds.getConnection();
	}
	
	// 글 작성
	public int insert(ShareDTO dto) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			String sql="insert into share_link values(share_seq.nextval,?,?,?,?,?,sysdate)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getShare_site());
			pstmt.setString(3, dto.getShare_des());
			pstmt.setString(4, dto.getShare_link());
			pstmt.setInt(5, dto.getShare_view());
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
				
				String sql="select count(*) from share_link";
				
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
	public List<ShareDTO> getList(int start, int end){
		List<ShareDTO> list = new ArrayList<ShareDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();

			String sql="select * from (select rownum rnum, share_link.* from ";
					sql+="(select * from share_link order by share_register desc) share_link )";
					sql+=" where rnum>=? and rnum<=?";
					
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ShareDTO dto = new ShareDTO();
				dto.setShare_num(rs.getInt("share_num"));
				dto.setName(rs.getString("name"));
				dto.setShare_site(rs.getString("share_site"));
				dto.setShare_des(rs.getString("share_des"));
				dto.setShare_link(rs.getString("share_link"));
				dto.setShare_view(rs.getInt("share_view"));
				dto.setShare_register(rs.getTimestamp("share_register"));

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
	
	// 조회수 증가
	public void readcountUpdate(int share_view) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql="update share_link set share_view=share_view+1 ";
					sql+="where share_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, share_view);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();}catch(Exception e) {}
			if(con!=null) try {con.close();}catch(Exception e) {}
		}
		
	}
	
	
	// 글 상세 구하기
	public ShareDTO getDetail(int share_num) {
		ShareDTO dto = new ShareDTO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql="select * from share_link where share_num=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, share_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setShare_num(rs.getInt("share_num"));
				dto.setName(rs.getString("name"));
				dto.setShare_site(rs.getString("share_site"));
				dto.setShare_des(rs.getString("share_des"));
				dto.setShare_link(rs.getString("share_link"));
				dto.setShare_view(rs.getInt("share_view"));
				dto.setShare_register(rs.getTimestamp("share_register"));
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
