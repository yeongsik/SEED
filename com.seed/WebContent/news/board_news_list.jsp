<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<a href ="./NewsAddActionForm.news">글쓰기</a><br>
글 갯수 : ${listcount} 개 <br>

<table border=1 width = 700 align = center>
	<caption>News </caption>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>날짜</th>
	</tr>
	<c:set var="num" value="${listcount - (page-1) *20 }"/>	
	<c:forEach var="b" items="${newslist }">
	<tr>
		<td>
			${num}
			<c:set var="num" value="${num-1 }" />
		</td>
		<td>
		<a href="./NewsDetailAction.seed?board_num=${b.board_num }&page=${page}">
			${b.board_subject }
		</a>
		</td>
		<td>
			${b.name }
		</td>
		<td>
			<fmt:formatDate value="${b.board_register }" pattern="yyyy-MM-dd"/>
		</td>
	</tr>
	</c:forEach>
</table>
<center>
<c:if test="${listcount >0 }">
	<a href="./NewsListAction.news?page=1" style="text-decoration :none"><<</a>
	<c:if test="${startPage > 10 }">
	<a href="./NewsListAction.news?page=${startPage-10 }" style="text-decoration :none">[이전]</a>
	</c:if>
<c:forEach var="i" begin="${startPage }" end= "${endPage}">
	<c:if test="${i==page }">
		[${i}]
	</c:if>
	<c:if test="${i != page }">
		<a href="./NewsListAction.news?page=${i}" style="text-decoration:none">[${i}]</a>
	</c:if>
</c:forEach>
	<c:if test="${endPage < pageCount }">
	<a href="./NewsListAction.news?page=${startPage+10}" style="text-decoration :none">[다음]</a>
	</c:if>
	
	<a href="./NewsListAction.news?page=${pageCount } " style="text-decoration :none">>></a>
</c:if>
</center>
<table>
	<tr>
		<th>Weekly Best</th>
	</tr>
	<tr>
		<td></td>
	</tr>
</table>