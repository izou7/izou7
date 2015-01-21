$(function () {
	initCalendar("#ticketSaleStartTime");
	initCalendar("#ticketSaleEndTime");
	initCalendar("#ticketValidStartTime");
	initCalendar("#ticketValidEndTime");
	var options = {
			dataType:"json",
			error:errorHandler,
			success:successHandler,
			type:"POST"
	}
	$('#ticketForm').ajaxForm(options);
//	$("#saveBtn").click(function (){$("#submitType").val("save");});
//	$("#nextBtn").click(function (){$("#submitType").val("next");});
	
	$("#nextBtn").click(nextBtnClick);
	$("#saveBtn").click(saveBtnClick);
	$("#deployBtn").click(deployBtnClick);
	$("input[name='free']").click(function freeHander(){freeChecked(this);});
	if(free!="false"){
		$("input[type!='hidden'][name!='free']").attr("disabled",true);
		$("textarea").attr("disabled",true);
	}
	$('#navigation a').stop().animate({'marginLeft':'-50px'},1000);
//    $('#navigation > li').hover(
//        function () {
//            $('a',$(this)).stop().animate({'marginLeft':'-2px'},200);
//        },
//        function () {
//            $('a',$(this)).stop().animate({'marginLeft':'-85px'},200);
//        }
//    );	
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
function freeChecked(obj){
	var free = $(obj).val();
	if(free=="true"){
		$("input[type!='hidden'][name!='free']").val("").attr("disabled",true);
		$("textarea").val("").attr("disabled",true);
	}else{
		$("input[type!='hidden'][name!='free']").attr("disabled",false);
		$("textarea").attr("disabled",false);
	}
}
function errorHandler(){
	$.Zebra_Dialog("操作异常", {
		'type':     'information',
		'title':    '提示',
		'buttons':  ["确定"]
	});
}
function successHandler(data,statusText,xhr,$form){
	var type = $("#type").val();
	if(data.statusCode==200){
		if(type=="DEPLOY"){
			location.href="activity?step=SUCCESS&activityId="+id;
		}else if(type=="NEXT"){
			location.href="activity?step=SIXTH&activityId="+id;
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
//	var submitType = $("#submitType").val();
//	if(submitType=="save"){
//		$.Zebra_Dialog("操作成功", {
//			'type':     'information',
//			'title':    '提示',
//			'buttons':  ["确定"]
//		});
//	}else{
//		location.href='activity?step=SIXTH&activityId='+$("#id").val();
//	}
}

