/*==============================================================*/
/* DBMS name:      MySQL 5.5                                                                 */
/* Created on:     21:21 2012/8/10                                                    */
/*==============================================================*/

/*==============================================================*/
/*
DataBase: ShopDB
Author:		architect.bian
Description:	ShopDB初始化测试数据
CreatedDate:	19:59 2012/7/28
ModifyDate:	19:59 2012/7/28
*/
/*==============================================================*/
/*
Author:		architect.bian
Description:	***表的初始化测试数据
CodeFile:		com.jiazu.web.platform.dao.***
*/

INSERT INTO `admin` (`uid`, `userid`, `email`, `password`, `createtime`) VALUES
('86883b04795f38d0a70b1f9004c1f989', 'admin', 'greatbsky@163.com', 'e10adc3949ba59abbe56e057f20f883e', '2012-08-22 00:00:00');

/*==============================================================*/
/*
Author:		architect.bian
Description:	***表的初始化测试数据
CodeFile:		com.jiazu.web.platform.dao.***
*/

INSERT INTO `adminrole` (`uid`, `userid`, `authority`) VALUES 
  ('96883b04795f38d0a70b1f9004c1f989', 'admin', 'ROLE_USER'),
  ('86883b04795f38d0a70b1f9004c1f989', 'admin', 'ROLE_ADMIN');
  
/*==============================================================*/
/*
Author:		architect.bian
Description:	***表的初始化测试数据
CodeFile:		com.jiazu.web.platform.dao.***
*/

