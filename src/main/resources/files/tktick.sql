/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50711
Source Host           : 127.0.0.1:3306
Source Database       : tktick

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2017-07-18 21:10:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tk_article
-- ----------------------------
DROP TABLE IF EXISTS `tk_article`;
CREATE TABLE `tk_article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `art_title` varchar(100) NOT NULL COMMENT '文章标题',
  `art_desc` varchar(200) DEFAULT '' COMMENT '文章摘要',
  `clz_id` int(11) DEFAULT '0' COMMENT '文章分类',
  `user_id` int(11) NOT NULL COMMENT '文章作者FK',
  `add_time` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `edit_time` bigint(20) NOT NULL DEFAULT '0' COMMENT '最后修改时间',
  `art_state` tinyint(4) NOT NULL DEFAULT '1' COMMENT '文章状态: 1正常 -1软删除',
  `art_auth` tinyint(4) NOT NULL DEFAULT '1' COMMENT '文章权限: 0:仅自己可见 1: 所有人可见 2:部分可见(另外一张表配合)',
  `art_cont` text COMMENT '文章内容',
  `art_imgs` varchar(4000) DEFAULT '' COMMENT '文章中的图片地址，每张图片之间用";"隔开',
  `art_tag_nms` varchar(200) DEFAULT '' COMMENT '文章标签名","隔开',
  `art_tag_ids` varchar(100) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章表';

-- ----------------------------
-- Records of tk_article
-- ----------------------------

-- ----------------------------
-- Table structure for tk_article_clz
-- ----------------------------
DROP TABLE IF EXISTS `tk_article_clz`;
CREATE TABLE `tk_article_clz` (
  `clz_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `clz_nm` varchar(20) NOT NULL DEFAULT '' COMMENT '分类名称',
  `clz_state` tinyint(4) NOT NULL DEFAULT '1' COMMENT '-1:软删除 1:正常',
  `clz_seq` smallint(6) DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`clz_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章分类';

-- ----------------------------
-- Records of tk_article_clz
-- ----------------------------

-- ----------------------------
-- Table structure for tk_comment
-- ----------------------------
DROP TABLE IF EXISTS `tk_comment`;
CREATE TABLE `tk_comment` (
  `comt_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comt_time` bigint(20) NOT NULL DEFAULT '0' COMMENT '评论时间',
  `comt_cont` varchar(500) NOT NULL DEFAULT '' COMMENT '评论内容，140字以内',
  `user_id` int(11) NOT NULL COMMENT '评论人',
  `art_id` bigint(1) NOT NULL COMMENT '被评论的文章',
  `comt_state` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态: 1:正常 -1:软删除',
  PRIMARY KEY (`comt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论表';

-- ----------------------------
-- Records of tk_comment
-- ----------------------------

