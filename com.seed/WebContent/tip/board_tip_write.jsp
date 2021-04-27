<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>글작성</title>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>

</head>
<body>
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
				<div style="width: 850px;"><textarea id="board_content" name="board_content" cols="50" rows="20"></textarea></div>
			</div>
			<div>
				<input type="submit" id="submit_btn" value="작성">
				<input type="reset" value="취소">
			</div>
		</div>
		<script defer src="<%=request.getContextPath() %>/tip/smarteditor.js"></script>
	</form>
</body>
</html>