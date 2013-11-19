/*==============================================================*/
/* DBMS name:      MySQL 5.5                                                                 */
/* Created on:     2012/7/28 20:47:51                                                     */
/*==============================================================*/

/*==============================================================*/
/*
DataBase: UserDB
Author:		architect.bian
Description:	创建数据库
CreatedDate:	19:59 2012/7/28
ModifyDate:	19:59 2012/7/28
*/
/*==============================================================*/
/*
drop database if EXISTS `UserDB`;

CREATE DATABASE `UserDB`
    CHARACTER SET 'utf8'
    COLLATE 'utf8_general_ci';
use `UserDB`;*/
drop table if exists accountlog;

drop table if exists comments;

drop table if exists customgallery;

drop table if exists education;

drop table if exists events;

drop table if exists jiazu;

drop table if exists msgboard;

drop table if exists t_sacrifice;

drop table if exists user;

drop table if exists wishes;

drop table if exists zupumember;

drop table if exists articlemarks;

drop table if exists jiazumember;

drop table if exists flowers;
/*==============================================================*/
/* Table: accountlog                                           
账号的操作日志
 */
/*==============================================================*/
create table accountlog
(
   uid                  varchar(36) not null comment '唯一ID',
   useruid              varchar(36) not null comment '用户uid',
   doaction             varchar(255) comment '操作',
   usemoney             decimal(12,2),
   account              decimal(10,2) unsigned not null default 0.00 comment '账户余额',
   createtime           timestamp not null default '0000-00-00 00:00:00.000' comment '创建时间', 
   primary key (uid),
   UNIQUE KEY `uid` (`uid`)
);

/*==============================================================*/
/* Table: comments                                              */
/*==============================================================*/
create table comments
(
   uid                  varchar(36) not null comment '唯一ID',
   fromuid              varchar(36) not null comment '所评论文章的UID',
   useruid              varchar(36),
   comment              varchar(150) comment '评论',
   status               tinyint unsigned not null default 1 comment '激活状态',
   createtime           timestamp not null default '0000-00-00 00:00:00.000' comment '创建时间', 
   primary key (uid, fromuid),
   UNIQUE KEY `uid` (`uid`)
);

/*==============================================================*/
/* Table: customgallery                                         */
/*==============================================================*/
create table customgallery
(
   uid                  varchar(36) not null comment '唯一ID',
   groupuid             varchar(36) not null,
   useruid              varchar(36) not null comment '唯一ID',
   img                  varchar(255) not null comment '图片',
   littlethumb          varchar(255) not null comment '小缩略图',
   thumb                varchar(255) not null comment '缩略图',
   bigthumb             varchar(255) not null comment '大缩略图',
   original             varchar(255) not null comment '原图',
   title                varchar(255) not null comment '标题',
   `desc`               varchar(255) comment '描述',
   istop                tinyint(1) unsigned not null default 0 comment '是否置顶',
   clickcount           int(11) unsigned default 0 comment '点击数',
   sortorder            tinyint unsigned default 0 comment '排序值 由大到小',
   createtime           timestamp not null default '0000-00-00 00:00:00.000' comment '创建时间', 
   primary key (uid),
   UNIQUE KEY `uid` (`uid`)
);

/*==============================================================*/
/* Table: education                                             */
/*==============================================================*/
create table education
(
   oid                  int(11) unsigned not null auto_increment comment '自增主键',
   groupuid             varchar(36) not null,
   useruid              varchar(36) comment '用户唯一ID',
   type                 tinyint unsigned not null comment '类型',
   title                varchar(150) not null comment '标题',
   titleimg             varchar(255) default '0' comment '是否有标题图',
   author               varchar(100) comment '作者',
   content              text comment '内容',
   viewsday             int(11) unsigned not null default 0 comment '日访问数',
   isrecommend          tinyint(1) unsigned not null default 0 comment '是否推荐',
   ispublic             tinyint(1) unsigned not null default 1 comment '是否公开',
   clickcount           int(11) unsigned default 0 comment '点击数',
   status               tinyint(1) unsigned not null default 2 comment '状态(0:草稿,1:审核中,2:审核通过,3:回收站)',
   createtime           timestamp not null default '0000-00-00 00:00:00.000' comment '创建时间',
   updatetime           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '最后更新时间', 
   primary key (oid),
   UNIQUE KEY `oid` (`oid`)
);

