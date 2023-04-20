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

 Date: 18/04/2023 08:59:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for md_cus
-- ----------------------------
DROP TABLE IF EXISTS `md_cus`;
CREATE TABLE `md_cus`  (
  `id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '主键',
  `create_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人名称',
  `create_by` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人登录名称',
  `create_date` datetime NULL DEFAULT NULL COMMENT '创建日期',
  `update_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '更新人名称',
  `update_by` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '更新人登录名称',
  `update_date` datetime NULL DEFAULT NULL COMMENT '更新日期',
  `sys_org_code` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '所属部门',
  `sys_company_code` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '所属公司',
  `zhong_wen_qch` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '中文全称',
  `zhu_ji_ma` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '助记码',
  `ke_hu_jian_cheng` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '客户简称',
  `ke_hu_bian_ma` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '客户编码',
  `ke_hu_ying_wen` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '客户英文名称',
  `zeng_yong_qi` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '曾用企业代码',
  `zeng_yong_qi_ye` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '曾用企业名称',
  `ke_hu_zhuang_tai` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '客户状态',
  `xing_ye_fen_lei` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '企业属性',
  `ke_hu_deng_ji` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '客户等级',
  `suo_shu_xing_ye` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '所属行业',
  `shou_qian_ri_qi` datetime NULL DEFAULT NULL COMMENT '首签日期',
  `zhong_zhi_he_shi_jian` datetime NULL DEFAULT NULL COMMENT '终止合作时间',
  `shen_qing_shi_jian` datetime NULL DEFAULT NULL COMMENT '申请时间',
  `ke_hu_shu_xing` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '客户属性',
  `gui_shu_zu_zh` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '归属组织代码',
  `gui_shu_sheng` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '归属省份代码',
  `gui_shu_shi_dai` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '归属市代码',
  `gui_shu` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '归属县区代码',
  `di_zhi` varchar(132) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '地址',
  `you_zheng_bian_ma` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '邮政编码',
  `zhu_lian_xi_ren` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '主联系人',
  `dian_hua` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '电话',
  `shou_ji` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '手机',
  `chuan_zhen` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '传真',
  `Emaildi_zhi` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT 'Email地址',
  `wang_ye_di_zhi` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '网页地址',
  `fa_ren_dai_biao` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '法人代表',
  `fa_ren_shen_fen` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '法人身份证号',
  `zhu_ce_zi_jin` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '注册资金万元',
  `bi_bie` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '币别',
  `ying_ye_zhi_zhao` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '营业执照号',
  `shui_wu_deng` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '税务登记证号',
  `zu_zhi_ji_gou` varchar(132) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '组织机构代码证',
  `dao_lu_yun_shu` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '道路运输经营许可证',
  `zhu_ying_ye_wu` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '主营业务',
  `he_yi_xiang` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '合作意向',
  `pi_zhun_ji_guan` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '批准机关',
  `pi_zhun_wen_hao` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '批准文号',
  `zhu_ce_ri_qi` datetime NULL DEFAULT NULL COMMENT '注册日期',
  `bei_zhu` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注',
  `zhu_lian_xi_ren1` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '联系人1',
  `dian_hua1` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '电话1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of md_cus
-- ----------------------------
INSERT INTO `md_cus` VALUES ('297e363f7deb92cd017deba50cd70003', '管理员', 'admin', '2021-12-24 16:53:22', NULL, NULL, NULL, 'A05', 'A05', '1', '1', NULL, 'A01', NULL, NULL, NULL, '10', '01', NULL, NULL, NULL, NULL, NULL, '10', NULL, NULL, NULL, NULL, '', NULL, '', '', '', NULL, '', NULL, NULL, NULL, NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '', '', '');
INSERT INTO `md_cus` VALUES ('4028804072de5db4017393807ede00e1', '测试', 'test', '2020-07-28 11:38:59', NULL, NULL, NULL, 'A05', 'A05', '北京同仁堂', '', NULL, '001122', NULL, NULL, NULL, '20', '', NULL, NULL, NULL, NULL, NULL, '10', NULL, NULL, NULL, NULL, '北京', NULL, 'ABC', '', '11111111111', NULL, '', NULL, NULL, NULL, NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '', '', '');
INSERT INTO `md_cus` VALUES ('4028804072de5db40174a91f5fbe015b', '测试', 'test', '2020-09-20 09:27:20', '管理员', 'admin', '2020-09-20 09:37:53', 'A05', 'A05', '北京01', '001', NULL, 'BJ01', NULL, NULL, NULL, '10', '01', NULL, NULL, NULL, NULL, NULL, '20', NULL, NULL, NULL, NULL, '北京', NULL, '', '', '', NULL, '', NULL, NULL, NULL, NULL, NULL, '001', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '', '', '');
INSERT INTO `md_cus` VALUES ('4028804072de5db40174a958a6f40189', '管理员', 'admin', '2020-09-20 10:29:54', '管理员', 'admin', '2020-09-20 16:00:47', 'A05', 'A05', '内蒙古额里图食品有限公司', 'NMELT01', NULL, 'NMELT', NULL, NULL, NULL, '20', '01', NULL, NULL, NULL, NULL, NULL, '20', NULL, NULL, NULL, NULL, '内蒙古锡林郭勒盟正镶白旗额里图农场', NULL, '汪涛', '', '15149165566', NULL, '', NULL, NULL, NULL, NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '', '', '');
INSERT INTO `md_cus` VALUES ('402882f17917a3b4017917a8259d0003', '管理员', 'admin', '2021-04-28 16:46:06', NULL, NULL, NULL, 'A05', 'A05', '中储粮', '', NULL, '001', NULL, NULL, NULL, '10', '01', NULL, NULL, NULL, NULL, NULL, '10', NULL, NULL, NULL, NULL, '', NULL, '', '', '', NULL, '', NULL, NULL, NULL, NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '', '', '');
INSERT INTO `md_cus` VALUES ('402882f17917a3b401791b277b7a0021', '管理员', 'admin', '2021-04-29 09:04:03', NULL, NULL, NULL, 'A05', 'A05', '芜湖众力', '', NULL, '8AR', NULL, NULL, NULL, '10', '01', NULL, NULL, NULL, NULL, NULL, '10', NULL, NULL, NULL, NULL, '', NULL, '', '', '', NULL, '', NULL, NULL, NULL, NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '', '', '');
INSERT INTO `md_cus` VALUES ('402883e2871d08f201871d2998920002', '管理员', 'admin', '2023-03-26 17:04:38', '管理员', 'admin', '2023-03-26 17:38:45', 'A05', 'A05', '天津理工大学计算机学院', '123456', NULL, '123456', NULL, NULL, NULL, '20', '01', NULL, NULL, NULL, NULL, NULL, '20', NULL, NULL, NULL, NULL, '天津市西青区宾水西道319号天津理工大学', NULL, '秦伟昊', '18503307601', '18503307601', NULL, '823995488@qq.com', NULL, NULL, NULL, NULL, NULL, 'Usie-088', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '天津理工大学客户', '1234567899', '1234567899');
INSERT INTO `md_cus` VALUES ('ff80808178f747c30178f74bdf7d0003', '管理员', 'admin', '2021-04-22 09:57:28', NULL, NULL, NULL, 'A05', 'A05', '商米', '', NULL, '0001', NULL, NULL, NULL, '10', '01', NULL, NULL, NULL, NULL, NULL, '10', NULL, NULL, NULL, NULL, '', NULL, '', '', '', NULL, '', NULL, NULL, NULL, NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '', '', '');

SET FOREIGN_KEY_CHECKS = 1;
