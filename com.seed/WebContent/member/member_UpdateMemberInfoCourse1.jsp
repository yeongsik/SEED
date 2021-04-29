<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="<%=request.getContextPath() %>/member/UpdateMemberInfoCourse1.js"></script>
</head>
<body>
	<form method="post" action="<%=request.getContextPath()%>/UpdateMemberInfoCourse2.seed">
		<div>
			<div>
				회원정보수정
			</div>
			
			<div>
				<div>
					비밀번호를 입력해주세요
				</div>
				<div>
					<input type="password" id="pw" name="pw">
				</div>					
				<div>
					<input type="submit" value="Confirm" id="confirm_btn">
					<input type="reset" value="Cancel" onClick="history.go(-1);">
				</div>
			</div>
			
		</div>
	</form>
</body>
</html>