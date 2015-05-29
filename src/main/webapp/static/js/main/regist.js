$(function () {
	$("#imgObj").click(imgObjClicked);
	$("#loginBtn").click(loginBtnClicked);
});
function imgObjClicked(){
	var imgSrc = $("#imgObj"); 
    var src = imgSrc.attr("src"); 
    imgSrc.attr("src", chgUrl(src));
}
function chgUrl(url) { 
    var timestamp = (new Date()).valueOf(); 
    url = url.substring(0, 17); 
    if ((url.indexOf("&") >= 0)) { 
        url = url + "×tamp=" + timestamp; 
    } else { 
        url = url + "?timestamp=" + timestamp; 
    } 
    return url; 
} 
function loginBtnClicked(){
	var phone = $("#phone").val();
	var captcha = $("#captcha").val();
	var password = $("#password").val();
	var cPassword = $("#cPassword").val();
	var paramObj = {
			"phone":phone,
			"captcha":captcha,
			"password":password,
			"cPassword":cPassword
	}
	console.info(JSON.stringify(paramObj));
	$.ajax({
		type:"POST",
        url:"/regist",
        data:JSON.stringify(paramObj),
		dataType : "json",
		contentType:'application/json;charset=UTF-8',
        success:function(json){
        	if (json.statusCode == 200) {
        		console.info(json);
				var id = json.body.id;
				$("#id").val(id);
				$("#registSecondForm").submit();
			}else {
				showMessage(json.message);
				imgObjClicked();
			}
        },
		error:function(json){
			console.info(json);
	    	showMessage("操作异常！");
	    	imgObjClicked();
	    }
    });
}