$(function () {
	$("div[name='title']").click(function (){titleClick(this);});
	$("div[name='title']").next().hide();
	$("#guestTBody").delegate("#delSpan","click",function(){delSpanClick(this);});
	$("#guestTBody").delegate("span[name='upSpan']","click",function(){upSpanClick(this);});
});
var activityId = $("#id").val();
function upSpanClick(obj){
	var up = $(obj).attr("data_up");
	var id = $(obj).attr("data_id");
	$.ajax({
		type : "PUT",
		url  : activityId+"/guest/"+id,
		dataType : "json",
		data:up,
		success : function(data){
			if(data.statusCode == 200){
				initGuestTable();
			}
		},
		error:function(){
			$.Zebra_Dialog("调整顺序失败！", {
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
	$.Zebra_Dialog("确定删除该嘉宾吗？", {
		'type':     'information',
		'title':    '提示',
		'buttons':  ["取消","确定"],
		'onClose': function(caption) {
			var option=(caption != '' ? '"' + caption + '"' : 'nothing');
	        if(option=="\"确定\""){
	        	var id = $(obj).attr("data_id");
	        	$.ajax({
					type : "DELETE",
					url  : activityId+"/guest/"+id,
					dataType : "json",
					success : function(data){
						if(data.statusCode == 200){
							initGuestTable();
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
function initGuestTable(){
	var activityId = $("#id").val();
	$.ajax({
		type: "GET",
		url: activityId+"/guests",
		dataType : "json",
		contentType:'application/json;charset=UTF-8', 
		success: function(json) {
			if (json.statusCode == 200) {
				$("#guestTBody").empty();
				var guests = json.body.guests;
				var tr = "";
				for(var i=0;i<guests.length;i++){
					var guest = guests[i];
					tr+='<tr><td>'+guest.name+'</td><td>'+guest.position+'</td><td>'+guest.company+'</td><td>'+guest.researchArea+'</td><td>'+guest.phone+'</td><td>'+guest.rank+'</td><td><span name="upSpan" data_up="true" class="glyphicon glyphicon-arrow-up " data_id="'+guest.id+'"></span>  <span name="upSpan"  data_up="false" class="glyphicon glyphicon-arrow-down paddingleft20" data_id="'+guest.id+'"></span></td><td><span id="delSpan" class="glyphicon glyphicon-remove"  data_id="'+guest.id+'"></span></td></tr>';
				}
				$("#guestTBody").append(tr);
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
