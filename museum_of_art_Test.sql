/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : 120.79.147.88:8001
 Source Schema         : museum_of_art_Test

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 04/09/2018 14:46:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '编号',
  `login_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登入名',
  `hashed_pwd` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐',
  `bank_account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行卡号',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES (1, '123', '', NULL, NULL, NULL, NULL);
INSERT INTO `administrator` VALUES (153472876677770, '12345', '11d73870b2640dfd39e62d4591d93785', '2501474635528820', NULL, '2018-08-20 09:32:47', NULL);
INSERT INTO `administrator` VALUES (229318083603607552, 'hello', 'bd47e7d55ac79b208100a7e9a4dddb96', '9554872496876116', NULL, '2018-08-21 16:29:17', NULL);

-- ----------------------------
-- Table structure for bid
-- ----------------------------
DROP TABLE IF EXISTS `bid`;
CREATE TABLE `bid`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `project_id` bigint(20) UNSIGNED NOT NULL COMMENT '项目id',
  `works_id` bigint(20) UNSIGNED NOT NULL COMMENT '作品id',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '投标表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for business
-- ----------------------------
DROP TABLE IF EXISTS `business`;
CREATE TABLE `business`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `hashed_pwd` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐',
  `avatar` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `business_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业名称',
  `representation_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合法代表人姓名',
  `representation_idcard` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合法代表人身份证号码',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `tel` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `introduction` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简介',
  `login_time` datetime(0) NULL DEFAULT NULL COMMENT '最近登入时间',
  `is_verified` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否通过审核',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `follower_count` int(11) NULL DEFAULT NULL COMMENT '粉丝人数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 230376196209524737 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '企业信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of business
-- ----------------------------
INSERT INTO `business` VALUES (153154865467993, 'ae228cf62d3c75c9b68f530eb7c5868f', '153154865467961', NULL, '11', '22', '612722196901031613', 'll837448792@163.com', '15229061830', '123456', '2018-07-14 06:10:55', 1, '2018-07-14 06:10:55', '2018-07-14 06:10:55', 1);
INSERT INTO `business` VALUES (153441576383963, 'a14bd06f4ea4afcb7e36e95f8ff4129b', '9684590420532200', NULL, NULL, NULL, NULL, '999999999@qq.com', NULL, NULL, NULL, 0, '2018-08-16 18:36:04', NULL, NULL);
INSERT INTO `business` VALUES (230376196209524736, '1e0af49cf1533f7477b45f100c2f0ce2', '1399766981001880', NULL, '啦啦啦1', '布吉岛呀1', '1111111', 'mlhapril1028@gmail.com', '131313131', NULL, NULL, 0, '2018-08-24 14:33:51', '2018-08-24 14:33:51', NULL);

-- ----------------------------
-- Table structure for business_attachment
-- ----------------------------
DROP TABLE IF EXISTS `business_attachment`;
CREATE TABLE `business_attachment`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `attachment_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附件名称',
  `attachment_path` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附件路径',
  `attachment_size` decimal(10, 0) NULL DEFAULT NULL COMMENT '附件大小',
  `business_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '企业id',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `attachment_type` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附件类型（0为工商管理登记证，1为项目文件）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 229634729652674561 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '企业附件' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of business_attachment
-- ----------------------------
INSERT INTO `business_attachment` VALUES (153154865467416, '20180714061044337849.jpg', '/home/dev/businessLicenseImg/20180714061044337849.jpg', 275376, 153154865467993, '2018-07-14 06:10:55', '2018-07-14 06:10:55', NULL);
INSERT INTO `business_attachment` VALUES (153155039153337, '20180714063940212016.png', '/home/dev/businessLicenseImg/20180714063940212016.png', 20677, 153155039153439, '2018-07-14 06:39:52', '2018-07-14 06:39:52', NULL);
INSERT INTO `business_attachment` VALUES (153155039867532, '20180714063946329759.png', '/home/dev/businessLicenseImg/20180714063946329759.png', 20677, 153155039867553, '2018-07-14 06:39:59', '2018-07-14 06:39:59', NULL);
INSERT INTO `business_attachment` VALUES (229275391666839552, 'p2454610755.jpg', 'http://localhost:8080/upload-dirp2454610755.jpg', 168669, NULL, '2018-08-21 13:39:39', '2018-08-21 13:39:39', '0');
INSERT INTO `business_attachment` VALUES (229275959357497344, 'rick_and_morty_3.jpg', 'http://localhost:8080/upload-dirrick_and_morty_3.jpg', 73831, NULL, '2018-08-21 13:41:54', '2018-08-21 13:41:54', '0');
INSERT INTO `business_attachment` VALUES (229634247152525312, 'rick_and_morty_3.jpg', 'http://localhost:8080/upload-dirrick_and_morty_3.jpg', 73831, NULL, '2018-08-22 13:25:37', '2018-08-22 13:25:37', '0');
INSERT INTO `business_attachment` VALUES (229634729652674560, 'rick_and_morty_3.jpg', 'http://localhost:8080/upload-dirrick_and_morty_3.jpg', 73831, 229604732078276608, '2018-08-22 13:27:32', '2018-08-22 13:27:32', '0');

