package service.share;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ShareDAO;
import model.ShareDTO;
import service.SeedAction;
import service.SeedActionForward;

public class ShareDetailAction implements SeedAction{

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ShareDetailAction");
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		int share_num = Integer.parseInt(request.getParameter("share_num"));
		String page = request.getParameter("page");
		System.out.println(share_num);
		ShareDAO dao = ShareDAO.getInstance();
		dao.readcountUpdate(share_num);
		
		ShareDTO dto = dao.getDetail(share_num);
		
		System.out.println("share_num:"+share_num);
		System.out.println("share_link:"+dto.getShare_link());
		System.out.println("2");
		
		
		String link = dto.getShare_link();
		System.out.println("link:"+link);
		
		request.setAttribute("page", page);
		request.setAttribute("dto", dto);

		System.out.println("3");
		if(share_num > 0) {
			out.println("<script>");			
			out.println("window.open("+'"'+link+'"'+")");			
			out.println("history.go(-1)");	
			out.println("</script>");	
			out.close();
			return null;
		}
		
		/*
		 * SeedActionForward forward = new SeedActionForward();
		 * 
		 * forward.setRedirect(false); forward.setPath("./share/boad_share_list.jsp");
		 */
		 
		System.out.println("4");
		return null;
	}

}
