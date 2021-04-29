<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.FreeDTO"%>
<%@ page import="dao.FreeDAO"%>

<%
	int board_num = Integer.parseInt(request.getParameter("board_num"));
	int nowpage = Integer.parseInt(request.getParameter("page"));
	
	FreeDAO dao = FreeDAO.getInstance();
	
	FreeDTO board = dao.getDetail(board_num);	// 그 페이지의 상세 정보 구하기
%>    

<html>
	<head>
		<title>Seed Free content</title>
		<link href="./css/free_board_content.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.1.js"></script>
	
	</head>   
	<body>
	 <form method="post" name="freeboardupdate" action="free_update_pro.jsp">
	  <input type="hidden" name="board_num" value="<%=board_num%>">
	   <input type="hidden" name="page" value="<%=nowpage%>">
		<div id="writeform">
 		 <div class="writecontent"></div>
  		  <div class="board_name">작성자
  		  <div id="board_view">조회수 : <%=board.getBoard_view() %> &nbsp;
  		  <div class="writedate"><%=board.getBoard_register() %></div>	&nbsp;
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
	    <input type="text" name="board_subject" size="40" class="board_subject" maxlength="255" value="<%=board.getBoard_subject()%>">
	   </div> <br>
	   <div>
	     <textarea class="board_content" name="board_content" rows="13" cols="40"><%=board.getBoard_content()%></textarea>
	   </div> <br>
	   </div>
	   <div id="button">
	   	<input type="submit" value="수정" > &nbsp;
		<input type="reset" value="삭제" onClick="location.href='free_delete_pro.jsp?board_num=<%=board_num%>&page=<%=nowpage%>' ">
	   </div>
	  </div>
	  </div>
	 </form>
	</body>
  <script  src="<%=request.getContextPath() %>/free/smarteditor.js"></script>
</html>
