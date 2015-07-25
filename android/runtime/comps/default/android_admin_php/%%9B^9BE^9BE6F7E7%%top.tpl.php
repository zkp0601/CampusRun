<?php /* Smarty version 2.6.18, created on 2015-05-27 23:26:17
         compiled from index/top.tpl */ ?>
<?php $_smarty_tpl_vars = $this->_tpl_vars;
$this->_smarty_include(array('smarty_include_tpl_file' => "public/header.tpl", 'smarty_include_vars' => array()));
$this->_tpl_vars = $_smarty_tpl_vars;
unset($_smarty_tpl_vars);
 ?>	
	<div id="top">
			<div class="left">
				<a herf="index.php"><img  border="0" src="<?php echo $this->_tpl_vars['res']; ?>
/images/logo.gif"></a>
			</div>

		
			<div class="right_tool">
					<ul>
						<li><a href="<?php echo $this->_tpl_vars['app']; ?>
/login/logout" onclick="return confirm('你确定要退出系统吗？')" target="_top"><img border=0 src="<?php echo $this->_tpl_vars['res']; ?>
/images/exit3.gif"></a></li>
					</ul>
			</div>
			<div class="right_user">
				<b>欢迎您-</b>&nbsp;【<?php echo $_SESSION['username']; ?>
】 &nbsp;&nbsp;
			</div>
		</div>
<?php $_smarty_tpl_vars = $this->_tpl_vars;
$this->_smarty_include(array('smarty_include_tpl_file' => "public/footer.tpl", 'smarty_include_vars' => array()));
$this->_tpl_vars = $_smarty_tpl_vars;
unset($_smarty_tpl_vars);
 ?>