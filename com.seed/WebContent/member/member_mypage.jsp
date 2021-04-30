<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
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
	
	<div>
		<div>
			${user_name}님 반갑습니다.
		</div>
		<div>
			My page
		</div>
		
		<div>
			<a href="./UpdateMemberInfoCourse1.seed">회원정보수정</a> <br>
			<a href="./SignOutMemberCourse1.seed">회원탈퇴</a>
		</div>
		
		<div>
			이번주 활동 <br>
			<div>
				<ul>
					<li>게시글 : ${CountContent}</li>
					<li>댓글 : ${CountComment}</li>
				</ul>
			</div>
			
			<div>
				<ul>
					<li>z</li>
					<li>2</li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>