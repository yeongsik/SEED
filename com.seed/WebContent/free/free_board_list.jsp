<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="model.FreeDTO"%>
<%@page import="dao.FreeDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>


<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


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
  
<%
// 1. 한 화면에 출력할 데이터 갯수
int page_size = 10;
String pageNum = request.getParameter("page");
if (pageNum == null) {
	pageNum = "1"; // 1 page : 최근글이 보이는 페이지
}
// 2. 현재 페이지 번호
int currentPage = Integer.parseInt(pageNum);
int startRow = (currentPage - 1) * page_size + 1; // page: 1 --> startRow=1,  endRow=10
int endRow = currentPage * page_size; // page: 2 --> startRow=11, endRow=20
// 3. 총 데이터 갯수
int count = 0;
FreeDAO dao = FreeDAO.getInstance();
count = dao.getCount();
System.out.println("count:" + count);
List<FreeDTO> list = null;
if (count > 0) {
	list = dao.getList(startRow, endRow);
}
System.out.println("list:" + list);
if (count == 0) {
%>
작성된 글이 없습니다.

<%
} else {
%>
<html>
<head>
<title>Free_Board_List</title>
<link href="./css/free_board_list.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.1.js"></script>
</head>
<header></header>
<body>
	<a href="./FreeWriteForm.seed">글쓰기</a> 글갯수 :
	<%=count%>
	<table class=boardtable border=1 width=700 align=center>
		<div class=boardtitle>
			<h3>게시판 목록</h3>
		</div>
		<ul class=categoryul>
			<li>카테고리 1</li>
			<li>카테고리 2</li>
			<li>카테고리 3</li>
			<li>카테고리 4</li>
			<li>카테고리 5</li>
			</ui>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
				<th>좋아요</th>
				<th>싫어요</th>
			</tr>
			
			<c:forEach var="board" items="${boardlist }">
				<tr>
					<td>${board.board_num}</td>
					<!-- 제목 클릭시 글 상세페이지로 이동. -->
					<td><a href="./FreeDetailAction.seed?&board_num=${board.board_num}&page=${page}">
							${board.board_subject }</a></td>
					<td>${board.name }</td>
				
					<td><fmt:formatDate value="${board.board_register }" pattern="yyyy-MM-dd"/></td>
					<td>${board.board_view }</td>
					<td>${board.board_like }</td>
					<td>${board.board_hate }</td>
				</tr>
			</c:forEach>
		<%-- 	<% int number = count - (currentPage - 1) * page_size;		// number : 각 페이지에 출력될 시작 번호	

			SimpleDateFormat sd = // 1 page :  number = 183 - (1-1) * 10 = 183
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 2 page :  number = 183 - (2-1) * 10 = 173
			for (int i = 0; i < list.size(); i++) {	//foreach로 사용해야함.
				FreeDTO board = list.get(i); %>
			<tr>
				<td><%=board.getBoard_num()%></td>
				<!-- 제목 클릭시 글 상세페이지로 이동. -->
				<td><a href="./FreeDetailAction.seed?&board_num=<%=board.getBoard_num()%>&page=<%=currentPage%>">
						${board.board_subject }</a></td>
				<td><%=board.getName()%></td>
				<td><%=sd.format(board.getBoard_register())%></td>
				<td><%=board.getBoard_view()%></td>
				<td><%=board.getBoard_like()%></td>
				<td><%=board.getBoard_hate()%></td>
			</tr>
			<% } // for end %>
		 --%>
	</table>
	<% } %>
	<center>	<!-- 페이지 링크 설정 -->
		<% if (count > 0) { // pageCount : 총페이지 수
			int pageCount = count / page_size + ((count % page_size == 0) ? 0 : 1);
			System.out.println("pageCount:" + pageCount);
			int startPage = ((currentPage - 1) / 10) * 10 + 1;
			int block = 10; // 1개의 블럭의 크기 : 10개의 페이지로 구성
			int endPage = startPage + block - 1;
			if (endPage > pageCount) { // 가장 마지막 블럭에는 endPage값을 pageCount로 설정
				endPage = pageCount;
			} %>
		<!-- 1페이지로 이동 -->
    
		<a href="./FreeListAction.seed?page=1" style="text-decoration: none"> << </a>

  
		<% if (startPage > 10) { // 이전 블럭으로 이동 %> 
		<a href="./FreeListAction.seed?page=<%=startPage - 10%>">[이전]</a>
		<% } %>
		<% // 각 블럭당 10개의 페이지 출력
		for (int i = startPage; i <= endPage; i++) {
			if (i == currentPage) { // 현재 페이지 %>
		[<%=i%>]
		<% } else { %>
		<a href="./FreeListAction.seed?page=<%=i%>">[<%=i%>]
		</a>
		<% }
		} // for end
			// 다음 블럭으로 이동하는 부분
		if (endPage < pageCount) { %>
  
		<a href="./FreeListAction.seed?page=<%=startPage + 10%>"> [다음] </a>

		<% } %>
		<!-- 마지막 페이지로 이동 -->
		<a href="./FreeListAction.seed?page=<%=pageCount%>" style="text-decoration: none"> >> </a>
		<% } // if end %>
	</center>
</body>
</html>