-- ----------------------------
-- Table structure for complaint_attachment
-- ----------------------------
DROP TABLE IF EXISTS `complaint_attachment`;
CREATE TABLE `complaint_attachment`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `attachment_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附件名称',
  `attachment_path` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附件路径',
  `attachment_size` decimal(10, 0) NULL DEFAULT NULL COMMENT '附件大小',
  `complaint_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '申诉id',
  `complaint_type` tinyint(3) UNSIGNED NULL DEFAULT NULL COMMENT '申诉的类型(订单：0 or项目：1 or作品：2)',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '申诉附件' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for email_activation
-- ----------------------------
DROP TABLE IF EXISTS `email_activation`;
CREATE TABLE `email_activation`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '编号',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `state` tinyint(3) NOT NULL DEFAULT 0 COMMENT '激活状态',
  `token` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '激活令牌',
  `token_expried_time` datetime(0) NULL DEFAULT NULL COMMENT '令牌过期时间',
  `gmt_registered` datetime(0) NULL DEFAULT NULL COMMENT '注册时间',
  `gmt_activated` datetime(0) NULL DEFAULT NULL COMMENT '激活时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '邮箱验证表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of email_activation
-- ----------------------------
INSERT INTO `email_activation` VALUES (153154864492577, 'll837448792@163.com', 0, '606618e00f59d4899dfae0b5ddb6e2d6', '2018-07-14 06:11:45', '2018-07-14 06:10:45', NULL);
INSERT INTO `email_activation` VALUES (153155038168326, 'honeysyt@foxmail.com', 1, '9afa131d29b05924320fc21459860aab', '2018-07-14 06:40:42', '2018-07-14 06:39:42', '2018-07-14 06:40:16');
INSERT INTO `email_activation` VALUES (153155039073744, 'honeysyt@foxmail.com', 0, 'be323aed780243a13d8d41163df497ef', '2018-07-14 06:40:51', '2018-07-14 06:39:51', NULL);

