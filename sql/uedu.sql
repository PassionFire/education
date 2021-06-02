/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : uedu

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 02/06/2021 14:47:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `cid` int(0) NOT NULL AUTO_INCREMENT COMMENT '课程编号',
  `courseName` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名称',
  `descs` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程简介',
  `courseType` int(0) NULL DEFAULT NULL COMMENT '课程类型',
  `courseImage` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程图片地址',
  `courseVideo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程视频地址',
  `coursePrice` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `status` int(0) NULL DEFAULT NULL COMMENT '状态',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '上传时间',
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '课程表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (11, 'JavaWeb课程', '这个阶段杜老师可以', 1, '1622517685997.jpg', '1622518940071.mp4', 999.00, 1, '2021-06-01 17:29:15');
INSERT INTO `course` VALUES (12, 'mysql课程', '这门课程非常重要', 2, '1622517685997.jpg', '1622518940071.mp4', 1200.00, 1, '2021-01-29 23:21:05');
INSERT INTO `course` VALUES (13, 'html课程', '做网页最基本的语言', 3, '1622517685997.jpg', '1622518940071.mp4', 300.00, 2, '2021-01-29 23:23:08');
INSERT INTO `course` VALUES (14, 'oracle课程', '这个课程非常牛逼', 2, '66ac769b-e416-4efd-9a8e-fdde3e1622517685997.jpg', '1622518940071.mp4', 1600.00, 1, '2021-01-29 23:23:55');
INSERT INTO `course` VALUES (15, 'vue课程', '这个课程作者是叶倩如', 3, '1622517685997.jpg', '1622518940071.mp4', 1200.00, 0, '2021-02-05 02:55:39');
INSERT INTO `course` VALUES (16, 'js课程', '程序员的看家手段', 3, '1622517685997.jpg', '1622518940071.mp4', 666.00, 1, '2021-02-09 00:26:56');
INSERT INTO `course` VALUES (17, 'springboot课程', '天下第一框架', 1, '1622518903713.jpg', '1622518940071.mp4', 85.00, 0, '2021-06-01 11:42:32');
INSERT INTO `course` VALUES (18, 'springcloud课程', '很好看', 1, '1622519987687.jpg', '1622520024817.mp4', 95.00, 0, '2021-06-01 12:00:56');
INSERT INTO `course` VALUES (19, 'SSM框架课程', '不粗的书籍', 1, '1622526805029.jpg', '1622526834091.mp4', 75.00, 0, '2021-06-01 13:54:52');

-- ----------------------------
-- Table structure for course_user
-- ----------------------------
DROP TABLE IF EXISTS `course_user`;
CREATE TABLE `course_user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `cid` int(0) NULL DEFAULT NULL,
  `uid` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_user
-- ----------------------------
INSERT INTO `course_user` VALUES (6, 15, 14);
INSERT INTO `course_user` VALUES (7, 11, 2);
INSERT INTO `course_user` VALUES (8, 13, 5);
INSERT INTO `course_user` VALUES (9, 16, 4);
INSERT INTO `course_user` VALUES (19, 16, 5);
INSERT INTO `course_user` VALUES (20, 15, 6);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int(0) NOT NULL AUTO_INCREMENT COMMENT '学员编号',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `age` int(0) NULL DEFAULT NULL COMMENT '年龄',
  `sex` int(0) NULL DEFAULT NULL COMMENT '性别',
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `status` int(0) NULL DEFAULT NULL COMMENT '状态',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '注册时间',
  `role` int(0) NULL DEFAULT NULL COMMENT '角色',
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '张三', '18638938271', 32, 1, 'root', '123456', 1, '2020-12-04 16:30:23', 1, NULL);
INSERT INTO `user` VALUES (2, '李44', '13721432300', 30, 1, 'admin1', '123456', 1, '2020-12-21 18:14:23', 2, NULL);
INSERT INTO `user` VALUES (4, '赵6', '13838384384', 19, 1, '赵六6', '123321', 2, '2021-05-31 11:35:53', 3, NULL);
INSERT INTO `user` VALUES (5, '哈哈', '199', 20, 0, 'admin1', '1234', 1, '2020-12-22 09:35:04', 3, NULL);
INSERT INTO `user` VALUES (6, '张6', '13721432300', 20, 0, 'admin2', '123456', 1, '2021-02-09 00:23:40', 3, NULL);
INSERT INTO `user` VALUES (10, 'pgone', '13721432300', 18, 1, 'pgone123', '123456', 1, '2021-02-09 00:23:56', 3, NULL);
INSERT INTO `user` VALUES (13, '孙悟空', '13721432300', 0, 0, 'sunwukong', '123456', 1, '2020-10-18 00:00:00', 2, NULL);
INSERT INTO `user` VALUES (14, '杜易墨', '18839788165', 99, 1, 'dym', '123456', 1, '2021-02-09 00:22:22', 2, NULL);
INSERT INTO `user` VALUES (17, '张三1', '13611112222', 20, 0, 'zs1', '123456', 2, '2021-06-01 13:51:16', 3, NULL);

SET FOREIGN_KEY_CHECKS = 1;
