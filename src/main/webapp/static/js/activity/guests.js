$(function () {
	$("div[name='title']").click(function (){titleClick(this);});
	$("div[name='title']").next().hide();
	$("#guestTBody").delegate("#delSpan","click",function(){delSpanClick(this);});
	$("#guestTBody").delegate("span[name='upSpan']","click",function(){upSpanClick(this);});
	var options = { 
			target:        '#save', 
			success:       successResponse,
			error:		   errorResponse,
			type:          "POST", 
			dataType:      "JSON" 
	}; 
	var guestOptions = { 
	        target:        '#add', 
	        success:       successAdd,
	        error:		   errorAdd,
	        type:          "POST", 
	        dataType:      "JSON",
	        clearForm:		true
	    }; 
	$("#settingForm").ajaxForm(options);
	$("#guestForm").ajaxForm(guestOptions);
	$("#sysTBody").delegate("#sysAdd","click",function(){sysAddBtnClick(this);});
	$("#nextBtn").click(nextBtnClick);
	$("#saveBtn").click(saveBtnClick);
	$("#deployBtn").click(deployBtnClick);
	$('#navigation a').stop().animate({'marginLeft':'-85px'},1000);
    $('#navigation > li').hover(
        function () {
            $('a',$(this)).stop().animate({'marginLeft':'-2px'},200);
        },
        function () {
            $('a',$(this)).stop().animate({'marginLeft':'-85px'},200);
        }
    );	
});
var id = $("#id").val();
function saveBtnClick(){
	$("#type").val("SAVE");
}
function deployBtnClick(){
	$("#type").val("DEPLOY");
}
function nextBtnClick(){
	$("#type").val("NEXT");
}
function sysAddBtnClick(obj){
	var gid = $(obj).attr("data_id");
	$.ajax({
		type : "POST",
		url  : activityId+"/sysGuest/"+gid,
		dataType : "json",
		success : function(data){
			if(data.statusCode == 200){
				initGuestTable();
			}else{
				$.Zebra_Dialog(data.message, {
					'type':     'information',
					'title':    '提示',
					'buttons':  ["确定"],
					'onClose': function(caption) {
					}
				});
			}
		},
		error:function(){
			$.Zebra_Dialog("添加系统推荐用户失败！", {
				'type':     'information',
				'title':    '提示',
				'buttons':  ["确定"],
				'onClose': function(caption) {
				}
			});
		}
	});
}
function successAdd(data){
	if(data.statusCode!=200){
		$.Zebra_Dialog(data.message, {
			'type':     'information',
			'title':    '提示',
			'buttons':  ["确定"]
		});
	}else{
			initGuestTable();
	}
	
}
function errorAdd(){
	$.Zebra_Dialog("添加嘉宾失败！", {
		'type':     'information',
		'title':    '提示',
		'buttons':  ["确定"],
		'onClose': function(caption) {
		}
	});
}
function successResponse(data){
	var type = $("#type").val();
	if(data.statusCode==200){
		if(type=="DEPLOY"){
			location.href="activity?step=SUCCESS&activityId="+id;
		}else if(type=="NEXT"){
			location.href="activity?step=SEVENTH&activityId="+id;
		}else{
			$.Zebra_Dialog("保存成功", {
				'type':     'information',
				'title':    '提示',
				'buttons':  ["确定"]
			});
		}
	}else{
		$.Zebra_Dialog(data.message, {
			'type':     'information',
			'title':    '提示',
			'buttons':  ["确定"]
		});
	}
}
function errorResponse(){
	$.Zebra_Dialog("保存嘉宾设置信息失败！", {
		'type':     'information',
		'title':    '提示',
		'buttons':  ["确定"],
		'onClose': function(caption) {
		}
	});
}
var activityId = $("#id").val();
function upSpanClick(obj){
	var up = $(obj).attr("data_up");
	var id = $(obj).attr("data_id");
	$.ajax({
		type : "PUT",
		url  : activityId+"/guest/"+id,
		dataType : "json",
		data:"up="+up,
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
