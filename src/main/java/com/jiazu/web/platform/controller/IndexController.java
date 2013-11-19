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
 * Create at: 2012-9-2 下午12:58:35
 * ============================================================================
 */
package com.jiazu.web.platform.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jiazu.global.constants.ESearchType;
import com.jiazu.global.constants.ViewKeyConstant;
import com.jiazu.web.base.controller.BaseController;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.platform.entity.Search;
import com.jiazu.web.platform.proxy.ContentPX;
import com.jiazu.web.platform.proxy.CustomPX;
import com.jiazu.web.platform.proxy.EduPX;
import com.jiazu.web.platform.proxy.EventPX;
import com.jiazu.web.platform.proxy.JiazuPX;
import com.jiazu.web.shop.proxy.B2CPX;
import com.jiazu.web.shop.proxy.C2CPX;

/**
 * @author Architect.bian
 *
 */
@Controller
public class IndexController extends BaseController {
	
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Map<String, Object> model) throws Exception {
		
		model.put(ViewKeyConstant.jiaZuNews, JiazuPX.getJiaZuNews(6));
		model.put(ViewKeyConstant.eduTop, EduPX.getIndex(9));
		model.put(ViewKeyConstant.customTop, CustomPX.getTop(9));
		model.put(ViewKeyConstant.charityTop, C2CPX.getCharityTop(2));
		model.put(ViewKeyConstant.b2ctxtTop, B2CPX.getB2CTxtTop(10));
		model.put(ViewKeyConstant.b2cimgTop, B2CPX.getB2CImgTop(6));
		model.put(ViewKeyConstant.c2cBestList, C2CPX.getC2CBestTop(5));
		model.put(ViewKeyConstant.imgFriendLinks, ContentPX.getImgFriendLinks());
		model.put(ViewKeyConstant.txtFriendLinks, ContentPX.getTxtFriendLinks());
		model.put(ViewKeyConstant.bannerList, ContentPX.getBannerList());
		return "index";
	}
	
	@RequestMapping(value = {"/search" })
	public String search(Map<String, Object> model, String s, String type) throws Exception {
		if (StringUtils.isNotEmpty(s) && StringUtils.isNotEmpty(type)) {
			s = s.trim();
			System.out.println("searching:" + s);
			model.put(ViewKeyConstant.searchText, s);
			if (type.equals(ESearchType.All.toString())) {
				List<Search> list = new ArrayList<>();
				list.addAll(EduPX.getSearchResult(s));
				list.addAll(EventPX.getSearchResult(s));
				list.addAll(B2CPX.getSearchResult(s));
				list.addAll(C2CPX.getSearchResult(s));
				model.put(ViewKeyConstant.list, list);
				return "search";
			} else if (type.equals(ESearchType.edu.toString())) {
				model.put(ViewKeyConstant.typeName, "家族教育搜索结果");
				model.put(ViewKeyConstant.bookList, B2CPX.getBookListTop(6));
				model.put(ViewKeyConstant.list, EduPX.search(s, new Pager()));
				return "/edulist";
			} else if (type.equals(ESearchType.event.toString())) {
				model.put(ViewKeyConstant.list, EventPX.search(s, new Pager()));
				return "event";
			} else if (type.equals(ESearchType.b2c.toString())) {
				model.put(ViewKeyConstant.list, B2CPX.search(s, new Pager()));
				model.put(ViewKeyConstant.hotlist, B2CPX.getHotList(new Pager()));
				model.put(ViewKeyConstant.type, "-1");
				return "b2clist";
			} else if (type.equals(ESearchType.c2c.toString())) {
				model.put(ViewKeyConstant.list, C2CPX.search(s, new Pager()));
//				model.put(ViewKeyConstant.type, type);
				return "c2clist";
			}
		}
		return "search";
	}
	
	@RequestMapping(value = { "/404"})
	public String page_404(Map<String, Object> model) throws Exception {
		return "404";
	}
}
