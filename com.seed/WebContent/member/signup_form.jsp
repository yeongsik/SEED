<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 폼</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<script src="member.js"></script>

</head>
<body>

<form method="post" action="<%=request.getContextPath() %>/SignUpAction.seed"> 
	<div>
		<div>
			회원가입
		</div>
		
		<div>
			E-mail <br>
			<input type=text autofocus="autofocus" id="id" name="id">
			<input type=button value="ID중복검사" id="idcheck"> <span id="myid"></span>
			<!-- <div id="myid"></div> -->
		</div>
		
		<div>
			닉네임 <br>
			<input type=text id="name" name="name">
		</div>
		
		<div>
			비밀번호 <br>
			<input type=password id="pw" name="pw">			
		</div>
		
		<div>
			비밀번호 확인 <br>
			<input type=password id="checkPw" name="checkPw">
		</div>		
		
		
		<div>
			<input type=submit value="회원가입">
			<input type=reset value="취소">
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
    <title>Seed 회원가입</title>
    <link rel="stylesheet" type="text/css" href="./css/member.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Fira+Sans:wght@300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@600&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400&display=swap" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-latest.js"></script>    
    <script src="main.js"></script>
    <script src="member.js"></script>
    <script src="<%=request.getContextPath() %>/member/UpdateMemberInfoCourse2.js"></script>
    <script 
    src="https://kit.fontawesome.com/78e568182c.js" crossorigin="anonymous">
    </script>
</head>
<body>
    <div class="container-main">
    <%@ include file="/main/main_header.jsp" %>
        <section class="member-section">
            <form method="POST" action="<%=request.getContextPath() %>/SignUpAction.seed">
                <div class="member-container">
                    <div class="member-content">
                        <div class="member_subject member_subject-kr" >
                            회원가입
                        </div>
                        <div class="member-signup-wrapper">
                            <div class="member-signup_input">
                                <div class="member-signup_input_content">
                                    <span>ID</span>
                                    <input type="text" class="member-signup_input_text" id="id" name="id" placeholder="아이디를 입력하세요.">
                                    <input type="button" class="member-signup_checkbtn" id="idcheck" value="아이디 중복확인">
                                    <span id="myid"></span>
                                </div>
                                <div class="member-signup_input_content">
                                    <span>닉네임</span>
                                    <input type="text" class="member-signup_input_text" id="name" name="name" placeholder="닉네임을 입력하세요" >
                                    <input type="button" class="member-signup_checkbtn" id="checkName" value="닉네임 중복확인">
                                    <span id="display_CheckNameResult"></span>
                                </div>
                                <div class="member-signup_input_content">
                                    <span>비밀번호</span>
                                    <input type="password" id="pw" name="pw" class="member-signup_input_text">
                                </div>
                                <div class="member-signup_input_content">
                                    <span>비밀번호 확인</span>
                                    <input type="password" class="member-signup_input_text" id="checkPw" name="checkPw">
                                </div>
                            </div>
                            <div class="member-signup_profile-wrapper">
                                <div class="member-signup_profile">
                                    
                                </div>
                                <input type="button" class="member-signup_profile_btn" value="프로필 첨부">
                                <div class="login-content_subject signup-otherlogin">
                                    <span>다른 사이트 로그인</span>
                                    <div class="otherlogin_icon">
                                        <a href=""><i class="fab fa-google otherlogin_svg"></i></a>
                                        <a href=""><i class="fab fa-facebook otherlogin_svg"></i></a>
                                        <a href=""><i class="fab fa-github otherlogin_svg"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="updatecheck-content-wrapper">
                            <div class="updatecheck_btn-wrapper updatecheck-content">
                                <input type="submit" class="check_btn" value="Confirm">
                                <input type="button" class="check_btn" value="Cancel">
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