/*==============================================================*/
/* Table: events                                                */
/*==============================================================*/
create table events
(
   uid                  varchar(36) not null comment '唯一ID',
   groupuid             varchar(36) not null comment '唯一ID',
   groupName            varchar(36) not null comment '家族名',
   groupImg             varchar(255) not null comment '家族logo',
   useruid              varchar(36) not null comment '唯一ID',
   userName             varchar(36) not null comment '用户名',
   type                 tinyint unsigned not null comment '类型',
   content              varchar(1000) not null comment '内容',
   img                  varchar(255) default '' comment '缩略图',
   bigimg               varchar(255) default '' comment '大图',
   rawimg               varchar(255) default '' comment '原图',
   commentcount         int(11) unsigned not null default 0 comment '评论数',
   isrecommend          tinyint(1) unsigned not null default 0 comment '是否推荐',
   ispublic             tinyint(1) unsigned not null default 1 comment '是否公开',
   status               tinyint(1) unsigned not null default 2 comment '状态(0:草稿,1:审核中,2:审核通过,3:回收站)',
   createtime           timestamp not null default '0000-00-00 00:00:00.000' comment '注册时间',
   updatetime           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '最后更新时间', 
   primary key (uid),
   UNIQUE KEY `uid` (`uid`)
);

/*==============================================================*/
/* Table: jiazu                                                 */
/*==============================================================*/
create table jiazu
(
   uid                  varchar(36) not null comment '唯一ID',
   owner                varchar(36) comment '族谱创建者uid',
   ownerid              varchar(255) comment '创建者id',
   name                 varchar(100) not null comment '族谱名称',
   headimg				varchar(255) comment '家族头像，小图50*50',
   logo                 varchar(255) comment '族徽',
   logooriginal         varchar(255) comment '族徽原图',
   brief                varchar(255) comment '族训',
   `desc`               varchar(2000) comment '渊源',
   logaction            varchar(255),
   status               tinyint unsigned not null default 1 comment '激活状态',
   createtime           timestamp not null default '0000-00-00 00:00:00.000' comment '创建时间',
   updatetime           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '最后更新时间', 
   primary key (uid),
   UNIQUE KEY `uid` (`uid`)
);

/*==============================================================*/
/* Table: jiazumember                                                 */
/*==============================================================*/
create table jiazumember
(
   uid                  varchar(36) not null comment '家族唯一ID',
   useruid              varchar(36) comment '用户唯一ID',
   type                 tinyint(1) unsigned not null default 0 comment '是否管理员,管理员类型',
   status               tinyint(1) unsigned not null default 1 comment '状态',
   createtime           timestamp not null default '0000-00-00 00:00:00.000' comment '创建时间',
   updatetime           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '最后更新时间', 
   primary key (uid,useruid)
);
/*==============================================================*/
/* Table: msgboard                                              */
/*==============================================================*/
create table msgboard
(
   uid                  varchar(36) not null comment '唯一ID',
   useruid              varchar(36) not null comment '用户唯一ID',
   useruidfrom          varchar(36) comment '唯一ID',
   title                varchar(150) not null comment '标题',
   msg                  varchar(255) not null comment '留言内容',
   type                 tinyint unsigned not null comment '类型',
   createtime           timestamp not null default '0000-00-00 00:00:00.000' comment '创建时间', 
   primary key (uid),
   UNIQUE KEY `uid` (`uid`)
);

/*==============================================================*/
/* Table: t_sacrifice                                           */
/*==============================================================*/
create table t_sacrifice
(
   uid                  varchar(36) not null comment '唯一ID',
   createtime           timestamp not null default '0000-00-00 00:00:00.000' comment '创建时间',
   updatetime           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '最后更新时间', 
   primary key (uid),
   UNIQUE KEY `uid` (`uid`)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   oid                  int(11) unsigned not null auto_increment,
   uid                  varchar(36) not null,
   groupuid             varchar(36) comment '默认家族uid',
   userid               varchar(255) not null,
   account              decimal(10,2) unsigned not null default 0.00 comment '账户余额',
   password             varchar(36) not null,
   name                 varchar(100),
   gender               tinyint(1) unsigned comment '性别',
   realname             varchar(100),
   birthday             date,
   email                varchar(255) comment 'Email',
   intro                varchar(255) comment '个人简介',
   thumb                varchar(255) comment '缩略图',
   avatar               varchar(255) comment '个人头像',
   original             varchar(255) comment '原图',
   signed               varchar(255) comment '个性签名',
   qq                   varchar(100) comment 'QQ',
   msn                  varchar(100) comment 'MSN',
   phone                varchar(50) comment '电话',
   mobile               varchar(50) comment '手机',
   salary               int(11) unsigned,
   status               tinyint unsigned not null default 1 comment '激活状态',
   resetpwd             varchar(10) comment '重置密码VALUE',
   logincount           int(11) unsigned not null default 0 comment '登录次数',
   educount             tinyint unsigned not null default 0 comment '最新教育',
   eventcount           tinyint unsigned not null default 0 comment '最新大事',
   groupcount           tinyint unsigned not null default 0 comment '家族成员',
   msgcount             tinyint unsigned not null default 0 comment '未读信息',
   errorlasttime        datetime comment '登录错误时间',
   errorcount           int(11) unsigned not null default 0 comment '登录错误次数',
   errorip              varchar(50) comment '登录错误IP',
   lastlogintime        datetime comment '最后登录时间',
   lastloginip          varchar(50) not null default '127.0.0.1' comment '最后登录IP',
   registerip           varchar(50) not null default '127.0.0.1' comment '注册IP',
   createtime           timestamp not null default '0000-00-00 00:00:00.000' comment '创建时间',
   updatetime           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '最后更新时间', 
   primary key (oid, uid),
   UNIQUE KEY `oid` (`oid`),
   UNIQUE KEY `uid` (`uid`),
   UNIQUE KEY `userid` (`userid`)
);

