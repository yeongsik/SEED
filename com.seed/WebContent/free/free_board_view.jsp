<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="color.jsp"%>
<%@page import="model.FreeDTO"%>
<%@page import="dao.FreeDAO"%>

<%
	int board_num = Integer.parseInt(request.getParameter("board_num"));
	String nowpage = request.getParameter("page");
	
	FreeDAO dao = FreeDAO.getInstance();
	
	String listClickFlag = request.getParameter("listClickFlag");
	if("Y".equals(listClickFlag)){	//조회수 update.
		dao.viewUpdate(board_num);
	}
	
	FreeDTO board = dao.getDetail(board_num);		// 본문
	
	SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
// 	String content = board.getBoard_content().replace("\n", "<br>");
%>

<html>
<head>
	<title>Seed Free view</title>
	<link href="style.css" rel="stylesheet" type="text/css">
	<link href="./css/free_board_view.css" rel="stylesheet" type="text/css">
	<script src="http://code.jquery.com/jquery-1.11.1.js"></script>
	<!-- <script src="check.js"></script> -->
</head>   
<body bgcolor="<%=bodyback_c%>">
<form method="post" name="freeboardupdate" action="free_board_update.jsp">
<input type="hidden" name="board_num" value="<%=board_num%>">
<input type="hidden" name="page" value="<%=nowpage%>">
 <div id="writeform">
  <div class="writeview"></div>
   <div class="board_name"> <%-- <%=board.getName()%> --%>
	<div class="category"><%=board.getBoard_subject()%></div> <br>
   <div>
	<input type="text" readonly="readonly" name="board_subject" size="40" class="board_subject" maxlength="255" value="<%=board.getBoard_subject()%>">
	   </div> <br>
	   <div>
	   <div class="board_content">
          <textarea id=smartEditor name="smartEditor" rows="7" title="content"><%=board.getBoard_content()%></textarea>
        </div> <br>
	   </div>
	   <div id="button">
	   	<input type="submit" class="submit" value="수정하기"> &nbsp;
		<input type="button" class="list" value="목록" OnClick="window.location='free_board_list.jsp'">
	   </div>
	  </div>
	  </div>
	 </form>
	</body>
  <script  src="<%=request.getContextPath() %>/free/smarteditor.js"></script>
</html>
