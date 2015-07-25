<?php /* Smarty version 2.6.18, created on 2015-05-27 23:46:58
         compiled from user/edit.tpl */ ?>
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
		    <form  method="post" action="<?php echo $this->_tpl_vars['url']; ?>
/update?user_id=<?php echo $this->_tpl_vars['user_id']; ?>
">
			<div class="msg-box">
				<ul class="viewmess">
					<li class="dark-row">
						<span class="col_width">用户ID&nbsp;:</span>
						<?php echo $this->_tpl_vars['user_id']; ?>

					</li>

					<li class="light-row">
						<span class="col_width">用户帐号:</span>
						<?php echo $this->_tpl_vars['user_name']; ?>

					</li>
					
					<li class="dark-row">
						<span class="col_width">用户密码<span class="red_font">*</span></span>
						<input name="user_pass" type="text" style="width:250px" value="<?php echo $this->_tpl_vars['user_pass']; ?>
" class="text-box"> 当前显示的为md5加密后的密文，输入新的密码即可
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
<?php $_smarty_tpl_vars = $this->_tpl_vars;
$this->_smarty_include(array('smarty_include_tpl_file' => "public/footer.tpl", 'smarty_include_vars' => array()));
$this->_tpl_vars = $_smarty_tpl_vars;
unset($_smarty_tpl_vars);
 ?>	

