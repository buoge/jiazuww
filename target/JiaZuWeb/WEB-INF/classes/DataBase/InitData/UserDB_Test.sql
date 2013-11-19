/*==============================================================*/
/* DBMS name:      MySQL 5.5                                                                 */
/* Created on:     21:21 2012/8/10                                                    */
/*==============================================================*/

/*==============================================================*/
/*
DataBase: UserDB
Author:		architect.bian
Description:	UserDB初始化测试数据
CreatedDate:	19:59 2012/7/28
ModifyDate:	19:59 2012/7/28
*/
/*==============================================================*/
/*
Author:		architect.bian
Description:	user表的初始化测试数据
CodeFile:		com.jiazu.web.platform.dao.UserDaoTest.java
*/

INSERT INTO `user` (`oid`, `uid`, `groupuid`, `userid`, `account`, `password`, `name`, `gender`, `realname`, `birthday`, `email`, `intro`, `thumb`, `avatar`, `original`, `signed`, `qq`, `msn`, `phone`, `mobile`, `salary`, `status`, `resetpwd`, `logincount`, `educount`, `eventcount`, `groupcount`, `msgcount`, `errorlasttime`, `errorcount`, `errorip`, `lastlogintime`, `lastloginip`, `registerip`, `createtime`, `updatetime`) VALUES
(1, '93483b04795f48d0a70b1f9004c1f98f', '86883b04795f38d0a70b1f9004c1f999', 'greathill', 111, 'e10adc3949ba59abbe56e057f20f883e', '大山', NULL, NULL, NULL, NULL, NULL, NULL, '/imgs/default/defaulthead.jpg', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, 0, 0, 0, 0, 0, NULL, 0, NULL, NULL, '127.0.0.1', '127.0.0.1', '2012-08-10 18:01:29', '2012-08-10 18:01:29'),
(2, '93483b04795f48d0a70b1f9004c1f922', '86883b04795f38d0a70b1f9004c1f999', 'test', 0, 'e10adc3949ba59abbe56e057f20f883e', 'test', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, 0, 0, 0, 0, 0, NULL, 0, NULL, NULL, '127.0.0.1', '127.0.0.1', '2012-08-10 18:01:29', '2012-08-10 18:01:29'),
(3, '93483b04795f48d0a70b1f9004c1f933', '86883b04795f38d0a70b1f9004c1f999', 'jiazu', 0, 'e10adc3949ba59abbe56e057f20f883e', 'jiazu', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, 0, 0, 0, 0, 0, NULL, 0, NULL, NULL, '127.0.0.1', '127.0.0.1', '2012-08-10 18:01:29', '2012-08-10 18:01:29');
/*==============================================================*/
/*
Author:		architect.bian
Description:	accountlog表的初始化测试数据
CodeFile:		com.jiazu.web.platform.dao.AccountLogDaoTest.java
*/
INSERT INTO `accountlog` (`uid`, `useruid`, `doaction`, `usemoney`, `account`, `createtime`) VALUES ('86883b04795f38d0a70b1f9004c1f989', '93483b04795f48d0a70b1f9004c1f98f', '测试', '100.09', '200.09', '2012-08-18 00:00:00');

/*==============================================================*/
/*
Author:		architect.bian
Description:	***表的初始化测试数据
CodeFile:		com.jiazu.web.platform.dao.***
*/
INSERT INTO `comments` (`uid`, `fromuid`, `useruid`, `comment`, `status`, `createtime`) VALUES ('d064a2fee9bb11e1b4b000fff2ed3093', '93483b04795f48d0a70b1f9004c1f98f', 'greathill', '测试', 1, '2012-08-19');

