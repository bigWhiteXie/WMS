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

 Date: 11/04/2023 20:31:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_s_role
-- ----------------------------
DROP TABLE IF EXISTS `t_s_role`;
CREATE TABLE `t_s_role`  (
  `ID` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT 'ID',
  `rolecode` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '角色编码',
  `rolename` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '角色名字',
  `update_name` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_date` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `update_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改人id',
  `create_name` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_date` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_s_role
-- ----------------------------
INSERT INTO `t_s_role` VALUES ('2c9221a4717bb44c01717ce20ca00411', 'cs', '测试', NULL, NULL, NULL, '初始', '2020-04-15 16:08:41', 'admin');
INSERT INTO `t_s_role` VALUES ('2c9221a4717bb44c01717ced1eb70425', 'ckjl', '仓库经理', '初始', '2020-04-15 16:22:26', 'admin', NULL, NULL, NULL);
INSERT INTO `t_s_role` VALUES ('2c9221a4717bb44c01717cf9cc2a04e6', 'cg', '仓管', '初始', '2020-04-15 16:37:26', 'admin', NULL, NULL, NULL);
INSERT INTO `t_s_role` VALUES ('4028804072de5db40172df63e359001d', 'KH', '客户', NULL, NULL, NULL, '管理员', '2020-06-23 12:16:05', 'admin');
INSERT INTO `t_s_role` VALUES ('8a8ab0b246dc81120146dc8181870050', 'gly', '管理员', '初始', '2020-04-15 16:33:39', 'admin', NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
