<{include file="public/header.tpl"}>
		<div id="main">
			<div class="head-dark-box">
				<div class="tit">内容管理>发布信息管理>编辑约跑信息</div>
			</div>	
		    <{ include file="public/title.tpl" }>
		    <form  method="post" action="<{$url}>/update">
			<div class="msg-box">
				<ul class="viewmess">
					<input type="hidden" name="user_id" value="<{$user_id}>">
					<input type="hidden" name="contents_id" value="<{$contents_id}>">

					<li class="light-row">
						<span class="col_width">出发时间<span class="red_font">*</span></span>
						<input name="start_time" type="text" value="<{$start_time}>" class="text-box"> 格式为 2000-01-01 00:00:00
					</li>

					<li class="dark-row">
						<span class="col_width" style="margin-top:30px">信息内容<span class="red_font">*</span></span>
						<textarea class="text-box" name="contents" cols="40" rows="5"><{ $contents }></textarea>
					</li>

					<li class="light-row">
						<span class="col_width">出发学校<span class="red_font">*</span></span>
						<input name="school" type="text" value="<{$school}>" class="text-box">
					</li>

					<li class="dark-row">
						<span class="col_width">接受者ID<span class="red_font">*</span></span>
						<input name="receiver_id" type="text" value="<{$receiver_id}>" class="text-box"> 不用ID以#隔开
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
<{include file="public/footer.tpl"}>	


