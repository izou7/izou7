$(function () {
	$("#province").change(function(){provinceChange(this)});
});
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
