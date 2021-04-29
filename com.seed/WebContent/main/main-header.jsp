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
                            <a href="">News</a>
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
                <div class="header-main-member-content header-member-content">
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