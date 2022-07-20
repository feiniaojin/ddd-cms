CREATE DATABASE db_cms;

USE db_cms;

CREATE TABLE `cms_article` (
	`id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键',
	`article_id` varchar(64) NULL COMMENT 'article业务主键',
	`title` varchar(64) NULL COMMENT '标题',
	`article_state` int NOT NULL COMMent 'article状态',
	`deleted` tinyint NULL DEFAULT 0 COMMENT '逻辑删除标记[0-正常；1-已删除]',
	`created_by` VARCHAR(100) COMMENT '创建人',
	`created_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`modified_by` VARCHAR(100) COMMENT '更新人',
	`modified_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	`version` bigint DEFAULT 1 COMMENT '乐观锁',
	PRIMARY KEY (`id`),
	INDEX `idx_articleId`(`article_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE utf8mb4_bin COMMENT 'article主表';

CREATE TABLE `cms_article_content` (
	`id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键',
	`article_id` varchar(64) NULL COMMENT 'article业务主键',
	`content` text NOT NULL COMMENT '内容',
	`deleted` tinyint NULL DEFAULT 0 COMMENT '逻辑删除标记[0-正常；1-已删除]',
	`created_by` VARCHAR(100) COMMENT '创建人',
	`created_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`modified_by` VARCHAR(100) COMMENT '更新人',
	`modified_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	`version` bigint DEFAULT 1 COMMENT '乐观锁',
	PRIMARY KEY (`id`),
	INDEX `idx_articleId`(`article_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE utf8mb4_bin COMMENT 'article正文内容表';
