<style>
textarea{
	padding:8px 5px;
}
.btn_box2{
 	text-align:center;
 }
.btn_box2 input{
	width: 253px;
    height: 42px;
    color: #fff;
    border: 0 none;
    margin: 0 auto;
    font-family: "微软雅黑";
    background-color:#e62f17;
    -moz-border-radius: 3px;      /* Gecko browsers */
    -webkit-border-radius: 3px;   /* Webkit browsers */
    border-radius:3px;            /* W3C syntax */
    cursor:pointer;
}
.addManager{
	float:right;
}
.longInput{
	width:715px!important;
}
dt{
	font-weight: bold;
}
</style>
<body>
<div class="jr_w">
		<div class="banner"></div>
		<div class="inner">
			<form>
				<dl>
					<dt>公司信息<span></span></dt>
					<dd class="clearfix">
							<label class="fl label_1">名称</label>
							<div class="textarea">
								<input type="text" id="companyName" class="fl longInput" >
							</div>
					</dd>
					<dd class="clearfix">
							<label class="fl label_1">网址</label>
							<div class="textarea">
								<input type="text" id="webSite" class="fl longInput" >
							</div>
					</dd>
					<dd class="clearfix">
							<label class="fl label_1">公众号</label>
							<div class="textarea">
								<input type="text" id="publicNum" class="fl longInput" >
							</div>
					</dd>
				</dl>
				<dl id="managerArea">
					<dt>核心管理层</dt>
					<div name="manager">
						<dd class="clearfix">
							<p class="addManager"><a name="delBtn" href="javascript:void(0);" class="add_gzjl">删除</a></p>
						</dd>
						<dd class="clearfix">
								<label class="fl label_1">姓名</label>
								<div class="textarea">
									<input type="text"  name="name" class="fl longInput" >
								</div>
						</dd>
						<dd class="clearfix">
								<label class="fl label_1">职务</label>
								<div class="textarea">
									<input type="text" name="position" class="fl longInput" >
								</div>
						</dd>
						
						<dd class="clearfix">
							<label class="fl label_1">教育背景</label>
							<div class="textarea">
								<textarea name="education"></textarea>
							</div>
						</dd>
						<dd class="clearfix">
							<label class="fl label_1">工作经历</label>
							<div class="textarea">
								<textarea name="career"></textarea>
							</div>
						</dd>
					</div>
				</dl>
				<dl>
					<dd class="clearfix">
						<p class="addManager"><a id="addMag" href="javascript:void(0);" class="add_gzjl">添加核心管理层</a></p>
					</dd>
				</dl>
				<dl>
					<dt>公司产品或拟申报项目简介<span>（产品应用范围，技术创新点 ，项目进展，发展规划）   </span></dt>
					<dd class="clearfix">
						<label class="fl label_1">项目简介</label>
						<div class="textarea">
							<textarea id="description"></textarea>
						</div>
					</dd>
				</dl>
				<dl>
					<dt>联系人信息<span></span></dt>
					<dd class="clearfix">
							<label class="fl label_1">姓名</label>
							<div class="textarea">
								<input type="text" id="name" class="fl longInput" >
							</div>
					</dd>
					<dd class="clearfix">
							<label class="fl label_1">邮箱</label>
							<div class="textarea">
								<input type="text" id="email" class="fl longInput" >
							</div>
					</dd>
					<dd class="clearfix">
							<label class="fl label_1">手机</label>
							<div class="textarea">
								<input type="text" id="phone" class="fl longInput" >
							</div>
					</dd>
					
				</dl>
				<div class="btn_box2" >
						<input id="saveBtn" type="button" value="提交">
				</div>
			</form>
		</div>
	</div>	
</body>
<script src="${ (project.staticDomain)! }/libs/jquery/jquery-2.0.3.js"></script>
<script src="${ (project.staticDomain)! }/js/common.js"></script>
<script src="${ (project.staticDomain)! }/libs/jquery/jquery.serializeObject.min.js"></script>
<script src="${ (project.staticDomain)! }/js/main/customer.js"></script>
