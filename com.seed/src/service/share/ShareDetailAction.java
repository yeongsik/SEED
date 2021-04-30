package service.share;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ShareDAO;
import service.SeedAction;
import service.SeedActionForward;

public class ShareDetailAction implements SeedAction{

	@Override
	public SeedActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ShareDetailAction");
		
		int share_view = Integer.parseInt(request.getParameter("share_view"));
		String page = request.getParameter("page");
		
		ShareDAO dao = ShareDAO.getInstance();
		dao.readcountUpdate(share_view);

		SeedActionForward forward = new SeedActionForward();
		forward.setRedirect(false);
		forward.setPath("${b.share_link}");
		
		return forward;
	}

}
