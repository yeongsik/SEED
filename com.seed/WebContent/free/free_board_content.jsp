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
	<tr>
	<div class="commentWrite">
				<form name="add_comment" id="add_comment" method="post" action="/mboard/mboard01/?method=comment_add&amp;no=115&amp;page=1">
				<input type="hidden" name="contents_no" id="contents_no" value="115">
				<input type="hidden" name="page" id="page" value="1">
				<input type="hidden" name="h_comment_count" id="h_comment_count" value="0">
				<input type="hidden" name="comment_method" id="comment_method" value="insert">
				<input type="hidden" name="comment_modify_no" id="comment_modify_no" value="">
				<div class="commentAuthor">
					<span class="cAuthorText">닉 네 임&nbsp;</span>
					<span class="cAuthorInput"><input type="text" name="nick_name" class="inp_d5" maxlength="10"></span>
				</div>
				<div class="commentAuthor">
					<span class="cPasswordText">패스워드</span>
					<span class="cAuthorInput"><input type="password" name="password" class="inp_d5" maxlength="20"></span>
				</div>
				<div class="commentAuthor">
					<span class="cCodeText">코드입력</span>
					<span class="cCodeImage"><img src="http://mdgbdalin2.dgweb.kr/captcha/1619444100.08.jpg" width="80" height="20" style="border:0;" alt=" " align="absmiddle"></span>
					<span class="cCodeInput"><input type="hidden" name="user_captcha_check" id="user_captcha_check" value=""><input type="hidden" name="user_captcha_val" id="user_captcha_val" value="AKJEJE"><input type="text" name="user_captcha" id="user_captcha" class="user_captcha" title="자동글쓰기방지" size="10" value=""></span>									
				</div>
				<div class="commentcode"><span class="cCodeResult"></span></div>
				<div class="cWrite">
					<div class="commentWContent">
						<textarea name="wcontent" id="wcontent" class="wcontent" rows="3"></textarea>
					</div>
					<div class="commentButton">
						<img id="add_comment_button" src="/plugins/board/views/default/images/comment_writebtn.gif" style="cursor:pointer;" onfocus="this.blur()">
					</div>
				</div>
				
				<div class="commentOption">
					<span class="is_secret"><input type="checkbox" value="Y" name="is_secret">&nbsp;비밀글</span>
				</div>
				</form>
			</div>
	 <td>댓글</td>
	 <td colspan=2 align=center>
	 	<input type="text" size="10" maxlength="10" id="reply" name="reply">
	 	<input type="button" value="댓글" onClick="location.href='free_board_content.jsp'?board_num=<%=board_num%>&page=<%=nowpage%>' ">
	  </td>
	</tr>
</table>