-- ----------------------------
-- Table structure for favorite_project
-- ----------------------------
DROP TABLE IF EXISTS `favorite_project`;
CREATE TABLE `favorite_project`  (
  `project_id` bigint(20) UNSIGNED NOT NULL COMMENT '项目id',
  `user_id` bigint(20) UNSIGNED NOT NULL COMMENT '用户id',
  `is_deleted` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否喜欢',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '收藏项目' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for favorite_works
-- ----------------------------
DROP TABLE IF EXISTS `favorite_works`;
CREATE TABLE `favorite_works`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `works_id` bigint(20) UNSIGNED NOT NULL COMMENT '作品id',
  `user_id` bigint(20) UNSIGNED NOT NULL COMMENT '用户id',
  `is_deleted` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否喜欢',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '收藏作品' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_form
-- ----------------------------
DROP TABLE IF EXISTS `order_form`;
CREATE TABLE `order_form`  (
  `id` bigint(20) NOT NULL COMMENT '订单id',
  `status` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '状态',
  `project_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '项目id',
  `seller_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '卖家id',
  `works_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '作品id',
  `buyer_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '买家id',
  `price` decimal(10, 0) NULL DEFAULT NULL COMMENT '成交价格',
  `finish_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `comment` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '买家评论',
  `type` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '订单类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for orders_complaint
-- ----------------------------
DROP TABLE IF EXISTS `orders_complaint`;
CREATE TABLE `orders_complaint`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '订单申诉id',
  `order_id` bigint(20) NULL DEFAULT NULL COMMENT '订单id',
  `complaint_description` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申诉内容',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单申诉' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for private_message
-- ----------------------------
DROP TABLE IF EXISTS `private_message`;
CREATE TABLE `private_message`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `sender_id` bigint(20) NULL DEFAULT NULL COMMENT '发送者id',
  `receiver_id` bigint(20) NULL DEFAULT NULL COMMENT '接收者id',
  `message_type` tinyint(3) UNSIGNED NULL DEFAULT NULL COMMENT '信息类型',
  `message_content` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '信息内容',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '信息状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '私信表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT 'id',
  `business_id` bigint(20) NOT NULL COMMENT '企业id',
  `project_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目名称',
  `project_description` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目描述',
  `is_verified` tinyint(3) NOT NULL DEFAULT 0 COMMENT '项目状态',
  `budget` decimal(10, 0) NULL DEFAULT NULL COMMENT '预算',
  `tender_period` int(11) NULL DEFAULT NULL COMMENT '投标时间',
  `expected_time` int(11) NULL DEFAULT NULL COMMENT '预计完成时间',
  `finish_time` datetime(0) NULL DEFAULT NULL COMMENT '实际完成时间',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `skill` json NULL COMMENT '项目需要的技能',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '项目表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES (153035104572630, 153035104572763, '设计logo', 'lalalalla', 1, 1000, 15, 11212, '1970-01-01 08:00:07', '1970-01-01 08:00:07', '1970-01-01 08:00:07', '[1, 2, 3]');
INSERT INTO `project` VALUES (153035118157416, 153035118157470, '设计logo', 'lalalalla', 1, 1000, 15, 11212, '1970-01-01 08:00:07', '1970-01-01 08:00:07', '1970-01-01 08:00:07', '[1, 2, 3]');
INSERT INTO `project` VALUES (153035122219850, 153035122219843, '设计logo', 'lalalalla', 1, 1000, 15, 11212, '1970-01-01 08:00:07', '1970-01-01 08:00:07', '1970-01-01 08:00:07', '[1, 2, 3]');
INSERT INTO `project` VALUES (153035213630677, 153035213630671, '设计logo', 'lalalalla', 1, 1000, 15, 11212, '1970-01-01 08:00:07', '1970-01-01 08:00:07', '1970-01-01 08:00:07', '[1, 2, 3]');
INSERT INTO `project` VALUES (153035219377121, 153035219377212, 'ppp0000', '222', 1, 1000, 3344, 11212, '1970-01-01 08:00:07', '1970-01-01 08:00:07', '1970-01-01 08:00:07', '[3, 1, 2]');
INSERT INTO `project` VALUES (153035220200436, 153035220200461, 'ppp0000', '222', 1, 1000, 3344, 11212, '1970-01-01 08:00:07', '1970-01-01 08:00:07', '1970-01-01 08:00:07', '[4, 1, 2]');
INSERT INTO `project` VALUES (153041136102286, 153041136102332, '设计logo', 'lalalalla', 1, 1000, 15, 11212, '1970-01-01 08:00:07', '1970-01-01 08:00:07', '1970-01-01 08:00:07', '[1, 2, 3]');
INSERT INTO `project` VALUES (153041146472161, 153041146472264, '设计logo', 'lalalalla', 1, 1000, 15, 11212, '1970-01-01 08:00:07', '1970-01-01 08:00:07', '1970-01-01 08:00:07', '[1, 2, 3]');
INSERT INTO `project` VALUES (153041417950466, 153041417950494, '设计logo', 'lalalalla', 1, 1000, 15, 11212, '1970-01-01 08:00:07', '1970-01-01 08:00:07', '1970-01-01 08:00:07', '[1, 2, 3]');
INSERT INTO `project` VALUES (153060664829573, 153060664829585, '设计logo', 'lalalalla', 1, 1000, 15, 11212, '1970-01-01 08:00:07', '1970-01-01 08:00:07', '1970-01-01 08:00:07', '[1, 2, 3]');
INSERT INTO `project` VALUES (153060676852418, 153060676852462, '设计logo', 'lalalalla', 1, 1000, 15, 11212, '1970-01-01 08:00:07', '1970-01-01 08:00:07', '1970-01-01 08:00:07', '[1, 2, 3]');
INSERT INTO `project` VALUES (153060692049847, 153060692049854, '设计logo', 'lalalalla', 1, 1000, 15, 11212, '1970-01-01 08:00:07', '1970-01-01 08:00:07', '1970-01-01 08:00:07', '[1, 2, 3]');
INSERT INTO `project` VALUES (153060723788237, 153060723788212, '设计logo', 'lalalalla', 1, 1000, 15, 11212, '1970-01-01 08:00:07', '1970-01-01 08:00:07', '1970-01-01 08:00:07', '[1, 2, 3]');
INSERT INTO `project` VALUES (153063172071815, 153063172071817, '设计logo', 'lalalalla', 1, 1000, 15, 11212, '1970-01-01 08:00:07', '1970-01-01 08:00:07', '1970-01-01 08:00:07', '[1, 2, 3]');
INSERT INTO `project` VALUES (153063225701033, 153063225701094, '设计logo', 'lalalalla', 1, 1000, 15, 11212, '1970-01-01 08:00:07', '1970-01-01 08:00:07', '1970-01-01 08:00:07', '[1, 2, 3]');
INSERT INTO `project` VALUES (153079462177660, 153079462177677, '设计logo', 'lalalalla', 1, 1000, 15, 11212, '1970-01-01 08:00:07', '1970-01-01 08:00:07', '1970-01-01 08:00:07', '[1, 2, 3]');
INSERT INTO `project` VALUES (153079627590969, 153079627590957, '设计logo', 'lalalalla', 1, 1000, 15, 11212, '1970-01-01 08:00:07', '1970-01-01 08:00:07', '1970-01-01 08:00:07', '[1, 2, 3]');
INSERT INTO `project` VALUES (153079650109376, 153079650109443, '设计logo', 'lalalalla', 1, 1000, 15, 11212, '1970-01-01 08:00:07', '1970-01-01 08:00:07', '1970-01-01 08:00:07', '[1, 2, 3]');
INSERT INTO `project` VALUES (153079991492922, 153079991493215, 'ppp0000', '222', 1, 1000, 3344, 11212, '1970-01-01 08:00:07', '1970-01-01 08:00:07', '1970-01-01 08:00:07', '[3, 1, 2]');
INSERT INTO `project` VALUES (153080031719815, 153080031719911, '设计logo', 'lalalalla', 1, 1000, 15, 11212, '1970-01-01 08:00:07', '1970-01-01 08:00:07', '1970-01-01 08:00:07', '[1, 2, 3]');
INSERT INTO `project` VALUES (153080322445711, 153080322446124, 'ppp0000', '222', 1, 1000, 3344, 11212, '1970-01-01 08:00:07', '1970-01-01 08:00:07', '1970-01-01 08:00:07', '[3, 1, 2]');
INSERT INTO `project` VALUES (153088785658913, 153088785660485, '设计logo', 'lalalalla', 1, 1000, 15, 11212, '1970-01-01 08:00:07', '1970-01-01 08:00:07', '1970-01-01 08:00:07', '[1, 2, 3]');
INSERT INTO `project` VALUES (153104037045053, 153104037048836, '212', '3123', 1, 12, 12, 1, '1970-01-01 08:00:07', '1970-01-01 08:00:07', '1970-01-01 08:00:07', '[1]');
INSERT INTO `project` VALUES (153261258052842, 1111, 'logo', '布吉岛', 1, 1000, 15, 11212, NULL, '1970-01-01 08:00:07', '1970-01-01 08:00:07', '[2, 3]');

-- ----------------------------
-- Table structure for project_attachment
-- ----------------------------
DROP TABLE IF EXISTS `project_attachment`;
CREATE TABLE `project_attachment`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `attachment_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附件名称',
  `attachment_path` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附件路径',
  `attachment_size` decimal(10, 0) NULL DEFAULT NULL COMMENT '附件大小',
  `project_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '项目id',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 153104037047867 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '项目附件' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project_attachment
-- ----------------------------
INSERT INTO `project_attachment` VALUES (153104037047866, '20180708165930621280.jpg', 'D:\\tmp\\dev\\projectAttachmentImg\\20180708165930621280.jpg', 30747, 153104037045053, '2018-07-08 16:59:30', '2018-07-08 16:59:30');

-- ----------------------------
-- Table structure for project_complaint
-- ----------------------------
DROP TABLE IF EXISTS `project_complaint`;
CREATE TABLE `project_complaint`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `project_id` bigint(20) NULL DEFAULT NULL COMMENT '项目id',
  `complaint_description` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申诉内容',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '项目申诉' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `resource_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `resource_path` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单路径',
  `pid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单父节点id',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '资源表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES (1, 'student_test', '/student/test', '-1', NULL, NULL);
INSERT INTO `resource` VALUES (2, 'hello学生', '/student/test/hello', '1', NULL, NULL);
INSERT INTO `resource` VALUES (3, 'business_test', '/business/test', '-1', NULL, NULL);
INSERT INTO `resource` VALUES (4, 'hello_business', '/business/test/hello', '3', NULL, NULL);

-- ----------------------------
-- Table structure for resource_role
-- ----------------------------
DROP TABLE IF EXISTS `resource_role`;
CREATE TABLE `resource_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `resource_id` bigint(20) NOT NULL COMMENT '菜单id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色与资源关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resource_role
-- ----------------------------
INSERT INTO `resource_role` VALUES (1, 1, 1, NULL, NULL);
INSERT INTO `resource_role` VALUES (2, 2, 1, NULL, NULL);
INSERT INTO `resource_role` VALUES (3, 3, 2, NULL, NULL);
INSERT INTO `resource_role` VALUES (4, 4, 2, NULL, NULL);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'student', NULL, NULL);
INSERT INTO `role` VALUES (2, 'business', NULL, NULL);

-- ----------------------------
-- Table structure for skill
-- ----------------------------
DROP TABLE IF EXISTS `skill`;
CREATE TABLE `skill`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `skill_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '技能名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '技能表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of skill
-- ----------------------------
INSERT INTO `skill` VALUES (1, 'logo');
INSERT INTO `skill` VALUES (2, 'java');
INSERT INTO `skill` VALUES (3, 'vue');
INSERT INTO `skill` VALUES (4, 'php');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT 'id',
  `student_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生学号',
  `login_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登入名称(昵称)',
  `hashed_pwd` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐',
  `avatar` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `sex` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `bank_account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行卡号',
  `tel` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `introduction` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简介',
  `transaction_time` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '交易总次数',
  `break_time` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '毁约次数',
  `login_time` datetime(0) NULL DEFAULT NULL COMMENT '登入时间',
  `is_verified` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否是第一次登入',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `follower_count` int(11) NULL DEFAULT NULL COMMENT '粉丝总数',
  `skill` json NULL COMMENT '学生有的技能',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `email`(`email`, `student_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学生信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (153429264220257, '20162570', '最后一次尝试', '1c225592192dd35ab7d4fea39222e850', '5390381676399438', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '2018-08-15 08:24:02', NULL, NULL, NULL);
INSERT INTO `student` VALUES (153430451952524, '2016', '一次尝试', '6d0a75b21725161119cdc1bd309404af', '6572376078195830', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '2018-08-15 11:42:00', NULL, NULL, NULL);
INSERT INTO `student` VALUES (153432286010689, 'studentId=2018', '尝试', 'e35d818f2daba0f20a088972b7b0afaf', '9240987540405250', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '2018-08-15 16:47:40', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user_relation
-- ----------------------------
DROP TABLE IF EXISTS `user_relation`;
CREATE TABLE `user_relation`  (
  `follow_id` bigint(20) NOT NULL COMMENT '用户id',
  `relation` tinyint(4) NOT NULL DEFAULT 0 COMMENT '两个用户关系',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色与用户关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (22222, 153429264220257, 1, NULL, NULL);
INSERT INTO `user_role` VALUES (111111, 153432286010689, 2, NULL, NULL);
INSERT INTO `user_role` VALUES (364363, 153429264220257, 2, NULL, NULL);
INSERT INTO `user_role` VALUES (1212121, 153430451952524, 1, NULL, NULL);

-- ----------------------------
-- Table structure for works
-- ----------------------------
DROP TABLE IF EXISTS `works`;
CREATE TABLE `works`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT 'id',
  `student_id` bigint(20) NULL DEFAULT NULL COMMENT '学生id',
  `works_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作品名称',
  `works_describe` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作品描述',
  `works_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '作品状态',
  `price` decimal(10, 0) NULL DEFAULT NULL COMMENT '学生报价',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '作品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for works_attachment
-- ----------------------------
DROP TABLE IF EXISTS `works_attachment`;
CREATE TABLE `works_attachment`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `attachment_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附件名称',
  `attachment_path` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附件路径',
  `attachment_size` decimal(10, 0) NULL DEFAULT NULL COMMENT '附件大小',
  `works_id` bigint(20) NULL DEFAULT NULL COMMENT '作品id',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '作品附件' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for works_comment
-- ----------------------------
DROP TABLE IF EXISTS `works_comment`;
CREATE TABLE `works_comment`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `works_id` bigint(20) NULL DEFAULT NULL COMMENT '作品id',
  `user_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '评论的用户id',
  `comment` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作品评论',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '作品评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for works_complaint
-- ----------------------------
DROP TABLE IF EXISTS `works_complaint`;
CREATE TABLE `works_complaint`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `works_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '作品id',
  `complaint_description` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申诉描述',
  `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '作品申诉表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
