$(function() {
	$("#idcheck").click(function(){
		if($("#id").val()=="") {
			alert("ID를 입력하세요.");
			$("#id").focus();
			return false;
		} else {
			var id = $("#id").val();
			
			$.ajax({
				type : "post",
				url : "/com.seed.www/IdcheckAction.seed",
				data : {"id": id},
				datatype : "text",
				success : function(data) {
					if(data == 1) {
						$("#myid").text("중복된 ID 입니다.");
						$("#id").val("").focus();
					} else {
						$("#myid").text("사용 가능한 ID 입니다.");
						$("#pw").focus();
					}
				}	
			});
		};
	});
	
	$("form").submit(function(){
		if($("#id").val() == "") {
			alert("ID를 입력하세요.");
			$("#id").focus();
			return false;
		} 
		if($("#pw").val() == "") {
			alert("비밀번호를 입력하세요.");
			$("#pw").focus();
			return false;
		}
		if($("#name").val() == "") {
			alert("닉네임을 입력하세요.");
			$("#name").focus();
			return false;
		}
		
	});
	
	
});

