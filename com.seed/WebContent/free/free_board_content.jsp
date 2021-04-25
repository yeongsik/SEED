<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.FreeDTO"%>
<%@ page import="dao.FreeDAO"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%
	int board_num = Integer.parseInt(request.getParameter("board_num"));
	String nowpage = request.getParameter("page");
	
	FreeDAO dao = FreeDAO.getInstance();
	
	String listClickFlag = request.getParameter("listClickFlag");
	if("Y".equals(listClickFlag)){	//조회수 update.
		dao.viewUpdate(board_num);
	}
	
	FreeDTO board = dao.getDetail(board_num);		// 본문
	
	SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
// 	String content = board.getBoard_content().replace("\n", "<br>");
%>    

<table border=1 width=500 align=center>
	<caption>상세 페이지</caption>
	<tr><td>카테고리</td>
		<td><%=board.getBoard_category() %></td>
		<td>조회수</td>
		<td><%=board.getBoard_view() %></td>
	</tr>
	<tr><td>작성자</td>
		<td><%=board.getName() %></td>
		<td>작성일</td>
		<td><%=board.getBoard_register() %></td>
	</tr>
	<tr><td>제목</td>
		<td colspan=3><%=board.getBoard_subject() %></td>
	</tr>
	<tr><td>내용</td>
		<td colspan=3>
		<pre><%=board.getBoard_content() %></pre>	
		</td>
	</tr>
	<tr><td colspan=4 align=center>
			<input type="button" value="수정" onClick="location.href='free_board_update.jsp?board_num=<%=board_num%>&page=<%=nowpage%>' ">
			<input type="button" value="삭제" onClick="location.href='free_delete_pro.jsp?board_num=<%=board_num%>&page=<%=nowpage%>' ">
			<input type="button" value="목록" onClick="location.href='free_board_list.jsp?page=<%=nowpage%>' ">
		</td>
	</tr>
</table>
