<?php /* Smarty version 2.6.18, created on 2015-06-02 14:27:20
         compiled from message/index.tpl */ ?>
<?php $_smarty_tpl_vars = $this->_tpl_vars;
$this->_smarty_include(array('smarty_include_tpl_file' => "public/header.tpl", 'smarty_include_vars' => array()));
$this->_tpl_vars = $_smarty_tpl_vars;
unset($_smarty_tpl_vars);
 ?>
		<div id="main">
			<div class="head-dark-box">
				<div class="tit">内容管理>发布信息管理>查看约跑信息</div>
			</div>	
		    <?php $_smarty_tpl_vars = $this->_tpl_vars;
$this->_smarty_include(array('smarty_include_tpl_file' => "public/title.tpl", 'smarty_include_vars' => array()));
$this->_tpl_vars = $_smarty_tpl_vars;
unset($_smarty_tpl_vars);
 ?>	  
			<div class="msg-box">
				<ul class="viewmess">
					<li class="dark-row">
						<span class="list_width width_font">发布者ID</span>
						<span class="list_width width_font" style="width:5%">本信息ID</span>
						<span class="list_width width_font" style="width:25%">内&nbsp;&nbsp;容</span>
						<span class="list_width width_font" style="width:15%">出发时间</span>
						<span class="list_width width_font" style="width:15%">约跑者学校</span>
						<span class="list_width width_font" style="width:6%">接受人数</span>
						<span class="list_width width_font">操&nbsp;&nbsp;作</span>
					</li>
				    <?php echo $this->_tpl_vars['show_all_the_message']; ?>

				</ul>	
			</div>
                   
		</div>
<?php $_smarty_tpl_vars = $this->_tpl_vars;
$this->_smarty_include(array('smarty_include_tpl_file' => "public/footer.tpl", 'smarty_include_vars' => array()));
$this->_tpl_vars = $_smarty_tpl_vars;
unset($_smarty_tpl_vars);
 ?>	

