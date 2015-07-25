<?php /* Smarty version 2.6.18, created on 2015-06-02 14:39:18
         compiled from run_record/index.tpl */ ?>
<?php $_smarty_tpl_vars = $this->_tpl_vars;
$this->_smarty_include(array('smarty_include_tpl_file' => "public/header.tpl", 'smarty_include_vars' => array()));
$this->_tpl_vars = $_smarty_tpl_vars;
unset($_smarty_tpl_vars);
 ?>
		<div id="main">
			<div class="head-dark-box">
				<div class="tit">内容管理>运动记录管理>查看运动记录</div>
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
						<span class="list_width width_font" style="width:10%">总运动路程</span>
						<span class="list_width width_font" style="width:10%">总运动时间</span>
						<span class="list_width width_font" style="width:10%">上次运动路程</span>
						<span class="list_width width_font" style="width:10%">上次运动时间</span>
						<span class="list_width width_font" style="width:10%">卡路里总消耗量</span>
						<span class="list_width width_font" style="width:10%">卡路里上次消耗量</span>
						<span class="list_width width_font">操&nbsp;&nbsp;作</span>
					</li>
				    <?php echo $this->_tpl_vars['show_all_the_run_record']; ?>

				</ul>	
			</div>
                   
		</div>
<?php $_smarty_tpl_vars = $this->_tpl_vars;
$this->_smarty_include(array('smarty_include_tpl_file' => "public/footer.tpl", 'smarty_include_vars' => array()));
$this->_tpl_vars = $_smarty_tpl_vars;
unset($_smarty_tpl_vars);
 ?>	

