<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${result == 1 }">
		<script>
			alert("댓글이 삭제 되었습니다.");
			location.href="./DetailAction.seed?board_num="+${board_num}+"&page="+${page};
		</script>
	
	</c:if>
</body>
</html>