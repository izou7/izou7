define( [ "jquery", "bootstrap","WdatePicker","common"], function () {

	(function ( $ ) {
		
		$(function () {
			initComponents();
			addEventListener();
		});
		
		/* Init components.
		 ==========================================*/
		function initComponents() {
			initCalendar("#birthday");
		}

		/* Add  event listener.
		 ==========================================*/
		function addEventListener() {
			$("#tagsDiv button").click(function(){tagsClicked(this)});
			$("#province").change(function(){provinceChange(this)});
			$("#save").click(function(){saveClicked(this)});
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
		
		function saveClicked(obj){
			var url = "";
			if(userInfo==null){
				url = "/userInfo/add";
				alert(1);
			}else{
				url = "/userInfo/update";
				alert(2);
			}
			
			
			var userInfo = {};
			userInfo.realName = $("#realName").val();
			userInfo.phone = $("#phone").val();
			userInfo.email = $("#email").val();
			userInfo.qq = $("#qq").val();
			userInfo.birthday = $("#birthday").val();
			userInfo.sex = $("input[name='sex']:checked").val();
			
			province = {};
			province.id = $("#province option[selected]").val();
			province.name = $("#province option[selected]").text();
			
			userInfo.city = {};
			userInfo.city.id = $("#city option[selected]").val();
			userInfo.city.city = $("#city option[selected]").text();
			userInfo.city.province = province;
			
			userInfo.phone = $("#phone").val();
			userInfo.phone = $("#phone").val();
			userInfo.phone = $("#phone").val();
			
			$.ajax({
				type: "POST",
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