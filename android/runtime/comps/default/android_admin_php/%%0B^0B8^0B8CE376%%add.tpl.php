<?php /* Smarty version 2.6.18, created on 2015-06-02 14:29:16
         compiled from message/add.tpl */ ?>
<?php $_smarty_tpl_vars = $this->_tpl_vars;
$this->_smarty_include(array('smarty_include_tpl_file' => "public/header.tpl", 'smarty_include_vars' => array()));
$this->_tpl_vars = $_smarty_tpl_vars;
unset($_smarty_tpl_vars);
 ?>
		<div id="main">
			<div class="head-dark-box">
				<div class="tit">内容管理>发布信息管理>添加约跑信息</div>
			</div>	
		    <?php $_smarty_tpl_vars = $this->_tpl_vars;
$this->_smarty_include(array('smarty_include_tpl_file' => "public/title.tpl", 'smarty_include_vars' => array()));
$this->_tpl_vars = $_smarty_tpl_vars;
unset($_smarty_tpl_vars);
 ?>
		    <form  method="post" action="<?php echo $this->_tpl_vars['url']; ?>
/insert">
			<div class="msg-box">
				<ul class="viewmess">
					<li class="light-row">
						<span class="col_width">发布者ID&nbsp;&nbsp;&nbsp;<span class="red_font">*</span></span>
						<input name="user_id" type="text" class="text-box"> 只能输入已存在用户ID
					</li>
					
					<li class="dark-row">
						<span class="col_width">发布信息ID<span class="red_font">*</span></span>
						<input name="contents_id" type="text" class="text-box"> 只能输入整数
					</li>

					<li class="light-row">
						<span class="col_width">信息内容<span class="red_font">*</span></span>
						<textarea class="text-box" name="contents" cols="40" rows="5"></textarea>
					</li>

					<li class="dark-row">
						<span class="col_width">发布日期<span class="red_font">*</span></span>
						<input name="post_time" id="pt" type="text" class="text-box">
						<input name="click" type="button" onclick="showDate()" value="获取时间">
					</li>

					<li class="light-row">
						<span class="col_width">出发学校<span class="red_font">*</span></span>
						<input name="school" type="text" class="text-box">
					</li>

					<li class="dark-row">
						<span class="col_width">出发时间<span class="red_font">*</span></span>
						<input name="start_time" type="text" class="text-box"> 格式 2000-01-01 00:00:00
					</li>

					<li class="light-row">
						<span class="col_width">发布者<span class="red_font">*</span></span>
						<input name="poster_name" type="text" class="text-box">
					</li>

					<li class="dark-row">
						<span class="col_width"> &nbsp; </span>
						<input type="submit" class="button"  value="添 加">&nbsp;&nbsp;
						<input type="reset" class="button" value="重 置">
					</li>
				</ul>	
			</div>
                    </form>	
		</div>
		<script>
			function showDate(){
				var today = new Date();
				var year = today.getFullYear();
				var month = (today.getMonth()+1 < 10) ? ('0'+(today.getMonth()+1)) : (today.getMonth()+1);
				var day = today.getDate() < 10 ? ('0'+today.getDate()) : today.getDate();
				var hours = today.getHours() < 10 ? ('0'+today.getHours()) : today.getHours();
				var minutes = today.getMinutes() < 10 ? ('0' + today.getMinutes()) : today.getMinutes();
				var seconds = today.getSeconds() < 10 ? ('0' + today.getSeconds()) : today.getSeconds();
				var date = year + "-" + month + "-" + day + " " + hours +":" + minutes + ":" + seconds;
				document.getElementById("pt").value = date;
			} 
		</script>
<?php $_smarty_tpl_vars = $this->_tpl_vars;
$this->_smarty_include(array('smarty_include_tpl_file' => "public/footer.tpl", 'smarty_include_vars' => array()));
$this->_tpl_vars = $_smarty_tpl_vars;
unset($_smarty_tpl_vars);
 ?>	

