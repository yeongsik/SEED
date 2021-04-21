<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!-- 세션이 있는 경우 -->
<c:if test="${sessionScope.id != null }">
	${sessionScope.name}님 환영 합니다. <br><br>
	<a href="<%=request.getContextPath()%>/NewsAddActionForm.seed">글쓰기</a><br><br>
	<a href="<%=request.getContextPath()%>/NewsListAction.seed">글목록</a><br><br>
	<a href="./UpdateMember.do">회원정보 수정</a> <br><br>
	<a href="./Logout.do">로그아웃</a> <br><br>
	<a href="./DeleteMember.do">회원탈퇴</a> <br><br>
</c:if>
<!-- 세션이 없는 경우-->
<c:if test="${sessionScope.id == null }">
	<a href="<%=request.getContextPath()%>/NewsListAction.seed">글목록</a>
	<a href="<%=request.getContextPath()%>/MemberForm.seed">회원가입</a> <br> <br>
	<a href="<%=request.getContextPath()%>/MemberLogInForm.seed">로그인</a>	<br><br>
</c:if>
