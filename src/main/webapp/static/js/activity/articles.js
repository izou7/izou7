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
	    	loadFilesTable();
	    	var fileName = data.files[0].name;
	    	files.remove(fileName);
	    }).bind('fileuploadsubmit', function(e,data){
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
	    		data.context.find('button').prop('disabled', false);
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
			$("#"+id).multiselect({numberDisplayed: 0,maxHeight: 250});
		}
	});
	
	
	
	$("#tagsDiv button").click(function(){tagsClicked(this)});
	$("#filesTable").click(function(e){filesTableClik(this,e)});
//	待研究。。。
//	$('button.cancel').click(function (e) {
//		alert(1);
//	    jqXHR.abort();
//	});
	$("#nextBtn").click(nextBtnClick);
	$("#tbodyId").delegate("button[name='delBtn']","click",function(){
		delArticle($(this).attr("data_id"));
		loadFilesTable();
	});
	$("#deployBtn").click(deployBtnClick);
	$('#navigation a').stop().animate({'marginLeft':'-85px'},1000);
    $('#navigation > li').hover(
        function () {
            $('a',$(this)).stop().animate({'marginLeft':'-2px'},200);
        },
        function () {
            $('a',$(this)).stop().animate({'marginLeft':'-85px'},200);
        }
    );
});
var id = $("#id").val();
function deployBtnClick(){
	$.ajax({
		type: "PUT",
		url: id+"/status",
		dataType : "json",
		data:"status=1",
		success: function(json) {
			if (json.statusCode == 200) {
				location.href="activity?step=SUCCESS&activityId="+id;
			}else {
				$.Zebra_Dialog('发布失败', {
					'type':     'information',
					'title':    '提示',
					'buttons':  ["确定"]
				});
			}
		},
		fail : function(json){
			$.Zebra_Dialog('发布异常', {
				'type':     'information',
				'title':    '提示',
				'buttons':  ["确定"]
			});
		}
	}); 
}
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
function delArticle(id){
	$.ajax({
		type: "DELETE",
		url: "article/"+id,
		dataType : "json",
		contentType:'application/json;charset=UTF-8', 
		success: function(json) {
			if (json.statusCode == 200) {
				$.Zebra_Dialog('删除文章成功', {
					'type':     'information',
					'title':    '提示',
					'buttons':  ["确定"]
				});
			}else {
				$.Zebra_Dialog('删除文章失败', {
					'type':     'information',
					'title':    '提示',
					'buttons':  ["确定"]
				});
			}
		},
		fail : function(json){
			$.Zebra_Dialog('删除文章异常', {
				'type':     'information',
				'title':    '提示',
				'buttons':  ["确定"]
			});
		}
	}); 
}
function loadFilesTable(){
	var arcitityId = $("#id").val();
	$.ajax({
		type: "GET",
		url: "articles",
		dataType : "json",
		data : "arcitityId="+arcitityId,
		contentType:'application/json;charset=UTF-8', 
		success: function(json) {
			if (json.statusCode == 200) {
				$("#tbodyId").empty();
				for(var i=0;i<json.body.articles.length;i++){
					var article = json.body.articles[i];
					$("#tbodyId").append('<tr><td>'+article.title+'</td><td>'+article.tags+'</td><td>'+(article.summary==null?"":article.summary)+'</td><td><a href="'+article.url+'"><span class="glyphicon glyphicon-download-alt"></span></a></td><td><button type="button" class="btn btn-info" name="delBtn" data_id="'+article.id+'">删除</button></td></tr>');
				}
			}else {
				$.Zebra_Dialog('获取文章列表失败', {
					'type':     'information',
					'title':    '提示',
					'buttons':  ["确定"]
				});
			}
		},
		fail : function(json){
			$.Zebra_Dialog('获取文章列表异常', {
				'type':     'information',
				'title':    '提示',
				'buttons':  ["确定"]
			});
		}
	}); 
}
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
	var arcitityId = $("#id").val();
	location.href="activity?step=THIRD&activityId="+arcitityId;
	
}

