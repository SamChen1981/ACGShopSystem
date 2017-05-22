/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost
 Source Database       : acg_db

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : utf-8

 Date: 05/21/2017 14:27:33 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `goods_description_table`
-- ----------------------------
DROP TABLE IF EXISTS `goods_description_table`;
CREATE TABLE `goods_description_table` (
  `id`                INT(11)                 NOT NULL AUTO_INCREMENT,
  `good_id`           INT(11)                 NOT NULL,
  `price`             VARCHAR(255)
                      COLLATE utf8_unicode_ci NOT NULL,
  `promotion_start`   DATETIME                         DEFAULT NULL
  COMMENT '促销开始时间，如果为空，责没有促销',
  `promotion_end`     DATETIME                         DEFAULT NULL
  COMMENT '促销结束时间，如果时间小于现在，促销结束',
  `other_description` VARCHAR(255)
                      COLLATE utf8_unicode_ci          DEFAULT NULL
  COMMENT '其他的描述，比如促销要说什么',
  `buy_type`          VARCHAR(255)
                      COLLATE utf8_unicode_ci          DEFAULT NULL,
  `buy_version`       VARCHAR(255)
                      COLLATE utf8_unicode_ci          DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `goods_description_table_good_id_uindex` (`good_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;

-- ----------------------------
--  Table structure for `goods_table`
-- ----------------------------
DROP TABLE IF EXISTS `goods_table`;
CREATE TABLE `goods_table` (
  `id`               INT(11)                 NOT NULL AUTO_INCREMENT,
  `good_name`        VARCHAR(255)
                     COLLATE utf8_unicode_ci NOT NULL,
  `good_id`          INT(11)                 NOT NULL,
  `good_description` VARCHAR(255)
                     COLLATE utf8_unicode_ci NOT NULL,
  `good_pic`         VARCHAR(255)
                     COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 17
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;

SET FOREIGN_KEY_CHECKS = 1;
