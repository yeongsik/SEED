<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
  <meta charset="UTF-8">
  <title>상세 페이지</title>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<!-- <script src="http://code.jquery.com/jquery-1.6.4.min.js"></script> -->
	<script>
		var num = ${board.board_num};
	</script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>
	<script src="<%=request.getContextPath() %>/qna/LikeUpdate.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
	<link rel="stylesheet" href="qna/view.css">
</head>

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

	
	<div class="comment_wrapper">
			<div class="comment_header">댓글</div>
			<div>
				<c:forEach var="user" items="${user_comment}">
					<ul>
						<li>댓글 작성자 :	${user.re_name}</li>
						<li>댓글 내용 : ${user.re_content}</li>
						<c:if test="${user.re_name == board.name}">
								<input type="button" value="수정" onClick="location.href='./CommentModifyAction.seed?board_num=${user.board_num}&re_num=${user.re_num}&page=${page}'">
								<input type="button" value="삭제" onClick="location.href='./CommentDeleteAction.seed?board_num=${user.board_num}&re_num=${user.re_num}&page=${page}'">
						</c:if>
					</ul>
						<hr>
				</c:forEach>
			</div>
		
		<form method="post" action="<%=request.getContextPath()%>/CommentAddAction.seed">
			<input type="hidden" id="board_num" name="board_num" value="${board.board_num}">
			<input type="hidden" id="page" name="page" value="${page}">
				<div>
					작성자 : ${board.name}
				</div>
				<div>
					<textarea id="smartEditor" name="smartEditor" rows="1" style="width:500px; height:100px;" placeholder="댓글 쓰기"></textarea>
				</div>
				<div class="">
					<input type="submit" id="submit_btn" value="작성">
				</div>
			<script defer src="<%=request.getContextPath() %>/qna/smarteditor_ver_view.js"></script>
		</form>
	</div>

