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
 * Create at: 2012-10-7 下午3:55:33
 * ============================================================================
 */
package com.jiazu.core.image;

import java.io.IOException;

import org.im4java.core.IM4JavaException;

/**
 * @author Architect.bian
 *
 */
public interface ImageEngine {

	/**
	 * @param width
	 * @param height
	 * @param files
	 * @return 处理后的文件列表
	 * @throws IM4JavaException 
	 * @throws InterruptedException 
	 * @throws Exception 
	 */
	String[] resizeImages(int width, int height, String... files) throws Exception;

}
