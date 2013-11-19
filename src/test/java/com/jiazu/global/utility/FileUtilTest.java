/**
 * 文件操作测试类
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
 * Create at: 2012-8-6 下午3:53:35
 * ============================================================================
 */
package com.jiazu.global.utility;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.io.IOUtils;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author GreatHost
 *
 */
public class FileUtilTest {
	
	@Test
	@Ignore
	public void nameTest() {
//		ResourceBundle resource = ResourceBundle.getBundle("DataBase.Schema.ShopDB.sql");
		URL path = Thread.currentThread().getContextClassLoader().getResource("DataBase/Schema/ShopDB.sql");
		System.out.println(path.toString());
		URL path2 = ClassLoader.getSystemResource("DataBase/Schema/ShopDB.sql");//use this method
		System.out.println(path2);
	}

	@Test
	@Ignore
	public void readSqlTest() throws MalformedURLException, IOException {
		InputStream userdbStream = ClassLoader.getSystemResourceAsStream("DataBase/Schema/ShopDB.sql");
		try {
			System.out.println(IOUtils.toString(userdbStream));
		} catch (Exception e) {
			
		} finally {
			IOUtils.closeQuietly(userdbStream);
		}
	}

}
