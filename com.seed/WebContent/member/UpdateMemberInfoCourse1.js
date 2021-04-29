$(function(){
	$("#confirm_btn").click(function(){
		if($("#pw").val() == "") {
			alert("비밀번호를 입력하세요.");
			$("#pw").focus();
			return false;
		}
	})
});