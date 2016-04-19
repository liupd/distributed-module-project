CREATE TABLE `bd_testitem_type` (
  `id` bigint(20) NOT NULL auto_increment,
  `business_key` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  `is_object` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `update_time` datetime NOT NULL,
  `is_delete` varchar(255) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `business_key` USING BTREE (`business_key`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

INSERT INTO `bd_testitem_type` (`id`, `business_key`, `create_time`, `is_object`, `name`, `update_time`, `is_delete`) VALUES (1, '866657d5750145e9be3299adbb25e55b', '2015-7-9 16:06:18', 'N', '填空题', '2015-7-9 16:06:18', 'N');
INSERT INTO `bd_testitem_type` (`id`, `business_key`, `create_time`, `is_object`, `name`, `update_time`, `is_delete`) VALUES (2, '9a4f2e753fff4e64924982053650894d', '2015-7-9 16:06:18', 'N', '单选题', '2015-7-9 16:06:18', 'N');
INSERT INTO `bd_testitem_type` (`id`, `business_key`, `create_time`, `is_object`, `name`, `update_time`, `is_delete`) VALUES (3, '294725538f084630b9b97a27c6ad1ee4', '2015-7-9 16:06:18', 'N', '多选题', '2015-7-9 16:06:18', 'N');
INSERT INTO `bd_testitem_type` (`id`, `business_key`, `create_time`, `is_object`, `name`, `update_time`, `is_delete`) VALUES (4, 'd0ab340a688940c3aa9cabacb32535a2', '2015-7-9 16:06:18', 'N', '简答题', '2015-7-9 16:06:18', 'N');
INSERT INTO `bd_testitem_type` (`id`, `business_key`, `create_time`, `is_object`, `name`, `update_time`, `is_delete`) VALUES (5, 'd6a5ac07f7054ee0940807a61ab1bc7b', '2015-7-9 16:06:18', 'N', '计算题', '2015-7-9 16:06:18', 'N');
INSERT INTO `bd_testitem_type` (`id`, `business_key`, `create_time`, `is_object`, `name`, `update_time`, `is_delete`) VALUES (6, '36f6dc8467fc46319e312a25a3e55fe5', '2015-7-9 16:06:18', 'N', '问答题', '2015-7-9 16:06:18', 'N');
INSERT INTO `bd_testitem_type` (`id`, `business_key`, `create_time`, `is_object`, `name`, `update_time`, `is_delete`) VALUES (7, '1835300d090444c18330fd41a60cd7ca', '2015-7-9 16:06:18', 'N', '判断题', '2015-7-9 16:06:18', 'N');
INSERT INTO `bd_testitem_type` (`id`, `business_key`, `create_time`, `is_object`, `name`, `update_time`, `is_delete`) VALUES (8, '276a18c83f794fe18f4882fd82a78369', '2015-7-9 16:06:18', 'N', '连线题', '2015-7-9 16:06:18', 'N');
INSERT INTO `bd_testitem_type` (`id`, `business_key`, `create_time`, `is_object`, `name`, `update_time`, `is_delete`) VALUES (9, '8bef1e2eb7454c67a48ca7f0d2d87cb3', '2015-7-9 16:06:18', 'N', '写作', '2015-7-9 16:06:18', 'N');
INSERT INTO `bd_testitem_type` (`id`, `business_key`, `create_time`, `is_object`, `name`, `update_time`, `is_delete`) VALUES (10, '6c4206410f734b93a30aec92c567ca85', '2015-7-9 16:06:18', 'N', '听力题', '2015-7-9 16:06:18', 'N');
INSERT INTO `bd_testitem_type` (`id`, `business_key`, `create_time`, `is_object`, `name`, `update_time`, `is_delete`) VALUES (11, 'eb26b0142f9b42148c24ca16d26d3e2c', '2015-7-9 16:06:18', 'N', '阅读理解', '2015-7-9 16:06:18', 'N');
INSERT INTO `bd_testitem_type` (`id`, `business_key`, `create_time`, `is_object`, `name`, `update_time`, `is_delete`) VALUES (12, 'ca08e5fd4bec449d90bd58e0f814a31e', '2015-7-9 16:06:18', 'N', '实验题', '2015-7-9 16:06:18', 'N');
INSERT INTO `bd_testitem_type` (`id`, `business_key`, `create_time`, `is_object`, `name`, `update_time`, `is_delete`) VALUES (13, '97f2fc182ef6479f8f216cb1e64ec8d4', '2015-7-9 16:06:18', 'N', '论述题', '2015-7-9 16:06:18', 'N');
INSERT INTO `bd_testitem_type` (`id`, `business_key`, `create_time`, `is_object`, `name`, `update_time`, `is_delete`) VALUES (14, '29f7afb55657428fa17927bc18880c7a', '2015-7-9 16:06:18', 'N', '材料分析题', '2015-7-9 16:06:18', 'N');
INSERT INTO `bd_testitem_type` (`id`, `business_key`, `create_time`, `is_object`, `name`, `update_time`, `is_delete`) VALUES (15, 'f6bf893862f741269ae95023fcbf790b', '2015-7-9 16:06:18', 'N', '解答题', '2015-7-9 16:06:18', 'N');
INSERT INTO `bd_testitem_type` (`id`, `business_key`, `create_time`, `is_object`, `name`, `update_time`, `is_delete`) VALUES (16, 'a4399978569a4cf89f6baa2057f01581', '2015-7-9 16:06:18', 'N', '操作题', '2015-7-9 16:06:18', 'N');
INSERT INTO `bd_testitem_type` (`id`, `business_key`, `create_time`, `is_object`, `name`, `update_time`, `is_delete`) VALUES (17, '733a683a3cb043cea005eec46bbe5fa6', '2015-7-9 16:06:18', 'N', '综合题', '2015-7-9 16:06:18', 'N');
INSERT INTO `bd_testitem_type` (`id`, `business_key`, `create_time`, `is_object`, `name`, `update_time`, `is_delete`) VALUES (18, '763ba7e78abf4c848ae8f65778202817', '2015-7-9 16:06:18', 'Y', '其他选择题', '2015-7-29 11:10:57', 'N');
