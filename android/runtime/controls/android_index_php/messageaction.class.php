<?php
	class MessageAction extends Common {
		function index(){
			debug(0);
			$message = D("message")->field('user_id,contents,post_time,sex,start_time,phone_num,school,accept_num,poster_name,receiver_id,contents_id')
				->order("contents_id desc")->select();
			if($message)
				$this->assign("message", /*'$message：'.*/json_encode($message));
			else
				$this->assign("message", /*'无合适约跑信息：'.*/json_encode("当前没有合适的约跑信息"));
			$this->display();
		}

		function update(){
			debug(0);
			// 需传递整个$_POST数组作为update默认参数
			if(isset($_POST["user_id"])){
				$result = D("message")->where(array("user_id"=>$_POST["user_id"]))->update();
			}else{
				$contents_id = $_POST["contents_id"];
				$result = D("message")->where(array("contents_id"=>$contents_id))->update();
				if ($result) {
					echo json_encode("参与成功");
				}else {
					echo json_encode("无法参与");
				}
			}
		}

		function insert(){
			debug(0);
			if($_POST["contents"] != null && $_POST["user_id"] != null){
				//D("person_info")->field('sex')->where(array("user_id"=>$_POST["user_id"]))->find();
				$current_id = D("message")->insert();
				if($current_id)
					echo /*'信息发布成功：'.*/json_encode('信息发布成功');
				else
					echo /*'信息发布失败：'.*/json_encode("信息发布失败");
			}
			else
				echo /*'发布失败：'.*/json_encode("发布失败!");
		}

		function delete(){
			debug(0);
			if($_POST["contents_id"] != null && $_POST["user_id"] != null){
				$row = D("message")->delete(array("contents_id"=>$_POST["contents_id"], "user_id"=>$_POST["user_id"]));
				if($row)
					echo json_encode("删除成功");
				else
					echo /*'删除失败：'.*/json_encode("没有对应的user_id或contents_id,删除失败");
			}else {
				$errorMessage = "";
				if($_POST["contents_id"] == null)
					$errorMessage .= "contents_id为空";
				if($_POST["user_id"] == null)
					$errorMessage .= ", user_id为空";
				echo /*'{$errorMessage}：'.*/json_encode($errorMessage);
			}
		}
	}