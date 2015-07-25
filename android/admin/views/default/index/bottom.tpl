<{include file="public/header.tpl"}>	
		<div id="bottom">
			<ul>
				<li class="left">Version:1.0 &nbsp;&nbsp;Author：郑恺培、庄泽帆、周佳麒、张伟越、周德友、邹洁婷</li>
					<li class="right"> 
						本后台现有：
						<{if $smarty.session.webadmin}>
							<a target="main" href="<{$app}>/message/index">约跑信息【<span class="red_font"><{$message_num}></span>】条&nbsp;</a>
						<{/if}>
						<{if $smarty.session.useradmin}>
							<a target="main" href="<{$app}>/user/index">用户【<span class="red_font"><{$users_num}></span>】个 </a>&nbsp; &nbsp; 
						<{/if}>
					</li>	
			</ul>	
		</div>
<{include file="public/footer.tpl"}>	


