<{include file="public/header.tpl"}>	
	<div id="top">
			<div class="left">
				<a herf="index.php"><img  border="0" src="<{$res}>/images/logo.gif"></a>
			</div>

		
			<div class="right_tool">
					<ul>
						<li><a href="<{$app}>/login/logout" onclick="return confirm('你确定要退出系统吗？')" target="_top"><img border=0 src="<{$res}>/images/exit3.gif"></a></li>
					</ul>
			</div>
			<div class="right_user">
				<b>欢迎您-</b>&nbsp;【<{$smarty.session.username}>】 &nbsp;&nbsp;
			</div>
		</div>
<{include file="public/footer.tpl"}>
