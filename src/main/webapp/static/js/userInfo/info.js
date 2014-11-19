$(function () {
	initCalendar("#birthday");
	$("#tagsDiv button").click(function(){tagsClicked(this)});
	$("#province").change(function(){provinceChange(this)});
	$("#save").click(function(){saveClicked(this)});
});
		
function tagsClicked(obj){
	if($(obj).attr("class").indexOf("btn-info")!=-1){
		$(obj).attr("class",$(obj).attr("class").replace("btn-info","btn-danger"));
	}else{
		$(obj).attr("class",$(obj).attr("class").replace("btn-danger","btn-info"));
	}
}

function saveClicked(obj){
	
	var userInfo = {};
	userInfo.id = userInfoId;
	userInfo.realName = $("#realName").val();
	userInfo.phone = $("#phone").val();
	userInfo.email = $("#email").val();
	userInfo.qq = $("#qq").val();
	userInfo.birthday = $("#birthday").val();
	userInfo.sex = $("input[name='sex']:checked").val();
	
	province = {};
	province.id = $("#province option[selected]").val();
	province.name = $("#province option:selected").text();
	
	city = {};
	city.id =  $("#city").val();
	city.city = $("#city option:selected").text();
	city.province = province;

	userInfo.city = city;
	
	userInfo.introduction = $("#introduction").val();
	
	var inputJson = JSON.stringify(userInfo);
	console.info(inputJson);
	$.ajax({
		type: "POST",
		url: "/userInfo/update",
		dataType : "json",
		data : inputJson,
		contentType:'application/json;charset=UTF-8', 
		success: function(json) {
			if (json.statusCode == 200) {
				$.Zebra_Dialog(json.message, {
					'type':     'information',
					'title':    '提示',
					'buttons':  ["确定"]
				});
			}else {
				$.Zebra_Dialog(json.message, {
					'type':     'information',
					'title':    '提示',
					'buttons':  ["确定"]
				});
			}
		},
		fail : function(json){
			$.Zebra_Dialog('失败', {
				'type':     'information',
				'title':    '提示',
				'buttons':  ["确定"]
			});
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
		
