CREATE DATABASE `vhr` DEFAULT CHARACTER SET utf8;

USE `repairHr`;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mg_staff
-- ----------------------------
DROP TABLE IF EXISTS `mg_staff`;
CREATE TABLE `mg_staff` (POSITION
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `jobId` INT(11) DEFAULT NULL COMMENT '工号',
  `roleId` INT(11) DEFAULT NULL COMMENT '角色ID',
  `deptId` INT(11) DEFAULT NULL COMMENT '部门ID',
  `faceId` INT(11) DEFAULT NULL COMMENT '算法服务器ID',
  `password` VARCHAR(255) DEFAULT NULL COMMENT '密码',
  `name` VARCHAR(32) DEFAULT NULL COMMENT '姓名',
  `position` LONGTEXT DEFAULT NULL COMMENT '职位',
  `phone` CHAR(11) DEFAULT NULL COMMENT '手机号码',
  `address` VARCHAR(64) DEFAULT NULL COMMENT '联系地址',
  `creatDate` DATE DEFAULT NULL COMMENT '创建日期',
  `updateDate` DATE DEFAULT NULL COMMENT '更新日期',
  `remark` VARCHAR(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mg_role
-- ----------------------------
DROP TABLE IF EXISTS `mg_role`;
CREATE TABLE `mg_role` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` INT(11) DEFAULT NULL COMMENT '角色名称',
  `nameEn` INT(11) DEFAULT NULL COMMENT '角色英文名',
  `creatDate` DATE DEFAULT NULL COMMENT '创建日期',
  `updateDate` DATE DEFAULT NULL COMMENT '更新日期',
  `remark` VARCHAR(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mg_structure
-- ----------------------------
DROP TABLE IF EXISTS `mg_structure`;
CREATE TABLE `mg_structure` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `pId` INT(11) DEFAULT NULL COMMENT '父级id',
  `deptName` INT(11) DEFAULT NULL COMMENT '部门名称',
  `creatDate` DATE DEFAULT NULL COMMENT '创建日期',
  `updateDate` DATE DEFAULT NULL COMMENT '更新日期',
  `remark` VARCHAR(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mg_admin_key
-- ----------------------------
DROP TABLE IF EXISTS `mg_admin_key`;
CREATE TABLE `mg_admin_key` (
  `adminKey` varchar(255) DEFAULT NULL COMMENT '找回超级密码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;