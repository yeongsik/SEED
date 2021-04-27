<%@page import="model.LiveDTO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script type="text/javascript" src="se2/js/HuskyEZCreator.js" charset="utf-8"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>

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


<table border=1 width=400 align=center>
	<caption>상세 페이지</caption>
	<tr>
		<td>제목 ${live.board_subject }</td>
	</tr>
	<tr>
		<td>내용 ${board_content}</td>
	</tr>
	<tr>
		<td>댓글<textarea id="cmtCnt" name="cmtCnt" placeholder="댓글 달아주세욤"></textarea></td>
	</tr>
	<tr>
		<td><button id="cmtCnt">댓글달기</button></td>
	</tr>
	<tr><td colspan=2 align=center>
	
				
				<input type="button" value="수정" 
onClick="location.href='/live/LiveModifyAction.seed?board_num=${board.board_num}&page=${page}' ">
				
				<input type="button" value="목록" 
onClick="location.href='/live/LiveListAction.seed?page=${page}' ">
				
		</td>
	</tr>
</table>