INSERT INTO `b2c` (`uid`, `catuid`, `sn`, `name`, `number`, `weight`, `marketprice`, `shopprice`, `shippingfee`, `keywords`, `brief`, `desc`, `littlethumb`, `thumb`, `rate`, `sortorder`, `isonsale`, `isbest`, `isnew`, `istop`, `ishot`, `type`, `showtype`, `sellcount`, `buyercount`, `clickcount`, `createtime`, `updatetime`) VALUES 
  ('150233858d8f495a83ca77f94a066dfa', '93483b04795f48d0a70b1f9004c1f98f', 'd67u4o04', '《观色·观行·观心：洞察他人心理观观心：他人心理（第3版》', 12, 2.1, 154, 39, 4.33, '乔布斯', '好书推荐语。。好书sh是一本博士后必备书籍！绝对经典！！！', '描述', '/imgs/webimgs/book2.gif', '/imgs/webimgs/book2.gif', 2.6, 122, 1, 1, 0, 0, 0, 0, -1, 0, 11, 0, '2012-11-06 23:25:40', '2012-11-07 18:56:26'),
  ('26883b04795f38d0a70b1f9004c1f989', '93483b04795f48d0a70b1f9004c1f98f', 'c064a2fee9bb11e1b4b000fff2ed3093', '好多村', 150, 1.03, 6899, 6699, 10, 'D90 尼康', '尼康突破性的场景识别系统首次应用于 D3 和 D300 这两款旗舰级相机，如今这一系统也配备于 D90 之中', '通过对来自 420 区 RGB 感应器的色彩和亮度信息加以利用，D90 提供惊人的自动对焦准确度。在自动区域自动对焦模式下拍摄时，相机可以通过侦测前景、背景和拍摄对象位置，对主要拍摄对象进行快速对焦', '/imgs/webimgs/pro6.gif', '/imgs/webimgs/pro6.gif', 0.9, 121, 1, 1, 0, 1, 1, 3, 1, 109, 102, 1337, '2012-08-22', '2012-11-07 18:56:26'),
  ('2ed77b02f93e4029be4ffd367860f631', '93483b04795f48d0a70b1f9004c1f98f', 'j9as43sy', '卡宾正品cab卡宾正品cabbeen浅灰小been浅灰小V', 12, 2.1, 154, 39, 4.33, '乔布斯', '传记', '描述', '/imgs/webimgs/b2c3.gif', '/imgs/webimgs/b2c3.gif', 2.6, 122, 1, 1, 0, 0, 0, 2, -1, 0, 11, 0, '2012-11-06 23:24:28', '2012-11-07 18:56:26'),
  ('313f8388267346fa9a14bf9fc45a1889', '93483b04795f48d0a70b1f9004c1f98f', '9vju6174', 'Windows 7家庭普通版 操作系统 销量先锋，惊喜特卖！', 12, 2.1, 154, 39, 4.33, '乔布斯', '传记', '描述', 'asdthunmb.jpg', 'asdthunmb.jpg', 2.6, 122, 1, 1, 0, 0, 0, 3, -1, 0, 11, 0, '2012-11-07 13:42:58', '2012-11-07 18:56:26'),
  ('36883b04795f38d0a70b1f9004c1f989', '93483b04795f48d0a70b1f9004c1f98f', 'a064a2fee9bb11e1b4b000fff2ed3093', '好多村', 150, 1.03, 6899, 6699, 10, 'D90 尼康', '尼康突破性的场景识别系统首次应用于 D3 和 D300 这两款旗舰级相机，如今这一系统也配备于 D90 之中', '通过对来自 420 区 RGB 感应器的色彩和亮度信息加以利用，D90 提供惊人的自动对焦准确度。在自动区域自动对焦模式下拍摄时，相机可以通过侦测前景、背景和拍摄对象位置，对主要拍摄对象进行快速对焦', '/imgs/webimgs/pro3.gif', '/imgs/webimgs/pro3.gif', 0.9, 122, 1, 1, 0, 1, 1, 2, 1, 109, 102, 1337, '2012-08-22', '2012-11-07 18:56:26'),
  ('37fab088ba5348cdbf63093ba13bcacf', '93483b04795f48d0a70b1f9004c1f98f', 'f5c3gsjn', 'Windows 7家庭普通版 操作系统 销量先锋，惊喜特卖！', 12, 2.1, 154, 39, 4.33, '乔布斯', '传记', '描述', 'asdthunmb.jpg', 'asdthunmb.jpg', 2.6, 122, 1, 1, 0, 0, 0, 3, -1, 0, 11, 0, '2012-11-06 23:26:35', '2012-11-07 18:56:26'),
  ('3f64553b313349529101f831f545bd18', '93483b04795f48d0a70b1f9004c1f98f', 'hr0jwy48', 'Windows 7家庭普通版 操作系统 销量先锋，惊喜特卖！', 12, 2.1, 154, 39, 4.33, '乔布斯', '传记', '描述', 'asdthunmb.jpg', 'asdthunmb.jpg', 2.6, 122, 1, 1, 0, 0, 0, 3, -1, 0, 11, 0, '2012-11-07 13:42:57', '2012-11-07 18:56:26'),
  ('46883b04795f38d0a70b1f9004c1f989', '93483b04795f48d0a70b1f9004c1f98f', 'b064a2fee9bb11e1b4b000fff2ed3093', '好多村', 150, 1.03, 6899, 6699, 10, 'D90 尼康', '尼康突破性的场景识别系统首次应用于 D3 和 D300 这两款旗舰级相机，如今这一系统也配备于 D90 之中', '通过对来自 420 区 RGB 感应器的色彩和亮度信息加以利用，D90 提供惊人的自动对焦准确度。在自动区域自动对焦模式下拍摄时，相机可以通过侦测前景、背景和拍摄对象位置，对主要拍摄对象进行快速对焦', '/imgs/webimgs/pro1.gif', '/imgs/webimgs/pro1.gif', 0.9, 123, 1, 1, 0, 1, 1, 1, 1, 109, 102, 1337, '2012-08-22', '2012-11-07 18:56:26'),
  ('56883b04795f38d0a70b1f9004c1f989', '93483b04795f48d0a70b1f9004c1f98f', 'g064a2fee9bb11e1b4b000fff2ed3093', '族徽设计', 150, 1.03, 6899, 6699, 10, 'D90 尼康', '尼康突破性的场景识别系统首次应用于 D3 和 D300 这两款旗舰级相机，如今这一系统也配备于 D90 之中', '通过对来自 420 区 RGB 感应器的色彩和亮度信息加以利用，D90 提供惊人的自动对焦准确度。在自动区域自动对焦模式下拍摄时，相机可以通过侦测前景、背景和拍摄对象位置，对主要拍摄对象进行快速对焦', 'ads.jpg', 'ads.jpg', 0.9, 122, 1, 1, 0, 1, 1, 3, 0, 109, 102, 1337, '2012-08-22', '2012-11-07 18:56:26'),
  ('652cb148251d4c399431e18a95c78763', '93483b04795f48d0a70b1f9004c1f98f', 'if31b6yx', '《观色·观行·观心：洞察他人心理观观心：他人心理（第3版》', 12, 2.1, 154, 39, 4.33, '乔布斯', '好书推荐语。。好书sh是一本博士后必备书籍！绝对经典！！！', '描述', '/imgs/webimgs/book1.gif', '/imgs/webimgs/book1.gif', 2.6, 122, 1, 1, 0, 0, 0, 0, -1, 0, 11, 0, '2012-11-06 23:25:39', '2012-11-07 18:56:26'),
  ('66883b04795f38d0a70b1f9004c1f989', '93483b04795f48d0a70b1f9004c1f98f', 'h064a2fee9bb11e1b4b000fff2ed3093', '族谱制作', 150, 1.03, 6899, 6699, 10, 'D90 尼康', '尼康突破性的场景识别系统首次应用于 D3 和 D300 这两款旗舰级相机，如今这一系统也配备于 D90 之中', '通过对来自 420 区 RGB 感应器的色彩和亮度信息加以利用，D90 提供惊人的自动对焦准确度。在自动区域自动对焦模式下拍摄时，相机可以通过侦测前景、背景和拍摄对象位置，对主要拍摄对象进行快速对焦', 'ads.jpg', 'ads.jpg', 0.9, 122, 1, 1, 0, 1, 1, 2, 0, 109, 102, 1337, '2012-08-22', '2012-11-07 18:56:26'),
  ('76883b04795f38d0a70b1f9004c1f989', '93483b04795f48d0a70b1f9004c1f98f', 'e064a2fee9bb11e1b4b000fff2ed3093', '正品软件出售', 150, 1.03, 6899, 6699, 10, 'D90 尼康', '尼康突破性的场景识别系统首次应用于 D3 和 D300 这两款旗舰级相机，如今这一系统也配备于 D90 之中', '通过对来自 420 区 RGB 感应器的色彩和亮度信息加以利用，D90 提供惊人的自动对焦准确度。在自动区域自动对焦模式下拍摄时，相机可以通过侦测前景、背景和拍摄对象位置，对主要拍摄对象进行快速对焦', 'ads.jpg', 'ads.jpg', 0.9, 122, 1, 1, 0, 1, 1, 3, 0, 109, 102, 1337, '2012-08-22', '2012-11-07 18:56:26'),
  ('86883b04795f38d0a70b1f9004c1f989', '93483b04795f48d0a70b1f9004c1f98f', 'd064a2fee9bb11e1b4b000fff2ed3093', '好多村', 150, 1.03, 6899, 6699, 10, 'D90 尼康', '尼康突破性的场景识别系统首次应用于 D3 和 D300 这两款旗舰级相机，如今这一系统也配备于 D90 之中', '通过对来自 420 区 RGB 感应器的色彩和亮度信息加以利用，D90 提供惊人的自动对焦准确度。在自动区域自动对焦模式下拍摄时，相机可以通过侦测前景、背景和拍摄对象位置，对主要拍摄对象进行快速对焦', '/imgs/webimgs/edu1.gif', '/imgs/webimgs/edu1.gif', 0.9, 122, 1, 1, 0, 1, 1, 0, -1, 109, 102, 1337, '2012-08-22', '2012-11-07 18:56:26'),
  ('875e9968c5214426ab2c77326401fe38', '93483b04795f48d0a70b1f9004c1f98f', '696plo3n', '《观色·观行·观心：洞察他人心理观观心：他人心理（第3版》', 12, 2.1, 154, 39, 4.33, '乔布斯', '好书推荐语。。好书sh是一本博士后必备书籍！绝对经典！！！', '描述', '/imgs/webimgs/book3.gif', '/imgs/webimgs/book3.gif', 2.6, 122, 1, 1, 0, 0, 0, 0, -1, 0, 11, 0, '2012-11-06 23:25:41', '2012-11-07 18:56:26'),
  ('891b9dc39b994cdfa906876382982d04', '93483b04795f48d0a70b1f9004c1f98f', 'lougyo0a', '卡宾正品cab卡宾正品cabbeen浅灰小been浅灰小V', 12, 2.1, 154, 39, 4.33, '乔布斯', '传记', '描述', '/imgs/webimgs/b2c3.gif', '/imgs/webimgs/b2c3.gif', 2.6, 122, 1, 1, 0, 0, 0, 1, -1, 0, 11, 0, '2012-11-06 23:17:34', '2012-11-07 18:56:26'),
  ('8c7324b8eb2540388e8e8e891518c89a', '93483b04795f48d0a70b1f9004c1f98f', 'bj9vlg7f', 'Windows 7家庭普通版 操作系统 销量先锋，惊喜特卖！', 12, 2.1, 154, 39, 4.33, '乔布斯', '传记', '描述', 'asdthunmb.jpg', 'asdthunmb.jpg', 2.6, 122, 1, 1, 0, 0, 0, 3, -1, 0, 11, 0, '2012-11-06 23:26:35', '2012-11-07 18:56:26'),
  ('9949e6b49b4c4f6793576a13c1111ac2', '93483b04795f48d0a70b1f9004c1f98f', 'xp620nzv', '卡宾正品cab卡宾正品cabbeen浅灰小been浅灰小V', 12, 2.1, 154, 39, 4.33, '乔布斯', '传记', '描述', '/imgs/webimgs/b2c1.gif', '/imgs/webimgs/b2c1.gif', 2.6, 122, 1, 1, 0, 0, 0, 1, -1, 0, 11, 0, '2012-11-06 23:17:33', '2012-11-07 18:56:26'),
  ('9e6dd6f442814430b2b5f747489c0665', '93483b04795f48d0a70b1f9004c1f98f', 'zg4vg2eg', '卡宾正品cab卡宾正品cabbeen浅灰小been浅灰小V', 12, 2.1, 154, 39, 4.33, '乔布斯', '传记', '描述', '/imgs/webimgs/b2c1.gif', '/imgs/webimgs/b2c1.gif', 2.6, 122, 1, 1, 0, 0, 0, 2, -1, 0, 11, 0, '2012-11-06 23:24:27', '2012-11-07 18:56:26'),
  ('a051d65610e74b90ab8736d5309eaeba', '93483b04795f48d0a70b1f9004c1f98f', 'woqt50vr', '卡宾正品cab卡宾正品cabbeen浅灰小been浅灰小V', 12, 2.1, 154, 39, 4.33, '乔布斯', '传记', '描述', '/imgs/webimgs/b2c2.gif', '/imgs/webimgs/b2c2.gif', 2.6, 122, 1, 1, 0, 0, 0, 1, -1, 0, 11, 0, '2012-11-06 23:17:34', '2012-11-07 18:56:26'),
  ('d7286bcff8e943b6937124c5d12d9e38', '93483b04795f48d0a70b1f9004c1f98f', 'j36437un', '卡宾正品cab卡宾正品cabbeen浅灰小been浅灰小V', 12, 2.1, 154, 39, 4.33, '乔布斯', '传记', '描述', '/imgs/webimgs/b2c2.gif', '/imgs/webimgs/b2c2.gif', 2.6, 122, 1, 1, 0, 0, 0, 2, -1, 0, 11, 0, '2012-11-06 23:24:27', '2012-11-07 18:56:26'),
  ('e647809382d743baa71507d7876e88fe', '93483b04795f48d0a70b1f9004c1f98f', '7r7cnojo', 'Windows 7家庭普通版 操作系统 销量先锋，惊喜特卖！', 12, 2.1, 154, 39, 4.33, '乔布斯', '传记', '描述', 'asdthunmb.jpg', 'asdthunmb.jpg', 2.6, 122, 1, 1, 0, 0, 0, 3, -1, 0, 11, 0, '2012-11-07 13:42:57', '2012-11-07 18:56:26'),
  ('e8f506f6a13849b48a71d38f72c5f153', '93483b04795f48d0a70b1f9004c1f98f', '26dfq7dz', 'Windows 7家庭普通版 操作系统 销量先锋，惊喜特卖！', 12, 2.1, 154, 39, 4.33, '乔布斯', '传记', '描述', 'asdthunmb.jpg', 'asdthunmb.jpg', 2.6, 122, 1, 1, 0, 0, 0, 3, -1, 0, 11, 0, '2012-11-06 23:26:35', '2012-11-07 18:56:26');



