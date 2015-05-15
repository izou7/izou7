$(function(){

	$(".fixed_top a").click(function(){
		$("html").animate({'scrollTop':0},1000);
	})


	$(".con_form_box li input,.con_form_box li textarea").focus(function(){
		$(this).parent().find("label").hide();
	})
	$(".con_form_box li  input,.con_form_box li textarea").blur(function(){
		if($(this).val() == ""){
			$(this).parent().find("label").show();
		}
	})
	$(".con_form_box li label").click(function(){
		$(this).hide();
		$(".con_form_box li input").focus();
	})

	$(".con_box .hd a").click(function(){
		var index = $(".con_box .hd a").index($(this))
		$(".con_box .hd a").removeClass();
		$(this).addClass("on");
		$(".con_box .bd .item").hide().eq(index).show();
	})

	$(".pop_box .close_btn").click(function(){
		$(".pop_box").hide();
		$(".mask").hide();
	})

	$(".login_wrap .text label").click(function(){
		$(this).parent().find("label").hide();
		$(this).parent().find("input").focus();
	})
	$(".login_wrap .text input,.cjsq_w .inner input").focus(function(){
		$(this).parent().find("label").hide();
	})
	$(".login_wrap .text input,.cjsq_w .inner input").blur(function(){
		if($(this).val()==""){
			$(this).parent().find("label").show();
		}
	})
	$(".cjsq_w .inner label").click(function(){
		$(this).parent().find("label").hide();
		$(this).parent().find("input").focus();
		$(this).parent().find("textarea").focus();
	})


	$(".cjsq_w .inner textarea").focus(function(){
		$(this).parent().find("label").hide();
	})
	$(".cjsq_w .inner textarea").blur(function(){
		if($(this).val()==""){
			$(this).parent().find("label").show();
		}
	})

	$(".zhxx_w .info_box li a").click(function(){
		$(".pop_edit_name").show();
		$(".mask").show();
	})

	$(".pop_edit_name .cancel_btn").click(function(){
		$(".pop_edit_name").hide();
		$(".mask").hide();
	})


	$(".cygl li").hover(function(){
		$(this).find(".user_info").show();
		//$(this).find(".mask_bg").show();

	},function(){
		$(this).find(".user_info").hide();
		//$(this).find(".mask_bg").hide();
	})

	$(".sq_inner li .hd .edit_btn").click(function(){
		$(this).parents("li").find(".user_info").show();
	})

	$(".sq_inner li .user_info").mouseleave(function(){
		$(this).hide();
	})

//	$(".tz_zk_item .tz_list .xl_btn").click(function(){
//		if($(this).data("f") == false){
//			$(".tz_zk_item .tz_list .hf").hide();
//			$(".tz_zk_item .tz_list .xl_btn").data("f",false).removeClass("xl_btn_s")
//			$(this).parents("li").find(".hf").show();
//			$(this).addClass("xl_btn_s")
//			$(this).data("f",true)
//		}else{
//			$(this).parents("li").find(".hf").hide();
//			$(this).removeClass("xl_btn_s")
//			$(this).data("f",false)
//
//		}
//	})
	$(".tz_zk_item .tz_list .xl_btn").click(function(){
		if($(this).attr("data") == "false"){
			$(".tz_zk_item .tz_list .hf").hide();
			$(".tz_zk_item .tz_list .xl_btn").data("f",false).removeClass("xl_btn_s")
			$(this).parents("li").find(".hf").show();
			$(this).addClass("xl_btn_s")
			$(this).attr("data","true")
		}else{
			$(this).parents("li").find(".hf").hide();
			$(this).removeClass("xl_btn_s")
			$(this).attr("data","false")
			
		}
	})
	
//	$(".mask_text").hover(function(){
//		$(this).addClass("mask_text_tg");
//		$(this).parent().find(".mask_bg").addClass("mask_bg_h");
//		$(this).html('审核通过')
//
//	},function(){
//		$(this).removeClass("mask_text_tg");
//		$(this).parent().find(".mask_bg").removeClass("mask_bg_h");
//		$(this).html('待审核')
//	})
	
	$(".more_li").click(function(){
		$(this).parents("ul").find(".none").show();
		$(this).hide();
	})
	$(".header .inner .s4").hover(function(){
		$(".menu_box").slideDown();

	},function(){
		$(".menu_box").slideUp();
	})

//	$(".sq_inner li").click(function(){
//		var index = $(".sq_inner li").index($(this));
//		$(".tab_content").hide().eq(index).show();
//	})

	$(".add_jybj").click(function(){
		var htm = ''
		 htm+=	'<dd class="clearfix">'
		htm+=		'<div class="clearfix jybj_box">'
		htm+=			'<div class="fl">'
		htm+=				'<label class="fl label_1">教育背景</label>'
		htm+=				'<div class="fl">'
		htm+=				'<input type="text" class="fl s_input">'
		htm+=				'<label class="fl">年</label>'
		htm+=				'<input type="text" class="fl s_input">'
		htm+=				'<label class="fl">月至</label>'
		htm+=				'<input type="text" class="fl s_input">'
		htm+=				'<label class="fl">年</label>'
		htm+=				'<input type="text" class="fl s_input">'
		htm+=				'<label class="fl">月</label>'
		htm+=			'</div>'
		htm+=			'<div class="fr">'
		htm+=				'<label class="fl label_1">学历</label>'
		htm+=				'<select  class="fl">'
		htm+=					'<option>请选择</option>'
		htm+=				'</select>'
		htm+=			'</div>'
		htm+=		'</div>'
		htm+=	'</dd>'
		htm+=	'<dd class="clearfix">'
		htm+=		'<div class="textarea">'
		htm+=			'<textarea></textarea>'
		htm+=		'</div>'
		htm+=	'</dd>'
		$(this).parents("dd").before(htm);
	})

	$(".add_gzjl").click(function(){
		var htm = ''
		 htm+=	'<dd class="clearfix">'
		htm+=		'<div class="clearfix jybj_box">'
		htm+=			'<div class="fl">'
		htm+=				'<label class="fl label_1">工作经历</label>'
		htm+=				'<div class="fl">'
		htm+=				'<input type="text" class="fl s_input">'
		htm+=				'<label class="fl">年</label>'
		htm+=				'<input type="text" class="fl s_input">'
		htm+=				'<label class="fl">月至</label>'
		htm+=				'<input type="text" class="fl s_input">'
		htm+=				'<label class="fl">年</label>'
		htm+=				'<input type="text" class="fl s_input">'
		htm+=				'<label class="fl">月</label>'
		htm+=			'</div>'
		htm+=		'</div>'
		htm+=	'</dd>'
		htm+=	'<dd class="clearfix">'
		htm+=		'<div class="textarea">'
		htm+=			'<textarea></textarea>'
		htm+=		'</div>'
		htm+=	'</dd>'
		$(this).parents("dd").before(htm);
	})

//$(".cjsq_w .btn_box input").click(function(){
//	$(".pop_tip").show();
//	$(".mask").show();
//	return false;
//})
	

})
function showMessage(message){
	$("#message").text(message);
	$("#infoBox").show();
	$(".mask").show();
}
function hideMessage(message){
	$("#infoBox").hide();
	$(".mask").hide();
}