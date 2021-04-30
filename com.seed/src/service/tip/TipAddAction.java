package service.tip;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TipDAO;
import model.TipDTO;
import service.SeedAction;
import service.SeedActionForward;

public class TipAddAction implements SeedAction{

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TipAddAction");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String name = (String) session.getAttribute("user_name");
		
		//DTO 생성
		TipDTO dto = new TipDTO();

		dto.setBoard_category(request.getParameter("board_category"));
		dto.setName(name);
		dto.setBoard_subject(request.getParameter("board_subject"));
		dto.setBoard_content(request.getParameter("board_content"));
		System.out.println("카테고리:"+dto.getBoard_category());
		System.out.println("작성자:"+dto.getName());
		System.out.println("제목:"+dto.getBoard_subject());
		System.out.println("내용:"+dto.getBoard_content());
		//DAO 생성
		TipDAO dao = TipDAO.getInstance();

		int result = dao.insert(dto);

		if(result == 1) {
			System.out.println("글작성 성공");
			out.println("<script>");
			out.println("alert('글작성 성공');");
			out.println("</script>");
		}else {
			System.out.println("글작성 실패");
			out.println("<script>");
			out.println("alert('글작성 실패');");
			out.println("history.go(-1);");
			out.println("</script>");
			
			return null;
		}
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(true);
		forward.setPath("./TipListAction.seed");
		
		return forward;
	}

}
