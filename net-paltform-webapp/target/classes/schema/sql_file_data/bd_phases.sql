
CREATE TABLE `bd_phases` (
  `id` bigint(20) NOT NULL auto_increment,
  `business_key` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  `name` varchar(255) NOT NULL,
  `update_time` datetime NOT NULL,
  `is_delete` varchar(255) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `business_key` USING BTREE (`business_key`),
  KEY `is_delete` USING BTREE (`is_delete`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

INSERT INTO `bd_phases` (`id`, `business_key`, `create_time`, `name`, `update_time`, `is_delete`) VALUES (1, 'd44f7bc731bd48d999b3d8d7443be7cc', '2015-7-6 15:36:12', '小学', '2015-8-15 20:14:54', 'N');
INSERT INTO `bd_phases` (`id`, `business_key`, `create_time`, `name`, `update_time`, `is_delete`) VALUES (2, '504a0baff23e44abbd3badc2d1b89aaf', '2015-7-6 15:36:12', '初中', '2015-7-6 15:36:12', 'N');
INSERT INTO `bd_phases` (`id`, `business_key`, `create_time`, `name`, `update_time`, `is_delete`) VALUES (3, 'e78f5514b8a048fc874509e9747befa8', '2015-7-6 15:36:12', '高中', '2015-7-6 15:36:12', 'N');
