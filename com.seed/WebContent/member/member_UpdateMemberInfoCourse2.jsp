<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="<%=request.getContextPath() %>/member/UpdateMemberInfoCourse2.js"></script>
</head>
<body>
	<form method="post" action="<%=request.getContextPath()%>/UpdateMemberInfoCourse3.seed">
		<div>
			<div>
				회원정보수정
			</div>
			<div>
				<div>아이디</div>
				<input type="text" id="id" name="id" value="${memberIdPw.id}" readonly>
			</div>
			<div>
				<div>닉네임</div>
				<input type="text" id="name" name="name" value="${user_name}">
				<input type="button" id="checkName" value="중복확인">
				<span id="display_CheckNameResult"></span>
			</div>
			<div>
				<div>비밀번호</div>
				<input type="password" id="pw" name="pw">
			</div>
			<div>
				<div>비밀번호 확인</div>
				<input type="password" id="checkPw" name="checkPw">
			</div>
			<div>
				<input type="submit" value="Update" id="update_btn">
				<input type="reset" value="Cancel" onClick="location.href='./MyPageAction.seed'">
			</div>
		</div>
	</form>
</body>
</html>