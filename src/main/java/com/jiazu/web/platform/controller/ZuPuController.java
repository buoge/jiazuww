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
 * Create at: 2012-9-2 下午1:48:33
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

import com.jiazu.global.constants.EStatus;
import com.jiazu.global.constants.MsgConstant;
import com.jiazu.global.constants.SysConf;
import com.jiazu.global.constants.SysConstant;
import com.jiazu.global.constants.ViewKeyConstant;
import com.jiazu.global.utility.FileUtil;
import com.jiazu.web.base.controller.BaseController;
import com.jiazu.web.platform.entity.Jiazu;
import com.jiazu.web.platform.entity.User;
import com.jiazu.web.platform.entity.ZupuMember;
import com.jiazu.web.platform.proxy.JiazuPX;
import com.jiazu.web.platform.proxy.MemberPX;
import com.jiazu.web.platform.proxy.SysPX;
import com.jiazu.web.platform.proxy.ZuPuPX;

/**
 * @author Architect.bian
 *
 */
@Controller
public class ZuPuController extends BaseController {
	
	@RequestMapping(value = "/zupu", method = RequestMethod.GET)
	public String index(Map<String, Object> model, HttpServletRequest request) {
		model.put(ViewKeyConstant.zuPuCount, ZuPuPX.getCreatedCount());
		model.put(ViewKeyConstant.zuPuLatest, ZuPuPX.getLatest(10));
		model.put(ViewKeyConstant.zuPuNews, ZuPuPX.getZuPuNews(8));
		model.put(ViewKeyConstant.intro, ZuPuPX.getIntroduce());
		if (request.getAttribute(ViewKeyConstant.me) != null) {
			User user = (User)request.getAttribute(ViewKeyConstant.me);
			List<Jiazu> jiazuList = JiazuPX.getList(user.getUid());
			if (jiazuList.size() > 0) {
				model.put(ViewKeyConstant.currUid, jiazuList.get(0).getId());
			}
		}
		return "zupu";
	}
	
	@RequestMapping(value = "/zuputest", method = RequestMethod.GET)
	public @ResponseBody User test(Map<String, Object> model, HttpServletRequest request) {
		User user = new User();
		user.setAccount(100);
		return user;
	}
	
	@RequestMapping(value="/myhome/{uid:.{32}}/zupu", method = RequestMethod.GET)
	public String myzupu(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		model.put(ViewKeyConstant.zupu, JiazuPX.getZupu(uid));
//		model.put(ViewKeyConstant.list, ZuPuPX.getMembers(uid));
		model.put(ViewKeyConstant.resphtml, ZuPuPX.getHtmlTree(uid).replace("<img src=\"", "<img src=\"" + request.getContextPath()));
		model.put(ViewKeyConstant.admintype, MemberPX.getOne(uid, getCurrUser(request).getUid()).getType().toString());
		return "myzupu";
	}
	
