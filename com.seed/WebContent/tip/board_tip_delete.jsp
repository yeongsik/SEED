<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/main/main_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/main.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Fira+Sans:wght@300&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Cairo:wght@600&display=swap" rel="stylesheet">

<script src="http://code.jquery.com/jquery-latest.js"></script>    
<script src="<%=request.getContextPath() %>/js/main.js"></script>
<script src="https://kit.fontawesome.com/78e568182c.js" crossorigin="anonymous"></script>
<title>게시글 삭제</title>
</head>
<body>
	<%@ include file="/main/main_header.jsp" %>
	
	<form method="post" action="<%=request.getContextPath()%>/TipDelete.seed">
		<input type="hidden" name="board_num" value="${param.board_num }">
		<input type="hidden" name="page" value="${param.page}">
		<div style="width: 500px; height: 400px; border: solid 1px;">
			<div>게시글 삭제</div>
<!-- 			<div>
				<div style="display: inline-block;">비밀번호</div>
				<div style="display: inline-block;">
					<input name="pw" id="pw" type="password"
						size="20" maxlength="20" value="">
				</div>
			</div> -->
			<div>
				<input type="submit" value="삭제"> <input type="reset"
					value="취소">
			</div>


		</div>
	</form>

</body>
</html>

