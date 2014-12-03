$(function () {
	var activityId = $("#id").val();
	$('#calendar').fullCalendar({
		timeFormat: 'H:mm{ - H:mm}',
		allDaySlot:false,
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
		selectable: true,
		selectHelper: true,
		events:function(start, end, callback) {$.getJSON(activityId+"/calendars", {start: start.getTime(), end: end.getTime()}, function(result) {callback(result);})}
	});

});

