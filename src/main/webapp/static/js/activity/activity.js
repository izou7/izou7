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

	initCalendarSecond("#startTime");
	initCalendarSecond("#endTime");
	var ue = UM.getEditor('editor');
	ue.addListener('blur',function(){
        $('#introduction').val(UM.getEditor('editor').getContent());
    });
    /**$('.form_datetime').datetimepicker({
        //language:  'fr',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		forceParse: 0,
        showMeridian: 1
    });**/
	initTags(tags);
	
	$("#tagsDiv button").click(function(){tagsClicked(this)});
	$("#province").change(function(){provinceChange(this)});
	
	$("#nextBtn").click(nextBtnClick);
	$("#saveBtn").click(saveBtnClick);
	$("#deployBtn").click(deployBtnClick);
	$('#navigation a').stop().animate({'marginLeft':'-50px'},1000);
//    $('#navigation > li').hover(
//        function () {
//            $('a',$(this)).stop().animate({'marginLeft':'-2px'},200);
//        },
//        function () {
//            $('a',$(this)).stop().animate({'marginLeft':'-85px'},200);
//        }
//    );
//	$("#fileupload").ajaxForm({
//		dataType:  "json",
//		success:    function( response ) {
//			if ( response.statusCode === 200 ) {
//				alert( response.message );
//			}
//		}
//	});
});
function initTags(tags){
	if(tags){
		var tagsArray = tags.split(",");
		for(var i=0;i<tagsArray.length;i++){
			$("#tagsDiv").find("button[value='"+tagsArray[i]+"']").attr("class","btn btn-sm btn-danger");
		}
	}
}
function saveBtnClick(){
	$("#type").val("SAVE");
	
	if(id){
		exeActivity("update");
	}else{
		exeActivity("add");
	}
}
function deployBtnClick(){
	$("#type").val("DEPLOY");
	var id = $("#id").val();
	if(id){
		exeActivity("update");
	}else{
		exeActivity("add");
	}
}
function nextBtnClick(){
	var id = $("#id").val();
	$("#type").val("NEXT");
	if(id){
//		location.href="activity?step=SECOND&activityId="+id;
		exeActivity("update");
	}else{
		exeActivity("add");
	}
}
function beforeRequest(){
//	var tags = $("#tags").val();
//	if(!tags){
//		$.Zebra_Dialog("活动标签不能为空！", {
//			'type':     'information',
//			'title':    '提示',
//			'buttons':  ["确定"]
//		});
//		return false;
//	}
//	return true;
}

function exeActivity(url){
	var inputJson = $("#fileupload").serialize();
	$.ajax({
		type: "GET",
		url: url,
		dataType : "json",
		data : inputJson,
		contentType:'application/json;charset=UTF-8', 
		success: function(json) {
			if (json.statusCode == 200) {
				var type = $.trim($("#type").val()); 
				
				if(type=="SAVE"){
					$.Zebra_Dialog('保存成功', {
						'type':     'information',
						'title':    '提示',
						'buttons':  ["确定"]
					});
					$("#id").val(json.body.id);
				}else if (type=="DEPLOY"){
					location.href="activity?step=SUCCESS&activityId="+json.body.id;
				}else{
					location.href="activity?step=SECOND&activityId="+json.body.id;
				}
			}else {
				$.Zebra_Dialog(json.message, {
					'type':     'information',
					'title':    '提示',
					'buttons':  ["确定"]
				});
			}
		},
		error : function(json){
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
			tags+=","+$(this).text();
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
					var citys = json.body.citys;
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
			error : function(json){
				$.Zebra_Dialog('获取城市失败！', {
					'type':     'information',
					'title':    '提示',
					'buttons':  ["确定"]
				});
			}
		});
	}
}
