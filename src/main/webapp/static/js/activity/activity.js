/*jslint unparam: true, regexp: true */
/*global window, $ */
$(function () {
	 'use strict';

	    $('#fileupload').fileupload({
	        url: 'upload',
			maxFileSize: 5000000,
			maxNumberOfFiles: 1
	    });

	    $('#fileupload').fileupload(
	        'option',
	        'redirect',
	        window.location.href.replace(
	            /\/[^\/]*$/,
	            '/cors/result.html?%s'
	        )
	    );
	
    initCalendar("#startTime");
	initCalendar("#endTime");
	
	$("#tagsDiv button").click(function(){tagsClicked(this)});
	$("#province").change(function(){provinceChange(this)});
	$("#fileupload").ajaxForm({
		dataType:  "json",
		success:    function( response ) {
			if ( response.statusCode === 200 ) {
				alert( response.message );
			}
		}
	});
});

function nextBtnClick(){
	
//	var inputJson = createAndValidate();
//	console.info(inputJson);
//	$.ajax({
//		type: "POST",
//		url: "add",
//		dataType : "json",
//		data : inputJson,
//		contentType:'application/json;charset=UTF-8', 
//		success: function(json) {
//			if (json.statusCode == 200) {
//				console.info(json);
//			}else {
//				$.Zebra_Dialog(json.message, {
//					'type':     'information',
//					'title':    '提示',
//					'buttons':  ["确定"]
//				});
//			}
//		},
//		fail : function(json){
//			$.Zebra_Dialog('操作异常', {
//				'type':     'information',
//				'title':    '提示',
//				'buttons':  ["确定"]
//			});
//		}
//	}); 
	
}
function createAndValidate(){
	var id = $("#id").val();
	var name = $("#name").val();
	var place = $("#address").val();
	var startTime = $("#startTime").val();
	var entTime = $("#endTime").val();
	var headCount = $("#num").val();
	var tags = "";
	var introduction = $("#introduction").val();
	var opened = $("#isPublic").val();
	var homepage = $("#homeUrl").val();
	var city = $("#city option:selected").val();
	var posterUrl = "";
	$("a[name='posterUrl']").each(function(){
		posterUrl = $(this).attr("href");
	});
	$("#tagsDiv button[class='btn btn-sm btn-danger']").each(function(index){
		if(index==0){
			tags+=$(this).text();
		}else{
			tags+="|"+$(this).text();
		}
	});
	var activity = {};
	activity.id = id;
	activity.name = name;
	activity.place = place;
	activity.startTime = startTime;
	activity.entTime = entTime;
	activity.headCount = headCount;
	activity.tags = tags;
	activity.introduction = introduction;
	activity.opened = opened;
	activity.homepage = homepage;
	activity.posterUrl = posterUrl;
//	activity.city = city;
	return JSON.stringify(activity);

}
function tagsClicked(obj){
	if($(obj).attr("class").indexOf("btn-info")!=-1){
		$(obj).attr("class",$(obj).attr("class").replace("btn-info","btn-danger"));
	}else{
		$(obj).attr("class",$(obj).attr("class").replace("btn-danger","btn-info"));
	}
}

function provinceChange(obj){
	if($(obj).val()!=0){
		var url = "/city/"+$(obj).val();
		$.ajax({
			type: "GET",
			url: url,
			dataType : "json",
			success: function(json) {
				$("#city").empty();
				if (json.statusCode == 200) {
					var citys = json.data.citys;
					if(citys){
						for(var i=0;i<citys.length;i++){
							$("#city").append('<option value="'+citys[i].id+'">'+citys[i].city+'</option>');
						}
					}
				}else {
					$.Zebra_Dialog('获取城市失败！', {
						'type':     'information',
						'title':    '提示',
						'buttons':  ["确定"]
					});
				}
			},
			fail : function(json){
				$.Zebra_Dialog('获取城市失败！', {
					'type':     'information',
					'title':    '提示',
					'buttons':  ["确定"]
				});
			}
		});
	}
}
