package service.free;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		String path = request.getRealPath("boardupload");
		System.out.println("path:"+path);
		
		int size = 1024 * 1024;		// 1MB
		
		//									업로드	 디렉토리, 파일크기(1MB),	한글,		중복파일 문제해결
		MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
		
		FreeDTO dto = new FreeDTO();
		dto.setName(multi.getParameter("Name"));	// 사용자 이름
		dto.setBoard_category(multi.getParameter("category"));	// 카테고리
		dto.setBoard_subject(multi.getParameter("board_subject"));	// 제목
		dto.setBoard_content(multi.getParameter("board_content"));	// 내용
//		dto.setBoard_num(multi.getParameter("num"));
		
		FreeDAO dao = FreeDAO.getInstance();
		int result = dao.insert(dto);
		if(result == 1) {
			System.out.println("글 작성 성공");
		}
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(true);
		forward.setPath("./FreeListAction.do");
		
		return forward;
	}

}
