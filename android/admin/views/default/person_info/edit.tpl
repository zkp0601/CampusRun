<{include file="public/header.tpl"}>
		<div id="main">
			<div class="head-dark-box">
				<div class="tit">用户管理>用户信息管理>编辑用户信息</div>
			</div>	
		    <{ include file="public/title.tpl" }>
		    <form  method="post" action="<{$url}>/update?user_id=<{$user_id}>">
			<div class="msg-box">
				<ul class="viewmess">
					<li class="light-row">
						<span class="col_width">用户ID</span>
						<{$user_id}>
					</li>

					<li class="dark-row">
						<span class="col_width">姓&nbsp;&nbsp;名<span class="red_font">*</span></span>
						<input name="name" type="text"  value="<{$name}>" class="text-box">
						可以使用真实姓名或昵称
					</li>
				
					<li class="light-row">
						<span class="col_width">性&nbsp;&nbsp;别<span class="red_font">*</span></span>
						<input name="sex" type="text"  value="<{$sex}>" class="text-box">
					</li>

					<li class="dark-row">
						<span class="col_width">年&nbsp;&nbsp;龄<span class="red_font">*</span></span>
						<input name="age" type="text"  value="<{$age}>" class="text-box">
					</li>

					<li class="light-row">
						<span class="col_width">学&nbsp;&nbsp;校<span class="red_font">*</span></span>
						<input name="school" type="text"  value="<{$school}>" class="text-box">
					</li>

					<li class="dark-row">
						<span class="col_width">邮&nbsp;&nbsp;箱<span class="red_font">*</span></span>
						<input name="email" type="text"  value="<{$email}>" class="text-box">
					</li>

					<li class="light-row">
						<span class="col_width">电&nbsp;&nbsp;话<span class="red_font">*</span></span>
						<input name="phone_num" type="text"  value="<{$phone_num}>" class="text-box">
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


