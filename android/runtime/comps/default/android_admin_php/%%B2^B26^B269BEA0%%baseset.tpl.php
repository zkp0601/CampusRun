<?php /* Smarty version 2.6.18, created on 2015-06-15 12:54:19
         compiled from system_info/baseset.tpl */ ?>
<?php $_smarty_tpl_vars = $this->_tpl_vars;
$this->_smarty_include(array('smarty_include_tpl_file' => "public/header.tpl", 'smarty_include_vars' => array()));
$this->_tpl_vars = $_smarty_tpl_vars;
unset($_smarty_tpl_vars);
 ?>
		<div id="main">
		    	<div class="head-dark-box">
				<div class="tit">系统管理>常规设置>基本设置</div>
			</div>	
			<?php $_smarty_tpl_vars = $this->_tpl_vars;
$this->_smarty_include(array('smarty_include_tpl_file' => "public/title.tpl", 'smarty_include_vars' => array()));
$this->_tpl_vars = $_smarty_tpl_vars;
unset($_smarty_tpl_vars);
 ?>
		    <form  method="post" action="<?php echo $this->_tpl_vars['url']; ?>
/set" enctype="multipart/form-data">
			<div class="msg-box">
				<ul class="viewmess">
					<li class="dark-row">
						<span class="col_width">约跑信息每页显示数目</span>
						<input type="text" class="text-box" name="messagePageSize" size="10" value="<?php echo $this->_tpl_vars['varList']['messagePageSize']; ?>
"> 条/页			
					</li>
					<li class="light-row">
						<span class="col_width">查看用户每页显示数目</span>
						<input type="text" class="text-box" name="userPageSize" size="10" value="<?php echo $this->_tpl_vars['varList']['userPageSize']; ?>
"> 条/页				
					</li>
					<li class="dark-row">
						<span class="col_width">缓存设置</span>
						<input type="radio" name="cstart" <?php if ($this->_tpl_vars['varList']['cstart'] == '1'): ?>checked<?php endif; ?> value="1"> 开启 &nbsp;&nbsp;
						<input type="radio" name="cstart" <?php if ($this->_tpl_vars['varList']['cstart'] == '0' || $this->_tpl_vars['varList']['cstart'] == null): ?>checked<?php endif; ?> value="0"> 关闭
					</li>
					<li class="light-row">
						<span class="col_width">缓存时间</span>
						<input type="text" class="text-box" name="ctime" size="5" value="<?php echo $this->_tpl_vars['varList']['ctime']; ?>
"> 秒
					
					</li>
					<li class="dark-row">
						<span class="col_width">网站标题</span>
						<input type="text" class="text-box" name="appname" size="30" value="<?php echo $this->_tpl_vars['varList']['appname']; ?>
"> 显示在首页的标题栏
					
					</li>
					<li class="light-row">
						<span class="col_width">网站描述</span>
						<textarea type="text" class="text-box" name="description" cols="40" rows="5"><?php echo $this->_tpl_vars['varList']['description']; ?>
</textarea> 
					
					</li>
					<li class="dark-row">
						<span class="col_width">&nbsp;</span>
						<input type="submit" class="button" name="mod" value="修 改">&nbsp;&nbsp;
						<input type="reset" class="button" value="重置">&nbsp;&nbsp;
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

