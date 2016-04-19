CREATE TABLE `bd_syslog` (
  `id` varchar(40) NOT NULL,
  `type` varchar(20) default NULL COMMENT '日志类型',
  `app_key` varchar(40) default NULL COMMENT '应用key',
  `app_remark` varchar(100) default NULL COMMENT '应用说明',
  `user_key` varchar(40) default NULL COMMENT '用户key',
  `user_name` varchar(40) default NULL COMMENT '用户名',
  `agent` varchar(512) default NULL COMMENT '请求终端(浏览器版本)',
  `request_url` varchar(1024) default NULL COMMENT '请求的url',
  `method` varchar(20) default NULL COMMENT '请求的方式',
  `params` text COMMENT '请求的参数',
  `remote_addr` varchar(20) default NULL COMMENT '用户的IP',
  `result` text COMMENT '返回结果',
  `request_time` timestamp NULL default NULL COMMENT '请求时间',
  PRIMARY KEY  (`id`),
  KEY `remoteAddr` (`remote_addr`),
  KEY `userKey` (`user_key`),
  KEY `type` (`type`),
  KEY `appkey` (`app_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作日志';

