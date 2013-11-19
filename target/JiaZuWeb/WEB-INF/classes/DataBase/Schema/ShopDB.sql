/*==============================================================*/
/* DBMS name:      MySQL 5.5                                                                 */
/* Created on:     2012/7/28 20:47:51                                                     */
/*==============================================================*/

/*==============================================================*/
/*
DataBase: ShopDB
Author:		architect.bian
Description:	创建数据库
CreatedDate:	19:59 2012/7/28
ModifyDate:	19:59 2012/7/28
*/
/*==============================================================*/
/*
drop database if EXISTS `ShopDB`;

CREATE DATABASE `ShopDB`
    CHARACTER SET 'utf8'
    COLLATE 'utf8_general_ci';

use `ShopDB`;
*/
drop table if exists admin;

drop table if exists adminrole;

drop table if exists b2c;

drop table if exists b2caddress;

drop table if exists b2ccart;

drop table if exists b2cgallery;

drop table if exists b2corder;

drop table if exists b2corderdetail;

drop table if exists b2corderlog;

drop table if exists c2c;

drop table if exists content;

drop table if exists region;
/*==============================================================*/
/* Table: admin                                                 */
/*==============================================================*/
create table admin
(
   uid                  varchar(36) not null comment '唯一ID',
   userid               varchar(60) not null,
   email                varchar(60) not null,
   password             varchar(32) not null,
   createtime           timestamp not null default '0000-00-00 00:00:00.000' comment '创建时间', 
   primary key (uid),
   UNIQUE KEY `uid` (`uid`),
   UNIQUE KEY `loginid` (`userid`)
);

/*==============================================================*/
/* Table: adminrole                                                 */
/*==============================================================*/
create table adminrole
(
   uid                  varchar(36) not null comment '唯一ID',
   userid               varchar(60) not null,
   authority            varchar(60) not null,
   primary key (uid),
   UNIQUE KEY `uid` (`uid`)
);

/*==============================================================*/
/* Table: b2c                                                   */
/*==============================================================*/
create table b2c
(
   uid                  varchar(36) not null comment '唯一ID',
   catuid               varchar(36) not null comment '类别uid',
   sn                   varchar(60) not null comment 'sn号',
   name                 varchar(100) not null comment '商品名称',
   number               INTEGER(11) unsigned not null default 0 comment '数量',
   weight               decimal(10,3) unsigned not null default 0.000 comment '重量',
   marketprice          decimal(10,2) unsigned not null default 0.00 comment '市场价或原价',
   shopprice            decimal(10,2) unsigned not null default 0.00 comment '会员价或现价',
   shippingfee          decimal(10,2) not null default 0.00 comment '快递费',
   keywords             varchar(255) comment '关键词',
   brief                varchar(255) not null comment '简短介绍',
   `desc`               text not null comment '商品描述',
   littlethumb          varchar(255) not null comment '小缩略图',
   thumb                varchar(255) not null comment '默认缩略图',
   rate                 decimal(10,2) default 0.0 comment '评分',
   sortorder            smallint(5) unsigned not null default 0 comment '排序从大到小',
   isonsale             tinyint(1) unsigned not null default 1 comment '是否上架销售',
   isbest               tinyint(1) unsigned not null default 0 comment '是否精品',
   isnew                tinyint(1) unsigned not null default 0 comment '是否最新',
   istop                tinyint(1) unsigned not null default 0 comment '是否置顶',
   ishot                tinyint(1) unsigned not null default 0 comment '是否最受欢迎',
   type                 tinyint unsigned not null default 0 comment '商品类型：书籍 软件等等',
   showtype             tinyint default -1 comment '显示类型，文本、图像',
   sellcount            smallint(5) unsigned not null default 0,
   buyercount           smallint(5) unsigned not null default 0,
   clickcount           int(11) unsigned not null default 0,
   createtime           timestamp not null default '0000-00-00 00:00:00.000' comment '创建时间',
   updatetime           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '最后更新时间', 
   primary key (uid),
   UNIQUE KEY `uid` (`uid`),
   UNIQUE KEY `sn` (`sn`)
);

