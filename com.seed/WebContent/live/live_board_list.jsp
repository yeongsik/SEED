<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="kr">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">


<title>사는얘기게시판</title>

<script src="http://code.jquery.com/jquery-latest.js"></script>

</head>
<body style="">
	<header>
		<div>
			<a href="#" >SEED</a>
		</div>
		<div class="header_Front">
			<ul style="text-decoration: none;">
				<li><a href="#">Home</a></li>
				<li><a href="#">Share</a></li>
				<li><a href="#">Community</a></li>
				<li><a href="#">About</a></li>
			</ul>
		</div>

	</header>
	<div>
	<a href="./live_board_write.jsp"
		style="position:relative; top:63px; left: 100px; text-decoration: none; color: blue;">Write</a>
	</div>	
	<div style="position: relative; left: 1150px;">글 개수 : ${listcount}개</div>
	
	<div 
		style="width: 1250px; height: 500; border: 1px solid; text-align:left;"><h3>사는 얘기</h3>
		<ul style="list-style: none; border:1px solid;">
			<li style="float: left  ">게시물번호</li>
			<li style="float: left">&emsp;카테고리</li>
			<li style="float: left">&emsp;&emsp;&emsp;&emsp;닉네임</li>
			<li style="float: left">&emsp;&emsp;&emsp;&emsp;&nbsp;제목</li>
			<li style="float: left">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;내용</li>
			<li style="float: left">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;등록일</li>
			<li style="float: left">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;조회수</li>
			<li style="float: left">&emsp;&emsp;&emsp;좋아요</li>
			<li style="float: left">&emsp;&emsp;&emsp;싫어요</li>
			<li style="float: left">&emsp;&emsp;Weekly Best</li>
		</ul>
		<br>
		
		<c:set var="num" value="${listcount - (page-1) * 10 }" ></c:set>	
		<c:forEach var="b" items="${livelist }">
			
				<div style="display: inline;">
					<div style="display: inline-block; ">&emsp;&emsp;&emsp;&emsp;${b.board_num}&emsp;&emsp;</div>
					<div style="display: inline-block; ">&emsp;<a href="./live/LiveLogInAction.seed" style="text-decoration: none;">${b.board_category}</a>&emsp;&emsp;</div>
					<div style="display: inline-block">&emsp;${b.name}&emsp;&emsp;</div>
					<div style="display: inline-block">&emsp;${b.board_subject}&emsp;&emsp;</div>
					<div style="display: inline-block">&emsp;&emsp;${b.board_content}&emsp;&emsp;</div>
					<div style="display: inline-block">
						<fmt:formatDate value="${b.board_register}"
							pattern="yyyy-MM-dd HH:mm:ss" />
					</div>
					<div style="display: inline-block">&emsp;&emsp;&emsp;&emsp;${b.board_view}&emsp;&emsp;&emsp;</div>
					<div style="display: inline-block">&emsp;&emsp;${b.board_like}&emsp;&emsp;&emsp;</div>
					<div style="display: inline-block">&emsp;&emsp;${b.board_hate}&emsp;&emsp;&emsp;</div>
					<div style="display: inline-block">&emsp;&emsp;${b.board_hate}${b.board_view}&emsp;&emsp;&emsp;</div>
				</div>
			
		</c:forEach>
	</div>



<!-- 페이지 처리 -->
	<div style="text-decoration: none; position:relative; top: 430px; right: 650px;">
	<c:if test="${listcount > 0 }">
		<a href="./live/LiveListAction.seed?page=1" >
			이전 </a>
		<c:if test="${startPage > 10}">
			<a href="./live/LiveListAction.seed?page=${startPage - 10}"></a>
		</c:if>

		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<c:if test="${i == page }">
		[${i}]
	</c:if>
			<c:if test="${i != page }">
				<a href="./live/LiveListAction.seed?page=${i}">[${i}]</a>

			</c:if>
		</c:forEach>
		<c:if test="${endPage < pageCount}">
			<a href="./live/LiveListAction.seed?page=${startPage + 10}"></a>
		</c:if>
		<a href="./live/LiveListAction.seed?page=${pageCount}"> 다음 </a>
	</c:if>
	</div>

</body>
</html>


