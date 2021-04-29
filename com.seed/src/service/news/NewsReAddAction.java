package service.news;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.NewsDAO;
import model.NewsReDTO;
import service.SeedAction;
import service.SeedActionForward;

public class NewsReAddAction implements SeedAction {

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NewsReAddAction");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		String page=request.getParameter("page");
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String session_name = (String)session.getAttribute("name");
		String re_content = request.getParameter("re_content");
		if(session_name.equals(request.getParameter("name"))) {
			NewsReDTO re = new NewsReDTO();
			re.setName(session_name);
			re.setRe_content(request.getParameter("re_content"));
			re.setBoard_num(board_num);
			
			NewsDAO dao = NewsDAO.getInstance();
			int result = dao.newsReWrite(re);
			if(result ==1) {
				System.out.println("댓글작성 완료");
			} else { }
		} else { }
		
		request.setAttribute("page", page);
		request.setAttribute("board_num", board_num);
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false);
		forward.setPath("/NewsDetailAction.seed");
		
		return forward;
	}

}
