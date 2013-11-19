/**
 * 
 * ============================================================================
 * 声明：北京旺族互联网科技有限公司版权所有
 * ----------------------------------------------------------------------------
 * Official Website: http://www.jiazuww.com
 * ----------------------------------------------------------------------------
 * Copyright: © 2012 JiaZuWW All Rights Reserved.
 * ----------------------------------------------------------------------------
 * @version: 1.0
 * ----------------------------------------------------------------------------
 * @author: Architect.bian
 * ----------------------------------------------------------------------------
 * Create at: 2012-8-17 上午8:41:58
 * ============================================================================
 */
package com.jiazu.web.platform.entity;

import static org.junit.Assert.*;

import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jiazu.global.constants.EGender;
import com.jiazu.global.constants.EOrderLogType;
import com.jiazu.global.constants.EStatus;
import com.jiazu.global.constants.TestConstants;
import com.jiazu.global.utility.StrUtil;

/**
 * @author Architect.bian
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/applicationContext**.xml" })
public class PlatformEntityTest {

	@Autowired
	ApplicationContext context;

	@Autowired
	AccountLog accountLog;

	@Autowired
	Comment comments;

	@Autowired
	Education education;

	@Autowired
	Event events;

	@Autowired
	Gallery gallery;

	@Autowired
	Jiazu jiazu;

	@Autowired
	ZupuMember memeber;

	@Autowired
	Message message;

	@Autowired
	OrderLog orderLog;

	@Autowired
	Sacrifice sacrifice;

	@Autowired
	Wish wish;

	@Test
	public void testAccountLog() {
		accountLog = new AccountLog();
		assertTrue(0 == accountLog.getAccount());
		double money = 100.367;
		accountLog.setAccount(money);
		assertTrue(money == accountLog.getAccount());
		System.out.println(accountLog.getCreateTime());
	}

	@Test
	public void testComment() {
		comments.setStatus(EStatus.enable);
		assertEquals(EStatus.enable, comments.getStatus());
		comments = new Comment();
		String cmt = "skasdkjfjf";
		comments.setComment(cmt);
		assertNotNull(comments.getStatus());
		assertEquals(cmt, comments.getComment());
	}

	@Test
	public void testEducation() {
		education.setUid(TestConstants.uid);
		boolean isrecommend = true;
		education.setIsrecommend(isrecommend);
		String toid = StrUtil.getRandomString(3);
		education.setToid(toid);
		assertEquals(TestConstants.uid, education.getUid());
		assertEquals(isrecommend, isrecommend);
		assertEquals(toid, education.getToid());
	}

	@Test
	public void testEvent() {
		String content = "asdjfifjeiwoidni203efewq8ejf8";
		events.setContent(content);
		events.setUseruid(TestConstants.uid);
		int commentcount = 6;
		for (int i = 0; i < commentcount; i++) {
			Comment c = new Comment();
			events.getComments().add(c);
		}
		assertEquals(commentcount, events.getCommentcount());
		assertEquals(content, events.getContent());
		assertEquals(TestConstants.uid, events.getUseruid());
	}

	@Test
	public void testGallery() {
		String img = "sdfkj23/d";
		gallery.setImg(img);
		String original = "http://sdlf/origint";
		gallery.setOriginal(original);
		int sortorder = 123322;
		gallery.setSortorder(sortorder);
		assertEquals(img, gallery.getImg());
		assertEquals(original, gallery.getOriginal());
		assertEquals(sortorder, gallery.getSortorder());
	}

	@Test
	public void testJiazu() {
		String brief = "breaiflsalkdf族训";
		jiazu.setBrief(brief);
		String desc = "渊源塑料袋口就覅恩";
		jiazu.setDesc(desc);
		String owner = "小胖";
		jiazu.setOwner(owner);
		String logooriginal = "aslkdhtt/dsfimgoright";
		jiazu.setLogooriginal(logooriginal);
		assertEquals(brief, jiazu.getBrief());
		assertEquals(desc, jiazu.getDesc());
		assertEquals(logooriginal, jiazu.getLogooriginal());
	}

	@Test
	public void testMemeber() {
		String avatar = "avatalllllldfio";
		memeber.setAvatar(avatar);
		LocalDate birthday = new LocalDate();
		memeber.setBirthday(birthday.toString());
		memeber.setGender(EGender.Lady);
		int level = 12;
		memeber.setLevel(level);
		memeber.setStatus(EStatus.enable);
		String realname = "张刚";
		memeber.setRealname(realname);
		assertEquals(avatar, memeber.getAvatar());
		assertEquals(birthday.toString(), memeber.getBirthday());
		assertEquals(EGender.Lady, memeber.getGender());
		assertEquals(level, memeber.getLevel());
		assertEquals(EStatus.enable, memeber.getStatus());
		assertEquals(realname, memeber.getRealname());
	}

	@Test
	public void testMessage() {
		String msg = "msgsdlkjfiwef";
		message.setMsg(msg);
		String title = "titilellsadnkf";
		message.setTitle(title);
		assertEquals(msg, message.getMsg());
		assertEquals(title, message.getTitle());
		assertEquals(null, message.getType());
	}

	@Test
	public void testOrderLog() {
		orderLog.setLogtype(EOrderLogType.submitted);
		String doaction = "订单日志操作记录";
		orderLog.setDoaction(doaction);
		orderLog.setOrderuid(TestConstants.uid);
		assertEquals(EOrderLogType.submitted, orderLog.getLogtype());
		assertEquals(doaction, orderLog.getDoaction());
		assertEquals(TestConstants.uid, orderLog.getOrderuid());
	}

	@Test
	public void testSacrifice() {
		assertNotNull(sacrifice);
	}
}
