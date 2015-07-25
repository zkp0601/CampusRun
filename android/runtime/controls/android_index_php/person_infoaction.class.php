<?php
	class Person_infoAction extends Common {
		function index(){
			debug(0);
			$user_id = $_POST["user_id"];
			$result = D("person_info")->where(array("user_id"=>$user_id))->find();
			if($result)
				echo /*'person_info信息：'.*/json_encode($result);
			else
				echo /*'person_info获取失败：'.*/json_encode("person_info获取失败");
		}

		function insert() {
			debug(0);
			$user_id = $_POST["user_id"];
			if($user_id != null){
				$info = array(
					"user_id"=>$user_id,
					"name"=>$_POST["name"],
					"sex" => $_POST["sex"],
					"age" => $_POST["age"],
					"school" => $_POST["school"],
					"email" => $_POST["email"], 
					"phone_num" => $_POST["phone_num"]
					);
				$result = D("person_info")->insert($info);
				if($result)
					echo /*'信息登记成功：'.*/json_encode("信息录入成功！");
				else
					echo /*'信息录入失败：'.*/json_encode("信息录入失败！");
			}else{
				echo /*'user_id为空：'.*/json_encode("user_id为空");
			}

		}

		function update(){
			debug(0);
			$user_id = (int)($_POST["user_id"]);
			if($user_id != null){
				$update_info = array(
					"user_id" => $user_id,
					"sex" => $_POST["sex"],
					"age" => (int)($_POST["age"]),
					"school" => $_POST["school"],
					"email" => $_POST["email"], 
					"phone_num" => $_POST["phone_num"]
					);
				$result = D("person_info")->update($update_info);
				if($result)
					echo /*'信息更新成功：'.*/json_encode("信息更新成功！");
				else
					echo /*'信息更新失败：'.*/json_encode("您的信息未改变！");
			}	
			else
				echo /*'更新失败, user_id为空：'.*/json_encode("更新失败, user_id为空");
		}

	}