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
		
		
	})(jQuery);
} );