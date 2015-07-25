<{include file="public/header.tpl"}>
		<div id="main">
			<div class="head-dark-box">
				<div class="tit">内容管理>运动记录管理>编辑运动记录</div>
			</div>	
		    <form  method="post" action="<{$url}>/update">
			<div class="msg-box">
				<ul class="viewmess">
					<li class="light-row">
						<span class="col_width">用户ID&nbsp;&nbsp;&nbsp;<span class="red_font">*</span></span>
						<input name="user_id" type="text" class="text-box" value="<{$user_id}>">
					</li>
					
					<li class="dark-row">
						<span class="col_width">总运动距离<span class="red_font">*</span></span>
						<input name="total_distance" type="text" class="text-box" value="<{$total_distance}>"> 只能输入整数，单位默认为米(m)
					</li>

					<li class="light-row">
						<span class="col_width">上次运动距离<span class="red_font">*</span></span>
						<input name="last_distance" id="pt" type="text" class="text-box" value="<{$last_distance}>">
					</li>

					<li class="dark-row">
						<span class="col_width">总运动时间<span class="red_font">*</span></span>
						<input name="total_time" type="text" class="text-box" value="<{$total_time}>"> 输入格式为 00:00:00
					</li>

					<li class="light-row">
						<span class="col_width">上次运动时间<span class="red_font">*</span></span>
						<input name="last_time" type="text" class="text-box" value="<{$last_time}>">
					</li>

					<li class="dark-row">
						<span class="col_width">卡路里总消耗量<span class="red_font">*</span></span>
						<input name="total_kaluli" type="text" class="text-box" value="<{$total_kaluli}>"> 只能输入整数，单位默认为千焦(kj)
					</li>

					<li class="light-row">
						<span class="col_width">上次卡路里消耗量<span class="red_font">*</span></span>
						<input name="last_kaluli" type="text" class="text-box" value="<{$last_kaluli}>">
					</li>

					<li class="dark-row">
						<span class="col_width"> &nbsp; </span>
						<input type="submit" class="button"  value="修 改">&nbsp;&nbsp;
						<input type="reset" class="button" value="重 置">
					</li>
				</ul>	
			</div>
                    </form>	
		</div>
<{include file="public/footer.tpl"}>	


