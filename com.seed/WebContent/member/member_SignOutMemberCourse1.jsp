<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="<%=request.getContextPath() %>/member/SignOutMemberCourse1.js"></script>
</head>
<body>
	<form method="post" action="<%=request.getContextPath()%>/SignOutMemberCourse2.seed">
		<div>
			<div>회원 탈퇴</div>
			<div>
				<div>비밀번호를 입력해주세요.</div>
				<div>
					<input type="password" id="pw" name="pw">
				</div>	
			</div>
			<div>
				<input type="submit" value="Confirm" id="submit_btn">
				<input type="reset" value="Cancle" onClick="history.go(-1);">
			</div>
		</div>
	</form>
</body>
</html>