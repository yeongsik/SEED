<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
    String ctx = request.getContextPath();    //콘텍스트명 얻어오기.
%>

<!DOCTYPE html>
<html lang="kr">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>사는얘기게시판</title>
<script src="http://code.jquery.com/jquery-1.9.0.min.js"></script>
<script src="<%=request.getContextPath()%>/live/script.js"></script>
<script type="text/javascript" src="<%=ctx %>/SE2/js/HuskyEZCreator.js" charset="utf-8"></script>

<script type="text/javascript">
var oEditors = [];
$(function(){
      nhn.husky.EZCreator.createInIFrame({
          oAppRef: oEditors,
          elPlaceHolder: "ir1", //textarea에서 지정한 id와 일치해야 합니다. 
          //SmartEditor2Skin.html 파일이 존재하는 경로
          sSkinURI: "/com.seed/SE2/SmartEditor2Skin.html",  
          htParams : {
              // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
              bUseToolbar : true,             
              // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
              bUseVerticalResizer : true,     
              // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
              bUseModeChanger : true,         
              fOnBeforeUnload : function(){
                   
              }
          }, 
          fOnAppLoad : function(){
              //기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용
              oEditors.getById["ir1"].exec("PASTE_HTML", ["기존 DB에 저장된 내용을 에디터에 적용할 문구"]);
          },
          fCreator: "createSEditor2"
      });
      
      //저장버튼 클릭시 form 전송
      $("#save").click(function(){
          oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
          $("#frm").submit();
      });    
});
 
 
 
</script>

</head>
<body style="width:500px;">
	<header>
		<div>
			<a href="#">SEED</a>
		</div>
		<div class="header_Front" style=" list-style: none;">
			<ul>
				<li><a href="#">Home</a></li>
				<li><a href="#">Share</a></li>
				<li><a href="#">Community</a></li>
				<li><a href="#">About</a></li>
			</ul>
		</div>

	</header>
	<form action="<%=request.getContextPath()%>./LiveListAction.seed" method="post">
		<div style="border: 1px solid;">
			<div style="align: center; width: 497px; height: 30px; border: 1px solid; display: inline-block;">
				<div>
					<select name="board_category" style="height:31px;">
						<option>일상얘기</option>
						<option>직장얘기</option>
					</select>카테고리 선택
				</div>

			</div>
			<div>
				<div>글 제목</div>
			</div>
			<div style="display: inline-block;">
				<input  name="board_subject" id="board_subject" type="text">
			</div>

			<div>
				<div>
					<div>내용</div>
				</div>
				<div>
					<textarea rows="10" cols="30" id="ir1" name="content" style="width:650px; height:350px; "></textarea>
				</div>
			</div>

			<div>
				<div></div>
			</div>
			<div>
				<div>
					<input type=submit value="등록"> <input type=reset value="취소">
				</div>
			</div>
		</div>
	</form>
</body>
</html>
