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
 * Create at: 2012-9-30 下午5:42:32
 * ============================================================================
 */
package com.jiazu.core.captcha;

import java.awt.Font;

import com.jiazu.global.constants.SysConf;
import com.octo.captcha.component.image.backgroundgenerator.BackgroundGenerator;
import com.octo.captcha.component.image.backgroundgenerator.FunkyBackgroundGenerator;
import com.octo.captcha.component.image.color.RandomRangeColorGenerator;
import com.octo.captcha.component.image.fontgenerator.FontGenerator;
import com.octo.captcha.component.image.fontgenerator.RandomFontGenerator;
import com.octo.captcha.component.image.textpaster.RandomTextPaster;
import com.octo.captcha.component.image.textpaster.TextPaster;
import com.octo.captcha.component.image.wordtoimage.ComposedWordToImage;
import com.octo.captcha.component.image.wordtoimage.WordToImage;
import com.octo.captcha.component.word.wordgenerator.RandomWordGenerator;
import com.octo.captcha.component.word.wordgenerator.WordGenerator;
import com.octo.captcha.engine.image.ListImageCaptchaEngine;

/**
 * @author Architect.bian
 * 
 */
public class MyImageCaptchaEngine extends ListImageCaptchaEngine {

	@Override
	protected void buildInitialFactories() {
		WordGenerator wgen = new RandomWordGenerator(SysConf.CaptchaRandomWordGenerator);  
        RandomRangeColorGenerator cgen = new RandomRangeColorGenerator(new int[] {0, 100}, new int[] {0, 100}, new int[] {0, 100});
        TextPaster textPaster = new RandomTextPaster(new Integer(SysConf.CaptchaMinTextSize), new Integer(SysConf.CaptchaMaxTextSize), cgen, true);  
        
        BackgroundGenerator backgroundGenerator = new FunkyBackgroundGenerator(new Integer(SysConf.CaptchaImgWidth), new Integer(SysConf.CaptchaImgHeight));  

        Font[] fontsList = new Font[] {new Font("Arial", 0, SysConf.CaptchaMinFontSize), new Font("Tahoma", 0, SysConf.CaptchaMinFontSize), new Font("Verdana", 0, SysConf.CaptchaMinFontSize)};  

        FontGenerator fontGenerator = new RandomFontGenerator(SysConf.CaptchaMinFontSize, SysConf.CaptchaMaxFontSize, fontsList);
  
         WordToImage wordToImage = new ComposedWordToImage(fontGenerator, backgroundGenerator, textPaster);
         this.addFactory(new MyGimpyFactory(wgen, wordToImage));
	}

}
