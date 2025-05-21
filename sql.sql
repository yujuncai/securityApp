DROP TABLE IF EXISTS `user`;

CREATE TABLE IF NOT EXISTS `user` (
  `user_id`         varchar(30)  NOT NULL COMMENT 'id',
  `password`        varchar(100) NOT NULL COMMENT '密码',
  `update_date`     timestamp    NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`)
);





INSERT INTO `user`(`user_id`, `password`) VALUES ('testUser', 'testPassword');