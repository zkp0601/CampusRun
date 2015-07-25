<?php
	class User{
		function index(){
			debug(0);
			$statement = "SELECT * FROM login";
			if($_GET["id_not_found"] == 1)
				$this->mess("未找到相应的用户", 0);
			else if(isset($_GET["isUpdate"]) && $_GET["isUpdate"] == 1)		// 修改密码后成功与否的提示
				$this->mess("密码修改成功", 1);
			else if(isset($_GET["isUpdate"]) && $_GET["isUpdate"] == 0)
				$this->mess("密码修改失败", 0);
			else if(isset($_GET["delete"]) && $_GET["delete"] == 1)		// 删除用户后成功与否的提示
				$this->mess("用户删除成功", 1);
			else if(isset($_GET["delete"]) &&$_GET["delete"] == 0)
				$this->mess("用户删除失败", 0);
			else if(isset($_GET["insert"]) && $_GET["insert"] == 0)
				$this->mess("添加用户失败", 0);
			else if(isset($_GET["insert"]) && $_GET["insert"] == 1)
				$this->mess("添加用户成功", 1);
			
			$all_user = connect_execute($statement);
			if( $all_user ){
				$result = $this->showMessage($all_user);
				$this->assign("show_users", $result);
				if(!isset($_GET["isUpdate"]) && !isset($_GET["id_not_found"]) && !isset($_GET["delete"]) 
					&& !isset($_GET["insert"]))
					$this->mess("当前所有用户如下所示：");
			}
			else
				$this->mess("No user in table \"login\" found.");
			$this->display();
		}

		function add(){
			debug(0);
			$this->display();
		}

		function insert(){
			$statement = 'INSERT INTO login(user_name, user_pass) values("'.$_POST["user_name"].'",
				"'.md5($_POST["user_pass"]).'")';
			$result = connect_execute($statement);
			if($result){
				del_dir(PROJECT_PATH.'runtime/cache/');
				$this->redirect("user/index", "insert/1");
			}
			else
				$this->redirect("user/index", "insert/0");
		}

		function update(){
			$statement = 'UPDATE login SET user_pass="'.md5($_POST["user_pass"]).'" where user_id='.$_GET["user_id"];
			$result = connect_execute($statement);
			if($result){
				del_dir(PROJECT_PATH.'runtime/cache/');
				$this->redirect("/user/index", "isUpdate/1");
			}
			else
				$this->redirect("/user/edit", "isUpdate/0");
		}

		function del(){
			$statement = 'DELETE FROM login where user_id='.$_GET["user_id"];
			$result = connect_execute($statement);
			if($result){
				del_dir(PROJECT_PATH.'runtime/cache/');
				// 同步删除run_record、person_info及game_record中信息
				$statement = 'DELETE FROM person_info where user_id='.$_GET["user_id"];
				connect_execute($statement);
				$statement = 'DELETE FROM run_record where user_id='.$_GET["user_id"];
				connect_execute($statement);
				$this->redirect("user/index", "delete/1");
			}
			else{
				$this->redirect("user/index", "delete/0");
			}
		}

		function edit(){
			debug(0);
			if(isset($_GET["isUpdate"]) && $_GET["isUpdate"] == 0)
				$this->mess("密码修改失败", 0);
			else
				$this->mess("此页面可以进行密码修改操作");
			$statement = "SELECT user_id, user_name, user_pass FROM login where user_id=".$_GET["user_id"];
			$result = connect_execute($statement);
			if($result){
				while($user = mysql_fetch_row($result)){
					$this->assign("user_id", $user[0]);
					$this->assign("user_name", $user[1]);
					$this->assign("user_pass", $user[2]);
				}
			}
			else{
				$this->redirect("user/index", "id_not_found/1");
			}
			$this->display();
		}

		private function showMessage($all_user){
			$result = "";
			while($row = mysql_fetch_row($all_user)){
				$arr = array();
				$i = 0;
				foreach( $row as $data){
					$arr[$i++] = $data;
				}
				$result .= '<li class="<{if $smarty.section.doc.index is even}>light-row<{else}>dark-row<{/if}>" 
					style="padding-top:10px; padding-bottom:10px">';
							
				$result .= '<span style="font-weight:bold" class="list_width">'.'
					<a href="http://localhost/android/admin.php/person_info/index/user_id/'.$arr[2].'">'.$arr[2].'</a></span>';
							
				$result .= '<span class="list_width" style="width:18%">'.$arr[0].'</span>';

				$result .= '<span class="list_width" style="width:36%">'.$arr[1].'</span>';

				$result .= '<span class="list_width">【<a href="http://localhost/android/admin.php/user/edit/user_id/'
					.$arr[2].'">编辑</a>】'.'【<a onclick="return confirm(\'确定要删除此约跑信息吗？\')"  
					href="http://localhost/android/admin.php/user/del/user_id/'.$arr[2].'">删除</a>】</li> ';
			}
			return $result;
		}
	}