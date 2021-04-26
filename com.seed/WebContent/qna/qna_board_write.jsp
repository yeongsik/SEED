<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>게시글 작성</title>
  <script src="http://code.jquery.com/jquery-latest.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>
</head>
<body>
 <form method="post" action="<%=request.getContextPath()%>/AddAction.seed" id="qna_write_form">   
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
        </div>
      </div>
    </section>

    <aside></aside>
    <footer></footer>
   <script defer src="<%=request.getContextPath() %>/qna/smarteditor.js"></script>
  </form>
</body>
</html>