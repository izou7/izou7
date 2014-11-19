/*jslint unparam: true, regexp: true */
/*global window, $ */
$(function () {
	'use strict';

    // Initialize the jQuery File Upload widget:
    $('#fileupload').fileupload({
        // Uncomment the following to send cross-domain cookies:
        //xhrFields: {withCredentials: true},
        url: 'upload'
    });

    // Enable iframe cross-domain access via redirect option:
    $('#fileupload').fileupload(
        'option',
        'redirect',
        window.location.href.replace(
            /\/[^\/]*$/,
            '/cors/result.html?%s'
        )
    );

    $('#fileupload').fileupload('option', {
        url: '//jquery-file-upload.appspot.com/',
        // Enable image resizing, except for Android and Opera,
        // which actually support image resizing, but fail to
        // send Blob objects via XHR requests:
        disableImageResize: /Android(?!.*Chrome)|Opera/
            .test(window.navigator.userAgent),
        maxFileSize: 5000000,
        acceptFileTypes: /(\.|\/)(gif|jpe?g|png)$/i
    });
    
    
	
	
	
    initCalendar("#startTime");
	initCalendar("#endTime");
	
	$("#tagsDiv button").click(function(){tagsClicked(this)});
	$("#province").change(function(){provinceChange(this)});
});
function tagsClicked(obj){
	if($(obj).attr("class").indexOf("btn-info")!=-1){
		$(obj).attr("class",$(obj).attr("class").replace("btn-info","btn-danger"));
	}else{
		$(obj).attr("class",$(obj).attr("class").replace("btn-danger","btn-info"));
	}
}

function provinceChange(obj){
	if($(obj).val()!=0){
		var url = "/city/"+$(obj).val();
		$.ajax({
			type: "GET",
			url: url,
			dataType : "json",
			success: function(json) {
				$("#city").empty();
				$("#city").append('<option value="0">请选择</option>');
				if (json.statusCode == 200) {
					var citys = json.data.citys;
					if(citys){
						for(var i=0;i<citys.length;i++){
							$("#city").append('<option value="'+citys[i].id+'">'+citys[i].city+'</option>');
						}
					}
				}else {
					$.Zebra_Dialog('获取城市失败！', {
						'type':     'information',
						'title':    '提示',
						'buttons':  ["确定"]
					});
				}
			},
			fail : function(json){
				$.Zebra_Dialog('获取城市失败！', {
					'type':     'information',
					'title':    '提示',
					'buttons':  ["确定"]
				});
			}
		});
	}
}
