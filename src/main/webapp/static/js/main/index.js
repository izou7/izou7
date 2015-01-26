$(function () {
	initActivities(1);
});
function initActivities(index){

	$.ajax({
		type: "GET",
		url: "activities",
		dataType : "json",
		contentType:'application/json;charset=UTF-8',
		data:"index="+index,
		success: function(json) {
			if (json.statusCode == 200) {
				$("#activities").empty();
				var acts = json.body.activities;
				var html = "";
				for(var i=0;i<acts.length;i++){
					var act = acts[i];
					html+='<div class="row" >'+
						'<div class="media ">'+
						  '<div class="media-body">'+
						    '<div class="caption title">'+
								       '<a href="/activity/info/1/'+act.id+'" title="'+act.name+'">'+act.name+
								      '</a>'+
								      '<p>'+
											'活动简介：'+act.introduction+
										'</p>'+
										'<p>'+
											'活动时间： '+act.startTime+
										'</p>'+
										'<p>'+
											'活动地点：'+act.place+
										'</p>'+
								      '</div>'+
						  '</div>'+
						    '<a class="media-right" href="#">'+
						    '<img src="http://cdn.huodongxing.com/logo/201501/1266152895100/941849048837311_v2small.jpg" >'+
						  '</a>'+
						'</div>'+
						'</div>';
				}
				console.info(html);
				$("#activities").append(html);
				initPaginator(json.body.page);
			}else {
				$.Zebra_Dialog("获取活动失败", {
					'type':     'information',
					'title':    '提示',
					'buttons':  ["确定"]
				});
			}
		},
		fail : function(json){
			$.Zebra_Dialog('获取活动异常', {
				'type':     'information',
				'title':    '提示',
				'buttons':  ["确定"]
			});
		}
	}); 
}
function initPaginator(pageObj) {
	var currentPage = pageObj.index + 1;
	var options = {
			currentPage : currentPage,
			totalPages : pageObj.count,
			onPageClicked : function(event, originalEvent, type,
					page) {
				initActivities(page);
			}
	};
	$('#paginator').bootstrapPaginator(options);
}