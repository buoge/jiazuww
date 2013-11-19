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
 * Create at: 2012-12-8 上午9:09:32
 * ============================================================================
 */
package com.jiazu.global.utility;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jiazu.global.constants.EStatus;
import com.jiazu.global.constants.SysConf;
import com.jiazu.web.platform.entity.Flower;
import com.jiazu.web.platform.entity.Jisi;
import com.jiazu.web.platform.entity.User;
import com.jiazu.web.platform.entity.ZupuMember;

/**
 * @author Architect.bian
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/applicationContext**.xml" })
public class SerialUtilTest {

	@Test
	public void testSerailAndUnSerial() {
		Jisi jisi = new Jisi();
		String uid = "default";
		jisi.setUid(uid);
		int candleDuration = 3*60;
		int senserDuration = 1*60;
		jisi.setCandleDucration(candleDuration);
		jisi.setCenserDuration(senserDuration);
		String music = "/imgs/jisi/music.mp3";
		jisi.setMusic(music);
		
		ZupuMember member = new ZupuMember();
		member.setUid(GlobalUtil.getUUID());
		member.setName("某某某");
		member.setAvatar("/imgs/jisi/avatar1.jpg");
		member.setIntroduce("我的生平简介。。。");
		member.setStatus(EStatus.disable);
		member.setName2("某某某");
		member.setAvatar2("/imgs/jisi/avatar2.jpg");
		member.setIntroduce2("我的生平简介。。。");
		member.setStatus2(EStatus.disable);
		jisi.setMember(member);
		
		String myname = "myname";
		User user = new User(myname);
		jisi.getViewers().add(user);
		jisi.getViewers().add(new User("myname2"));
		
		Flower f = new Flower();
		f.setUid(GlobalUtil.getUUID());
		String name = "mflower";
		f.setName(name);
		f.setPrice(1);
		f.setFree(true);
		f.setStatus(EStatus.enable);
		jisi.getFlowers().add(f);
		
		boolean flag = SerialUtil.Serialize(jisi, SysConf.SerialPath + SysConf.Separator_Directory + jisi.getUid());
		assertTrue(flag);
		jisi = (Jisi)SerialUtil.Deserialize(jisi.getUid(), SysConf.SerialPath);
		assertEquals(jisi.getUid(), uid);
		assertEquals(jisi.getCandleDucration(), candleDuration);
		assertEquals(jisi.getCenserDuration(), senserDuration);
		assertEquals(jisi.getMember(), member);
		assertEquals(jisi.getViewers().get(0), user);
		assertEquals(jisi.getViewers().get(0).getName(), myname);
		assertEquals(jisi.getFlowers().get(0), f);
		assertEquals(jisi.getFlowers().get(0).getName(), name);
		assertTrue(jisi.getFlowers().get(0).getPrice() == 1);
		assertTrue(jisi.getFlowers().get(0).isFree());
		assertEquals(jisi.getFlowers().get(0).getStatus(), EStatus.enable);
	}

}
