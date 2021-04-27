<%@ page language="java" contentType="text/html; charset=utf-8"%>

<html>
<head>
	<title>게시판 삭제</title>
</head>
<body>

<form action="<%=request.getContextPath() %>/NewsDelete.seed" method="post">
<input type="hidden" name = "board_num" value="${param.board_num }">
<input type="hidden" name = "page" value="${param.page}">
<input type="hidden" name = "name" value="${sessionScope.name }">
<table cellpadding="0" cellspacing="0" align=center border=1>
	<tr align="center" valign="middle">
		<td colspan="5">게시판 삭제</td>
	</tr>
	<tr align="center" valign="middle">
		<td colspan="5">			
			<input type=submit value="삭제">
			<input type=reset value="취소">
		</td>
	</tr>
</table>
</form>

</body>
</html>