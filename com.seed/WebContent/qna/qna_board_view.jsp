<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<!-- <script src="http://code.jquery.com/jquery-1.6.4.min.js"></script> -->
<script>
	var num = ${board.board_num};
</script>



<script src="<%=request.getContextPath() %>/qna/LikeUpdate.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

<div>
	게시판 : ${board.board_category}
</div>

<hr>

<div>
	작성자 : ${board.name} 					<br>
	작성일 : <fmt:formatDate value="${board.board_register}" pattern="yyyy-MM-dd HH:mm:ss"/> 		<br>
</div>

<hr>

<div>
	<%-- 게시물 번호 : ${board.board_num} 		<br> --%>
	<h2>제목 : ${board.board_subject}</h2> 	<br>
	추천 수 : <div id="like_div">${board.board_like}</div>			<br>
	반대 수 : <div id="hate_div">${board.board_hate}</div>
</div>

<hr>
	
<div>
	${board_content}
</div>

<hr>

<div>
	<i class="far fa-thumbs-up" id="like_btn"></i>
	<i class="far fa-thumbs-down" id="hate_btn"></i>
	<input type="button" value="수정" onClick="location.href='./ModifyFormAction.seed?board_num=${board.board_num}&page=${page}'">
	<input type="button" value="삭제" onClick="location.href='./DeleteAction.seed?board_num=${board.board_num}&page=${page}'">
	<input type="button" value="목록" onClick="location.href='./ListAction.seed?page=${page}'">
</div>