/*==============================================================*/
/*
Author:		architect.bian
Description:	***表的初始化测试数据
CodeFile:		com.jiazu.web.platform.dao.***
*/

INSERT INTO `b2caddress` (`uid`, `useruid`, `consignee`, `email`, `province`, `city`, `district`, `address`, `zipcode`, `tel`, `mobile`, `type`, `createtime`, `updatetime`) VALUES
('86883b04795f38d0a70b1f9004c1f989', '93483b04795f48d0a70b1f9004c1f98f', '收件人', 'asd@ass.com', 1, 1, 1, '联系地址', '100086', '010-1230098890', '1920099909', 0, '2012-08-22 00:00:00', '2012-08-22 08:14:42');

/*==============================================================*/
/*
Author:		architect.bian
Description:	***表的初始化测试数据
CodeFile:		com.jiazu.web.platform.dao.***
*/

INSERT INTO `b2ccart` (`uid`, `useruid`, `b2cuid`, `number`, `createtime`, `updatetime`) VALUES
('86883b04795f38d0a70b1f9004c1f989', '93483b04795f48d0a70b1f9004c1f98f', 'd064a2fee9bb11e1b4b000fff2ed3093', 2, '2012-08-22 00:00:00', '2012-08-22 08:17:52');

/*==============================================================*/
/*
Author:		architect.bian
Description:	***表的初始化测试数据
CodeFile:		com.jiazu.web.platform.dao.***
*/

