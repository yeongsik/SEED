package service.qna;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QnADAO;
import model.QnADTO;
import service.SeedAction;
import service.SeedActionForward;

public class LikeUpdate implements SeedAction {
 
	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LikeUpdate");
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		String page = request.getParameter("page");
		
		PrintWriter out = response.getWriter();
		
		QnADAO dao = QnADAO.getInstance();
		
		int result = dao.likeUpdate(board_num);
		
		QnADTO board = dao.getDetail(board_num);
		
		if(result == 1) {
			System.out.println("추천 수 증가 성공");
		} else {
			System.out.println("추천 수 증가 실패");
		}
		 
		out.println(board.getBoard_like());
		out.close();
		 
		return null;
		
	}

}
