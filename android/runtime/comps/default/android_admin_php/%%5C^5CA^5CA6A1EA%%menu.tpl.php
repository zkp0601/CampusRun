<?php /* Smarty version 2.6.18, created on 2015-05-27 23:26:17
         compiled from index/menu.tpl */ ?>
<?php $_smarty_tpl_vars = $this->_tpl_vars;
$this->_smarty_include(array('smarty_include_tpl_file' => "public/header.tpl", 'smarty_include_vars' => array()));
$this->_tpl_vars = $_smarty_tpl_vars;
unset($_smarty_tpl_vars);
 ?>
	<div id="menu">
		<div class="option">
			<div class="menutitle">【管理选项】</div>
			<div class="content">
				<ul>
					<li class="opt">
						<a href="<?php echo $this->_tpl_vars['url']; ?>
/main" onclick="switchmenu('optionmenu','menulist',0)" target="main">
						<img onmouseover="cimg(this)" onmouseout="cimg(this)" border="0" src="<?php echo $this->_tpl_vars['res']; ?>
/images/system_d.gif"><br>系统管理</a>
					</li>
					<li class="opt">
						<a href="<?php echo $this->_tpl_vars['url']; ?>
/main" onclick="switchmenu('optionmenu','menulist',1)" target="main">
						<img onmouseover="cimg(this)" onmouseout="cimg(this)" border="0" src="<?php echo $this->_tpl_vars['res']; ?>
/images/article_d.gif"><br>
						内容管理</a>
					</li>
					<li class="opt">	
						 <a href="<?php echo $this->_tpl_vars['url']; ?>
/main" onclick="switchmenu('optionmenu','menulist',2)" target="main">
						 <img onmouseover="cimg(this)" onmouseout="cimg(this)" border="0" src="<?php echo $this->_tpl_vars['res']; ?>
/images/user_d.gif"><br>
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
				<?php if ($_SESSION['webadmin']): ?>					
				<h4 onclick="domenu(this, 'list1')" class="tit">--常规管理--</h4>
				<ul id="list1">
					<li><a class="list" href="<?php echo $this->_tpl_vars['app']; ?>
/system_info/sysinfo" target="main">系统信息</a></li>
					<li><a class="list" href="<?php echo $this->_tpl_vars['app']; ?>
/system_info/baseset" target="main">基本设置</a></li>
					<li><a class="list" href="<?php echo $this->_tpl_vars['app']; ?>
/system_info/upcache" target="main">更新缓存</a></li>
				</ul>
				<?php else: ?>
					<h4>没有系统管理权限, 请重新登录</h4>
				<?php endif; ?>
			</div>

			<div>
			<?php if ($_SESSION['contentsadmin']): ?>
				<h4 onclick="domenu(this, 'list21')" class="tit">--发布信息管理--</h4>
				<ul id="list21">
					<li><a class="list" href="<?php echo $this->_tpl_vars['app']; ?>
/message/index" target="main">查看约跑信息</a></li>
					<li><a class="list" href="<?php echo $this->_tpl_vars['app']; ?>
/message/add" target="main">添加约跑信息</a></li>
				</ul>
				<h4 onclick="domenu(this, 'list22')" class="tit">--运动记录管理--</h4>
				<ul id="list22">
					<li><a class="list" href="<?php echo $this->_tpl_vars['app']; ?>
/run_record/index" target="main">查看运动记录</a></li>
				</ul>
				<h4 onclick="domenu(this, 'list23')" class="tit">--游戏记录管理--</h4>
				<ul id="list23">
					<li><a class="list" href="<?php echo $this->_tpl_vars['app']; ?>
/game_record/index" target="main">查看游戏记录</a></li>
					<li><a class="list" href="<?php echo $this->_tpl_vars['app']; ?>
/game_record/add" target="main">添加游戏记录</a></li>
				</ul>
				<?php else: ?>
				<h4>没有发布信息管理权限, 请重新登录</h4>
				<?php endif; ?>
				</div>

			<div>
			<?php if ($_SESSION['useradmin']): ?>
				<h4 onclick="domenu(this, 'list31')" class="tit">--用户帐号管理--</h4>
				<ul id="list31">
					<li><a class="list" href="<?php echo $this->_tpl_vars['app']; ?>
/user/index" target="main">查看用户帐号</a></li>
					<li><a class="list" href="<?php echo $this->_tpl_vars['app']; ?>
/user/add" target="main">添加用户帐号</a></li>
				</ul>
				<h4 onclick="domenu(this, 'list32')" class="tit">--用户信息管理--</h4>
				<ul id="list32">
					<li><a class="list" href="<?php echo $this->_tpl_vars['app']; ?>
/person_info/index" target="main">查看用户信息</a></li>
				</ul>
			<?php else: ?>
				<h4>没有用户管理权限, 请重新登录</h4>
			<?php endif; ?>
			</div>
		</div>
	</div>
</div>
<?php $_smarty_tpl_vars = $this->_tpl_vars;
$this->_smarty_include(array('smarty_include_tpl_file' => "public/footer.tpl", 'smarty_include_vars' => array()));
$this->_tpl_vars = $_smarty_tpl_vars;
unset($_smarty_tpl_vars);
 ?>