INSERT INTO `content` (`oid`, `channel_id`, `type`, `adminuid`, `top_level`, `priority`, `title`, `titleshort`, `titleimg`, `author`, `origin`, `originurl`, `description`, `content`, `isrecommend`, `status`, `viewsday`, `commentsday`, `upsday`, `sortorder`, `createtime`, `updatetime`) VALUES
(1, 1, 1, '93483b04795f48d0a70b1f9004c1f98f', 12, 12, '尼康（Nikon） D3100 单反套机（AF-S DX 18-55mm f/3.5-5.6G VR尼克尔镜头）', '尼康（Nikon） D3100', 'asdddd.jpg', 'admin', 'google', 'http://google.com', '简要描述', '内容', 1, 1, 122, 43, 66, 0,'2012-08-22 00:00:00', '2012-08-22 08:35:38'),
(2, 0, 2, 'ksdjf39fj9e39490fjeiojwiocjoiejw', 0, 0, '家族网注册条款', NULL, '0', NULL, NULL, NULL, NULL, "【注意】欢迎申请使用广州网易计算机系统有限公司（下列简称为“网易公司”）提供的服务。请用户仔细阅读以下全部内容（特别是粗体下划线标注的内容）。如用户不同意本服务条款任意内容，请不要注册或使用网易服务。如用户通过进入注册程序并勾选“我同意网易通行证服务条款”，即表示用户与网易公司已达成协议，自愿接受本服务条款的所有内容。此后，用户不得以未阅读本服务条款内容作任何形式的抗辩。", 0, 2, 0, 0, 0, 0, '2012-11-03 16:26:58', '2012-11-03 16:27:06'),
(3, 0, 4, 'ksdjf39fj9e39490fjeiojwiocjoiejw', 0, 0, 'title', NULL, '/imgs/webimgs/link1.gif', NULL, NULL, 'http://jiazuww.com', '', '', 0, 2, 0, 0, 0, 0, '2012-11-03 16:26:58', '2012-11-03 16:27:06'),
(4, 0, 4, 'ksdjf39fj9e39490fjeiojwiocjoiejw', 0, 0, 'title', NULL, '/imgs/webimgs/link2.gif', NULL, NULL, 'http://jiazuww.com', '', '', 0, 2, 0, 0, 0, 0, '2012-11-03 16:26:58', '2012-11-03 16:27:06'),
(5, 0, 4, 'ksdjf39fj9e39490fjeiojwiocjoiejw', 0, 0, 'title', NULL, '/imgs/webimgs/link3.gif', NULL, NULL, 'http://jiazuww.com', '', '', 0, 2, 0, 0, 0, 0, '2012-11-03 16:26:58', '2012-11-03 16:27:06'),
(6, 0, 4, 'ksdjf39fj9e39490fjeiojwiocjoiejw', 0, 0, 'title', NULL, '/imgs/webimgs/link2.gif', NULL, NULL, 'http://jiazuww.com', '', '', 0, 2, 0, 0, 0, 0, '2012-11-03 16:26:58', '2012-11-03 16:27:06'),
(7, 0, 3, 'ksdjf39fj9e39490fjeiojwiocjoiejw', 0, 0, '网标在线', NULL, '', NULL, NULL, 'http://jiazuww.com', '', '', 0, 2, 0, 0, 0, 0, '2012-11-03 16:26:58', '2012-11-03 16:27:06'),
(8, 0, 3, 'ksdjf39fj9e39490fjeiojwiocjoiejw', 0, 0, 'Google', NULL, '', NULL, NULL, 'http://jiazuww.com', '', '', 0, 2, 0, 0, 0, 0, '2012-11-03 16:26:58', '2012-11-03 16:27:06'),
(9, 0, 3, 'ksdjf39fj9e39490fjeiojwiocjoiejw', 0, 0, '百度', NULL, '', NULL, NULL, 'http://jiazuww.com', '', '', 0, 2, 0, 0, 0, 0, '2012-11-03 16:26:58', '2012-11-03 16:27:06'),
(10, 0, 1, 'ksdjf39fj9e39490fjeiojwiocjoiejw', 0, 0, '世界末日是2012年12月23日', NULL, '', NULL, NULL, 'http://jiazuww.com', '', '', 0, 2, 0, 0, 0, 0, '2012-11-03 16:26:58', '2012-11-03 16:27:06'),
(16, 0, 6, 'anonymousUser', 0, 0, '金币', NULL, NULL, NULL, NULL, '/search?s=金币&type=0', NULL, NULL, 0, 1, 0, 0, 0, 0, '2012-11-13 11:22:48', '2012-11-13 11:22:48');
/*==============================================================*/
/*
Author:		architect.bian
Description:	***表的初始化测试数据
CodeFile:		com.jiazu.web.platform.dao.***
*/
INSERT INTO `b2cgallery` (`uid`, `goodsuid`, `img`, `thumb`, `bigimg`, `original`, `title`, `isdefault`, `sortorder`, `createtime`) VALUES 
  ('46883b04795f38d0a70b1f9004c1f765', '46883b04795f38d0a70b1f9004c1f989', '/imgs/webimgs/d90350.jpg', '/imgs/webimgs/little1.gif', '/imgs/webimgs/d90big.jpg', '/imgs/webimgs/d90big.jpg', 'd90', 1, 1, '2012-11-07 11:40:54'),
  ('46883b04795f38d0a70b1f9004c1f766', '46883b04795f38d0a70b1f9004c1f989', '/imgs/webimgs/d90350.jpg', '/imgs/webimgs/little2.gif', '/imgs/webimgs/d90big.jpg', '/imgs/webimgs/d90big.jpg', 'd902', 0, 1, '2012-11-07 11:40:54'),
  ('46883b04795f38d0a70b1f9004c1f767', '46883b04795f38d0a70b1f9004c1f989', '/imgs/webimgs/d90350.jpg', '/imgs/webimgs/little1.gif', '/imgs/webimgs/d90big.jpg', '/imgs/webimgs/d90big.jpg', 'd90', 0, 1, '2012-11-07 11:40:54'),
  ('46883b04795f38d0a70b1f9004c1f768', '46883b04795f38d0a70b1f9004c1f989', '/imgs/webimgs/d90350.jpg', '/imgs/webimgs/little2.gif', '/imgs/webimgs/d90big.jpg', '/imgs/webimgs/d90big.jpg', 'd902', 0, 1, '2012-11-07 11:40:54'),
  ('86883b04795f38d0a70b1f9004c1f989', '93483b04795f48d0a70b1f9004c1f98f', 'img.png', 'thumb.jpg', 'img.png', 'orign.gif', '标题', 1, 12, '2012-08-22');