alter table user comment '用户表';

/*==============================================================*/
/* Table: wishes                                                */
/*==============================================================*/
create table wishes
(
   uid                  varchar(36) not null comment '唯一ID',
   groupuid             varchar(36) not null,
   groupname            varchar(36) comment '家族名称',
   useruid              varchar(36) comment '用户唯一ID',
   name                 varchar(100),
   wish                 varchar(300) comment '祝福',
   type                 tinyint(1) unsigned,
   createtime           timestamp not null default '0000-00-00 00:00:00.000' comment '创建时间', 
   primary key (uid),
   UNIQUE KEY `uid` (`uid`)
);

/*==============================================================*/
/* Table: zupumemeber                                           */
/*==============================================================*/
create table zupumember
(
   uid                  varchar(36) not null comment '唯一ID',
   groupuid             varchar(36) comment '家族Uid',
   useruid              varchar(36) comment '用户唯一ID',
   useruid2             varchar(36) comment '用户唯一ID',
   name                 varchar(100),
   name2                varchar(100),
   gender               tinyint(1) unsigned comment '男性',
   gender2              tinyint(1) unsigned comment '女性',
   realname             varchar(100),
   realname2            varchar(100),
   birthday             varchar(10),
   birthday2            varchar(10),
   dieday          	    varchar(10),
   dieday2              varchar(10),
   introduce            varchar(200) comment '生平',
   introduce2           varchar(200) comment '简介',
   avatar               varchar(100) comment '个人头像',
   avatar2              varchar(100) comment '个人头像',
   level                tinyint unsigned comment '层级从上到下',
   /*loveruid              varchar(36) comment '爱人的唯一ID对应本表的uid',*/
   parentuid            varchar(36) comment '父母Uid',
   /*isadmin              tinyint(1) unsigned not null default 0 comment '是否管理员',*/
   status               tinyint(1) unsigned not null default 1 comment '状态',
   status2              tinyint(1) unsigned not null default 1 comment '状态',
   createtime           timestamp not null default '0000-00-00 00:00:00.000' comment '创建时间', 
   primary key (uid,useruid)
);

/*==============================================================*/
/* Table: articlemarks                                                */
/*==============================================================*/
create table articlemarks
(
   uid                  varchar(36) not null comment '唯一ID',
   useruid              varchar(36) not null comment '用户唯一ID',
   articleuid           varchar(36) not null comment '对应的内容ID',
   note                 varchar(100) comment '备注',
   type                 tinyint(1) unsigned comment '类型：教育 大事记等等',
   marktype             tinyint(1) unsigned comment '标记类型：未读 已读',
   status               tinyint(1) unsigned not null default 1 comment '状态',
   createtime           timestamp not null default '0000-00-00 00:00:00.000' comment '创建时间', 
   updatetime           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '最后更新时间', 
   primary key (uid, useruid, articleuid),
   UNIQUE KEY `uid` (`uid`)
);

/*==============================================================*/
/* Table: flowers 祭品表                                                */
/*==============================================================*/
create table flowers
(
   uid                  varchar(36) not null comment '唯一ID',
   name                 varchar(36) not null comment '名称',
   thumb                varchar(255) not null comment '缩略图',
   img                  varchar(255) not null comment '图像',
   bigimg               varchar(255) comment '大图',
   original             varchar(255) not null comment '原图',
   price                decimal(10,2) unsigned not null comment '价格',
   free                 tinyint(1) not null default 0  comment '是否免费',
   duration             int(11) unsigned not null default 0 comment '持续时间',
   sortorder            smallint(5) unsigned not null default 0 comment '排序从大到小',
   status               tinyint(1) unsigned not null default 1 comment '状态',
   createtime           timestamp not null default '0000-00-00 00:00:00.000' comment '创建时间', 
   updatetime           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '最后更新时间', 
   primary key (uid),
   UNIQUE KEY `uid` (`uid`)
);