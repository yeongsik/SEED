package service.tip;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TipDAO;
import model.TipDTO;
import service.SeedAction;
import service.SeedActionForward;

public class TipListAction implements SeedAction{

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TipListAction");
		
		int page = 1;		// 현재 페이지 번호
		int limit = 10;		// 한 화면에 출력할 데이터 개수
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int startRow = (page-1) * limit + 1;
		int endRow = page * limit;
		
		TipDAO dao = TipDAO.getInstance();
		int listcount = dao.getCount();			// 총 데이터개수
		System.out.println("listcount:"+ listcount);
		
		List<TipDTO> boardlist = dao.getList(startRow, endRow);
		System.out.println("boardlist:" + boardlist);
		
		// 총 페이지 구하기
		int pageCount = listcount/limit + ((listcount%limit==0) ? 0:1);		//10의 배수가 아니면 0 , 10의 배수면 1
		
		int startPage = ((page -1)/10) * limit + 1;	//1, 11, 21...
		int endPage = startPage + 10 - 1;			// 10, 20, 30...
		
		if(endPage > pageCount) endPage = pageCount;
		
		// 공유설정
		request.setAttribute("page", page);
		request.setAttribute("listcount", listcount);
		request.setAttribute("boardlist", boardlist);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		SeedActionForward forward = new SeedActionForward();	
		// dispatcher 방식으로 포워딩되어야 view 페이지에서 공유한 값에 접근할 수있다.
		forward.setRedirect(false);
		forward.setPath("./tip/board_tip_list.jsp");
		
		return forward;
	}
	
}
