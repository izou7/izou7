$(function () {
	$("#submitBtn").click(submitBtnClicked);
});
function submitBtnClicked(){
	console.info($('form').serializeObject());
	$.ajax({
		type:"POST",
        url:"contact",
        data:JSON.stringify($('form').serializeObject()),
		dataType : "json",
		contentType:'application/json;charset=UTF-8',
        success:function(json){
        	if (json.statusCode == 200) {
				showMessage("提交成功！");
				location.href = "/contact";
			}else {
				showMessage(json.message);
			}
        },
		error:function(json){
	    	showMessage("操作异常！");
	    }
    });
}