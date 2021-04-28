package service.news;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NewsDAO;
import model.NewsDTO;
import service.SeedAction;
import service.SeedActionForward;

public class NewsListAction implements SeedAction{

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NewsListAction");
		
		int page = 1;
		int limit = 20;
		
		if(request.getParameter("page") !=null ) {
			page =Integer.parseInt(request.getParameter("page"));
		}
		
		int startRow  = (page-1) * limit +1;
		int endRow = page * limit;
		
		NewsDAO dao = NewsDAO.getInstance();
		int listcount = dao.getCount();
		System.out.println("listcount:" + listcount);
		
		List<NewsDTO> newslist = dao.getList(startRow ,endRow);
		System.out.println("newslist : " + newslist);
		/* List<NewsDTO> weeklylist = dao.getBest(); */
		List<NewsDTO> weeklybest_newslist = dao.getBestList();
		System.out.println("weeklybest : " + weeklybest_newslist);
		int pageCount = listcount / limit + ((listcount%limit ==0) ? 0:1);
		
		int startPage = ((page -1)/10) * 10 +1;
		int endPage = startPage + 10 - 1;
		
		if(endPage>pageCount) endPage = pageCount;
		
		request.setAttribute("page", page);
		request.setAttribute("listcount", listcount);
		request.setAttribute("newslist", newslist);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("weeklybest_newslist", weeklybest_newslist);
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false);
		forward.setPath("./news/board_news_list.jsp");
		return forward;
	}
	

}
