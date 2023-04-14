/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80031
 Source Host           : localhost:3306
 Source Schema         : wms

 Target Server Type    : MySQL
 Target Server Version : 80031
 File Encoding         : 65001

 Date: 12/04/2023 16:20:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_s_user_org
-- ----------------------------
DROP TABLE IF EXISTS `t_s_user_org`;
CREATE TABLE `t_s_user_org`  (
  `ID` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT 'id',
  `user_id` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `org_id` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '部门id',
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `index_user_id`(`user_id` ASC) USING BTREE,
  INDEX `index_org_id`(`org_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_s_user_org
-- ----------------------------
INSERT INTO `t_s_user_org` VALUES ('2c9221a4715dbbff017173299b6b01cd', '8a8ab0b246dc81120146dc8181a10054', '2c9221a470adc6fc0170ecef9dd4029e');
INSERT INTO `t_s_user_org` VALUES ('2c9221a4715dbbff01717329cc4e01d0', '4028ef81563ae5be01563ae92d7f0002', '2c9221a470adc6fc0170ecef9dd4029e');
INSERT INTO `t_s_user_org` VALUES ('2c9221a4715dbbff01717334dc2a01d6', '402881875988e889015988ec36770001', '2c9221a470adc6fc0170ecef9dd4029e');
INSERT INTO `t_s_user_org` VALUES ('2c9221a4717bb44c01717d01c70c0541', '2c9221a4717bb44c01717d01c6ff0540', '2c9221a470adc6fc0170ecef9dd4029e');
INSERT INTO `t_s_user_org` VALUES ('4028804072de5db40172e01178830058', '4028804072de5db40172e011787a0057', '2c9221a470adc6fc0170ecef9dd4029e');
INSERT INTO `t_s_user_org` VALUES ('4028804072de5db40172e1a606e30066', '4028804072de5db40172e1a606e30065', '2c9221a470adc6fc0170ecef9dd4029e');
INSERT INTO `t_s_user_org` VALUES ('4028804072de5db40172e40d45f50075', '4028804072de5db40172e40d45930074', '2c9221a470adc6fc0170ecef9dd4029e');
INSERT INTO `t_s_user_org` VALUES ('4028804072de5db40172ff898d24008d', '4028804072de5db40172ff898d1a008c', '2c9221a470adc6fc0170ecef9dd4029e');
INSERT INTO `t_s_user_org` VALUES ('4028804072de5db40174a91fe41d015e', '4028804072de5db40174a91fe409015d', '2c9221a470adc6fc0170ecef9dd4029e');

SET FOREIGN_KEY_CHECKS = 1;
