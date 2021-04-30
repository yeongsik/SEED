<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
	<link rel="stylesheet" type="text/css" href="./css/main.css">
	<link rel="stylesheet" type="text/css" href="./css/member.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Fira+Sans:wght@300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@600&display=swap" rel="stylesheet">
    
    <script src="http://code.jquery.com/jquery-latest.js"></script>    
    <script src="<%=request.getContextPath() %>/js/main.js"></script>
    <script src="https://kit.fontawesome.com/78e568182c.js" crossorigin="anonymous"></script>
</head>
<body>
	<%@ include file="/main/main_header.jsp" %>
	
	<div>
		<div>
			${user_name}님 반갑습니다.
		</div>
		<div>
			My page
		</div>
		
		<div>
			<a href="./UpdateMemberInfoCourse1.seed">회원정보수정</a> <br>
			<a href="./SignOutMemberCourse1.seed">회원탈퇴</a>
		</div>
		
		<div>
			이번주 활동 <br>
			<div>
				<ul>
					<li>게시글 : ${CountContent}</li>
					<li>댓글 : ${CountComment}</li>
				</ul>
			</div>
			
			<div>
				<ul>
					<li>z</li>
					<li>2</li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html> --%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width , initial-scale=1.0">
    <meta name="viewport" content="user-scalable=no, initial-scale=1, maxium-scale=1">
    <title>마이 페이지</title>
    <link rel="stylesheet" type="text/css" href="./css/member.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Fira+Sans:wght@300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@600&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400&display=swap" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-latest.js"></script>   
    <script src="<%=request.getContextPath() %>/js/main.js"></script> 
    <script 
    src="https://kit.fontawesome.com/78e568182c.js" crossorigin="anonymous">
    </script>
</head>
<%@ include file="/main/main_header.jsp" %>
<body>
    <div class="container-main">
        <section class="member-section">
                <div class="member-container">
                    <div class="member-content">
                        <div class="mypage-subject-wrapper">
                            <div class="member_subject">
                                My page
                            </div>
                            <div class="mypage-welcome-wrapper">
                                <span class="mypage_welcomeMsg Msg_name">${user_name}님</span>
                                <span class="mypage_welcomeMsg">반갑습니다</span>
                            </div>
                        </div>
                        <div class="mypage-content-wrapper">
                            <div class="mypage-content-nav-wrapper">
                                <div class="mypage-content-nav">
                                    <a href="./UpdateMemberInfoCourse1.seed">회원정보수정</a>
                                </div>
                                <div class="mypage-content-nav">
                                    <a href="./SignOutMemberCourse1.seed">회원 탈퇴</a>
                                </div>
                            </div>
                            <div class="mypage-content-activity">
                                <div class="mypage_act_subject">${user_name}님의 활동내역</div>
                                <div class="mypage_activity">
                                    <div class="mypage_activity_content">
                                        <span>게시글</span>
                                        <span>${CountContent}</span>
                                    </div>
                                    <div class="mypage_activity_content">
                                        <span>댓글</span>
                                        <span>${CountComment}</span>
                                    </div>
                                    <div class="mypage_activity_content">
                                        <span>게시물당 조회수</span>
                                        <span>숫자</span>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
        </section>
        <%@ include file="/main/main_footer.jsp" %>
    </div>
</body>
</html>