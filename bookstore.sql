/*
Navicat MySQL Data Transfer

Source Server         : jsp
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : bookstore

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-06-05 15:43:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bookid` int(11) NOT NULL AUTO_INCREMENT COMMENT '图书编号',
  `catalogid` int(11) NOT NULL COMMENT '分类编号',
  `bookname` varchar(20) NOT NULL COMMENT '图书名称',
  `price` int(11) NOT NULL COMMENT '价格',
  `picture` varchar(30) NOT NULL COMMENT '图片',
  PRIMARY KEY (`bookid`),
  KEY `FK_Relationship_3` (`catalogid`),
  CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`catalogid`) REFERENCES `catalog` (`catalogid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '4', 'ASP.NET 3.5', '38', 'ASP.NET3.5.jpg');
INSERT INTO `book` VALUES ('2', '1', 'C#', '43', 'CSharp.jpg');
INSERT INTO `book` VALUES ('3', '1', 'C', '36', 'C.jpg');
INSERT INTO `book` VALUES ('4', '1', 'C++', '40', 'C++.jpg');
INSERT INTO `book` VALUES ('5', '4', 'Flex 4', '45', 'Flex4.jpg');
INSERT INTO `book` VALUES ('6', '2', 'Java EE基础', '35', 'JavaEEBasic.jpg');
INSERT INTO `book` VALUES ('7', '2', 'Java EE', '39', 'JavaEE.jpg');
INSERT INTO `book` VALUES ('8', '2', 'Java', '50', 'Java.jpg');
INSERT INTO `book` VALUES ('9', '4', 'JSP', '30', 'JSP.jpg');
INSERT INTO `book` VALUES ('10', '3', 'MySQL', '37', 'MySQL.jpg');
INSERT INTO `book` VALUES ('11', '3', 'Oracle', '29', 'Oracle.jpg');
INSERT INTO `book` VALUES ('12', '4', 'PHP', '35', 'PHP.jpg');
INSERT INTO `book` VALUES ('13', '3', 'SQL Server', '25', 'SQL Server.jpg');
INSERT INTO `book` VALUES ('14', '1', 'Visual C++', '25', 'VC++.jpg');
INSERT INTO `book` VALUES ('15', '5', '共产党宣言', '18', 'gcd.jpg');
INSERT INTO `book` VALUES ('16', '5', '资本论', '98', 'capital.jpg');
INSERT INTO `book` VALUES ('17', '5', '习近平重要讲话', '10', 'X.jpg');
INSERT INTO `book` VALUES ('18', '5', '中国即将崩溃', '36', 'col.jpg');
INSERT INTO `book` VALUES ('19', '6', '吉米多维奇', '49', 'jimi.jpg');
INSERT INTO `book` VALUES ('20', '6', '菲赫金哥尔茨', '68', 'cal.jpg');

-- ----------------------------
-- Table structure for catalog
-- ----------------------------
DROP TABLE IF EXISTS `catalog`;
CREATE TABLE `catalog` (
  `catalogid` int(11) NOT NULL AUTO_INCREMENT,
  `catalogname` varchar(20) NOT NULL,
  PRIMARY KEY (`catalogid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of catalog
-- ----------------------------
INSERT INTO `catalog` VALUES ('1', 'C语言程序设计');
INSERT INTO `catalog` VALUES ('2', 'Java开发');
INSERT INTO `catalog` VALUES ('3', '数据库');
INSERT INTO `catalog` VALUES ('4', '网页编程');
INSERT INTO `catalog` VALUES ('5', '政治觉悟');
INSERT INTO `catalog` VALUES ('6', '娱乐休闲');

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `orderitemid` int(11) NOT NULL AUTO_INCREMENT,
  `bookid` int(11) NOT NULL,
  `orderid` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`orderitemid`),
  KEY `FK_Relationship_2` (`orderid`),
  KEY `FK_Relationship_4` (`bookid`),
  CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`orderid`) REFERENCES `orders` (`orderid`),
  CONSTRAINT `FK_Relationship_4` FOREIGN KEY (`bookid`) REFERENCES `book` (`bookid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderitem
-- ----------------------------

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `orderdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`orderid`),
  KEY `FK_Relationship_1` (`userid`),
  CONSTRAINT `FK_Relationship_1` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '1', '2017-06-05 15:35:46');
INSERT INTO `orders` VALUES ('2', '2', '2017-06-05 15:38:28');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'panyang', '111111', 'male', '20');
INSERT INTO `user` VALUES ('2', 'laowang', '233333', 'male', '23');
