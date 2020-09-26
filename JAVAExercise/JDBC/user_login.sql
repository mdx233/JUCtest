drop table if exists t_user;

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   id                   bigint auto_increment,
   loginName            varchar(255),
   loginPwd             varchar(255),
   realName             varchar(255),
   primary key (id)
);

INSERT INTO t_user(loginName,loginPwd,realName) VALUES('zhangsan','123','张三');
INSERT INTO t_user(loginName,loginPwd,realName) VALUES('jack','123','杰克');
commit;
SELECT * FROM t_user;