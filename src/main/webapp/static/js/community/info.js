$(function () {
	$("#saveBtn").click(function(){addCommunity()});
	$(".tag").click(function(){tagsClicked(this)});
	initTags(tags);
	$("#province").change(function(){provinceChange(this)});
});
	
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
	var poster = $("#posterUrl").val(); 
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
			"poster":poster
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
					showMessage("操作成功");
			}else {
				showMessage(json.message);
			}
		},
		error : function(json){
			showMessage("操作异常，获取更多帮助，请联系管理员！");
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
