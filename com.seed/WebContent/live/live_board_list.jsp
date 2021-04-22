<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="kr">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">


<title>사는얘기게시판</title>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="<%=request.getContextPath()%>/liveboard/script.js"></script>

</head>
<body style="width: 500;">
	<header>
		<div>
			<a href="#">SEED</a>
		</div>
		<div class="header_Front">
			<ul>
				<li><a href="#">Home</a></li>
				<li><a href="#">Share</a></li>
				<li><a href="#">Community</a></li>
				<li><a href="#">About</a></li>
			</ul>
		</div>

	</header>

	<a href="/live_board_write.liveb"
		style="position: relative; left: 0px; text-decoration: none;">글 작성</a>
	<div style="position: relative; left: 950px;">글 개수 :
		${listcount}개</div>
	<div>사는 얘기</div>
	<div
		style="width: 500; height: 500; border: 1px solid; text-align:left;">
		<ul style="list-style: none">
			<li style="float: left">게시물번호</li>
			<li style="float: left">&emsp;카테고리</li>
			<li style="float: left">&emsp;&emsp;&emsp;&emsp;닉네임</li>
			<li style="float: left">&emsp;&emsp;&emsp;&emsp;&nbsp;제목</li>
			<li style="float: left">&emsp;&emsp;&emsp;&emsp;&emsp;내용</li>
			<li style="float: left">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;등록일</li>
			<li style="float: left">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;조회수</li>
			<li style="float: left">&emsp;&emsp;&emsp;좋아요</li>
			<li style="float: left">&emsp;&emsp;&emsp;싫어요</li>
		</ul>
		<br>
		<c:set var="num" value="${listcount - (page-1) * 10 }" ></c:set>	
		<c:forEach var="b" items="${livelist }">
			<div style="border: 1px solid;">
				<div style="list-style: none">
					<div style="display: inline;">&emsp;&emsp;&emsp;&emsp;${b.board_num}&emsp;&emsp;</div>
					<div style="display: inline-block;">&emsp;<a href="/LiveDetailAction.liveb">${b.board_category}</a>&emsp;&emsp;</div>
					<div style="display: inline-block;">&emsp;${b.name}&emsp;&emsp;</div>
					<div style="display: inline-block;">&emsp;${b.board_subject}&emsp;&emsp;</div>
					<div style="display: inline-block;">&emsp;&emsp;${b.board_content}&emsp;&emsp;</div>
					<div style="display: inline-block;">
						<fmt:formatDate value="${b.board_register}"
							pattern="yyyy-MM-dd HH:mm:ss" />
					</div>
					<div style="display: inline-block">&emsp;&emsp;&emsp;&emsp;${b.board_view}&emsp;&emsp;&emsp;</div>
					<div style="display: inline-block;">&emsp;&emsp;${b.board_like}&emsp;&emsp;&emsp;</div>
					<div style="display: inline-block;">&emsp;&emsp;${b.board_hate}&emsp;&emsp;&emsp;</div>
				</div>
			</div>
			<br>
			
		</c:forEach>
	</div>



</body>
</html>
<!-- 페이지 처리 -->
<center>
	<c:if test="${listcount > 0 }">
		<a href="/LiveListAction.liveb?page=1" style="text-decoration: none">
			<< </a>
		<c:if test="${startPage > 10}">
			<a href="/LiveListAction.liveb?page=${startPage - 10}">[이전]</a>
		</c:if>

		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<c:if test="${i == page }">
		[${i}]
	</c:if>
			<c:if test="${i != page }">
				<a href="/LiveListAction.liveb?page=${i}">[${i}]</a>

			</c:if>
		</c:forEach>
		<c:if test="${endPage < pageCount}">
			<a href="/LiveListAction.liveb?page=${startPage + 10}">[다음]</a>
		</c:if>
		<a href="/LiveListAction.liveb?page=${pageCount}"
			style="text-decoration: none"> >> </a>
	</c:if>
</center>