/*==============================================================*/
/* Table: b2caddress                                            */
/*==============================================================*/
create table b2caddress
(
   uid                  varchar(36) not null comment '唯一ID',
   useruid              varchar(36) comment '用户唯一ID',
   consignee            varchar(60) not null comment '收货人',
   email                varchar(60) not null,
   province             varchar(30) not null default '',
   city                 varchar(30) not null default '',
   district             varchar(30) not null default '',
   address              varchar(120),
   zipcode              varchar(60),
   tel                  varchar(60),
   mobile               varchar(60),
   type                 tinyint(1) unsigned comment '是否为默认地址',
   createtime           timestamp not null default '0000-00-00 00:00:00.000' comment '创建时间',
   updatetime           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '最后更新时间', 
   primary key (uid),
   UNIQUE KEY `uid` (`uid`)
);

/*==============================================================*/
/* Table: b2ccart                                               */
/*==============================================================*/
create table b2ccart
(
   uid                  varchar(36) not null comment '唯一ID',
   useruid              varchar(36) comment '用户唯一ID',
   b2cuid               varchar(36) not null comment '商品唯一ID',
   number               smallint(5) unsigned not null default 0 comment '数量',
   createtime           timestamp not null default '0000-00-00 00:00:00.000' comment '创建时间',
   updatetime           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '最后更新时间', 
   primary key (uid),
   UNIQUE KEY `uid` (`uid`)
);

/*==============================================================*/
/* Table: b2cgallery                                            */
/*==============================================================*/
create table b2cgallery
(
   uid                  varchar(36) not null comment '唯一ID',
   goodsuid             varchar(36) not null comment '商品uid',
   img                  varchar(255) not null comment '图片',
   thumb                varchar(255) not null comment '缩略图',
   bigimg               varchar(255) not null comment '大图片',
   original             varchar(255) not null comment '原图',
   title                varchar(255) not null comment '标题',
   isdefault            tinyint(1) unsigned comment '是否默认',
   sortorder            tinyint unsigned default 0 comment '排序值 由大到小',
   createtime           timestamp not null default '0000-00-00 00:00:00.000' comment '创建时间', 
   primary key (uid),
   UNIQUE KEY `uid` (`uid`)
);

/*==============================================================*/
/* Table: b2corder                                              */
/*==============================================================*/
create table b2corder
(
   uid                  varchar(36) not null comment '唯一ID',
   useruid              varchar(36) comment '用户唯一ID',
   userid               varchar(36) comment '用户ID',
   username             varchar(36) comment '用户姓名',
   ordersn              varchar(60) not null,
   totalamount          smallint(5) unsigned not null comment '总量',
   unitprice            decimal(10,2) unsigned not null,
   minusprice           decimal(10,2) default 0,
   totalprice           decimal(10,2) unsigned not null,
   shippingid           varchar(60) not null default 0 comment '快递号',
   postscript           varchar(255) not null comment '快递备注',
   shippingfee          decimal(10,2) unsigned not null default 0.00 comment '快递费',
   shipping_name        varchar(120) not null comment '快递名称',
   consignee            varchar(60) not null comment '收件人',
   province             varchar(30) not null default '',
   city                 varchar(30) not null default '',
   district             varchar(30) not null default '',
   address              varchar(255) not null,
   zipcode              varchar(60) not null,
   tel                  varchar(60) not null,
   mobile               varchar(60),
   email                varchar(60) not null,
   memo                 varchar(255)  comment '商品备注',
   orderstatus          tinyint(1) not null default 0  comment '订单状态',
   shippingstatus       tinyint(1) not null default 0  comment '快递状态',
   paystatus            tinyint(1) not null default 0  comment '支付状态',
   payid                varchar(60) not null default 0  comment '支付ID',
   payname              varchar(100) not null  comment '支付人',
   exprdate             date comment '期望送达时间',
   createtime           timestamp not null default '0000-00-00 00:00:00.000' comment '创建时间',
   updatetime           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '最后更新时间', 
   primary key (uid),
   UNIQUE KEY `uid` (`uid`)
);

/*==============================================================*/
/* Table: b2corderlog                                           */
/*==============================================================*/
create table b2corderdetail
(
   uid                  varchar(36) not null comment '唯一ID',
   b2cuid               varchar(36) not null comment '商品uid',
   b2csn                varchar(36) not null comment '商品sn',
   b2cname              varchar(36) not null comment '商品名称',
   b2clittlethumb       varchar(255) not null comment '商品小缩略图',
   b2cthumb             varchar(255) not null comment '商品缩略图',
   num                  smallint(5) unsigned not null comment '数量',
   createtime           timestamp not null default '0000-00-00 00:00:00.000' comment '创建时间',
   updatetime           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '最后更新时间', 
   primary key (uid, b2cuid)
);

