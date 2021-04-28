package service.qna;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QnADAO;
import model.QnADTO;
import service.SeedAction;
import service.SeedActionForward;

public class ModifyAction implements SeedAction {

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ModifyAction");
		
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		
		QnADTO board = new QnADTO();
		board.setBoard_num(board_num);
		board.setBoard_category(request.getParameter("category"));
		board.setBoard_subject(request.getParameter("subject"));
		board.setBoard_content(request.getParameter("smartEditor"));
		
		QnADAO dao = QnADAO.getInstance();
		int result = dao.update(board);
		
		
		if(result == 1) {
			System.out.println("글 수정 성공");
		} else {
			out.println("<script>");
			out.println("alert('알 수 없는 오류가 발생했습니다.')");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			
			return null;
		}
		
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false);
		forward.setPath("/DetailAction.seed?board_num="+board_num+"&page="+page);
		
		return forward;
	}
	
}
