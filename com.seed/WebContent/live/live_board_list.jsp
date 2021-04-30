<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width , initial-scale=1.0">
<meta name="viewport"
	content="user-scalable=no, initial-scale=1, maxium-scale=1">
<title>Seed</title>

<link rel="stylesheet" type="text/css" href="./css/main.css">

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/main.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/board.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/member.css">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Fira+Sans:wght@300&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Cairo:wght@600&display=swap" rel="stylesheet">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="<%=request.getContextPath()%>/js/main.js"></script>
<script src="https://kit.fontawesome.com/78e568182c.js" crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/board.css">

</head>
<body>
	<div class="board-container">
	<%@ include file="/main/main_header.jsp" %>
		<div class="nav-article">
			<div class="nav-title">LIVE 게시판</div>
			<div class="nav-search">
				<input class="nav-input" type="text" placeholder="검색어 입력">

			</div>

			<div class="nav-category-start">
				<ul class="nav-category-ul">
					<li class="nav-category-li-hover nav-category-li">일상얘기</li>
					<li class="nav-category-li nav-category-li-hover">주변얘기</li>
					<li class="nav-category-li nav-category-li-hover">직장얘기</li>
					<li class="nav-category-li-count">작성된 글 개수 : ${listcount}</li>
					<li class="nav-select"><select>
							<option value="최신순" selected>최신순</option>
							<option value="과거순">과거순</option>
					</select></li>
				</ul>

				<ul class="nav-hr">
					<li class="article-board-boardnum">게시물번호</li>
					<li class="article-board-num">카테고리</li>
					<li class="article-board-num">닉네임</li>
					<li class="article-board-num">제목</li>
					<li class="article-board-view">조회수</li>
					<li class="article-board-view">좋아요</li>
					<li class="article-board-view">싫어요</li>
					<li class="article-board-num">날짜</li>
				</ul>
			</div>
		</div>

		<div class="article-board-main">
			<c:set var="num" value="${listcount - (page-1) * 10 }"></c:set>
			<c:forEach var="b" items="${livelist }">

				<div class="article-content-list">
					<div class="article-content-list-a">${b.board_num}</div>
					<div class="article-content-list-b">
						<a
							href="./LiveDetailAction.seed?board_num=${b.board_num }&page=${page}">${b.board_category}</a>
					</div>
					<div class="article-content-list-c">${b.name}</div>
					<div class="article-content-list-d">${b.board_subject}</div>
					<div class="article-content-list-e article-content-viewlikehate">${b.board_view}</div>
					<div class="article-content-list-e article-content-viewlikehate">${b.board_like}</div>
					<div class="article-content-list-e article-content-viewlikehate">${b.board_hate}</div>
					<div class="article-content-list-f">
						<fmt:formatDate value="${b.board_register}"
							pattern="yy-MM-dd HH:mm" />
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="article-write-button">
			<a href="./LiveAddActionForm.seed" class="for-hreftag">글쓰기</a>

		</div>
		<div class="page-cover">

			<c:if test="${listcount > 0 }">
				<a class="page-previous" href="./LiveListAction.seed?page=1"> <
				</a>
				<c:if test="${startPage > 10}">
					<a href="./LiveListAction.seed?page=${startPage - 10}"
						class="page-num"></a>
				</c:if>

				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<c:if test="${i == page }">
						<a class="page-num">${i}</a>
					</c:if>
					<c:if test="${i != page }">
						<a class="page-num" href="./LiveListAction.seed?page=${i}">${i}</a>
					</c:if>

				</c:forEach>
				<c:if test="${endPage < pageCount}">
					<a href="./LiveListAction.seed?page=${startPage + 10}"
						class="page-num"></a>
				</c:if>
				<a class="page-next" href="./LiveListAction.seed?page=${pageCount}">
					> </a>
			</c:if>
		</div>
	</div>
	<aside>
		<div class="aside-container">
			<div class="aside-title">Weekly Best</div>
			<c:forEach var="wb" items="${weeklybest}">
				<table>
					<tr class="aside-hr">
						<td class="aside-list">${wb.board_subject}</td>
					</tr>
				</table>
			</c:forEach>
		</div>
	</aside>

	<footer class="footer"> </footer>
</body>
</html>
