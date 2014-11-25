$(function () {
	initCalendar("#ticketSaleStartTime");
	initCalendar("#ticketSaleEndTime");
	initCalendar("#ticketValidStartTime");
	initCalendar("#ticketValidEndTime");
	var options = {
			dataType:"json",
			error:errorHandler,
			success:successHandler,
			target:"button[name='save']",
			type:"POST"
	}
	$('#ticketForm').ajaxForm(options);
	$("#saveBtn").click(function (){$("#submitType").val("save");});
	$("#nextBtn").click(function (){$("#submitType").val("next");});
});
function errorHandler(){
	$.Zebra_Dialog("操作异常", {
		'type':     'information',
		'title':    '提示',
		'buttons':  ["确定"]
	});
}
function successHandler(responseText,statusText,xhr,$form){
	var submitType = $("#submitType").val();
	if(submitType=="save"){
		$.Zebra_Dialog("操作成功", {
			'type':     'information',
			'title':    '提示',
			'buttons':  ["确定"]
		});
	}else{
		location.href='activity?step=SIXTH&activityId='+$("#id").val();
	}
}
function nextBtnClick(){
	   
	var ticket = JSON.stringify($("#ticketForm").serializeObject());
	var activityId = $("#id").val();
	console.info(ticket);
	return;
	$.ajax({
		type: "POST",
		url: activityId+"/ticket",
		dataType : "json",
		data : ticket,
		contentType:'application/json;charset=UTF-8', 
		success: function(json) {
			if (json.statusCode == 200) {
				location.href="activity?step=SIXTH&activityId="+activityId;
			}else {
				$.Zebra_Dialog("操作失败", {
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
