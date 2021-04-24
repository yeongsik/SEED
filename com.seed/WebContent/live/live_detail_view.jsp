<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="kr">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">

<script type="text/javascript" src="se2/js/HuskyEZCreator.js" charset="utf-8"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
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
<table border=1 width=400 align=center>
	<caption>상세 페이지</caption>
	<tr><td>제목</td>
		<td>${live.board_subject }</td>
	</tr>
	<tr><td>내용</td>
		<td>
			${board_content}
		</td>	
	</tr>
	<tr><td>댓글</td>
		<td>
			
		</td>
	</tr>
	<tr><td colspan=2 align=center>
	
				
				<input type="button" value="수정" 
onClick="location.href='/live/LiveModifyAction.seed?board_num=${board.board_num}&page=${page}' ">
				
				<input type="button" value="목록" 
onClick="location.href='/live/LiveListAction.seed?page=${page}' ">
				
		</td>
	</tr>
</table>
</body>	
</html>