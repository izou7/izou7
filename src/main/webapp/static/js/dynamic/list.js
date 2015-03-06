$(function () {
	var currentPage = 1;
	initDynamics(currentPage);
	$("tbody[id$='TBody']").delegate("a[name='delete']","click",function(){delClick(this);});
	$("tbody[id$='TBody']").delegate("a[name='deleteMessage']","click",function(){delMessageClick(this);});
	$("tbody[id$='TBody']").delegate("tr[name='messageTR']","click",function(){messageTRClick(this);});
});
function messageTRClick(obj){
	if($("tr[name='message']").length>0){
		$("tr[name='message']").remove();
	}else{
		var id = $(obj).attr("data_id");
    	$.ajax({
			type : "GET",
			url  : "../dynamicMessage/"+id,
			contentType:'application/json;charset=UTF-8',
			dataType : "json",
			success : function(data){
				if(data.statusCode == 200){
					var messages = data.body.messages;
					var tr = "";
					if(messages.length==0){
						$.Zebra_Dialog("该状态暂无留言！", {
							'type':     'information',
							'title':    '提示',
							'buttons':  ["确定"],
							'onClose': function(caption) {
							}
						});
					}
					for(var i=0;i<messages.length;i++){
						var content = messages[i].username+"向"+messages[i].toUsername+"留言："+messages[i].content;
						var date = new Date(messages[i].createTime);
						var dateStr = date.Format("yyyy-MM-dd HH:mm:ss");
						if(content.lenght>50){
							content = content.substr(0,50)+"...";
						}
						var deleteStr = '<a name="deleteMessage" data_id="'+messages[i].id+'" href="#" title="删除留言"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>';
						tr += '<tr name="message" style="background-color:#f6f6f6;"><td colspan="2">'+content+'</td><td>'+dateStr+'</td><td>'+deleteStr+'</td></tr>';
					}
					$(obj).after(tr);
				}
			},
			error:function(){
				$.Zebra_Dialog("获取留言异常！", {
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
function delClick(obj){
	$.Zebra_Dialog("确定删除该动态吗？", {
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
							initDynamics(currentPage);
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
function delMessageClick(obj){
	$.Zebra_Dialog("确定删除该条留言吗？", {
		'type':     'information',
		'title':    '提示',
		'buttons':  ["取消","确定"],
		'onClose': function(caption) {
			var option=(caption != '' ? '"' + caption + '"' : 'nothing');
	        if(option=="\"确定\""){
	        	var id = $(obj).attr("data_id");
	        	$.ajax({
					type : "DELETE",
					url  : "/dynamicMessage/"+id,
					dataType : "json",
					success : function(data){
						if(data.statusCode == 200){
							$(obj).parent().parent().remove();
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

function initDynamics(index){
	var id = $("#id").val();
	$.ajax({
		type: "GET",
		url: id+"/list",
		dataType : "json",
		contentType:'application/json;charset=UTF-8',
		data:"index="+index,
		success: function(json) {
			if (json.statusCode == 200) {
				$("#dynamicTBody").empty();
				var dds = json.body.dds;
				var tr = "";
				for(var i=0;i<dds.length;i++){
					var date = new Date(dds[i].createTime);
					var dateStr = date.Format("yyyy-MM-dd HH:mm:ss");
					var content = dds[i].content;
					if(content.length>50){
						content = content.substr(0,50)+"...";
					}
					var deleteStr = '<a name="delete" data_id="'+dds[i].id+'" href="#" title="删除动态"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>';
					tr += '<tr name="messageTR" style="cursor:pointer" data_id="'+dds[i].id+'"><td>'+content+'</td><td>'+dds[i].username+'</td><td>'+dateStr+'</td><td>'+deleteStr+'</td></tr>';
				}
				$("#dynamicTBody").append(tr);
				initPaginator(json.body.page);
			}else {
				$.Zebra_Dialog("获取动态失败", {
					'type':     'information',
					'title':    '提示',
					'buttons':  ["确定"]
				});
			}
		},
		error : function(json){
			$.Zebra_Dialog('获取动态异常', {
				'type':     'information',
				'title':    '提示',
				'buttons':  ["确定"]
			});
		}
	}); 
}

function initPaginator(pageObj) {
	currentPage = pageObj.index + 1;
	var options = {
		currentPage : currentPage,
		totalPages : pageObj.count,
		onPageClicked : function(event, originalEvent, type,
				page) {
			initDynamics(page);
		}
	};
    $('#dynamicPaginator').bootstrapPaginator(options);
}