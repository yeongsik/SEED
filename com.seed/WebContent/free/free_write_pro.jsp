<%@page import="dao.FreeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.FreeDTO"%>

<%  // 한글값이 post방식으로 전송될때 utf-8로 인코딩을 시켜주는 역할
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="board" class="model.FreeDTO"/> 
<jsp:setProperty property="*" name="board"/>   

<%	
	FreeDAO dao = FreeDAO.getInstance();
	int result = dao.insert(board);
	
	if(result == 1){
%>
		<script>
			alert("글 작성 성공");
			location.href="free_board_list.jsp";
		</script>

<%	}else{ %>
		<script>
			alert("글 작성 실패");
			history.go(-1);
		</script>
<%	} %>

