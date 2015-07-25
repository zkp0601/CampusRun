<?php /* Smarty version 2.6.18, created on 2015-05-27 23:26:11
         compiled from login/index.tpl */ ?>
<html>
	<head>
		<title> Campus Run 后台管理系统 </title>
		<meta http-equiv="Windows-Target" content="_top" />
		<meta http-equiv="content-type" content="text/html;charset=utf-8" />
		<meta name="Author" content="高洛峰" />
		<meta name="Keywords" content="php,lampbrother" />
		<meta http-equiv="Windows-Target" content="_top" />
		<link rel="stylesheet" type="text/css" href="<?php echo $this->_tpl_vars['res']; ?>
/css/style.css" />
	</head>

<body class="center" onload="document.getElementById('login-form').username.focus()">
<div id="login-box">
<div id="main">
	<div class="head-dark-box">
		&nbsp;<b> Campus Run 后台管理登录</b>
	</div>

	<form method="post" action="<?php echo $this->_tpl_vars['url']; ?>
/prologin" id="login-form">
		<ul>	
			<li style="height:25px" class="dark-row" >
				<span class="list_width_login">用户名</span>
				<input type="text" class="text-box" size="15" name="username">
			</li>
			<li style="height:25px" class="light-row">
				<span class="list_width_login">密&nbsp;&nbsp;&nbsp;码</span>
				<input type="password" class="text-box" size="15" name="userpwd">
			</li>
			<li style="height:25px" class="dark-row">
				<span class="list_width_login">验证码</span>
				<input type="text" onkeyup="if (this.value != this.value.toUpperCase()) this.value=this.value.toUpperCase();"  class="text-box" size="6" name="code" />
				<img style="cursor:pointer;" alt="看不清，换一张" onclick="this.src='<?php echo $this->_tpl_vars['url']; ?>
/code/'+Math.random()" src="<?php echo $this->_tpl_vars['url']; ?>
/code" />
			</li>
			<li style="height:25px" class="light-row">
				<span class="list_width_login">&nbsp;</span>
				<input type="submit" class="button" value="登录系统" />
			</li>
		</ul>
	</form>
</div>
</div>
</body>
</html>
