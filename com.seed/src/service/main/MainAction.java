package service.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NewsDAO;
import model.NewsDTO;
import service.SeedAction;
import service.SeedActionForward;

public class MainAction implements SeedAction {

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MainAction");
		
		NewsDAO newsDAO = NewsDAO.getInstance();
		
		List<NewsDTO> bestNewsList = newsDAO.getBestList(10);
		
		System.out.println(bestNewsList);
		request.setAttribute("bestNewsList", bestNewsList);
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false);
		forward.setPath("./main/main.jsp");
		return forward;
	}

}
