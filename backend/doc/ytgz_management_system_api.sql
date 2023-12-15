DROP TABLE IF EXISTS `ytgz_user`;
CREATE TABLE `ytgz_user`  (
    `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `nick_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '用户名',
    `avatar` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT '用户头像图片',
    `gender` int(0) NULL DEFAULT 1 COMMENT '性别：1时是男性，值为2时是女性，值为0时是未知',
    `birthday` date NULL DEFAULT NULL COMMENT '生日',
    `mobile` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '手机号',
    `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '邮箱',
    `status` int(0) NOT NULL DEFAULT 0 COMMENT '0 可用, 1 禁用, 2 注销',
    `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户表' ROW_FORMAT = Dynamic;



DROP TABLE IF EXISTS `ytgz_user_account`;
CREATE TABLE  `ytgz_user_account` (
    `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `username` varchar(100) CHARACTER SET utf8 NOT NULL COMMENT '登录用户名',
    `password` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '登录密码',
    `user_id` bigint(0) NOT NULL COMMENT '用户外键',
    primary key (`id`) USING BTREE,
    FOREIGN KEY (`user_id`) REFERENCES ytgz_user(id)
)


