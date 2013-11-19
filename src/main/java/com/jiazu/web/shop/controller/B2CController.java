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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jiazu.global.constants.EB2C;
import com.jiazu.global.constants.MapperConstant;
import com.jiazu.global.constants.MsgConstant;
import com.jiazu.global.constants.ViewKeyConstant;
import com.jiazu.global.utility.ConvertUtil;
import com.jiazu.global.utility.FileUtil;
import com.jiazu.global.utility.StrUtil;
import com.jiazu.web.base.controller.BaseController;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.platform.entity.Comment;
import com.jiazu.web.platform.proxy.CommentPX;
import com.jiazu.web.shop.entity.B2C;
import com.jiazu.web.shop.entity.Gallery;
import com.jiazu.web.shop.proxy.B2CPX;
import com.jiazu.web.shop.proxy.GalleryPX;

/**
 * @author Architect.bian
 * 
 */
@Controller
public class B2CController extends BaseController {

	@RequestMapping(value = "/b2c", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {
		model.put(ViewKeyConstant.cultureProdAmount, B2CPX.getCultureProdAmount());
		model.put(ViewKeyConstant.eduToolsAmount, B2CPX.getEduToolsAmount());
		model.put(ViewKeyConstant.booksAmount, B2CPX.getBooksAmount());
		model.put(ViewKeyConstant.softwareAmount, B2CPX.getSoftwareAmount());
		model.put(ViewKeyConstant.cultureProds, B2CPX.getCultureProdsTop(12));
		model.put(ViewKeyConstant.eduTools, B2CPX.getEduToolsTop(3));
		model.put(ViewKeyConstant.books, B2CPX.getBooksTop(12));
		model.put(ViewKeyConstant.softwares, B2CPX.getSoftwaresTop(12));
		return "/b2c";
	}

	@RequestMapping("/b2c/{uid:.{32}}")
	public String show(@PathVariable String uid, Map<String, Object> model, HttpServletRequest request) {
		Pager pager = Pager.getNewInstance(request.getParameter("num"), 10);
		B2C b2c = B2CPX.get(uid);
		List<Comment> list = CommentPX.getList(b2c.getUid(), pager);
		pager.refresh(list);
		b2c.setComments(list);
		model.put(ViewKeyConstant.bean, b2c);
		model.put(ViewKeyConstant.pager, pager);
		return "/b2cuid";
	}

	@RequestMapping("/b2c/{type:\\d+}")
	public String more(@PathVariable String type, Map<String, Object> model, String num) {
		if (StringUtils.isNumeric(type)) {
			Pager pager = Pager.getNewInstance(num, 20);
			List<B2C> list = B2CPX.getListByType(EB2C.get(Integer.valueOf(type)), pager);
			pager.refresh(list);
			model.put(ViewKeyConstant.list, list);
			model.put(ViewKeyConstant.hotlist, B2CPX.getHotList(new Pager()));
			model.put(ViewKeyConstant.type, type);
			model.put(ViewKeyConstant.pager, pager);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.err_argument);
		}
		return "/b2clist";
	}

	@RequestMapping(value = "/admin/dob2c", method = RequestMethod.GET)
	public String dob2c(Map<String, Object> model, HttpServletRequest request) {
		Pager pager = Pager.getNewInstance(request.getParameter("num"), 20);
		List<B2C> list = B2CPX.getList(pager);
		pager.refresh(list);
		model.put(ViewKeyConstant.list, list);
		model.put(ViewKeyConstant.pager, pager);
		return "/dob2c";
	}

	@RequestMapping(value = "/admin/dob2c", method = RequestMethod.POST)
	public String dob2c_add(Map<String, Object> model, B2C b2c, @RequestParam MultipartFile[] file, HttpServletRequest request) {
		uploadGallerys(b2c, file);
		b2c.setSn(StrUtil.getRandomString(8));
		if (B2CPX.add(b2c)) {
			model.put(ViewKeyConstant.msg, MsgConstant.addSuccess);
		} else {
			//TODO 删除图片处理
			model.put(ViewKeyConstant.alertmsg, MsgConstant.addFailed);
		}
		return dob2c(model, request);
	}

	/**
	 * @param b2c
	 * @param file
	 */
	private void uploadGallerys(B2C b2c, MultipartFile[] file) {
		int size = b2c.getGalleries().size();
		int len = file.length;
		for (int i = 0; i < len; i++) {
			MultipartFile f = file[i];
			if (f.getSize() > 0) {
				if (i == 0 && b2c.getGalleries().size() == 0) {
					int[][] sizes = { { 1000, 1000 }, { 360, 350 }, { 140, 160 }, { 55, 55 } };
					// int[][] sizes = {{1000,1000} , {360,350}, {55,55}};
					String[] paths = FileUtil.resizeImage(f, sizes);
					Gallery gallery = new Gallery();
					gallery.setOriginal(paths[0]);
					gallery.setBigimg(paths[1]);
					gallery.setImg(paths[2]);
					b2c.setThumb(paths[3]);
					b2c.setLittlethumb(paths[4]);
					gallery.setThumb(paths[4]);
					gallery.setGoodsuid(b2c.getUid());
					gallery.setTitle(b2c.getName());
					gallery.setSortorder(i + size);
					gallery.setIsdefault(true);
					b2c.getGalleries().add(gallery);
				} else {
					int[][] sizes = { { 1000, 1000 }, { 360, 350 }, { 55, 55 } };
					String[] paths = FileUtil.resizeImage(f, sizes);
					Gallery gallery = new Gallery();
					gallery.setOriginal(paths[0]);
					gallery.setBigimg(paths[1]);
					gallery.setImg(paths[2]);
					gallery.setThumb(paths[3]);
					gallery.setGoodsuid(b2c.getUid());
					gallery.setTitle(b2c.getName());
					gallery.setSortorder(i + size);
					gallery.setIsdefault(false);
					b2c.getGalleries().add(gallery);
				}
			}
		}
	}

