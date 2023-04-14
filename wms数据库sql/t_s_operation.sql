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

 Date: 12/04/2023 16:22:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_s_operation
-- ----------------------------
DROP TABLE IF EXISTS `t_s_operation`;
CREATE TABLE `t_s_operation`  (
  `ID` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT 'id',
  `operationcode` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '页面控件code',
  `operationicon` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '图标',
  `operationname` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '页面名字',
  `status` smallint NULL DEFAULT NULL COMMENT '状态',
  `functionid` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '菜单ID',
  `iconid` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '图标ID',
  `operationtype` smallint NULL DEFAULT NULL COMMENT '规则类型：1/禁用 0/隐藏',
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `FK_pceuy41wr2fjbcilyc7mk3m1f`(`functionid` ASC) USING BTREE,
  INDEX `FK_ny5de7922l39ta2pkhyspd5f`(`iconid` ASC) USING BTREE,
  CONSTRAINT `t_s_operation_ibfk_1` FOREIGN KEY (`iconid`) REFERENCES `t_s_icon` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_s_operation_ibfk_2` FOREIGN KEY (`functionid`) REFERENCES `t_s_function` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = 'InnoDB free: 599040 kB; (`iconid`) REFER `jeecg/t_s_icon`(`I' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_s_operation
-- ----------------------------
INSERT INTO `t_s_operation` VALUES ('2c9221a471e7ec49017207089d2611bb', 'delinqm', NULL, '删除', 0, '4028b8815e5272f8015e527538d80001', '8a8ab0b246dc81120146dc8180460000', 0);
INSERT INTO `t_s_operation` VALUES ('40288088481d019401481d30a0d1000f', 'add_phnoe', NULL, '手机号码录入', 0, '40288088481d019401481d2fcebf000d', '8a8ab0b246dc81120146dc8180460000', 1);
INSERT INTO `t_s_operation` VALUES ('402880f25a87b619015a8800be110008', 'hol_reson', NULL, '请假原因隐藏', 0, '4028ef815378741f01537879315e0009', '8a8ab0b246dc81120146dc8180460000', 0);
INSERT INTO `t_s_operation` VALUES ('402880f25a980e2a015a981e9e460008', 'leave_reason', NULL, '请假原因隐藏', 0, '402880f25a980e2a015a981dc8de0005', '8a8ab0b246dc81120146dc8180460000', 0);
INSERT INTO `t_s_operation` VALUES ('402880f25a9833f5015a9844ed14000f', '订单客户.订单号', NULL, '列表订单号隐藏', 0, '402880f25a9833f5015a9843218f000c', '8a8ab0b246dc81120146dc8180460000', 0);
INSERT INTO `t_s_operation` VALUES ('402880f25b182dcf015b183926370003', 'db_generate_form', NULL, '隐藏数据库导入表单', 0, '8a8ab0b246dc81120146dc818106002d', '8a8ab0b246dc81120146dc8180460000', 0);
INSERT INTO `t_s_operation` VALUES ('402880f25b182dcf015b1839762c0005', 'copyOnlineTable', NULL, '隐藏复制表单功能', 0, '8a8ab0b246dc81120146dc818106002d', '8a8ab0b246dc81120146dc8180460000', 0);
INSERT INTO `t_s_operation` VALUES ('402880f25b182dcf015b184c4885001b', 'sql_enhance', NULL, '隐藏SQL增强按钮', 0, '8a8ab0b246dc81120146dc818106002d', '8a8ab0b246dc81120146dc8180460000', 0);
INSERT INTO `t_s_operation` VALUES ('402880f25b182dcf015b1860f334002f', '#mail_id', NULL, '隐藏邮箱字段', 0, '4028f6815af5ca04015af5cbf9300001', '8a8ab0b246dc81120146dc8180460000', 0);
INSERT INTO `t_s_operation` VALUES ('402880f25b182dcf015b18632e970036', 'phone_code', NULL, '隐藏手机号字段', 0, '4028f6815af5ca04015af5cbf9300001', '8a8ab0b246dc81120146dc8180460000', 0);
INSERT INTO `t_s_operation` VALUES ('402880f25b182dcf015b187b464a004b', '#money_id', NULL, '禁用金额字段', 0, '4028f6815af5ca04015af5cbf9300001', '8a8ab0b246dc81120146dc8180460000', 1);
INSERT INTO `t_s_operation` VALUES ('402880f25b1d5a3a015b1d77ff6a0015', 'day_num', NULL, '禁用请假天数', 0, '402880f25b1d5a3a015b1d772c2b0013', '8a8ab0b246dc81120146dc8180460000', 1);
INSERT INTO `t_s_operation` VALUES ('402880f25b1d5a3a015b1d901da00028', 'hol_dept', NULL, '列表隐藏请假部门', 0, '402880e74d76e784014d76f5cc2e0014', '8a8ab0b246dc81120146dc8180460000', 0);
INSERT INTO `t_s_operation` VALUES ('402880f25b1d5a3a015b1d941094002e', '#import', NULL, '隐藏excel导入按钮', 0, '402880e74d76e784014d76f5cc2e0014', '8a8ab0b246dc81120146dc8180460000', 0);
INSERT INTO `t_s_operation` VALUES ('402880f25b1d5a3a015b1d97b13d0039', '#delete', NULL, '隐藏批量删除按钮', 0, '402880e74d76e784014d76f5cc2e0014', '8a8ab0b246dc81120146dc8180460000', 0);
INSERT INTO `t_s_operation` VALUES ('402880f25b1df029015b1e19a8890027', '#bohui', NULL, '隐藏按钮驳回', 0, '402880e74d76e784014d76f5cc2e0014', '8a8ab0b246dc81120146dc8180460000', 0);
INSERT INTO `t_s_operation` VALUES ('402880f25b1df029015b1e19e0d00029', '#pizhun', NULL, '隐藏按钮批准', 0, '402880e74d76e784014d76f5cc2e0014', '8a8ab0b246dc81120146dc8180460000', 0);
INSERT INTO `t_s_operation` VALUES ('402880f25b23a635015b23ab94b60006', 'order_date', NULL, '隐藏订单日期', 0, '402880f25b23a635015b23a992f10003', '8a8ab0b246dc81120146dc8180460000', 0);
INSERT INTO `t_s_operation` VALUES ('402880f25b23a635015b23ad152f000d', 'jform_order_customer.telphone', NULL, '隐藏客户手机号', 0, '402880f25b23a635015b23a992f10003', '8a8ab0b246dc81120146dc8180460000', 0);
INSERT INTO `t_s_operation` VALUES ('402881855ab8c48a015ab8c945a70008', 'contact_way', NULL, '联系方式隐藏', 0, '402880f25a980e2a015a981dc8de0005', '8a8ab0b246dc81120146dc8180460000', 0);
INSERT INTO `t_s_operation` VALUES ('402881855ab8c48a015ab8caa347000a', 'GO_RETURN_PRICE', NULL, '合同定金', 0, '402880f25a9833f5015a9843218f000c', '8a8ab0b246dc81120146dc8180460000', 0);
INSERT INTO `t_s_operation` VALUES ('402881855ab8c48a015ab8d331b1001e', 'content', NULL, '隐藏审批意见', 0, '402881855ab8c48a015ab8d1f96f001b', '8a8ab0b246dc81120146dc8180460000', 0);
INSERT INTO `t_s_operation` VALUES ('402881875b1a8040015b1a84fd800001', 'phone', NULL, '列表隐藏手机号', 0, '4028f6815af5e479015af5f08dc4001a', '8a8ab0b246dc81120146dc8180460000', 0);
INSERT INTO `t_s_operation` VALUES ('402881b265e2f9050165e2fb56fe0030', 'export', NULL, 'export', 0, '8a7ba3345e89c253015e9051b0cc0858', '8a8ab0b246dc81120146dc8180460000', 0);

SET FOREIGN_KEY_CHECKS = 1;
