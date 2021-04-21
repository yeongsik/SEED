package service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import model.MemberDTO;
import service.SeedAction;
import service.SeedActionForward;

public class MemberLogIn implements SeedAction{

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MemberLogIn");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		MemberDTO member = new MemberDTO();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println(id);
		System.out.println(pw);
		
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.memberAuth(id, pw);
		System.out.println("result :" + result);
		if(result ==1) {
			System.out.println("로그인 성공");
			member = dao.getMember(id);
			session.setAttribute("name", member.getName());
			session.setAttribute("id", id);
		} else {
			out.println("<script> alert('로그인 실패');");
			out.println("history.go(-1); </script>");
			out.close();
			return null;
		}
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false);
		forward.setPath("./member/main.jsp");
		return forward;
	}

}
