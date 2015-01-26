$(function () {
	initPaginator();
	function initPaginator(){
		var options = {
				currentPage: currentPage+1,
				totalPages: totalPages,
				useBootstrapTooltip:true,
				tooltipTitles: function (type, page, current) {
					switch (type) {
						case "first":
							return "Go To First Page";
		                case "prev":
		                    return "Go To Previous Page";
		                case "next":
		                    return "Go To Next Page";
		                case "last":
		                    return "Go To Last Page";
		                case "page":
		                    return "Go to page " + page;
					}
				},
				bootstrapTooltipOptions: {
					html: true,
					placement: 'bottom'
				},
				onPageClicked:function(event, originalEvent, type,page){
					$("input[name='index']").val(page);
					$("#paging-form").submit();
				}
		};
		$('#paginator').bootstrapPaginator(options);
	}
});