	@RequestMapping(value="/myhome/{uid:.{32}}/zupu", method = RequestMethod.POST, params = "action=add")
	public String myzupu_add(Map<String, Object> model, @PathVariable String uid, @RequestParam String selecteduid, ZupuMember member, @RequestParam MultipartFile file, @RequestParam MultipartFile file2, HttpServletRequest request) {
		if (selecteduid.length() == 32) {
			ZupuMember m = ZuPuPX.get(selecteduid);
			if (m == null) {
				model.put(ViewKeyConstant.msg, MsgConstant.err_argument);
				return myzupu(model, uid, request);
			} else {
				member.setLevel(m.getLevel() + 1);
			}
		} else {
			member.setLevel(1);
		}
		//TODO 可为空，若为空则使用用户头像
		if (file.getSize() > 0) {
			String[] paths = FileUtil.resizeImage(file, 80, 80);
			member.setAvatar(paths[1]);
			if (member.getStatus() == EStatus.disable) {
				String graypath = FileUtil.gray(paths[1]);
				if (StringUtils.isNotEmpty(graypath)) {
					member.setAvatar(graypath);
				}
			}
		} 
		if (file2.getSize() > 0) {
			String[] paths = FileUtil.resizeImage(file2, 80, 80);
			member.setAvatar2(paths[1]);
			if (member.getStatus2() == EStatus.disable) {
				String graypath = FileUtil.gray(paths[1]);
				if (StringUtils.isNotEmpty(graypath)) {
					member.setAvatar2(graypath);
				}
			}
		}
		if(StringUtils.isEmpty(member.getAvatar())) {
			member.setAvatar(SysConstant.defaultNoImg_50_50);
		}
		if(StringUtils.isEmpty(member.getAvatar2())) {
			member.setAvatar2(SysConstant.defaultNoImg_50_50);
		}
		member.setGroupuid(uid);
		member.setParentuid(selecteduid);
		if (ZuPuPX.add(member)) {
			Jiazu jiazu = JiazuPX.get(uid);
			SysPX.addZupuNews(jiazu.getName(), jiazu.getHeadimg(), SysConf.format_zupunews_addmember, "");
			model.put(ViewKeyConstant.msg, MsgConstant.addSuccess);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.addFailed);
		}
		return myzupu(model, uid, request);
	}
	
	
	@RequestMapping(value="/myhome/{uid:.{32}}/zupu", method = RequestMethod.POST, params = "action=del")
	public String myzupu_del(Map<String, Object> model, @PathVariable String uid, @RequestParam String selecteduid, HttpServletRequest request) {
		if (ZuPuPX.delete(selecteduid)) {
			model.put(ViewKeyConstant.msg, MsgConstant.deleteSuccess);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.deleteFailed);
		}
		return myzupu(model, uid, request);
	}
	
	@RequestMapping(value="/myhome/{uid:.{32}}/zupu", params = "action=edit")
	public String myzupu_edit(Map<String, Object> model, @PathVariable String uid, @RequestParam String selecteduid, HttpServletRequest request) {
		model.put(ViewKeyConstant.editbean, ZuPuPX.get(selecteduid));
		return myzupu(model, uid, request);
	}
	
	@RequestMapping(value="/myhome/{uid:.{32}}/zupu", method = RequestMethod.POST, params = "action=save")
	public String myzupu_save(Map<String, Object> model, @PathVariable String uid, ZupuMember member, @RequestParam MultipartFile file, @RequestParam MultipartFile file2, HttpServletRequest request) {
		ZupuMember m = ZuPuPX.get(member.getUid());
		
		//TODO 可为空，若为空则使用用户头像
		if (file.getSize() > 0) {
			String[] paths = FileUtil.resizeImage(file, 80, 80);
			m.setAvatar(paths[1]);
			if (member.getStatus() == EStatus.disable) {
				String graypath = FileUtil.gray(paths[1]);
				if (StringUtils.isNotEmpty(graypath)) {
					m.setAvatar(graypath);
				}
			}
		} 
		if (file2.getSize() > 0) {
			String[] paths = FileUtil.resizeImage(file2, 80, 80);
			m.setAvatar2(paths[1]);
			if (member.getStatus2() == EStatus.disable) {
				String graypath = FileUtil.gray(paths[1]);
				if (StringUtils.isNotEmpty(graypath)) {
					m.setAvatar2(graypath);
				}
			}
		}
		if(StringUtils.isEmpty(m.getAvatar())) {
			m.setAvatar(SysConstant.defaultNoImg_50_50);
		}
		if(StringUtils.isEmpty(m.getAvatar2())) {
			m.setAvatar2(SysConstant.defaultNoImg_50_50);
		}
		m.setName(member.getName());
		m.setBirthday(member.getBirthday());
		m.setDieday(member.getDieday());
		m.setIntroduce(member.getIntroduce());
		m.setStatus(member.getStatus());
		m.setName2(member.getName2());
		m.setBirthday2(member.getBirthday2());
		m.setDieday2(member.getDieday2());
		m.setIntroduce2(member.getIntroduce2());
		m.setStatus2(member.getStatus2());
		if (ZuPuPX.update(m)) {
			Jiazu jiazu = JiazuPX.get(uid);
			SysPX.addZupuNews(jiazu.getName(), jiazu.getHeadimg(), SysConf.format_zupunews_addmember, "");
			model.put(ViewKeyConstant.msg, MsgConstant.addSuccess);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.addFailed);
		}
		return myzupu(model, uid, request);
	}
	
	@RequestMapping(value="/api/myhome/{uid:.{32}}/zupu", method = RequestMethod.POST, params = "action=init", produces="application/json;charset=UTF-8")
	public @ResponseBody String myzupu_init(Map<String, Object> model, @PathVariable String uid) {
		String resp = ZuPuPX.getJsonMembers(uid);
//		String resp = "[{\"id\": \"idididid\", \"text\": \"1. 祖父 | 祖母\",\"expanded\": true,\"children\":[{\"id\": \"222222\",\"text\": \"1.1 父亲 | 母亲\"}, {\"id\": \"33333\",\"text\": \"1.2 叔叔 | 婶婶\"}]},{\"text\": \"2. 二祖父 | 二祖母\"},{\"text\": \"3. 三祖父 | 三祖母\"},{\"text\": \"4. 四祖父 | 四祖母\"}]";
		return resp;
	}
	
}
