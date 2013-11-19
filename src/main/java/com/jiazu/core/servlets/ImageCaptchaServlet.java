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
 * Create at: 2012-9-30 下午3:57:23
 * ============================================================================
 */
package com.jiazu.core.servlets;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jiazu.core.cache.rule.SessionRule;
import com.jiazu.core.captcha.CaptchaServiceSingleton;
import com.jiazu.global.constants.SessConstant;
import com.jiazu.global.factory.SessionFactory;
import com.octo.captcha.service.CaptchaServiceException;
/**
 * @author Architect.bian
 * 
 */
public class ImageCaptchaServlet extends HttpServlet {
	private static final long serialVersionUID = -2320479472517505460L;

	public static final String CAPTCHA_IMAGE_FORMAT = "jpeg";
	public static StringBuffer GeneratedCaptchaWord = new StringBuffer();

	public void init(ServletConfig servletConfig) throws ServletException {
		super.init(servletConfig);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		byte[] captchaChallengeAsJpeg = null;
		// the output stream to render the captcha image as jpeg into
		ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
		try {
			// get the session id that will identify the generated captcha.
			// the same id must be used to validate the response, the session id
			// is a good candidate!
			HttpSession sess = SessionFactory.getHttpSession();
			String sessCaptchaKey = new SessionRule(req, SessConstant.CAPTCHA).toString();
			int i = 0;
			while (i++ < 10) {
				BufferedImage challenge;
				synchronized (GeneratedCaptchaWord) {//因使用到了GeneratedCaptchaWord 所以要同步
					// call the ImageCaptchaService getChallenge method
					challenge = CaptchaServiceSingleton.getInstance().getImageChallengeForID(sessCaptchaKey, req.getLocale());
					sess.setAttribute(sessCaptchaKey, GeneratedCaptchaWord.toString());
				}
				if (CaptchaServiceSingleton.getInstance().validateResponseForID(sessCaptchaKey, GeneratedCaptchaWord.toString())) {
					//System.out.println(GeneratedCaptchaWord);
					ImageIO.write(challenge, CAPTCHA_IMAGE_FORMAT, jpegOutputStream);
					break;
				}
			}
		} catch (IllegalArgumentException e) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		} catch (CaptchaServiceException e) {
			resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return;
		}

		captchaChallengeAsJpeg = jpegOutputStream.toByteArray();

		// flush it in the response
		resp.setHeader("Cache-Control", "no-store");
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Connection", "close");//TODO 不起作用
		resp.setDateHeader("Expires", 0);
		resp.setContentType("image/jpeg");
		resp.setContentLength(captchaChallengeAsJpeg.length);
		ServletOutputStream responseOutputStream = resp.getOutputStream();
		responseOutputStream.write(captchaChallengeAsJpeg);
		responseOutputStream.flush();
		responseOutputStream.close();
	}

}
