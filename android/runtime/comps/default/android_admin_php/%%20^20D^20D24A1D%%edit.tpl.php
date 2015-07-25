<?php /* Smarty version 2.6.18, created on 2015-06-02 14:27:45
         compiled from message/edit.tpl */ ?>
<?php $_smarty_tpl_vars = $this->_tpl_vars;
$this->_smarty_include(array('smarty_include_tpl_file' => "public/header.tpl", 'smarty_include_vars' => array()));
$this->_tpl_vars = $_smarty_tpl_vars;
unset($_smarty_tpl_vars);
 ?>
		<div id="main">
			<div class="head-dark-box">
				<div class="tit">内容管理>发布信息管理>编辑约跑信息</div>
			</div>	
		    <?php $_smarty_tpl_vars = $this->_tpl_vars;
$this->_smarty_include(array('smarty_include_tpl_file' => "public/title.tpl", 'smarty_include_vars' => array()));
$this->_tpl_vars = $_smarty_tpl_vars;
unset($_smarty_tpl_vars);
 ?>
		    <form  method="post" action="<?php echo $this->_tpl_vars['url']; ?>
/update">
			<div class="msg-box">
				<ul class="viewmess">
					<input type="hidden" name="user_id" value="<?php echo $this->_tpl_vars['user_id']; ?>
">
					<input type="hidden" name="contents_id" value="<?php echo $this->_tpl_vars['contents_id']; ?>
">

					<li class="light-row">
						<span class="col_width">出发时间<span class="red_font">*</span></span>
						<input name="start_time" type="text" value="<?php echo $this->_tpl_vars['start_time']; ?>
" class="text-box"> 格式为 2000-01-01 00:00:00
					</li>

					<li class="dark-row">
						<span class="col_width" style="margin-top:30px">信息内容<span class="red_font">*</span></span>
						<textarea class="text-box" name="contents" cols="40" rows="5"><?php echo $this->_tpl_vars['contents']; ?>
</textarea>
					</li>

					<li class="light-row">
						<span class="col_width">出发学校<span class="red_font">*</span></span>
						<input name="school" type="text" value="<?php echo $this->_tpl_vars['school']; ?>
" class="text-box">
					</li>

					<li class="dark-row">
						<span class="col_width">接受者ID<span class="red_font">*</span></span>
						<input name="receiver_id" type="text" value="<?php echo $this->_tpl_vars['receiver_id']; ?>
" class="text-box"> 不用ID以#隔开
					</li>
				
					<li class="light-row">
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

