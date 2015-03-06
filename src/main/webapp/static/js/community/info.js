$(function () {
	$("#saveBtn").click(function(){addCommunity()});
	$("#tagsDiv button").click(function(){tagsClicked(this)});
	initTags(tags);
	$("#province").change(function(){provinceChange(this)});
});
	
function initTags(tags){
	if(tags){
		var tagsArray = tags.split(",");
		for(var i=0;i<tagsArray.length;i++){
			$("#tagsDiv").find("button[value='"+tagsArray[i]+"']").attr("class","btn btn-sm btn-danger");
		}
	}
}

function addCommunity(){
	var action = "/community/add";
	var community = {
			"id":$("#id").val(),
			"tags":$("#tags").val(),
			"name":$("#name").val(),
			"cityId":parseInt($("#city").val()),
			"address":$("#address").val(),
			"description":$("#description").val()
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
					$.Zebra_Dialog('保存成功', {
						'type':     'information',
						'title':    '提示',
						'buttons':  ["确定"],
						'onClose': function(caption) {
							location.href = "/community/listPage";
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
