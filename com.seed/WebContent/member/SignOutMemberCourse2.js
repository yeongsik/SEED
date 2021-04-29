$(function(){
	$("#check_agree").click(function(){
		var check = $(this).prop("checked");
		
		if(check == true) {
			$("#submit_btn").css({"backgroundColor": "rgb(39,174,96)", "cursor":"pointer","color":"white"}).prop("disabled",false);
		} else {
			$("#submit_btn").css({"backgroundColor": "rgb(94,94,94)", "cursor":"not-allowed","color":"white"}).prop("disabled",true);
		}
		
	});

});