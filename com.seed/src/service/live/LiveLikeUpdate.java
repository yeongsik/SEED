package service.live;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LiveDAO;
import dao.QnADAO;
import model.LiveDTO;
import model.QnADTO;
import service.SeedAction;
import service.SeedActionForward;

public class LiveLikeUpdate implements SeedAction{

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LiveLikeUpdate");
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		String page = request.getParameter("page");
		PrintWriter out = response.getWriter();
		
		LiveDAO dao = LiveDAO.getInstance();
		int result = dao.LiveLikeUpdate(board_num);
		LiveDTO board = dao.getDetail(board_num);
		
		if(result == 1) {
			System.out.println("추천 수 up!!");
		} else {
			System.out.println("추천 수 증가 fail!!");
		}
		 
		out.println(board.getBoard_like());
		out.close();
		
		
		
		return null;
	}
	
}
