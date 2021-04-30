<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

<%@ include  file="/main/main_header.jsp"%>
	
 <form method="post" action="<%=request.getContextPath()%>/ModifyAction.seed">   
 	<input type="hidden" name="board_num" value="${b.board_num}">
	<input type="hidden" name="page" value="${p}">
    <header></header>
    <nav></nav>
    <section class="container">
      <div class="section_header">
        글 수정하기
      </div>  
      <hr>
      
      <div class="section_body">
        <div class="section_body_category">
          <select name="category" id="">
            <option value="뉴스" <c:if test="${b.board_category=='뉴스' }">${'selected' }</c:if> >뉴스</option>
            <option value="tip" <c:if test="${b.board_category=='tip' }">${'selected' }</c:if> >tip</option>
            <option value="사는 얘기" <c:if test="${b.board_category=='사는 얘기' }">${'selected' }</c:if> >사는 얘기</option>
            <option value="Q&A" <c:if test="${b.board_category=='Q&A' }">${'selected' }</c:if> >Q&A</option>
            <option value="자유게시판" <c:if test="${b.board_category=='자유게시판' }">${'selected' }</c:if> >자유게시판</option>
          </select>
        </div>
        
        <div class="section_body_subject">
          <input type="text" name="subject" value="${b.board_subject}">
        </div>
        
        <div class="section_body_content">
          <textarea id=smartEditor name="smartEditor" rows="7" style="width:700px; height:350px;" title="내용">${b.board_content}</textarea>
        </div>
        <div class="section_body_btn">
        	<input type="submit" id="submit_btn" value="수정">
        	<input type="button" value="취소" onClick="history.go(-1);">
        </div>
      </div>
    </section>

    <aside></aside>
    <footer></footer>
    <script defer src="./smarteditor.js"></script>
  </form>
</body>
</html>