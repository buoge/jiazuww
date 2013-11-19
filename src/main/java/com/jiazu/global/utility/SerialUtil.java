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
 * Create at: 2012-12-8 上午9:05:20
 * ============================================================================
 */
package com.jiazu.global.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.util.SerializationUtils;

import com.jiazu.global.constants.SysConf;

/**
 * @author Architect.bian
 * 
 */
public class SerialUtil {

	/**
	 * @param f
	 */
	public static boolean Serialize(Object obj, String fullpath) {
		byte[] data = SerializationUtils.serialize(obj);
		File file = new File(fullpath);
		try {
			FileUtils.writeByteArrayToFile(file, data);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param uid
	 * @return
	 */
	public static Object Deserialize(String uid, String parentpath) {
		File file = new File(parentpath + SysConf.Separator_Directory + uid);
		try {
			if (file.exists()) {
				return SerializationUtils.deserialize(FileUtils.readFileToByteArray(file));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
