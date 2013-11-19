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
 * Create at: 2012-9-30 下午6:40:49
 * ============================================================================
 */
package com.jiazu.core.captcha;

import java.awt.image.BufferedImage;

import com.octo.captcha.image.ImageCaptcha;

/**
 * @author Architect.bian
 * 
 */
public class MyGimpy extends ImageCaptcha {
	private static final long serialVersionUID = 1L;
	
	private String response;

	/**
	 * @param question
	 * @param challenge
	 * @param response
	 */
	MyGimpy(String question, BufferedImage challenge, String response) {
		super(question, challenge);
		this.response = response;
	}

	public final Boolean validateResponse(Object response) {
		return (null != response) && ((response instanceof String)) ? validateResponse((String) response) : Boolean.FALSE;
	}

	private final Boolean validateResponse(String response) {
		return Boolean.valueOf(response.equals(this.response));
	}

}
