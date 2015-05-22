$(function () {
	$("#saveBtn").click(function(){addCommunity()});
	//$(".tag").click(function(){tagsClicked(this)});
	//initTags(tags);
	$("#province").change(function(){provinceChange(this)});
	//$('#originalImg').Jcrop();
	//animHandler([217,122,382,284]);
	//$("#uploadBtn").click(uploadBtnClick);
	$("#fileInput").change(fileInputChanged);
});
function fileInputChanged(){
	
	var file = $("#fileInput").val();
	if(file){
		//$("#uploadBtn").css("display","block");
		uploadBtnClick();
	}else{
		//$("#uploadBtn").css("display","none");
	}
}
function uploadBtnClick(){
    ajaxFileUpload();
}
function ajaxFileUpload() {
	$.ajaxFileUpload
	(
	    {
	    url: '/fileUpload/upload', //用于文件上传的服务器端请求地址
	    secureuri: false, //是否需要安全协议，一般设置为false
	    fileElementId: 'fileInput', //文件上传域的ID
	    dataType: 'json', //返回值类型 一般设置为json
	    success: function (data, status)  //服务器成功响应处理函数
	    {
	    	if(data.statusCode==200){
	    		$("#posterUrl").attr("src",data.body.urls[0]);
	    		$("#posterUrl").css("display","block");
	    	}else{
	    		showMessage(data.message);
	    	}
	    },
	    error: function (data, status, e)//服务器响应失败处理函数
        {
        	showMessage("上传失败！");
        	showMessage(data.responseBody.message);
        }
	    }
	    )
	    return false;
	}
function animHandler(v) {
	return function() {
		jcrop_api.animateTo(v);
		return false;
	};
};
function initTags(tags){
	if(tags){
		var tagsArray = tags.split(",");
		for(var i=0;i<tagsArray.length;i++){
			$("a[value='"+tagsArray[i]+"']").removeClass("tag").addClass("tag2");
		}
	}
}

function addCommunity(){
	var action = "/community/add";
	var poster = $("#posterUrl").attr("src");
	var price = $.trim($("#price").val().replace("元 人/月","").replace("元","").replace("人","").replace("月","").replace("/",""));
	try{ 
		price = parseInt(price);
	}catch(e){ 
		showMessage("价格格式错误，请填入正整数的价格！");
		return;
	}
	var community = {
			"id":parseInt($("#id").val()),
			"tags":$("#tags").val(),
			"name":$("#name").val(),
			"cityId":parseInt($("#city").val()),
			"address":$("#address").val(),
			"description":$("#description").val(),
			"realName":$("#realName").val(),
			"phone":$("#phone").val(),
			"publicNumber":$("#publicNumber").val(),
			"poster":poster,
			"price":price
	};
	if($.trim($("#id").val())!=""){
		action = "/community/update";
	}
	console.info(JSON.stringify(community));
	$.ajax({
		type: "POST",
		url: action,
		dataType : "json",
		data : JSON.stringify(community),
		contentType:'application/json;charset=UTF-8', 
		success: function(json) {
			if (json.statusCode == 200) {
					//showMessage("操作成功");
				location.href = "/community/manager";
			}else {
				showMessage(json.message);
			}
		},
		error : function(json){
			showMessage("操作异常，请检查网络！");
		}
	}); 
	
}


function tagsClicked(obj){
//	if($(obj).attr("class").indexOf("btn-info")!=-1){
//		$(obj).attr("class",$(obj).attr("class").replace("btn-info","btn-danger"));
//	}else{
//		$(obj).attr("class",$(obj).attr("class").replace("btn-danger","btn-info"));
//	}
//	var tags = "";
//	$("#tagsDiv button[class='btn btn-sm btn-danger']").each(function(index){
//		if(index==0){
//			tags+=$(this).text();
//		}else{
//			tags+=","+$(this).text();
//		}
//	});
//	$("#tags").val(tags);
	//$("#tagsDiv").find("a[value='"+tagsArray[i]+"']").removeClass("tag").addClass("tag2");
	if($(obj).attr("class")=="tag2"){
		$(obj).removeClass("tag2").addClass("tag");
	}else{
		$(obj).removeClass("tag").addClass("tag2");
	}
	var tags = "";
	$("a[class='tag2']").each(function(index){
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
					showMessage("获取城市失败！");
				}
			},
			error : function(json){
				showMessage("获取城市异常，请检查网络！");
			}
		});
	}
}
