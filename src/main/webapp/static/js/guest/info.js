$(function () {
	 'use strict';

	    $('#fileupload').fileupload({
	        url: '/upload',
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
	$("#saveBtn").click(function(){addGuest()});
	$("#tagsDiv4Adept button").click(function(){tagsClicked(this,"tagsDiv4Adept","adeptTags")});
	$("#tagsDiv4Interest button").click(function(){tagsClicked(this,"tagsDiv4Interest","interestTags")});
	//initTags(tags);
	$("input[name='self']").click(selfClicked);
	var realName = "";
	var company = "";
	var position = "";
	var phone = "";
});
	
function initTags(tags){
	if(tags){
		var tagsArray = tags.split(",");
		for(var i=0;i<tagsArray.length;i++){
			$("#tagsDiv4Adept").find("button[value='"+tagsArray[i]+"']").attr("class","btn btn-sm btn-danger");
		}
	}
}
function selfClicked(){
	if($("input[name='self']:checked").val()=="true"){
		realName = $("#realName").val(realName);
		phone  = $("#phone").val(phone);
		position  = $("#position").val(position);
		company  = $("#company").val(company);
	}else{
		realName = $("#realName").val();
		phone  = $("#phone").val();
		position  = $("#position").val();
		company  = $("#company").val();
		$("#realName").val("");
		$("#phone").val("");
		$("#position").val("");
		$("#company").val("");
	}
}
function addGuest(){
	var ways = "";
	$("input[name='ways']:checked").each(function(index){
		if(index==0){
			ways+=$(this).val();
		}else{
			ways+=","+$(this).val();
		}
	});
	var guest = {
			"interestTags":$("#interestTags").val(),
			"adeptTags":$("#adeptTags").val(),
			"ways":ways,
			"posterUrl":$("#posterUrl").val(),
			"realName":$("#realName").val(),
			"phone":$("#phone").val(),
			"company":$("#company").val(),
			"position":$("#position").val(),
			"self":$("input[name='self']:checked").val(),
	};
	console.info(JSON.stringify(guest));
	$.ajax({
		type: "POST",
		url: "add",
		dataType : "json",
		data : JSON.stringify(guest),
		contentType:'application/json;charset=UTF-8', 
		success: function(json) {
			if (json.statusCode == 200) {
					$.Zebra_Dialog('保存成功', {
						'type':     'information',
						'title':    '提示',
						'buttons':  ["确定"],
						'onClose': function(caption) {
							location.href = "index";
						}
					});
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


function tagsClicked(obj,divId,tagsId){
	if($(obj).attr("class").indexOf("btn-info")!=-1){
		$(obj).attr("class",$(obj).attr("class").replace("btn-info","btn-danger"));
	}else{
		$(obj).attr("class",$(obj).attr("class").replace("btn-danger","btn-info"));
	}
	var tags = "";
	$("#"+divId+" button[class='btn btn-sm btn-danger']").each(function(index){
		if(index==0){
			tags+=$(this).text();
		}else{
			tags+=","+$(this).text();
		}
	});
	$("#"+tagsId).val(tags);
}

