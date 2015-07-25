<?php
	class Index {

		function index(){
			debug(0);
			//$user_name = $_SESSION["user_name"];
			//$user_pass = $_SESSION["user_pass"];
			echo /*"返回user_name和user_pass的json格式：".*/json_encode($user_name).json_encode($user_pass);
			$this->display();
		}		

	}