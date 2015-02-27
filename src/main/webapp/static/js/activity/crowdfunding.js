$(function () {
	var options = { 
			target:        '#save', 
			success:       successAdd,
			error:		   errorAdd,
			type:          "POST", 
			dataType:      "JSON"
	}; 
	var rewardOptions = { 
			target:        '#add', 
			success:       rewardSuccessAdd,
			error:		   errorAdd,
			type:          "POST", 
			dataType:      "JSON",
			clearForm:		true
	}; 
	$("#settingForm").ajaxForm(options);
	$("#rewardForm").ajaxForm(rewardOptions);
    initCalendar("#rewardStartTime");
	initCalendar("#rewardEndTime");
	$("#rewardTBody").delegate("#delSpan","click",function(){delSpanClick(this);});
	$("div[name='title']").click(function (){titleClick(this);});
	$("div[name='title']").next().hide();
	$("#add").click(function(){$("#submitType").val("add");});
	$("#deploy").click(function(){$("#submitType").val("deploy");});
});
var id = $("#id").val();
var activityId = $("#id").val();

function titleClick(obj){
	$(obj).next().slideToggle("slow");
}

function rewardSuccessAdd(){
	$.Zebra_Dialog("添加成功！", {
		'type':     'information',
		'title':    '提示',
		'buttons':  ["确定"],
		'onClose': function(caption) {
			initRewardTable();
		}
	});
}
function initRewardTable(){
	var activityId = $("#id").val();
	$.ajax({
		type: "GET",
		url: activityId+"/activityCrowdfunding/rewards",
		dataType : "json",
		contentType:'application/json;charset=UTF-8', 
		success: function(json) {
			if (json.statusCode == 200) {
				$("#rewardTBody").empty();
				var rewards = json.body.rewards;
				var tr = "";
				for(var i=0;i<rewards.length;i++){
					var reward = rewards[i];
					tr+='<tr><td>'+reward.amount+'</td><td>'+reward.limit+'</td><td>'+reward.reward+'</td><td>'+reward.days+'</td><td><span id="delSpan" class="glyphicon glyphicon-remove" data_id="'+reward.id+'"></span></td></tr>';
				}
				$("#rewardTBody").append(tr);
			}else {
				$.Zebra_Dialog("获取活动回报设置列表失败", {
					'type':     'information',
					'title':    '提示',
					'buttons':  ["确定"]
				});
			}
		},
		error : function(json){
			$.Zebra_Dialog('获取活动回报设置列表异常', {
				'type':     'information',
				'title':    '提示',
				'buttons':  ["确定"]
			});
		}
	}); 
}
function delSpanClick(obj){
	$.Zebra_Dialog("确定删除该回报设置吗？", {
		'type':     'information',
		'title':    '提示',
		'buttons':  ["取消","确定"],
		'onClose': function(caption) {
			var option=(caption != '' ? '"' + caption + '"' : 'nothing');
	        if(option=="\"确定\""){
	        	var id = $(obj).attr("data_id");
	        	$.ajax({
					type : "DELETE",
					url  : "activityCrowdfunding/reward/"+id,
					dataType : "json",
					success : function(data){
						if(data.statusCode == 200){
							initRewardTable();
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
function successAdd(){
	var type = $("#submitType").val();
	if(type=="deploy"){
		location.href='activity?step=SUCCESS&activityId='+id;
	}else{
		$.Zebra_Dialog("添加成功！", {
			'type':     'information',
			'title':    '提示',
			'buttons':  ["确定"],
			'onClose': function(caption) {
			}
		});		
	}

}
function errorAdd(){
	$.Zebra_Dialog("添加失败！", {
		'type':     'information',
		'title':    '提示',
		'buttons':  ["确定"],
		'onClose': function(caption) {
		}
	});
}

