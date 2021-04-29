package service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QnADAO;
import service.SeedAction;
import service.SeedActionForward;

public class MyPageForm implements SeedAction {

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MyPageForm");
		
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("id");
		String user_name = (String) session.getAttribute("user_name");
		
		System.out.println("id : " + id);
		System.out.println("user_name : " + user_name);
		
		QnADAO dao = QnADAO.getInstance();
		
		int CountContent = 0;
		
		CountContent = CountContent + dao.getCountContentFromQA(user_name);
		CountContent = CountContent + dao.getCountContentFromFree(user_name);
		CountContent = CountContent + dao.getCountContentFromLive(user_name);
		CountContent = CountContent + dao.getCountContentFromNews(user_name);
		CountContent = CountContent + dao.getCountContentFromTip(user_name);

		int CountComment = 0;
		
		CountComment = CountComment + dao.getCountCommentFromQA(user_name);
		CountComment = CountComment + dao.getCountCommentFromFree(user_name);
		CountComment = CountComment + dao.getCountCommentFromLive(user_name);
		CountComment = CountComment + dao.getCountCommentFromNews(user_name);
		CountComment = CountComment + dao.getCountCommentFromTip(user_name);
		
		if(CountContent != 0 && CountComment != 0) {
			System.out.println("CountContent & CountComment 공유 성공");
			session.setAttribute("CountContent", CountContent);
			session.setAttribute("CountComment", CountComment);
		} else {
			System.out.println("CountContent 공유 실패");
		}
		
		
		
		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false);
		forward.setPath("/MyPageAction.seed");
		
		return forward;
	}

}
