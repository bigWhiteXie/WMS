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

 Date: 11/04/2023 20:30:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_s_user
-- ----------------------------
DROP TABLE IF EXISTS `t_s_user`;
CREATE TABLE `t_s_user`  (
  `id` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT 'id',
  `email` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `mobilePhone` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `officePhone` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '办公座机',
  `signatureFile` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '签名文件',
  `update_name` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_date` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `update_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改人id',
  `create_name` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_date` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `user_type` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_2cuji5h6yorrxgsr8ojndlmal`(`id` ASC) USING BTREE,
  CONSTRAINT `t_s_user_ibfk_1` FOREIGN KEY (`id`) REFERENCES `t_s_base_user` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = 'InnoDB free: 599040 kB; (`id`) REFER `jeecg/t_s_base_user`(`' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_s_user
-- ----------------------------
INSERT INTO `t_s_user` VALUES ('2c9221a4717bb44c01717d01c6ff0540', '', '', '', NULL, '黄文平', '2020-04-16 15:58:44', 'hwp', '黄文平', '2020-04-15 16:43:21', 'hwp', '4');
INSERT INTO `t_s_user` VALUES ('4028804072de5db40172e011787a0057', '', '', '', NULL, '陈帝江', '2020-06-23 22:47:34', 'ADMIN_CDJ', '管理员', '2020-06-23 15:25:41', 'admin', '4');
INSERT INTO `t_s_user` VALUES ('4028804072de5db40172e1a606e30065', '', '', '', NULL, '管理员', '2020-06-24 09:59:35', 'admin', '陈帝江', '2020-06-23 22:47:34', 'ADMIN_CDJ', '1');
INSERT INTO `t_s_user` VALUES ('4028804072de5db40172e40d45930074', '', '', '', NULL, '管理员', '2020-06-28 14:38:00', 'admin', '管理员', '2020-06-24 09:59:35', 'admin', '4');
INSERT INTO `t_s_user` VALUES ('4028804072de5db40172ff898d1a008c', '', '', '', NULL, '测试', '2020-09-20 09:27:54', 'test', '管理员', '2020-06-29 18:05:04', 'admin', '4');
INSERT INTO `t_s_user` VALUES ('4028804072de5db40174a91fe409015d', '', '', '', NULL, NULL, NULL, NULL, '测试', '2020-09-20 09:27:54', 'test', '4');
INSERT INTO `t_s_user` VALUES ('402881875988e889015988ec36770001', '', '', '', NULL, '初始', '2020-04-13 19:02:56', 'admin', '管理员', '2017-01-10 23:08:18', 'admin', NULL);
INSERT INTO `t_s_user` VALUES ('4028ef81563ae5be01563ae92d7f0002', '', '', '', NULL, '初始', '2020-04-13 18:50:51', 'admin', '管理员', '2016-07-30 16:26:15', 'admin', NULL);
INSERT INTO `t_s_user` VALUES ('8a8ab0b246dc81120146dc8181a10054', '', '', '', NULL, '初始', '2020-04-13 18:50:39', 'admin', NULL, '2016-07-10 16:26:15', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
