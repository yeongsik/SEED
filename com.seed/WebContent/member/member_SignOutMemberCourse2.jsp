<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="<%=request.getContextPath() %>/member/SignOutMemberCourse2.js"></script>
<body>
	<form method="post" action="<%=request.getContextPath()%>/SignOutMemberCourse3.seed">
		<div>
			<div>회원 탈퇴</div>
			<div>지금까지의 ${user_name}님의 활동내역입니다.</div>
			<div>
				<ul>
					<li>게시글 : ${CountContent}</li>
					<li>댓글 : ${CountComment}</li>
					<li>Days : ${days}</li>
				</ul>
			</div>
			<div>
				개인정보 관련 문장이 들어갈 공간	<br>
				개인정보 관련 문장이 들어갈 공간	<br>
				개인정보 관련 문장이 들어갈 공간	<br>
			</div>
			<div>
				<input type="checkbox" id="check_agree"> 상기 내용을 확인했으며 회원탈퇴에 동의합니다.
			</div>	
			<div>
				<input type="submit" value="Confirm" id="submit_btn" disabled>
				<input type="reset" value="Cancle" onClick="location.href='./MainAction.seed'">
			</div>
		</div>
	</form>
</body>
</html> --%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width , initial-scale=1.0">
    <meta name="viewport" content="user-scalable=no, initial-scale=1, maxium-scale=1">
    <title>Seed 회원탈퇴</title>
    <link rel="stylesheet" type="text/css" href="./css/member.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Fira+Sans:wght@300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@600&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400&display=swap" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-latest.js"></script>    
    <script src="<%=request.getContextPath() %>/member/SignOutMemberCourse2.js"></script>
    <script 
    src="https://kit.fontawesome.com/78e568182c.js" crossorigin="anonymous">
    </script>
</head>
<body>
    <div class="container-main">
    <%@ include file="/main/main_header.jsp" %>
        <section class="member-section">
            <form method="POST" action="<%=request.getContextPath()%>/SignOutMemberCourse3.seed">
                <div class="member-container">
                    <div class="member-content">
                        <div class="member_subject member_subject-kr" >
                            회원탈퇴
                        </div>
                        <div class="member-deleteform-content-wrapper">
                            <div class="deleteform-content-activity-comment">
                                지금까지의 <br> ${user_name}님 활동입니다.
                            </div>
                            <div class="deleteform-content-activity_data">
                                <div class="deleteform-content-board-wrapper deleteform-board-wrapper">
                                    <span class="deleteform-content-board_subject">게시글</span>
                                    <span class="deleteform-content-board_number">${CountContent}</span>
                                </div>
                                <div class="deleteform-content-review-wrapper deleteform-board-wrapper">
                                    <span class="deleteform-content-board_subject">댓글</span>
                                    <span class="deleteform-content-board_number">${CountComment}</span>
                                </div>  
                                <div class="deleteform-content-view-wrapper deleteform-board-wrapper">
                                    <span class="deleteform-content-board_subject">조회수</span>
                                    <span class="deleteform-content-board_number">숫자</span>
                                </div>
                                <div class="deleteform-content-days-wrapper deleteform-board-wrapper">
                                    <span class="deleteform-content-board_subject">Days</span>
                                    <span class="deleteform-content-board_number">${days}</span>
                                </div>
                            </div>
                            <div class="deleteform-information-container">
                                <div class="deleteform-information-wrapper">
                                    개인정보관련 내용
                                </div>
                            </div>
                            <div class="deleteform-check-container">
                                <input type="checkbox" class="delete_chk" id="check_agree">
                                <span class="delete_chk_span">상기 내용을 확인했으며 회원탈퇴에 동의합니다.</span>
                            </div>
                            <div class="deleteform-btn-container">
                                <div class="updatecheck_btn-wrapper updatecheck-content">
                                    <input type="submit" class="check_btn-2" value="Confirm" id="submit_btn" disabled>
                                    <input type="button" class="check_btn-2" value="Cancel" onClick="location.href='./MainAction.seed'">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </section>
        <%@ include file="/main/main_footer.jsp" %>
    </div>
</body>
</html>