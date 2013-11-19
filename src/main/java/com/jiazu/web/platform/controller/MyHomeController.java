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
 * Create at: 2012-9-1 下午9:46:58
 * ============================================================================
 */
package com.jiazu.web.platform.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jiazu.global.constants.GlobalConstant;
import com.jiazu.global.constants.SysConstant;
import com.jiazu.global.constants.ViewKeyConstant;
import com.jiazu.global.utility.FileUtil;
import com.jiazu.global.utility.StrUtil;
import com.jiazu.web.base.controller.BaseController;
import com.jiazu.web.platform.entity.Jiazu;
import com.jiazu.web.platform.entity.Search;
import com.jiazu.web.platform.entity.User;
import com.jiazu.web.platform.proxy.EduPX;
import com.jiazu.web.platform.proxy.EventPX;
import com.jiazu.web.platform.proxy.JiazuPX;

/**
 * @author Architect.bian
 *
 */
@Controller
public class MyHomeController extends BaseController {

	@RequestMapping(value={"/myhome"})
	public String myhome(Map<String, Object> model) {
		return "myhome";
	}
	
	@RequestMapping(value="/myhome/{uid:.{32}}")
	public String myhome(@PathVariable String uid, Map<String, Object> model) {
		model.put(ViewKeyConstant.currUid, uid);
		return "myhome";
	}
	
	@RequestMapping(value="/ckeditor/img", method = RequestMethod.POST)
	public ResponseEntity<String> imgupload(Map<String, Object> model,@RequestParam("CKEditorFuncNum") String funNum, @RequestParam(value="upload") MultipartFile file, HttpServletRequest request) {
		if (file.getSize() > 0) {
			String path = FileUtil.upload(file);
			model.put("msg", "File '" + file.getOriginalFilename() + "' uploaded successfully");
			if (StringUtils.isEmpty(SysConstant.baseImgRootPath)) {
				String basePath = request.getContextPath();
				SysConstant.baseImgRootPath = basePath;
			}
			String imgpath = SysConstant.baseImgRootPath + path;
			String resp = "<script type=\"text/javascript\">window.parent.CKEDITOR.tools.callFunction(" + funNum + ",'" + imgpath + "','')</script>";
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.TEXT_HTML);
			return new ResponseEntity<String>(resp,headers, HttpStatus.OK);
		} else {
			HttpHeaders headers = new HttpHeaders();
			String resp = "";
			return new ResponseEntity<String>(resp,headers, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/ckeditor/flash", method = RequestMethod.POST)
	public ResponseEntity<String> flashupload(Map<String, Object> model,@RequestParam("CKEditorFuncNum") String funNum, @RequestParam(value="upload") MultipartFile file) {
		model.put("msg", "File '" + file.getOriginalFilename() + "' uploaded successfully");
		String imgpath = "http://www.baidu.com/img/baidu_sylogo1.gif";
		String resp = "<script type=\"text/javascript\">window.parent.CKEDITOR.tools.callFunction(" + funNum + ",'" + imgpath + "','')</script>";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_HTML);
		return new ResponseEntity<String>(resp,headers, HttpStatus.OK);
	}

	@RequestMapping(value="/myhome/search")
	public String search(Map<String, Object> model, String s, HttpServletRequest request) {
		User u = getCurrUser(request);
		if (u != null) {
			model.put(ViewKeyConstant.searchText, s);
			List<Jiazu> jiazus = JiazuPX.getList(u.getUid());
			String groupuids = "";
			for (Jiazu jiazu : jiazus) {
				groupuids += jiazu.getUid() + GlobalConstant.COMMA;
			}
			groupuids = StrUtil.trim(groupuids, GlobalConstant.COMMA);
			List<Search> list = new ArrayList<>();
			list.addAll(EduPX.getSearchResult(s, groupuids));
			list.addAll(EventPX.getSearchResult(s, groupuids));
			model.put(ViewKeyConstant.list, list);
			return "mysearch";
		} else {
			return "login";
		}
	}
}
