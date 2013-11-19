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
 * Create at: 2012-11-8 下午12:47:21
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiazu.global.constants.EAddress;
import com.jiazu.global.utility.StrUtil;
import com.jiazu.web.base.controller.BaseController;
import com.jiazu.web.platform.entity.User;
import com.jiazu.web.shop.entity.Address;
import com.jiazu.web.shop.entity.Region;
import com.jiazu.web.shop.proxy.AddressPX;
import com.jiazu.web.shop.proxy.RegionPX;

/**
 * @author Architect.bian
 *
 */
@Controller
@RequestMapping(value = "/api")
public class AddressController extends BaseController {

	@RequestMapping(value = "/address/{uid:.{32}}", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
	public @ResponseBody Address get(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		User u = getCurrUser(request);
		if (u != null) {
			return AddressPX.get(uid);
		}
		return null;
	}
	
	@RequestMapping(value = "/address", method = RequestMethod.GET)
	public @ResponseBody String[] list(Map<String, Object> model, HttpServletRequest request) {
		User u = getCurrUser(request);
		if (u != null) {
			String uid = u.getUid();
			List<Address> list = AddressPX.getList(uid);
			String[] strs = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				strs[i] = list.get(i).toString();
			}
			return strs;
		}
		return null;
	}
	
	@RequestMapping(value = "/address", method = RequestMethod.POST, params="method=add")
	public @ResponseBody Address add(Map<String, Object> model, Address address, HttpServletRequest request) {
		
		User u = getCurrUser(request);
		if (u != null) {
			String uid = u.getUid();
			address.setUseruid(uid);
			if (AddressPX.add(address)) {
				return address;
			}
		}
		return null;
	}
	
	@RequestMapping(value = "/address", method = RequestMethod.POST, params="!method")
	public @ResponseBody String update(Map<String, Object> model, Address address, HttpServletRequest request) {
		User u = getCurrUser(request);
		if (u != null) {
			if (AddressPX.update(address)) {
				return StrUtil.toJson(address);
			}
		}
		return "false";
	}
	
	@RequestMapping(value = "/address/{type:\\d+}", method = RequestMethod.POST)
	public @ResponseBody boolean update(Map<String, Object> model, String uid, @PathVariable int type, HttpServletRequest request) {
		User u = getCurrUser(request);
		if (u != null) {
			return AddressPX.updateType(uid, EAddress.get(type));
		}
		return false;
	}
	
	@RequestMapping(value = "/address/{uid:.{32}}", method = RequestMethod.DELETE, produces="application/json;charset=UTF-8")
	public @ResponseBody boolean delete(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		User u = getCurrUser(request);
		if (u != null) {
			if (StringUtils.isNotEmpty(uid)) {
				return AddressPX.delete(uid);
			}
		}
		return false;
	}
	
	@RequestMapping(value = "/region/{pid}", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
	public @ResponseBody List<Region> getRegionList(Map<String, Object> model,@PathVariable String pid) {
		return RegionPX.getList(pid);
	}
}
