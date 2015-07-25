<?php
	class Common extends Action {
		function init(){

		}	

		function mess($mess="ok", $is=null){
			$message="";
			if(is_array($mess)){
				foreach($mess as $m){
					$message.=$m;
				}	
			}else{
				$message=$mess;
			}

			if(is_null($is)){
				$this->assign("mess", "");
			}else if($is){
				$this->assign("mess", "ok");
			}else{
				$this->assign("mess", "error");
			}
			$this->assign("tmess", $message);
		}	
	}