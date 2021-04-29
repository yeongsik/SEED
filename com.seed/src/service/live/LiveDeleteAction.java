package service.live;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LiveDAO;
import service.SeedAction;
import service.SeedActionForward;



public class LiveDeleteAction implements SeedAction {

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LiveDeleteAction");
		
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		
		LiveDAO dao = LiveDAO.getInstance();
		int result = dao.delete(board_num);
		
		if(result==1) {
			System.out.println("글 삭제 성공");
			out.println("<script>");
			out.println("alert('글 삭제 완료');");
			out.println("location.href='./LiveListAction.seed'");
			out.println("</script>");
			out.close();
			
			return null;
		} else {
			System.out.println("글 삭제 실패");
			
		}
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false);
		forward.setPath("/LiveListAction.seed?page="+page); 
		
		return forward;
		
	}

}
