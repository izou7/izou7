$(function () {
	$("#submitBtn").click(submitBtnClicked);
});
function submitBtnClicked(){
	console.info($('form').serializeObject());
	$.ajax({
		type:"POST",
        url:"agency",
        data:JSON.stringify($('form').serializeObject()),
		dataType : "json",
		contentType:'application/json;charset=UTF-8',
        success:function(json){
        	if (json.statusCode == 200) {
				alert("操作成功！");
				location.href = "/agency";
			}else {
				alert(json.message);
			}
        },
		error:function(json){
	    	alert("操作异常！");
	    }
    });
}