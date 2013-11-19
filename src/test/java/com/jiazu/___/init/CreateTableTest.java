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
public class CreateTableTest {

	@Autowired
	SqlSessionFactory sqlSessionFactory;

	@Autowired
	SqlSessionFactory sqlSessionFactoryShopDB;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void createUserDB() throws Exception {
		logger.info("-----------invoking method: createUserDB");
		InputStream userdbStream = ClassLoader.getSystemResourceAsStream("DataBase/Schema/UserDB.sql");
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
	public void createShopDB() throws IOException {
		logger.info("-----------invoking method: createShopDB");
		InputStream shopdbStream = ClassLoader.getSystemResourceAsStream("DataBase/Schema/ShopDB.sql");
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
	public void createTestDB() throws IOException {
		logger.info("-----------invoking method: createTestDB");
		InputStream shopdbStream = ClassLoader.getSystemResourceAsStream("DataBase/Schema/TestDB.sql");
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

	@Ignore
	public void jdbcTest() throws Exception {
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost/";
		String USER = "root";
		String PASS = "968";
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating database...");
			stmt = conn.createStatement();
			InputStream userdbStream = ClassLoader.getSystemResourceAsStream("DataBase/Schema/UserDB.sql");
			String sqlUserDB = IOUtils.toString(userdbStream);
			sqlUserDB = sqlUserDB.replaceAll("/\\*[\\s\\S]*?\\*/", "");// 去除注释
			String[] strs = StringUtils.split(sqlUserDB, ";");
			for (String sql : strs) {
				sql = sql.replaceAll("^[^\\w]*", "").trim();// 取出前面的空白
				if (!StringUtils.isEmpty(sql)) {
					stmt.executeUpdate(sql.trim());
				}
			}
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
		System.out.println("Goodbye!");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Ignore
	public void getDataTest() throws SQLException {
		logger.info("-----------begin to invoke method: getDataTest");
		QueryRunner runner = new QueryRunner();
		ResultSetHandler rsh = new MapListHandler();
		String strsql = "select * from t_idvalue";
		ArrayList<Object> result = (ArrayList<Object>) runner.query(sqlSessionFactoryShopDB.openSession()
				.getConnection(), strsql, rsh);
		for (int i = 0; i < result.size(); i++) {
			Map<String, String> map = (Map<String, String>) result.get(i);
			logger.info(map.toString());
		}
	}
}
