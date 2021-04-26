package service.qna;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QnADAO;
import model.QnADTO;
import service.SeedAction;
import service.SeedActionForward;

public class AddAction implements SeedAction {

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("AddAction");
		
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		QnADTO board = new QnADTO();
		board.setBoard_category(request.getParameter("category"));
		board.setName("하마");
		board.setBoard_subject(request.getParameter("subject"));
		board.setBoard_content(request.getParameter("smartEditor"));
		
		QnADAO dao = QnADAO.getInstance();
		
		int result = dao.insert(board);
		
		if(result == 1) {
			System.out.println("글 작성 성공");
		} else {
			System.out.println("글 작성 실패");
			out.println("<script>");
			out.println("alert('글 작성 실패');");
			out.println("history.go(-1);");
			out.println("</script>");
			
			return null;
		}
		
		SeedActionForward forward = new SeedActionForward(); 
		forward.setRedirect(true);
		forward.setPath("./ListAction.seed");
		
		return forward;
	}

}
