$(function () {
	$('#activityTab a').click(function (e) {
	    e.preventDefault();//取消事件的默认动作
	    $(this).tab('show');
	})
	initDeployedActivity();
	$("#deployedTBody").delegate("span[name='delSpan']","click",function(){delSpanClick(this);});
	$("#deployedTBody").delegate("span[name='editSpan']","click",function(){editSpanClick(this);});
});
function editSpanClick(obj){
	var id = $(obj).attr("data_id");
	location.href = id;
}
function delSpanClick(obj){
	$.Zebra_Dialog("确定删除该活动吗？", {
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
							initDeployedActivity();
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
});

function initDeployedActivity(){
	$.ajax({
		type: "GET",
		url: "deployedActivitys",
		dataType : "json",
		contentType:'application/json;charset=UTF-8', 
		success: function(json) {
			if (json.statusCode == 200) {
				$("#deployedTBody").empty();
				var acts = json.body.deployedActivitys;
				var tr = "";
				for(var i=0;i<acts.length;i++){
					var act = acts[i];
					tr+='<tr><td><img src="'+act.poster+'" height="50" width="50"></td><td>'+act.deployTime+'</td><td>'+act.updateTime+'</td><td>'+act.name+'</td><td><span name="delSpan" class="glyphicon glyphicon-remove"  data_id="'+act.id+'"></span><span name="editSpan" class="glyphicon glyphicon-edit margin-left50"  data_id="'+act.id+'"></span></td>';
					console.info(act);
					tr+='<tr><td><img src="'+act.activityPosters[0].poster+'" height="50" width="50"></td><td>'+act.createTime+'</td><td>'+act.updateTime+'</td><td>'+act.name+'</td><td><span name="delSpan" class="glyphicon glyphicon-remove"  data_id="'+act.id+'"></span><span name="editSpan" class="glyphicon glyphicon-edit margin-left50"  data_id="'+act.id+'"></span></td>';
				}
				$("#deployedTBody").append(tr);
				initPaginator4Deployed(json.body.page);
			}else {
				$.Zebra_Dialog("获取活动嘉宾失败", {
					'type':     'information',
					'title':    '提示',
					'buttons':  ["确定"]
				});
			}
		},
		fail : function(json){
			$.Zebra_Dialog('获取活动嘉宾异常', {
				'type':     'information',
				'title':    '提示',
				'buttons':  ["确定"]
			});
		}
	}); 
}
function initPaginator4Deployed(pageObj) {
	var currentPage = pageObj.index + 1;
	var options = {
		currentPage : currentPage,
		totalPages : pageObj.count,
		onPageClicked : function(event, originalEvent, type,
				page) {
			
		}
	};
    $('#deployedPaginator').bootstrapPaginator(options);
}
