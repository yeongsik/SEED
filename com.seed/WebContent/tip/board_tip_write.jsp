<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/main/main_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>글작성</title>
	<link rel="stylesheet" type="text/css" href="./css/main.css">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Fira+Sans:wght@300&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Cairo:wght@600&display=swap" rel="stylesheet">
	
	<script src="http://code.jquery.com/jquery-latest.js"></script>    
	<script src="<%=request.getContextPath() %>/js/main.js"></script>
	<script src="https://kit.fontawesome.com/78e568182c.js" crossorigin="anonymous"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>

</head>
<body>
	<%@ include file="/main/main_header.jsp" %>
	
	<form  action="<%=request.getContextPath() %>/TipAddAction.seed" method="post" ><!-- enctpye:첨부파일 사용시 추가.  enctype="multipart/form-data"-->
		<div style="width:600px;height: 550px; border: solid 1px;margin:0 auto; padding:20px;">
			<h2 style="text-align: center;">글작성</h2>
			<div>
				<div id="board_category" style="display: inline-block;">카테고리</div>
				<div style="display: inline-block;">
					<select name="board_category">
						<option>Tip1</option>
						<option>Tip2</option>
					</select>
				</div>
			</div>
			<div>
				<div style="display: inline-block;">제목</div>
				<div style="display: inline-block;"><input name="board_subject" id="board_subject" type="text" size="50" maxlength="100" style=" width: 530px;"></div>
			</div>
			<div>
				<div>내용</div>
				<!-- 스마트에디터를 사용할 시 내용이 자동적으로 p태그로 입혀져서 채널소개부분 옆에 붙지 못하고 아랫줄로 이동하게 됨. -->
				<div style="width: 850px;"><textarea id="board_content" name="board_content" cols="50" rows="20" style="height: 150px;"></textarea></div>
			</div><br>
			<div>
				<input type="submit" id="submit_btn" value="작성">
				<input type="reset" value="취소">
			</div>
		</div>
		<script defer src="<%=request.getContextPath() %>/tip/smarteditor.js"></script>
	</form>
</body>
</html>