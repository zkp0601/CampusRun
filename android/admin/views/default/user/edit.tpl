<{include file="public/header.tpl"}>
		<div id="main">
			<div class="head-dark-box">
				<div class="tit">用户管理>用户帐号管理>查看用户帐号</div>
			</div>	
		    <{ include file="public/title.tpl" }>
		    <form  method="post" action="<{$url}>/update?user_id=<{$user_id}>">
			<div class="msg-box">
				<ul class="viewmess">
					<li class="dark-row">
						<span class="col_width">用户ID&nbsp;:</span>
						<{$user_id}>
					</li>

					<li class="light-row">
						<span class="col_width">用户帐号:</span>
						<{$user_name}>
					</li>
					
					<li class="dark-row">
						<span class="col_width">用户密码<span class="red_font">*</span></span>
						<input name="user_pass" type="text" style="width:250px" value="<{$user_pass}>" class="text-box"> 当前显示的为md5加密后的密文，输入新的密码即可
					</li>
				
					<li class="dark-row">
						<span class="col_width"> &nbsp; </span>
						<input type="submit" class="button"  value="修 改">&nbsp;&nbsp;
						<input type="reset" class="button" value="重 置">&nbsp;&nbsp;
					</li>
				</ul>	
			</div>
                    </form>	
		</div>
<{include file="public/footer.tpl"}>	


