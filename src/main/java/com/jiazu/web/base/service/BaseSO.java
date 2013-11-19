/**
 * 所有service层的基类
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
 * Create at: 2012-8-10 上午7:29:43
 * ============================================================================
 */
package com.jiazu.web.base.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jiazu.global.constants.EStatus;
import com.jiazu.global.constants.GlobalConstant;
import com.jiazu.global.constants.MapperConstant;
import com.jiazu.global.constants.ViewKeyConstant;
import com.jiazu.web.base.entity.Pager;

/**
 * @author Architect.bian
 *
 */
public class BaseSO {

	protected Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * @param e
	 */
	protected void logException(Exception e) {
		String error = StringUtils.isNotEmpty(e.getMessage()) ? e.getMessage() : e.toString();
		log.error(error);
	}

	/**
	 * @return
	 */
	protected Map<String, Object> getParamMap() {
		Map<String, Object> map = new HashMap<>();
		map.put(MapperConstant.ASCDESC, GlobalConstant.DESC);
		map.put(MapperConstant.STARTINDEX, 0);
		map.put(MapperConstant.status, EStatus.enable);
		return map;
	}

	/**
	 * @param pager
	 * @return
	 */
	protected Map<String, Object> getParamMap(Pager pager) {
		Map<String, Object> map = getParamMap();
		map.put(ViewKeyConstant.startIndex, pager.getStartIndex());
		map.put(MapperConstant.PAGESIZE, pager.getPageSize());
		return map;
	}
	
	/**
	 * @param top
	 * @return
	 */
	protected Map<String, Object> getParamMap(int top) {
		Map<String, Object> map = getParamMap();
		map.put(MapperConstant.PAGESIZE, top);
		return map;
	}
}
