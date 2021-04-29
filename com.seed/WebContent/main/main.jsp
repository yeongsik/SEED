<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width , initial-scale=1.0">
    <meta name="viewport" content="user-scalable=no, initial-scale=1, maxium-scale=1">
    <title>Seed</title>
    
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
    <div class="container-main">

	

   	 	<%@ include file="/main/main-header.jsp" %>
<%-- 
        <header class="header-main">

            <div class="header-icon header-content">
                <div class="icon-content icon-img">
                    <i class="fas fa-seedling"></i>
                </div>
                <div class="icon-content seed"><a href="<%=request.getContextPath()%>/MainAction.seed">SEED</a></div>
            </div>
            <div class="header-main-nav header-content">
                <div class="nav-list">
                    <div class="nav-list-content">
                        <a href="<%=request.getContextPath()%>/MainAction.seed">Home</a>
                    </div>
                    <div class="nav-list-content">
                        <a href="">Share</a>
                    </div>
                    <div class="nav-list-content nav-list-community">
                        <a href="" class="community-sub">Community</a>
                        <div class="nav-list-content-detail">
                            <a href="">Tip</a>
                            <a href="<%=request.getContextPath()%>/NewsListAction.seed">News</a>
                            <a href="">Free</a>
                            <a href="./ListAction.seed">Q&A</a>
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
	             	<c:if test="${user_name == null }">
                		<a href="<%=request.getContextPath()%>/MemberLogInForm.seed">Log In</a>
                	</c:if>
                	
              		<c:if test="${user_name != null }">
              			<div class="header-main-member-content-icon">
        	        		<a href="./MyPageForm.seed"><i class="fas fa-user-circle member-icon"></i></a>
    	            		<div class="header-main-member-content-icon-detail">
                				<a href="./MyPageForm.seed">My Page</a>
                				<a href="./MemberLogout.seed">Logout</a>
	                		</div>
              			</div>
              		</c:if>
              		
                </div>
            </div>
        </header> --%>
        <div class="main-ad">
            <div class="main-ad-content">
				<img class="mySlides" src="<%=request.getContextPath()%>/css/img/seed-ad.title.jpg">
				<button class="w3-button w3-display-left" onclick="plusDivs(-1)">&#10094;</button>
				<button class="w3-button w3-display-right" onclick="plusDivs(+1)">&#10095;</button>
            </div>
        </div>
        <section class="main-section">
            <div class="main-section-board">

                <article class="main-section-article weeklybest-container">
                    <div class="article-subject weeklybest_subject fade-in">
                        Weekly Best
                    </div>
                    <div class="board-article-container weeklybest-content fade-in">
                        <div class="weeklybest-content_category" id="category_btn">
                            <input type="button" class="category-list"  value="Q&A">
                            <input type="button" class="category-list"  value="팁 게시판">
                            <input type="button" class="category-list"  value="사는 얘기">
                            <input type="button" class="category-list"  value="News">
                            <input type="button" class="category-list"  value="자유 게시판">
                        </div>
                        
                        <div class="weeklybest-content_board-container" id="weeklybest">
                        	<div id="ajax">
	                            <c:forEach var="news" items="${bestNewsList}">
	                            <div class="weeklybest-content_board">
	                                <div class="weeklybest_cell-1 weeklybest_cell">
	                                    <a href="<%=request.getContextPath()%>/NewsDetailAction.seed?board_num=${news.board_num}">${news.board_subject }</a>
	                                </div>
	                                <div class="weeklybest_cell-2 weeklybest_cell">
	                                    ${news.name}
	                                </div>
	                                <div class="weeklybest_cell-3 weeklybest_cell">
	                                    <fmt:formatDate value="${news.board_register}" pattern="yyyy-MM-dd"/>
	                                </div>
	                            </div>
	                            </c:forEach>
                        	</div>
                        </div>
                    </div>
                </article>
                <article class="main-section-article editorpick-container fade-in">
                    <div class="article-subject editorpick_subject">
                        Editor's Pick
                    </div>
                    <div class="board-article-container editorpick-content article-transition-box">
                        <div class="editorpick-content-container article-transition">
                            <div class="editorpick-content_subject editorpick-cell">
                                글 제목 
                            </div>
                            <div class="editorpick-content_namename editorpick-cell">
                                작성자
                            </div>
                            <div class="editorpick-content_register editorpick-cell">
                                날짜
                            </div>
                        </div>
                    </div>
                </article>
            </div>
            <article class="main-section-article-share">
                <div class="main-section-article-share-container">
                    <div class="article-subject share_subject fade-in">
                        Best Share
                    </div>
                    <div class="article-share-content-container share-first-container fade-in">
                        <div class="article-share-content article-transition-box">
                            <div class="share-content article-transition">
                                <div class="share-content_channel">
                                    채널명
                                </div>
                                <div class="share-content_desc">
                                    채널 소개
                                </div>
                            </div>
                        </div>
                        <div class="article-share-content">
                            <div class="share-content">
                                <div class="share-content_channel">
                                    채널명
                                </div>
                                <div class="share-content_desc">
                                    채널 소개
                                </div>
                            </div>
                        </div>
                        <div class="article-share-content">
                            <div class="share-content">
                                <div class="share-content_channel">
                                    채널명
                                </div>
                                <div class="share-content_desc">
                                    채널 소개
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="article-share-content-container fade-in">
                        <div class="article-share-content">
                            <div class="share-content">
                                <div class="share-content_channel">
                                    채널명
                                </div>
                                <div class="share-content_desc">
                                    채널 소개
                                </div>
                            </div>
                        </div>
                        <div class="article-share-content">
                            <div class="share-content">
                                <div class="share-content_channel">
                                    채널명
                                </div>
                                <div class="share-content_desc">
                                    채널 소개
                                </div>
                            </div>
                        </div>
                        <div class="article-share-content">
                            <div class="share-content">
                                <div class="share-content_channel">
                                    채널명
                                </div>
                                <div class="share-content_desc">
                                    채널 소개
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="article-share-content-container fade-in">
                        <div class="article-share-content">
                            <div class="share-content">
                                <div class="share-content_channel">
                                    채널명
                                </div>
                                <div class="share-content_desc">
                                    채널 소개
                                </div>
                            </div>
                        </div>
                        <div class="article-share-content">
                            <div class="share-content">
                                <div class="share-content_channel">
                                    채널명
                                </div>
                                <div class="share-content_desc">
                                    채널 소개
                                </div>
                            </div>
                        </div>
                        <div class="article-share-content">
                            <div class="share-content">
                                <div class="share-content_channel">
                                    채널명
                                </div>
                                <div class="share-content_desc">
                                    채널 소개
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="article-share-content-arrow fade-in">
                        <div class="article-share-content-arrow_btn">
                            More
                        </div>
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

