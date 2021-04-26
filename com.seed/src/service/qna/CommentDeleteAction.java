package service.qna;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QnADAO;
import model.QnADTO;
import service.SeedAction;
import service.SeedActionForward;

public class CommentDeleteAction implements SeedAction {

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("CommentDeleteAction");
		
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		int re_num = Integer.parseInt(request.getParameter("re_num"));
		String page = request.getParameter("page");
		
		System.out.println("page : " + page);
		
		QnADAO dao = QnADAO.getInstance(); 
		
		int result = dao.commentDelete(board_num, re_num);
		
		if(result==1) {
			System.out.println("댓글 삭제 성공");
			out.println("<script>");
			out.println("alert('댓글이 삭제되었습니다');");
//			out.println("location.href='./DetailAction.seed?board_num='+board_num+'&page='+page");
			out.println("location.href='./DetailAction.seed?board_num='+board_num+'&page='+page'");
			out.println("</script>");
			out.close();
			
			return null;
		} else {
			System.out.println("글 삭제 실패");
		}
		
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false);
		forward.setPath("./DetailAction.seed?board_num="+board_num+"&page="+page);
		
	
		return null;
	}

}
