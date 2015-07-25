<?php
	class Person_info{
		function index(){
			debug(0);	
			$statement = 'SELECT * FROM person_info';
			if(isset($_GET["isUpdate"]) && $_GET["isUpdate"] == 1)
				$this->mess("个人信息修改成功", 1);
			else if(isset($_GET["user_id"]) && $_GET["user_id"] != 0){
				$statement .= ' where user_id = '.$_GET["user_id"];
				$this->mess("用户ID为".$_GET["user_id"]."的个人信息如下所示：");
				del_dir(PROJECT_PATH.'runtime/cache/');
			}
			else
				$this->mess("当前所有用户的个人信息如下：");
			
			$all_personInfo = connect_execute($statement);
			if($all_personInfo){
				$result = $this->showMessage($all_personInfo);
				$this->assign("person_info", $result);
			}
			else{
				$this->mess("当前没有用户");
			}
			$this->display();
		}

		function add(){
			$this->display();
		}

		function edit(){
			debug(0);
			$statement = 'SELECT * from person_info where user_id='.$_GET["user_id"];
			$result = connect_execute($statement);
			if($result){
				while($row = mysql_fetch_row($result)){
					$this->assign("user_id", $row[0]);
					$this->assign("name", $row[1]);
					$this->assign("sex", $row[2]);
					$this->assign("age", $row[3]);
					$this->assign("school", $row[4]);
					$this->assign("email", $row[5]);
					$this->assign("phone_num", $row[6]);
				}
			}
			if(isset($_GET["isUpdate"]) && $_GET["isUpdate"] == 0)
				$this->mess("用户信息修改失败", 0);
			else
				$this->mess("修改用户个人信息");
			$this->display();
		}

		function update(){
			$statement = 'UPDATE person_info SET name=\''.$_POST["name"].'\',sex=\''.$_POST["sex"].'\',age='.
				$_POST["age"].',school=\''.$_POST["school"].'\',email=\''.$_POST["email"].'\',phone_num=\''.$_POST["phone_num"].
				'\' where user_id='.$_GET["user_id"];
			$result = connect_execute($statement);
			if($result){
				del_dir(PROJECT_PATH.'runtime/cache/');
				$this->redirect("person_info/index", "isUpdate/1");
			}
			else
				$this->redirect('person_info/edit', 'isUpdate/0/user_id/'.$_GET["user_id"]);
		}

		private function showMessage($all_personInfo){
			$result = "";
			while($row = mysql_fetch_row($all_personInfo)){
				$i = 0;
				$arr = array();
				foreach( $row as $data ){
					$arr[$i++] = $data;
				}
				$result .= '<li class="<{if $smarty.section.doc.index is even}>light-row<{else}>dark-row<{/if}>" 
					style="padding-top:10px; padding-bottom:10px">';
							
				$result .= '<span style="font-weight:bold;width:5%" class="list_width">'.$arr[0].'</span>';
							
				$result .= '<span class="list_width" style="width:5%">'.$arr[1].'</span>';

				$result .= '<span class="list_width" style="width:5%">'.$arr[2].'</span>';

				$result .= '<span class="list_width" style="width:5%">'.$arr[3].'</span>';

				$result .= '<span class="list_width" style="width:15%">'.$arr[4].'</span>';

				$result .= '<span class="list_width" style="width:15%">'.$arr[5].'</span>';

				$result .= '<span class="list_width" style="width:9%">'.$arr[6].'</span>';
				$result .= '<span class="list_width">【<a href="http://localhost/android/admin.php/person_info/edit/user_id/'
					.$arr[0].'">编辑</a>】</li> ';
			}
			return $result;
		}
	}