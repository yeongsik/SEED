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
	<div>
		<div>
			회원가입
		</div>
		
		<div>
			E-mail <br>
			<input type=text autofocus="autofocus" id="id" name="id">
			<input type=button value="ID중복검사" id="idcheck"> <span id="myid"></span>
			<!-- <div id="myid"></div> -->
		</div>
		
		<div>
			닉네임 <br>
			<input type=text id="name" name="name">
		</div>
		
		<div>
			비밀번호 <br>
			<input type=password id="pw" name="pw">			
		</div>
		
		<div>
			비밀번호 확인 <br>
			<input type=password id="checkPw" name="checkPw">
		</div>		
		
		
		<div>
			<input type=submit value="회원가입">
			<input type=reset value="취소">
		</div>
	</div>
</form>

</body>
</html>