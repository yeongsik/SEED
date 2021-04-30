<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%
String ctx = request.getContextPath();
%>
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


<script src="<%=request.getContextPath()%>/live/script.js"></script>
<script type="text/javascript"
	src="<%=ctx%>/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>

<title>write form</title>
</head>
<body>
	<%@ include file="/main/main_header.jsp" %>
	
	<form action="<%=request.getContextPath()%>/LiveAddAction.seed"
		method="post" style="width: 650px;">
		<div style="border: 1px solid;">
			<div
				style="align: center; height: 30px; border: 1px solid; display: inline-block;">
				<div>
					<select name="board_category"
						style="height: 31px;">
						<option>카테고리 선택</option>
						<option value="일상얘기">일상얘기</option>
						<option value="주변얘기">직장얘기</option>
						<option value="직장얘기">직장얘기</option>
					</select>
				</div>

			</div>
			<div>
				<div>글 제목</div>
			</div>
			<div style="display: inline-block;">
				<input name="board_subject" id="board_subject" type="text">
			</div>

			<div>
				<div>
					<div>내용</div>

					<div>
						<textarea rows="10" cols="30" id="smartEditor"
							name="board_content" style="width: 643px; height: 350px;"></textarea>
					</div>
				</div>
			</div>
			<div>
				<div>
					<input type=submit value="등록" id="#submit_btn"> <input
						type=reset value="취소">
				</div>
			</div>
		</div>
		<script defer src="<%=request.getContextPath()%>/live/smarteditor.js"></script>
	</form>
</body>
</html>