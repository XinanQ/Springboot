CREATE DATABASE db1;
USE db1;
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
    username VARCHAR(50) NOT NULL COMMENT '用户名',
    gender TINYINT(1) NOT NULL COMMENT '性别',
    age INT NOT NULL COMMENT '年龄',
    create_user VARCHAR(40) NOT NULL COMMENT '创建人标识',
    create_user_name VARCHAR(128) NOT NULL COMMENT '创建人姓名',
    create_time DATETIME NOT NULL COMMENT '创建时间',
    update_user VARCHAR(40) NOT NULL COMMENT '最后更新人标识',
    update_user_name VARCHAR(128) NOT NULL COMMENT '最后更新人姓名',
    update_time DATETIME NOT NULL COMMENT '最后更新时间',
    is_delete TINYINT(1) DEFAULT 0 NOT NULL COMMENT '删除标记：0未删除 1已删除'
);
