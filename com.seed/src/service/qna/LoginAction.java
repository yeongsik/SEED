package service.qna;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QnADAO;
import model.QnADTO;
import service.SeedAction;
import service.SeedActionForward;

public class LoginAction implements SeedAction {

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LoginAction");
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		
		QnADAO dao = QnADAO.getInstance();
		
		int result = dao.memberCheck(id, pw);
		System.out.println("result : " + result);
	
		String user_name = dao.getUserName(id);
		System.out.println("user_name : " + user_name);
		
		if(result==1) System.out.println("회원인증 성공");
		
		if(result == 1) {	// 회원인증 성공
			session.setAttribute("id", id);				
			session.setAttribute("user_name", user_name);
		} else {			// 회원인증 실패
			out.println("<script>");
			out.println("alert('로그인 실패')");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			
			return null;
		}
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false);
		forward.setPath("/ListAction.seed");
		
		return forward;
	}

}