/*==============================================================*/
/*
Author:		architect.bian
Description:	***表的初始化测试数据
CodeFile:		com.jiazu.web.platform.dao.***
*/

INSERT INTO `b2corder` (`uid`, `useruid`, `ordersn`, `totalamount`, `unitprice`, `totalprice`, `shippingid`, `postscript`, `shippingfee`, `shipping_name`, `consignee`, `province`, `city`, `district`, `address`, `zipcode`, `tel`, `mobile`, `email`, `memo`, `orderstatus`, `shippingstatus`, `paystatus`, `payid`, `payname`, `exprdate`, `createtime`, `updatetime`) VALUES
('86883b04795f38d0a70b1f9004c1f989', '93483b04795f48d0a70b1f9004c1f98f', 'f2ed3093', 10, 209.00, 2090.00, 1, 'postscript', 10.00, '顺风', '北京海淀张三', 1, 1, 1, '地址', '100086', '010-29399989', '198893838849', 'greatbsky@163.com', '要红色的哦', 1, 1, 1, 1, '支付宝', '2012-08-25', '2012-08-22 00:00:00', '2012-08-22 08:44:06');

/*==============================================================*/
/*
Author:		architect.bian
Description:	***表的初始化测试数据
CodeFile:		com.jiazu.web.platform.dao.***
*/

