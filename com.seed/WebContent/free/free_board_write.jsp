<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="color.jsp"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Seed Free write form</title>
<link href="<%=request.getContextPath()%>/free/css/free_board_write.css" rel="stylesheet" type="text/css">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>

<!-- 		<script src="check.js"></script> -->
<script>
	/* 	$(function(){
			$("form").submit(function(){
				if($("#name").val()==""){
					alert('작성자를 입력하세요.');
					return false;
				}
				if($("#board_category").val()==0){
					alert('카테고리를 선택하세요.');
					return false;
				}
				if($("#board_subject").val()==""){
					alert("제목을 입력하세요");
					$("#board_subject").focus();
					return false;
				}
				if($("#smartEditor").val()==""){
					alert("내용을 입력하세요");
					$("#smartEditor").focus();
					return false;
				}
			});
		}); */
</script>
</head>
<body bgcolor="<%=bodyback_c%>">
	<br>
	<form method="post" name="freewritepro" action="<%=request.getContextPath()%>/FreeAddAction.seed">
		<header></header>
		<nav></nav>

		<section id="writeform">
			<div class="boardwrite">게시물 작성</div>
			<div class="writer">
				작성자<input type="text" id="name" name="name" value="name">

				<div class="category">
					<select id="board_category" name="board_category">
						<option value="0">카테고리</option>
						<option value="HTML">HTML</option>
						<option value="JAVA">JAVA</option>
						<option value="jQuery">jQuery</option>
						<option value="C++">C++</option>
					</select>
				</div>
				<br>

				<div>
					<input type="text" name="board_subject" id="board_subject" size="40" class="board_subject" maxlength="255"
						placeholder="제목을 입력해 주세요."
					>
				</div>
				<br>
				<div>
					<div class="board_content">
						<!--           <textarea id=smartEditor name="board_content" rows="7" title="content">내용을 입력하세요.</textarea> -->
						<textarea id="smartEditor" name="smartEditor" rows="7" style="width: 700px; height: 350px;" title="내용">내용을 입력해주세요</textarea>
					</div>
					<br>
				</div>
				<div id="button">
					<input type="submit" class="submit" value="글쓰기"> &nbsp; <input type="reset" class="reset" value="취소"
						onClick="location.href='<%=request.getContextPath()%>/FreeListAction.seed'"
					>
				</div>
			</div>

		</section>
		<aside></aside>
		<footer></footer>
	</form>
</body>
 <script  src="<%=request.getContextPath() %>/qna/smarteditor.js"></script>
</html>