	@RequestMapping(value = "/admin/dob2c/{uid:.{32}}", method = RequestMethod.GET, params = "do=del")
	public String dob2c_delete(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		if (B2CPX.delete(uid)) {
			model.put(ViewKeyConstant.msg, MsgConstant.deleteSuccess);
		} else {
			model.put(ViewKeyConstant.alertmsg, MsgConstant.deleteFailed);
		}
		return dob2c(model, request);
	}

	@RequestMapping(value = "/admin/dob2c/{uid:.{32}}", method = RequestMethod.GET, params = "do=edit")
	public String dob2c_edit(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		model.put(ViewKeyConstant.bean, B2CPX.get(uid));
		return dob2c(model, request);
	}

	@RequestMapping(value = "/admin/dob2c/{uid:.{32}}", method = RequestMethod.POST)
	public String dob2c_update(Map<String, Object> model, @PathVariable String uid, B2C b2c, @RequestParam MultipartFile[] file, HttpServletRequest request) {
		// b2c.setGalleries(GalleryPX.getList(uid));
		uploadGallerys(b2c, file);
		if (B2CPX.update(b2c)) {
			model.put(ViewKeyConstant.msg, MsgConstant.editSuccess);
		} else {
			model.put(ViewKeyConstant.alertmsg, MsgConstant.editFailed);
			model.put(ViewKeyConstant.bean, b2c);
			return dob2c(model, request);
		}
		return dob2c(model, request);
	}
	
	@RequestMapping(value = "/admin/gallery/{uid:.{32}}/del", method = RequestMethod.GET)
	public @ResponseBody boolean gallery_delete(Map<String, Object> model, @PathVariable String uid) {
		if (GalleryPX.delete(uid)) {
			return true;
		} else {
			return false;
		}
	}
	
	@RequestMapping(value = "/admin/gallery/{uid:.{32}}/default", method = RequestMethod.GET)
	public @ResponseBody boolean gallery_default(Map<String, Object> model, @PathVariable String uid) {
		Gallery g = GalleryPX.get(uid);
		B2C b2c = B2CPX.get(g.getGoodsuid());
		String[] paths = FileUtil.resizeImage(g.getOriginal(), 140, 160);//展示页缩略图
		b2c.setThumb(paths[0]);
		b2c.setLittlethumb(g.getThumb());
		if (b2c.getGalleries().size() > 0) {
			Gallery first = b2c.getGalleries().get(0);
			if (!first.getUid().equals(uid)) {//是否第一个
				if (first.isdefault()) {
					GalleryPX.updateDefault(b2c.getGalleries().get(0).getUid(), false);
				}
				return GalleryPX.updateDefault(uid, true) && B2CPX.update(b2c);
			} else {
				if (!first.isdefault()) {
					GalleryPX.updateDefault(uid, true);
				}
				B2CPX.update(b2c);
				return true;
			}
		}
		return false;
	}
	
	@RequestMapping(value = "/admin/dob2c/search", method = RequestMethod.GET)
	public String dob2c_search(Map<String, Object> model, String name, String sn, String istop, String isbest, String type, String num) {
		Pager pager = Pager.getNewInstance(num, 20);
		Map<String, Object> map = getParamMap(pager);
		if (StringUtils.isNotEmpty(name)) {
			map.put(MapperConstant.name + MapperConstant.like, name.trim());
		}
		if (StringUtils.isNotEmpty(sn)) {
			map.put(MapperConstant.sn, sn.trim());
		}
		if (StrUtil.isNumeric(istop) && Integer.valueOf(istop) >= 0) {
			map.put(MapperConstant.istop, ConvertUtil.toBoolean(istop));
		}
		if (StrUtil.isNumeric(isbest) && Integer.valueOf(isbest) >= 0) {
			map.put(MapperConstant.isbest, ConvertUtil.toBoolean(isbest));
		}
		if (StrUtil.isNumeric(type) && Integer.valueOf(type) >= 0) {
			map.put(MapperConstant.type, EB2C.get(type));
		}
		List<B2C> list = B2CPX.getList(map);
		pager.refresh(list);
		model.put(ViewKeyConstant.pager, pager);
		model.put(ViewKeyConstant.list, list);
		model.put(ViewKeyConstant.name, name);
		model.put(ViewKeyConstant.sn, sn);
		model.put(ViewKeyConstant.istop, istop);
		model.put(ViewKeyConstant.isbest, isbest);
		model.put(ViewKeyConstant.type, type);
		return "dob2c";
	}
}
