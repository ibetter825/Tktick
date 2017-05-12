/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : tktick

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2017-05-12 16:52:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tk_article
-- ----------------------------
DROP TABLE IF EXISTS `tk_article`;
CREATE TABLE `tk_article` (
  `art_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `art_title` varchar(100) NOT NULL COMMENT '文章标题',
  `art_desc` varchar(200) DEFAULT '' COMMENT '文章摘要',
  `acc_id` bigint(20) NOT NULL COMMENT '文章作者FK',
  `add_time` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `edit_time` bigint(20) NOT NULL DEFAULT '0' COMMENT '最后修改时间',
  `art_state` tinyint(4) NOT NULL DEFAULT '1' COMMENT '文章状态: 1正常 -1软删除',
  `art_auth` tinyint(4) NOT NULL COMMENT '文章权限: 0:仅自己可见 1: 所有人可见 2:部分可见(另外一张表配合)',
  `art_cont` text COMMENT '文章内容',
  `art_imgs` varchar(4000) DEFAULT '' COMMENT '文章中的图片地址，每张图片之间用";"隔开',
  PRIMARY KEY (`art_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章表';

-- ----------------------------
-- Records of tk_article
-- ----------------------------

-- ----------------------------
-- Table structure for tk_comment
-- ----------------------------
DROP TABLE IF EXISTS `tk_comment`;
CREATE TABLE `tk_comment` (
  `comt_id` bigint(20) NOT NULL AUTO_INCREMENT,
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
  `art_id` bigint(20) NOT NULL,
  `set_id` int(11) NOT NULL,
  PRIMARY KEY (`dver_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投稿记录';

-- ----------------------------
-- Records of tk_deliver
-- ----------------------------

-- ----------------------------
-- Table structure for tk_reply
-- ----------------------------
DROP TABLE IF EXISTS `tk_reply`;
CREATE TABLE `tk_reply` (
  `reply_id` bigint(20) NOT NULL,
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
  PRIMARY KEY (`set_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='合集表';

-- ----------------------------
-- Records of tk_set
-- ----------------------------

-- ----------------------------
-- Table structure for tk_set_keeper
-- ----------------------------
DROP TABLE IF EXISTS `tk_set_keeper`;
CREATE TABLE `tk_set_keeper` (
  `set_id` int(11) DEFAULT NULL,
  `acc_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='合集管理员表';

-- ----------------------------
-- Records of tk_set_keeper
-- ----------------------------

-- ----------------------------
-- Table structure for tk_tag
-- ----------------------------
DROP TABLE IF EXISTS `tk_tag`;
CREATE TABLE `tk_tag` (
  `tag_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tag_nm` varchar(50) NOT NULL DEFAULT '',
  `art_num` int(11) NOT NULL DEFAULT '0' COMMENT '该标签下文章数量，触发器控制',
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='标签表';

-- ----------------------------
-- Records of tk_tag
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
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL DEFAULT '' COMMENT '登录名',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of tk_user
-- ----------------------------
