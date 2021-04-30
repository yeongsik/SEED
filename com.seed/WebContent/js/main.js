/**
 * 
 */
$(document).ready(function() {
	
	$(".category-list").on("click",function(){
		$("#ajax").remove();
		let category_name = $(this).attr('value');
		$.ajax ({
			url:"./MainWeeklyBestList.seed",
			type : "POST",
			dataType : "json",
			data : {category_name},
			success : function(list){
				var cell= '';
				$.each(list,function(index,item){
					//let date = item.board_register;
					cell += '<div id="ajax"><div class="weeklybest-content_board">'
					cell +=	'<div class="weeklybest_cell-1">'
					cell +=	'<a href="<%=request.getContextPath()%>/NewsDetailAction.seed?board_num='+item.board_num+'">'+item.board_subject+'</a></div>';
					cell += '<div class="weeklybest_cell-2">'+item.name+'</div>';
					cell += '<div class="weeklybest_cell-3">'+item.board_register+'</div></div></div>';
					
					//$(".weeklybest-content_board-container").append(cell);
					console.log(cell)
				});
					$(".weeklybest-content_board-container").html(cell);
			}
		});
	});
});

function isElementUnderBottom(elem , triggerDiff) {
    const { top } =elem.getBoundingClientRect();
    const { innerHeight } =window;
    return top > innerHeight + (triggerDiff || 0);
};

function handleScroll() {
    const elems = document.querySelectorAll('.fade-in');
    elems.forEach(elem => {
        if(isElementUnderBottom(elem, -20)) {
            elem.style.opacity ="0";
            elem.style.transform = 'translateY(100px)';
        } else {
            elem.style.opacity ="1";
            elem.style.transform = 'translateY(0)';
        };
    });
};

window.addEventListener('scroll' , handleScroll);

/*function getFormatDate(date) {
	var year =date.getFullYear();
	var month = (1 + date.getMonth());
	month = month >= 10 ? month : '0' + month;
	var day = date.getDate();
	day = day >= 10 ? day : '0' +day;
	return year + '-' + month + '-' + day;
}
*/



