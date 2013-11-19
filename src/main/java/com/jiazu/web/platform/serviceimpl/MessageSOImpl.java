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
 * Create at: 2012-10-27 下午9:30:09
 * ============================================================================
 */
package com.jiazu.web.platform.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiazu.global.constants.EMsg;
import com.jiazu.global.constants.MapperConstant;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.base.service.BaseSO;
import com.jiazu.web.platform.dao.MsgDao;
import com.jiazu.web.platform.entity.Message;
import com.jiazu.web.platform.proxy.UserPX;
import com.jiazu.web.platform.service.MessageSO;

/**
 * @author Architect.bian
 *
 */
@Service
public class MessageSOImpl extends BaseSO implements MessageSO {

	@Autowired
	private MsgDao dao;
	
	@Override
	public boolean send(String groupuid, String[] touids, String fromuid, String title, String msg) {
		try {
			for (String useruid : touids) {
				Message m = new Message();
				m.setUseruid(useruid);
				m.setUseruidfrom(fromuid);
				m.setTitle(title);
				m.setMsg(msg);
				m.setType(EMsg.other);
				dao.insert(m);
			}
			return true;
		} catch (Exception e) {
			logException(e);
		}
		return false;
	}

	@Override
	public List<Message> getList(String useruid, Pager pager) {
		try {
			Map<String, Object> map = getParamMap(pager);
			map.put(MapperConstant.useruid, useruid);
			List<Message> list = dao.getList(map);
			for (Message msg : list) {
				msg.setUser(UserPX.getUser(msg.getUseruidfrom()));
			}
			return list;
		} catch (Exception e) {
			logException(e);
			return null;
		}
	}

	@Override
	public boolean delete(String uid) {
		try {
			dao.delete(uid);
			return true;
		} catch (Exception e) {
			logException(e);
			return false;
		}
	}

}
