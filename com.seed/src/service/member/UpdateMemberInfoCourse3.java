package service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QnADAO;
import service.SeedAction;
import service.SeedActionForward;

public class UpdateMemberInfoCourse3 implements SeedAction {

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("UpdateMemberInfoCourse3");

		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		String before_user_name = (String) session.getAttribute("user_name");
		String after_user_name = request.getParameter("name");
		String after_user_pw = request.getParameter("pw");

		System.out.println("before_user_name : " + before_user_name);
		System.out.println("after_user_name : " + after_user_name);
		
		QnADAO dao = QnADAO.getInstance();
		
		int changeContentNameAtQA = dao.changeContentNameAtQA(after_user_name, before_user_name);
		if(changeContentNameAtQA != -1) System.out.println("changeContentNameAtQA : " + changeContentNameAtQA);
		
		int changeContentNameAtFREE = dao.changeContentNameAtFREE(after_user_name, before_user_name);
		if(changeContentNameAtFREE != -1) System.out.println("changeContentNameAtFREE : " + changeContentNameAtFREE);
		
		int changeContentNameAtLIVE = dao.changeContentNameAtLIVE(after_user_name, before_user_name);
		if(changeContentNameAtLIVE != -1) System.out.println("changeContentNameAtLIVE : " + changeContentNameAtLIVE);
		
		int changeContentNameAtTIP = dao.changeContentNameAtTIP(after_user_name, before_user_name);
		if(changeContentNameAtTIP != -1) System.out.println("changeContentNameAtTIP : " + changeContentNameAtTIP);
		
		int changeContentNameAtNEWS = dao.changeContentNameAtNEWS(after_user_name, before_user_name);
		if(changeContentNameAtNEWS != 1) System.out.println("changeContentNameAtNEWS : " + changeContentNameAtNEWS);
		
		int changeCommentNameAtQA_RE = dao.changeCommentNameAtQA_RE(after_user_name, before_user_name);
		if(changeCommentNameAtQA_RE != 1) System.out.println("changeCommentNameAtQA_RE : " + changeCommentNameAtQA_RE);
		
		int changeCommentNameAtFREE_RE = dao.changeCommentNameAtFREE_RE(after_user_name, before_user_name);
		if(changeCommentNameAtFREE_RE != 1) System.out.println("changeCommentNameAtFREE_RE : " + changeCommentNameAtFREE_RE);
		
		int changeCommentNameAtLIVE_RE = dao.changeCommentNameAtLIVE_RE(after_user_name, before_user_name);
		if(changeCommentNameAtLIVE_RE != 1) System.out.println("changeCommentNameAtLIVE_RE : " + changeCommentNameAtLIVE_RE);
		
		int changeCommentNameAtTIP_RE = dao.changeCommentNameAtTIP_RE(after_user_name, before_user_name);
		if(changeCommentNameAtTIP_RE != 1) System.out.println("changeCommentNameAtTIP_RE : " + changeCommentNameAtTIP_RE);
		
		int changeCommentNameAtNEWS_RE = dao.changeCommentNameAtNEWS_RE(after_user_name, before_user_name);
		if(changeCommentNameAtNEWS_RE != 1) System.out.println("changeCommentNameAtNEWS_RE : " + changeCommentNameAtNEWS_RE);
		
		int changeUserName = dao.changeUserName(before_user_name, after_user_name, after_user_pw);
		System.out.println("changeUserName : " + changeUserName);
		
		if(changeUserName == 1) {
			System.out.println("회원정보수정 성공");
			session.setAttribute("user_name", after_user_name);
			out.println("<script>");
			out.println("alert('회원정보가 수정되었습니다.')");
			out.println("location.href='./MainAction.seed'");
			out.println("</script>");
			
			return null;
		} else {
			System.out.println("회원정보수정 실패");
		}
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false);
		forward.setPath("/MainAction.seed");
		
		return forward;
	}

}