INSERT INTO `b2corderdetail` (`uid`, `b2cuid`, `b2csn`, `b2cname`, `b2clittlethumb`, `b2cthumb`, `num`, `createtime`, `updatetime`) VALUES 
  ('93483b04795f48d0a70b1f9004c1f98f', '86883b04795f38d0a70b1f9004c1f989', 'sddsnsnsn', '尼康D90', '/imgs/default/nopic50_50.gif', '/imgs/default/nopic.gif', 1, '2012-11-10 10:54:57', '2012-11-10 10:55:03');

/*==============================================================*/
/*
Author:		architect.bian
Description:	***表的初始化测试数据
CodeFile:		com.jiazu.web.platform.dao.***
*/

INSERT INTO `b2corderlog` (`oid`, `useruid`, `orderuid`, `doaction`, `logtype`, `createtime`, `updatetime`) VALUES
(1, '93483b04795f48d0a70b1f9004c1f98f', '86883b04795f38d0a70b1f9004c1f989', '张三发货', 1, '2012-08-22 00:00:00', '2012-08-22 08:46:03');

/*==============================================================*/
/*
Author:		architect.bian
Description:	***表的初始化测试数据
CodeFile:		com.jiazu.web.platform.dao.***
*/

INSERT INTO `c2c` (`uid`, `useruid`, `sn`, `name`, `number`, `price`, `desc`, `contactname`, `telephone`, `qq`, `address`, `littlethumb`, `thumb`, `bigthumb`, `img`, `originalimg`, `newrate`, `sortorder`, `isbest`, `istop`, `ishot`, `type`, `status`, `createtime`, `updatetime`) VALUES
('96883b04795f38d0a70b1f9004c1f989', '93483b04795f48d0a70b1f9004c1f98f', 'e064a2fee9bb11e1b4b000fff2ed3093', '西藏地震地区需要捐献棉被', 1, 100.56, '描述', '联系人', '010-9099090', '89998889', '北京海淀', '/imgs/webimgs/c2c3.gif', '/imgs/webimgs/c2c3.gif', '/imgs/webimgs/c2c3.gif', 'img.png', 'origjg.img', 0.9, 12, 0, 0, 1, 2, 1, '2012-08-22 00:00:00', '2012-08-22 08:50:59'),
('96883b04795f38d0a70b1f9004c1f988', '93483b04795f48d0a70b1f9004c1f98f', 'f064a2fee9bb11e1b4b000fff2ed3093', 'BBS充电合金四通道遥控飞机模型 遥控直升机直升机航模儿', 1, 100.56, '描述', '联系人', '010-9099090', '89998889', '北京海淀', 'jsda.jpg', '/imgs/webimgs/market1.gif', '/imgs/webimgs/market1.gif', '/imgs/webimgs/market1.gif', 'origjg.img', 0.9, 12, 1, 1, 1, 0, 1, '2012-08-22 00:00:00', '2012-08-22 08:50:59'),
('96883b04795f38d0a70b1f9004c1f987', '93483b04795f48d0a70b1f9004c1f98f', 'g064a2fee9bb11e1b4b000fff2ed3093', 'BBS充电合金四通道遥控飞机模型 遥控直升机直升机航模儿', 1, 100.56, '描述', '联系人', '010-9099090', '89998889', '北京海淀', 'jsda.jpg', '/imgs/webimgs/market2.gif', '/imgs/webimgs/market2.gif', '/imgs/webimgs/market2.gif', 'origjg.img', 0.9, 12, 1, 1, 1,0, 1, '2012-08-22 00:00:00', '2012-08-22 08:50:59'),
('96883b04795f38d0a70b1f9004c1f986', '93483b04795f48d0a70b1f9004c1f98f', 'h064a2fee9bb11e1b4b000fff2ed3093', 'BBS充电合金四通道遥控飞机模型 遥控直升机直升机航模儿', 1, 100.56, '描述', '联系人', '010-9099090', '89998889', '北京海淀', 'jsda.jpg', '/imgs/webimgs/market3.gif', '/imgs/webimgs/market3.gif', '/imgs/webimgs/market3.gif', 'origjg.img', 0.9, 12, 1, 1, 1, 0, 1, '2012-08-22 00:00:00', '2012-08-22 08:50:59'),
('96883b04795f38d0a70b1f9004c1f985', '93483b04795f48d0a70b1f9004c1f98f', 'i064a2fee9bb11e1b4b000fff2ed3093', 'BBS充电合金四通道遥控飞机模型 遥控直升机直升机航模儿', 1, 100.56, '描述', '联系人', '010-9099090', '89998889', '北京海淀', 'jsda.jpg', '/imgs/webimgs/market4.gif', '/imgs/webimgs/market4.gif', '/imgs/webimgs/market4.gif', 'origjg.img', 0.9, 12, 1, 1, 1, 0, 1, '2012-08-22 00:00:00', '2012-08-22 08:50:59'),
('96883b04795f38d0a70b1f9004c1f984', '93483b04795f48d0a70b1f9004c1f98f', 'j064a2fee9bb11e1b4b000fff2ed3093', 'BBS充电合金四通道遥控飞机模型 遥控直升机直升机航模儿', 1, 100.56, '描述', '联系人', '010-9099090', '89998889', '北京海淀', 'jsda.jpg', '/imgs/webimgs/market5.gif', '/imgs/webimgs/market5.gif', '/imgs/webimgs/market5.gif', 'origjg.img', 0.9, 12, 1, 1, 1, 0, 1, '2012-08-22 00:00:00', '2012-08-22 08:50:59'),
('86883b04795f38d0a70b1f9004c1f989', '93483b04795f48d0a70b1f9004c1f98f', 'd064a2fee9bb11e1b4b000fff2ed3093', '王五', 1, 100.56, '描述', '联系人', '010-9099090', '89998889', '北京海淀', 'jsda.jpg', 'jsda.jpg', 'jsda.jpg', 'img.png', 'origjg.img', 0.9, 12, 0, 0, 1, 1, 1, '2012-08-22 00:00:00', '2012-08-22 08:50:59');





