<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
String ctx = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="<%=request.getContextPath()%>/live/script.js"></script>
<script type="text/javascript" src="<%=ctx%>/SE2/js/HuskyEZCreator.js"
	charset="utf-8"></script>
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
	<form action="<%=request.getContextPath()%>/live/LiveModify.seed"
		method="post">
		<input type="hidden" name="board_num" value="${live.board_name }">
		<input type="hidden" name="page" value="${page }">

		<table border=1 style="width:650px; ">
			<tr align="center" valign="middle">
				<td colspan="6"><select name="board_category">
						<option>일상얘기</option>
						<option>직장얘기</option>
				</select>카테고리 선택</td>
			</tr>
			<tr>
				<td height="16">
					<div align="center">글 제목</div>
				</td>
				<td><input name="board_subject" id="board_subject" type="text"
					size="10" maxlength="10" value="" /></td>
			</tr>
			<tr> 
				<td>
					<div align="center">비밀번호</div>
				</td>
				<td><input name="board_pass" id="board_pass" type="password"
					size="10" maxlength="10" value="" /></td>
			</tr>
			<tr>
				<td>
					<div align="center">내용</div>
				</td>
				<td><textarea name="smartEditor" id="smartEditor" cols="67"
						rows="15" >${live.board_content }</textarea></td>
			</tr>

			<tr bgcolor="cccccc">
				<td colspan="3" style="height: 1px;"></td>
			</tr>
			<tr align="center" valign="middle">
				<td colspan="5"><input type=submit value="글 수정"> <input
					type=reset value="취소"></td>
			</tr>
		</table>
		<script defer src="<%=request.getContextPath()%>../live/smarteditor.js"></script>
	</form>
</body>
</html>