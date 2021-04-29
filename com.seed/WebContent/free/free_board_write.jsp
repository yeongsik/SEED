<%@ page contentType="text/html; charset=utf-8" %>
<%@ include file="color.jsp"%>

<html>
	<head>
		<title>Seed Free write form</title>
		<link href="./css/free_board_write.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.1.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>
		<!-- SmartEditor를 사용하기 위해서 다음 js파일을 추가 (경로 확인) -->
		<%-- <script type="text/javascript" src="<%=ctx %>/SE2/js/HuskyEZCreator.js" charset="utf-8"></script> --%>
<!-- 		<script src="check.js"></script> -->
		<script>
		$(function(){
			$("form").submit(function(){
				if($("#name").val()==""){
					alert('작성자를 입력하세요.');
					return false;
				}
				if($("#board_category").val()==0){
					alert('카테고리를 선택하세요.');
					return false;
				}
				if($("#board_subject").val()==""){
					alert("제목을 입력하세요");
					$("#board_subject").focus();
					return false;
				}
				if($("#smartEditor").val()==""){
					alert("내용을 입력하세요");
					$("#smartEditor").focus();
					return false;
				}
			});
		});
		</script>
	</head>   
	<body bgcolor="<%=bodyback_c%>">  
		<br>
	 <form method="post" name="freewritepro" action="free_write_pro.jsp">
	 <div id="writeform">
	  <div class="boardwrite">게시물 작성</div>
	  <div class="writer">작성자<input type="text" id="name" name="name" value="name">
	   <div class="category">
	   	<select id="board_category" name="board_category">
		    <option value="0">카테고리</option>
		    <option value="HTML">HTML</option>
		    <option value="JAVA">JAVA</option>
		    <option value="jQuery">jQuery</option>
		    <option value="C++">C++</option>
		</select>
	   </div> <br>
	   <div>
	    <input type="text" name="board_subject" id="board_subject" size="40" class="board_subject" maxlength="255" placeholder="제목을 입력해 주세요.">
	   </div> <br>
	   <div>
	   <div class="board_content">
          <textarea id=smartEditor name="board_content" rows="7" title="content">내용을 입력하세요.</textarea>
        </div> <br>
	   </div>
	   <div id="button">
	   	<input type="submit" class="submit" value="글쓰기"> &nbsp;
		<input type="reset" class="reset" value="취소" onClick="location.href='<%=request.getContextPath()%>/FreeListAction.seed'">
	   </div>
	  </div>
	  </div>
	 </form>
	</body>
  <script  src="<%=request.getContextPath() %>/free/smarteditor.js"></script>
</html>
