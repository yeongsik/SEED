package service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QnADAO;
import service.SeedAction;
import service.SeedActionForward;

public class SignOutMemberCourse3 implements SeedAction {

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("SignOutMemberCourse3");
		
		HttpSession session = request.getSession();
		
		String user_name = (String) session.getAttribute("user_name");
		System.out.println("user_name : " + user_name);
		
		
		QnADAO dao = QnADAO.getInstance();
		
		int result = dao.DeleteMember(user_name);
		
		result = result * dao.DeleteContentAtQA(user_name);
		result = result * dao.DeleteContentAtFREE(user_name);
		result = result * dao.DeleteContentAtLIVE(user_name);
		result = result * dao.DeleteContentAtTIP(user_name);
		result = result * dao.DeleteContentAtNEWS(user_name);
		
		result = result * dao.DeleteCommentAtQA_RE(user_name);
		result = result * dao.DeleteCommentAtFREE_RE(user_name);
		result = result * dao.DeleteCommentAtLIVE_RE(user_name);
		result = result * dao.DeleteCommentAtTIP_RE(user_name);
		result = result * dao.DeleteCommentAtNEWS_RE(user_name);
		
		System.out.println("result : " + result);
		
		if(result == 1) {
			System.out.println("회원탈퇴 성공");
			session.invalidate();
		} else {
			System.out.println("회원탈퇴 실패");
		}
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false);
		forward.setPath("./member/member_SignOutMemberCourse3.jsp");
		
		return forward;
	}

}
