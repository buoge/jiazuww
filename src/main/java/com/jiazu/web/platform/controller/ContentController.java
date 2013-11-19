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
 * Create at: 2012-11-15 上午7:43:45
 * ============================================================================
 */
package com.jiazu.web.platform.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jiazu.global.constants.EContent;
import com.jiazu.global.constants.MsgConstant;
import com.jiazu.global.constants.ViewKeyConstant;
import com.jiazu.web.base.controller.BaseController;
import com.jiazu.web.platform.proxy.ContentPX;

/**
 * @author Architect.bian
 *
 */
@Controller
public class ContentController extends BaseController {
	
	@RequestMapping(value="/aboutus", method = RequestMethod.GET)
	public String aboutus(Map<String, Object> model, HttpServletRequest request) {
		model.put(ViewKeyConstant.bean, ContentPX.getOneByType(EContent.aboutus));
		model.put(ViewKeyConstant.title, EContent.getName(EContent.aboutus));
		return "aboutus";
	}
	
	@RequestMapping(value="/charge", method = RequestMethod.GET)
	public String charge(Map<String, Object> model, HttpServletRequest request) {
		model.put(ViewKeyConstant.bean, ContentPX.getOneByType(EContent.charge));
		model.put(ViewKeyConstant.title, EContent.getName(EContent.charge));
		return "aboutus";
	}
	
	@RequestMapping(value="/service", method = RequestMethod.GET)
	public String service(Map<String, Object> model, HttpServletRequest request) {
		model.put(ViewKeyConstant.bean, ContentPX.getOneByType(EContent.service));
		model.put(ViewKeyConstant.title, EContent.getName(EContent.service));
		return "aboutus";
	}
	
	@RequestMapping(value="/hr", method = RequestMethod.GET)
	public String hr(Map<String, Object> model, HttpServletRequest request) {
		model.put(ViewKeyConstant.bean, ContentPX.getOneByType(EContent.hr));
		model.put(ViewKeyConstant.title, EContent.getName(EContent.hr));
		return "aboutus";
	}
	
	@RequestMapping(value="/legal", method = RequestMethod.GET)
	public String legal(Map<String, Object> model, HttpServletRequest request) {
		model.put(ViewKeyConstant.bean, ContentPX.getOneByType(EContent.legal));
		model.put(ViewKeyConstant.title, EContent.getName(EContent.legal));
		return "aboutus";
	}
	
	@RequestMapping(value="/help", method = RequestMethod.GET)
	public String help(Map<String, Object> model, HttpServletRequest request) {
		model.put(ViewKeyConstant.bean, ContentPX.getOneByType(EContent.help));
		model.put(ViewKeyConstant.title, EContent.getName(EContent.help));
		return "aboutus";
	}
	
	@RequestMapping(value="/admin/content/{type:\\d+}", method = RequestMethod.GET)
	public String docontent(Map<String, Object> model, @PathVariable String type) {
		if (StringUtils.isNumeric(type)) {
			EContent e = EContent.get(Integer.valueOf(type));
			model.put(ViewKeyConstant.bean, ContentPX.getOneByType(e));
			model.put(ViewKeyConstant.title, EContent.getName(e));
			model.put(ViewKeyConstant.type, type);
		}
		return "docontent";
	}
	
	@RequestMapping(value="/admin/content/{type:\\d+}", method = RequestMethod.POST)
	public String docontent_save(Map<String, Object> model, @PathVariable String type, String id, String content) {
		if (ContentPX.updateContent(id, content)) {
			model.put(ViewKeyConstant.msg, MsgConstant.editSuccess);
		} else {
			model.put(ViewKeyConstant.alertmsg, MsgConstant.editFailed);
		}
		return docontent(model, type);
	}
	
	@RequestMapping(value="/admin/content/dozupu", method = RequestMethod.GET)
	public String dozupu(Map<String, Object> model) {
		model.put(ViewKeyConstant.bean, ContentPX.getZupuIntroduce());
		return "dozupu";
	}
	
	@RequestMapping(value="/admin/content/dozupu", method = RequestMethod.POST)
	public String dozupu_save(Map<String, Object> model, String id, String content) {
		if (ContentPX.updateContent(id, content)) {
			model.put(ViewKeyConstant.msg, MsgConstant.editSuccess);
		} else {
			model.put(ViewKeyConstant.alertmsg, MsgConstant.editFailed);
		}
		return dozupu(model);
	}
	
}
