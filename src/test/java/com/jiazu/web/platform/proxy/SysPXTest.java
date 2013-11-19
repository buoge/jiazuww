package com.jiazu.web.platform.proxy;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jiazu.web.platform.entity.News;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/applicationContext**.xml" })
public class SysPXTest {

	@Test
	public final void testGetJiaZuNews() throws Exception {
		SysPX.addJiazuNews("华夏我哈", "/imgs/default/defaulthead.jpg", "今日整理网站的 CSS 的时候发现我的网站在 Firefox下面出现了变形的情况,这个时候我急啊.", "");
		SysPX.addJiazuNews("华夏我哈", "/imgs/default/defaulthead.jpg", "今日整理网站的 CSS 的时候发现我的网站在 Firefox下面出现了变形的情况,这个时候我急啊.", "");
		List<News> list = SysPX.getJiaZuNews();
		assertTrue(list.size() > 1);
	}

	@Test
	public final void testAddJiaZuNews() throws Exception {
		SysPX.addJiazuNews("华夏我哈", "/imgs/default/defaulthead.jpg", "今日整理网站的 CSS 的时候发现我的网站在 Firefox下面出现了变形的情况,这个时候我急啊.", "");
		assertTrue(SysPX.getJiaZuNews().size() > 0);
	}

}
