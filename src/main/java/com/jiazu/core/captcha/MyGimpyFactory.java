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
 * Create at: 2012-9-30 下午5:54:02
 * ============================================================================
 */
package com.jiazu.core.captcha;

import java.awt.image.BufferedImage;
import java.util.Locale;

import com.jiazu.core.servlets.ImageCaptchaServlet;
import com.octo.captcha.CaptchaException;
import com.octo.captcha.CaptchaQuestionHelper;
import com.octo.captcha.component.image.wordtoimage.WordToImage;
import com.octo.captcha.component.word.wordgenerator.WordGenerator;
import com.octo.captcha.image.ImageCaptcha;
import com.octo.captcha.image.gimpy.Gimpy;
import com.octo.captcha.image.gimpy.GimpyFactory;

/**
 * @author Architect.bian
 *
 */
public class MyGimpyFactory extends GimpyFactory {

	/**
	 * @param generator
	 * @param word2image
	 */
	public MyGimpyFactory(WordGenerator generator, WordToImage word2image) {
		super(generator, word2image);
	}

	public ImageCaptcha getImageCaptcha(Locale locale) {
		Integer wordLength = getRandomLength();

		String word = getWordGenerator().getWord(wordLength, locale);
		
		ImageCaptchaServlet.GeneratedCaptchaWord.replace(0, ImageCaptchaServlet.GeneratedCaptchaWord.length(), word);
//		System.out.println(word);

		BufferedImage image = null;
		try {
			image = getWordToImage().getImage(word);
		} catch (Throwable e) {
			throw new CaptchaException(e);
		}

		ImageCaptcha captcha = new MyGimpy(CaptchaQuestionHelper.getQuestion(locale, BUNDLE_QUESTION_KEY), image, word);

		return captcha;
	}
}
