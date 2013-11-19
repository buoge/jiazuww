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
 * Create at: 2012-9-2 下午2:16:16
 * ============================================================================
 */
package com.jiazu.web.shop.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jiazu.global.constants.EC2C;
import com.jiazu.global.constants.MapperConstant;
import com.jiazu.global.constants.MsgConstant;
import com.jiazu.global.constants.SysConf;
import com.jiazu.global.constants.ViewKeyConstant;
import com.jiazu.global.utility.ConvertUtil;
import com.jiazu.global.utility.FileUtil;
import com.jiazu.global.utility.StrUtil;
import com.jiazu.web.base.controller.BaseController;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.platform.entity.User;
import com.jiazu.web.platform.proxy.SysPX;
import com.jiazu.web.shop.entity.C2C;
import com.jiazu.web.shop.proxy.C2CPX;

/**
 * @author Architect.bian
 *
 */
@Controller
public class C2CController extends BaseController {
	
	@RequestMapping(value = "/c2c", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {
		model.put(ViewKeyConstant.onlineUsersCount, StringUtils.leftPad(String.valueOf(SysPX.getOnlineUsersCount()), 8, "0"));
		model.put(ViewKeyConstant.c2cTopList, C2CPX.getProdListTop(21));
		model.put(ViewKeyConstant.c2cProdList, C2CPX.getProdList(new Pager()));
		model.put(ViewKeyConstant.c2cCharityList, C2CPX.getCharityList(new Pager()));
		return "/c2c";
	}

	@RequestMapping(value="/c2c/{uid:.{32}}", method = RequestMethod.GET)
	public String showc2c(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		model.put(ViewKeyConstant.bean, C2CPX.get(uid));
		return "/c2cuid";
	}
	
	@RequestMapping(value="/c2c/{type:\\d+}", method = RequestMethod.GET)
	public String listc2c(Map<String, Object> model, @PathVariable String type, HttpServletRequest request, String num) {
		char[] arr = type.toCharArray();
		EC2C[] types = new EC2C[2];
		for (int i = 0; i < arr.length; i++) {
			String str = String.valueOf(arr[i]);
			types[i] = EC2C.get(Integer.valueOf(str));
		}
		Pager pager = Pager.getNewInstance(num, 20);
		List<C2C> list = C2CPX.getListByType(types, pager);
		pager.refresh(list);
		model.put(ViewKeyConstant.pager, pager);
		model.put(ViewKeyConstant.list, list);
		model.put(ViewKeyConstant.type, type);
		return "/c2clist";
	}

	@RequestMapping(value="/myhome/c2c", method = RequestMethod.GET)
	public String myc2c(Map<String, Object> model, HttpServletRequest request) {
		User user = (User)request.getAttribute(ViewKeyConstant.me);
		model.put(ViewKeyConstant.c2cList, C2CPX.getList(user.getUid(), new Pager()));
		model.put(ViewKeyConstant.c2cDisableList, C2CPX.getDisableList(user.getUid(), new Pager()));
		return "myc2c";
	}
	
	@RequestMapping(value="/myhome/c2c", method = RequestMethod.POST)
	public String myc2c(Map<String, Object> model, C2C c2c, HttpServletRequest request, @RequestParam MultipartFile file) {
		User user = (User)request.getAttribute(ViewKeyConstant.me);
		if (user != null) {
			c2c.setUseruid(user.getUid());
		} else {
			c2c.setUseruid("admin");
		}
		if (file != null && file.getSize() > 0) {
			int[][] sizes = {{800,800}, {160,160}, {124,124}, {100,100}};
			String[] paths = FileUtil.resizeImage(file, sizes);
			c2c.setOriginalimg(paths[0]);
			c2c.setImg(paths[1]);
			c2c.setBigthumb(paths[2]);
			c2c.setThumb(paths[3]);
			c2c.setLittlethumb(paths[4]);
		}
		if (C2CPX.create(c2c)) {
			if (user != null) {
				SysPX.addJiazuNews(user.getName(), user.getAvatar(), SysConf.format_jiazunews_c2cadd, "");
			}
			model.put(ViewKeyConstant.msg, String.format(MsgConstant.publishSuccessArgs, "互通有无"));
		} else {
			model.put(ViewKeyConstant.msg, String.format(MsgConstant.publishFailedArgs, "互通有无"));
		}
		if (user == null) {
			return null;
		}
		return myc2c(model, request);
	}

	@RequestMapping(value="/myhome/c2c/{uid:.{32}}/edit", method = RequestMethod.GET)
	public String myc2c_edit(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		User user = (User)request.getAttribute(ViewKeyConstant.me);
		model.put(ViewKeyConstant.editbean, C2CPX.get(uid));
		if (user == null) {
			return null;
		}
		return myc2c(model, request);
	}
	
	@RequestMapping(value="/myhome/c2c/{uid:.{32}}/edit", method = RequestMethod.POST)
	public String myc2c_edit(Map<String, Object> model, @PathVariable String uid, C2C c2c, HttpServletRequest request, @RequestParam MultipartFile file) {
		c2c.setUid(uid);
		if (file != null && file.getSize() > 0) {
			int[][] sizes = {{800,800}, {160,160}, {124,124}, {100,100}};
			String[] paths = FileUtil.resizeImage(file, sizes);
			FileUtil.deleteImg(c2c.getOriginalimg(), c2c.getImg(), c2c.getBigthumb(), c2c.getThumb(), c2c.getLittlethumb());
			c2c.setOriginalimg(paths[0]);
			c2c.setImg(paths[1]);
			c2c.setBigthumb(paths[2]);
			c2c.setThumb(paths[3]);
			c2c.setLittlethumb(paths[4]);
		}
		if (C2CPX.update(c2c)) {
			model.put(ViewKeyConstant.msg, String.format(MsgConstant.uploadSuccessArgs, "互通有无"));
		} else {
			model.put(ViewKeyConstant.msg, String.format(MsgConstant.uploadFailedArgs, "互通有无"));
		}
		User user = (User)request.getAttribute(ViewKeyConstant.me);
		if (user == null) {
			return null;
		}
		return myc2c(model, request);
	}
	
	@RequestMapping(value="/myhome/c2c/{uid:.{32}}/disable", method = RequestMethod.GET)
	public String myc2c_disable(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		if (C2CPX.updateStatus(uid, false)) {
			model.put(ViewKeyConstant.msg, MsgConstant.doSuccess);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.doFailed);
		}
		User user = (User)request.getAttribute(ViewKeyConstant.me);
		if (user == null) {
			return null;
		}
		return myc2c(model, request);
	}
	
