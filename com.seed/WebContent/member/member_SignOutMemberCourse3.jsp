<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<body>
	<form method="post" action="<%=request.getContextPath()%>/MainAction.seed">
		<div>
			<div>회원탈퇴 성공</div>
			<div>
				그동안 이용해주셔서 감사합니다.
			</div>	
			
			<div>
				<input type="submit" value="Confirm" id="submit_btn" >
			</div>
		</div>
	</form>
</body>
</html>