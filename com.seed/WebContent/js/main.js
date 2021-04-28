/**
 * 
 */
$(document).ready(function() {
	$(".category-list").on("click",function(){
		$(".weeklybest-content_board-container").remove();
		let category_name = $(this).attr('value');
		alert($(this).attr('value'));
		$.ajax ({
			url:"./MainWeeklyBestList.seed",
			type : "POST",
			dataType : "json",
			data : {category_name},
			success : function(list){
				var div1 = '<div class="weeklybest-content_board">';
				var close = '</div>';
				$.each(list,function(item){
					var cell1 = '<div class="weeklybest_cell-1"><a href="<%=request.getContextPath()%>/NewsDetailAction.seed?board_num"'
								+item.board_num+'>${'+item.board_subject+'}</a></div>';
					var cell2 = '<div class="weeklybest_cell-2">${'+item.name+'}</div>';
					var cell3 = '<div class="weeklybest_cell-3"><fmt:formatDate value="${'+item.board_register+'}" pattern="yyyy-MM-dd"</div>';
					
					$("#weeklybest").append(div1);
					$("#weeklybest").append(cell1);
					$("#weeklybest").append(cell2);
					$("#weeklybest").append(cell3);
					$("#weeklybest").append(close);
					
				});
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



