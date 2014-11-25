$(function () {
	initCalendar("#ticketSaleStartTime");
	initCalendar("#ticketSaleEndTime");
	initCalendar("#ticketValidStartTime");
	initCalendar("#ticketValidEndTime");
	$("#nextBtn").click(nextBtnClick);
});
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