	@RequestMapping(value="/myhome/c2c/{uid:.{32}}/del", method = RequestMethod.GET)
	public String myc2c_del(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		if (C2CPX.delete(uid)) {
			model.put(ViewKeyConstant.msg, MsgConstant.deleteSuccess);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.deleteFailed);
		}
		User user = (User)request.getAttribute(ViewKeyConstant.me);
		if (user == null) {
			return null;
		}
		return myc2c(model, request);
	}

	@RequestMapping(value="/admin/doc2c", method = RequestMethod.GET)
	public String doc2c(Map<String, Object> model, HttpServletRequest request) {
		Pager pager = Pager.getNewInstance(request.getParameter("num"), 20);
		model.put(ViewKeyConstant.c2cTopList, C2CPX.getTopList());
		List<C2C> list = C2CPX.getList(pager);
		model.put(ViewKeyConstant.c2cList, list);
		pager.refresh(list);
		model.put(ViewKeyConstant.pager, pager);
		return "doc2c";
	}
	

	@RequestMapping(value="/admin/doc2c", method = RequestMethod.POST)
	public String doc2c(Map<String, Object> model, C2C c2c, HttpServletRequest request, @RequestParam MultipartFile file) {
		myc2c(model, c2c, request, file);
		return doc2c(model, request);
	}

	@RequestMapping(value="/admin/doc2c/{uid:.{32}}/edit", method = RequestMethod.GET)
	public String doc2c_edit(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		myc2c_edit(model, uid, request);
		return doc2c(model, request);
	}
	
	@RequestMapping(value="/admin/doc2c/{doc2c:.{32}}/edit", method = RequestMethod.POST)
	public String doc2c_edit(Map<String, Object> model, @PathVariable String uid, C2C c2c, HttpServletRequest request, @RequestParam MultipartFile file) {
		myc2c_edit(model, uid, c2c, request, file);
		return doc2c(model, request);
	}
	
	@RequestMapping(value="/admin/doc2c/{uid:.{32}}/top", method = RequestMethod.GET)
	public String doc2c_top(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		if (C2CPX.setTop(uid, true)) {
			model.put(ViewKeyConstant.msg, MsgConstant.setSuccess);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.setFailed);
		}
		return doc2c(model, request);
	}
	
	@RequestMapping(value="/admin/doc2c/{uid:.{32}}/topcancel", method = RequestMethod.GET)
	public String doc2c_topcancel(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		if (C2CPX.setTop(uid, false)) {
			model.put(ViewKeyConstant.msg, MsgConstant.setSuccess);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.setFailed);
		}
		return doc2c(model, request);
	}
	
	@RequestMapping(value="/admin/doc2c/{uid:.{32}}/disable", method = RequestMethod.GET)
	public String doc2c_disable(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		if (C2CPX.updateStatus(uid, false)) {
			model.put(ViewKeyConstant.msg, MsgConstant.setSuccess);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.setFailed);
		}
		return doc2c(model, request);
	}
	
	@RequestMapping(value="/admin/doc2c/{uid:.{32}}/enable", method = RequestMethod.GET)
	public String doc2c_enable(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		if (C2CPX.updateStatus(uid, true)) {
			model.put(ViewKeyConstant.msg, MsgConstant.setSuccess);
		} else {
			model.put(ViewKeyConstant.alertmsg, MsgConstant.setFailed);
		}
		return doc2c(model, request);
	}
	
	@RequestMapping(value="/admin/doc2c/{uid:.{32}}/del", method = RequestMethod.GET)
	public String doc2c_del(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		myc2c_del(model, uid, request);
		return doc2c(model, request);
	}
	

	@RequestMapping(value = "/admin/doc2c/search", method = RequestMethod.GET)
	public String doc2c_search(Map<String, Object> model, String name, String contactname, String istop, String status, String type, String num) {
		Pager pager = Pager.getNewInstance(num, 20);
		Map<String, Object> map = getParamMap(pager);
		if (StringUtils.isNotEmpty(name)) {
			map.put(MapperConstant.name + MapperConstant.like, name.trim());
		}
		if (StringUtils.isNotEmpty(contactname)) {
			map.put(MapperConstant.contactname + MapperConstant.like, contactname.trim());
		}
		if (StrUtil.isNumeric(istop) && Integer.valueOf(istop) >= 0) {
			map.put(MapperConstant.istop, ConvertUtil.toBoolean(istop));
		}
		if (StrUtil.isNumeric(status) && Integer.valueOf(status) >= 0) {
			map.put(MapperConstant.status, ConvertUtil.toBoolean(status));
		}
		if (StrUtil.isNumeric(type) && Integer.valueOf(type) >= 0) {
			map.put(MapperConstant.type, EC2C.get(type));
		}
		List<C2C> list = C2CPX.getList(map);
		pager.refresh(list);
		model.put(ViewKeyConstant.pager, pager);
		//model.put(ViewKeyConstant.c2cTopList, C2CPX.getTopList());
		model.put(ViewKeyConstant.c2cList, list);
		model.put(ViewKeyConstant.name, name);
		model.put(ViewKeyConstant.contactname, contactname);
		model.put(ViewKeyConstant.istop, istop);
		model.put(ViewKeyConstant.status, status);
		model.put(ViewKeyConstant.type, type);
		return "doc2c";
	}
}
