/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : robot

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2019-11-10 11:48:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_address
-- ----------------------------
DROP TABLE IF EXISTS `tbl_address`;
CREATE TABLE `tbl_address` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `ipType` int(2) DEFAULT '0' COMMENT '类型（0 算法 1 其他）',
  `ip` varchar(512) DEFAULT NULL COMMENT 'IP地址',
  `level` int(2) DEFAULT NULL COMMENT '级别 1 2 3',
  `area` varchar(255) DEFAULT NULL COMMENT '区域',
  `cameraId` varchar(512) DEFAULT NULL COMMENT '摄像头id',
  `location` varchar(512) DEFAULT NULL COMMENT '摄像头位置',
  `audioId` VARCHAR(512) DEFAULT NULL COMMENT '音响id',
  `audioLocation` VARCHAR(512) DEFAULT NULL COMMENT '音响位置',
  `userId` int(12) DEFAULT NULL COMMENT '用户id',
  `createUser` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `pid` int(12) DEFAULT NULL,
  `status` int(2) DEFAULT '0' COMMENT '状态（0未删除,1删除）',
  `timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_admin_key
-- ----------------------------
DROP TABLE IF EXISTS `tbl_admin_key`;
CREATE TABLE `tbl_admin_key` (
  `adminKey` varchar(255) DEFAULT NULL COMMENT '找回超级密码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_alarm_info
-- ----------------------------
DROP TABLE IF EXISTS `tbl_alarm_info`;
CREATE TABLE `tbl_alarm_info` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT,
  `sourceId` bigint(20) DEFAULT NULL,
  `alarmId` int(10) DEFAULT NULL COMMENT 'ID',
  `alarmName` varchar(2048) DEFAULT NULL COMMENT '报警事件名称,算法名称',
  `server` varchar(512) DEFAULT NULL,
  `takePic1` longtext COMMENT '图片1-报警对象图片',
  `alarmTime` datetime DEFAULT NULL COMMENT '报警时间',
  `ivsHostId` varchar(12) DEFAULT NULL COMMENT '通道号',
  `isDelete` int(1) DEFAULT '0' COMMENT '是否处理',
  `timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73429 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_alarm_type
-- ----------------------------
DROP TABLE IF EXISTS `tbl_alarm_type`;
CREATE TABLE `tbl_alarm_type` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `alarmNameEn` varchar(1024) DEFAULT NULL COMMENT '算法类型（名称 唯一的）',
  `alarmName` varchar(1024) DEFAULT NULL,
  `timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_config
-- ----------------------------
DROP TABLE IF EXISTS `tbl_config`;
CREATE TABLE `tbl_config` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `config` varchar(512) DEFAULT NULL,
  `timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_last_taskid
-- ----------------------------
DROP TABLE IF EXISTS `tbl_last_taskid`;
CREATE TABLE `tbl_last_taskid` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT,
  `lastId` bigint(10) NOT NULL,
  `dateStr` varchar(50) DEFAULT NULL,
  `serveAddress` varchar(1024) DEFAULT NULL,
  `timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dateStr` (`dateStr`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_login_log
-- ----------------------------
DROP TABLE IF EXISTS `tbl_login_log`;
CREATE TABLE `tbl_login_log` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT,
  `uId` int(10) DEFAULT NULL COMMENT '用户id',
  `loginTime` datetime DEFAULT NULL COMMENT '登录时间',
  `ip` varchar(255) DEFAULT NULL COMMENT '访问ip地址',
  `timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_task_date
-- ----------------------------
DROP TABLE IF EXISTS `tbl_task_date`;
CREATE TABLE `tbl_task_date` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(255) DEFAULT NULL,
  `timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='定时任务的时间';

-- ----------------------------
-- Table structure for tbl_task_errorlog
-- ----------------------------
DROP TABLE IF EXISTS `tbl_task_errorlog`;
CREATE TABLE `tbl_task_errorlog` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `info` varchar(2048) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_template
-- ----------------------------
DROP TABLE IF EXISTS `tbl_template`;
CREATE TABLE `tbl_template` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `templateName` varchar(255) DEFAULT '' COMMENT '模板名称',
  `href` varchar(512) DEFAULT NULL,
  `imgUrl` varchar(1024) DEFAULT NULL,
  `alarmId` varchar(218) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `userId` int(12) DEFAULT NULL COMMENT '关联tbl_user表主键id',
  `createUser` varchar(255) DEFAULT NULL COMMENT '创建者',
  `pid` int(12) DEFAULT NULL,
  `status` int(2) DEFAULT '0' COMMENT '状态（0未删除,1删除）',
  `timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=213 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键UID',
  `phone` varchar(255) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(1024) DEFAULT NULL COMMENT '用户密码(密文）',
  `userType` int(1) DEFAULT '0' COMMENT '用户类型（0为管理员 1未超级管理员）',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `lastLoginTime` datetime DEFAULT NULL COMMENT '最新登录时间',
  `status` int(2) DEFAULT '0' COMMENT '是否删除（0 未删除 1已删除）',
  `timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `userName` (`userName`) USING BTREE,
  UNIQUE KEY `phone` (`phone`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for tbl_audio
-- ----------------------------
DROP TABLE IF EXISTS `tbl_audio`;
CREATE TABLE `tbl_audio` (
  `id` INT(12) NOT NULL AUTO_INCREMENT,
  `musicName` VARCHAR(255) DEFAULT NULL COMMENT '音乐描述',
  `musicPath` VARCHAR(1024) DEFAULT NULL COMMENT '音乐路径',
  `alarmEn` VARCHAR(255) DEFAULT NULL COMMENT '报警英文名',
  `alarmName` VARCHAR(255) DEFAULT NULL COMMENT '报警中文名',
  `timestamp` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `alarmEn` (`alarmEn`) USING BTREE
) ENGINE=INNODB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
