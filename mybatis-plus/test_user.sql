create table test_user
(
  id               int auto_increment
  comment '主键'
    primary key,
  name             varchar(255) null
  comment '姓名',
  age              int          null
  comment '年龄',
  birthday         datetime     null
  comment '出生日期',
  last_update_time timestamp    null
  on update CURRENT_TIMESTAMP
  comment '最后修改时间'
)
  collate = utf8mb4_unicode_ci;

