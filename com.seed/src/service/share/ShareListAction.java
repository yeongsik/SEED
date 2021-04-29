package service.share;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ShareDAO;
import model.ShareDTO;
import service.SeedAction;
import service.SeedActionForward;

public class ShareListAction implements SeedAction{

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ShareListAction");
		int page = 1;
		int limit = 9;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int startRow = (page-1) * limit + 1;
		int endRow = page * limit;
		
		ShareDAO dao = ShareDAO.getInstance();
		int listcount = dao.getCount();
		System.out.println("listcount:"+listcount);
		
		List<ShareDTO> boardlist = dao.getList(startRow, endRow);
		System.out.println("boardlist:" + boardlist);
		
		int pageCount = listcount/limit + ((listcount%limit==0) ? 0:1);
		
		int startPage = ((page -1)/9) * limit + 1;	
		int endPage = startPage + 9 - 1;			
		
		if(endPage > pageCount) endPage = pageCount;
		
		request.setAttribute("page", page);
		request.setAttribute("listcount", listcount);
		request.setAttribute("boardlist", boardlist);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		SeedActionForward forward = new SeedActionForward();	

		forward.setRedirect(false);
		forward.setPath("./share/boad_share_list.jsp");
		return forward;
	}

}
