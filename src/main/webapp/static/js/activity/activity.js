define( [ "jquery", "bootstrap"], function () {

	(function ( $ ) {
		
		$(function () {
			initComponents();
			addEventListener();
		});
		
		/* Init components.
		 ==========================================*/
		function initComponents() {
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
						if (json.statusCode == 200) {
							console.info(json);
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