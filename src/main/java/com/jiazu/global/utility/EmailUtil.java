/**
 * 邮件发送工具类
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
 * Create at: 2012-8-5 上午10:46:21
 * ============================================================================
 */
package com.jiazu.global.utility;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import com.jiazu.global.constants.SysConf;

/**
 * @author Architect.bian
 *
 */
public class EmailUtil {

	/**
	 * @param email
	 * @param title
	 * @param msg
	 * @return
	 */
	public static boolean send(String toaddr, String title, String msg) {
		try {
			HtmlEmail email = new HtmlEmail();
			//smtp host 
			email.setHostName(SysConf.EmailHost);
			//登陆邮件服务器的用户名和密码
			email.setAuthentication(SysConf.EmailHostName,SysConf.EmailHostPwd);
			//接收人
			email.addTo(toaddr);
			//发送人
			email.setFrom(SysConf.EmailHostEmailAddr, SysConf.WebSiteName);
			//设置主题的字符集为UTF-8            
	        email.setCharset("UTF-8");
			//标题
			email.setSubject(title);
			//邮件内容
			email.setHtmlMsg(msg);
			//添加附件
//			email.attach();
			email.send();
			return true;
		} catch (EmailException e) {
			e.printStackTrace();
			return false;
		}
	}

}
