<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<title>게시글 삭제</title>
</head>
<body>

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

