/*jslint unparam: true, regexp: true */
/*global window, $ */
$(function () {
	 'use strict';

	    $('#fileupload').fileupload({
	        url: 'upload',
			maxFileSize: 2000000,
			maxNumberOfFiles: 1,
			acceptFileTypes:/(\.|\/)(gif|jpe?g|png)$/i
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
	
	$("#nextBtn").click(nextBtnClick);
//	$("#fileupload").ajaxForm({
//		dataType:  "json",
//		success:    function( response ) {
//			if ( response.statusCode === 200 ) {
//				alert( response.message );
//			}
//		}
//	});
});
function beforeRequest(){
	var tags = $("#tags").val();
	if(!tags){
		$.Zebra_Dialog("活动标签不能为空！", {
			'type':     'information',
			'title':    '提示',
			'buttons':  ["确定"]
		});
		return false;
	}
	return true;
}
function nextBtnClick(){
	var inputJson = $("#fileupload").serialize();
	$.ajax({
		type: "GET",
		url: "add",
		dataType : "json",
		data : inputJson,
		contentType:'application/json;charset=UTF-8', 
		success: function(json) {
			if (json.statusCode == 200) {
				location.href="activity?step=SECOND&id="+json.body.id;
			}else {
				$.Zebra_Dialog(json.message, {
					'type':     'information',
					'title':    '提示',
					'buttons':  ["确定"]
				});
			}
		},
		fail : function(json){
			$.Zebra_Dialog('操作异常', {
				'type':     'information',
				'title':    '提示',
				'buttons':  ["确定"]
			});
		}
	}); 
	
}
function createAndValidate(){
}
function tagsClicked(obj){
	if($(obj).attr("class").indexOf("btn-info")!=-1){
		$(obj).attr("class",$(obj).attr("class").replace("btn-info","btn-danger"));
	}else{
		$(obj).attr("class",$(obj).attr("class").replace("btn-danger","btn-info"));
	}
	var tags = "";
	$("#tagsDiv button[class='btn btn-sm btn-danger']").each(function(index){
		if(index==0){
			tags+=$(this).text();
		}else{
			tags+="|"+$(this).text();
		}
	});
	$("#tags").val(tags);
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
