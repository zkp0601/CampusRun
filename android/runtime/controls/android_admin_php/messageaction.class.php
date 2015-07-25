<?php

	class MessageAction extends Common {
		function index(){
			debug(0);
			$statement = "SELECT user_id, contents_id, contents, start_time, school, accept_num, receiver_id FROM message order by user_id";
			$all_message = connect_execute($statement);
			$result = $this->showMessage($all_message); //用于显示后台主页面的所有 message
			if(isset($_GET["isUpdate"]) && $_GET["isUpdate"] == 1)
				$this->mess("更新成功", 1);
			else if(isset($_GET["isUpdate"]) && $_GET["isUpdate"] == 0)
				$this->mess("更新失败", 0);
			else if(isset($_GET["isInsert"]) && $_GET["isInsert"] == 1)
				$this->mess("添加约跑信息成功", 1);
			else if(isset($_GET["delete"]) && isset($_GET["delete"]) == 1)
				$this->mess("删除约跑信息成功", 1);
			else
				$this->mess("当前平台上的所有约跑信息");
			$this->assign("show_all_the_message", $result);
			$this->display();
		}

		function add(){
			debug(0);
			if(isset($_GET["isInsert"]) && $_GET["isInsert"] == 0)
				$this->mess("插入失败", 0);
			else
				$this->mess("可为特定用户添加特定约跑信息");
			$this->display();
		}

		function edit(){
			debug(0);
			if($_GET["isUpdate"])
				$this->mess("更新成功", 1);
			else
				$this->mess("只允许更改信息内容、出发学校及其信息接受状态");
			$statement = "SELECT contents, school, accept_num FROM message 
				where user_id = ".$_GET["user_id"]." and contents_id = ".$_GET["contents_id"];
			$this->assign("user_id", $_GET["user_id"]);
			$this->assign("contents_id", $_GET["contents_id"]);
			$result = connect_execute($statement);
			if( $result ){
				$arr = array();
				while( $row = mysql_fetch_row($result) ){
					$this->assign('contents', $row[0]);
					$this->assign('school', $row[1]);
					$this->assign('accept_num', $row[2]);
				}
			}
			else
				$this->mess("未找到该消息，更改失败", 0);
			$this->display();
		}

		function update(){
			debug(0);
			$statement = 'UPDATE message SET contents=\''.$_POST["contents"].'\', school=\''.$_POST["school"].
				'\', receiver_id=\''.$_POST["receiver_id"].'\',start_time=\''.$_POST["start_time"].'\' 
				where user_id='.$_POST["user_id"]." and contents_id=".$_POST["contents_id"];

			$result = connect_execute($statement);
			if( $result ){
				del_dir(PROJECT_PATH.'runtime/cache/');
				$this->redirect('message/index', '/isUpdate/1');
			}
			else{
				$this->redirect('message/index', '/isUpdate/0');
			}
		}

		function del(){
			debug(0);
			$statement = 'DELETE FROM message where user_id = '.$_GET["user_id"].' and contents_id = '.$_GET["contents_id"];
			$result = connect_execute($statement);
			if($result){
				del_dir(PROJECT_PATH.'runtime/cache/');
				$this->redirect("message/index", "delete/1");
			}
		}

		function insert(){
			debug(0);
			$statement = 'INSERT INTO message(user_id, contents_id, contents, post_time, school, start_time, poster_name)
				values('.$_POST["user_id"].','.$_POST["contents_id"].',"'.$_POST["contents"].'","'.$_POST["post_time"].'","'
					.$_POST["school"].'","'.$_POST["start_time"].'","'.$_POST["poster_name"].'")';
			$result = connect_execute($statement);
			if($result){
				del_dir(PROJECT_PATH.'runtime/cache/');
				$this->redirect("message/index", "isInsert/1");
			}
			else{
				$this->redirect("message/add", "isInsert/0");
			}
		}

		private function showMessage($all_message){
			$result = "";
			while($row = mysql_fetch_row($all_message)){
				$arr = array();
				$i = 0;
				foreach( $row as $data){
					$arr[$i++] = $data;
				}
				$result .= '<li class="<{if $smarty.section.doc.index is even}>light-row<{else}>dark-row<{/if}>" 
					style="padding-top:10px; padding-bottom:10px">';
							
				$result .= '<span style="font-weight:bold" class="list_width">'.'
					<a href="http://localhost/android/admin.php/person_info/index/user_id/'.$arr[0].'">'.$arr[0].'</a></span>';
							
				$result .= '<span class="list_width" style="width:5%">'.$arr[1].'</span>';

				$result .= '<span class="list_width_not_center" style="width:25%">'.$arr[2].'</span>';

				$result .= '<span class="list_width_not_center" style="width:15%">'.$arr[3].'</span>';
						
				$result .= '<span class="list_width" style="width:15%">'.$arr[4].'</span>';

				$result .= '<span class="list_width" style="width:6%">'.$arr[5].'</span>';

				$result .= '<span class="list_width">【<a href="http://localhost/android/admin.php/message/edit/user_id/'
					.$arr[0].'/contents_id/'.$arr[1].'">编辑</a>】 '.
					'【<a onclick="return confirm(\'确定要删除此约跑信息吗？\')"  href="http://localhost/android/admin.php/message/del/user_id/'
					.$arr[0].'/contents_id/'.$arr[1].'">删除</a>】</span>
					</li>';
			}
			return $result;
		}
	}