<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	test입니다.
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
	 	<%-- <input type="button" value="댓글" onClick="location.href='free_board_content.jsp'?board_num=<%=board_num%>&page=<%=nowpage%>' "> --%>
	  </td>
	</tr>
</body>
</html>