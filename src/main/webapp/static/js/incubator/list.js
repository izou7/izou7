$(function () {
	initIncubators(1);
});
function initIncubators(index){
	$.ajax({
		type: "GET",
		url: "incubators",
		dataType : "json",
		contentType:'application/json;charset=UTF-8',
		data:"index="+index,
		success: function(json) {
			if (json.statusCode == 200) {
				$("#incubators").empty();
				var ibts = json.body.incubators;
				var html = "";
				for(var i=0;i<ibts.length;i++){
					var ibt = ibts[i];
					var introduction = ibt.introduction;
					if(introduction&&introduction.length>50){
						introduction = introduction.substr(0,50);
					}
					var address = ibt.address;
					if(address&&address.length>50){
						address = address.substr(0,50);
					}
					var name = ibt.name;
					if(name&&name.length>50){
						name = name.substr(0,50);
					}
					html+='<div class="media">'+
				      '<a class="media-left" href="incubatorPage?id='+ibt.id+'">'+
				        '<img class="media-object" src="'+ibt.littlePosterUrl+'" >'+
				      '</a>'+
				      '<div class="media-body">'+
				        '<h4 class="media-heading">'+name+'</h4>'+
				        '<p>'+introduction+'</p>'+
				        '<p>'+address+'</p>'+
				        '<a href="incubatorPage?id='+ibt.id+'">more</a>'+
				      '</div>'+
				    '</div>'
				}
				$("#incubators").append(html);
				initPaginator(json.body.page);
			}else {
				$.Zebra_Dialog("获取孵化器数据失败", {
					'type':     'information',
					'title':    '提示',
					'buttons':  ["确定"]
				});
			}
		},
		error : function(json){
			$.Zebra_Dialog('获取孵化器数据异常', {
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
				initIncubators(page);
			}
	};
	$('#paginator').bootstrapPaginator(options);
}
