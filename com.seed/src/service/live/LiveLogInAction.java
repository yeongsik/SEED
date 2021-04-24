package service.live;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LiveDAO;
import dao.MemberDAO;
import model.LiveDTO;
import model.MemberDTO;
import service.SeedAction;
import service.SeedActionForward;

public class LiveLogInAction implements SeedAction {

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LiveLogInAction");
		request.setCharacterEncoding("utf-8"); 
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberDAO mdao = new MemberDAO();
		MemberDTO mdto= new MemberDTO();
		
		mdto.setId(request.getParameter("id"));
		mdto.setPw(request.getParameter("pw"));
		int result = mdao.memberAuth(id,pw);
		
		if(result==-1) {
			out.println("<script>");
			out.println("alert('아이디/비밀번호가 일치하지않습니다.')");
			out.println("location.href='./member/MemberLogIn.seed';");
			out.println("</script>");
			out.close();
			return null;
		}else if(result==1) {
			out.println("<script>");
			out.println("alert('로그인되었습니다.')");
			out.println("</script>");
		}

		session.setAttribute(id, mdto.getId());
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(true);
		System.out.println("리스트액션");
		forward.setPath("./live/LiveListAction.seed");
		
		return forward;
	}

}