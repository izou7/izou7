$(function () {
	$("#province").change(function(){provinceChange(this)});
	$("#saveBtn").click(saveBtnClicked);
});

function saveBtnClicked(){
	var realName = $("#realName").val();
	var city = $("#city option:selected").val();
	var company = $("#company").val();
	var position = $("#position").val();
	var sex = $("input[name='sex']:checked").val();
	var paramObj = {
			"realName":realName,
			"city":parseInt(city),
			"company":company,
			"position":position,
			"sex":parseInt(sex)==0?false:true,
			"id":parseInt($("#id").val())
	}
	console.info(JSON.stringify(paramObj));
	$.ajax({
		type:"POST",
        url:"/registSecond",
        data:JSON.stringify(paramObj),
		dataType : "json",
		contentType:'application/json;charset=UTF-8',
        success:function(json){
        	if (json.statusCode == 200) {
        		location.href="/login.jsp";
			}else {
				showMessage(json.message);
			}
        },
		error:function(json){
			console.info(json);
	    	showMessage("操作异常！");
	    }
    });
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
				if (json.statusCode == 200) {
					var citys = json.body.citys;
					if(citys){
						for(var i=0;i<citys.length;i++){
							$("#city").append('<option value="'+citys[i].id+'">'+citys[i].city+'</option>');
						}
					}
				}else {
					showMessage("获取城市失败！");
				}
			},
			error : function(json){
				showMessage("获取城市异常，请检查网络！");
			}
		});
	}
}
