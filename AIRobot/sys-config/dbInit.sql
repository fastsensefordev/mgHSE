/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : robot

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2019-07-27 11:36:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_admin_key
-- ----------------------------
DROP TABLE IF EXISTS `tbl_admin_key`;
CREATE TABLE `tbl_admin_key` (
  `adminKey` varchar(255) DEFAULT NULL COMMENT '找回超级密码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_admin_key
-- ----------------------------
INSERT INTO `tbl_admin_key` VALUES ('admin123');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_login_log
-- ----------------------------

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('1', '18602902331', 'jiayaobo', 'BKHNYBX1zcqx93U7FiPG4Q==', '0', '2019-07-20 15:21:12', '2019-07-20 15:21:19', '0', '2019-07-27 10:55:26');
INSERT INTO `tbl_user` VALUES ('2', '15102123215', 'admin', 'admin', '1', '2019-07-20 15:21:14', '2019-07-20 15:21:21', '0', '2019-07-21 09:44:08');
INSERT INTO `tbl_user` VALUES ('3', '18602902321', 'woaini91', '4J3rvGnJyBZgR6IQAGsphA==', '0', '2019-07-21 14:09:03', null, '1', '2019-07-22 20:58:54');
INSERT INTO `tbl_user` VALUES ('4', '18729015211', 'woaini', 'BKHNYBX1zcqx93U7FiPG4Q==', '1', '2019-07-21 14:11:59', null, '1', '2019-07-21 14:19:03');
INSERT INTO `tbl_user` VALUES ('5', '18602902332', 'admin12', '0hcyJP/6yvVjGytYS754TA==', '1', '2019-07-21 14:25:26', null, '1', '2019-07-22 20:58:57');
INSERT INTO `tbl_user` VALUES ('6', '18602301235', 'admintest', 'EAPeipXwWUV2Sg7Sd0kFkg==', '1', '2019-07-21 14:30:11', null, '0', '2019-07-21 14:30:11');
INSERT INTO `tbl_user` VALUES ('7', '15102123214', 'test123', 'LNPRO2o/mOxmmPXQCMrNfQ==', '1', '2019-07-21 14:31:09', null, '0', '2019-07-21 14:31:09');
INSERT INTO `tbl_user` VALUES ('8', '15102123212', 'woaini432', 'nWiVscYiOwd/44yWlT9UCQ==', '1', '2019-07-21 14:31:29', null, '0', '2019-07-21 14:31:29');
INSERT INTO `tbl_user` VALUES ('9', '18602902329', 'adminewe', 'BKHNYBX1zcqx93U7FiPG4Q==', '0', '2019-07-21 14:32:09', null, '1', '2019-07-22 20:58:50');
INSERT INTO `tbl_user` VALUES ('10', '18602902326', 'dsddd', '0hcyJP/6yvVjGytYS754TA==', '1', '2019-07-21 14:32:38', null, '0', '2019-07-21 14:32:38');
INSERT INTO `tbl_user` VALUES ('11', '15421542135', 'sasadsds', 'TKtphEDvrS2od9TKv71vZg==', '1', '2019-07-21 14:33:30', null, '0', '2019-07-21 14:33:30');
INSERT INTO `tbl_user` VALUES ('12', '15421542134', 'jasonjia', 'BKHNYBX1zcqx93U7FiPG4Q==', '1', '2019-07-21 14:34:00', null, '0', '2019-07-27 11:32:30');
