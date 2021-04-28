$(function(){
	$('#like_btn').mouseover(function(){
		$('#like_btn').css("cursor","pointer");
	});
});

$(function(){
	$('#hate_btn').mouseover(function(){
		$('#hate_btn').css("cursor","pointer");
	});
});

// ----------------------------------------------------

$(function() {
	$('#like_btn').click(function() {
		$.ajax({
			type: "post",
			url : "/com.seed.www/LikeUpdate.seed",
			data : {"board_num" : num},
			success : function(data){
						$('#like_div').text(data);
						}
		});	// ajax 끝
	}); // click 끝
});

$(function() {
	$('#hate_btn').click(function() {
		$.ajax({
			type: "post",
			url : "/com.seed.www/HateUpdate.seed",
			data : {"board_num" : num},
			success : function(data){
						$('#hate_div').text(data);
						}
		});	// ajax 끝
	}); // click 끝
});

// --------------------------------------------------------
// 최신 jquery에선 toogle() -> toggleClass()로 변경되었다
// toggleClass() 실패..

/*$(function() {
	$('#hate_btn').click(function(){
		$('#hate_div').toggleClass(function() {
			$.ajax({
				type: "post",
				url : "/com.seed.www/HateUpdate.seed",
				data : {"board_num" : num},
				success : function(data){
							$('#hate_div').text(data);
							}
			}, function() {
				$.ajax({
				type: "post",
				url : "/com.seed.www/HateDownUpdate.seed",
				data : {"board_num" : num},
				success : function(data){
							$('#hate_div').text(data);
							}
				});	
			});
		});
	});
});*/

// ---------------------------------------------------------
// toggle() 실패

/*$(function() {
	$('#hate_btn').click(function(){
		$('#hate_div').toggle(function() {
			$.ajax({
				type: "post",
				url : "/com.seed.www/HateUpdate.seed",
				data : {"board_num" : num},
				success : function(data){
							$('#hate_div').text(data);
							}
			}, function() {
				$.ajax({
				type: "post",
				url : "/com.seed.www/HateDownUpdate.seed",
				data : {"board_num" : num},
				success : function(data){
							$('#hate_div').text(data);
							}
				});	
			});
		});
	});
});*/
