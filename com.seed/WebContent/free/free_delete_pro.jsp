<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.FreeDTO"%>
<%@page import="dao.FreeDAO"%>

<%
	request.setCharacterEncoding("utf-8");
%>    

<jsp:useBean id="board" class="model.FreeDTO"/>
<jsp:setProperty property="*" name="board"/>

<%
	int board_num = Integer.parseInt(request.getParameter("board_num"));
	String nowpage = request.getParameter("page");

	FreeDAO dao = FreeDAO.getInstance();

	int result = dao.delete(board_num);
	if(result == 1) {
%>
			<script>
				alert("글 삭제 성공");
				location.href="free_board_list.jsp?page=<%=nowpage%>";
			</script>
<%	}else{	// 문제 시	 %>
		<script>
			alert("글 삭제 실패");
			history.go(-1);
		</script>
<%	} %>
