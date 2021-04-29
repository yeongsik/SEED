package service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QnADAO;
import model.QnADTO;
import service.SeedAction;
import service.SeedActionForward;

public class SignUpAction implements SeedAction {

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("SignUpAction");
		
		request.setCharacterEncoding("UTF-8");
		
		QnADTO member = new QnADTO();
		member.setId(request.getParameter("id"));
		member.setPw(request.getParameter("pw"));
		member.setName(request.getParameter("name"));
		member.setProfile("없음");
		
		QnADAO dao = QnADAO.getInstance();
		int result = dao.memberInsert(member);
		
		if(result == 1) {
			System.out.println("회원가입 성공");
		}
		
		SeedActionForward forward =new SeedActionForward();
		forward.setRedirect(false);
		forward.setPath("/member/member_login_form.jsp");
		
		return forward;
	}

}
