$(function () {
	var activityId = $("#id").val();
	initCalendarSecond("#start");
	initCalendarSecond("#end");
	var eventData;
	$("#addBtn").click(function(){$("#submitBtn").trigger("click");});
	$("#delBtn").click(delBtnClick);
	$("#editBtn").click(editBtnClick);
	
	var options = { 
	        target:        '#submitBtn',   // target element(s) to be updated with server response 
	        beforeSubmit:  beforeRequest,  // pre-submit callback 
	        success:       successResponse,  // post-submit callback
	        error:		   errorResponse,
	        // other available options: 
	        //url:       url         // override for form's 'action' attribute 
	        type:      "POST",       // 'get' or 'post', override for form's 'method' attribute 
	        dataType:  "JSON",       // 'xml', 'script', or 'json' (expected server response type) 
	        clearForm: true        // clear all form fields after successful submit 
	        //resetForm: true        // reset the form after successful submit 
	 
	        // $.ajax options can be used here too, for example: 
	        //timeout:   3000 
	    }; 
	
	$('#calendarForm').ajaxForm(options); 
	var calendar = $('#calendar').fullCalendar({
		timeFormat: 'H:mm{ - H:mm}',
		aspectRatio: 0,
		allDaySlot:false,
		unselectAuto:false,
		lazyFetching:false,
		axisFormat:'H(:mm)点',
		firstDay:1,
		monthNames: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],  
        monthNamesShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],  
        dayNames: ["周日", "周一", "周二", "周三", "周四", "周五", "周六"],  
        dayNamesShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六"],  
        today: ["今天"],  
        buttonText: {  
			  today: '今天',  
			  month: '月',  
			  week: '周',  
			  day: '日'
		},
		header: {
			left: false,
			center: 'title',
			right:  'today prev,next'
		},
		defaultView : 'agendaWeek',
		draggable:true,
		selectable: true,
		selectHelper: true,
		select: function(start, end) {
			$('#calendarForm').clearForm();
			$("#modalTrigger").trigger("click");
			$("#editBtn").attr("class","btn btn-primary collapse");
			$("#delBtn").attr("class","btn btn-primary collapse");
			$("#addBtn").attr("class","btn btn-primary");
			$("#start").val(start.Format("yyyy-MM-dd HH:mm:ss"));
			$("#end").val(end.Format("yyyy-MM-dd HH:mm:ss"));
			
		},
		editable : true,
		eventDrop:function( calEvent, dayDelta, minuteDelta, allDay, revertFunc, jsEvent, ui, view) {
			$.Zebra_Dialog('确定修改该日程？',
					{
						'type' : 'confirm',
						'title' : '请确认',
						'buttons' : ['确定', '取消'],
						'onClose' : function (caption)
						{
							var option = (caption != '' ? '"' + caption + '"' : 'nothing');
							if ("\"确定\"" == option)
							{
								var calendarId = calEvent.id;
								var data = JSON.stringify({title:calEvent.title,start:calEvent.start.Format("yyyy-MM-dd HH:mm:ss"),end:calEvent.end.Format("yyyy-MM-dd HH:mm:ss")});
								updateCalendar(calendarId,data,revertFunc);
							}
							else
							{
								revertFunc();
							}
							
						}
					}
					);
		},
		eventResize:function(calEvent, dayDelta, minuteDelta, revertFunc, jsEvent, ui, view) {
			$.Zebra_Dialog('确定修改该日程？', {
				'type' : 'question',
				'title' : '请确认',
				'buttons' : [ '确定', '取消' ],
				'onClose' : function(caption) {
					var option = (caption != '' ? '"' + caption + '"'
							: 'nothing');
					if ("\"确定\"" == option) {
//						var duration = (calEvent.end.getTime()-calEvent.start.getTime())/1000;
						var calendarId = calEvent.id;
						var data = JSON.stringify({title:calEvent.title,start:calEvent.start.Format("yyyy-MM-dd HH:mm:ss"),end:calEvent.end.Format("yyyy-MM-dd HH:mm:ss")});
						updateCalendar(calendarId,data,revertFunc);
					} else {
						revertFunc();
					}

				}
			});
		},
		events:function(start, end, callback) {$.getJSON(activityId+"/calendars", {start: start.getTime(), end: end.getTime()}, function(result) {callback(result);})},
		eventClick: function(calEvent, jsEvent, view) {
			$("#modalTrigger").trigger("click");
			$("#editBtn").attr("class","btn btn-primary");
			$("#delBtn").attr("class","btn btn-primary");
			$("#addBtn").attr("class","btn btn-primary collapse");
			$("#title").val(calEvent.title);
			$("#start").val(calEvent.start.Format("yyyy-MM-dd HH:mm:ss"));
			$("#end").val(calEvent.end.Format("yyyy-MM-dd HH:mm:ss"));
			$("#calendarId").val(calEvent.id);
		}
	});
	$("#nextBtn").click(nextBtnClick);
	$('#addModal').on('hidden.bs.modal', function (e) {
		calendar.fullCalendar('unselect');
	});


});
function beforeRequest(){
	eventData = $('#calendarForm').serializeObject(); 
}
function successResponse(){
	$("#closeBtn").trigger("click");
	refreshView();
	
}
function errorResponse(){
	$("#closeBtn").trigger("click");
	$('#calendar').fullCalendar('unselect');
}
function delBtnClick(){
	$("#closeBtn").trigger("click");
	var calendarId = $("#calendarId").val();
	$.ajax({
        type:"DELETE",
        url:"calendar/"+calendarId,
        dataType: 'json',
        contentType:'application/json;charset=UTF-8',  
        async:false,
        success:function(json){
        	if(json.statusCode=="200"){
        		$.Zebra_Dialog("删除日程成功！", {
            		'type':     'information',
            		'title':    '提示',
            		'buttons':  ["确定"],
            		'onClose':function(caption) {
            			refreshView();
            		}
            	});
        	}else{
        		$.Zebra_Dialog("删除日程失败！", {
            		'type':     'information',
            		'title':    '提示',
            		'buttons':  ["确定"]
            	});
        	}
        },
        error:function(){
        	$.Zebra_Dialog("删除日程异常！", {
        		'type':     'information',
        		'title':    '提示',
        		'buttons':  ["确定"]
        	});
        }
    });
}
function editBtnClick(){
	$("#closeBtn").trigger("click");
	var calendarId = $("#calendarId").val();
	var data = JSON.stringify({title:$("#title").val(),start:$("#start").val(),end:$("#end").val()});
	$.ajax({
        type:"PUT",
        url:"calendar/"+calendarId,
        data:data, 
        dataType: 'json',
        contentType:'application/json;charset=UTF-8',  
        async:false,
        success:function(json){
        	if(json.statusCode=="200"){
        		$.Zebra_Dialog("修改日程成功！", {
            		'type':     'information',
            		'title':    '提示',
            		'buttons':  ["确定"],
            		'onClose':function(caption) {
            			refreshView();
            		}
            	});
        		
        	}else{
        		$.Zebra_Dialog("修改日程失败！", {
            		'type':     'information',
            		'title':    '提示',
            		'buttons':  ["确定"],
            		'onClose': function(caption) {
            			revertFunc();
            		}
            	});
        	}
        },
        error:function(){
        	$.Zebra_Dialog("修改日程异常！", {
        		'type':     'information',
        		'title':    '提示',
        		'buttons':  ["确定"],
        		'onClose': function(caption) {
        			revertFunc();
        		}
        	});
        }
    });
}
function updateCalendar(calendarId,data,revertFunc){
	$.ajax({
        type:"PUT",
        url:"calendar/"+calendarId,
        data:data, 
        dataType: 'json',
        contentType:'application/json;charset=UTF-8',  
        async:false,
        success:function(json){
        	if(json.statusCode=="200"){
        		$.Zebra_Dialog("修改日程成功！", {
            		'type':     'information',
            		'title':    '提示',
            		'buttons':  ["确定"]
            		
            	});
        	}else{
        		$.Zebra_Dialog("修改日程失败！", {
            		'type':     'information',
            		'title':    '提示',
            		'buttons':  ["确定"],
            		'onClose': function(caption) {
            			revertFunc();
            		}
            	});
        	}
        },
        error:function(){
        	$.Zebra_Dialog("修改日程异常！", {
        		'type':     'information',
        		'title':    '提示',
        		'buttons':  ["确定"],
        		'onClose': function(caption) {
        			revertFunc();
        		}
        	});
        }
    });
}
function refreshView(){
	  $('#calendar').fullCalendar('refetchEvents');
}
function nextBtnClick(){
	var arcitityId = $("#id").val();
	location.href="activity?step=FOURTH&activityId="+arcitityId;
}

