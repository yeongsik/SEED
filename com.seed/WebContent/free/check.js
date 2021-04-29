$(function(){
	$("form").submit(function(){
		if($("#name").val()==""){
			alert('작성자명을 입력하세요');
			$("#name").focus();
			return false;
		}
		if($("#board_category").val()==0){
			alert('카테고리를 선택하세요.');
			return false;
		}
		if($("#board_subject").val()==""){
			alert("제목을 입력하세요");
			$("#board_subject").focus();
			return false;
		}
		if($("#board_content").val()==""){
			alert("내용을 입력하세요");
			$("#board_content").focus();
			return false;
		}
		/*if($("#passwd").val()==""){
			alert("비밀번호를 입력하세요");
			$("#passwd").focus();
			return false;
		}*/
	});
});