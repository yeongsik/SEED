<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>사는얘기게시판</title>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="<%=request.getContextPath()%>/liveboard/script.js"></script>

</head>
<body style="width:500px;">
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
	<form action="<%=request.getContextPath()%>/LiveAddAction.seed"
		method="post">
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
					<textarea name="board_content" id="board_content" cols="67"
						rows="15"></textarea>
				</div>
			</div>

			<div>
				<div></div>
			</div>
			<div>
				<div>
					<input type=submit value="등록" name="/live_board_list.seed"> <input type=reset value="취소">
				</div>
			</div>
		</div>
	</form>
</body>
</html>
