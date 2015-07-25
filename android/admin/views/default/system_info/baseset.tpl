<{include file="public/header.tpl"}>
		<div id="main">
		    	<div class="head-dark-box">
				<div class="tit">系统管理>常规设置>基本设置</div>
			</div>	
			<{ include file="public/title.tpl" }>
		    <form  method="post" action="<{$url}>/set" enctype="multipart/form-data">
			<div class="msg-box">
				<ul class="viewmess">
					<li class="dark-row">
						<span class="col_width">约跑信息每页显示数目</span>
						<input type="text" class="text-box" name="messagePageSize" size="10" value="<{$varList.messagePageSize}>"> 条/页			
					</li>
					<li class="light-row">
						<span class="col_width">查看用户每页显示数目</span>
						<input type="text" class="text-box" name="userPageSize" size="10" value="<{$varList.userPageSize}>"> 条/页				
					</li>
					<li class="dark-row">
						<span class="col_width">缓存设置</span>
						<input type="radio" name="cstart" <{if $varList.cstart eq '1'}>checked<{/if}> value="1"> 开启 &nbsp;&nbsp;
						<input type="radio" name="cstart" <{if $varList.cstart eq '0' or $varList.cstart eq null}>checked<{/if}> value="0"> 关闭
					</li>
					<li class="light-row">
						<span class="col_width">缓存时间</span>
						<input type="text" class="text-box" name="ctime" size="5" value="<{$varList.ctime}>"> 秒
					
					</li>
					<li class="dark-row">
						<span class="col_width">网站标题</span>
						<input type="text" class="text-box" name="appname" size="30" value="<{$varList.appname}>"> 显示在首页的标题栏
					
					</li>
					<li class="light-row">
						<span class="col_width">网站描述</span>
						<textarea type="text" class="text-box" name="description" cols="40" rows="5"><{$varList.description}></textarea> 
					
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

<{include file="public/footer.tpl"}>	


