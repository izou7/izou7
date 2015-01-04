$(function () {
	$("input[name='browse']").click(function(){browsePublic(this)});
	$("input[name='delete']").click(function(){deletePublic(this)});
});
		

function browsePublic(obj){
	var id = $(obj).attr("data");
	window.location.href = "/public/show?publicId="+id;
	return;
}

function refresh(){
	window.location.reload();
}

function deletePublic(obj){
	$.Zebra_Dialog('确定删除吗?',
		{
			'type' : 'question',
			'title' : '请确认',
			'buttons' : ['确定', '取消'],
			'onClose' : function (caption)
			{
				var option = (caption != '' ? '"' + caption + '"' : 'nothing');
				if ("\"确定\"" == option)
				{
					var id = $(obj).attr("data");
					$.ajax({
						type: "DELETE",
						url: "/public/delete/"+id,
						dataType : "json",
						//data : inputJson,
						//contentType:'application/json;charset=UTF-8', 
						success: function(json) {
							if (json.statusCode == 200) {
								$.Zebra_Dialog(json.message, {
									'type':     'information',
									'title':    '提示',
									'buttons':  ["确定"],
									'onClose': 	function(){
			            	 			refresh();
			             			}
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
				else
				{
					return;
				}
				
					
			}
		}
	);
}
		
