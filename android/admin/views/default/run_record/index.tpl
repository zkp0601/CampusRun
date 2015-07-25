<{include file="public/header.tpl"}>
		<div id="main">
			<div class="head-dark-box">
				<div class="tit">内容管理>运动记录管理>查看运动记录</div>
			</div>	
		    <{ include file="public/title.tpl" }>	  
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
				    <{ $show_all_the_run_record }>
				</ul>	
			</div>
                   
		</div>
<{include file="public/footer.tpl"}>	


