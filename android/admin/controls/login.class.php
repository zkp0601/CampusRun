<?php
	// 用于后台的管理员登录界面
	class Login {
		function index(){
			debug(0);
			$this->display();
		}

		function prologin(){
			$this->validate();

			$user=D("manager")->field('user')
				->where(array("user"=>$_POST["username"], "pass"=>$_POST["userpwd"]))
				->find();
			if($user){
				//设置管理员权限
				$_SESSION["webadmin"] = 1;
				$_SESSION["username"] = $_POST["username"];
				$_SESSION["useradmin"] = 1;
				$_SESSION["isLogin"] = 1;
				$_SESSION["contentsadmin"] = 1;
				$this->redirect('index/index');
			}else{
				$this->error('用户登录失败，请重新登录!', 1, "login/index");
			}
		}

		function logout(){
			//$this->caching() = 0;
			$user = $_SESSION["username"];
			D("manager", $user)->logout();
			$this->success("再见 {$user},退出成功", 1, "login/index");
		}
		
		private function validate(){
			$stats = false;
			$errormess = "登录失败：<br>";
			if(!preg_match('/^\S+$/i', $_POST["username"])){
				$errormess.="用户名不能为空!<br>";
				$stats=true;	
			}
			if(!preg_match('/^\S+$/i', $_POST["userpwd"])){
				$errormess.="用户密码不能为空!<br>";
				$stats=true;	
			}
			if(strtoupper($_POST["code"])!=$_SESSION["code"]){
				$errormess.="验证码输出错误!<br>";
				$stats=true;	
			}
			if($stats){
				$this->error($errormess, 2, "index");
			}
		}

		function code(){
			echo new Vcode(50,18);
		}

	}