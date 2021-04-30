<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<link rel="stylesheet" type="text/css" href="./css/main.css">   
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Fira+Sans:wght@300&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Cairo:wght@600&display=swap" rel="stylesheet">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="<%=request.getContextPath() %>/js/main.js"></script>
<script src="https://kit.fontawesome.com/78e568182c.js" crossorigin="anonymous"></script>

 <header class="header-main">
            <div class="header-icon header-content">
                <div class="icon-content icon-img">
                    <a href="<%=request.getContextPath()%>/MainAction.seed"><i class="fas fa-seedling"></i></a>
                </div>
                <div class="icon-content seed">SEED</div>
            </div>
            <div class="header-main-nav header-content">
                <div class="nav-list">
                    <div class="nav-list-content">
                        <a href="<%=request.getContextPath()%>/MainAction.seed">Home</a>
                    </div>
                    <div class="nav-list-content">
                        <a href="<%=request.getContextPath()%>/ShareListAction.seed">Share</a>
                    </div>
                    <div class="nav-list-content nav-list-community">
                        <a href="" class="community-sub">Community</a>
                        <div class="nav-list-content-detail">
                            <a href="<%=request.getContextPath()%>/TipListAction.seed">Tip</a>
                            <a href="<%=request.getContextPath()%>/NewsListAction.seed">News</a>
                            <a href="<%=request.getContextPath()%>/FreeListAction.seed">Free</a>
                            <a href="<%=request.getContextPath()%>/ListAction.seed">Q&A</a>
                            <a href="<%=request.getContextPath()%>/LiveListAction.seed">Live</a>
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
                <div class="header-main-member-content header-member-content">
<%-- 	             	<c:if test="${sessionScope.id == null }">
                		<a href="<%=request.getContextPath()%>/MemberLogInForm.seed">Log In</a>
                	</c:if>
                	
              		<c:if test="${sessionScope.id != null }">
                		<div class="header-main-member-content-icon">
        	        		<a href="./MyPageForm.seed"><i class="fas fa-user-circle member-icon"></i></a>
    	            		<div class="header-main-member-content-icon-detail">
                				<a href="./MyPageForm.seed">My Page</a>
                				<a href="./MemberLogout.seed">Logout</a>
	                		</div>
              			</div>
              		</c:if>
 --%>              		
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
        </header>