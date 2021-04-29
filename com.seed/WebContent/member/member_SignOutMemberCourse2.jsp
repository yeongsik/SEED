<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="<%=request.getContextPath() %>/member/SignOutMemberCourse2.js"></script>
<body>
	<form method="post" action="<%=request.getContextPath()%>/SignOutMemberCourse3.seed">
		<div>
			<div>회원 탈퇴</div>
			<div>지금까지의 ${user_name}님의 활동내역입니다.</div>
			<div>
				<ul>
					<li>게시글 : ${CountContent}</li>
					<li>댓글 : ${CountComment}</li>
					<li>Days : ${days}</li>
				</ul>
			</div>
			<div>
				개인정보 관련 문장이 들어갈 공간	<br>
				개인정보 관련 문장이 들어갈 공간	<br>
				개인정보 관련 문장이 들어갈 공간	<br>
			</div>
			<div>
				<input type="checkbox" id="check_agree"> 상기 내용을 확인했으며 회원탈퇴에 동의합니다.
			</div>	
			<div>
				<input type="submit" value="Confirm" id="submit_btn" disabled>
				<input type="reset" value="Cancle" onClick="location.href='./MainAction.seed'">
			</div>
		</div>
	</form>
</body>
</html>