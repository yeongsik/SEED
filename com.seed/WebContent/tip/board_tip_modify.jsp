<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<title>게시글 수정</title>
</head>
<body>
	<form method="post" action="<%=request.getContextPath()%>/TipModify.seed">
		<input type="hidden" name="board_num" value="${dto.board_num }">
		<input type="hidden" name="page" value="${page}">
		<div style="width: 500px; height: 400px; border: solid 1px;">
			<div>게시글 수정</div>
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
				<div style="display: inline-block;">
					<input name="board_subject" id="board_subject" type="text"
						size="50" maxlength="100" value="${dto.board_subject }">
				</div>
			</div>
			<div>
				<div style="display: inline-block;">내용</div>
				<div style="display: inline-block;">
					<textarea id="board_content" name="board_content" cols="60"
						rows="15">${dto.board_subject }</textarea>
				</div>
			</div>
			<div>
				<input type="submit" value="작성"> <input type="reset"
					value="취소">
			</div>


		</div>
	</form>

</body>
</html>

