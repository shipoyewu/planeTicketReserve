/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : planeticketreserve

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-06-18 09:53:40
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of agency
-- ----------------------------

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
  `id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKparticipat877580` (`travellerid`),
  KEY `FKparticipat730716` (`teamid`),
  CONSTRAINT `FKparticipat730716` FOREIGN KEY (`teamid`) REFERENCES `team` (`id`),
  CONSTRAINT `FKparticipat877580` FOREIGN KEY (`travellerid`) REFERENCES `traveller` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of participate
-- ----------------------------

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
  `name` varchar(25) DEFAULT NULL,
  `starttime` timestamp NULL DEFAULT NULL,
  `endtime` timestamp NULL DEFAULT NULL,
  `type` int(10) DEFAULT NULL,
  `status` int(10) DEFAULT '0',
  `agencyid` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKteam537233` (`agencyid`),
  CONSTRAINT `FKteam537233` FOREIGN KEY (`agencyid`) REFERENCES `agency` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of team
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of traveller
-- ----------------------------
