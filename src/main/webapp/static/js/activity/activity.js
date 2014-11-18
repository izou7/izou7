define( [ "jquery", "bootstrap","WdatePicker","common"], function () {

	(function ( $ ) {
		
		$(function () {
			initComponents();
			addEventListener();
		});
		
		/* Init components.
		 ==========================================*/
		function initComponents() {
			initCalendar("#startTime");
			initCalendar("#endTime");
		}

		/* Add  event listener.
		 ==========================================*/
		function addEventListener() {
			$("#tagsDiv button").click(function(){tagsClicked(this)});
			$("#province").change(function(){provinceChange(this)});
		}

		/*Functions of initComponents
		 ============================================*/
		
		/*Functions of addEventListener
		 ============================================*/
		function tagsClicked(obj){
			if($(obj).attr("class").indexOf("btn-info")!=-1){
				$(obj).attr("class",$(obj).attr("class").replace("btn-info","btn-danger"));
			}else{
				$(obj).attr("class",$(obj).attr("class").replace("btn-danger","btn-info"));
			}
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
		
		
	})(jQuery);
} );