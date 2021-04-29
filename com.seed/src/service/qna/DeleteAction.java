package service.qna;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QnADAO;
import service.SeedAction;
import service.SeedActionForward;



public class DeleteAction implements SeedAction {

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("DeleteAction");
		
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		
		QnADAO dao = QnADAO.getInstance();
		
		int result = dao.delete(board_num);
		
		if(result==1) {
			System.out.println("글 삭제 성공");
			out.println("<script>");
			out.println("alert('글이 삭제되었습니다');");
			out.println("location.href='./ListAction.seed'");
			out.println("</script>");
			out.close();
			
			return null;
		} else {
			System.out.println("글 삭제 실패");
			
		}
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false);
		forward.setPath("/ListAction.seed?page="+page); 
		
		return forward;
		
	}

}
