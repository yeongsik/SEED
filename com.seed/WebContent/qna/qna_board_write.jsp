<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>게시글 작성</title>
  <script src="http://code.jquery.com/jquery-latest.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>
  
   <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/main.css">
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

 <form method="post" action="<%=request.getContextPath() %>/AddAction.seed" id="qna_write_form">   
    <header></header>
    <nav></nav>
    <section class="container">
      <div class="section_header">
        카페 글쓰기
      </div>  
      <hr>
      
      <div class="section_body">
        <div class="section_body_category">
          <select name="category" id="">
            <option value="뉴스" >뉴스</option>
            <option value="tip" >tip</option>
            <option value="사는 얘기" >사는 얘기</option>
            <option value="Q&A" selected>Q&A</option>
            <option value="자유게시판" >자유게시판</option>
          </select>
        </div>
        
        <div class="section_body_subject">
          <input type="text" name="subject" placeholder="제목을 입력해 주세요">
        </div>
        
        <div class="section_body_content">
          <textarea id=smartEditor name="smartEditor" rows="7" style="width:700px; height:350px;" title="내용">내용을 입력해주세요</textarea>
        </div>
        <div class="section_body_btn">
        	<input type="submit" id="submit_btn" value="작성">
        	<input type="button" value="취소" onClick="location.href='<%=request.getContextPath()%>/ListAction.seed'">
        </div>
      </div>
    </section>

    <aside></aside>
    <footer></footer>
  </form>
</body>
   <script  src="<%=request.getContextPath() %>/qna/smarteditor.js"></script>
</html>