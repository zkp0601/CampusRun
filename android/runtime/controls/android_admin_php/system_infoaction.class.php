<?php
	// 设置系统管理选项
	class System_infoAction extends Common {

		function sysinfo(){
			debug(0);
			$sysinfo = new Sysinfo;
			$this->assign("sysinfo", $sysinfo->getSysInfos());
			$this->mess('此部分可根据网站需要，对当前服务器配置进行调整');
			$this->display();
		}

		function baseset(){
			debug(0);
			if( isset($_GET["stats"]) )
				$this->mess($_GET["mess"], $_GET["stats"]);
			else
				$this->mess("用于设置页面信息的显示样式，包括每一页显示的条数等	");
			$this->assign("varList", BaseSet::getSet());
			$this->display();
		}

		function upcache(){
			debug(0);
			$cache_dir = PROJECT_PATH.'runtime/cache/';
			del_dir($cache_dir);
			if(!file_exists($cache_dir))
				$this->mess("更新所有缓存成功！", 1);
			else
				$this->mess("更新缓存失败！", 0);
			$this->display();
		}

		function set(){
			if(BaseSet::writeConfig($_POST))
				$this->redirect("baseset", "stats/1/mess/修改成功");
			else
				$this->redirect("baseset", "stats/0/mess/修改失败");
		}
	}