<?php
	class Run_record{
		
		function index(){
			debug(0);
			$statement = "SELECT user_id, total_distance, total_time, last_distance, last_time,
			 total_kaluli, last_kaluli FROM run_record order by total_distance desc";
			$all_run_record = connect_execute($statement);
			$result = $this->showMessage($all_run_record); //用于显示后台主页面的所有 message
			if(isset($_GET["isUpdate"]) && $_GET["isUpdate"] == 1)
				$this->mess("记录更新成功", 1);
			else if(isset($_GET["isUpdate"]) && $_GET["isUpdate"] == 0)
				$this->mess("记录更新失败", 0);
			else
				$this->mess("当前平台上所有用户的运动记录");
			$this->assign("show_all_the_run_record", $result);
			$this->display();
		}

		function edit(){
			debug(0);
			$this->assign("user_id", $_GET["user_id"]);
			$statement = 'SELECT * FROM run_record where user_id='.$_GET["user_id"];
			$result = connect_execute($statement);
			while($row = mysql_fetch_row($result)){
				$this->assign("total_distance", $row[1]);
				$this->assign("last_distance", $row[3]);
				$this->assign("total_time", $row[2]);
				$this->assign("last_time", $row[4]);
				$this->assign("total_kaluli", $row[5]);
				$this->assign("last_kaluli", $row[6]);
			}
			$this->display();
		}

		function update(){
			$statement = 'UPDATE run_record SET total_distance='.$_POST["total_distance"].',total_time=\''.
				$_POST["total_time"].'\',last_distance='.$_POST["last_distance"].',last_time=\''.$_POST["last_time"].
				'\',total_kaluli='.$_POST["total_kaluli"].',last_kaluli='.$_POST["last_kaluli"].' where user_id='.$_POST["user_id"];
			$result = connect_execute($statement);
			if($result){
				del_dir(PROJECT_PATH.'runtime/cache/');
				$this->redirect("run_record/index", "isUpdate/1");
			}
			else
				$this->redirect("run_record/index", "isUpdate/0");
		}

		private function showMessage($all_run_record){
			$result = "";
			while($row = mysql_fetch_row($all_run_record)){
				$arr = array();
				$i = 0;
				foreach( $row as $data){
					$arr[$i++] = $data;
				}
				$result .= '<li class="<{if $smarty.section.doc.index is even}>light-row<{else}>dark-row<{/if}>" 
					style="padding-top:10px; padding-bottom:10px">';
							
				$result .= '<span style="font-weight:bold" class="list_width">'.'
					<a href="http://localhost/android/admin.php/person_info/index/user_id/'.$arr[0].'">'.$arr[0].'</a></span>';
							
				$result .= '<span class="list_width" style="width:10%">'.$arr[1].'</span>';

				$result .= '<span class="list_width" style="width:10%">'.$arr[2].'</span>';
						
				$result .= '<span class="list_width" style="width:10%">'.$arr[3].'</span>';

				$result .= '<span class="list_width" style="width:10%">'.$arr[4].'</span>';

				$result .= '<span class="list_width" style="width:10%">'.$arr[5].'</span>';

				$result .= '<span class="list_width" style="width:10%">'.$arr[6].'</span>';

				$result .= '<span class="list_width">【<a href="http://localhost/android/admin.php/run_record/edit/user_id/'
					.$arr[0].'">编辑</a>】</li> ';
			}
			return $result;
		}

	}