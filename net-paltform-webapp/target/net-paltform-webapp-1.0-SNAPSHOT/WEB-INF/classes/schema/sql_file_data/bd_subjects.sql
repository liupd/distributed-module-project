CREATE TABLE `bd_subjects` (
  `id` bigint(20) NOT NULL auto_increment,
  `business_key` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  `name` varchar(255) NOT NULL,
  `update_time` datetime NOT NULL,
  `user_business_key` varchar(255) default NULL,
  `is_delete` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  KEY `business_key` USING BTREE (`business_key`),
  KEY `is_delete` USING BTREE (`is_delete`),
  KEY `name` USING BTREE (`name`),
  KEY `user_business_key` USING BTREE (`user_business_key`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

INSERT INTO `bd_subjects` (`id`, `business_key`, `create_time`, `name`, `update_time`, `user_business_key`, `is_delete`) VALUES (1, 'f4feb3cf4f8e4ed5840da94fe9fb9ec2', '2015-7-6 16:17:08', '语文', '2015-8-15 20:15:03', '', 'N');
INSERT INTO `bd_subjects` (`id`, `business_key`, `create_time`, `name`, `update_time`, `user_business_key`, `is_delete`) VALUES (2, 'c5597ff321044025856a66de72fcb9e3', '2015-7-6 16:17:08', '数学', '2015-7-6 16:17:08', NULL, 'N');
INSERT INTO `bd_subjects` (`id`, `business_key`, `create_time`, `name`, `update_time`, `user_business_key`, `is_delete`) VALUES (3, '0ba78c4acc6844ecb0192ea2ef9b8008', '2015-7-6 16:17:08', '英语', '2015-7-6 16:17:08', NULL, 'N');
INSERT INTO `bd_subjects` (`id`, `business_key`, `create_time`, `name`, `update_time`, `user_business_key`, `is_delete`) VALUES (4, '217641ef50b34fbd8f9f9c8d07d862bb', '2015-7-6 16:17:08', '物理', '2015-7-6 16:17:08', NULL, 'N');
INSERT INTO `bd_subjects` (`id`, `business_key`, `create_time`, `name`, `update_time`, `user_business_key`, `is_delete`) VALUES (5, 'b07c6975fa5c4e8383248d78814974c0', '2015-7-6 16:17:08', '化学', '2015-7-6 16:17:08', NULL, 'N');
INSERT INTO `bd_subjects` (`id`, `business_key`, `create_time`, `name`, `update_time`, `user_business_key`, `is_delete`) VALUES (6, 'c89dc00981274ec38ea73140b074731b', '2015-7-6 16:17:08', '生物', '2015-7-6 16:17:08', NULL, 'N');
INSERT INTO `bd_subjects` (`id`, `business_key`, `create_time`, `name`, `update_time`, `user_business_key`, `is_delete`) VALUES (7, '32ecf4ae332f48279eba32152a5af82b', '2015-7-6 16:17:08', '地理', '2015-7-6 16:17:08', NULL, 'N');
INSERT INTO `bd_subjects` (`id`, `business_key`, `create_time`, `name`, `update_time`, `user_business_key`, `is_delete`) VALUES (8, '7546a15f096d4d75ba44c7a34ad15d79', '2015-7-6 16:17:08', '历史', '2015-7-6 16:17:08', NULL, 'N');
INSERT INTO `bd_subjects` (`id`, `business_key`, `create_time`, `name`, `update_time`, `user_business_key`, `is_delete`) VALUES (9, 'ac4e15eb433548f994b62a93bb14b40d', '2015-7-6 16:17:08', '政治', '2015-7-6 16:17:08', NULL, 'N');
INSERT INTO `bd_subjects` (`id`, `business_key`, `create_time`, `name`, `update_time`, `user_business_key`, `is_delete`) VALUES (10, 'a0389c34fbcb491186ce883beb747ddb', '2015-7-6 16:17:08', '美术', '2015-7-6 16:17:08', NULL, 'N');
INSERT INTO `bd_subjects` (`id`, `business_key`, `create_time`, `name`, `update_time`, `user_business_key`, `is_delete`) VALUES (11, '7fdd8536a73f491f9c4a409c78ff7d06', '2015-7-6 16:17:08', '音乐', '2015-7-6 16:17:08', NULL, 'N');
INSERT INTO `bd_subjects` (`id`, `business_key`, `create_time`, `name`, `update_time`, `user_business_key`, `is_delete`) VALUES (12, 'e5d7aecd1a8347e794e9d1e473c49757', '2015-7-6 16:17:08', '科学', '2015-7-6 16:17:08', NULL, 'N');
INSERT INTO `bd_subjects` (`id`, `business_key`, `create_time`, `name`, `update_time`, `user_business_key`, `is_delete`) VALUES (13, 'b31caf7401a6418596e0a9407420426e', '2015-7-6 16:17:08', '思想品德', '2015-7-6 16:17:08', NULL, 'N');
INSERT INTO `bd_subjects` (`id`, `business_key`, `create_time`, `name`, `update_time`, `user_business_key`, `is_delete`) VALUES (14, '4f159029464b4c2780345782f6b0e4b9', '2015-7-6 16:17:08', '思想政治', '2015-7-6 16:17:08', NULL, 'N');
INSERT INTO `bd_subjects` (`id`, `business_key`, `create_time`, `name`, `update_time`, `user_business_key`, `is_delete`) VALUES (15, 'ab0180b63b8d4b2d849c00bb610e1b20', '2015-7-6 16:17:08', '品德与社会', '2015-7-6 16:17:08', NULL, 'N');
