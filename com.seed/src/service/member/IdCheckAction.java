package service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QnADAO;
import service.SeedAction;
import service.SeedActionForward;

public class IdCheckAction implements SeedAction{

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("IdCheck");
		
		
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		System.out.println("id : " + id);
		
		QnADAO dao = QnADAO.getInstance();
		int result = dao.idCheck(id);
		
		System.out.println("result : " + result);	// 1 : 중복 ID, -1 : 사용 가능
		
		out.println(result);	// 브라우저에 출력되는 값이 callback 함수로 return

		return null;
	}

}
