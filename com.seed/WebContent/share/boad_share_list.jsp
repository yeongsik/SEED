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
        <header class="header-main">
            <div class="header-icon header-content">
                <div class="icon-content icon-img">
                    <i class="fas fa-seedling"></i>
                </div>
                <div class="icon-content seed">SEED</div>
            </div>
            <div class="header-main-nav header-content">
                <div class="nav-list">
                    <div class="nav-list-content">
                        <a href="<%=request.getContextPath()%>/MainAction.seed">Home</a>
                    </div>
                    <div class="nav-list-content">
                        <a href="./ShareListAction.seed">Share</a>
                    </div>
                    <div class="nav-list-content nav-list-community">
                        <a href="" class="community-sub">Community</a>
                        <div class="nav-list-content-detail">
                            <a href="">Tip</a>
                            <a href="">News</a>
                            <a href="">Free</a>
                            <a href="">Q&A</a>
                            <a href="">Live</a>
                        </div>
                    </div>
                    <div class="nav-list-content">
                        <a href="">About</a>
                    </div>
                </div>
            </div>
            <div class="header-main-member header-content">
                <div class="header-main-member-content header_search">
                    <i class="fas fa-search" id="search_btn"></i>
                </div>
                <div class="header-main-member-content search_box">
                    <input type="text" value="search">
                    <input type="button" value="검색">
                </div>
                <div class="header-main-member-content member-content">
	             	<c:if test="${sessionScope.id == null }">
                		<a href="<%=request.getContextPath()%>/MemberLogInForm.seed">Log In</a>
                	</c:if>
              		<c:if test="${sessionScope.id != null }">
                		<a href=""><i class="fas fa-user-circle member-icon"></i></a>
              		</c:if>
                </div>
            </div>
        </header>
        <div class="main-ad">
            <div class="main-ad-content">
				<img class="mySlides" src="<%=request.getContextPath()%>/css/img/seed-ad.title.jpg">
				<button class="w3-button w3-display-left" onclick="plusDivs(-1)">&#10094;</button>
				<button class="w3-button w3-display-right" onclick="plusDivs(+1)">&#10095;</button>
            </div>
        </div>
        <section class="main-section">
            <article class="main-section-article-share">
                <div class="main-section-article-share-container">
                    <div class="article-subject share_subject fade-in">
                        Best Share
                    </div>
					<div style="float: right;">
						<a href="./ShareWriteForm.seed" style="">글쓰기</a>
					</div>
					<c:set var="num" value="${listcount = (page-1) * 9 }" />
					<c:forEach var="b" items="${boardlist }">
						<div class="article-share-content-container share-first-container fade-in" id="viewpage" style="display: inline-block;">
							<div class="article-share-content article-transition-box" 
									style="background-color:#4c8c4a ;" onclick="location.href='${b.share_link}'"><!-- onclick="shareLink()" -->
								<div class="share-content article-transition" style="margin:0 auto">
									<div class="share-content_channel">채널명 : ${b.share_site}</div>
									<div class="share-content_desc" style="display: inline-block;">채널 소개 : ${b.share_des }</div>
									<div style="display: inline-block;float: right;">${b.share_view } View</div>
								</div>
							</div>
						</div>
					</c:forEach>
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