/*==============================================================*/
/*
Author:		architect.bian
Description:	***表的初始化测试数据
CodeFile:		com.jiazu.web.platform.dao.***
*/
INSERT INTO `customgallery` (`uid`, `groupuid`, `useruid`, `img`, `littlethumb`, `thumb`, `bigthumb`, `original`, `title`, `istop`, `sortorder`, `createtime`) VALUES
('86883b04795f38d0a70b1f9004c1f989', 'd064a2fee9bb11e1b4b000fff2ed3093', '93483b04795f48d0a70b1f9004c1f98f', '/imgs/webimgs/custom3.gif', '/imgs/webimgs/pic1.gif', '/imgs/webimgs/custom2.gif', '/imgs/webimgs/custom1.gif', 'oright.png', '测试', 1, 19, '2012-08-19 00:00:00'),
('76883b04795f38d0a70b1f9004c1f989', 'd064a2fee9bb11e1b4b000fff2ed3093', '93483b04795f48d0a70b1f9004c1f98f', '/imgs/webimgs/custom3.gif', '/imgs/webimgs/pic2.gif', '/imgs/webimgs/custom2.gif', '/imgs/webimgs/custom1.gif', 'oright.png', '测试', 0, 18, '2012-08-19 00:00:00'),
('66883b04795f38d0a70b1f9004c1f989', 'd064a2fee9bb11e1b4b000fff2ed3093', '93483b04795f48d0a70b1f9004c1f98f', '/imgs/webimgs/custom3.gif', '/imgs/webimgs/pic3.gif', '/imgs/webimgs/custom2.gif', '/imgs/webimgs/custom1.gif', 'oright.png', '测试', 1, 17, '2012-08-19 00:00:00'),
('56883b04795f38d0a70b1f9004c1f989', 'd064a2fee9bb11e1b4b000fff2ed3093', '93483b04795f48d0a70b1f9004c1f98f', '/imgs/webimgs/custom3.gif', '/imgs/webimgs/pic2.gif', '/imgs/webimgs/custom2.gif', '/imgs/webimgs/custom1.gif', 'oright.png', '测试', 1, 15, '2012-08-19 00:00:00'),
('46883b04795f38d0a70b1f9004c1f989', 'd064a2fee9bb11e1b4b000fff2ed3093', '93483b04795f48d0a70b1f9004c1f98f', '/imgs/webimgs/custom3.gif', '/imgs/webimgs/pic1.gif', '/imgs/webimgs/custom2.gif', '/imgs/webimgs/custom1.gif', 'oright.png', '测试', 1, 14, '2012-08-19 00:00:00');
/*==============================================================*/
/*
Author:		architect.bian
Description:	***表的初始化测试数据
CodeFile:		com.jiazu.web.platform.dao.***
*/

INSERT INTO `education` (`oid`, `groupuid`, `useruid`, `type`, `title`, `titleimg`, `author`, `content`, `viewsday`, `isrecommend`, `ispublic`, `status`, `createtime`, `updatetime`) VALUES
(1, '86883b04795f38d0a70b1f9004c1f989', '93483b04795f48d0a70b1f9004c1f98f', 1, '测试', '0', '测试', '19测试', 1, 1, 1, 1, '2012-08-20 00:00:00', '2012-08-20 07:45:03'),
(2, '86883b04795f38d0a70b1f9004c1f989', '93483b04795f48d0a70b1f9004c1f98f', 0, '名门家教：家教的鼻祖是孔子——三人行必有吾师', '0', '测试', '19测试', 1, 1, 1, 1, '2012-08-20 00:00:00', '2012-08-20 07:45:03'),
(3, '86883b04795f38d0a70b1f9004c1f989', '93483b04795f48d0a70b1f9004c1f98f', 1, '专家理念：家教的鼻祖是孔子——三人行必有吾师', '0', '测试', '19测试', 1, 1, 1, 1, '2012-08-20 00:00:00', '2012-08-20 07:45:03'),
(4, '86883b04795f38d0a70b1f9004c1f989', '93483b04795f48d0a70b1f9004c1f98f', 2, '家族教育：家教的鼻祖是孔子——三人行必有吾师', '0', '测试', '19测试', 1, 1, 1, 1, '2012-08-20 00:00:00', '2012-08-20 07:45:03');

/*==============================================================*/
/*
Author:		architect.bian
Description:	***表的初始化测试数据
CodeFile:		com.jiazu.web.platform.dao.***
*/

INSERT INTO `events` (`uid`, `groupuid`, `groupName`, `groupImg`, `useruid`, `userName`, `type`, `content`, `img`, `bigimg`, `rawimg`, `commentcount`, `isrecommend`, `ispublic`, `status`, `createtime`, `updatetime`) VALUES 
  ('86883b04795f38d0a70b1f9004c1f989', 'd064a2fee9bb11e1b4b000fff2ed3093', '乐呵呵家族', '/imgs/webimgs/eventhead1.gif', '93483b04795f48d0a70b1f9004c1f98f', 'great hill', 0, '表的初始化测试数据表的初始化测试数据测试iPad表的初始化测试数据测试Melinda表的初始化测试数据iPad测试测试Ц初始化测试数据Ц', '/imgs/webimgs/eventpic1.gif', '/imgs/webimgs/bigevent.png', '/imgs/webimgs/bigevent.png', 122, 1, 1, 1, '2012-08-20', '2012-11-06 06:18:55');


/*==============================================================*/
/*
Author:		architect.bian
Description:	***表的初始化测试数据
CodeFile:		com.jiazu.web.platform.dao.***
*/

