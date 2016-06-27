/*
Navicat MySQL Data Transfer

Source Server         : ex
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : planeticketreserve

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-06-27 10:40:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `agency`
-- ----------------------------
DROP TABLE IF EXISTS `agency`;
CREATE TABLE `agency` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `pwd` varchar(25) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `contacts` varchar(255) DEFAULT NULL,
  `phone` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq` (`phone`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of agency
-- ----------------------------
INSERT INTO `agency` VALUES ('2', '123456', 'snice', '河南省郑州市高新区科学大道', '硕硕', '13027711597');
INSERT INTO `agency` VALUES ('3', '123456', '旅游小助手', '郑州大学信息工程学院', '宗瓚', '13027711598');
INSERT INTO `agency` VALUES ('4', '123456', '郑州大学', '郑州大学', '骚胡', '13095746354');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `flight` varchar(25) DEFAULT NULL,
  `startpoint` varchar(25) DEFAULT NULL,
  `endpoint` varchar(25) DEFAULT NULL,
  `starttime` timestamp NULL DEFAULT NULL,
  `endtime` timestamp NULL DEFAULT NULL,
  `advancestatus` int(10) DEFAULT '0',
  `ticketstatus` int(10) DEFAULT '0',
  `tickettime` timestamp NULL DEFAULT NULL,
  `price` double DEFAULT NULL,
  `seat` int(10) DEFAULT NULL,
  `space` int(10) DEFAULT NULL,
  `travellerid` int(10) NOT NULL,
  `teamid` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `have` (`travellerid`),
  KEY `teamhave` (`teamid`),
  CONSTRAINT `have` FOREIGN KEY (`travellerid`) REFERENCES `traveller` (`id`),
  CONSTRAINT `teamhave` FOREIGN KEY (`teamid`) REFERENCES `team` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for `participate`
-- ----------------------------
DROP TABLE IF EXISTS `participate`;
CREATE TABLE `participate` (
  `travellerid` int(10) NOT NULL,
  `teamid` int(10) NOT NULL,
  `jointime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `id` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `FKparticipat877580` (`travellerid`),
  KEY `FKparticipat730716` (`teamid`),
  CONSTRAINT `FKparticipat730716` FOREIGN KEY (`teamid`) REFERENCES `team` (`id`),
  CONSTRAINT `FKparticipat877580` FOREIGN KEY (`travellerid`) REFERENCES `traveller` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of participate
-- ----------------------------
INSERT INTO `participate` VALUES ('1', '1', '2016-06-23 19:14:58', '1');
INSERT INTO `participate` VALUES ('2', '1', '2016-06-23 19:15:11', '2');
INSERT INTO `participate` VALUES ('3', '1', '2016-06-23 19:15:30', '4');
INSERT INTO `participate` VALUES ('4', '1', '2016-06-23 19:15:39', '5');

-- ----------------------------
-- Table structure for `route`
-- ----------------------------
DROP TABLE IF EXISTS `route`;
CREATE TABLE `route` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `startpoint` varchar(25) DEFAULT NULL,
  `endpoint` varchar(25) DEFAULT NULL,
  `ordernumber` int(10) DEFAULT NULL,
  `teamid` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKroute449476` (`teamid`),
  CONSTRAINT `FKroute449476` FOREIGN KEY (`teamid`) REFERENCES `team` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of route
-- ----------------------------

-- ----------------------------
-- Table structure for `team`
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL DEFAULT '',
  `starttime` timestamp NULL DEFAULT NULL,
  `endtime` timestamp NULL DEFAULT NULL,
  `type` int(10) DEFAULT NULL,
  `status` int(10) DEFAULT '0',
  `agencyid` int(10) NOT NULL,
  `principal` varchar(10) NOT NULL,
  `prinphone` varchar(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKteam537233` (`agencyid`),
  CONSTRAINT `FKteam537233` FOREIGN KEY (`agencyid`) REFERENCES `agency` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of team
-- ----------------------------
INSERT INTO `team` VALUES ('1', '郑大团', '2016-06-08 19:13:11', '2016-07-02 19:13:15', '1', '0', '2', '邢佳丽', '13029482746');
INSERT INTO `team` VALUES ('2', '软三毕业团', '2016-06-22 10:38:51', '2016-07-05 10:38:55', '2', '0', '3', '王健', '13984765342');

-- ----------------------------
-- Table structure for `traveller`
-- ----------------------------
DROP TABLE IF EXISTS `traveller`;
CREATE TABLE `traveller` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `sex` varchar(25) DEFAULT NULL,
  `name` varchar(25) DEFAULT NULL,
  `idcard` varchar(25) DEFAULT NULL,
  `phone` varchar(25) DEFAULT NULL,
  `agencyid` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtraveller928676` (`agencyid`),
  CONSTRAINT `FKtraveller928676` FOREIGN KEY (`agencyid`) REFERENCES `agency` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of traveller
-- ----------------------------
INSERT INTO `traveller` VALUES ('1', '男', '宗瓚', '370481199403120311F', '13791443377', '2');
INSERT INTO `traveller` VALUES ('2', '男', 'zanzong', '370481199403120314F', '13938276452', '2');
INSERT INTO `traveller` VALUES ('3', '女', '阿斯蒂芬', '370481199403120312F', '13027711870', '2');
INSERT INTO `traveller` VALUES ('4', '男', 'heheda', '37048119940312031XF', '13027765432', '2');
INSERT INTO `traveller` VALUES ('5', '男', 'zanzna', '370481199403120314F', '13027711652', '2');
INSERT INTO `traveller` VALUES ('6', '男', '石胡', '370481199403120310F', '13027766452', '2');
INSERT INTO `traveller` VALUES ('7', '男', '瓚哥哥', '370481199403120991F', '13027711465', '2');
INSERT INTO `traveller` VALUES ('14', '女', '徐芳华', '370481199403120387F', '13028574635', '2');
