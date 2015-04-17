$(function () {
	$("a[name='delete']").click(function(){deleteClicked(this);});
});
function deleteClicked (obj){
	$.Zebra_Dialog("确定删除该社区吗？", {
		'type':     'information',
		'title':    '提示',
		'buttons':  ["取消","确定"],
		'onClose': function(caption) {
			var option=(caption != '' ? '"' + caption + '"' : 'nothing');
	        if(option=="\"确定\""){
	        	var id = $(obj).attr("data_id");
	        	$.ajax({
					type : "DELETE",
					url  : id,
					dataType : "json",
					success : function(data){
						if(data.statusCode == 200){
							location.href = "/community/listPage";
						}
					},
					error:function(){
						$.Zebra_Dialog("删除失败！", {
							'type':     'information',
							'title':    '提示',
							'buttons':  ["确定"],
							'onClose': function(caption) {
							}
						});
					}
				});
			}
		}
		});
}
	

