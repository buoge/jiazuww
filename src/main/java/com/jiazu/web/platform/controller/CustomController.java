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
 * Create at: 2012-9-2 下午2:30:13
 * ============================================================================
 */
package com.jiazu.web.platform.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jiazu.global.constants.MsgConstant;
import com.jiazu.global.constants.SysConf;
import com.jiazu.global.constants.ViewKeyConstant;
import com.jiazu.global.utility.FileUtil;
import com.jiazu.web.base.controller.BaseController;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.platform.entity.Comment;
import com.jiazu.web.platform.entity.Gallery;
import com.jiazu.web.platform.entity.User;
import com.jiazu.web.platform.proxy.CommentPX;
import com.jiazu.web.platform.proxy.CustomPX;
import com.jiazu.web.platform.proxy.SysPX;

/**
 * @author Architect.bian
 *
 */
@Controller
public class CustomController extends BaseController {

	@RequestMapping(value = "/custom", method = RequestMethod.GET)
	public String index(Map<String, Object> model, String num) {
		Pager pager = Pager.getNewInstance(num, 20);
		List<Gallery> list = CustomPX.getList(pager);
		pager.refresh(list);
		model.put(ViewKeyConstant.pager, pager);
		List<Gallery> toplist = CustomPX.getTop(8);
		model.put(ViewKeyConstant.topCustoms, toplist);
		list.removeAll(toplist);
		model.put(ViewKeyConstant.customList, list);
		return "custom";
	}
	
	@RequestMapping("/custom/{uid}")
	public String show(@PathVariable String uid, Map<String, Object> model, HttpServletRequest request) {
		CustomPX.increaseClickCount(uid);
		Pager pager = Pager.getNewInstance(request.getParameter("num"), 6);
		Gallery custom = CustomPX.get(uid);
		List<Comment> list = CommentPX.getList(custom.getUid(), pager);
		pager.refresh(list);
		custom.setComments(list);
		model.put(ViewKeyConstant.bean, custom);
		model.put(ViewKeyConstant.pager, pager);
		return "customuid";
	}

	@RequestMapping(value="/myhome/{uid:.{32}}/custom", method = RequestMethod.GET)
	public String mycustom(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
//		System.out.println(uid);
		Pager pager = Pager.getNewInstance(request.getParameter("num"), 12);
		List<Gallery> list = CustomPX.getList(uid, pager);
		model.put(ViewKeyConstant.customList, list);
		pager.refresh(list);
		model.put(ViewKeyConstant.pager, pager);
		return "mycustom";
	}
	
	@RequestMapping(value="/myhome/{uid:.{32}}/custom", method = RequestMethod.POST)
	public String mycustom(Map<String, Object> model, @PathVariable String uid, Gallery gallery, @RequestParam MultipartFile file, HttpServletRequest request) {
		User u = getCurrUser(request);
		if (validate(model, gallery)) {
			if (file.getSize() > 0) {
				int[][] sizes = {{600,2000}, {220,180}, {180,150}, {90,60}};
				String[] paths = FileUtil.resizeImage(file, sizes);
				gallery.setOriginal(paths[0]);
				gallery.setImg(paths[1]);
				gallery.setBigthumb(paths[2]);
				gallery.setThumb(paths[3]);
				gallery.setLittlethumb(paths[4]);
				gallery.setGroupuid(uid);
				if (CustomPX.add(gallery)) {
					SysPX.addJiazuNews(u.getName(), u.getAvatar(), SysConf.format_jiazunews_customadd, "");
					model.put(ViewKeyConstant.msg, MsgConstant.uploadSuccess);
				} else {
					model.put(ViewKeyConstant.msg, MsgConstant.uploadFailed);
				}
			} else {
				model.put(ViewKeyConstant.msg, String.format(MsgConstant.err_cannotbeemptyArgs, "文件"));
			}
		}
		return mycustom(model, uid, request);
	}

	@RequestMapping(value="/myhome/{cuid:.{32}}/custom/{uid:.{32}}/del", method = RequestMethod.GET)
	public @ResponseBody boolean mycustom_del(Map<String, Object> model, @PathVariable String uid) {
		return CustomPX.delete(uid);
	}
	
	/**
	 * @param model
	 * @param gallery
	 * @return
	 */
	private boolean validate(Map<String, Object> model, Gallery gallery) {
		if (StringUtils.isEmpty(gallery.getTitle())) {
			model.put(ViewKeyConstant.msg, String.format(MsgConstant.err_cannotbeemptyArgs, "名称"));
			return false;
		}
		return true;
	}
	
	@RequestMapping(value="/admin/docustom", method = RequestMethod.GET)
	public String docustom(Map<String, Object> model) {
		model.put(ViewKeyConstant.topCustoms, CustomPX.getTopList());
		model.put(ViewKeyConstant.customList, CustomPX.getList(new Pager()));
		return "docustom";
	}

	@RequestMapping(value="/admin/docustom/{uid:.{32}}/del", method = RequestMethod.GET)
	public @ResponseBody boolean docustom_delete(Map<String, Object> model, @PathVariable String uid) {
		return CustomPX.delete(uid);
	}
	
	@RequestMapping(value="/admin/docustom/{uid:.{32}}/top", method = RequestMethod.GET)
	public String docustom_top(Map<String, Object> model, @PathVariable String uid) {
		if (CustomPX.setTop(uid, true)) {
			model.put(ViewKeyConstant.msg, MsgConstant.setSuccess);
		} else {
			model.put(ViewKeyConstant.alertmsg, MsgConstant.setFailed);
		}
		return docustom(model);
	}
	
	@RequestMapping(value="/admin/docustom/{uid:.{32}}/topcancel", method = RequestMethod.GET)
	public String docustom_topcancel(Map<String, Object> model, @PathVariable String uid) {
		if (CustomPX.setTop(uid, false)) {
			model.put(ViewKeyConstant.msg, MsgConstant.setSuccess);
		} else {
			model.put(ViewKeyConstant.alertmsg, MsgConstant.setFailed);
		}
		return docustom(model);
	}
}
