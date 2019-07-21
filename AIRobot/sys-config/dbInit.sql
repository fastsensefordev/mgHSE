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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

CREATE TABLE `tbl_login_log` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT,
  `uId` int(10) DEFAULT NULL COMMENT '用户id',
  `loginTime` datetime DEFAULT NULL COMMENT '登录时间',
  `ip` varchar(255) DEFAULT NULL COMMENT '访问ip地址',
  `timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

