<{include file="public/header.tpl"}>
	<div id="menu">
		<div class="option">
			<div class="menutitle">【管理选项】</div>
			<div class="content">
				<ul>
					<li class="opt">
						<a href="<{$url}>/main" onclick="switchmenu('optionmenu','menulist',0)" target="main">
						<img onmouseover="cimg(this)" onmouseout="cimg(this)" border="0" src="<{$res}>/images/system_d.gif"><br>系统管理</a>
					</li>
					<li class="opt">
						<a href="<{$url}>/main" onclick="switchmenu('optionmenu','menulist',1)" target="main">
						<img onmouseover="cimg(this)" onmouseout="cimg(this)" border="0" src="<{$res}>/images/article_d.gif"><br>
						内容管理</a>
					</li>
					<li class="opt">	
						 <a href="<{$url}>/main" onclick="switchmenu('optionmenu','menulist',2)" target="main">
						 <img onmouseover="cimg(this)" onmouseout="cimg(this)" border="0" src="<{$res}>/images/user_d.gif"><br>
						 用户管理</a>
					</li>
				</ul>
			 </div>
		</div>

		<div class="nav"> </div>
		<div class="option">
			<div id="optionmenu" class="menutitle">【系统管理】</div>
			<div id="menulist" class="content"> 
				<div style="display:block">
				<{if $smarty.session.webadmin}>					
				<h4 onclick="domenu(this, 'list1')" class="tit">--常规管理--</h4>
				<ul id="list1">
					<li><a class="list" href="<{$app}>/system_info/sysinfo" target="main">系统信息</a></li>
					<li><a class="list" href="<{$app}>/system_info/baseset" target="main">基本设置</a></li>
					<li><a class="list" href="<{$app}>/system_info/upcache" target="main">更新缓存</a></li>
				</ul>
				<{else}>
					<h4>没有系统管理权限, 请重新登录</h4>
				<{/if}>
			</div>

			<div>
			<{if $smarty.session.contentsadmin}>
				<h4 onclick="domenu(this, 'list21')" class="tit">--发布信息管理--</h4>
				<ul id="list21">
					<li><a class="list" href="<{$app}>/message/index" target="main">查看约跑信息</a></li>
					<li><a class="list" href="<{$app}>/message/add" target="main">添加约跑信息</a></li>
				</ul>
				<h4 onclick="domenu(this, 'list22')" class="tit">--运动记录管理--</h4>
				<ul id="list22">
					<li><a class="list" href="<{$app}>/run_record/index" target="main">查看运动记录</a></li>
				</ul>
				<h4 onclick="domenu(this, 'list23')" class="tit">--游戏记录管理--</h4>
				<ul id="list23">
					<li><a class="list" href="<{$app}>/game_record/index" target="main">查看游戏记录</a></li>
					<li><a class="list" href="<{$app}>/game_record/add" target="main">添加游戏记录</a></li>
				</ul>
				<{else}>
				<h4>没有发布信息管理权限, 请重新登录</h4>
				<{/if}>
				</div>

			<div>
			<{if $smarty.session.useradmin}>
				<h4 onclick="domenu(this, 'list31')" class="tit">--用户帐号管理--</h4>
				<ul id="list31">
					<li><a class="list" href="<{$app}>/user/index" target="main">查看用户帐号</a></li>
					<li><a class="list" href="<{$app}>/user/add" target="main">添加用户帐号</a></li>
				</ul>
				<h4 onclick="domenu(this, 'list32')" class="tit">--用户信息管理--</h4>
				<ul id="list32">
					<li><a class="list" href="<{$app}>/person_info/index" target="main">查看用户信息</a></li>
				</ul>
			<{else}>
				<h4>没有用户管理权限, 请重新登录</h4>
			<{/if}>
			</div>
		</div>
	</div>
</div>
<{include file="public/footer.tpl"}>


