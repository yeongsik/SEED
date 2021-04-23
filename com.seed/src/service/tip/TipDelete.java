package service.tip;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TipDAO;
import service.SeedAction;
import service.SeedActionForward;

public class TipDelete implements SeedAction{

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TipDelete");
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		int num = Integer.parseInt(request.getParameter("board_num"));
		System.out.println("page:"+num);
		String page = request.getParameter("page");
		System.out.println("page:"+page);
		
		//비번비교
		String pw = request.getParameter("pw");
		/*
		MemberDAO memberdao = MemberDAO.getInstance();
		MemberDTO old = memberdao.getMember(pw);
		
		if(old.getPw().equals(pw)) {
			int result = memberdao.delete(pw);
			if(result == 1) System.out.println("삭제 성공");
		}else {
			out.println("<script>");
			out.println("alert('비번이 일치하지 않습니다.')");
			out.println("history.go(-1)");
			out.println("</script>");
			out.close();
			
			return null;
		}
		*/
		TipDAO dao = TipDAO.getInstance();
		int old = dao.delete(num);
		
		if (old==1) {
			System.out.println("글삭제 완료");
		}else{
			out.println("<script>");
			out.println("alert('로그인이 필요한 서비스 입니다.')");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		
		
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false);
		forward.setPath("/TipListAction.seed?page="+page);
		
		
		return forward;
	}

}
