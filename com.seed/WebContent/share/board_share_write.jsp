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
	<form  action="<%=request.getContextPath() %>/ShareAddAction.seed" method="post" ><!-- enctpye:첨부파일 사용시 추가.  enctype="multipart/form-data"-->
		<div style="width:600px;height: 650px; border: solid 1px;margin:0 auto; padding:20px;">
			<h2 style="text-align: center;">글작성</h2>
			<div>
				<div id="share_site" style="display: inline-block;">사이트명</div>
				<div style="display: inline-block;"><input name="share_site" id="share_site" type="text" size="50" maxlength="100" style=" width: 530px;"></div>
			</div>
			<div>
				<div>사이트 설명</div>
				<div style="width: 600px;"><textarea id="share_des" name="share_des" cols="50" rows="20"></textarea></div>
			</div>
			
			<div>
				<div>사이트 링크</div>
				<div><input type="url" id="share_link" name="share_link" style=" width: 530px;"></div>
			</div>
			<div>
				<input type="submit" id="submit_btn" value="작성">
				<input type="reset" value="취소">
			</div>
		</div>
		<script defer src="<%=request.getContextPath() %>/share/smarteditor.js22"></script><!-- 임시중지 -->
	</form>
</body>
</html>