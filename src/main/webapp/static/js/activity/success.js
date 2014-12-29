$(function () {
	$("#seeBtn").click(seeBtnClick);
	$("#copyUrlBtn").click(copyUrlBtnClick);
	$("#copyFormBtn").click(copyFormBtnClick);
});
function seeBtnClick(){
	window.open($("#url").val());
}
function copyUrlBtnClick(){
	copyToClipboard($("#url").val()); 
}
function copyFormBtnClick(){
	copyToClipboard($("#contentText").text()); 
}
function copyToClipboard(maintext){
	  if (window.clipboardData){
	    window.clipboardData.setData("Text", maintext);
	    }else if (window.netscape){
	      try{
	        netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
	    }catch(e){
	        alert("该浏览器不支持一键复制！n请手工复制文本框链接地址～");
	    }
	    var clip = Components.classes['@mozilla.org/widget/clipboard;1'].createInstance(Components.interfaces.nsIClipboard);
	    if (!clip) return;
	    var trans = Components.classes['@mozilla.org/widget/transferable;1'].createInstance(Components.interfaces.nsITransferable);
	    if (!trans) return;
	    trans.addDataFlavor('text/unicode');
	    var str = new Object();
	    var len = new Object();
	    var str = Components.classes["@mozilla.org/supports-string;1"].createInstance(Components.interfaces.nsISupportsString);
	    var copytext=maintext;
	    str.data=copytext;
	    trans.setTransferData("text/unicode",str,copytext.length*2);
	    var clipid=Components.interfaces.nsIClipboard;
	    if (!clip) return false;
	    clip.setData(trans,null,clipid.kGlobalClipboard);
	  }
	  alert("以下内容已经复制到剪贴板:" + maintext);
	}