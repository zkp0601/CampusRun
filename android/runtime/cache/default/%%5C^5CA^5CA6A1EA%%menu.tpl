194
a:4:{s:8:"template";a:3:{s:14:"index/menu.tpl";b:1;s:17:"public/header.tpl";b:1;s:17:"public/footer.tpl";b:1;}s:9:"timestamp";i:1437205349;s:7:"expires";i:1437205355;s:13:"cache_serials";a:0:{}}<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>无标题文档</title>
		<meta name="Author" content="高洛峰" />
		<meta name="Keywords" content="细说PHP" />
		<link rel="stylesheet" type="text/css" href="/android/admin/views/default/resource/css/style.css" />
		<script src="/android/public/js/ajax3.0.js"></script>
		<script src="/android/admin/views/default/resource/js/menu.js"></script>	
	</head>

	<body>	<div id="menu">
		<div class="option">
			<div class="menutitle">【管理选项】</div>
			<div class="content">
				<ul>
					<li class="opt">
						<a href="/android/admin.php/index/main" onclick="switchmenu('optionmenu','menulist',0)" target="main">
						<img onmouseover="cimg(this)" onmouseout="cimg(this)" border="0" src="/android/admin/views/default/resource/images/system_d.gif"><br>系统管理</a>
					</li>
					<li class="opt">
						<a href="/android/admin.php/index/main" onclick="switchmenu('optionmenu','menulist',1)" target="main">
						<img onmouseover="cimg(this)" onmouseout="cimg(this)" border="0" src="/android/admin/views/default/resource/images/article_d.gif"><br>
						内容管理</a>
					</li>
					<li class="opt">	
						 <a href="/android/admin.php/index/main" onclick="switchmenu('optionmenu','menulist',2)" target="main">
						 <img onmouseover="cimg(this)" onmouseout="cimg(this)" border="0" src="/android/admin/views/default/resource/images/user_d.gif"><br>
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
									
				<h4 onclick="domenu(this, 'list1')" class="tit">--常规管理--</h4>
				<ul id="list1">
					<li><a class="list" href="/android/admin.php/system_info/sysinfo" target="main">系统信息</a></li>
					<li><a class="list" href="/android/admin.php/system_info/baseset" target="main">基本设置</a></li>
					<li><a class="list" href="/android/admin.php/system_info/upcache" target="main">更新缓存</a></li>
				</ul>
							</div>

			<div>
							<h4 onclick="domenu(this, 'list21')" class="tit">--发布信息管理--</h4>
				<ul id="list21">
					<li><a class="list" href="/android/admin.php/message/index" target="main">查看约跑信息</a></li>
					<li><a class="list" href="/android/admin.php/message/add" target="main">添加约跑信息</a></li>
				</ul>
				<h4 onclick="domenu(this, 'list22')" class="tit">--运动记录管理--</h4>
				<ul id="list22">
					<li><a class="list" href="/android/admin.php/run_record/index" target="main">查看运动记录</a></li>
				</ul>
				<h4 onclick="domenu(this, 'list23')" class="tit">--游戏记录管理--</h4>
				<ul id="list23">
					<li><a class="list" href="/android/admin.php/game_record/index" target="main">查看游戏记录</a></li>
					<li><a class="list" href="/android/admin.php/game_record/add" target="main">添加游戏记录</a></li>
				</ul>
								</div>

			<div>
							<h4 onclick="domenu(this, 'list31')" class="tit">--用户帐号管理--</h4>
				<ul id="list31">
					<li><a class="list" href="/android/admin.php/user/index" target="main">查看用户帐号</a></li>
					<li><a class="list" href="/android/admin.php/user/add" target="main">添加用户帐号</a></li>
				</ul>
				<h4 onclick="domenu(this, 'list32')" class="tit">--用户信息管理--</h4>
				<ul id="list32">
					<li><a class="list" href="/android/admin.php/person_info/index" target="main">查看用户信息</a></li>
				</ul>
						</div>
		</div>
	</div>
</div>
	</body>
</html>

