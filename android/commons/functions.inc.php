<?php
	//全局可以使用的通用函数声明在这个文件中.

	function del_dir($file_path){
		if(is_dir($file_path)){
			if($dir_handle = @opendir($file_path)){
				while(false!==($file_name=readdir($dir_handle))){
					$file = $file_path."/".$file_name;
					if($file_name!="." && $file_name != ".."){
						if(is_dir($file))
							del_dir($file);
						else
							unlink($file);
					}
				}
				closedir($dir_handle);
			}
			rmdir($file_path);
		}
	}
	/*
	function execute($statement, $memcache){
		$key = md5($statement);
		$data = $memcache->get($key);

		if(!$data){
			try{
				$pdo = new PDO("mysql:host=localhost;dbname=android", "root", "root");
			}catch(PDOException $e){
				die('本地服务器连接失败：'.$e->getMessage());
			}
			$pre = $pdo->prepare($statement);
			$pre->execute();
			$data = $pre->fetchALl(PDO::FETCH_ASSOC);
			
			$memcache->add($key, $data, MEMCACHE_COMPRESSED, 0);
			echo '!data';
			var_dump($data);
			
		}else{
			echo 'data';
		}
		return $data;
	}
	*/

	function connect_execute($statement){
		
		$link = mysql_connect("localhost", "root", "root");
		if(!$link)
			die("本地服务器连接失败：".mysql_error());
		mysql_select_db("android", $link) or die("连接数据库失败".mysql_error());
		$result = mysql_query($statement);
		if($result)
			return $result;
		else
			return false;
			
		/*
		$memcache = new Memcache;
		$memcache->connect("localhost", 11211);
		$result = execute($statement, $memcache);
		$memcache->flush();
		return $result;
		 */
	}