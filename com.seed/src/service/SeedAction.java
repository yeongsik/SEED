package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface SeedAction {

	public SeedActionForward execute(HttpServletRequest request ,HttpServletResponse response) throws Exception;
	
}
