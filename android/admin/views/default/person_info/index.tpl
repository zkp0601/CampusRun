<{include file="public/header.tpl"}>
		<div id="main">
			<div class="head-dark-box">
				<div class="tit">用户管理>用户信息管理>查看用户信息</div>
			</div>	
		    <{ include file="public/title.tpl" }>	  
			<div class="msg-box">
				<ul class="viewmess">
					<li class="dark-row">
						<span class="list_width width_font" style="width:5%">用户ID</span>
						<span class="list_width width_font" style="width:5%">姓&nbsp;&nbsp;名</span>
						<span class="list_width width_font" style="width:5%">性&nbsp;&nbsp;别</span>
						<span class="list_width width_font" style="width:5%">年&nbsp;&nbsp;龄</span>
						<span class="list_width width_font" style="width:15%">学&nbsp;&nbsp;校</span>
						<span class="list_width width_font" style="width:15%">邮&nbsp;&nbsp;箱</span>
						<span class="list_width width_font">电&nbsp;&nbsp;话</span>
						<span class="list_width width_font">操&nbsp;&nbsp;作</span>
					</li>
					<{$person_info}>
				</ul>	
			</div>
                   
		</div>
<{include file="public/footer.tpl"}>	


