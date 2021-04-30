<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width , initial-scale=1.0">
    <meta name="viewport" content="user-scalable=no, initial-scale=1, maxium-scale=1">
    <title>Seed</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Fira+Sans:wght@300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@600&display=swap" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-latest.js"></script>    
    <script src="<%=request.getContextPath() %>/js/main.js"></script>
    <script 
    src="https://kit.fontawesome.com/78e568182c.js" crossorigin="anonymous">
    </script>
    <script>
/*     	function shareLink(){
    		var url = "<c:out value='${b.share_link}'/>";
    		var popup = window.open(url); // url자리에 값을 넣을 방법이 있는지 
    	} */

    	$(function(){
    	    $("#viewage").slice(0, 9).show();
    	    $("#more").click(function(e){
    	        e.preventDefault();// 이쪽 명령아 a태그에서 작동하는 기능이라고 해서 a태그를 줘도 작동하지 않았습니다.
    	        $("div:hidden").slice(0, 3).show();// div가 어디에서 오는 값인지 
    	        if($("div:hidden").length == 0){
    	            alert("마지막 페이지 입니다.");
    	        }
    	    });
    	});

    </script>
</head>
<body>
    <div class="container-main">
    	<%@ include file="/main/main_header.jsp" %>
        <section class="main-section">
            <article class="main-section-article-share" style="margin:0;">
                <div class="main-section-article-share-container">
                    <div class="article-subject share_subject fade-in" style="padding-left:120px">
                        Share
                    </div>
<!-- 					<div style="float: right;">
						<a href="./ShareWriteForm.seed" style="">글쓰기</a>
					</div> -->
					<div style="text-align: center;">
					<c:set var="num" value="${listcount = (page-1) * 9 }" />
					<c:forEach var="b" items="${boardlist }">
						<div class="article-share-content-container share-first-container fade-in" id="viewpage" style="display: inline-block;">
							<div class="article-share-content article-transition-box" style="background-color:#4c8c4a;margin:0 10px ;"
							onclick="location.href='./ShareDetailAction.seed?share_num=${b.share_num}&page=${page }'"><%-- onclick="shareLink()" --%>
								<a href="${b.share_link}" target="_blank" style="width:300px; height: 50px">링크</a>
								
								<div class="share-content article-transition" style="margin:0 auto">
									<div class="share-content_channel"style="text-align: left;">채널명 : ${b.share_site}</div>
									<div class="share-content_desc" style="text-align: left;">채널 소개 : ${b.share_des }</div>
									<%-- <div style="display: inline-block;float: right;">${b.share_view } View</div> --%>
								</div>
							</div>
						</div>
					</c:forEach>
					</div>
					<div class="article-share-content-arrow fade-in">
						<div class="article-share-content-arrow_btn" >More</div>
<!-- 						<div class="article-share-content-arrow_btn" ><a id="more">More</a></div> -->
						<i class="fas fa-angle-double-down"></i>
					</div>
				</div>
            </article>

        </section>

        <footer class="footer">

        </footer>
    </div>

</body>
</html>

