<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
  <meta charset="UTF-8">
  <title>상세 페이지</title>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<!-- <script src="http://code.jquery.com/jquery-1.6.4.min.js"></script> -->
	<script>
		var num = ${board.board_num};
	</script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>
	<script src="<%=request.getContextPath() %>/qna/UpdateLike.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
	<link rel="stylesheet" href="qna/view.css">
	<script>
		$(function(){
			$(".update_btn").live("click", function(){
				var id = $(this).attr('id');
				var text = $('#comment_content_'+id).text();
				$('#li_comment_'+id).html("댓글 수정 : " + "<br>" + "<textarea rows='3' cols='30' id='tt_"+id+"'>" + text + "</textarea>");
				$('#btn_'+id).html(
						"<form method='post' action='/com.seed.www/CommentModifyAction.seed' id='comment_frm'>" +
							"<input type='hidden' id='re_num' name='re_num' value='"+id+"'>" +
							"<input type='hidden' id='comment_content' name='comment_content' value='"+$('#tt_'+id).val()+"'>" +
							"<input type='hidden' id='board_num' name='board_num' value='${board.board_num}'>" + 
							"<input type='hidden' id='page' name='page' value='${page}'>" + 
							"<li class='li_style'>" +
								"<input type='submit' value='확인' onClick='up("+id+")'>" + 
								"<input type='button' value='취소' onClick='location.href=\'history.go(-1);\''>" +
							"</li>" +
						"</form>"
				);
				
			});
		});
		
		function up(id) {
			var formData = $('#comment_frm').serialize();
			
			$.post('/com.seed.www/CommentModifyAction.seed', formData, function(){
				$('tt_'+id).html(data);
			});
		}
	</script>
</head>

<div>
	게시판 : ${board.board_category}
</div>

<hr>

<div>
	작성자 : ${board.name} 					<br>
	작성일 : <fmt:formatDate value="${board.board_register}" pattern="yyyy-MM-dd HH:mm:ss"/> 		<br>
</div>

<hr>

<div>
	<h2>제목 : ${board.board_subject}</h2> 	<br>
	추천 수 : <div id="like_div">${board.board_like}</div>			<br>
	반대 수 : <div id="hate_div">${board.board_hate}</div>
</div>

<hr>
	
<div>
	${board_content}
</div>

<hr>

<div>
	<i class="far fa-thumbs-up" id="like_btn"></i>
	<i class="far fa-thumbs-down" id="hate_btn"></i>
	<input type="button" value="수정" onClick="location.href='./ModifyFormAction.seed?board_num=${board.board_num}&page=${page}'">
	<input type="button" value="삭제" onClick="location.href='./DeleteAction.seed?board_num=${board.board_num}&page=${page}'">
	<input type="button" value="목록" onClick="location.href='./ListAction.seed?page=${page}'">
</div>

	<div class="comment_wrapper">
			<div class="comment_header">댓글</div>
			<c:forEach var="user" items="${user_comment}">
				<div id="comment_${user.re_num}">
					<ul>
						<li class="li_style">
							댓글 작성자 : 
							<span id="user_name">${user.re_name}</span>
						</li>
						<li class="li_style" id="li_comment_${user.re_num}">
							댓글 내용 : 
							<span id="comment_content_${user.re_num}">${user.re_content}</span>
						</li>
						<li class="li_style" id="btn_${user.re_num}">
							<c:if test="${user.re_name == board.name}">
									<%-- <input type="button" value="수정" onClick="location.href='./CommentModifyFormAction.seed?board_num=${user.board_num}&re_num=${user.re_num}&page=${page}'"> --%>
									<input type="button" value="수정" class="update_btn" id="${user.re_num}">
									<input type="button" value="삭제" onClick="location.href='./CommentDeleteAction.seed?board_num=${user.board_num}&re_num=${user.re_num}&page=${page}'">
							</c:if>
						</li>	
					</ul>
						<hr>
				</div>
			</c:forEach>
		<c:if test="${board.name != null}">	
			<form method="post" action="<%=request.getContextPath()%>/CommentAddAction.seed">
				<input type="hidden" id="board_num" name="board_num" value="${board.board_num}">
				<input type="hidden" id="page" name="page" value="${page}">
					<div>
						작성자 : ${board.name}
					</div>
					<div>
						<textarea id="smartEditor" name="smartEditor" rows="1" style="width:500px; height:100px;" placeholder="댓글 쓰기"></textarea>
					</div>
					<div class="">
						<input type="submit" id="submit_btn" value="작성">
					</div>
				<script defer src="<%=request.getContextPath() %>/qna/smarteditor_ver_view.js"></script>
			</form>
		</c:if>
	</div>

