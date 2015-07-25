<?php /* Smarty version 2.6.18, created on 2015-05-27 23:26:24
         compiled from person_info/index.tpl */ ?>
<?php $_smarty_tpl_vars = $this->_tpl_vars;
$this->_smarty_include(array('smarty_include_tpl_file' => "public/header.tpl", 'smarty_include_vars' => array()));
$this->_tpl_vars = $_smarty_tpl_vars;
unset($_smarty_tpl_vars);
 ?>
		<div id="main">
			<div class="head-dark-box">
				<div class="tit">用户管理>用户信息管理>查看用户信息</div>
			</div>	
		    <?php $_smarty_tpl_vars = $this->_tpl_vars;
$this->_smarty_include(array('smarty_include_tpl_file' => "public/title.tpl", 'smarty_include_vars' => array()));
$this->_tpl_vars = $_smarty_tpl_vars;
unset($_smarty_tpl_vars);
 ?>	  
			<div class="msg-box">
				<ul class="viewmess">
					<li class="dark-row">
						<span class="list_width width_font" style="width:5%">用户ID</span>
						<span class="list_width width_font" style="width:5%">姓&nbsp;&nbsp;名</span>
						<span class="list_width width_font" style="width:5%">性&nbsp;&nbsp;别</span>
						<span class="list_width width_font" style="width:5%">年&nbsp;&nbsp;龄</span>
						<span class="list_width width_font" style="width:15%">学&nbsp;&nbsp;校</span>
						<span class="list_width width_font" style="width:15%">邮&nbsp;&nbsp;箱</span>
						<span class="list_width width_font">电&nbsp;&nbsp;话</span>
						<span class="list_width width_font">操&nbsp;&nbsp;作</span>
					</li>
					<?php echo $this->_tpl_vars['person_info']; ?>

				</ul>	
			</div>
                   
		</div>
<?php $_smarty_tpl_vars = $this->_tpl_vars;
$this->_smarty_include(array('smarty_include_tpl_file' => "public/footer.tpl", 'smarty_include_vars' => array()));
$this->_tpl_vars = $_smarty_tpl_vars;
unset($_smarty_tpl_vars);
 ?>	

