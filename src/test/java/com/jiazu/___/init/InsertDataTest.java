/**
 * 初始化数据库
 * ============================================================================
 * 声明：北京旺族互联网科技有限公司版权所有
 * ----------------------------------------------------------------------------
 * Official Website: http://www.jiazuww.com
 * ----------------------------------------------------------------------------
 * Copyright: ? 2012 JiaZuWW All Rights Reserved.
 * ----------------------------------------------------------------------------
 * @version: 1.0
 * ----------------------------------------------------------------------------
 * @author: Greatbsky
 * ----------------------------------------------------------------------------
 * @email: verygreat@126.com
 * ----------------------------------------------------------------------------
 * Create at: 2012-8-6 下午1:36:06
 * ============================================================================
 */
package com.jiazu.___.init;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jiazu.global.constants.SysConstant;

/**
 * @author GreatHost
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/applicationContext**.xml" })
public class InsertDataTest {

	@Autowired
	SqlSessionFactory sqlSessionFactory;

	@Autowired
	SqlSessionFactory sqlSessionFactoryShopDB;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void insertUserData() throws Exception {
		logger.info("-----------invoking method: insertUserDB");
		InputStream userdbStream = ClassLoader.getSystemResourceAsStream("DataBase/InitData/UserDB.sql");
		String sqlUserDB = IOUtils.toString(userdbStream, SysConstant.UTF8);
//		logger.info("-----------response sql text:" + sqlUserDB);
		Connection conn = null;
		try {
			sqlUserDB = sqlUserDB.replaceAll("/\\*[\\s\\S]*?\\*/", "");
			String[] strs = StringUtils.split(sqlUserDB, ';');
			conn = sqlSessionFactory.openSession().getConnection();
			for (String sql : strs) {
				sql = sql.replaceAll("^[^\\w]*", "").trim();// 去除前面的空白及特殊字符
				if (!StringUtils.isEmpty(sql)) {
					QueryRunner runner = new QueryRunner();
					runner.update(conn, sql);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(conn);
		}
		
	}
	
	@Test
	public void insertUserTestData() throws Exception {
		logger.info("-----------invoking method: insertUserTestData");
		InputStream userdbStream = ClassLoader.getSystemResourceAsStream("DataBase/InitData/UserDB_Test.sql");
		String sqlUserDB = IOUtils.toString(userdbStream, SysConstant.UTF8);
//		logger.info("-----------response sql text:" + sqlUserDB);
		Connection conn = null;
		try {
			sqlUserDB = sqlUserDB.replaceAll("/\\*[\\s\\S]*?\\*/", "");
			String[] strs = StringUtils.split(sqlUserDB, ';');
			conn = sqlSessionFactory.openSession().getConnection();
			for (String sql : strs) {
				sql = sql.replaceAll("^[^\\w]*", "").trim();// 去除前面的空白及特殊字符
				if (!StringUtils.isEmpty(sql)) {
					QueryRunner runner = new QueryRunner();
					runner.update(conn, sql);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(conn);
		}
		
	}
	
	@Test
	public void insertDataShopData() throws IOException {
		logger.info("-----------invoking method: insertDataShopDB");
		InputStream shopdbStream = ClassLoader.getSystemResourceAsStream("DataBase/InitData/ShopDB.sql");
		String sqlShopDB = IOUtils.toString(shopdbStream, SysConstant.UTF8);
		Connection conn = null;
		try {
			sqlShopDB = sqlShopDB.replaceAll("/\\*[\\s\\S]*?\\*/", "");
			String[] strs = StringUtils.split(sqlShopDB, ';');
			conn = sqlSessionFactoryShopDB.openSession().getConnection();
			for (String sql : strs) {
				sql = sql.replaceAll("^[^\\w]*", "").trim();// 去除前面的空白及特殊字符
				if (!StringUtils.isEmpty(sql)) {
					QueryRunner runner = new QueryRunner();
					runner.update(conn, sql);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(conn);
		}
	}
	
	@Test
	public void insertDataShopTestData() throws IOException {
		logger.info("-----------invoking method: insertDataShopTestData");
		InputStream shopdbStream = ClassLoader.getSystemResourceAsStream("DataBase/InitData/ShopDB_Test.sql");
		String sqlShopDB = IOUtils.toString(shopdbStream, SysConstant.UTF8);
		Connection conn = null;
		try {
			sqlShopDB = sqlShopDB.replaceAll("/\\*[\\s\\S]*?\\*/", "");
			String[] strs = StringUtils.split(sqlShopDB, ';');
			conn = sqlSessionFactoryShopDB.openSession().getConnection();
			for (String sql : strs) {
				sql = sql.replaceAll("^[^\\w]*", "").trim();// 去除前面的空白及特殊字符
				if (!StringUtils.isEmpty(sql)) {
					QueryRunner runner = new QueryRunner();
					runner.update(conn, sql);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(conn);
		}
	}
	
	@Test
	public void insertTestData() throws IOException {
		logger.info("-----------invoking method: insertTestDB");
		InputStream shopdbStream = ClassLoader.getSystemResourceAsStream("DataBase/InitData/TestDB.sql");
		String sqlTestDB = IOUtils.toString(shopdbStream, SysConstant.UTF8);
		Connection conn = null;
		try {
			sqlTestDB = sqlTestDB.replaceAll("/\\*[\\s\\S]*?\\*/", "");
			String[] strs = StringUtils.split(sqlTestDB, ';');
			conn = sqlSessionFactoryShopDB.openSession().getConnection();
			for (String sql : strs) {
				sql = sql.replaceAll("^[^\\w]*", "").trim();// 去除前面的空白及特殊字符
				if (!StringUtils.isEmpty(sql)) {
					QueryRunner runner = new QueryRunner();
					runner.update(conn, sql);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(conn);
		}
	}
}
