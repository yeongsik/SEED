package service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QnADAO;
import service.SeedAction;
import service.SeedActionForward;

public class NameCheckAction implements SeedAction{

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NameCheck");
		
		
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		System.out.println("name : " + name);
		
		QnADAO dao = QnADAO.getInstance();
		int result = dao.nameCheck(name);
		
		System.out.println("result : " + result);	// 1 : 중복 ID, -1 : 사용 가능
		
		out.println(result);	// 브라우저에 출력되는 값이 callback 함수로 return

		return null;
	}

}
