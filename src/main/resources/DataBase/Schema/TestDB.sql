/*==============================================================*/
/* DBMS name:      MySQL 5.5                                                                 */
/* Created on:     2012/7/28 20:47:51                                                     */
/*==============================================================*/

/*==============================================================*/
/*
DataBase: TestDB
Author:		architect.bian
Description:	创建数据库
CreatedDate:	14:01 2012/8/6
ModifyDate:	14:01 2012/8/6
*/
/*==============================================================*/
/*
drop database if EXISTS `TestDB`;

CREATE DATABASE `TestDB`
    CHARACTER SET 'utf8'
    COLLATE 'utf8_general_ci';

use `TestDB`;
*/
drop table if exists t_idvalue;

CREATE TABLE `t_idvalue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;