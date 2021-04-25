<%@ page contentType="text/html; charset=utf-8" %>
<%@ include file="color.jsp"%>

<html>
	<head>
		<title>Seed Free write form</title>
		<link href="../css/free_board_write.css" rel="stylesheet" type="text/css">
		<script src="http://code.jquery.com/jquery-1.11.1.js"></script>
<!-- 		<script src="check.js"></script> -->
		<script>
		$(function(){
			$("form").submit(function(){
				if($("#name").val()==""){
					alert('작성자명을 입력하세요');
					$("#name").focus();
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
				if($("#board_content").val()==""){
					alert("내용을 입력하세요");
					$("#board_content").focus();
					return false;
				}
			});
		});
		</script>
	</head>   
	<body bgcolor="<%=bodyback_c%>">  
		<center class="writesub"><b>게시물 작성</b></center>
		<br>
		<form method="post" name="freewritepro" action="free_write_pro.jsp">		
		<table width="330" border="1" cellspacing="0" cellpadding="0"  bgcolor="<%=bodyback_c%>" align="center">
			<tr class="name" align="center">아이디</tr>
		   <tr>
		    <td  width="330">
		       <input type="text" size="10" maxlength="10" id="name" name="name"></td>
		  </tr>
		    <tr>
		    <td width="330">
		   		<select id="board_category" name="board_category">
		    		<option value="0">카테고리</option>
		    		<option value="HTML">HTML</option>
		    		<option value="JAVA">JAVA</option>
		    		<option value="jQuery">jQuery</option>
		    		<option value="C++">C++</option>
		    	</select>
		  </tr>
		  <tr>
		    <td width="330">    
		       <input type="text" size="40" maxlength="50" id="board_subject" name="board_subject" placeholder="제목을 입력해 주세요."></td>	
		  </tr>
		  <tr>
		    <td width="330" >
		     <textarea id="board_content" name="board_content" rows="13" cols="40" placeholder="내용을 입력해 주세요."></textarea></td>
		  </tr>
		<tr>      
		 <td colspan=2 align="center"> 
		  <input type="submit" class="submit" value="글쓰기">
		  <input type="reset" class="reset" value="취소">
		   <input type="button" class="list" value="목록" onClick="location.href='free_board_list.jsp'">
		</td></tr></table>   
		</form>      
	</body>
</html>
