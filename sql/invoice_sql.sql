CREATE TABLE start.`invoice_user` (
  `id`              BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `company_name`    VARCHAR(100) NOT NULL DEFAULT ''
  COMMENT '公司名',
  `email`           VARCHAR(255) NOT NULL DEFAULT ''
  COMMENT '登录邮箱',
  `password`        VARCHAR(255) NOT NULL DEFAULT ''
  COMMENT '登录密码',
  `user_uuid`       VARCHAR(255) NOT NULL DEFAULT ''
  COMMENT '用户的唯一凭证,用于免登陆时使用',
  `create_time`     DATETIME     NOT NULL
  COMMENT '创建时间',
  `last_login_time` DATETIME     NOT NULL
  COMMENT '最后登录时间',
  `is_del`          INT(11)      NOT NULL DEFAULT '0'
  COMMENT '是否已删除,0:未删除,1已删除',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1453523211
  DEFAULT CHARSET = utf8mb4
  COMMENT = '用户表';


