<?php
	class Login{
		function index(){
			debug(0);
			$this->caching = 0;
			$stats = true;
			$errorMess = "登录失败：";
			if(!preg_match('/^\S+$/i', $_POST["user_name"])){
				$errorMess .= "用户名不能为空！<br>";
				$stats = false;
			}
			if(!preg_match('/^\S+$/i', $_POST["user_pass"])){
				$errorMess .= "用户密码不能为空！<br>";
				$stats = false;
			}

			// 若输入的用户名和密码格式没有错误
			if(!$stats){
				$this->assign("login_result", "用户名或者密码为空：".json_encode($errorMess));
			}else {
				// 密码要加密！！！
				$login = D("login")->field('user_id')
					->where(array("user_name"=>$_POST["user_name"], "user_pass"=>md5($_POST["user_pass"])))
					->find();

				if($login){
					$message = D("run_record")->field(
						'user_id, 
						total_distance, 
						last_distance')
					->where(array("user_id"=>$login["user_id"]))
					->find();
					$this->assign("login_result", /*'$message:'.*/json_encode($message));
				}else{
					$this->assign("login_result", /*'登录失败!：'.*/json_encode("登录失败!"));
				}
			}
			$this->display();
		}

		function register(){
			debug(0);
			$this->caching = 0;	
			$user_name = $_POST["user_name"];
			$user_pass = md5($_POST["user_pass"]);
			$exists = $this->unique($user_name);
			if($exists)
				echo json_encode("用户名已存在");
			else{
				$insert_id = $this->insert($user_name, $user_pass);
				if($insert_id){
					$mess = "注册成功, ";
					// 每完成一个帐号注册，则生成insert一条对应的run record信息
					$run_record_mess = D("run_record")->insert(array("user_id"=>$insert_id));
					$person_info_mess = D("person_info")->insert(array("user_id"=>$insert_id, "sex"=>$_POST["sex"], "phone_num"=>$_POST["phone_num"]));
					$game_record_mess = D("game_record")->insert(array("user_id"=>$insert_id));
					if($run_record_mess && $person_info_mess)
						echo json_encode($mess.'且对应的 run record, game record 和 person_info 均添加成功！');
					// else
						// echo /*'注册成功但 run record信息没有添加：'.*/json_encode($mess.'但 run record 或 person_info 没有添加');
				}
				else
					echo json_encode("注册失败！");
			}
		} 
		/*
		function logout(){
			$thsi->caching = 0;
		}
		*/
		private function insert($user_name, $user_pass){
			$login = D("login");
			$data = array("user_name"=>$user_name, "user_pass"=>$user_pass);
			$result = $login->insert($data);
			if($result)
				return $result;
			else
				return 0;
		}

		private function unique($user_name){
			$login = D("login");
			$exists = $login->field('user_name')->where(array("user_name"=>$user_name))
				->find();
			if($exists)
				return true;
			else
				return false;
		}
	}