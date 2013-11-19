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
 * Create at: 2012-8-22 上午7:06:58
 * ============================================================================
 */
package com.jiazu.web.shop.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jiazu.global.constants.EOrder;
import com.jiazu.global.constants.EPay;
import com.jiazu.global.constants.EShipping;
import com.jiazu.global.constants.MapperConstant;
import com.jiazu.global.constants.TestConstants;
import com.jiazu.global.utility.GlobalUtil;
import com.jiazu.global.utility.StrUtil;
import com.jiazu.web.shop.entity.Order;

/**
 * @author Architect.bian
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/applicationContext**.xml" })
public class OrderDaoTest {

	@Autowired
	OrderDao dao;
	
	@Autowired
	Order entity;
	
	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#get(java.lang.String)}.
	 */
	@Test
	public void testGet() {
		entity = dao.get(TestConstants.uidpk);
		assertNotNull(entity);
		assertEquals(TestConstants.uid, entity.getUseruid());
		assertEquals("f2ed3093", entity.getOrdersn());
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#getOne(java.util.Map)}.
	 */
	@Test
	public void testGetOne() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.useruid, TestConstants.uid);
		assertNotNull(dao.getOne(map));
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#getList(java.util.Map)}.
	 */
	@Test
	public void testGetList() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.useruid, TestConstants.uid);
		assertTrue(dao.getList(map).size() > 0);
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#insert(java.lang.Object)}.
	 */
	@Test
	public void testInsert() {
		String uid = GlobalUtil.getUUID();
		entity.setUid(uid);
		entity.setUseruid(TestConstants.uid);
		String ordersn = StrUtil.getRandomString(3);
		entity.setOrdersn(ordersn );
		entity.setTotalamount(3);
		entity.setUnitprice(33.243);
		entity.setTotalprice(223.67);
		entity.setShippingid("asddddffe");
		entity.setPostscript("快递备注");
		entity.setShippingfee(10.01);
		entity.setShipping_name("顺风");
		entity.setConsignee("收件人");
		entity.setProvince("1");
		entity.setCity("102");
		entity.setDistrict("23");
		entity.setAddress("北京海淀");
		entity.setZipcode("100089");
		entity.setTel("1224443334");
		entity.setEmail("ads@sasd.com");
		entity.setOrderstatus(EOrder.payed);
		entity.setShippingstatus(EShipping.packaged);
		entity.setPaystatus(EPay.init);
		entity.setPayid("alipay id");
		entity.setPayname("支付人姓名");
		dao.insert(entity);
		assertNotNull(dao.get(uid));
		dao.delete(uid);
		assertNull(dao.get(uid));
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#update(java.lang.Object)}.
	 */
	@Test
	public void testUpdate() {
		entity = dao.get(TestConstants.uidpk);
		entity.setPaystatus(EPay.payed);
		dao.update(entity);
		assertEquals(EPay.payed, dao.get(TestConstants.uidpk).getPaystatus());
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#updateFields(java.util.Map)}.
	 */
	@Test
	public void testUpdateFields() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.UID, TestConstants.uidpk);
		map.put(MapperConstant.paystatus, EPay.payed);
		dao.updateFields(map);
		assertEquals(EPay.payed, dao.get(TestConstants.uidpk).getPaystatus());
	}

}
