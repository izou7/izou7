$(function () {
	var currentPage = 1;
	initMembers(currentPage);
	$("tbody[id$='TBody']").delegate("a[name='delete']","click",function(){delClick(this);});
});

function delClick(obj){
	$.Zebra_Dialog("确定删除该成员吗？", {
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
							initMembers(currentPage);
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

function initMembers(index){
	var id = $("#id").val();
	$.ajax({
		type: "GET",
		url: "list/"+id,
		dataType : "json",
		contentType:'application/json;charset=UTF-8',
		data:"index="+index,
		success: function(json) {
			if (json.statusCode == 200) {
				$("#memberTBody").empty();
				var mds = json.body.mds;
				var tr = "";
				for(var i=0;i<mds.length;i++){
					var introduction = mds[i].introduction;
					if(introduction==null){
						introduction = "暂无";
					}else if(introduction.length>20){
						introduction = introduction.substr(0,20)+"...";
					}
					var date = new Date(mds[i].addDate);
					var dateStr = date.Format("yyyy-MM-dd HH:mm:ss");
					var phoneStr = mds[i].phone;
					if(phoneStr==null){
						phoneStr = "暂无";
					}
					var deleteStr = '管理员';
					if(mds[i].userId!=json.body.currentUserId){
						
						deleteStr = '<a name="delete" data_id="'+mds[i].id+'" href="#" title="删除"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>';
					}
					tr+= '<tr><td>'+mds[i].headPictureUrl+'</td><td>'+mds[i].username+'</td><td>'+introduction+'</td><td>'+dateStr+'</td><td>'+phoneStr+'</td><td>'+deleteStr+'</td></tr>';
				}
				$("#memberTBody").append(tr);
				initPaginator(json.body.page);
			}else {
				$.Zebra_Dialog("获取成员失败", {
					'type':     'information',
					'title':    '提示',
					'buttons':  ["确定"]
				});
			}
		},
		error : function(json){
			$.Zebra_Dialog('获取成员异常', {
				'type':     'information',
				'title':    '提示',
				'buttons':  ["确定"]
			});
		}
	}); 
}

function initPaginator(pageObj) {
	currentPage = pageObj.index + 1;
	var options = {
		currentPage : currentPage,
		totalPages : pageObj.count,
		onPageClicked : function(event, originalEvent, type,
				page) {
			initMembers(page);
		}
	};
    $('#memberPaginator').bootstrapPaginator(options);
}