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
 * Create at: 2012-9-28 下午2:37:55
 * ============================================================================
 */
package com.jiazu.web.platform.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jiazu.global.constants.ViewKeyConstant;
import com.jiazu.web.base.controller.BaseController;
import com.jiazu.web.platform.proxy.ContentPX;

/**
 * @author Architect.bian
 *
 */
@Controller
@RequestMapping("/rule")
public class RuleController extends BaseController {

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Map<String, Object> model) {
		model.put(ViewKeyConstant.bean, ContentPX.getRegisterRule());
		return "rule";
	}
}
