<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" type="text/css" href="./css/main.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Fira+Sans:wght@300&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Cairo:wght@600&display=swap" rel="stylesheet">

<script src="http://code.jquery.com/jquery-latest.js"></script>    
<script src="<%=request.getContextPath() %>/js/main.js"></script>
<script src="https://kit.fontawesome.com/78e568182c.js" crossorigin="anonymous"></script>

<%@ include file="/main/main_header.jsp" %>

<div style="width:600px;height: 550px; border: solid 1px;margin:0 auto; padding:20px;">
	<h1>상세 페이지</h1>
	<div>제목</div>
	<div>${dto.board_subject }</div>
	<div>내용</div>
	<div>${board_content }</div>
	
	<div>
		<input type="button" value="수정"
		onClick = "location.href='./TipModifyAction.seed?board_num=${dto.board_num }&page=${page}'">
		<input type="button" value="삭제"
		onClick = "location.href='./TipDeleteAction.seed?board_num=${dto.board_num }&page=${page}'">
		<input type="button" value="목록"
		onClick = "location.href='./TipListAction.seed?&page=${page}'">
	
	</div>
	<form action="<%=request.getContextPath() %>/CommentAddAction.seed" >
		<!-- 댓글목록이 있을 경우 출력 -->
		<c:if test="${requestScope.commentList != null}">
			<div>댓글 : ${listcount} </div><!-- 댓글카운트로 변경할것. -->
			<!-- 댓글 앞에 여백처리 -->
			<c:forEach var="i" begin="0" end="${b.board_re_lev }">
				&nbsp;
			</c:forEach>
			<c:forEach var="comment" items="${requestScope.commentList}">
				<!-- 아이디 , 작성일 -->
				<div>
					${comment.name}
					<span>${comment.re_register}</span>
				</div>
				<!-- 내용 -->
				<div>
					${comment.re_content }
				</div>
				<div>
					<input type="submit" id="submit_btn" value="수정"> 
					<!-- <input type="reset" value="취소"> -->
				</div>
			</c:forEach>
		</c:if>
		<!-- 댓글이 없을 경우 -->
		<c:if test="${requestScope.commentList = null }">
			<div>댓글을 남겨주세요</div>
		
		</c:if>
		<script defer src="<%=request.getContextPath() %>/tip/smarteditor.js"></script>
	</form>
</div>
