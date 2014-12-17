$(function () {
	$("#tagsDiv button").click(function(){tagsClicked(this)});
	var options = { 
	        target:        '#add', 
	        success:       successAdd,
	        error:		   errorAdd,
	        type:          "POST", 
	        dataType:      "JSON"
	    }; 
	$("#publicForm").ajaxForm(options);
});
var id = $("#id").val();
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
		$.Zebra_Dialog("添加公众号成功！", {
			'type':     'information',
			'title':    '提示',
			'buttons':  ["确定"],
			'onClose': function(caption) {
				$("#publicForm").clearForm();
				$("#tagsDiv button[class='btn btn-sm btn-danger']").attr("class","btn btn-sm btn-info");
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
	$.Zebra_Dialog("添加公众号失败！", {
		'type':     'information',
		'title':    '提示',
		'buttons':  ["确定"],
		'onClose': function(caption) {
		}
	});
}



