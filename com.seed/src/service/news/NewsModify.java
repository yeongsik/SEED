package service.news;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.NewsDAO;
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
		news.setBoard_category("board_category");
		news.setBoard_subject("board_subject");
		news.setBoard_content("board_content");
		
		NewsDAO dao = NewsDAO.getInstance();
		HttpSession session = request.getSession();
		String session_name = (String)session.getAttribute("name");
		
		if(session_name.equals(name)) {
			int result = dao.modify(news);
			if(result ==1) {
				System.out.println("글수정 완료");
			}
		} else {
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다')");
			out.println("history.go(-1)");
			out.println("</script>");
			out.close();
			
			return null;
		}
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false);
		forward.setPath("/NewsDetailAction.seed?board_num="+board_num+"&page="+page);
		return forward;
	}

}
