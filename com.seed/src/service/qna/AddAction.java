package service.qna;

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
		
		request.setCharacterEncoding("UTF-8");
		
		QnADTO board = new QnADTO();
		board.setBoard_category(request.getParameter("category"));
		board.setName("하마");
		board.setBoard_subject(request.getParameter("subject"));
		board.setBoard_content(request.getParameter("smartEditor"));
		
		QnADAO dao = QnADAO.getInstance();
		
		int result = dao.insert(board);
		
		if(result == 1) {
			System.out.println("글 작성 성공");
		}
		
		SeedActionForward forward = new SeedActionForward(); 
		forward.setRedirect(true);
		forward.setPath("./ListAction.seed");
		
		return forward;
	}

}
