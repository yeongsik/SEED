package service.share;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ShareDAO;
import model.ShareDTO;
import service.SeedAction;
import service.SeedActionForward;

public class ShareAddAction implements SeedAction{

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ShareAddAction");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		ShareDTO dto = new ShareDTO();
		
		dto.setName("댓글맨");
		dto.setShare_site(request.getParameter("share_site"));
		dto.setShare_des(request.getParameter("share_des"));
		dto.setShare_link(request.getParameter("share_link"));
		System.out.println("작성자:"+dto.getName());
		System.out.println("사이트명:"+dto.getShare_site());
		System.out.println("사이트설명:"+dto.getShare_des());
		System.out.println("사이트링크:"+dto.getShare_link());
		
		ShareDAO dao = ShareDAO.getInstance();
		
		int result = dao.insert(dto);
		
		if(result == 1) {
			System.out.println("글작성 성공");
			out.println("<script>");
			out.println("alert('글작성 성공');");
			out.println("</script>");
		}else {
			System.out.println("글작성 실패");
			out.println("<script>");
			out.println("alert('글작성 실패');");
			out.println("history.go(-1);");
			out.println("</script>");
			
			return null;
		}
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(true);
		forward.setPath("./ShareListAction.seed");
		
		return forward;
	}
	
}
