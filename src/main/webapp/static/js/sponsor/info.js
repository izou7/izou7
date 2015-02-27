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
	$("#saveBtn").click(function(){addSponsor()});
	$("#tagsDiv button").click(function(){tagsClicked(this)});
	initTags(tags);
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
			$("#tagsDiv").find("button[value='"+tagsArray[i]+"']").attr("class","btn btn-sm btn-danger");
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
function addSponsor(){
	var sponsor = {
			"tags":$("#tags").val(),
			"name":$("#name").val(),
			"posterUrl":$("#posterUrl").val(),
			"realName":$("#realName").val(),
			"phone":$("#phone").val(),
			"company":$("#company").val(),
			"position":$("#position").val(),
			"self":$("input[name='self']:checked").val(),
			"introduction":$("#introduction").val()
	};
	console.info(JSON.stringify(sponsor));
	$.ajax({
		type: "POST",
		url: "add",
		dataType : "json",
		data : JSON.stringify(sponsor),
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

