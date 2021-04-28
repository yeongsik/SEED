package service.tip;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TipDAO;
import model.TipDTO;
import service.SeedAction;
import service.SeedActionForward;

public class TipCommentAddAction implements SeedAction{

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TipCommentAddAction");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		// DTO 생성
		TipDTO dto = new TipDTO();
		
		dto.setName("댓글맨");
		dto.setRe_content("re_content");
		System.out.println("작성자:"+dto.getName());
		System.out.println("내용:"+dto.getRe_content());
		
		// DAO 생성
		TipDAO dao = TipDAO.getInstance();
		int result = dao.commentInsert(dto);
		
		return null;
	}

}
