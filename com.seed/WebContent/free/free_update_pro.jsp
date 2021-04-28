<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.FreeDAO"%>
<%@page import="model.FreeDTO"%>

<%
	request.setCharacterEncoding("utf-8");
%>    

<jsp:useBean id="board" class="model.FreeDTO"/>
<jsp:setProperty property="*" name="board"/>

<%
	String nowpage = request.getParameter("page");

	FreeDAO dao = FreeDAO.getInstance();
	FreeDTO dto = dao.getDetail(board.getBoard_num());
		
	int result = dao.update(board);		// 글 수정
	if(result == 1){
%>
		<script>
			alert("글 수정 성공");
			location.href="free_board_content.jsp?board_num=<%=board.getBoard_num()%>&page=<%=nowpage%>";
		</script>
<%	} else {	// 작성 된 글이 없을 시	 %>
		<script>
			alert("글 수정 실패");
			history.go(-1);
		</script>
<%	} %>