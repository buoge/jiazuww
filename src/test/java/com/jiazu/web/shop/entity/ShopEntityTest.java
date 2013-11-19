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
 * Create at: 2012-8-18 上午9:35:29
 * ============================================================================
 */
package com.jiazu.web.shop.entity;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jiazu.global.constants.TestConstants;

/**
 * @author Architect.bian
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:**/applicationContext**.xml"})
public class ShopEntityTest {

	@Autowired
	ApplicationContext context;
	
	@Autowired
	Address address;
	
	@Autowired
	Admin admin;
	
	@Autowired
	B2C b2c;
	
	@Autowired
	C2C c2c;
	
	@Autowired
	Cart cart;
	
	@Autowired
	Content content;
	
	@Autowired
	Gallery gallery;
	
	@Autowired
	Order order;
	
	@Test
	public void testAddress() {
		String addr = "北京海淀上地";
		address.setAddress(addr);
		String city = "北京";
		address.setCity(city);
		String province = "北京";
		address.setProvince(province);
		String district = "上地";
		address.setDistrict(district);
		String email = "verygreat@126.com";
		address.setEmail(email);
		String mobile = "010-110";
		address.setMobile(mobile);
		String tel = "15300128809";
		address.setTel(tel);
		assertEquals(addr, address.getAddress());
		assertEquals(city, address.getCity());
		assertEquals(province, address.getProvince());
		assertEquals(district, address.getDistrict());
		assertEquals(email, address.getEmail());
		assertEquals(mobile, address.getMobile());
		assertEquals(tel, address.getTel());
	}
	
	@Test
	public void testAdmin() {
		String email = "verygreat@126.com";
		admin.setEmail(email );
		admin.setPassword(TestConstants.pwd_123456);
		assertEquals(email, admin.getEmail());
		assertEquals(TestConstants.pwd_123456, admin.getPassword());
	}
	
	@Test
	public void testB2C() {
		String sn = "sn00012";
		b2c.setSn(sn);
		String name = "尼康D90";
		b2c.setName(name);
		boolean isbest = true;
		b2c.setIsbest(isbest);
		int clickcount = 12989328;
		b2c.setClickcount(clickcount);
		String desc = "尼康D90描述";
		b2c.setDesc(desc);
		String catuid = TestConstants.uid;
		b2c.setCatuid(catuid);
		double marketprice = 200.89;
		b2c.setMarketprice(marketprice);
		double rate = 5.4;
		b2c.setRate(rate);
		double weight = 1.6;
		b2c.setWeight(weight);
		assertEquals(sn, b2c.getSn());
		assertEquals(name, b2c.getName());
		assertEquals(isbest, b2c.isbest());
		assertEquals(clickcount, b2c.getClickcount());
		assertEquals(desc, b2c.getDesc());
		assertEquals(catuid, b2c.getCatuid());
		assertTrue(marketprice == b2c.getMarketprice());
		assertTrue(rate == b2c.getRate());
		assertTrue(weight == b2c.getWeight());
	}
	
	@Test
	public void testC2C() {
		String addr = "被奶牛关";
		c2c.setAddress(addr);
		String img = "htt/sdkfkdimg.jpg";
		c2c.setImg(img);
		String contactname = "张三";
		c2c.setContactname(contactname);
		boolean isbest = false;
		c2c.setIsbest(isbest);
		String name = "GPs导航仪";
		c2c.setName(name);
		double newrate = 2.3;
		c2c.setNewrate(newrate);
		int sortorder = 1222;
		c2c.setSortorder(sortorder);
		String thumb = "thjuummb";
		c2c.setThumb(thumb);
		assertEquals(addr, c2c.getAddress());
		assertEquals(img, c2c.getImg());
		assertEquals(contactname, c2c.getContactname());
		assertEquals(isbest, c2c.isbest());
		assertEquals(name, c2c.getName());
		assertTrue(newrate == c2c.getNewrate());
		assertEquals(sortorder, c2c.getSortorder());
		assertEquals(thumb, c2c.getThumb());
	}
	
	@Test
	public void testCart() {
		cart.setB2cuid(TestConstants.uid);
		int number = 33;
		cart.setNumber(number);
		assertEquals(TestConstants.uid, cart.getB2cuid());
		assertEquals(number, cart.getNumber());
	}
	
	@Test
	public void testContent() {
		String author = "里斯";
		content.setAuthor(author);
		int commentsday = 30;
		content.setCommentsday(commentsday);
		String adminuid = TestConstants.uid;
		content.setAdminuid(adminuid);
		String strcontent = "内容.....";
		content.setContent(strcontent);
		String origin = "origin......";
		content.setOrigin(origin);
		int upsday = 10;
		content.setUpsday(upsday);
		assertEquals(author, content.getAuthor());
		assertEquals(commentsday, content.getCommentsday());
		assertEquals(adminuid, content.getAdminuid());
		assertEquals(strcontent, content.getContent());
		assertEquals(origin, content.getOrigin());
		assertEquals(upsday, content.getUpsday());
	}
	
	@Test
	public void testGallery() {
		String img = "flasjfie";
		gallery.setImg(img);
		String original = "orgingln";
		gallery.setOriginal(original);
		String thumb = "thumbdlakdkkf";
		gallery.setThumb(thumb);
		boolean isdefault = false;
		gallery.setIsdefault(isdefault);
		assertEquals(img, gallery.getImg());
		assertEquals(original, gallery.getOriginal());
		assertEquals(thumb, gallery.getThumb());
		assertEquals(isdefault, gallery.isdefault());
	}
	
	@Test
	public void testOrder() {
		String addr = "addresss........";
		order.setAddress(addr);
		String city = "被奶牛";
		order.setCity(city);
		String memo = "备注";
		order.setMemo(memo);
		String sn = "sn00023903";
		order.setOrdersn(sn);
		String payid = "payid...we99";
		order.setPayid(payid);
		assertEquals(addr, order.getAddress());
		assertEquals(city, order.getCity());
		assertEquals(memo, order.getMemo());
		assertEquals(sn, order.getOrdersn());
		assertEquals(payid, order.getPayid());
	}

}
