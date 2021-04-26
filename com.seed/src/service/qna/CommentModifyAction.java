package service.qna;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QnADAO;
import model.QnADTO;
import service.SeedAction;
import service.SeedActionForward;

public class CommentModifyAction implements SeedAction {

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("CommentModifyAction");
		
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		
		QnADTO comment = new QnADTO();
		comment.setRe_content(request.getParameter("smartEditor"));
		
		QnADAO dao = QnADAO.getInstance();
		int result = dao.commentModify(comment);
		
		if(result == 1) {
			System.out.println("댓글 수정 성공");
		} else {
			out.println("<script>");
			out.println("alert('댓글 수정 실패')");
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
