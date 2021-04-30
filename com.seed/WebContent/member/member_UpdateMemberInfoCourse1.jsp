<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="<%=request.getContextPath() %>/member/UpdateMemberInfoCourse1.js"></script>
</head>
<body>
	<form method="post" action="<%=request.getContextPath()%>/UpdateMemberInfoCourse2.seed">
		<div>
			<div>
				회원정보수정
			</div>
			
			<div>
				<div>
					비밀번호를 입력해주세요
				</div>
				<div>
					<input type="password" id="pw" name="pw">
				</div>					
				<div>
					<input type="submit" value="Confirm" id="confirm_btn">
					<input type="reset" value="Cancel" onClick="history.go(-1);">
				</div>
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
    <title>Seed</title>
    <link rel="stylesheet" type="text/css" href="./css/member.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Fira+Sans:wght@300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@600&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400&display=swap" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-latest.js"></script>   
    <script src="<%=request.getContextPath() %>/member/UpdateMemberInfoCourse1.js"></script> 
    <script 
    src="https://kit.fontawesome.com/78e568182c.js" crossorigin="anonymous">
    </script>
</head>
<body>
    <div class="container-main">
    	<%@ include file="/main/main_header.jsp" %>
        <section class="member-section">
            <form method="POST" action="<%=request.getContextPath()%>/UpdateMemberInfoCourse2.seed">
                <div class="member-container">
                    <div class="member-content">
                        <div class="member_subject member_subject-kr" >
                            회원정보 수정
                        </div>
                        <div class="updatecheck-content-wrapper">
                        <div class="updatecheck_subejct updatecheck-content">
                            비밀번호를 입력해주세요.
                        </div>
                            <div class="updatecheck_input updatecheck-content">
                                <input type="password" class="pw-check_input" id="pw" name="pw">
                            </div>
                            <div class="updatecheck_btn-wrapper updatecheck-content">
                                <input type="submit" class="check_btn" value="Check" id="confirm_btn">
                                <input type="button" class="check_btn" value="Cancel" onClick="history.go(-1);">
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