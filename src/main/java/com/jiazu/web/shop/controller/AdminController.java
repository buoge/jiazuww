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
 * Create at: 2012-11-11 下午9:17:31
 * ============================================================================
 */
package com.jiazu.web.shop.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jiazu.global.constants.EContent;
import com.jiazu.global.constants.MsgConstant;
import com.jiazu.global.constants.ViewKeyConstant;
import com.jiazu.global.utility.FileUtil;
import com.jiazu.global.utility.StrUtil;
import com.jiazu.web.platform.proxy.ContentPX;
import com.jiazu.web.shop.entity.Admin;
import com.jiazu.web.shop.entity.Content;
import com.jiazu.web.shop.proxy.AdminPX;

/**
 * @author Architect.bian
 *
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String get(Map<String, Object> model) {
		return "adminlogin";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {
		return "adminindex";
	}
	
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu(Map<String, Object> model) {
		return "adminmenu";
	}
	
	@RequestMapping(value = "/doadmin", method = RequestMethod.GET)
	public String admin(Map<String, Object> model) {
		model.put(ViewKeyConstant.list, AdminPX.getList());
		return "doadmin";
	}
	
	@RequestMapping(value = "/doadmin", method = RequestMethod.POST)
	public String admin_add(Map<String, Object> model, Admin admin) {
		if(AdminPX.add(admin)) {
			model.put(ViewKeyConstant.msg, MsgConstant.addSuccess);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.addFailed);
		}
		return admin(model);
	}
	
	@RequestMapping(value = "/doadmin/{uid:.{32}}", method = RequestMethod.GET, params="do=del")
	public String admin_delete(Map<String, Object> model, @PathVariable String uid) {
		if(AdminPX.delete(uid)) {
			model.put(ViewKeyConstant.msg, MsgConstant.deleteSuccess);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.deleteFailed);
		}
		return admin(model);
	}

	@RequestMapping(value = "/donotice", method = RequestMethod.GET)
	public String notice(Map<String, Object> model) {
		model.put(ViewKeyConstant.list, ContentPX.getNotices());
		return "donotice";
	}
	
	@RequestMapping(value = "/donotice", method = RequestMethod.POST)
	public String notice_add(Map<String, Object> model, String title, String sortorder) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Content content = new Content(title);
		content.setType(EContent.notice);
		content.setAdminuid(auth.getName());
		if (StringUtils.isNumeric(sortorder)) {
			content.setSortorder(Integer.valueOf(sortorder));
		}
		if(ContentPX.add(content)) {
			model.put(ViewKeyConstant.msg, MsgConstant.addSuccess);
		} else {
			model.put(ViewKeyConstant.alertmsg, MsgConstant.addFailed);
		}
		return notice(model);
	}
	
	@RequestMapping(value = "/donotice/{id:\\d+}", method = RequestMethod.GET, params="do=del")
	public String notice_delete(Map<String, Object> model, @PathVariable String id) {
		if(ContentPX.delete(Integer.valueOf(id))) {
			model.put(ViewKeyConstant.msg, MsgConstant.deleteSuccess);
		} else {
			model.put(ViewKeyConstant.alertmsg, MsgConstant.deleteFailed);
		}
		return notice(model);
	}
	
	@RequestMapping(value = "/dohotsearch", method = RequestMethod.GET)
	public String hotsearch(Map<String, Object> model) {
		model.put(ViewKeyConstant.list, ContentPX.getHotSearch());
		return "dohotsearch";
	}
	
	@RequestMapping(value = "/dohotsearch", method = RequestMethod.POST)
	public String hotsearch_add(Map<String, Object> model, String title, String originurl, String sortorder) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Content content = new Content(title);
		content.setType(EContent.hotsearch);
		content.setOriginurl(originurl);
		content.setAdminuid(auth.getName());
		if (StringUtils.isNumeric(sortorder)) {
			content.setSortorder(Integer.valueOf(sortorder));
		}
		if(ContentPX.add(content)) {
			model.put(ViewKeyConstant.msg, MsgConstant.addSuccess);
		} else {
			model.put(ViewKeyConstant.alertmsg, MsgConstant.addFailed);
		}
		return hotsearch(model);
	}
	
	@RequestMapping(value = "/dohotsearch/{id:\\d+}", method = RequestMethod.GET, params="do=del")
	public String hotsearch_delete(Map<String, Object> model, @PathVariable String id) {
		if(ContentPX.delete(Integer.valueOf(id))) {
			model.put(ViewKeyConstant.msg, MsgConstant.deleteSuccess);
		} else {
			model.put(ViewKeyConstant.alertmsg, MsgConstant.deleteFailed);
		}
		return hotsearch(model);
	}
	
	@RequestMapping(value = "/dofriendlink", method = RequestMethod.GET)
	public String friendlink(Map<String, Object> model) {
		model.put(ViewKeyConstant.imgFriendLinks, ContentPX.getImgFriendLinks());
		model.put(ViewKeyConstant.txtFriendLinks, ContentPX.getTxtFriendLinks());
		return "dofriendlink";
	}
	
	@RequestMapping(value = "/dofriendlink", method = RequestMethod.POST)
	public String friendlink_add(Map<String, Object> model, Content content, @RequestParam MultipartFile file) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (file.getSize() > 0) {
			String[] paths = FileUtil.resizeImage(file, 120, 60);
			content.setTitleimg(paths[1]);
			content.setType(EContent.friendLink_img);
		} else {
			content.setType(EContent.friendLink_txt);
		}
		content.setAdminuid(auth.getName());
		if(ContentPX.add(content)) {
			model.put(ViewKeyConstant.msg, MsgConstant.addSuccess);
		} else {
			model.put(ViewKeyConstant.alertmsg, MsgConstant.addFailed);
		}
		return friendlink(model);
	}
	
	@RequestMapping(value = "/dofriendlink/{id:\\d+}", method = RequestMethod.GET, params="do=del")
	public String friendlink_delete(Map<String, Object> model, @PathVariable String id) {
		if(ContentPX.delete(Integer.valueOf(id))) {
			model.put(ViewKeyConstant.msg, MsgConstant.deleteSuccess);
		} else {
			model.put(ViewKeyConstant.alertmsg, MsgConstant.deleteFailed);
		}
		return friendlink(model);
	}
	

	@RequestMapping(value = "/dobanner", method = RequestMethod.GET)
	public String dobanner(Map<String, Object> model) {
		model.put(ViewKeyConstant.list, ContentPX.getBannerList());
		return "dobanner";
	}
	
	@RequestMapping(value = "/dobanner", method = RequestMethod.POST)
	public String dobanner_add(Map<String, Object> model, Content content, @RequestParam MultipartFile file) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (file.getSize() > 0) {
			String[] paths = FileUtil.resizeImage(file, 90, 50);
			content.setOriginalimg(paths[0]);
			content.setTitleimg(paths[1]);
			content.setType(EContent.banner);
		}
		content.setAdminuid(auth.getName());
		if(ContentPX.add(content)) {
			model.put(ViewKeyConstant.msg, MsgConstant.addSuccess);
		} else {
			model.put(ViewKeyConstant.alertmsg, MsgConstant.addFailed);
		}
		return dobanner(model);
	}
	
	@RequestMapping(value = "/dobanner/{id:\\d+}", method = RequestMethod.GET, params="do=del")
	public String dobanner_delete(Map<String, Object> model, @PathVariable String id) {
		if(ContentPX.delete(Integer.valueOf(id))) {
			model.put(ViewKeyConstant.msg, MsgConstant.deleteSuccess);
		} else {
			model.put(ViewKeyConstant.alertmsg, MsgConstant.deleteFailed);
		}
		return dobanner(model);
	}

	@RequestMapping(value = "/dologo", method = RequestMethod.GET)
	public String dologo(Map<String, Object> model) {
		List<Content> list = ContentPX.getLogoList();
		model.put(ViewKeyConstant.list, list);
		if (list.size() > 0) {
			model.put(ViewKeyConstant.ID, list.get(0).getOid());
		}
		return "dologo";
	}
	
	@RequestMapping(value = "/dologo", method = RequestMethod.POST)
	public String dologo_update(Map<String, Object> model, Content content, String id, @RequestParam MultipartFile file) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (file.getSize() > 0) {
			String[] paths = FileUtil.resizeImage(file, 120, 90);
			content.setOriginalimg(paths[0]);
			content.setTitleimg(paths[1]);
			content.setType(EContent.logo);
		}
		content.setAdminuid(auth.getName());
		boolean flag = false;
		if (StringUtils.isNotEmpty(id) && StrUtil.isNumeric(id)) {
			content.setOid(Integer.valueOf(id));
			flag = ContentPX.update(content);
		} else {
			flag = ContentPX.add(content);
		}
		if(flag) {
			model.put(ViewKeyConstant.msg, MsgConstant.addSuccess);
		} else {
			model.put(ViewKeyConstant.alertmsg, MsgConstant.addFailed);
		}
		return dologo(model);
	}

	@RequestMapping(value = "/dologo/{id:\\d+}", method = RequestMethod.GET, params="do=del")
	public String dologo_delete(Map<String, Object> model, @PathVariable String id) {
		if(ContentPX.delete(Integer.valueOf(id))) {
			model.put(ViewKeyConstant.msg, MsgConstant.deleteSuccess);
		} else {
			model.put(ViewKeyConstant.alertmsg, MsgConstant.deleteFailed);
		}
		return dologo(model);
	}
}
