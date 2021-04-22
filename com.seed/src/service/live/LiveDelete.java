package service.live;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.LiveDAO;
import model.LiveDTO;
import service.SeedAction;
import service.SeedActionForward;

public class LiveDelete implements SeedAction{

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardDelete");
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		String board_pass = request.getParameter("board_pass");
		
		LiveDAO dao = LiveDAO.getInstance();
		LiveDTO old = dao.getDetail(board_num);
		
		
		// 비번 비교
		/*
		 * if(old.getBoard_pass().equals(board_pass)) { // 비번 일치시 int result =
		 * dao.delete(board_num); if(result == 1) System.out.println("삭제 성공");
		 * 
		 * }else { // 비번 불일치시 out.println("<script>");
		 * out.println("alert('비번이 일치하지 않습니다.');"); out.println("history.go(-1);");
		 * out.println("</script>"); out.close();
		 * 
		 * return null; }
		 */
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false);
		forward.setPath("/LivedListAction.seed?page="+page);
		
		return forward;
	}

}
