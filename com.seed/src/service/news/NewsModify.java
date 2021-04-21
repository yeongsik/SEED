package service.news;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NewsDTO;
import service.SeedAction;
import service.SeedActionForward;

public class NewsModify implements SeedAction {

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NewsModify");
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		String name = request.getParameter("name");
		NewsDTO news = new NewsDTO();
		news.setBoard_num(board_num);
		news.setName(name);
		
		
		return null;
	}

}
