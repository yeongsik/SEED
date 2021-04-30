<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="<%=request.getContextPath() %>/member/UpdateMemberInfoCourse2.js"></script>
</head>
<body>
	<form method="post" action="<%=request.getContextPath()%>/UpdateMemberInfoCourse3.seed">
		<div>
			<div>
				회원정보수정
			</div>
			<div>
				<div>아이디</div>
				<input type="text" id="id" name="id" value="${memberIdPw.id}" readonly>
			</div>
			<div>
				<div>닉네임</div>
				<input type="text" id="name" name="name" value="${user_name}">
				<input type="button" id="checkName" value="중복확인">
				<span id="display_CheckNameResult"></span>
			</div>
			<div>
				<div>비밀번호</div>
				<input type="password" id="pw" name="pw">
			</div>
			<div>
				<div>비밀번호 확인</div>
				<input type="password" id="checkPw" name="checkPw">
			</div>
			<div>
				<input type="submit" value="Update" id="update_btn">
				<input type="reset" value="Cancel" onClick="location.href='./MyPageAction.seed'">
			</div>
		</div>
	</form>
</body>
</html>
 --%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width , initial-scale=1.0">
    <meta name="viewport" content="user-scalable=no, initial-scale=1, maxium-scale=1">
    <title>회원정보수정</title>
    <link rel="stylesheet" type="text/css" href="./css/member.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Fira+Sans:wght@300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@600&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400&display=swap" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-latest.js"></script>    
    <script src="<%=request.getContextPath() %>/member/UpdateMemberInfoCourse2.js"></script>
    <script 
    src="https://kit.fontawesome.com/78e568182c.js" crossorigin="anonymous">
    </script>
</head>
<body>
    <div class="container-main">
    <%@ include file="/main/main_header.jsp" %>
        <section class="member-section">
            <form method="POST" action="<%=request.getContextPath()%>/UpdateMemberInfoCourse3.seed">
                <div class="member-container">
                    <div class="member-content">
                        <div class="member_subject member_subject-kr" >
                            회원정보 수정
                        </div>
                        <div class="member-signup-wrapper">
                            <div class="member-signup_input">
                                <div class="member-signup_input_content">
                                    <span>ID</span>
                                    <input type="text" class="member-signup_input_text" id="id" name="id" value="${memberIdPw.id}" readonly>
                                </div>
                                <div class="member-signup_input_content">
                                    <span>닉네임</span>
                                    <input type="text" class="member-signup_input_text" id="name" name="name" value="${user_name}" >
                                    <input type="button" class="member-signup_checkbtn" id="checkName" value="닉네임 중복확인">
                                    <span id="display_CheckNameResult"></span>
                                </div>
                                <div class="member-signup_input_content">
                                    <span>비밀번호</span>
                                    <input type="password" class="member-signup_input_text" id="pw" name="pw">
                                </div>
                                <div class="member-signup_input_content">
                                    <span>비밀번호 확인</span>
                                    <input type="password" class="member-signup_input_text" id="checkPw" name="checkPw">
                                </div>
                            </div>
                            <div class="member-signup_profile-wrapper">
                                <div class="member-signup_profile">

                                </div>
                                <input type="button" class="member-signup_profile_btn" value="프로필 변경">
                            </div>
                        </div>
                        <div class="updatecheck-content-wrapper">
                            <div class="updatecheck_btn-wrapper updatecheck-content">
                                <input type="submit" class="check_btn" value="Check" id="update_btn">
                                <input type="button" class="check_btn" value="Cancel" onClick="location.href='./MyPageAction.seed'">
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