<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>News 게시판</title>
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
		<input type="text" id="board_subject" , name="board_subject" value="제목을 입력하세요.">
	</td>
</tr>
<tr>
	<td>글내용</td>
	<td>
		<textarea cols="50" rows="20" id="board_content" name="board_content"></textarea>
	</td>
</tr>
<tr>
	<td>
		<input type="submit" value="글작성">
		<input type="reset" value="취소">
	</td>
</table>
</form>
</body>
</html>