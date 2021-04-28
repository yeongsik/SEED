<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<table border=1 align=center width=800>
<tr>
	<td colspan=2>
		${news.board_category}
	</td>
	<td>
		작성자 : ${news.name }
	</td>
</tr>
<tr>
	<td>글제목</td>
	<td>
		${news.board_subject }
	</td>
</tr>
<tr>
	<td>조회수</td>
	<td>${news.board_view }</td>
</tr>
<tr>
	<td>글내용</td>
	<td>
		${board_content }
	</td>
</tr>
<tr>
	<td>
		<c:if test="${sessionScope.name == news.name  }">
		<input type="button" value="수정"
		onClick = "location.href='./NewsModifyAction.seed?board_num=${news.board_num}&page=${page}'">
		<input type="button" value="삭제"
		onClick = "location.href='./NewsDeleteAction.seed?board_num=${news.board_num}&page=${page}'">
		</c:if>
		<input type="button" value="글목록"
		onClick = "location.href='./NewsListAction.seed?page=${page}'">
	</td>
</tr>
</table>
<%-- <form method="post" action="<%=request.getContextPath() %>/NewsReAddAction.seed">
<input type="hidden" name="board_num" value="${news.board_num }">
<input type="hidden" name="page" value="${page}">
<table border=1 align=center width = 800>
	<tr>
		<td colspan=2>
			댓글 수 :  ${relistcount}
		</td>
	</tr>
	<c:forEach var = "re" items="${relist}">
	<tr>
		<td>
			${re.name}
		</td>
		<td>
			${re. }
		</td>
	</tr>
	</c:forEach>
	<c:if test="${sessionScope.id ==null }"> 
	<tr>
		<td colspan=2 align=center>
		<a href="login">로그인</a>을 하셔야 댓글을 작성할 수 있습니다.
		</td>
	</tr>
	</c:if>
	<c:if test="${sessionScope.id !=null }">
	
	<tr>
		<td>
			${sessionScope.name}
			<input type="hidden" name="name" value="${sessionScope.name }">
		</td>
		<td>
			<textarea name="re_content"> 내용을 입력하세요</textarea>
			<input type="submit" value="댓글작성">
		</td>
	</tr>
	</c:if>
</table>
</form>
 --%>

