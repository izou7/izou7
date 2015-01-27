$(function () {
    $('#slider').flexslider({  
        playAfterPaused: 3000,  
        animation: "fade",  
        animationLoop: true,  
        smoothHeight: true,  
        animationSpeed: 5000  
    });  
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
					var introduction = act.introduction;
					if(introduction&&introduction.length>50){
						introduction = introduction.substr(0,50);
					}
					var place = act.place;
					if(place&&place.length>50){
						place = place.substr(0,50);
					}
					var name = act.name;
					if(name&&name.length>50){
						name = name.substr(0,50);
					}
					html+='<div class="row" >'+
						'<div class="media ">'+
						  '<div class="media-body">'+
						    '<div class="caption title">'+
								       '<a href="/activity/info/1/'+act.id+'" title="'+act.name+'">'+name+
								      '</a>'+
								      '<p>'+
											'活动简介：'+introduction+
										'</p>'+
										'<p>'+
											'活动时间： '+act.startTime+
										'</p>'+
										'<p>'+
											'活动地点：'+place+
										'</p>'+
								      '</div>'+
						  '</div>'+
						    '<a class="media-right" href="#">'+
						    '<img src="'+act.poster+'" class="img-rounded">'+
						  '</a>'+
						'</div>'+
						'</div>';
				}
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
		error : function(json){
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
			size:"large",
			currentPage : currentPage,
			totalPages : pageObj.count,
			onPageClicked : function(event, originalEvent, type,
					page) {
				initActivities(page);
			}
	};
	$('#paginator').bootstrapPaginator(options);
}
