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
 * Create at: 2012-8-27 上午7:58:49
 * ============================================================================
 */
package com.jiazu.web.base.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.jiazu.core.cache.rule.SessionRule;
import com.jiazu.global.constants.EStatus;
import com.jiazu.global.constants.GlobalConstant;
import com.jiazu.global.constants.MapperConstant;
import com.jiazu.global.constants.SessConstant;
import com.jiazu.global.constants.SysConf;
import com.jiazu.global.constants.ValidConstant;
import com.jiazu.global.constants.ViewKeyConstant;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.platform.entity.User;

/**
 * @author Architect.bian
 *
 */
public class BaseController {// extends ParameterizableViewController

	protected static final String prefixRedirect = "redirect:";

	/**
	 * 
	 * @param result
	 * @param model
	 */
	protected void validateErrors(BindingResult result, Map<String, String> errs) {
		List<FieldError> fes = result.getFieldErrors();
		for (FieldError fe : fes) {
			String k = fe.getField();
			String v = errs.get(k);
			String[] strs = StringUtils.splitByWholeSeparator(v, ValidConstant.VALID_MSG_SPLITTER);
			strs = ArrayUtils.add(strs, fe.getDefaultMessage());
			v = StringUtils.join(strs, ValidConstant.VALID_MSG_SPLITTER);
			errs.put(k, v);
		}
	}

	/**
	 * 页面保留初始数据
	 * @param model
	 * @param params
	 */
	protected void cloneParamsToModel(Map<String, Object> model, Map<?, ?> params) {
		for (Object key : params.keySet()) {
			if (params.get(key).getClass().isArray()) {
				String[] arr = (String[])params.get(key);
				if (arr.length == 1) {
					model.put(key.toString(), arr[0]);
				} else {
					model.put(key.toString(), arr);
				}
			}
		}
	}

	/**
	 * @param request
	 * @return
	 */
	protected User getCurrUser(HttpServletRequest request) {
		User user = (User)request.getAttribute(ViewKeyConstant.me);
		return user;
	}
	
	protected Map<String, Object> getParamMap() {
		Map<String, Object> map = new HashMap<>();
		map.put(MapperConstant.ASCDESC, GlobalConstant.DESC);
		map.put(MapperConstant.STARTINDEX, 0);
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
	 * @param request
	 * @return
	 */
	protected String getCurrUserCacheKey(HttpServletRequest request) {
		return new SessionRule(request, SessConstant.USER, SysConf.Expire_UserSession).toString();
	}

}