INSERT INTO `jiazu` (`uid`, `owner`, `ownerid`, `name`, `headimg`, `logo`, `logooriginal`, `brief`, `desc`, `logaction`, `createtime`, `updatetime`) VALUES 
  ('86883b04795f38d0a70b1f9004c1f989', '', 'greathill', '测试', '/imgs/default/noimg50_50.gif', '/imgs/default/noimg130_130.gif', '/imgs/default/noimg130_130.gif', '家族族训', '家族渊源', NULL, '2012-08-21', '2012-11-06 15:27:57'),
  ('86883b04795f38d0a70b1f9004c1f999', '93483b04795f48d0a70b1f9004c1f98f', 'greathill', '乐呵呵家族', '/imgs/default/noimg50_50.gif', '/imgs/default/noimg130_130.gif', '/imgs/default/noimg130_130.gif', '昔朱子作家训，后世奉为典常。吾族乾隆旧牒，有忠孝勤俭明宽公廉八法，撰自常宁极生先哲，亦原本朱子遗意，惟首列忠条，尊主忠君立言，与今国体不甚相合，余或陈义过高，或于阔不切情事。兹就忠孝节义勤俭公信，关于日用伦常持身涉世诸大端，仿朱子家训之意，既以绍述先人，并期垂示后昆，俾有所矜式云。', '', NULL, '2012-08-21', '2012-11-06 15:27:59');

/*==============================================================*/
/*
Author:		architect.bian
Description:	***表的初始化测试数据
CodeFile:		com.jiazu.web.platform.dao.***
*/

INSERT INTO `jiazumember` (`uid`, `useruid`, `type`, `status`, `createtime`, `updatetime`) VALUES 
  ('86883b04795f38d0a70b1f9004c1f989', '93483b04795f48d0a70b1f9004c1f98f', 0, 1, '2012-10-14 16:48:24', '2012-10-14 16:48:24'),
  ('86883b04795f38d0a70b1f9004c1f999', '93483b04795f48d0a70b1f9004c1f98f', 2, 1, '2012-10-26 07:51:46', '2012-10-26 07:51:49');

/*==============================================================*/
/*
Author:		architect.bian
Description:	***表的初始化测试数据
CodeFile:		com.jiazu.web.platform.dao.***
*/

INSERT INTO `msgboard` (`uid`, `useruid`, `useruidfrom`, `title`, `msg`, `type`, `createtime`) VALUES
('86883b04795f38d0a70b1f9004c1f989', '93483b04795f48d0a70b1f9004c1f98f', 'd064a2fee9bb11e1b4b000fff2ed3093', '测试', '测试', 1, '2012-08-21 00:00:00');


/*==============================================================*/
/*
Author:		architect.bian
Description:	***表的初始化测试数据
CodeFile:		com.jiazu.web.platform.dao.***
*/

INSERT INTO `wishes` (`uid`, `groupuid`, `useruid`, `name`, `wish`, `type`, `createtime`) VALUES
('86883b04795f38d0a70b1f9004c1f989', '93483b04795f48d0a70b1f9004c1f98f', 'd064a2fee9bb11e1b4b000fff2ed3093', '测试', '测试', 1, '2012-08-21 00:00:00');


/*==============================================================*/
/*
Author:		architect.bian
Description:	***表的初始化测试数据
CodeFile:		com.jiazu.web.platform.dao.***
*/

INSERT INTO `zupumember` (`uid`, `groupuid`, `useruid`, `useruid2`, `name`, `name2`, `gender`, `gender2`, `realname`, `realname2`, `birthday`, `birthday2`, `avatar`, `avatar2`, `level`, `parentuid`, `status`, `status2`, `createtime`) VALUES 
('86883b04795f38d0a70b1f9004c1f989', '86883b04795f38d0a70b1f9004c1f989', '93483b04795f48d0a70b1f9004c1f98f', '93483b04795f48d0a70b1f9004c1f98f', '张三', '李四', 0, 1, '张武', '李老五', '2012-10-06', '2012-10-06', 'avatar.gif', 'avatar.gif', 1, 'd064a2fee9bb11e1b4b000fff2ed3093', 1, 1, '2012-10-06 10:27:26');

/*==============================================================*/
/*
Author:		architect.bian
Description:	***表的初始化测试数据
CodeFile:		com.jiazu.web.platform.dao.***
*/

INSERT INTO `articlemarks` (`uid`, `useruid`, `articleuid`, `note`, `type`, `marktype`, `status`, `createtime`) VALUES 
  ('86883b04795f38d0a70b1f9004c1f989', 'd064a2fee9bb11e1b4b000fff2ed3093', '93483b04795f48d0a70b1f9004c1f98f', NULL, 1, 0, 1, '2012-9-16 15:37:08');


/*==============================================================*/
/*
Author:		architect.bian
Description:	***表的初始化测试数据
CodeFile:		com.jiazu.web.platform.dao.***
*/

INSERT INTO `flowers` (`uid`, `name`, `thumb`, `img`, `bigimg`, `original`, `price`, `free`, `sortorder`, `status`, `createtime`, `updatetime`) VALUES 
  ('86883b04795f38d0a70b1f9004c1f989', '测试蜡烛', 'asdjffds.jpg', 'asdfimg.png', NULL, 'myorigninal.jpg', 1, 1, 0, 0, '2012-12-08 08:36:59', '2012-12-08 08:36:59');



/*==============================================================*/
/*
Author:		architect.bian
Description:	***表的初始化测试数据
CodeFile:		com.jiazu.web.platform.dao.***
*/

