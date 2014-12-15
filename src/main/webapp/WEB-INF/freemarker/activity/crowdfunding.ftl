  <style>
  	.glyphicon{
  		cursor: pointer
  	}
  	#tagsDiv button{
  	  margin:5px;
  	}
  </style>
  <!-- Generic page styles -->
  <!-- 主要内容 -->
  <div class="container content">
  <!--页头-->
    <div class="page-header">
		<h1>发布活动</h1>
	</div>
	<div class="panel panel-default">
		  <div class="panel-heading"  style="cursor: pointer">
		    <h3 class="panel-title">回报设置列表</h3>
		  </div>
		  <div class="panel-body">
	  		<div class="form-group">
						<div class="col-lg-10">
							 <div class="table-responsive">
							  <table class="table table-bordered">
								<thead>
								  <tr>
									<th>支付金额</th>
									<th>名额</th>
									<th>回报内容</th>
									<th>回报时间</th>
									<th>操作</th>
								  </tr>
								</thead>
								<tbody id="rewardTBody">
								<#list rewards as reward>
									<tr>
										<td>${(reward.amount)!}</td>
										<td>${(reward.limit)!}</td>
										<td>${(reward.reward)!}</td>
										<td>${(reward.days)!}</td>
										<td><span id="delSpan" class="glyphicon glyphicon-remove" data_id="${(reward.id)!}"></span></td>
									</tr>
								</#list>
								</tbody>
							  </table>
							</div>
						</div>
					</div>		  	
		  </div>
	  </div>
	<div class="panel panel-default">
	  <div class="panel-heading" name="title"  style="cursor: pointer">
	    <h3 class="panel-title">添加回报设置</h3>
	  </div>
	  <div class="panel-body">
	  <form class="form-horizontal" id="rewardForm" action="${id!}/activityCrowdfunding/reward" method="POST">
	  	<div class="form-group">
	  		<div class="form-group">
			<label class="col-lg-2 control-label" >回报时间：</label>
			<div class="col-lg-2" >
			  <input class="form-control " type="text" name="rewardStartTime" id="rewardStartTime" style="width:220px;" required>
			</div>
			<span class="col-lg-2 text-center" >到</span>
			<div class="col-lg-2">
			  <input class="form-control" type="text" id="rewardEndTime" name="rewardEndTime" style="width:220px;margin-left:-63px;" required>
			</div>
		  </div>
		    <div class="form-group">
					<label class="col-sm-2 control-label" for="amount">支持金额：</label>
					<div class="col-sm-4">
					  <input class="form-control" type="text" name="amount"  id="amount" placeholder="支持金额" required>
					</div>
			</div>
		    <div class="form-group">
					<label class="col-sm-2 control-label" for="reward">回报内容：</label>
					<div class="col-sm-4">
					  <textarea class="form-control" rows="4" id="reward" name="reward" placeholder="回报内容"></textarea>
					</div>
			</div>
		    <div class="form-group">
					<label class="col-sm-2 control-label" for="limit">名额：</label>
					<div class="col-sm-4">
					  <input class="form-control" type="text" name="limit"  id="limit" placeholder="名额" required>
					</div>
			</div>
			
		    <div class="form-group">
		    		<div class="col-sm-4">
					</div>
					<div class="col-sm-2">
					  <button type="submit" id="add" class="btn btn-info btn-block" >添加</button>
					</div>
			</div>
		</div>
		</form>
	  </div>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
		<h3 class="panel-title">众筹</h3>
		</div>
		<form class="form-horizontal" role="form" id="settingForm" action="${id!}/activityCrowdfunding/setting" method="POST">
		<div class="panel-body">
				<input type="hidden" id="id" value="${id!}">
				<input type="hidden" name="id" value="${(setting.id)!}">
			<div class="form-horizontal">
			    <div class="form-group">
						<label class="col-sm-2 control-label" for="amount">筹资金额：</label>
						<div class="col-sm-4">
						  <input class="form-control" type="text" name="amount"  id="amount" placeholder="筹资金额" value="${(setting.amount)!}" required>
						</div>
				</div>				
			    <div class="form-group">
						<label class="col-sm-2 control-label" for="highLines">筹资上限：</label>
						<div class="col-sm-4">
						  <input class="form-control" type="text" name="highLines"  id="highLines"  value="${(setting.highLines)!}" placeholder="筹资上限" required>
						</div>
				</div>				
			    <div class="form-group">
						<label class="col-sm-2 control-label" for="days">筹资天数：</label>
						<div class="col-sm-4">
						  <input class="form-control" type="text" name="days"  id="days" placeholder="筹资天数"  value="${(setting.days)!}" required>
						</div>
				</div>				
			</div>
		</div>
		<div class="panel-heading">
			<h3 class="panel-title">收款信息</h3>
		</div>
		<div class="panel-body">
			 <div class="form-horizontal"  >
			 <div class="form-group">
				<label class="col-sm-2 control-label" for="accountType">账户类型：</label>
				<#if (setting.accountType)?? && (setting.accountType)! == 1>
					<div class="col-sm-2">
					  <input  type="radio" name="accountType" value="0" >个人账户
					</div>
					<div class="col-sm-2">
					  <input  type="radio" name="accountType" value="1" checked>公司账户
					</div>					
				<#else>
					<div class="col-sm-2">
					  <input  type="radio" name="accountType" value="0" checked>个人账户
					</div>
					<div class="col-sm-2">
					  <input  type="radio" name="accountType" value="1" >公司账户
					</div>
				</#if>
			 </div>
			 <div class="form-group">
				<label class="col-sm-2 control-label" for="accountName">收款人姓名：</label>
				<div class="col-sm-4">
				  <input class="form-control" type="text" name="accountName" id="accountName"  value="${(setting.accountName)!}" required>
				</div>
			 </div>
			 <div class="form-group">
				<label class="col-sm-2 control-label" for="bank">银行：</label>
				<div class="col-sm-4">
				  <select name="accountBank" class="form-control">
				  	<#list banks as bank>
				  		<#if (setting.accountBank)?? && (setting.accountBank)! == (bank.id)!>
				  			<option value="${(bank.id)!}" selected>${(bank.name)!}</option>
				  		<#else>
				  			<option value="${(bank.id)!}">${(bank.name)!}</option>
				  		</#if>
				  	</#list>
				  </select>
				</div>
			 </div>
			 <div class="form-group">
				<label class="col-sm-2 control-label" for="subBank">支行：</label>
				<div class="col-sm-4">
				  <input class="form-control" type="text" name="subBank" id="subBank"  value="${(setting.subBank)!}" required>
				</div>
			 </div>
			 <div class="form-group">
				<label class="col-sm-2 control-label" for="accountNumber">银行卡号：</label>
				<div class="col-sm-4">
				  <input class="form-control" type="text" id="accountNumber" name="accountNumber"  value="${(setting.accountNumber)!}" >
				</div>
			 </div>
			 <div class="form-group">
				<label class="col-sm-2 control-label" for="accountNumber2">确认银行卡号：</label>
				<div class="col-sm-4">
				  <input class="form-control" type="text" id="accountNumber2"  value="${(setting.accountNumber)!}">
				</div>
			 </div>
			 <div class="form-group">
				<div class="col-sm-2">
				  <button type="button" class="btn btn-info btn-block" onclick="javascript:location.href='activity?step=SEVENTH&activityId=${id!}';">上一步</button>
				</div>
				<div class="col-sm-2">
				  <button type="submit" id="save" class="btn btn-info btn-block" >保存</button>
				</div>
				<div class="col-sm-2">
				  <button type="submit" id="deploy" class="btn btn-info btn-block" >发布</button>
				</div>
				<input type="hidden" id="submitType" value="">
			 </div>
			  
			</div>
			</form>
		</div>
	</div>
	
  </div>

<script src="${ (project.staticDomain)! }/libs/jquery/jquery-2.0.3.js"></script>
<script src="${ (project.staticDomain)! }/libs/jquery-form/jquery.form.js"></script>
<script src="${ (project.staticDomain)! }/libs/Zebra_Dialog/js/zebra_dialog.js"></script>
<script src="${ (project.staticDomain)! }/libs/My97DatePicker/WdatePicker.js"></script>
<script src="${ (project.staticDomain)! }/js/common.js"></script>
<script src="${ (project.staticDomain)! }/js/activity/crowdfunding.js"></script> 



