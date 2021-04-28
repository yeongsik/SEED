<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>News 게시판</title>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="../smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>
</head>
<body>
<form method="post" action="<%=request.getContextPath() %>/NewsAddAction.seed">

<table border=1 align=center width=800>
<tr>
	<td colspan=2>
		<select id="board_category" name="board_category">
			<option>카테고리 지정해주세요</option>
			<option value="개발동향">개발동향</option>
			<option value="취업뉴스">취업뉴스</option>
		</select>
	</td>
	<td>
		작성자 : ${sessionScope.name}
	</td>
</tr>
<tr>
	<td>글제목</td>
	<td>
		<input type="text" id="board_subject" name="board_subject" value="제목을 입력하세요.">
	</td>
</tr>
<tr>
	<td>글내용</td>
	<td>
		<textarea style="width : 100%; height:500px;" id="board_content" name="board_content">내용을 입력해주세요</textarea>
	</td>
</tr>
<tr>
	<td>
		<input type="submit" id="submit_btn" value="글작성">
		<input type="reset" value="취소">
	</td>
</table>
</form>
</body>
<script type="text/javascript" src ="../news/se.js"></script>
</html>

