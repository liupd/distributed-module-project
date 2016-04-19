
CREATE TABLE `bd_static_config` (
  `id` varchar(40) NOT NULL,
  `name` varchar(100) NOT NULL COMMENT '显示名称',
  `value` varchar(50) NOT NULL COMMENT '值',
  `type` varchar(50) NOT NULL COMMENT '类别',
  `sort` int(11) default NULL COMMENT '排序',
  PRIMARY KEY  (`id`),
  KEY `type` USING BTREE (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统静态参数配置表';


INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('014632be-ff35-4064-a06a-6b36c4472731', '高考', 'collegeEntrance', 'categroy', 3);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('0480511a-fb1a-408a-b18e-360133c1bf7c', '励志', 'Inspirational', 'ebookType', 12);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('0814b1ad-3067-4e96-bed0-91a2b45dbee2', '菜单', 'MENU', 'authResouceType', 1);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('0c7047c5-8588-4369-ada3-7d45a7dd87d4', '冲刺', 'sprint', 'categroy', 1);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('0f55539f-df2c-4568-ab0f-d7b06c85c2d3', '课外读物', 'ebook', 'resourceType', 2);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('100e893e-dd46-4089-b812-1d0c0c1e19ce', '历史', 'history', 'ebookType', 13);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('13bf3725-c8be-49d9-b68b-28a5b7d3f7c4', '视频', 'VIDEO', 'resourceTeachType', 3);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('1f22434e-f7c4-41dd-8efd-aa3e66331f96', '文档', 'FILE', 'resourceTeachType', 1);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('346e2619-77d2-47ba-ad76-7bacf8e6f919', '课本', 'textbook', 'textbookType', 1);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('41f397c6-2e7c-46d6-94c5-df267a405844', '填空题', 'FILLING', 'questionType', 2);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('4deb2f35-504c-40e8-8bfd-a302128e8017', '教学资源', 'resourceTeaching', 'resourceType', 3);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('52e41486-12c5-4a76-96df-3e4e6b5112fd', '家长', '3', 'userGroup', 3);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('550835b4-6f11-45a0-bd7b-cd0e84716737', '教师', '1', 'userGroup', 1);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('5f67e2c1-10b6-4509-99a3-f248cd66e121', '模拟', 'simulation', 'categroy', 2);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('69169d00-6874-4bd5-a6f5-0b38125ffb3e', '动漫', 'Animation', 'ebookType', 14);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('6a816fa0-6f76-43cb-86f8-e21d798c668e', '判断题', 'JUDGE', 'questionType', 3);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('6b828379-e4f3-4d2f-be8c-d2b93e02cafa', '图片', 'IMAGE', 'resourceTeachType', 2);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('714c9208-1d24-481a-84af-bb3f44d72e61', '军事', 'military', 'ebookType', 11);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('7d7da409-fc13-4e26-b41c-4f3a2bf8b5bf', '普通用户', '4', 'userGroup', 4);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('7dcfec42-faae-42d9-aab2-0e383aacf667', '课辅', 'auxiliary', 'textbookType', 2);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('7f0ed4ca-05cd-4b83-89a1-61aa959dc15d', '学生', '2', 'userGroup', 2);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('a3dba2fd-6e62-49e8-9f01-3281e4d21f18', '选择题', 'CHOICE', 'questionType', 1);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('a54d7480-9715-49bb-86ce-ecafd70593f1', '艺术', 'art', 'ebookType', 1);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('a8c587d7-f3fd-4c65-b9e6-df1cafc41901', '功能', 'FUNCTION', 'authResouceType', 2);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('b67b837b-5b68-471a-a2f1-d953cd8e7f73', '学件', 'learnMaterials', 'resourceCategroy', 2);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('c00c3da1-dffb-4cef-956e-09674ff7a279', '简答题', 'SHORTANSWER', 'questionType', 4);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('c9643354-c033-4add-87d9-b3545d2a474e', '课件', 'courseware', 'resourceCategroy', 1);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('c9c1a4a5-8f5a-4ac3-af53-6305d7aa26dd', '少儿', 'Children', 'ebookType', 2);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('d8d6eb64-8cbb-4de0-83be-e85a76bfdea3', '工具书', 'referenceBook', 'ebookType', 3);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('dc832027-9d6e-4c7d-b608-8e0e9c41cdc5', '学习方法', 'studyMethod', 'ebookType', 4);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('de804391-134e-4c3a-aa12-754d85445bad', '国学', 'Sinology', 'ebookType', 5);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('e038483c-1343-4954-b8bb-129481f90ce8', '心理学', 'psychology', 'ebookType', 6);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('e6a520c9-30a0-4a52-b993-7578a48a1899', '综合题', 'SYNTHETICAL', 'questionType', 5);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('e71b6135-b9f2-4bc9-b663-ced5d477d0ea', '音频', 'AUDIO', 'resourceTeachType', 4);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('f245e137-2f65-4aac-9c32-6378d902ceea', '科普', 'PopularScience', 'ebookType', 7);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('f79b4bbd-7512-45ee-87ca-272a54da1e49', '地理', 'geography', 'ebookType', 8);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('f8d911ab-1608-4686-a05b-90a6e7da7065', '文学', 'literature', 'ebookType', 9);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('fabb53e4-c3d4-4daf-937c-58372bd4c0b7', '小说', 'Fiction', 'ebookType', 10);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('fbb67e95-70b0-4f24-ae49-b53d5ea07b4a', '教材', 'textbook', 'resourceType', 1);
INSERT INTO `bd_static_config` (`id`, `name`, `value`, `type`, `sort`) VALUES ('fcbe1a54-47de-4c0c-995b-9e5d34997118', '积件', 'accumulation', 'resourceCategroy', 3);
