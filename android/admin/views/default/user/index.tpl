<{include file="public/header.tpl"}>
		<div id="main">
			<div class="head-dark-box">
				<div class="tit">用户管理>用户帐号管理>查看用户帐号</div>
			</div>	
		    <{ include file="public/title.tpl" }>	  
			<div class="msg-box">
				<ul class="viewmess">
				
					<li class="dark-row">
						<span class="list_width width_font">用户ID</span>
						<span class="list_width width_font" style="width:18%">用户帐号</span>
						<span class="list_width width_font" style="width:36%">用户密码</span>
						<span class="list_width width_font">操&nbsp;&nbsp;作</span>
					</li>
				       
					<{ $show_users }>
				</ul>	
			</div>
                   
		</div>
<{include file="public/footer.tpl"}>	


