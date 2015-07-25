<{include file="public/header.tpl"}>
		<div id="main">
			<div class="head-dark-box">
				<div class="tit">用户管理>用户帐号管理>添加用户帐号</div>
			</div>	
		    <{ include file="public/title.tpl" }>
		    <form  method="post" action="<{$url}>/insert">
			<div class="msg-box">
				<ul class="viewmess">
					<li class="light-row">
						<span class="col_width">用户名&nbsp;&nbsp;&nbsp;<span class="red_font">*</span></span>
						<input name="user_name" type="text" class="text-box">
						可以使用中文，但禁止除[@][.]以外的特殊符号
					</li>
					
					<li class="dark-row">
						<span class="col_width">用户密码&nbsp;&nbsp;&nbsp;<span class="red_font">*</span></span>
						<input name="user_pass" type="text" class="text-box"> 
					</li>
				
					<li class="dark-row">
						<span class="col_width"> &nbsp; </span>
						<input type="submit" class="button"  value="添 加">&nbsp;&nbsp;
						<input type="reset" class="button" value="重 置">
					</li>
				</ul>	
			</div>
                    </form>	
		</div>
<{include file="public/footer.tpl"}>	


