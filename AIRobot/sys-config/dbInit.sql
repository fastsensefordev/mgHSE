/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : robot

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2019-07-31 22:41:57
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
  `cameraId` varchar(512) DEFAULT NULL COMMENT '摄像头id',
  `location` varchar(512) DEFAULT NULL COMMENT '摄像头位置',
  `userId` int(12) DEFAULT NULL COMMENT '用户id',
  `createUser` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `pid` int(12) DEFAULT NULL,
  `status` int(2) DEFAULT '0' COMMENT '状态（0未删除,1删除）',
  `timestamp` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_address
-- ----------------------------
INSERT INTO `tbl_address` VALUES ('2', null, null, null, null, '1', 'jiayaobo', '2019-07-31 21:13:39', '0', '1', '2019-07-31 21:16:30');
INSERT INTO `tbl_address` VALUES ('3', null, null, null, null, '1', 'jiayaobo', '2019-07-31 21:13:56', '0', '1', '2019-07-31 21:16:34');
INSERT INTO `tbl_address` VALUES ('4', null, null, null, null, '1', 'jiayaobo', '2019-07-31 21:16:44', '0', '1', '2019-07-31 21:17:28');
INSERT INTO `tbl_address` VALUES ('5', '0', '10.185.27.164', null, null, '1', 'jiayaobo', '2019-07-31 21:17:40', '0', '1', '2019-07-31 21:25:00');
INSERT INTO `tbl_address` VALUES ('6', '0', 'http://10.187.2.113:8081/', null, null, '1', 'jiayaobo', '2019-07-31 21:24:56', '0', '0', null);
INSERT INTO `tbl_address` VALUES ('7', '0', 'http://10.187.2.113:8081/', null, null, '1', 'jiayaobo', '2019-07-31 21:25:03', '0', '0', null);
INSERT INTO `tbl_address` VALUES ('8', '0', 'http://10.187.2.113:8081/', null, null, '1', 'jiayaobo', '2019-07-31 21:25:05', '0', '0', null);
INSERT INTO `tbl_address` VALUES ('9', '0', 'http://10.187.2.113:8081/', null, null, '1', 'jiayaobo', '2019-07-31 21:25:07', '0', '0', null);
INSERT INTO `tbl_address` VALUES ('10', '1', 'https://www.baidu.com/', null, null, '1', 'jiayaobo', '2019-07-31 21:25:17', '0', '0', null);
INSERT INTO `tbl_address` VALUES ('11', '1', 'https://mvnrepository.com/', null, null, '1', 'jiayaobo', '2019-07-31 21:25:25', '0', '0', null);
INSERT INTO `tbl_address` VALUES ('12', null, null, '嫦娥1号', '(123.132,123.251)', '1', 'jiayaobo', '2019-07-31 21:40:17', '6', '0', '2019-07-31 21:41:18');
INSERT INTO `tbl_address` VALUES ('13', null, null, '嫦娥2号', '(123.132,123.251)', '1', 'jiayaobo', '2019-07-31 21:41:33', '6', '0', null);
INSERT INTO `tbl_address` VALUES ('14', null, null, '嫦娥3号', '(223.632,433.987)', '1', 'jiayaobo', '2019-07-31 21:41:53', '6', '0', null);
INSERT INTO `tbl_address` VALUES ('15', null, null, '天宫1号', '19231.124,125541.321', '1', 'jiayaobo', '2019-07-31 21:46:45', '7', '0', null);

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
-- Table structure for tbl_template
-- ----------------------------
DROP TABLE IF EXISTS `tbl_template`;
CREATE TABLE `tbl_template` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `templateName` varchar(255) DEFAULT '' COMMENT '模板名称',
  `href` varchar(512) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `userId` int(12) DEFAULT NULL COMMENT '关联tbl_user表主键id',
  `createUser` varchar(255) DEFAULT NULL COMMENT '创建者',
  `pid` int(12) DEFAULT NULL,
  `status` int(2) DEFAULT '0' COMMENT '状态（0未删除,1删除）',
  `timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_template
-- ----------------------------
INSERT INTO `tbl_template` VALUES ('18', '可视化001', 'dashboard?id=', '2019-07-28 11:26:29', '1', 'jiayaobo', '0', '1', '2019-07-29 21:51:06');
INSERT INTO `tbl_template` VALUES ('19', '可视化001未佩戴安全帽', 'safeChart?aId=1', '2019-07-28 11:26:29', '1', 'jiayaobo', '18', '1', '2019-07-29 21:51:06');
INSERT INTO `tbl_template` VALUES ('20', '可视化001行人非法闯入', 'illegalChart?aId=2', '2019-07-28 11:26:29', '1', 'jiayaobo', '18', '1', '2019-07-29 21:51:06');
INSERT INTO `tbl_template` VALUES ('21', '可视化001明火危险', 'dangerChart?aId=3', '2019-07-28 11:26:29', '1', 'jiayaobo', '18', '1', '2019-07-29 21:51:06');
INSERT INTO `tbl_template` VALUES ('22', '可视化001综合分析', 'totalChart?aId=4', '2019-07-28 11:26:29', '1', 'jiayaobo', '18', '1', '2019-07-29 21:51:06');
INSERT INTO `tbl_template` VALUES ('23', '模板11111', 'dashboard?id=', '2019-07-28 12:27:19', '1', 'jiayaobo', '0', '1', '2019-07-29 21:52:58');
INSERT INTO `tbl_template` VALUES ('24', '模板11111未佩戴安全帽', 'safeChart?aId=1', '2019-07-28 12:27:19', '1', 'jiayaobo', '23', '1', '2019-07-29 21:52:58');
INSERT INTO `tbl_template` VALUES ('25', '模板11111行人非法闯入', 'illegalChart?aId=2', '2019-07-28 12:27:19', '1', 'jiayaobo', '23', '1', '2019-07-29 21:52:58');
INSERT INTO `tbl_template` VALUES ('26', '模板11111明火危险', 'dangerChart?aId=3', '2019-07-28 12:27:19', '1', 'jiayaobo', '23', '1', '2019-07-29 21:52:58');
INSERT INTO `tbl_template` VALUES ('27', '模板11111综合分析', 'totalChart?aId=4', '2019-07-28 12:27:19', '1', 'jiayaobo', '23', '1', '2019-07-29 21:52:58');
INSERT INTO `tbl_template` VALUES ('28', '贾耀博的模板', 'dashboard?id=', '2019-07-28 12:27:27', '1', 'jiayaobo', '0', '1', '2019-07-29 21:56:09');
INSERT INTO `tbl_template` VALUES ('29', '贾耀博的模板未佩戴安全帽', 'safeChart?aId=1', '2019-07-28 12:27:27', '1', 'jiayaobo', '28', '1', '2019-07-29 21:56:09');
INSERT INTO `tbl_template` VALUES ('30', '贾耀博的模板行人非法闯入', 'illegalChart?aId=2', '2019-07-28 12:27:27', '1', 'jiayaobo', '28', '1', '2019-07-29 21:56:09');
INSERT INTO `tbl_template` VALUES ('31', '贾耀博的模板明火危险', 'dangerChart?aId=3', '2019-07-28 12:27:27', '1', 'jiayaobo', '28', '1', '2019-07-29 21:56:09');
INSERT INTO `tbl_template` VALUES ('32', '贾耀博的模板综合分析', 'totalChart?aId=4', '2019-07-28 12:27:27', '1', 'jiayaobo', '28', '1', '2019-07-29 21:56:09');
INSERT INTO `tbl_template` VALUES ('33', '反倒是对我说', 'dashboard?id=', '2019-07-28 12:27:31', '1', 'jiayaobo', '0', '1', '2019-07-29 21:58:55');
INSERT INTO `tbl_template` VALUES ('34', '反倒是对我说未佩戴安全帽', 'safeChart?aId=1', '2019-07-28 12:27:31', '1', 'jiayaobo', '33', '1', '2019-07-29 21:58:55');
INSERT INTO `tbl_template` VALUES ('35', '反倒是对我说行人非法闯入', 'illegalChart?aId=2', '2019-07-28 12:27:31', '1', 'jiayaobo', '33', '1', '2019-07-29 21:58:55');
INSERT INTO `tbl_template` VALUES ('36', '反倒是对我说明火危险', 'dangerChart?aId=3', '2019-07-28 12:27:31', '1', 'jiayaobo', '33', '1', '2019-07-29 21:58:55');
INSERT INTO `tbl_template` VALUES ('37', '反倒是对我说综合分析', 'totalChart?aId=4', '2019-07-28 12:27:31', '1', 'jiayaobo', '33', '1', '2019-07-29 21:58:55');
INSERT INTO `tbl_template` VALUES ('38', '飒飒', 'dashboard?id=', '2019-07-29 22:00:26', '1', 'jiayaobo', '0', '1', '2019-07-29 22:00:56');
INSERT INTO `tbl_template` VALUES ('39', '飒飒未佩戴安全帽', 'safeChart?aId=1', '2019-07-29 22:00:26', '1', 'jiayaobo', '38', '1', '2019-07-29 22:00:56');
INSERT INTO `tbl_template` VALUES ('40', '飒飒行人非法闯入', 'illegalChart?aId=2', '2019-07-29 22:00:26', '1', 'jiayaobo', '38', '1', '2019-07-29 22:00:56');
INSERT INTO `tbl_template` VALUES ('41', '飒飒明火危险', 'dangerChart?aId=3', '2019-07-29 22:00:26', '1', 'jiayaobo', '38', '1', '2019-07-29 22:00:56');
INSERT INTO `tbl_template` VALUES ('42', '飒飒综合分析', 'totalChart?aId=4', '2019-07-29 22:00:26', '1', 'jiayaobo', '38', '1', '2019-07-29 22:00:56');
INSERT INTO `tbl_template` VALUES ('43', '颠三倒四多所', 'dashboard?id=', '2019-07-29 22:00:30', '1', 'jiayaobo', '0', '1', '2019-07-29 22:01:01');
INSERT INTO `tbl_template` VALUES ('44', '颠三倒四多所未佩戴安全帽', 'safeChart?aId=1', '2019-07-29 22:00:30', '1', 'jiayaobo', '43', '1', '2019-07-29 22:01:01');
INSERT INTO `tbl_template` VALUES ('45', '颠三倒四多所行人非法闯入', 'illegalChart?aId=2', '2019-07-29 22:00:30', '1', 'jiayaobo', '43', '1', '2019-07-29 22:01:01');
INSERT INTO `tbl_template` VALUES ('46', '颠三倒四多所明火危险', 'dangerChart?aId=3', '2019-07-29 22:00:30', '1', 'jiayaobo', '43', '1', '2019-07-29 22:01:01');
INSERT INTO `tbl_template` VALUES ('47', '颠三倒四多所综合分析', 'totalChart?aId=4', '2019-07-29 22:00:30', '1', 'jiayaobo', '43', '1', '2019-07-29 22:01:01');
INSERT INTO `tbl_template` VALUES ('48', '颠三倒四多', 'dashboard?id=', '2019-07-29 22:00:34', '1', 'jiayaobo', '0', '1', '2019-07-29 22:00:59');
INSERT INTO `tbl_template` VALUES ('49', '颠三倒四多未佩戴安全帽', 'safeChart?aId=1', '2019-07-29 22:00:34', '1', 'jiayaobo', '48', '1', '2019-07-29 22:00:59');
INSERT INTO `tbl_template` VALUES ('50', '颠三倒四多行人非法闯入', 'illegalChart?aId=2', '2019-07-29 22:00:34', '1', 'jiayaobo', '48', '1', '2019-07-29 22:00:59');
INSERT INTO `tbl_template` VALUES ('51', '颠三倒四多明火危险', 'dangerChart?aId=3', '2019-07-29 22:00:34', '1', 'jiayaobo', '48', '1', '2019-07-29 22:00:59');
INSERT INTO `tbl_template` VALUES ('52', '颠三倒四多综合分析', 'totalChart?aId=4', '2019-07-29 22:00:34', '1', 'jiayaobo', '48', '1', '2019-07-29 22:00:59');
INSERT INTO `tbl_template` VALUES ('53', '颠三倒四多', 'dashboard?id=', '2019-07-29 22:01:14', '1', 'jiayaobo', '0', '0', '2019-07-29 22:01:14');
INSERT INTO `tbl_template` VALUES ('54', '颠三倒四多未佩戴安全帽', 'safeChart?aId=1', '2019-07-29 22:01:14', '1', 'jiayaobo', '53', '0', '2019-07-29 22:01:14');
INSERT INTO `tbl_template` VALUES ('55', '颠三倒四多行人非法闯入', 'illegalChart?aId=2', '2019-07-29 22:01:14', '1', 'jiayaobo', '53', '0', '2019-07-29 22:01:14');
INSERT INTO `tbl_template` VALUES ('56', '颠三倒四多明火危险', 'dangerChart?aId=3', '2019-07-29 22:01:14', '1', 'jiayaobo', '53', '0', '2019-07-29 22:01:14');
INSERT INTO `tbl_template` VALUES ('57', '颠三倒四多综合分析', 'totalChart?aId=4', '2019-07-29 22:01:14', '1', 'jiayaobo', '53', '0', '2019-07-29 22:01:14');
INSERT INTO `tbl_template` VALUES ('58', '颠三倒四多', 'dashboard?id=', '2019-07-29 22:01:17', '1', 'jiayaobo', '0', '0', '2019-07-29 22:01:17');
INSERT INTO `tbl_template` VALUES ('59', '颠三倒四多未佩戴安全帽', 'safeChart?aId=1', '2019-07-29 22:01:17', '1', 'jiayaobo', '58', '0', '2019-07-29 22:01:17');
INSERT INTO `tbl_template` VALUES ('60', '颠三倒四多行人非法闯入', 'illegalChart?aId=2', '2019-07-29 22:01:17', '1', 'jiayaobo', '58', '0', '2019-07-29 22:01:17');
INSERT INTO `tbl_template` VALUES ('61', '颠三倒四多明火危险', 'dangerChart?aId=3', '2019-07-29 22:01:17', '1', 'jiayaobo', '58', '0', '2019-07-29 22:01:17');
INSERT INTO `tbl_template` VALUES ('62', '颠三倒四多综合分析', 'totalChart?aId=4', '2019-07-29 22:01:17', '1', 'jiayaobo', '58', '0', '2019-07-29 22:01:17');
INSERT INTO `tbl_template` VALUES ('63', '发给对方的', 'dashboard?id=', '2019-07-29 22:01:20', '1', 'jiayaobo', '0', '0', '2019-07-29 22:01:20');
INSERT INTO `tbl_template` VALUES ('64', '发给对方的未佩戴安全帽', 'safeChart?aId=1', '2019-07-29 22:01:20', '1', 'jiayaobo', '63', '0', '2019-07-29 22:01:20');
INSERT INTO `tbl_template` VALUES ('65', '发给对方的行人非法闯入', 'illegalChart?aId=2', '2019-07-29 22:01:20', '1', 'jiayaobo', '63', '0', '2019-07-29 22:01:20');
INSERT INTO `tbl_template` VALUES ('66', '发给对方的明火危险', 'dangerChart?aId=3', '2019-07-29 22:01:20', '1', 'jiayaobo', '63', '0', '2019-07-29 22:01:20');
INSERT INTO `tbl_template` VALUES ('67', '发给对方的综合分析', 'totalChart?aId=4', '2019-07-29 22:01:20', '1', 'jiayaobo', '63', '0', '2019-07-29 22:01:20');
INSERT INTO `tbl_template` VALUES ('68', '颠三倒四多', 'dashboard?id=', '2019-07-29 22:01:23', '1', 'jiayaobo', '0', '0', '2019-07-29 22:01:23');
INSERT INTO `tbl_template` VALUES ('69', '颠三倒四多未佩戴安全帽', 'safeChart?aId=1', '2019-07-29 22:01:23', '1', 'jiayaobo', '68', '0', '2019-07-29 22:01:23');
INSERT INTO `tbl_template` VALUES ('70', '颠三倒四多行人非法闯入', 'illegalChart?aId=2', '2019-07-29 22:01:23', '1', 'jiayaobo', '68', '0', '2019-07-29 22:01:23');
INSERT INTO `tbl_template` VALUES ('71', '颠三倒四多明火危险', 'dangerChart?aId=3', '2019-07-29 22:01:23', '1', 'jiayaobo', '68', '0', '2019-07-29 22:01:23');
INSERT INTO `tbl_template` VALUES ('72', '颠三倒四多综合分析', 'totalChart?aId=4', '2019-07-29 22:01:23', '1', 'jiayaobo', '68', '0', '2019-07-29 22:01:23');
INSERT INTO `tbl_template` VALUES ('73', '风动旛动', 'dashboard?id=', '2019-07-29 22:01:25', '1', 'jiayaobo', '0', '0', '2019-07-29 22:01:25');
INSERT INTO `tbl_template` VALUES ('74', '风动旛动未佩戴安全帽', 'safeChart?aId=1', '2019-07-29 22:01:25', '1', 'jiayaobo', '73', '0', '2019-07-29 22:01:25');
INSERT INTO `tbl_template` VALUES ('75', '风动旛动行人非法闯入', 'illegalChart?aId=2', '2019-07-29 22:01:25', '1', 'jiayaobo', '73', '0', '2019-07-29 22:01:25');
INSERT INTO `tbl_template` VALUES ('76', '风动旛动明火危险', 'dangerChart?aId=3', '2019-07-29 22:01:25', '1', 'jiayaobo', '73', '0', '2019-07-29 22:01:25');
INSERT INTO `tbl_template` VALUES ('77', '风动旛动综合分析', 'totalChart?aId=4', '2019-07-29 22:01:25', '1', 'jiayaobo', '73', '0', '2019-07-29 22:01:25');
INSERT INTO `tbl_template` VALUES ('78', '颠三倒四', 'dashboard?id=', '2019-07-29 22:01:29', '1', 'jiayaobo', '0', '0', '2019-07-29 22:01:29');
INSERT INTO `tbl_template` VALUES ('79', '颠三倒四未佩戴安全帽', 'safeChart?aId=1', '2019-07-29 22:01:29', '1', 'jiayaobo', '78', '0', '2019-07-29 22:01:29');
INSERT INTO `tbl_template` VALUES ('80', '颠三倒四行人非法闯入', 'illegalChart?aId=2', '2019-07-29 22:01:29', '1', 'jiayaobo', '78', '0', '2019-07-29 22:01:29');
INSERT INTO `tbl_template` VALUES ('81', '颠三倒四明火危险', 'dangerChart?aId=3', '2019-07-29 22:01:29', '1', 'jiayaobo', '78', '0', '2019-07-29 22:01:29');
INSERT INTO `tbl_template` VALUES ('82', '颠三倒四综合分析', 'totalChart?aId=4', '2019-07-29 22:01:29', '1', 'jiayaobo', '78', '0', '2019-07-29 22:01:29');
INSERT INTO `tbl_template` VALUES ('83', '辅导费大多数', 'dashboard?id=', '2019-07-29 22:01:33', '1', 'jiayaobo', '0', '0', '2019-07-29 22:01:33');
INSERT INTO `tbl_template` VALUES ('84', '辅导费大多数未佩戴安全帽', 'safeChart?aId=1', '2019-07-29 22:01:33', '1', 'jiayaobo', '83', '0', '2019-07-29 22:01:33');
INSERT INTO `tbl_template` VALUES ('85', '辅导费大多数行人非法闯入', 'illegalChart?aId=2', '2019-07-29 22:01:33', '1', 'jiayaobo', '83', '0', '2019-07-29 22:01:33');
INSERT INTO `tbl_template` VALUES ('86', '辅导费大多数明火危险', 'dangerChart?aId=3', '2019-07-29 22:01:33', '1', 'jiayaobo', '83', '0', '2019-07-29 22:01:33');
INSERT INTO `tbl_template` VALUES ('87', '辅导费大多数综合分析', 'totalChart?aId=4', '2019-07-29 22:01:33', '1', 'jiayaobo', '83', '0', '2019-07-29 22:01:33');

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
