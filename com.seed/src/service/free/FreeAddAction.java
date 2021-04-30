package service.free;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.FreeDAO;
import model.FreeDTO;
import service.SeedAction;
import service.SeedActionForward;

public class FreeAddAction implements SeedAction {

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("FreeAddAction");
		
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("name");
		
		FreeDTO dto = new FreeDTO();
		
		dto.setName(request.getParameter("Name"));	// 사용자 이름
		dto.setBoard_category(request.getParameter("category"));	// 카테고리
		dto.setBoard_subject(request.getParameter("board_subject"));	// 제목
		dto.setBoard_content(request.getParameter("board_content"));	// 내용
		
		FreeDAO dao = FreeDAO.getInstance();
		int result = dao.insert(dto);
		if(result == 1) {
			System.out.println("글 작성 성공");
		} else {
			System.out.println("글 작성 실패");
		}
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(true);
		forward.setPath("./FreeListAction.seed");
		
		return forward;
	}

}
