/**
 * created by aqr
 * last modified 2013/12/27
 * email: mgwaqir@gmail.com
 * qq: 995349498
 */
var cn = {};
cn.videofact = {};
(function(){
	$(function(){
		initCommonComponents();
		addCommonEventListener();
	});
	/* Init common components.
	 ==========================================*/
	function initCommonComponents(){
	}

	/* Add common event listener.
	 ==========================================*/
	function addCommonEventListener(){
		$(".batch-check .all").click(batchCheckAllClicked);
		$(".batch-check .inverse").click(batchCheckInverseClicked);
		$(".batch-check .cancel").click(batchCheckCancelClicked);
	}
	function batchCheckAllClicked(event){
		var target = event.target;
		var dataTarget = $(target).closest(".batch-check").data("target");
		$(dataTarget).attr("checked",true);
	}
	function batchCheckInverseClicked(event){
		var target = event.target;
		var dataTarget = $(target).closest(".batch-check").data("target");
		$(dataTarget).each(function(){
			if($(this).attr("checked")){
				$(this).attr("checked",false);
			}else{
				$(this).attr("checked",true);
			}
		});
	}
	function batchCheckCancelClicked(event){
		var target = event.target;
		var dataTarget = $(target).closest(".batch-check").data("target");
		$(dataTarget).attr("checked",false);
	}


	/*Commons*/
	function Commons(){}

	/* define properties
	 =========================================*/
	Commons.name = "se-common-js";
	Commons.version = "1.0";
	/* define functions
	 ==========================================*/
	/**
	 * clone object.
	 * @param input
	 * @returns {*}
	 */
	Commons.clone = function(input) {
		if ( input === null ) {
			return null;
		}

		// Final value.
		if (typeof input !== "object") {
			return input;
		}

		// Array.
		if (input instanceof Array) {

			var arr = [];
			for (var i = 0; i < input.length; i++) {

				if (typeof input[i] === "object") {
					arr[i] = clone(input[i]);
				} else {
					arr[i] = input[i];
				}
			}

			return arr;
		}

		var output = {};
		for (var attr in input) {
			output[ attr ] = clone(input[ attr ]);
		}
		return output;
	}

	/*Class
	 ==============================================*/
	/**
	 * a function triggered after $param tm.
	 * @param handler
	 * @param tm
	 * @constructor
	 */
	Commons.LazyFunction = function(handler, tm){
		this.cnt = 0;
		this.tm = tm || 1000;
		this.handler = handler || function(){};
	}
	Commons.LazyFunction.prototype = {
		execute : function(){
			clearTimeout(this.cnt);
			this.cnt = setTimeout(this.handler, this.tm);
		}
	}

	cn.videofact.Commons = Commons;
	
})();

/**
 * 初始化时间控件
 * 
 */
function initCalendarSecond(mark)
{
	$(mark).focus(function(){
		WdatePicker({doubleCalendar:true,startDate:'%y-%M-01 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true,skin:'twoer'});
	});
}
function initCalendar(mark)
{
	$(mark).focus(function(){
		WdatePicker({doubleCalendar:true,startDate:'%y-%M-01',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,skin:'twoer'});
	});
}