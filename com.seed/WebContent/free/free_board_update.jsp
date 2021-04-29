<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
	<link href="./css/free_board_update.css" rel="stylesheet" type="text/css">
	<script src="http://code.jquery.com/jquery-1.11.1.js"></script>
	<!-- <script src="check.js"></script> -->
	<script>
		$(function(){
			$("form").submit(function(){
				if($("#board_category").val()==0){
					alert('카테고리를 선택하세요.');
					return false;
				}
				if($("#board_subject").val()==""){
					alert("제목을 입력하세요");
					$("#board_subject").focus();
					return false;
				}
				if($("#board_content").val()==""){
					alert("내용을 입력하세요");
					$("#board_content").focus();
					return false;
				}
			});
		});
		</script>
</head>   
<body bgcolor="<%=bodyback_c%>">
<form method="post" name="freeboardupdate" action="free_update_pro.jsp">
<input type="hidden" name="board_num" value="<%=board_num%>">
<input type="hidden" name="page" value="<%=nowpage%>">
 <div id="writeform">
  <div class="writeupdate">게시물 수정</div>
   <div class="board_name">작성자 <%-- <%=board.getName()%> --%>
	<div class="category">
	 <select id="board_category" name="board_category">
	  <option value="0">카테고리</option>
	   <option value="HTML">HTML</option>
	   <option value="JAVA">JAVA</option>
	   <option value="jQuery">jQuery</option>
	   <option value="C++">C++</option>
	 </select>
	</div> <br>
   <div>
	<input type="text" name="board_subject" size="40" class="board_subject" maxlength="255" value="<%=board.getBoard_subject()%>">
	   </div> <br>
	   <div>
	   <div class="section_body_content">
          <textarea id=smartEditor name="board_content" rows="7" title="content"><%=board.getBoard_content() %></textarea>
        </div> <br>
	   </div>
	   <div id="button">
	   	<input type="submit" class="submit" value="수정"> &nbsp;
		<input type="reset" class="reset" value="취소">
	   </div>
	  </div>
	  </div>
	 </form>
	</body>
  <script  src="<%=request.getContextPath() %>/free/smarteditor.js"></script>
</html>
