<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	
	<!-- 외부 자바스크립트 파일 불러오기 -->
	<script src="<%=request.getContextPath() %>/qna/login.js"></script>
	
	</head>
	<body>
		<form method="post" action="<%=request.getContextPath() %>/LoginAction.seed">
			<div class="">
				<div>
					<h2>Log In</h2>
				</div>
				<div>
					E-mail <br>
					<input type=text size=30 id="id" name="id" autofocus="autofocus">	
				</div>
				<div>
					Password <br>
					<input type="password" size=30 id="pw" name="pw">
				</div>
				<div>
					<input type="button" value="회원가입" onClick="location.href='<%=request.getContextPath()%>/MemberFormAction.seed'">
					<input type="submit" value="Login">
					<input type="reset" value="Cancel" onClick="history.go(-1);">
				</div>
			</div>
		</form>
	</body>
	</html>