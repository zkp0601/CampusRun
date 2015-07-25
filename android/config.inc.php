<?php
	define("DEBUG", 1);				      //开启调试模式 1 开启 0 关闭
	define("DRIVER","mysqli");				      //数据库的驱动，本系统支持pdo(默认)和mysqli两种
	//define("DSN", "mysql:host=localhost;dbname=brophp"); //如果使用PDO可以使用，不使用则默认连接MySQL
	define("HOST", "localhost");			      //数据库主机
	define("USER", "root");                               //数据库用户名
	define("PASS", "root");                                   //数据库密码
	define("DBNAME","android");			      //数据库名
	define("TABPREFIX", "");                           //数据表前缀
	define("CSTART","1");                                  //缓存开关 1开启，0为关闭
	define("CTIME", "6");                          //缓存时间
	define("TPLPREFIX", "tpl");                           //模板文件的后缀名
	define("TPLSTYLE", "default");                        //默认模板存放的目录

	//$memServers = array("localhost", 11211);	     //使用memcache服务器
	/*
	如果有多台memcache服务器可以使用二维数组
	$memServers = array(
			array("www.XXX.net", '11211'),
			array("www.XXX.com", '11211'),
			...
		);
	*/

	define("MESSAGE_PAGE_SIZE", "16");
	define("USER_PAGE_SIZE", "10");
	define("CTIME", "6");
	define("APP_NAME", "Campus Run 后台管理系统");
	define("DESCRIPTION", "本后台使用了broPHP框架，用于管理校园应用Campus Run的信息");