package service.qna;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QnADAO;
import model.QnADTO;
import service.SeedAction;
import service.SeedActionForward;

public class ListAction implements SeedAction {

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ListAction");
		
		int page = 1;
		int limit = 10;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int startRow = (page-1) * limit + 1;
		int endRow = page * limit;
		
		QnADAO dao = QnADAO.getInstance();
		int listcount = dao.getCount();
		
		System.out.println("listcount : " + listcount);
		
		List<QnADTO> boardlist = dao.getList(startRow, endRow);
		System.out.println("boardlist : " + boardlist);
	
		int pageCount = listcount / limit + ((listcount % limit == 0) ? 0 : 1);
		
		int startPage = ((page - 1) /10) * limit + 1;	// 1, 11, 21...
		int endPage = startPage + 10 -1;
		
		if(endPage > pageCount) { endPage = pageCount; }
		
		request.setAttribute("page", page);
		request.setAttribute("listcount", listcount);
		request.setAttribute("boardlist", boardlist);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		// ------------------------------------------------------------------- Weekly Best
		
		QnADAO second_dao = QnADAO.getInstance();
		List<QnADTO> weeklybest = second_dao.getWeeklyBest();
		System.out.println("weeklybest : " + weeklybest);
		
		request.setAttribute("weeklybest", weeklybest);
		
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false);
		forward.setPath("./qna/qna_board_list.jsp");
		
		return forward;
	}

}