/*==============================================================*/
/* Table: b2corderlog                                           */
/*==============================================================*/
create table b2corderlog
(
   oid                  int(11) unsigned not null auto_increment comment '自增主键',
   useruid              varchar(36) comment '用户唯一ID',
   orderuid             varchar(36) not null comment '订单uid',
   doaction             varchar(255) comment '操作',
   logtype              tinyint(1) unsigned not null,
   createtime           timestamp not null default '0000-00-00 00:00:00.000' comment '创建时间',
   updatetime           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '最后更新时间', 
   primary key (oid),
   UNIQUE KEY `oid` (`oid`)
);

/*==============================================================*/
/* Table: c2c                                                   */
/*==============================================================*/
create table c2c
(
   uid                  varchar(36) not null comment '唯一ID',
   groupuid             varchar(36) comment '家族唯一ID',
   useruid              varchar(36) comment '用户唯一ID',
   sn                   varchar(60) comment 'sn号',
   name                 varchar(100) not null comment '商品名称',
   number               smallint(5) unsigned not null default 0 comment '数量',
   price                decimal(12,2),
   `desc`               text not null comment '商品描述',
   contactname          varchar(30) not null comment '联系人姓名',
   telephone            varchar(30) not null comment '手机',
   qq                   varchar(30),
   address              varchar(255),
   littlethumb          varchar(255) comment '小缩略图',
   thumb                varchar(255) comment '默认缩略图',
   bigthumb             varchar(255) comment '大缩略图',
   img                  varchar(255) comment '默认图片',
   originalimg          varchar(255) comment '默认原图',
   newrate              decimal(2,1) comment '9成新',
   sortorder            smallint(5) unsigned not null default 0 comment '排序从大到小',
   isbest               tinyint(1) unsigned not null default 0 comment '是否精品',
   istop                tinyint(1) unsigned not null default 0 comment '是否置顶',
   ishot                tinyint(1) unsigned not null default 0 comment '是否最受欢迎',
   type                 tinyint unsigned not null default 0 comment '商品类型：书籍 软件等等',
   status               tinyint(1) unsigned not null default 1 comment '状态',
   createtime           timestamp not null default '0000-00-00 00:00:00.000' comment '创建时间',
   updatetime           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '最后更新时间', 
   primary key (uid),
   UNIQUE KEY `uid` (`uid`),
   UNIQUE KEY `sn` (`sn`)
);

/*==============================================================*/
/* Table: content                                               */
/*==============================================================*/
create table content
(
   oid                  int(11) unsigned not null auto_increment comment '自增主键',
   channel_id           int(11) unsigned not null comment '栏目ID',
   type                 tinyint unsigned not null comment '类型',
   adminuid             varchar(36) not null comment '管理员ID',
   top_level            tinyint(4) unsigned not null default 0 comment '固顶级别',
   priority             int(11) unsigned not null default 0 comment '排列顺序',
   title                varchar(150) not null comment '标题',
   titleshort           varchar(150) comment '简短标题',
   titleimg             varchar(255) default '0' comment '是否有标题图',
   originalimg          varchar(255) default '' comment '原图',
   author               varchar(100) comment '作者',
   origin               varchar(100) comment '来源',
   originurl            varchar(255) comment '来源链接',
   description          varchar(255) comment '描述',
   content              text comment '内容',
   isrecommend          tinyint(1) unsigned not null default 0 comment '是否推荐',
   status               tinyint(1) unsigned not null default 2 comment '状态(0:草稿,1:审核中,2:审核通过,3:回收站)',
   viewsday             int(11) unsigned not null default 0 comment '日访问数',
   commentsday          smallint(6) unsigned not null default 0 comment '日评论数',
   upsday               smallint(6) unsigned not null default 0 comment '日顶数',
   sortorder            smallint(6) unsigned default 0 comment '排序值',
   createtime           timestamp not null default '0000-00-00 00:00:00.000' comment '创建时间',
   updatetime           timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '最后更新时间', 
   primary key (oid),
   UNIQUE KEY `oid` (`oid`)
);

/*==============================================================*/
/* Table: content                                               */
/*==============================================================*/
create table `region` (
  `id` char(6) not null,
  `name` varchar(60) default null,
  `name_english` varchar(254) default '',
  `name_short` varchar(60) default null,
  `postcode` varchar(6) default null,
  `areacode` varchar(8) default null,
  `parentid` varchar(6) default '',
  `note` varchar(254) default '',
  PRIMARY KEY (`id`)
)