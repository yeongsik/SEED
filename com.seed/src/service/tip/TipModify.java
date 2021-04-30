package service.tip;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TipDAO;
import model.TipDTO;
import service.SeedAction;
import service.SeedActionForward;

public class TipModify implements SeedAction{

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TipModify");
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		// hidden 값
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		
		TipDTO dto = new TipDTO();
		dto.setName("name1");
		dto.setBoard_num(board_num);
		dto.setBoard_category(request.getParameter("board_category"));
		dto.setBoard_subject(request.getParameter("board_subject"));
		dto.setBoard_content(request.getParameter("board_content"));
		
		TipDAO dao = TipDAO.getInstance();
		int old = dao.update(dto);
		
		if (old==1) {
			System.out.println("글수정 완료");
		}else{
			out.println("<script>");
			out.println("alert('로그인이 필요한 서비스 입니다.')");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false);
		forward.setPath("/TipDetailAction.seed?board_num="+board_num+"&page="+page);
		
		return forward;
	}

}
