<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<a href="./BoardWrite.seed">글쓰기</a>	<br>

<h2>전체글보기</h2> <br>
${listcount}개의 글	<br>

<hr>

<c:set var="num" value="${listcount - (page - 1) * 10 }"/>

<c:forEach var="b" items="${boardlist}">
	<div>
		<span>
			${num}
			<c:set var="num" value="${num-1}"/>	
		</span>	&emsp;
		<span>
			<a href="./DetailAction.seed?board_num=${b.board_num}&page=${page}" style="text-decoration:none;">
				${b.board_subject}
			</a>
			&emsp;
		</span>
		<span>${b.name}</span> &emsp;
		<span>
			<fmt:formatDate value="${b.board_register}" pattern="yyyy-MM-dd HH:mm:ss"/>
		</span> &emsp;
		<span>${b.board_view}</span> &emsp;
		<span>${b.board_like}</span> &emsp;
		<span>${b.board_hate}</span> &emsp;
	</div>
</c:forEach>

<hr>

<div>
	<c:if test="${listcount > 0 }">
	
		<a href="./ListAction.seed?page=1" style="text-decoration:none;"> << </a>	
	
		<c:if test="${startPage > 10}">
			<a href="./ListAction.seed?page=${startPage-10}">[이전]</a>
		</c:if>
	
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<c:if test="${i == page}">
				[${i}]
			</c:if>
			<c:if test="${i != page}">
				<a href="./ListAction.seed?page=${i}">[${i}]</a>
			</c:if>
		</c:forEach>
		
		<c:if test="${endPage < pageCount}">
			<a href="./ListAction.seed?page=${startPage+10}">[다음]</a>
		</c:if>
		
		<a href="./ListAction.seed?page=${pageCount}" style="text-decoration:none;"> >> </a>
	</c:if>
</div>
