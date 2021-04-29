<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>

<script src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
</head>
<body>
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