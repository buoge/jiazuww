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
 * Create at: 2012-9-30 下午6:01:22
 * ============================================================================
 */
package com.jiazu.global.constants;

import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Architect.bian
 *
 */
@Component
public class SysConf extends BaseConstant {
	
	public static String WebSiteUrl;
	
	public static final int maxSizeLatestJiazu = 9;

	public static final double ShippingFee = 15;

	public static final int searchResultTextCount = 100;

	public static final String Separator_Directory = "/";

	public static final String format_eduhref = "/edu/%s/%s";

	public static final String format_eventhref = "/event/%s";

	public static final String format_b2chref = "/b2c/%s";

	public static final String format_c2chref = "/c2c/%s";

	public static final String role_admin = "ROLE_ADMIN";

	public static final String format_error_deleteimg = "图像文件:%s删除失败";

	public static final int SessionIDLength = 6;

	public static final String format_jiazunews_customadd = "我在风土人情上传了几张照片";

	public static final String format_jiazunews_educationadd = "我发表了一篇家族教育相关的文章";

	public static final String format_jiazunews_eventadd = "我公布了一条家族大事记";

	public static final String format_jiazunews_c2cadd = "互通有无，互通天下";

	public static final String format_jiazunews_wishadd = "我给我的家族成员写了条祝福";

	public static final String format_jiazunews_jiazucreate = "我创建了一个家族，快来看看吧";

	public static final String format_jiazunews_jiazulogo = "我修改了我们家族的族徽";

	public static final String format_jiazunews_jiazubrief = "我修改了我们家族的族训";

	public static final String format_zupunews_updatelogo = "更换了新族徽";

	public static final String format_zupunews_addmember = "添加了新成员";

	public static final String format_zupunews_updatebrief = "修改了家族族训";

	public static final String format_zupunews_updatehistory = "修改了家族渊源";

	public static final String format_zupunews_create = "新成立了一个家族";

	// 随机生成的字符组成
	public static String CaptchaRandomWordGenerator = "0123456789";

	// 验证码图片上显示的字符个数
	public static int CaptchaMinTextSize = 4;
	public static int CaptchaMaxTextSize = 4;

	// 验证码图片上显示的字符的大小设置
	public static int CaptchaMinFontSize = 15;
	public static int CaptchaMaxFontSize = 18;

	public static int CaptchaImgWidth = 100;
	public static int CaptchaImgHeight = 30;
	
	public static String UserImgUploadPath = "";
	public static String UserImgBasePath = "";
	public static String UserImgDirPath = "";
	
	public static Properties sysProps;

	public static int Expire_UserSession = -1;

	public static String EmailResetTitle;

	public static String EmailValidateTitle;

	public static String EmailHost;

	public static String EmailHostName;

	public static String EmailHostPwd;

	public static String EmailHostEmailAddr;

	public static String WebSiteName;

	public static String EmailValidateUrlFormat;

	public static String SerialPath;

	public static String alipay_partner;
	public static String alipay_key;
	public static String alipay_seller_email;
	public static String alipay_notify_url;
	public static String alipay_return_url;
	public static String alipay_log_path;

	@Value("#{sys}")
	public void setSysConf(Properties sys) {
		SysConf.WebSiteUrl = sys.getProperty("WebSiteUrl");
		SysConf.CaptchaRandomWordGenerator = sys.getProperty("CaptchaRandomWordGenerator");
		SysConf.CaptchaMinTextSize = Integer.valueOf(sys.getProperty("CaptchaMinTextLen"));
		SysConf.CaptchaMaxTextSize = Integer.valueOf(sys.getProperty("CaptchaMaxTextLen"));
		SysConf.CaptchaMinFontSize = Integer.valueOf(sys.getProperty("CaptchaMinFontSize"));
		SysConf.CaptchaMaxFontSize = Integer.valueOf(sys.getProperty("CaptchaMaxFontSize"));
		SysConf.CaptchaImgWidth = Integer.valueOf(sys.getProperty("CaptchaImgWidth"));
		SysConf.CaptchaImgHeight = Integer.valueOf(sys.getProperty("CaptchaImgHeight"));
		SysConf.UserImgUploadPath = sys.getProperty("UserImgUploadPath");
		SysConf.UserImgBasePath = sys.getProperty("UserImgBasePath");
		SysConf.UserImgDirPath = StringUtils.replace(SysConf.UserImgUploadPath, SysConf.UserImgBasePath, "");
		SysConf.Expire_UserSession = Integer.valueOf(sys.getProperty("Expire_UserSession"));
		SysConf.EmailResetTitle = sys.getProperty("EmailResetTitle");
		SysConf.EmailValidateTitle = sys.getProperty("EmailValidateTitle");
		SysConf.EmailHost = sys.getProperty("EmailHost");
		SysConf.EmailHostName = sys.getProperty("EmailHostName");
		SysConf.EmailHostPwd = sys.getProperty("EmailHostPwd");
		SysConf.EmailHostEmailAddr = sys.getProperty("EmailHostEmailAddr");
		SysConf.WebSiteName = sys.getProperty("WebSiteName");
		SysConf.EmailValidateUrlFormat = sys.getProperty("EmailValidateUrlFormat");
		SysConf.SerialPath = sys.getProperty("SerialPath");
		SysConf.alipay_partner = sys.getProperty("alipay_partner");
		SysConf.alipay_key = sys.getProperty("alipay_key");
		SysConf.alipay_seller_email = sys.getProperty("alipay_seller_email");
		SysConf.alipay_notify_url = sys.getProperty("alipay_notify_url");
		SysConf.alipay_return_url = sys.getProperty("alipay_return_url");
		SysConf.alipay_log_path = sys.getProperty("alipay_log_path");
		SysConf.sysProps = sys;
	}
}
