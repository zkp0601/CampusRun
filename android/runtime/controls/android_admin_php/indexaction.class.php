<?php
	class IndexAction extends Common {
		function index(){
			debug(0);
			if($_SESSION["isLogin"])
				$this->display();
			else
				$this->redirect("login/index");
		}

		function top(){
			debug(0);
			$this->display();
		}

		function menu(){
			debug(0);
			$this->display();
		}

		function main(){
			debug(0);
			$this->mess("本后台用于管理 Campus Run 用户的各项数据, 可通过操作左侧菜单进行管理");
			$this->display();
		}

		function bottom(){
			$statement = 'SELECT * FROM message';
			$result = connect_execute($statement);
			$rows = mysql_num_rows($result); // 计算总的message数目
			$this->assign("message_num", $rows);
			
			$statement = "SELECT * FROM login"; // 计算当前的用户数
			$result = connect_execute($statement);
			$rows = mysql_num_rows($result);
			$this->assign("users_num", $rows);
			$this->display();
		}
	}