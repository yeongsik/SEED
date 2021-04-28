<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 폼</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<script src="member.js"></script>

</head>
<body>

<form method="post" action="<%=request.getContextPath() %>/SignUpAction.seed"> 
<table border=1 width=500 align=center>
	<caption>회원 가입</caption>
	<tr><td>ID</td>
		<td><input type=text autofocus="autofocus" id="id" name="id">
			<input type=button value="ID중복검사" id="idcheck">
			<div id="myid"></div>
		</td>
	</tr>
	<tr><td>비밀번호</td>
		<td><input type=password id="pw" name="pw"></td>
	</tr>
	<tr><td>닉네임</td>
		<td><input type=text id="name" name="name"></td>
	</tr>
	<tr><td colspan=2 align=center>
			<input type=submit value="회원가입">
			<input type=reset value="취소">
		</td>
	</tr>		
</table>
</form>


</body>
</html>