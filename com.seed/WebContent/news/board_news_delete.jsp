<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<html>
<head>
	<title>게시판 삭제</title>
<link rel="stylesheet" type="text/css" href="./css/main.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Fira+Sans:wght@300&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Cairo:wght@600&display=swap" rel="stylesheet">

<script src="http://code.jquery.com/jquery-latest.js"></script>    
<script src="<%=request.getContextPath() %>/js/main.js"></script>
<script src="https://kit.fontawesome.com/78e568182c.js" crossorigin="anonymous"></script>
</head>
<body>

<%@ include file="/main/main_header.jsp" %>

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
 <%@ include file="/main/main_footer.jsp"%>
</body>
</html>