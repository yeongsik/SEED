<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="viewport" content="user-scalable=no, initial-scale=1, maximum-scale=1">

<title>사는얘기게시판</title>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="<%=request.getContextPath()%>/liveboard/script.js"></script>

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
	<form action="<%=request.getContextPath()%>/LiveModify.seed" method="post">
	<input type="hidden" name="board_num" value="${board.board_num }"> 
	<input type="hidden" name="page" value="${page }">
	
	<table cellpadding="0" cellspacing="0" align=center border=1>
	<tr align="center" valign="middle">
		<td colspan="6"><select name="board_category">
		<option>일상얘기</option>
		<option>직장얘기</option>
		</select>카테고리 선택 </td>
	</tr>
	<tr>
		<td  height="16">
			<div align="center">글 제목</div>
		</td>
		<td>
			<input name="board_subject" id="board_subject" type="text" size="10" maxlength="10" 
				value=""/>
		</td>
	</tr>
	<tr>
		<td>
			<div align="center">내용</div>
		</td>
		<td>
			<textarea name="board_content" id="board_content" cols="67" rows="15"></textarea>
		</td>
	</tr>
	
	<tr bgcolor="cccccc">
		<td colspan="3" style="height:1px;">
		</td>
	</tr>
	<tr align="center" valign="middle">
		<td colspan="5">			
			<input type=submit value="글 수정">
			<input type=reset value="취소">
		</td>
	</tr>
</table>
</form>
</body>
</html>
