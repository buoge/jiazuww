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
 * Create at: 2012-9-30 下午3:54:50
 * ============================================================================
 */
package com.jiazu.core.captcha;

import com.octo.captcha.service.captchastore.FastHashMapCaptchaStore;
import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;
import com.octo.captcha.service.image.ImageCaptchaService;

/**
 * @author Architect.bian
 *
 */
public class CaptchaServiceSingleton {
	
	private static ImageCaptchaService instance = new DefaultManageableImageCaptchaService();
	
	static {
		instance = new DefaultManageableImageCaptchaService(new FastHashMapCaptchaStore(), new MyImageCaptchaEngine(), 180, 100000, 75000);
	}
	 
    public static ImageCaptchaService getInstance(){
        return instance;
    }
}
