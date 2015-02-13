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
	    $("#saveBtn").click(function(){addSite()});
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
	$("#tagsDiv button").click(function(){tagsClicked(this)});
	initTags(tags);
	$("#province").change(function(){provinceChange(this)});
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
function addSite(){
	var site = {
			"tags":$("#tags").val(),
			"name":$("#name").val(),
			"posterUrl":$("#posterUrl").val(),
			"cityId":$("#cityId").val(),
			"realName":$("#realName").val(),
			"phone":$("#phone").val(),
			"company":$("#company").val(),
			"position":$("#position").val(),
			"self":$("input[name='self']:checked").val(),
			"address":$("#address").val(),
			"introduction":$("#introduction").val()
	};
	$.ajax({
		type: "POST",
		url: "add",
		dataType : "json",
		data : JSON.stringify(site),
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

function beforeRequest(){

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
