<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" type="text/css" href="./css/main.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Fira+Sans:wght@300&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Cairo:wght@600&display=swap" rel="stylesheet">

<script src="http://code.jquery.com/jquery-latest.js"></script>    
<script src="<%=request.getContextPath() %>/js/main.js"></script>
<script src="https://kit.fontawesome.com/78e568182c.js" crossorigin="anonymous"></script>
<%@ include file="/main/main_header.jsp" %>

<div style="margin:0 auto;text-align:right;">
	<div style="display: inline-block;margin:0 auto;"><!-- 게시판+페이징 -->
		<div style=" border:1px solid; width:900; height:730 ; textalign:center;margin:0 auto; padding: 20px;">
			<h1 style="text-align: center;">TIP 게시판</h1><hr>
			<br>
			<div style="text-align: left;">글 개수 : ${listcount} 개 </div>
			<br>
			<ul style="list-style-type: none; text-align: center;">
				<li style="float: left;width: 50px">번호</li>
				<li style="float: left;width: 310px;">제목</li>
				<li style="float: left;width: 120px">작성자</li>
				<li style="float: left;width: 100px">날짜</li>
				<li style="float: left;width: 80px">조회수</li>
				<li style="float: left;width: 80px">좋아요</li>
				<li style="float: left;width: 80px">싫어요</li>
			</ul><br><br>
			<c:set var="num" value="${listcount - (page-1) * 10 }"/>
			<c:forEach var="b" items="${boardlist }">
				<div style="text-align: center;">
					<div style="display: inline-block;width: 50px;text-align: left;">${num}	<!-- 후행연산 -- 를 사용할 수없기 때문에 아래 코드를 추가 -->
						<c:set var="num" value="${num-1 }"/>
					</div>
					
		<%-- 			<div style="display: inline-block;width: 80px">${b.board_num}</div> --%>
					<div style="display: inline-block;width: 310px;text-align: left;"><a href="./TipDetailAction.seed?board_num=${b.board_num}&page=${page }" style="text-decoration:none;">${b.board_subject}</a></div>
					<div style="display: inline-block;width: 80px">${b.name}</div>
					<div style="display: inline-block;width: 110px">
						<fmt:formatDate value="${b.board_register}" pattern="MM-dd HH:mm"/>
					</div>
					<div style="display: inline-block;width: 80px">${b.board_view }</div>
					<div style="display: inline-block;width: 80px">${b.board_like }</div>
					<div style="display: inline-block;width: 80px">${b.board_hate }</div>
				</div><br>

			</c:forEach>
			<div style="float: right;">
				<a href="./TipWriteForm.seed" style="">글쓰기</a>
			</div>
		</div><br>
	<!-- 페이징 처리 -->
		<div style="text-align: center;">
			<%-- <c:if test="${listcount >0 }"><!-- ${listcount > 0 } 인식못함? --> --%>
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
			<%-- </c:if> --%>
		</div>
	</div>
	<!-- ----weeklybest------- -->
	<div style="display:inline-block ;vertical-align:top;text-align:center;  border:1px solid; width:580;height:300 ; textalign:center;margin:0 auto; padding: 20px;">
		<h3>Weekly Best</h3>
		<hr>
		<ul style="list-style-type: none; text-align: center;">
			<li style="float: left;width: 265px;">제목</li>
			<li style="float: left;width: 110px">작성자</li>
			<li style="float: left;width: 80px">날짜</li>
			<li style="float: left;width: 80px">조회수</li>
<!-- 			<li style="float: left;width: 80px">좋아요</li>
			<li style="float: left;width: 80px">싫어요</li> -->
		</ul><br><br>
		<c:forEach var="w" items="${weeklybest_tip}">
			<div style="display: inline-block;width: 280px;text-align: left;">
				<a href="./TipDetailAction.seed?board_num=${w.board_num}&page=${page}" style="text-decoration:none;">
					${w.board_subject}
				</a>
			</div>
			<div style="display: inline-block;">
				<div style="display: inline-block;width: 80px">${w.name}</div>
				<div style="display: inline-block;width: 90px"><fmt:formatDate value="${w.board_register}" pattern="MM-dd"/></div>
				<div style="display: inline-block;width: 70px">${w.board_view}</div>
<%-- 				<div style="display: inline-block;width: 70px">${w.board_like}</div>
				<div style="display: inline-block;width: 70px">${w.board_hate}</div> --%>
			</div><br>

		</c:forEach>

	</div>
	
</div>

