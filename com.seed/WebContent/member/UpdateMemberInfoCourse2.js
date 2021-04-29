$(function() {
	var checkName = 0;
	
	$("#checkName").click(function() {
			if($("#name").val()=="") {
				alert("변경할 닉네임을 입력하세요.");
				$("#name").focus();
				return false;
			} else {
				var name = $("#name").val();
				
				$.ajax({
					type : "post",
					url : "/com.seed.www/NameCheckAction.seed",
					data : {"name": name},
					datatype : "text",
					success : function(data) {
						if(data == 1) {
							checkName = -1;
							console.log("checkName fail : " + checkName);
							$("#display_CheckNameResult").text("중복된 닉네임 입니다.");
							$("#name").val("").focus();
						} else {
							checkName = 1;
							console.log("checkName success : " + checkName)
							$("#display_CheckNameResult").text("사용 가능한 닉네임 입니다.");
							$("#pw").focus();
						}
					}	
				});
			}
	});
		
	$("#update_btn").click(function(){
		console.log("checkName result : " + checkName);
		
		if($("#name").val()=="") {
			alert("닉네임을 입력하세요.");
			$("#name").focus();
			reload();
			return false;
		}
		
		if(checkName == 0) {
			alert("닉네임 중복 검사를 해야 합니다.");
			$("#name").focus();
			reload();
			return false;
		}
		
		if(checkName == -1) {
			alert("중복된 닉네임 입니다.");
			$("#name").val("").focus();
			reload();
			return false;
		}
		
		if($("#pw").val()=="") {
			alert("비밀번호를 입력하세요.");
			$("#pw").focus();
			return false;
		}
		if($("#checkPw").val()=="") {
			alert("비밀번호 확인란을 입력하세요.");
			$("#checkPw").focus();
			return false;
		}
		
		if($("#pw").val() != $("#checkPw").val()) {
			alert("비밀번호를 정확히 입력하세요.");
			$("#pw").val("").focus();
			$("#checkPw").val("");
			return false;
		}
	});
});