$(function () {
	$("#submitBtn").click(submitBtnClicked);
	$("#addMag").click(addMagClicked);
	$("#managerArea").delegate("a[name='delBtn']","click",function(){delBtnClicked(this)});
	$("#saveBtn").click(saveBtnClicked);
});
function saveBtnClicked(){
	
	var companyName = $("#companyName").val();
	var webSite = $("#webSite").val();
	var publicNum = $("#publicNum").val();
	var description = $("#description").val();
	var name = $("#name").val();
	var phone = $("#phone").val();
	var email = $("#email").val();
	var managementInfo = [];
	$("#managerArea").find("div[name='manager']").each(function(index,element){
		if($(element).is(":visible")){
			var mag = {
					"name":$(element).find("input[name='name']").val(),
					"position":$(element).find("input[name='position']").val(),
					"education_info":$(element).find("textarea[name='education']").val(),
					"career_info":$(element).find("textarea[name='career']").val()
			}
			managementInfo.push(mag);
		}
	});
	var customer = {
			"companyName":companyName,
			"webSite":webSite,
			"publicNum":publicNum,
			"description":description,
			"name":name,
			"phone":phone,
			"email":email,
			"managementInfo":JSON.stringify(managementInfo)
	};
	console.info(JSON.stringify(customer));
	$.ajax({
		type:"POST",
        url:"/customer/add",
        data:JSON.stringify(customer),
		dataType : "json",
		contentType:'application/json;charset=UTF-8',
        success:function(json){
        	if (json.statusCode == 200) {
				showMessage("提交成功！");
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
function delBtnClicked(obj){
	$(obj).parents("div[name='manager']").fadeOut("slow");
}
function addMagClicked(){
	var html = '<div name="manager">'+
				'<dd class="clearfix">'+
					'<p class="addManager"><a name="delBtn" href="javascript:void(0);" class="add_gzjl">删除</a></p>'+
				'</dd>'+
				'<dd class="clearfix">'+
						'<label class="fl label_1">姓名</label>'+
						'<div class="textarea">'+
							'<input type="text" name="name" class="fl longInput" >'+
						'</div>'+
				'</dd>'+
				'<dd class="clearfix">'+
						'<label class="fl label_1">职务</label>'+
						'<div class="textarea">'+
							'<input type="text" name="position" class="fl longInput" >'+
						'</div>'+
				'</dd>'+
				'<dd class="clearfix">'+
					'<label class="fl label_1">教育背景</label>'+
					'<div class="textarea">'+
						'<textarea name="education"></textarea>'+
					'</div>'+
				'</dd>'+
				'<dd class="clearfix">'+
					'<label class="fl label_1">工作经历</label>'+
					'<div class="textarea">'+
						'<textarea name="career"></textarea>'+
					'</div>'+
				'</dd>'+
				'</div>';
	$("#managerArea").append(html);
		
}
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
				showMessage("提交成功！");
				location.href = "/agency";
			}else {
				showMessage(json.message);
			}
        },
		error:function(json){
	    	showMessage("操作异常！");
	    }
    });
}