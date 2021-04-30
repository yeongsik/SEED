<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="color.jsp"%>
<%@ include file="/main/main_header.jsp" %>

<!DOCTYPE html>
<html lang="ko">
	<head>
	<meta charset="UTF-8">
		<title>Seed Free write form</title>
		<link href="./css/free_board_modify.css" rel="stylesheet" type="text/css">
		<script src="http://code.jquery.com/jquery-latest.js"></script>
		z<script type="text/javascript" src="<%=request.getContextPath()%>/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>
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
<body bgcolor="<%=bodyback_c%>">	<br>
<input type="hidden" name="board_num" value="${board.board_num}">
<input type="hidden" name="page" value="${page}">
	 <form method="post" name="freewritepro" action="free_write_pro.jsp">		
	 <div id="writeform">
	  <div class="boardmodifywrite">게시물 수정</div>
	   <div class="board_name" type="readonly" value="${board.board_name}"><h4><b>작성자</b></h4>
	   <div>
	   	<select id="board_category" name="board_category">
		    <option value="0">카테고리</option>
		    <option value="HTML">HTML</option>
		    <option value="JAVA">JAVA</option>
		    <option value="jQuery">jQuery</option>
		    <option value="C++">C++</option>
		</select>
	   </div> <br>
	   <div>
	    <input type="text" name="board_subject" size="40" class="board_subject" maxlength="255" placeholder="제목을 입력해 주세요.">${board.board_subject}
	   </div> <br>
	   <div>
	     <textarea class="board_content" name="board_content" rows="13" cols="40">${board.board_content}</textarea>
	   </div> <br>
	   </div>
	   <div id="button">
	   	<input type="submit" class="submit" value="글수정"> &nbsp;
		<input type="reset" class="reset" value="되돌리기">
	   </div>
	  </div>
	 </form>
	</body>

