package service.main;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import dao.MainDAO;
import service.SeedAction;
import service.SeedActionForward;

public class MainWeeklyBestList implements SeedAction{

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MainWeeklyBestList");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String category_name = (String)request.getParameter("category_name");
		System.out.println(category_name);
		String table_name = null;
		JSONArray list = new JSONArray();
		if(category_name.equals("Q&A")) {
			table_name = "qa";
		} else if (category_name.equals("팁 게시판")) {
			table_name = "tip";
		} else if (category_name.equals("사는 얘기")) {
			table_name = "live";
		} else if (category_name.equals("News")) {
			table_name = "news";
		} else if (category_name.equals("자유 게시판")) {
			table_name = "free";
		}  	
		System.out.println("table_name : " +table_name);
		MainDAO dao = MainDAO.getInstance();
		list = dao.weeklyBestList(table_name);
		out.print(list);
		System.out.println(list);
		return null;
	}

}
