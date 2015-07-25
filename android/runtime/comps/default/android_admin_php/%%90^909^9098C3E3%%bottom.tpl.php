<?php /* Smarty version 2.6.18, created on 2015-05-27 23:26:17
         compiled from index/bottom.tpl */ ?>
<?php $_smarty_tpl_vars = $this->_tpl_vars;
$this->_smarty_include(array('smarty_include_tpl_file' => "public/header.tpl", 'smarty_include_vars' => array()));
$this->_tpl_vars = $_smarty_tpl_vars;
unset($_smarty_tpl_vars);
 ?>	
		<div id="bottom">
			<ul>
				<li class="left">Version:1.0 &nbsp;&nbsp;Author：郑恺培、庄泽帆、周佳麒、张伟越、周德友、邹洁婷</li>
					<li class="right"> 
						本后台现有：
						<?php if ($_SESSION['webadmin']): ?>
							<a target="main" href="<?php echo $this->_tpl_vars['app']; ?>
/message/index">约跑信息【<span class="red_font"><?php echo $this->_tpl_vars['message_num']; ?>
</span>】条&nbsp;</a>
						<?php endif; ?>
						<?php if ($_SESSION['useradmin']): ?>
							<a target="main" href="<?php echo $this->_tpl_vars['app']; ?>
/user/index">用户【<span class="red_font"><?php echo $this->_tpl_vars['users_num']; ?>
</span>】个 </a>&nbsp; &nbsp; 
						<?php endif; ?>
					</li>	
			</ul>	
		</div>
<?php $_smarty_tpl_vars = $this->_tpl_vars;
$this->_smarty_include(array('smarty_include_tpl_file' => "public/footer.tpl", 'smarty_include_vars' => array()));
$this->_tpl_vars = $_smarty_tpl_vars;
unset($_smarty_tpl_vars);
 ?>	

