/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : microservice_springcloud

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 26/11/2019 14:50:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '书籍id',
  `name` varchar(60) NOT NULL DEFAULT '' COMMENT '书名',
  `author` varchar(60) NOT NULL COMMENT '作者',
  `publication_date` varchar(8) DEFAULT NULL COMMENT '出版时间',
  `introduction` varchar(255) DEFAULT NULL COMMENT '内容简介',
  `data_source` varchar(20) DEFAULT NULL COMMENT '数据来源',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of books
-- ----------------------------
BEGIN;
INSERT INTO `books` VALUES (1, '水浒传', '施耐庵', '元末明初', '中国四大名著之一，是一部以北宋末年宋江起义为主要故事背景、类型上属于英雄传奇的章回体长篇小说。', 'db-8001');
INSERT INTO `books` VALUES (2, '三国演义', '罗贯中', '元末明初', '《三国演义》全名为《三国志通俗演义》（又称《三国志演义》），中国四大名著之一，是元末明初的小说家罗贯中创作的长篇章回体历史演义小说。', 'db-8001');
INSERT INTO `books` VALUES (3, '西游记', '吴承恩', '明代', '《西游记》是中国古代第一部浪漫主义章回体长篇神魔小说。现存明刊百回本《西游记》均无作者署名。清代学者吴玉搢等首先提出《西游记》作者是明代吴承恩。这部小说以“唐僧取经”这一历史事件为蓝本，通过作者的艺术加工，深刻地描绘了当时的社会现实。', 'db-8001');
INSERT INTO `books` VALUES (4, '红楼梦 ', '曹雪芹', '清代', '《红楼梦》，中国古代章回体长篇小说，又名《石头记》等，被列为中国古典四大名著之首，一般认为是清代作家曹雪芹所著。小说以贾、史、王、薛四大家族的兴衰为背景，以富贵公子贾宝玉为视角，描绘了一批举止见识出于须眉之上的闺阁佳人的人生百态，展现了真正的人性美和悲剧美，可以说是一部从各个角度展现女性美以及中国古代社会世态百相的史诗性著作。', 'db-8001');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
