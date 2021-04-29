<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
    String ctx = request.getContextPath(); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="<%=request.getContextPath()%>/live/script.js"></script>
<script type="text/javascript" src="<%=ctx %>/SE2/js/HuskyEZCreator.js" charset="utf-8"></script>
</head>
<body>
	<table border=1 width=400 align=center>
		<caption>상세 페이지</caption>
		<tr>
			<td>제목 ${board_subject}</td>
		</tr>
		<tr>
			<td>내용 ${board_content}</td>
		</tr>
		<tr>
			<td><textarea id="smarteditor" name="board_content" placeholder=""></textarea></td>
		</tr>
		<tr>
			<td><button id="cmtCnt">댓글달기</button></td>
		</tr>
		<tr>
			<td colspan=2 align=center><input type="button" value="수정"
				onClick="location.href='./LiveModifyAction.seed?board_num=${board.board_num}&page=${page}' ">

				<input type="button" value="삭제"
				onClick="location.href='./LiveDelete.seed?board_num=${board.board_num}&page=${page}' ">

				<input type="button" value="목록"
				onClick="location.href='./LiveListAction.seed?page=${page}' ">

			</td>
		</tr>
	</table>
</body>
</html>
