<?php
	class Run_recordAction extends Common {
		function index(){
			debug(0);
			$user_id = $_POST["user_id"];
			if($user_id != null){
				$result = D("run_record")->where(array("user_id"=>$user_id))->find();
				if($result)
					echo /*'run_record数据：'.*/json_encode($result);
				else
					echo /*'无法擦查询到对应的running record：'.*/json_encode("没有对应的跑步记录");
			}
			else{
				echo 'user_id为空：'.json_encode("user_id为空");
			}
		}

		function update(){
			debug(0);
			// 客户端需随时记录某一次跑步的情况, 假设为 current_time及current_distance
			$current_distance = (float)$_POST["current_distance"];
			$current_time = $_POST["current_time"];
			$current_kaluli = (float)$_POST["current_kaluli"];
			$result = D("run_record")->field('total_distance, total_time, total_kaluli')
				->where(array("user_id"=>$_POST["user_id"]))->find();

			list($total_hours, $total_minutes, $total_seconds) = split(":", $result["total_time"]);
			list($current_hours, $current_minutes, $current_seconds) = split(":", $current_time);
			//echo $total_hours;
			$result_hours =((int)(((int)(($total_seconds+$current_seconds) / 60)+ $total_minutes + $current_minutes) / 60)/**/ + $total_hours + $current_hours); 
			$result_minutes =  ((int)(($total_seconds+$current_seconds) / 60) + $total_minutes + $current_minutes) % 60;
			$result_seconds = ($total_seconds+$current_seconds) % 60 ;
			if($result){
				$update_info = array(
					"total_distance" => ($result["total_distance"] + $current_distance),
					"total_time" => ( $result_hours.':'.$result_minutes.':'.$result_seconds ),
					"last_distance" => $current_distance,
					"last_time" => $current_time,
					"total_kaluli" => ((float)$result["total_kaluli"] + $current_kaluli),
					"last_kaluli" => $current_kaluli
					);
				$row = D("run_record")->where(array("user_id"=>$_POST["user_id"]))->update($update_info);
				if($row)
					echo /*'返回run record更新成功的json格式：'.*/json_encode("更新成功");
				else
					echo /*'返回run record更新失败的json格式：'.*/json_encode("更新失败");
			}
			else
				echo /*'访问路径参数有误：'.*/json_encode("访问路径参数有误");
		}
	}
