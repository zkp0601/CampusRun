<?php
	class Game_recordAction extends Common {
		function index(){
			debug(0);
			$this->caching = 0;
			if(isset($_POST["user_id"]) && $_POST["user_id"] != 0){
				$personal_record = D("game_record")->field('user_id, score, ranking, game_award')
					->where(array("user_id"=>$_POST["user_id"]))->find();
				//若当前有记录,则直接返回
				if($personal_record){
					echo json_encode($personal_record);
				}
				else
					echo '没有相应的记录'.json_encode("没有相应的记录");
			}
		}

		function update(){
			debug(0);
			$this->caching = 0;
			$current_score = D("game_record")->field('user_id, score')
				->where(array("user_id"=>$_POST["user_id"]))->find();
			if($current_score["score"] < (int)$_POST["score"]){
				$update_result = D("game_record")->where(array("user_id"=>$_POST["user_id"]))->update();
				echo 'update_result'.json_encode($update_result);
			}
		}

		function ranking(){
			debug(0);
			$this->caching = 0;
			$ranking_list = D("game_record")->field('user_id, score, ranking, game_award')
				->order("score desc")->select();
			if($ranking_list)
				echo json_encode($ranking_list);
		}
	}