-- ----------------------------
-- Table structure for tk_deliver
-- ----------------------------
DROP TABLE IF EXISTS `tk_deliver`;
CREATE TABLE `tk_deliver` (
  `dver_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '投稿编号',
  `art_id` bigint(20) NOT NULL COMMENT '文章id',
  `set_id` int(11) NOT NULL COMMENT '合集id',
  `dver_time` bigint(20) DEFAULT '0' COMMENT '投递时间',
  `dver_state` tinyint(4) DEFAULT '0' COMMENT '投递状态: -1:软删除 0:未被处理, 1:已处理且被收录 2:已处理但被退回 3:撤回投递',
  PRIMARY KEY (`dver_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投稿记录';

-- ----------------------------
-- Records of tk_deliver
-- ----------------------------

-- ----------------------------
-- Table structure for tk_dict
-- ----------------------------
DROP TABLE IF EXISTS `tk_dict`;
CREATE TABLE `tk_dict` (
  `dict_no` varchar(50) NOT NULL DEFAULT '' COMMENT '字典编码',
  `dict_fno` varchar(50) DEFAULT '' COMMENT '父级字典',
  `dict_nm` varchar(100) DEFAULT '' COMMENT '字典名称',
  `dict_desc` varchar(200) DEFAULT '',
  `dict_state` tinyint(4) DEFAULT '0' COMMENT '状态',
  `dict_seq` int(11) DEFAULT '0' COMMENT '同级排序',
  `dict_icon` varchar(100) DEFAULT '' COMMENT '图标，或者类',
  `dict_par` varchar(1000) DEFAULT '' COMMENT '字典参数',
  PRIMARY KEY (`dict_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典表';

-- ----------------------------
-- Records of tk_dict
-- ----------------------------

-- ----------------------------
-- Table structure for tk_reply
-- ----------------------------
DROP TABLE IF EXISTS `tk_reply`;
CREATE TABLE `tk_reply` (
  `reply_id` bigint(20) NOT NULL,
  `reply_time` bigint(20) NOT NULL DEFAULT '0' COMMENT '回复时间',
  `reply_cont` varchar(500) NOT NULL DEFAULT '' COMMENT '回复内容，140字以内',
  `comt_id` bigint(20) NOT NULL COMMENT '被回复的评论',
  `user_id` int(20) NOT NULL COMMENT '回复人',
  `reply_state` tinyint(4) NOT NULL DEFAULT '1' COMMENT '回复状态: 1:正常 -1:软删除',
  PRIMARY KEY (`reply_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='回复表';

-- ----------------------------
-- Records of tk_reply
-- ----------------------------

-- ----------------------------
-- Table structure for tk_set
-- ----------------------------
DROP TABLE IF EXISTS `tk_set`;
CREATE TABLE `tk_set` (
  `set_id` int(11) NOT NULL AUTO_INCREMENT,
  `set_title` varchar(100) NOT NULL DEFAULT '' COMMENT '合集名称',
  `art_num` int(11) DEFAULT '0' COMMENT '收录的文章数量，使用触发器操作',
  `add_time` bigint(20) DEFAULT '0' COMMENT '创建时间',
  `edit_time` bigint(20) DEFAULT '0' COMMENT '修改时间',
  `set_desc` varchar(2000) DEFAULT '' COMMENT '合集简介',
  PRIMARY KEY (`set_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='合集表';

-- ----------------------------
-- Records of tk_set
-- ----------------------------
INSERT INTO `tk_set` VALUES ('1', '测试', '0', '0', '0', '测试描述');

-- ----------------------------
-- Table structure for tk_set_keeper
-- ----------------------------
DROP TABLE IF EXISTS `tk_set_keeper`;
CREATE TABLE `tk_set_keeper` (
  `kpr_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `set_id` int(11) NOT NULL COMMENT '合集id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `kpr_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '管理员分类:  1:创建者 0:其他管理员',
  PRIMARY KEY (`kpr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='合集管理员表';

-- ----------------------------
-- Records of tk_set_keeper
-- ----------------------------

-- ----------------------------
-- Table structure for tk_tag
-- ----------------------------
DROP TABLE IF EXISTS `tk_tag`;
CREATE TABLE `tk_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_nm` varchar(50) NOT NULL DEFAULT '' COMMENT '标签名,主键',
  `art_num` int(11) NOT NULL DEFAULT '0' COMMENT '该标签下文章数量，触发器控制',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE_TK_TAG_TAG_NM` (`tag_nm`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='标签表';

-- ----------------------------
-- Records of tk_tag
-- ----------------------------
INSERT INTO `tk_tag` VALUES ('1', '丹霞', '0');
INSERT INTO `tk_tag` VALUES ('2', '清迈', '0');
INSERT INTO `tk_tag` VALUES ('10', '邓丽君', '0');

-- ----------------------------
-- Table structure for tk_tag_art
-- ----------------------------
DROP TABLE IF EXISTS `tk_tag_art`;
CREATE TABLE `tk_tag_art` (
  `tag_id` int(11) NOT NULL,
  `art_id` bigint(20) NOT NULL COMMENT '文章id',
  PRIMARY KEY (`tag_id`,`art_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章标签关联表';

-- ----------------------------
-- Records of tk_tag_art
-- ----------------------------

-- ----------------------------
-- Table structure for tk_theme
-- ----------------------------
DROP TABLE IF EXISTS `tk_theme`;
CREATE TABLE `tk_theme` (
  `thm_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`thm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专题表';

-- ----------------------------
-- Records of tk_theme
-- ----------------------------

-- ----------------------------
-- Table structure for tk_topic
-- ----------------------------
DROP TABLE IF EXISTS `tk_topic`;
CREATE TABLE `tk_topic` (
  `top_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`top_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='话题表';

-- ----------------------------
-- Records of tk_topic
-- ----------------------------

-- ----------------------------
-- Table structure for tk_user
-- ----------------------------
DROP TABLE IF EXISTS `tk_user`;
CREATE TABLE `tk_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT '' COMMENT '登录名',
  `user_pwd` varchar(32) NOT NULL COMMENT '用户密码',
  `user_salt` varchar(10) NOT NULL COMMENT '加密用字符串',
  `user_phone` bigint(11) DEFAULT '0' COMMENT '用户电话号码，可用于登录',
  `user_email` varchar(100) DEFAULT '' COMMENT '用户邮箱，可用于登录',
  `user_state` tinyint(4) DEFAULT '1' COMMENT '状态: -1：删除，0：限制登陆，1：正常',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `INX_TK_USER_USER_NAME` (`user_name`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of tk_user
-- ----------------------------
INSERT INTO `tk_user` VALUES ('10000', 'tktick', 'BB855C106B50CEA148E553154E3DF151', 'yang', '13408458790', 'y825y@qq.com', '1');

-- ----------------------------
-- Table structure for tk_user_info
-- ----------------------------
DROP TABLE IF EXISTS `tk_user_info`;
CREATE TABLE `tk_user_info` (
  `user_id` int(11) NOT NULL,
  `user_avatar` varchar(200) DEFAULT '' COMMENT '用户头像',
  `user_intro` varchar(500) DEFAULT '' COMMENT '用户简介',
  `nick_name` varchar(100) DEFAULT '' COMMENT '用户昵称',
  `user_sex` tinyint(4) DEFAULT '1' COMMENT '用户性别: 1: 男  0:女',
  `login_time` bigint(20) DEFAULT '0' COMMENT '上次登录时间',
  `login_ip` varchar(50) DEFAULT '' COMMENT '上次登录ip,另外一张表使用触发器自动记录登录时间与ip',
  `reg_time` bigint(20) DEFAULT '0' COMMENT '注册时间',
  `err_count` tinyint(20) DEFAULT '0' COMMENT '连续登录错误次数',
  `stop_time` bigint(20) DEFAULT '0' COMMENT '限制登录开始时间，24小时候才能再次登录并清空'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户详情表';

-- ----------------------------
-- Records of tk_user_info
-- ----------------------------
INSERT INTO `tk_user_info` VALUES ('10000', '', '第一个用户', 'TkTick', '1', '1500295938859', '127.0.0.1', '0', '0', '1495517899241');
DROP TRIGGER IF EXISTS `t_after_insert_on_tk_tag_art`;
DELIMITER ;;
CREATE TRIGGER `t_after_insert_on_tk_tag_art` AFTER INSERT ON `tk_tag_art` FOR EACH ROW BEGIN
	UPDATE tk_tag SET art_num = art_num + 1 WHERE id = new.tag_id;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `t_after_delete_on_tk_tag_art`;
DELIMITER ;;
CREATE TRIGGER `t_after_delete_on_tk_tag_art` AFTER DELETE ON `tk_tag_art` FOR EACH ROW BEGIN
	update tk_tag set art_num = art_num - 1 where id = old.tag_id and art_num > 0;
END
;;
DELIMITER ;
