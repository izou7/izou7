<style>
.form_box input,textarea{
font-size:15px;
}
</style>
<body>
	<div class="three_box">
		<div class="sub_nav">                  
			<a href="/contact" class="on">联系我们</a>
			|
			<a href="/join">加入我们</a>
			|
			<a href="/agency">代理政策</a>
		</div>
		<div class="intro_box">
			<p>
				付费用户：zhouzhou@ttjiazu.com
				<br/><br/>
				技术支持 &bugs反馈：zhangying@ttjiazu.com<br/>
				
				<br/>
				QQ群：107317233
			</p>
		</div>
		<div class="con_box con_form_box">
			<div class="hd">              
				<span>您也可以通过填写下面表单联系我们</span>
			</div>
			<div class="bd contact_bd">
				<form class="form_box" action="">
					<ul>
						<li>
							<input name="name" type="text" class="text" placeholder="姓名">
						</li>
						<li>
							<input name="email" type="text" class="text" placeholder="邮箱">
						</li>
						<li>
							<input name="phone" type="text" class="text"  placeholder="手机">
						</li>
						<li>
							<input name="company" type="text" class="text" placeholder="公司名称">
						</li>
						<li>
							<textarea name="description" class="textarea" placeholder="想说点什么..."></textarea>
						</li>
						<li>
							<button id="submitBtn" type="button"  class="submit_btn" ></button>
						</li>
					</ul>
				</form>
			</div>
		</div>
	</div>
</body>
<script src="${ (project.staticDomain)! }/libs/jquery/jquery-2.0.3.js"></script>
<script src="${ (project.staticDomain)! }/js/common.js"></script>
<script src="${ (project.staticDomain)! }/libs/jquery/jquery.serializeObject.min.js"></script>
<script src="${ (project.staticDomain)! }/js/main/contact.js"></script>
