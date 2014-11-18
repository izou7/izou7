  <style>
  	#tagsDiv button{
  	  margin:5px;
  	}
  </style>
  <!-- 主要内容 -->
  <div class="container content">
  <!--页头-->
    <div class="page-header">
		<h1>个人资料</h1>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
		<h3 class="panel-title">基本信息</h3>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" role="form">
			  <div class="form-group">
				<label class="col-sm-2 control-label" for="name">真实姓名：</label>
				<div class="col-sm-6">
					<input class="form-control" type="text" id="realName" placeholder="真实姓名">
			  	</div>
			  </div>
			  <div class="form-group">
				<label class="col-sm-2 control-label" for="phone">手机：</label>
				<div class="col-sm-6">
				  <input class="form-control" type="text" id="phone" placeholder="手机号">
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-sm-2 control-label" for="email">电子邮箱：</label>
				<div class="col-sm-6">
				  <input class="form-control" type="text" id="email" placeholder="电子邮箱">
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-sm-2 control-label" for="qq">qq号：</label>
				<div class="col-sm-6">
				  <input class="form-control" type="text" id="qq" placeholder="qq号">
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-lg-2 control-label" for="introduction">个人介绍：</label>
				<div class="col-lg-6">
				  <textarea class="form-control" rows="4" id="introduction" placeholder="活动介绍"></textarea>
				</div>
			  </div>
			  
			  <div class="form-group">
				<label class="col-sm-2 control-label" for="interestField">感兴趣的领域：</label>
				<div id="tagsDiv" class="col-sm-6">
					<button type="button" class="btn btn-sm btn-info">原创设计</button>
					<button type="button" class="btn btn-sm btn-info">演唱会</button>
					<button type="button" class="btn btn-sm btn-info">红丝带</button>
					<button type="button" class="btn btn-sm btn-info">扶贫</button>
					<button type="button" class="btn btn-sm btn-info">助学</button>
					<button type="button" class="btn btn-sm btn-info">微电影</button>
					<button type="button" class="btn btn-sm btn-info">生活育儿</button>
					<button type="button" class="btn btn-sm btn-info">论坛</button>
					<button type="button" class="btn btn-sm btn-info">点映</button>
					<button type="button" class="btn btn-sm btn-info">首映</button>
					<button type="button" class="btn btn-sm btn-info">其他</button>
				</div>
			  </div>
			  
			  <div class="form-group">
				<label class="col-sm-2 control-label" for="interestCareer">感兴趣的职业：</label>
				<div id="tagsDiv" class="col-sm-6">
					<button type="button" class="btn btn-sm btn-info">原创设计</button>
					<button type="button" class="btn btn-sm btn-info">演唱会</button>
					<button type="button" class="btn btn-sm btn-info">红丝带</button>
					<button type="button" class="btn btn-sm btn-info">扶贫</button>
					<button type="button" class="btn btn-sm btn-info">助学</button>
					<button type="button" class="btn btn-sm btn-info">微电影</button>
					<button type="button" class="btn btn-sm btn-info">生活育儿</button>
					<button type="button" class="btn btn-sm btn-info">论坛</button>
					<button type="button" class="btn btn-sm btn-info">点映</button>
					<button type="button" class="btn btn-sm btn-info">首映</button>
					<button type="button" class="btn btn-sm btn-info">其他</button>
				</div>
			  </div>
			  
			  
			  
			  
			   <div class="form-group">
				<label class="col-lg-2 control-label" for="site">活动地点：</label>
				<div class="col-lg-2">
				  <select id="site" class="form-control" >
					<option>北京</option>
					<option>上海</option>
					<option>广州</option>
				  </select>
				</div>
				<div class="col-lg-2">
				  <select class="form-control" >
					<option>北京</option>
					<option>上海</option>
					<option>广州</option>
				  </select>
				</div>
				<div class="col-lg-2">
				  <select class="form-control" >
					<option>北京</option>
					<option>上海</option>
					<option>广州</option>
				  </select>
				</div>
			  </div>		
			  <div class="form-group">
				<label class="col-lg-2 control-label" for="time">活动时间：</label>
				<div class="col-lg-2" >
				  <input class="form-control " type="text" id="startTime" style="width:220px;">
				</div>
				<span class="col-lg-2 text-center" >到</span>
				<div class="col-lg-2">
				  <input class="form-control" type="text" id="endTime" style="width:220px;margin-left:-63px;">
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-lg-2 control-label" for="num">活动人数：</label>
				<div class="col-lg-6">
				  <input class="form-control" type="text" id="num" placeholder="活动人数">
				</div>
			  </div>			  
			  <div class="form-group">
				<label class="col-lg-2 control-label" for="tag">活动标签：</label>
				<div class="col-lg-6">
				  <input id="tags_1" id="tag" type="text" class="tags form-control" value="原装设计,微电影" />
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-lg-2 control-label" for="introduction">活动介绍：</label>
				<div class="col-lg-6">
				  <textarea class="form-control" rows="4" id="introduction" placeholder="活动介绍"></textarea>
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-lg-2 control-label" for="poster">上传海报：</label>
				<div class="col-lg-1">
				<button type="button" class="btn btn-info">上传海报</button>
				<input type="file" name="fileField" class="file" id="fileField" size="18" />
				</div>
				<div class="col-lg-4">
					<h6 class="help-block">支持jpg、jpeg、png、gif格式，大小不超过2M。建议尺寸：400 X 220px</h6>
					
				</div>
			 </div>
			 <div class="form-group">
				<label class="col-lg-2 control-label" for="attachment"></label>
				<div class="col-lg-10">
				<!--
					<img src="${ (project.staticDomain)! }/images/shop.jpg" class="img-responsive" height="140" width="200">
					-->
				</div>
			 </div>
			 <div class="form-group">
				<label class="col-lg-2 control-label" for="attachment">上传附件：</label>
				<div class="col-lg-10">
					<input type="file" id="attachment" class="btn btn-primary" >
					<h6 class="help-block">支持jpg、jpeg、png、gif格式，大小不超过2M。建议尺寸：400 X 220px</h6>
				</div>
			 </div>
			 <div class="form-group">
				<label class="col-lg-2 control-label" for="isPublic">是否公开：</label>
				<div class="col-lg-10">
					<div class="checkbox">
						<label>
						  <input type="radio" name="isPublic"> 是
						</label>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<label>
						  <input type="radio" name="isPublic"> 否
						</label>
					</div>
					
				</div>
			 </div>	
			 <div class="form-group">
				<label class="col-lg-2 control-label" for="homeUrl">活动主页地址：</label>
				<div class="col-lg-6">
				  <input class="form-control" type="text" id="homeUrl" placeholder="活动主页地址">
				</div>
			 </div>	
			 <div class="form-group">
				<div class="col-lg-6">
				 
				</div>
				<div class="col-lg-2">
				  <button type="button" class="btn btn-info btn-block" onclick="javascript:location.href='deploy2.html'">下一步</button>
				</div>
			 </div>
			<!--
			 <div class="form-group">
			 <label class="col-lg-2 control-label" for="inputFile">相关链接：</label>
				<div class="col-lg-6">
					 <div class="table-responsive">
					  <table class="table table-bordered">
						<thead>
						  <tr>
							<th>序号</th>
							<th>链接</th>
							
						  </tr>
						</thead>
						<tbody>
						  <tr>
							<td>1</td>
							<td>www.baidu.com</td>
						  </tr>
						  <tr>
							<td>2</td>
							<td>www.sogou.com</td>
						  </tr>
						  <tr>
							<td>3</td>
							<td>www.google.com</td>
						  </tr>
						</tbody>
					  </table>
					</div>
				</div>
				<div class="col-lg-4">
					<button type="button" class="btn btn-info"><span class="glyphicon glyphicon-plus"></span></button>
					<button type="button" class="btn btn-info"><span class="glyphicon glyphicon-minus"></span></button>
				</div>
			</div>
			-->
			</form>
		</div>
	</div>
  </div>
<script type="text/javascript">
	requirejs( ["${ (project.staticDomain)! }/js/activity/activity.js"] );
</script>