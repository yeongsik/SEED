<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% 
	// 세션 삭제
	session.invalidate();
%>

<script>
	alert("성공적으로 로그아웃 되었습니다.");
	location.href="./qna_board_login.jsp";
</script>