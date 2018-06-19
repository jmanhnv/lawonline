/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50637
 Source Host           : localhost:3306
 Source Schema         : lawonline

 Target Server Type    : MySQL
 Target Server Version : 50637
 File Encoding         : 65001

 Date: 18/06/2018 17:01:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- DATABASE
-- ----------------------------
DROP DATABASE IF EXISTS `lawonline`;
CREATE DATABASE lawonline;
USE lawonline;

-- ----------------------------
-- Table structure for judgment
-- ----------------------------
DROP TABLE IF EXISTS `judgment`;
CREATE TABLE `judgment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `content` longblob NOT NULL,
  `created_date` date DEFAULT NULL,
  `file_name` varchar(255) NOT NULL,
  `file_path` varchar(255) NOT NULL,
  `updated_date` date DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
