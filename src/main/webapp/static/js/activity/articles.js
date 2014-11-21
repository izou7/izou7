/*jslint unparam: true, regexp: true */
/*global window, $ */
var files = [];
var initFlag = false;
$(function () {
	 'use strict';
	    $('#fileupload').fileupload({
	        url: 'uploadArticles',
	        maxFileSize: 10000000,
			maxNumberOfFiles: 3,
			multipart:true,
			singleFileUploads:true,
			acceptFileTypes:/(\.|\/)(doc|docx|txt|pdf|wps)$/i
	    }).bind('fileuploadadd', function (e, data) {
	    	var fileName = data.files[0].name;
	    	for(var i=0;i<files.length;i++){
	    		if(fileName==files[i]){
	    			$.Zebra_Dialog("上传文章名有重复！", {
	    				'type':     'information',
	    				'title':    '提示',
	    				'buttons':  ["确定"]
	    			});
	    			return false;
	    		}
	    	}
	    	files.push(fileName);
	    }).bind('fileuploaddone', function (e, data) {
	    	var fileName = data.files[0].name;
	    	files.remove(fileName);
	    }).bind('fileuploadsend', function (e, data) {
	    	var title = $(e.target).parent().children().find("input[name^='title']").val();
	    	var tags = $(e.target).parent().children().find("select[name^='multiple']").val();
	    	if(title&&tags){
	    		return true;
	    	}else{
	    		$.Zebra_Dialog("标题和标签不能为空！", {
    				'type':     'information',
    				'title':    '提示',
    				'buttons':  ["确定"]
    			});
	    		return false;
	    	}
	    });

	    $('#fileupload').fileupload(
	        'option',
	        'redirect',
	        window.location.href.replace(
	            /\/[^\/]*$/,
	            '/cors/result.html?%s'
	        )
	    );
	$(".files").bind("DOMNodeInserted",function(e){
		if($(e.target).is("tr")){
			var id = $(e.target).children().find("select[id^=multiple]").attr("id");
			$("#"+id).multiselect({numberDisplayed: 0});
		}
	});
	
	
	$("#tagsDiv button").click(function(){tagsClicked(this)});
	$("#filesTable").click(function(e){filesTableClik(this,e)});
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
Array.prototype.indexOf = function(val) {            
	for (var i = 0; i < this.length; i++) {
		if (this[i] == val) return i;
	}
	return -1;
};
Array.prototype.remove = function(val) {
	var index = this.indexOf(val);
	if (index > -1) {
		this.splice(index, 1);
	}
};

function filesTableClik(obj,e){
	if($(e.target).is("button[name='cancelBtn']")||$(e.target).parent().is("button[name='cancelBtn']")){
		var taget;
		if($(e.target).is("button[name='cancelBtn']")){
			target = $(e.target);
		}else{
			target = $(e.target).parent();
		}
		var fileName = target.parent().parent().children().find(".name").text();
		files.remove($.trim(fileName));
	}
}
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
