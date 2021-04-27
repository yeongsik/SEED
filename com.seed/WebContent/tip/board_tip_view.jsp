<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	<div></div>
	<div></div>
</div>
