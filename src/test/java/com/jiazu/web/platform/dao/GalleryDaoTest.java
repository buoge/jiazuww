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
 * Create at: 2012-8-19 下午9:05:16
 * ============================================================================
 */
package com.jiazu.web.platform.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jiazu.global.constants.MapperConstant;
import com.jiazu.global.constants.TestConstants;
import com.jiazu.global.utility.GlobalUtil;
import com.jiazu.web.platform.entity.Gallery;

/**
 * @author Architect.bian
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/applicationContext**.xml" })
public class GalleryDaoTest {
	
	@Autowired
	GalleryDao dao;
	
	@Autowired
	Gallery gallery;

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#get(java.lang.String)}.
	 */
	@Test
	public void testGet() {
		gallery = dao.get(TestConstants.uidpk);
		assertNotNull(gallery);
		assertEquals(TestConstants.uid, gallery.getUseruid());
		assertEquals(TestConstants.uidpk, gallery.getUid());
		assertEquals(TestConstants.uidpk2, gallery.getGroupuid());
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
		gallery.setUid(uid);
		gallery.setUseruid(TestConstants.uidpk2);
		gallery.setGroupuid(GlobalUtil.getUUID());
		gallery.setLittlethumb("thumb.jpg");
		gallery.setThumb("thumb.jpg");
		gallery.setBigthumb("thumb.jpg");
		gallery.setImg("img,,,sp");
		gallery.setOriginal("");
		gallery.setSortorder(23);
		gallery.setTitle("mytitle");
		dao.insert(gallery);
		assertNotNull(dao.get(uid));
		dao.delete(uid);
		assertNull(dao.get(uid));
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#update(java.lang.Object)}.
	 */
	@Test
	public void testUpdate() {
		gallery = dao.get(TestConstants.uidpk);
		gallery.setIstop(false);
		dao.update(gallery);
		assertFalse(dao.get(TestConstants.uidpk).istop());
	}

	/**
	 * Test method for {@link com.jiazu.web.base.dao.BaseDao#updateFields(java.util.Map)}.
	 */
	@Test
	public void testUpdateFields() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(MapperConstant.UID, TestConstants.uidpk);
		map.put(MapperConstant.istop, true);
		dao.updateFields(map);
		assertTrue(dao.get(TestConstants.uidpk).istop());
	}

}
