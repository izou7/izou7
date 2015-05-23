<style>
.bspan{
 font-weight:bold;
}
.ltd{
float:left;
}
.p1, .p2{
text-align:left!important;
}
/*订单页公共样式*/
.order_process { border: 1px solid #e9e5e6; height: 37px; line-height: 37px; background: #f4f4f4; font-family: 'microsoft yahei'; font-size: 14px; width: 1000px;; }
.order_process ul { position: relative;; height: 37px; overflow: hidden; float: left; width: 100%; }
.order_process li { width: 25%; position: relative; text-align: center; float: left; z-index: 0; }
.order_process li.active { background: #fda6a3; color: #fff; }
.order_process li.active .order_ahead_arrow { background-position: top; }
.order_process li.active .order_behind_arrow { background-position: bottom; left: -19px; }
.order_process li .order_arrow { width: 19px; height: 37px; display: block; position: absolute; top: 0; right: -17px; background: url(${ (project.staticDomain)!}/images/order_arrow.png) 0 -40px no-repeat; z-index: 0; }

</style>
<body>

	<div class="fffw_w">
		<div class="inner">
			<div class="t_box">
				<div class="order_process">
			        <ul>
			            <li class="active">
			                网上申报
			                <span class="order_behind_arrow order_arrow"></span>
			                <span class="order_ahead_arrow order_arrow"></span>
			            </li>
			            <li>
			                专家审核
			                <span class="order_behind_arrow order_arrow"></span>
			                <span class="order_ahead_arrow order_arrow"></span>
			            </li>
			            <li>
			                提交材料
			                <span class="order_behind_arrow order_arrow"></span>
			                <span class="order_ahead_arrow order_arrow"></span>
			            </li>
			            <li>
			                等待结果
			                <span class="order_behind_arrow order_arrow"></span>
			                <span class="order_ahead_arrow order_arrow"></span>
			            </li>
			        </ul>
    			</div>
				
			</div>
			<div class="t_box">
				<p class="p1">需要准备材料</p>
				<p class="p2">全部需要提交的材料</p>
				<p class="p2">用户需要填写的表格</p>
			</div>
			<div class="t_box">
				<p class="p1">专家审核，网上提交</p>
				<p class="p2">材料合规完整，切合得分点，提高成功率</p>
			</div>
		</div>
	</div>
</body>
<script src="${ (project.staticDomain)! }/libs/jquery/jquery-2.0.3.js"></script>
<script src="${ (project.staticDomain)! }/js/common.js"></script>