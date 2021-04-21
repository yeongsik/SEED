<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<a href="./BoardForm.seed">글쓰기</a> <br>
글 개수 : ${listcount} 개 <br>
<div>
	<div style="border:1px solid; width:800;height:650 ; textalign:center; margin:0 auto;">
		<h1 style="text-align: center;">게시판 목록</h1><hr>
		<ul style="list-style-type: none;">
			<li style="float: left;">번호&emsp;</li>
			<li style="float: left;">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;제목&emsp;&emsp;&emsp;&emsp;&emsp;</li>
			<li style="float: left;">&emsp;&emsp;작성자&emsp;&emsp;</li>
			<li style="float: left;">&emsp;&emsp;날짜&emsp;&emsp;&emsp;</li>
			<li style="float: left;">&emsp;조회수&emsp;</li>
			<li style="float: left;">&emsp;좋아요&emsp;</li>
			<li style="float: left;">&emsp;싫어요&emsp;</li>
		</ul><br><br>
		<c:set var="num" value="${listcount = (page-1) * 10 }"/>
		<c:forEach var="b" items="${boardlist }">
		<div>
<%-- 			<div>${num}	<!-- 후행연산 -- 를 사용할 수없기 때문에 아래 코드를 추가 -->
				<c:set var="num" value="${num-1 }"/>
			</div> --%>
			<div style="display: inline-block;">&emsp;&emsp;${b.board_num}&emsp;&emsp;</div>
			<div style="display: inline-block;">&emsp;&emsp;&emsp;${b.board_subject}&emsp;&emsp;&emsp;</div>
			<div style="display: inline-block;">&emsp;&emsp;${b.name}&emsp;&emsp;</div>
			<div style="display: inline-block;">
				<fmt:formatDate value="${b.board_register}" pattern="MM-dd HH:mm"/>
			</div>
			<div style="display: inline-block;">&emsp;&emsp;&emsp;${b.board_view }&emsp;&emsp;</div>
			<div style="display: inline-block;">&emsp;&emsp;${b.board_like }&emsp;&emsp;</div>
			<div style="display: inline-block;">&emsp;&emsp;${b.board_hate }&emsp;&emsp;</div>
		</div><br>
		</c:forEach>
	
	</div><br><br>

<!-- 페이징 처리 -->
	<div style="margin:0 auto;">
		<c:if test="${listcount >0 }"><!-- ${listcount > 0 } 인식못함? -->			
			<!-- 1페이지로 이동 -->	
			<a href="./TipListAction.seed?page=1" style="text-decoration: none;"> << </a>			
			<!-- 이전 블럭으로 이동 -->
			<c:if test="${startPage > 10 }">
				<a href="./TipListAction.seed?page=${startPage - 10}">[이전]</a>
			</c:if>			
			<!-- 10개의 페이지 출력 -->		
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<c:if test="${i == page }">	<!-- 현재 페이지, 링크 x -->
					[${i}]
				</c:if>
				<c:if test="${i != page }"> <!-- 현재페이지 아닐경우 링크 추가-->
					<a href="./TipListAction.seed?page=${i}">[${i}]</a>
				</c:if>
			</c:forEach>
			<!-- 다음 블럭으로 이동 -->
			<c:if test="${endPage < pageCount}">
				<a href="./TipListAction.seed?page=${startPage + 10}" style="text-decoration:none">[다음]</a>
			</c:if>
			<!-- 마지막 페이지로 이동 -->
			<a href="./TipListAction.seed?page=${pageCount}" style="text-decoration:none"> >> </a>
		</c:if>
	</div>
</div>

