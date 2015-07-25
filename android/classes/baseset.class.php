<?php
	class BaseSet{

		// 函数: getSet()
		// 功能: 获取需要设置的信息数组
		// 参数: 无
		// 返回: 需要对系统进行设置的选择数组
		static function getSet(){
			$varList = array(
					"cstart"    => CSTART,
					"messagePageSize" => MESSAGE_PAGE_SIZE,
					"userPageSize" => USER_PAGE_SIZE,
					"ctime"		=> CTIME,
					"appname"		=> APP_NAME,
					"description"	=> DESCRIPTION
				 );
			return $varList;
		}

		// 函数: writeConfig($fileName,$post)
		// 功能: 用于将用户输入的设置信息改写配置文件
		// 参数: fileName是配置文件的名称，和需要设置的内容数组
		// 返回: true或false
		static function writeConfig($post){
			$confile=PROJECT_PATH."config.inc.php";
		
			$configText = file_get_contents($confile);
			
			$reg=array(
					"/define\(\"CTIME\".+?;/i",
					"/define\(\"APP_NAME\".+?;/i",
					"/define\(\"DESCRIPTION\".+?;/i",
					"/define\(\"MESSAGE_PAGE_SIZE\".+?;/i",		
					"/define\(\"USER_PAGE_SIZE\".+?;/i",
					"/define\(\"CSTART\".+?;/i"
				);
			$rep=array(	
					"define(\"CTIME\", \"{$post['ctime']}\");",
					"define(\"APP_NAME\", \"{$post['appname']}\");",
					"define(\"DESCRIPTION\", \"{$post['description']}\");",
					"define(\"MESSAGE_PAGE_SIZE\", \"{$post['messagePageSize']}\");",
					"define(\"USER_PAGE_SIZE\", \"{$post['userPageSize']}\");",
					"define(\"CSTART\",\"{$post['cstart']}\");"
				);
			
			return file_put_contents($confile, preg_replace($reg, $rep, $configText));
		}
	}

