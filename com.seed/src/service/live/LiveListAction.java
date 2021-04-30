package service.live;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LiveDAO;
import model.LiveDTO;
import service.SeedAction;
import service.SeedActionForward;

public class LiveListAction implements SeedAction{

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LiveListAction");
		
		request.setCharacterEncoding("utf-8");
		
		int page = 1; 		
		int limit = 10;     
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		
		int startRow = (page-1) * limit + 1;	
		int endRow = page * limit;
		
		LiveDAO dao = LiveDAO.getInstance();
		int listcount = dao.getCount();		// 총 데이터 갯수
		System.out.println("listcount:"+ listcount);
		
		List<LiveDTO> livelist = dao.getList(startRow, endRow);
		System.out.println("livelist:" + livelist);
		
		int pageCount=listcount/limit+((listcount%limit==0) ? 0:1); 
		
		int startPage = ((page - 1)/10) * limit + 1; 
		int endPage = startPage + 10 - 1;            
		
		if(endPage > pageCount)   endPage = pageCount;
		
		request.setAttribute("page", page);
		request.setAttribute("listcount", listcount);
		request.setAttribute("livelist", livelist);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		LiveDAO wbdao = LiveDAO.getInstance();
		List<LiveDTO> weeklybest = wbdao.getWeeklyBest();
		System.out.println("weeklybest : " + weeklybest);
		
		request.setAttribute("weeklybest", weeklybest);
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false); 
		System.out.println("리스트 총 페이지");
		forward.setPath("/live/live_board_list.jsp");
		
		return forward;
	}
 
} 
