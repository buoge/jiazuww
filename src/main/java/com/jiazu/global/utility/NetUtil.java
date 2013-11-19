/**
 * 网络相关工具类
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
 * Create at: 2012-8-5 上午10:01:50
 * ============================================================================
 */
package com.jiazu.global.utility;

/**
 * @author Architect.bian
 *
 */
public class NetUtil {
	
//	public static boolean sendMail(String serverAddress, String user,
//			String pwd, String from, String emailReceiver, String subject,
//			String htmlContents) {
//
//		// 设置邮件的字符集，默认为 UTF-8
//		String emailSendCharsetString = null;
//		try {
//			emailSendCharsetString = SystemManager
//					.getValueByKey("email.send.charset");
//		} catch (Exception e) {
//			emailSendCharsetString = "";
//		}
//		if (StringUtil.isEmpty(emailSendCharsetString)) {
//			emailSendCharsetString = "UTF-8";
//		}
//
//		try {
//			// 创建Properties对象
//			Properties props = System.getProperties();
//			// 创建信件服务器
//			props.put("mail.smtp.auth", "true");
//			// 得到默认的对话对象
//			Session session = Session.getDefaultInstance(props, null);
//
//			// 创建一个消息，并初始化该消息的各项元素
//			Message msg = new MimeMessage(session);
//			msg.setFrom(new InternetAddress(from));
//			InternetAddress[] address = { new InternetAddress(emailReceiver) };
//			msg.setRecipients(Message.RecipientType.TO, address);
//			msg.setSubject(new String(subject.getBytes(),
//					emailSendCharsetString));
//
//			// 后面的BodyPart将加入到此处创建的Multipart中
//			Multipart mp = new MimeMultipart();
//			// 设置内容
//			BodyPart bp = new MimeBodyPart();
//			bp.setContent(htmlContents + getMailCorpright(),
//					"text/html;charset=" + emailSendCharsetString);
//			mp.addBodyPart(bp);
//			// Multipart加入到信件
//			msg.setContent(mp);
//			// 设置信件头的发送日期
//			msg.setSentDate(new Date());
//			msg.saveChanges();
//
//			// 发送信件
//			Transport trans = session.getTransport("smtp");
//			trans.connect(serverAddress, user, pwd);
//
//			if (trans.isConnected()) {
//				trans.sendMessage(msg, msg.getAllRecipients());
//				trans.close();
//				return true;
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//
//		return false;
//	}
//
//	/**
//	 * 只用传发送邮件地址与邮件标题，邮件内容就发送邮件。
//	 * 
//	 * @param emailReceiver
//	 * @param subject
//	 * @param htmlContents
//	 * @return
//	 */
//	public static boolean sendSmtpMail(String emailReceiver, String subject,
//			String htmlContents) {
//
//		try {
//			MailConfig mailconfig = SystemManager.getMailConfig(null);
//			if (mailconfig != null) {
//				// String subject = "";
//				String serverAddress = mailconfig.getSmtp_host();
//				String userName = mailconfig.getSmtp_user();
//				String pwd = mailconfig.getSmtp_password();
//				String from = mailconfig.getMail_from();
//				// 创建Properties对象
//				Properties props = System.getProperties();
//				// 创建信件服务器
//				props.put("mail.smtp.auth", "true");
//				// 得到默认的对话对象
//				Session session = Session.getDefaultInstance(props, null);
//
//				// 创建一个消息，并初始化该消息的各项元素
//				Message msg = new MimeMessage(session);
//				msg.setFrom(new InternetAddress(from));
//				InternetAddress[] address = { new InternetAddress(emailReceiver) };
//				msg.setRecipients(Message.RecipientType.TO, address);
//				msg.setSubject(MimeUtility.encodeText(subject, "GBK", "B"));
//
//				// 后面的BodyPart将加入到此处创建的Multipart中
//				Multipart mp = new MimeMultipart();
//				// 设置内容
//				BodyPart bp = new MimeBodyPart();
//				bp.setContent(htmlContents + getMailCorpright(),
//						"text/html;charset=gbk");
//				mp.addBodyPart(bp);
//				// Multipart加入到信件
//				msg.setContent(mp);
//				// 设置信件头的发送日期
//				msg.setSentDate(new Date());
//				msg.saveChanges();
//
//				// 发送信件
//				Transport trans = session.getTransport("smtp");
//				trans.connect(serverAddress, userName, pwd);
//
//				if (trans.isConnected()) {
//					trans.sendMessage(msg, msg.getAllRecipients());
//					trans.close();
//					return true;
//				}
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//
//		return false;
//	}
}
