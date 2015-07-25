<?php /* Smarty version 2.6.18, created on 2015-05-27 23:26:21
         compiled from user/index.tpl */ ?>
<?php $_smarty_tpl_vars = $this->_tpl_vars;
$this->_smarty_include(array('smarty_include_tpl_file' => "public/header.tpl", 'smarty_include_vars' => array()));
$this->_tpl_vars = $_smarty_tpl_vars;
unset($_smarty_tpl_vars);
 ?>
		<div id="main">
			<div class="head-dark-box">
				<div class="tit">用户管理>用户帐号管理>查看用户帐号</div>
			</div>	
		    <?php $_smarty_tpl_vars = $this->_tpl_vars;
$this->_smarty_include(array('smarty_include_tpl_file' => "public/title.tpl", 'smarty_include_vars' => array()));
$this->_tpl_vars = $_smarty_tpl_vars;
unset($_smarty_tpl_vars);
 ?>	  
			<div class="msg-box">
				<ul class="viewmess">
				
					<li class="dark-row">
						<span class="list_width width_font">用户ID</span>
						<span class="list_width width_font" style="width:18%">用户帐号</span>
						<span class="list_width width_font" style="width:36%">用户密码</span>
						<span class="list_width width_font">操&nbsp;&nbsp;作</span>
					</li>
				       
					<?php echo $this->_tpl_vars['show_users']; ?>

				</ul>	
			</div>
                   
		</div>
<?php $_smarty_tpl_vars = $this->_tpl_vars;
$this->_smarty_include(array('smarty_include_tpl_file' => "public/footer.tpl", 'smarty_include_vars' => array()));
$this->_tpl_vars = $_smarty_tpl_vars;
unset($_smarty_tpl_vars);
 ?>	

