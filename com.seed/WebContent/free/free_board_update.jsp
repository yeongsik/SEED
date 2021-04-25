<%@ page contentType="text/html; charset=utf-8" %>
<%@ include file="color.jsp"%>
<%@page import="model.FreeDTO"%>
<%@page import="dao.FreeDAO"%>

<%
	int board_num = Integer.parseInt(request.getParameter("board_num"));
	int nowpage = Integer.parseInt(request.getParameter("page"));
	
	FreeDAO dao = FreeDAO.getInstance();
	
	FreeDTO board = dao.getDetail(board_num);	// 그 페이지의 상세 정보 구하기
%>

<html>
<head>
	<title>Seed Free update form</title>
	<link href="style.css" rel="stylesheet" type="text/css">
	<script src="http://code.jquery.com/jquery-1.11.1.js"></script>
	<!-- <script src="check.js"></script> -->
</head>   
<body bgcolor="<%=bodyback_c%>">  
<center class="writesub"><b>게시물 수정</b></center>
<br>
<form method="post" name="freeboardwrite" action="free_update_pro.jsp">
<input type="hidden" name="board_num" value="<%=board_num%>">
<input type="hidden" name="page" value="<%=nowpage%>">
<table width="330" border="1" cellspacing="0" cellpadding="0"  bgcolor="<%=bodyback_c%>" align="center">
   <tr class="name" align="center">아이디</tr>
	<tr>
    <td  width="330">
       <input readonly="readonly" type="text" size="10" maxlength="10" id="name" name="name" value="<%=board.getName()%>"></td>
  </tr>
    <tr>
    <td width="330">
	 <select id="board_category" name="board_category">
		<option value="0">카테고리</option>
		<option value="HTML">HTML</option>
		<option value="JAVA">JAVA</option>
		<option value="jQuery">jQuery</option>
		<option value="C++">C++</option>
	 </select>
  </tr>
  <tr>
    <td width="330">    
       <input type="text" size="40" maxlength="50" id="board_subject" name="board_subject" value="<%=board.getBoard_subject()%>"></td>	
  </tr>
  <tr>
    <td width="330" >
     <textarea id="board_content" name="board_content" rows="13" cols="40"><%=board.getBoard_content() %></textarea></td>
  </tr>
<tr>      
 <td colspan=2 align="center"> 
  <input type="submit" class="submit" value="수정">  
  <input type="reset" class="reset" value="재작성">
  <input type="button" class="list" value="목록" OnClick="window.location='free_board_list.jsp'">
</td></tr></table>    
</form>      
</body>
</html>
