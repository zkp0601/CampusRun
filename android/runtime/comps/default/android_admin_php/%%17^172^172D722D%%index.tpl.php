<?php /* Smarty version 2.6.18, created on 2015-06-15 12:54:11
         compiled from game_record/index.tpl */ ?>
<?php require_once(SMARTY_CORE_DIR . 'core.load_plugins.php');
smarty_core_load_plugins(array('plugins' => array(array('modifier', 'truncate', 'game_record/index.tpl', 21, false),)), $this); ?>
<?php $_smarty_tpl_vars = $this->_tpl_vars;
$this->_smarty_include(array('smarty_include_tpl_file' => "public/header.tpl", 'smarty_include_vars' => array()));
$this->_tpl_vars = $_smarty_tpl_vars;
unset($_smarty_tpl_vars);
 ?>
		<div id="main">
			<div class="head-dark-box">
				<div class="tit">内容管理>游戏记录管理>查看游戏记录</div>
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
						<span class="list_width width_font" style="width:400px">游戏记录</span>
						<span class="list_width width_font">操&nbsp;&nbsp;作</span>
					</li>
				        <?php unset($this->_sections['doc']);
$this->_sections['doc']['name'] = 'doc';
$this->_sections['doc']['loop'] = is_array($_loop=$this->_tpl_vars['groups']) ? count($_loop) : max(0, (int)$_loop); unset($_loop);
$this->_sections['doc']['show'] = true;
$this->_sections['doc']['max'] = $this->_sections['doc']['loop'];
$this->_sections['doc']['step'] = 1;
$this->_sections['doc']['start'] = $this->_sections['doc']['step'] > 0 ? 0 : $this->_sections['doc']['loop']-1;
if ($this->_sections['doc']['show']) {
    $this->_sections['doc']['total'] = $this->_sections['doc']['loop'];
    if ($this->_sections['doc']['total'] == 0)
        $this->_sections['doc']['show'] = false;
} else
    $this->_sections['doc']['total'] = 0;
if ($this->_sections['doc']['show']):

            for ($this->_sections['doc']['index'] = $this->_sections['doc']['start'], $this->_sections['doc']['iteration'] = 1;
                 $this->_sections['doc']['iteration'] <= $this->_sections['doc']['total'];
                 $this->_sections['doc']['index'] += $this->_sections['doc']['step'], $this->_sections['doc']['iteration']++):
$this->_sections['doc']['rownum'] = $this->_sections['doc']['iteration'];
$this->_sections['doc']['index_prev'] = $this->_sections['doc']['index'] - $this->_sections['doc']['step'];
$this->_sections['doc']['index_next'] = $this->_sections['doc']['index'] + $this->_sections['doc']['step'];
$this->_sections['doc']['first']      = ($this->_sections['doc']['iteration'] == 1);
$this->_sections['doc']['last']       = ($this->_sections['doc']['iteration'] == $this->_sections['doc']['total']);
?>
						<li class="<?php if (!(1 & $this->_sections['doc']['index'])): ?>light-row<?php else: ?>dark-row<?php endif; ?>" style="padding-top:10px; padding-bottom:10px">
							
							<span style="font-weight:bold" class="list_width"><a href="<?php echo $this->_tpl_vars['app']; ?>
/user/index/gid/<?php echo $this->_tpl_vars['groups'][$this->_sections['doc']['index']]['id']; ?>
"><?php echo $this->_tpl_vars['groups'][$this->_sections['doc']['index']]['groupname']; ?>
</a></span>
							
							<span class="list_width" style="width:400px"><?php echo ((is_array($_tmp=$this->_tpl_vars['groups'][$this->_sections['doc']['index']]['description'])) ? $this->_run_mod_handler('truncate', true, $_tmp, '50') : smarty_modifier_truncate($_tmp, '50')); ?>
</span>
						
							<span class="list_width" style="width:160px;">
						
							【<a href="<?php echo $this->_tpl_vars['url']; ?>
/mod/id/<?php echo $this->_tpl_vars['groups'][$this->_sections['doc']['index']]['id']; ?>
">修改</a>】
							<?php if ($this->_tpl_vars['groups'][$this->_sections['doc']['index']]['id'] != 1): ?>
							【<a onclick="return confirm('确定要删除用户组<?php echo $this->_tpl_vars['groups'][$this->_sections['doc']['index']]['username']; ?>
吗？')" href="<?php echo $this->_tpl_vars['url']; ?>
/del/id/<?php echo $this->_tpl_vars['groups'][$this->_sections['doc']['index']]['id']; ?>
">删除</a>】
							<?php endif; ?>
							</span>
						</li>
					<?php endfor; endif; ?>
				</ul>	
			</div>
                   
		</div>
<?php $_smarty_tpl_vars = $this->_tpl_vars;
$this->_smarty_include(array('smarty_include_tpl_file' => "public/footer.tpl", 'smarty_include_vars' => array()));
$this->_tpl_vars = $_smarty_tpl_vars;
unset($_smarty_tpl_vars);
 ?>	

