$(function () {
	$("div[name='title']").click(function (){titleClick(this);});
	$("div[name='title']").next().hide();
	$("#tagsDiv button").click(function(){tagsClicked(this)});
	$("#cooperationTBody").delegate("#delSpan","click",function(){delSpanClick(this);});
	var options = { 
	        target:        '#add', 
	        success:       successAdd,
	        error:		   errorAdd,
	        type:          "POST", 
	        dataType:      "JSON",
	        clearForm:		true
	    }; 
	$("#cooperationForm").ajaxForm(options);
	$("#addSpan").click(function(){addSpanClick(this);});
});
var id = $("#id").val();
var activityId = $("#id").val();
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
function successAdd(data){
	if(data.statusCode == 200){
		$.Zebra_Dialog("添加活动开放合作成功！", {
			'type':     'information',
			'title':    '提示',
			'buttons':  ["确定"],
			'onClose': function(caption) {
				initCooperationTable();
			}
		});		
	}else{
		$.Zebra_Dialog(data.message, {
			'type':     'information',
			'title':    '提示',
			'buttons':  ["确定"]
		});	
	}

}
function errorAdd(){
	$.Zebra_Dialog("添加活动开放合作失败！", {
		'type':     'information',
		'title':    '提示',
		'buttons':  ["确定"],
		'onClose': function(caption) {
		}
	});
}

function addSpanClick(obj){
	var id = $(obj).attr("data_id");
	$.ajax({
		type : "POST",
		url  : activityId+"/cooperation/"+id,
		dataType : "json",
		success : function(data){
			if(data.statusCode == 200){
				$.Zebra_Dialog("添加开放合作成功！", {
					'type':     'information',
					'title':    '提示',
					'buttons':  ["确定"],
					'onClose': function(caption) {
						initCooperationTable();
					}
				});				
			}else{
				$.Zebra_Dialog(data.message, {
					'type':     'information',
					'title':    '提示',
					'buttons':  ["确定"],
					'onClose': function(caption) {
						initCooperationTable();
					}
				});	
			}
		},
		error:function(){
			$.Zebra_Dialog("新增开放合作失败！", {
				'type':     'information',
				'title':    '提示',
				'buttons':  ["确定"],
				'onClose': function(caption) {
				}
			});
		}
	});
}
function delSpanClick(obj){
	$.Zebra_Dialog("确定删除该开放合作吗？", {
		'type':     'information',
		'title':    '提示',
		'buttons':  ["取消","确定"],
		'onClose': function(caption) {
			var option=(caption != '' ? '"' + caption + '"' : 'nothing');
	        if(option=="\"确定\""){
	        	var id = $(obj).attr("data_id");
	        	$.ajax({
					type : "DELETE",
					url  : "cooperation/"+id,
					dataType : "json",
					success : function(data){
						if(data.statusCode == 200){
							initCooperationTable();
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
function titleClick(obj){
	$(obj).next().slideToggle("slow");
}
function initCooperationTable(){
	var activityId = $("#id").val();
	$.ajax({
		type: "GET",
		url: activityId+"/cooperations",
		dataType : "json",
		contentType:'application/json;charset=UTF-8', 
		success: function(json) {
			if (json.statusCode == 200) {
				$("#cooperationTBody").empty();
				var cpts = json.body.cpts;
				var tr = "";
				for(var i=0;i<cpts.length;i++){
					var cpat = cpts[i];
					var isMine = cpat.mine==true?"是":"否";
					tr+='<tr><td>'+cpat.wechatId+'</td><td>'+cpat.publicName+'</td><td>'+(cpat.description==null?"":cpat.description)+'</td><td>'+isMine+'</td><td><span id="delSpan" class="glyphicon glyphicon-remove" data_id="'+cpat.id+'"></span></td></tr>';
				}
				$("#cooperationTBody").append(tr);
			}else {
				$.Zebra_Dialog("获取活动开放合作失败", {
					'type':     'information',
					'title':    '提示',
					'buttons':  ["确定"]
				});
			}
		},
		fail : function(json){
			$.Zebra_Dialog('获取活动开放合作异常', {
				'type':     'information',
				'title':    '提示',
				'buttons':  ["确定"]
			});
		}
	}); 
}
