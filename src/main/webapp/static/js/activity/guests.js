$(function () {
	$("div[name='title']").click(function (){titleClick(this);});
	$("div[name='title']").next().hide();
});
function titleClick(obj){
	$(obj).next().slideToggle("slow");
}
