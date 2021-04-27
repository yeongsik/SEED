<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
    String ctx = request.getContextPath(); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="<%=request.getContextPath()%>/live/script.js"></script>
<script type="text/javascript" src="<%=ctx %>/SE2/js/HuskyEZCreator.js" charset="utf-8"></script>

<title>사는얘기 게시판</title>
</head>
<body>
	<header>
		<div>
			<a href="#">SEED</a>
		</div>
		<div class="header_Front" style=" list-style: none;">
			<ul>
				<li><a href="#">Home</a></li>
				<li><a href="#">Share</a></li>
				<li><a href="#">Community</a></li>
				<li><a href="#">About</a></li>
			</ul>
		</div>
	</header>
	<form action="<%=request.getContextPath()%>/LiveListAction.seed" method="post" id="live_write_form" style="width:650px;">
		<div style="border: 1px solid;">
			<div style="align: center; width: 497px; height: 30px; border: 1px solid; display: inline-block;">
				<div>
					<select name="board_category" style="height:31px;">
						<option>일상얘기</option>
						<option>직장얘기</option>
					</select>카테고리 선택
				</div>

			</div>
			<div>
				<div>글 제목</div>
			</div>
			<div style="display: inline-block;">
				<input  name="board_subject" id="board_subject" type="text">
			</div>

			<div>
				<div>
					<div>내용</div>
				</div>
				<div>
					<textarea rows="10" cols="30" id="smartEditor" name="smartEditor" style="width:643px; height:350px; "></textarea>
				</div>
			</div>
			<div>
				<div>
					<input type=submit value="등록" id="#submit_btn"> <input type=reset value="취소">
				</div>
			</div>
		</div>
		<script defer src="<%=request.getContextPath() %>../live/smarteditor.js"></script>
	</form>
</body>
</html>