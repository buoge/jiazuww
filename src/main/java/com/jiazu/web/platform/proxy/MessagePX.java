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
 * Create at: 2012-9-16 下午3:02:12
 * ============================================================================
 */
package com.jiazu.web.platform.proxy;

import java.util.List;

import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.base.proxy.BasePX;
import com.jiazu.web.platform.entity.Message;
import com.jiazu.web.platform.service.MessageSO;

/**
 * @author Architect.bian
 *
 */
public class MessagePX extends BasePX {
	/**
	 * @param string
	 * @param pager
	 * @return
	 */
	public static List<Message> getList(String useruid, Pager pager) {
		MessageSO so = (MessageSO)spring.getBean(MessageSO.class);
		return so.getList(useruid, pager);
	}
	
	/**
	 * @param string
	 * @return
	 */
	public static int getNewMsgCount(String useruid) {
		List<String> list;
		try {
			list = SysPX.getUnreadMsgList_StatisticsUser(useruid);
			if (list == null) {
				return 0;
			} else {
				return list.size();
			}
		} catch (Exception e) {
			e.printStackTrace();
			//TODO 记录日志
			return - 1;
		}
	}

	/**
	 * @param uid
	 * @param select
	 * @param uid2
	 * @param title
	 * @param msg
	 * @return
	 */
	public static boolean send(String groupuid, String[] touids, String fromuid, String title, String msg) {
		MessageSO so = (MessageSO)spring.getBean(MessageSO.class);
		return so.send(groupuid, touids, fromuid, title, msg);
	}

	/**
	 * @param uid
	 * @return
	 */
	public static boolean delete(String uid) {
		MessageSO so = (MessageSO)spring.getBean(MessageSO.class);
		return so.delete(uid);
	}

}
