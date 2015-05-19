$(function () {
	$("#pager").paginate({
			count 		: parseInt(count),
			start 		: parseInt(start)+1,
			display     : 10,
			border					: false,
			text_color  			: '#888',
			background_color    	: '#EEE',	
			text_hover_color  		: 'black',
			background_hover_color	: '#CFCFCF',
			onChange                : function(page){
				location.href = "/community/manager?id="+$("#communityId").val()+"&index="+page;
			}
		});
	//$("a[name='delete']").click(function(){deleteClicked(this);});
	$("div[name='communityArea']").click(function(){communityAreaClicked(this)});
	$("a[name='dynDeleteBtn']").click(function(){dynDeleteBtnClicked(this)});
	$("a[name='deleteMemBtn']").click(function(){deleteMemBtnClicked(this)});
	$("a[name='deleteComBtn']").click(function(){deleteComBtnClicked(this)});
	$("a[name='deleteMesBtn']").click(function(){deleteMesBtnClicked(this)});
	$("a[name='passBtn']").click(function(){passBtnClicked(this)});
	$("a[name='noPassBtn']").click(function(){noPassBtnClicked(this)});
	$("#deleteBtn").click(deleteBtnClicked);
});
function passBtnClicked(obj){
	execAudit($(obj).attr("data_id"),1);
}
function noPassBtnClicked(obj){
	execAudit($(obj).attr("data_id"),0);
}
function execAudit(id,pass){
	$.ajax({
		type : "PUT",
		url  : "/member/"+id+"/"+pass,
		dataType : "json",
		success : function(data){
			if(data.statusCode == 200){
				showMessage("操作成功");
				if(pass==0){
					$("#mem"+id).remove();
				}else{
//					$("#mem"+id).children(".mask_bg").attr("class","mask_bg").css("display","none");
//					$("#mem"+id).children(".mask_text").attr("class","mask_text").text("");
					location.reload();
				}
				
			}else{
				showMessage("操作失败");
			}
			
		},
		error:function(){
			showMessage("操作异常");
		}
	});
}
function deleteBtnClicked(){
	var type = $("#tempData").attr("data_type");
	var val =  $("#tempData").attr("data_value");
	var url;
	if(type=="com"){
		url = "/community/"+val; 
	}else if(type=="mem"){
		url = "/member/"+val;
	}else if(type=="dyn"){
		url = "/dynamic/"+val;
	}else if(type=="mes"){
		url = "/dynamicMessage/"+val;
	}
	$.ajax({
		type : "DELETE",
		url  : url,
		dataType : "json",
		success : function(data){
			$("#confirmBox").hide();
			if(data.statusCode == 200){
				$("#"+type+val).remove();
				$(".mask").hide();
			}else{
				
				$("#infoBox").show();
				$(".mask").show();
			}
			
		},
		error:function(){
			$("#confirmBox").hide();
			showMessage("删除异常，请联系管理员！");
		}
	});
}
function deleteMesBtnClicked(obj){
	var id = $(obj).attr("data_id");
	$("#tempData").attr("data_type","mes").attr("data_value",id);
	$("#confirmBox").show();
	$(".mask").show();
}
function deleteComBtnClicked(obj){
	var id = $(obj).attr("data_id");
	$("#tempData").attr("data_type","com").attr("data_value",id);
	$("#confirmBox").show();
	$(".mask").show();
}
function deleteMemBtnClicked(obj){
	var id = $(obj).attr("data_id");
	$("#tempData").attr("data_type","mem").attr("data_value",id);
	$("#confirmBox").show();
	$(".mask").show();
}
function dynDeleteBtnClicked(obj){
	var id = $(obj).parents("li").attr("data_id");
	$("#tempData").attr("data_type","dyn").attr("data_value",id);
	$("#confirmBox").show();
	$(".mask").show();
	
}
function communityAreaClicked(obj){
	$("li[name='communityLi']").removeClass("on")
	$(obj).parent("li").addClass("on")
	location.href = "/community/manager?id="+$(obj).parent("li").attr("data_id")+"&index="+0;
}

function deleteClicked (obj){
	$.Zebra_Dialog("确定删除该社区吗？", {
		'type':     'information',
		'title':    '提示',
		'buttons':  ["取消","确定"],
		'onClose': function(caption) {
			var option=(caption != '' ? '"' + caption + '"' : 'nothing');
	        if(option=="\"确定\""){
	        	var id = $(obj).attr("data_id");
	        	$.ajax({
					type : "DELETE",
					url  : id,
					dataType : "json",
					success : function(data){
						if(data.statusCode == 200){
							location.href = "/community/listPage";
						}
					},
					error:function(){
						$.Zebra_Dialog("删除失败！", {
							'type':     'information',
							'title':    '提示',
							'buttons':  ["确定"],
							'onClose': function(caption) {
							}
						});
					}
				});
			}
		}
		});
}
	

