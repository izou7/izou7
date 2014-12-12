$(function () {
	 $("a[name='template']").click(function(){templateClick(this);});
	 $("#nextBtn").click(nextBtnClick);
	 $("#deployBtn").click(deployBtnClick);
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
function nextBtnClick(){
	var id = $("a[name='template'][class='thumbnail selectedTemplate']").attr("data_id");
    var activityId = $("#id").val();
	$.ajax({
		type: "PUT",
		url: activityId+"/template/"+id,
		dataType : "json",
		contentType:'application/json;charset=UTF-8', 
		success: function(json) {
			if (json.statusCode == 200) {
				location.href="activity?step=FIFTH&activityId="+activityId;
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
function templateClick(obj){
	$("a[name='template']").attr("class","thumbnail");
	if($(obj).attr("class")=="thumbnail selectedTemplate"){
		$(obj).attr("class","thumbnail");
	}else{
		$(obj).attr("class","thumbnail selectedTemplate");
	}
}