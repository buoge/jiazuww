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
 * Create at: 2012-12-6 上午11:39:01
 * ============================================================================
 */
package com.jiazu.web.platform.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jiazu.global.constants.EB2C;
import com.jiazu.global.constants.EContent;
import com.jiazu.global.constants.MsgConstant;
import com.jiazu.global.constants.SysConf;
import com.jiazu.global.constants.ViewKeyConstant;
import com.jiazu.global.utility.FileUtil;
import com.jiazu.global.utility.SerialUtil;
import com.jiazu.global.utility.StrUtil;
import com.jiazu.web.base.controller.BaseController;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.platform.entity.Flower;
import com.jiazu.web.platform.entity.Jisi;
import com.jiazu.web.platform.entity.Music;
import com.jiazu.web.platform.entity.User;
import com.jiazu.web.platform.entity.ZupuMember;
import com.jiazu.web.platform.proxy.ContentPX;
import com.jiazu.web.platform.proxy.FlowerPX;
import com.jiazu.web.platform.proxy.JisiPX;
import com.jiazu.web.platform.proxy.UserPX;
import com.jiazu.web.shop.entity.B2C;
import com.jiazu.web.shop.proxy.B2CPX;

/**
 * @author Architect.bian
 *
 */
@Controller
public class JisiController extends BaseController {
	
	@RequestMapping(value="/jisi", method = RequestMethod.GET)
	public String jisi_default(Map<String, Object> model, HttpServletRequest request) {
		return jisi(model, "default", request);
	}

	@RequestMapping(value="/jisi/{uid:.{32}}")
	public String jisi(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		Jisi jisi = getJisi(uid);
		if (jisi != null) {
			ZupuMember mem = null;
			if (uid.equals("default")) {
				mem = jisi.getMember();
			} else {
				mem = JisiPX.get(uid);
			}
			if(StringUtils.isNotEmpty(request.getParameter("musicpath"))) {
				model.put(ViewKeyConstant.music, request.getParameter("musicpath"));
			} else {
				model.put(ViewKeyConstant.music, jisi.getMusic());
			}
			model.put(ViewKeyConstant.viewers, jisi.getViewers());
			model.put(ViewKeyConstant.flowers, jisi.getFlowers());
			if (mem != null) {
				model.put(ViewKeyConstant.member, mem);
			}
			model.put(ViewKeyConstant.list, FlowerPX.getList());
			model.put(ViewKeyConstant.article, ContentPX.getOneByType(EContent.jisi).getContent());
			List<B2C> list = B2CPX.getListByType(EB2C.money, new Pager());
			if (list != null && list.size() > 0) {
				model.put(ViewKeyConstant.url, list.get(0).getUid());
			}
			model.put(ViewKeyConstant.jisiuid, uid);
			if (jisi.getCandleTime() != null) {
				long leftMillis = jisi.getCandleTime().plusMinutes(jisi.getCandleDucration()).getMillis() - (new DateTime()).getMillis();
				double leftMinute = Double.valueOf(leftMillis) / (60 * 1000);
				double leftCandlePercent = leftMinute / jisi.getCandleDucration();
				model.put(ViewKeyConstant.leftCandlePercent, leftCandlePercent);
			}
			if (jisi.getCenserTime() != null) {
				long leftMillis = (jisi.getCenserTime().plusMinutes(jisi.getCenserDuration()).getMillis() - (new DateTime()).getMillis());
				double leftMinute = Double.valueOf(leftMillis) / (60 * 1000);
				double leftCenserPercent = leftMinute / Double.valueOf(jisi.getCenserDuration());
				model.put(ViewKeyConstant.leftCenserPercent, leftCenserPercent);
			}
		}
		return "/jisi";
	}

	/**
	 * @param uid
	 * @return
	 */
	private Jisi getJisi(String uid) {
		Jisi jisi = (Jisi)SerialUtil.Deserialize(uid, SysConf.SerialPath);
		if (jisi == null) {
			jisi = getDefaultJisi();
			jisi.setUid(uid);
			jisi.init();
		} else if (!uid.equals("default")) {
			jisi.setConfig(getDefaultJisi());
		} else {
			jisi.getFlowers().clear();
		}
		List<Flower> toremoves = new ArrayList<>();
		for (Flower flower : jisi.getFlowers()) {
			if (flower.getCreateTime().plusMinutes(flower.getDuration()).isBeforeNow()) {
				toremoves.add(flower);
			}
		}
		if (toremoves.size() > 0) {
			jisi.getFlowers().removeAll(toremoves);
			saveJisi(jisi);
		}
		return jisi;
	}
	
	private Jisi getDefaultJisi() {
		Jisi jisi = (Jisi)SerialUtil.Deserialize("default", SysConf.SerialPath);
		jisi.getFlowers().clear();
		return jisi;
	}
	
	@RequestMapping(value="/jisi/candle", method = RequestMethod.GET)
	public @ResponseBody boolean updateCandle(@Param(value = "jisiuid") String jisiuid, HttpServletRequest request) {
		Jisi jisi = getJisi(jisiuid);
		jisi.setCandleTime(new DateTime());
		User user = getCurrUser(request);
		if (user != null) {
			user.setCreateTime(new DateTime());
			jisi.getViewers().remove(user);
			jisi.getViewers().add(0, user);
		}
		if (saveJisi(jisi)) {
			return true;
		} else {
			return false;
		}
	}
	
	@RequestMapping(value="/jisi/censer", method = RequestMethod.GET)
	public @ResponseBody boolean updateCenser(@Param(value = "jisiuid") String jisiuid, HttpServletRequest request) {
		Jisi jisi = getJisi(jisiuid);
		jisi.setCenserTime(new DateTime());
		User user = getCurrUser(request);
		if (user != null) {
			user.setCreateTime(new DateTime());
			jisi.getViewers().remove(user);
			jisi.getViewers().add(0, user);
		}
		if (saveJisi(jisi)) {
			return true;
		} else {
			return false;
		}
	}
	
	@RequestMapping(value="/jisi/flower", method = RequestMethod.GET)
	public @ResponseBody Flower getFlower(@Param(value = "uid") String uid, @Param(value = "jisiuid") String jisiuid, HttpServletRequest request) {
		Jisi jisi = getJisi(jisiuid);
		User user = getCurrUser(request);
		if (user != null) {
			user.setCreateTime(new DateTime());
			jisi.getViewers().remove(user);
			jisi.getViewers().add(0, user);
		}
		Flower flower = FlowerPX.get(uid);
		boolean charged = false;
		if (flower.isFree()) {
			charged = true;
		} else if (flower.getPrice() > 0 && user.getAccount() >= flower.getPrice()) {
			user.setAccount(user.getAccount() - flower.getPrice());
			if (UserPX.updateAccount(user)) {
				UserPX.freshCache(getCurrUserCacheKey(request), user.getUid());
				charged = true;
			}
		}
		if (charged) {
			flower.setCreateTime(new DateTime());
			jisi.addFlower(flower);
			saveJisi(jisi);
			return flower;
		} else {
			return null;
		}
	}
	
	/**
	 * @param jisi
	 */
	private boolean saveJisi(Jisi jisi) {
		while (jisi.getViewers().size() > 5) {
			jisi.getViewers().remove(0);
		}
		jisi.setUpdateTime(new DateTime());
		return SerialUtil.Serialize(jisi, SysConf.SerialPath + SysConf.Separator_Directory + jisi.getUid());
	}

	@RequestMapping(value="/myhome/{uid:.{32}}/jisi", method = RequestMethod.GET)
	public String myjisi(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		Pager pager = Pager.getNewInstance(request.getParameter("num"), 6);
		List<ZupuMember> list = JisiPX.getListByGroupUid(uid, pager);
		model.put(ViewKeyConstant.list, list);
		pager.refresh(list);
		model.put(ViewKeyConstant.pager, pager);
		model.put(ViewKeyConstant.musiclist, getDefaultJisi().getMusiclist());
		return "myjisi";
	}
	
	@RequestMapping(value="/admin/dojisi", method = RequestMethod.GET)
	public String dojisi(Map<String, Object> model, HttpServletRequest request) {
		model.put(ViewKeyConstant.bean, getDefaultJisi());
		model.put(ViewKeyConstant.list, FlowerPX.getList());
		return "dojisi";
	}
	
	@RequestMapping(value="/admin/dojisi", method = RequestMethod.POST)
	public String dojisi_post(Map<String, Object> model, String memberuid, String censerDuration, String candleDucration, @RequestParam MultipartFile music, HttpServletRequest request) {
		Jisi jisi = getDefaultJisi();
		if (jisi == null) {
			jisi = new Jisi();
		}
		if (StrUtil.isNumeric(censerDuration)) {
			jisi.setCenserDuration(Integer.valueOf(censerDuration));
		}
		if (StrUtil.isNumeric(candleDucration)) {
			jisi.setCandleDucration(Integer.valueOf(candleDucration));
		}
		ZupuMember mem = JisiPX.get(memberuid);
		if (mem != null) {
			jisi.setMember(mem);
		}
		if (music.getSize() > 0) {
			jisi.setMusic(FileUtil.upload(music));//TODO 修改成管理员的地址
		}
		boolean flag = SerialUtil.Serialize(jisi, SysConf.SerialPath + SysConf.Separator_Directory + jisi.getUid());
		if (flag) {
			model.put(ViewKeyConstant.msg, MsgConstant.uploadSuccess);
		} else {
			model.put(ViewKeyConstant.alertmsg, MsgConstant.uploadFailed);
		}
		return dojisi(model, request);
	}
	
	@RequestMapping(value="/admin/dojisi/{uid:.{32}}", method = RequestMethod.GET)
	public String dojisi_edit(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		Flower flower = FlowerPX.get(uid);
		if (flower != null) {
			model.put(ViewKeyConstant.editbean, flower);
		} else {
			model.put(ViewKeyConstant.alertmsg, MsgConstant.editFailed);
		}
		return dojisi(model, request);
	}
	
	@RequestMapping(value="/admin/dojisi/{uid:.{32}}", method = RequestMethod.POST)
	public String dojisi_update(Map<String, Object> model, Flower flower, @RequestParam MultipartFile file, HttpServletRequest request) {
		if (file.getSize() > 0) {
			int[][] sizes = {{40,40}, {60,60}};
			String[] paths = FileUtil.resizeImage(file, sizes);
			flower.setOriginal(paths[0]);
			flower.setThumb(paths[1]);
			flower.setImg(paths[2]);
//			flower.setBigimg(paths[3]);
		}
		if (FlowerPX.update(flower)) {
			model.put(ViewKeyConstant.msg, MsgConstant.editSuccess);
		} else {
			model.put(ViewKeyConstant.alertmsg, MsgConstant.editFailed);
		}
		return dojisi(model, request);
	}
	

	@RequestMapping(value="/admin/dojisi/add", method = RequestMethod.POST)
	public String dojisi_add(Map<String, Object> model, Flower flower, @RequestParam MultipartFile file, HttpServletRequest request) {
		if (file.getSize() > 0) {
			int[][] sizes = {{40,40}, {60,60}};
			String[] paths = FileUtil.resizeImage(file, sizes);
			flower.setOriginal(paths[0]);
			flower.setThumb(paths[1]);
			flower.setImg(paths[2]);
//			flower.setBigimg(paths[3]);
		}
		if (FlowerPX.add(flower)) {
			model.put(ViewKeyConstant.msg, MsgConstant.addSuccess);
		} else {
			model.put(ViewKeyConstant.alertmsg, MsgConstant.addFailed);
		}
		return dojisi(model, request);
	}
	

	@RequestMapping(value="/admin/dojisi/{uid:.{32}}/del", method = RequestMethod.GET)
	public String dojisi_del(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		if (FlowerPX.delete(uid)) {
			model.put(ViewKeyConstant.msg, MsgConstant.deleteSuccess);
		} else {
			model.put(ViewKeyConstant.alertmsg, MsgConstant.deleteFailed);
		}
		return dojisi(model, request);
	}
	

	@RequestMapping(value="/admin/dojisimusic", method = RequestMethod.GET)
	public String dojisimusic(Map<String, Object> model, HttpServletRequest request) {
		model.put(ViewKeyConstant.list, getDefaultJisi().getMusiclist());
		return "dojisimusic";
	}

	@RequestMapping(value="/admin/dojisimusic", method = RequestMethod.POST)
	public String dojisimusic_add(Map<String, Object> model, String name, @RequestParam MultipartFile music, HttpServletRequest request) {
		Jisi jisi = getDefaultJisi();
		if (jisi == null) {
			jisi = new Jisi();
		}
		if (music.getSize() > 0) {
			Music m = new Music(name, FileUtil.upload(music));//TODO 修改成管理员的地址
			if(jisi.getMusiclist() == null) {
				jisi.setMusiclist(new ArrayList<Music>());
			}
			jisi.getMusiclist().add(m);
		}
		boolean flag = SerialUtil.Serialize(jisi, SysConf.SerialPath + SysConf.Separator_Directory + jisi.getUid());
		if (flag) {
			model.put(ViewKeyConstant.msg, MsgConstant.addSuccess);
		} else {
			model.put(ViewKeyConstant.alertmsg, MsgConstant.addFailed);
		}
		return dojisimusic(model, request);
	}
	
	@RequestMapping(value="/admin/dojisimusic/{uid:.{32}}/del", method = RequestMethod.GET)
	public String dojisimusic_del(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		Jisi jisi = getDefaultJisi();
		int i = -1;
		List<Music> musics = jisi.getMusiclist();
		for (int j = 0; j < musics.size(); j++) {
			if (musics.get(j).getUid().equals(uid)) {
				i = j;
			}
		}
		if (i != -1) {
			Music music = jisi.getMusiclist().get(i);
			FileUtil.delete(music.getPath());
			jisi.getMusiclist().remove(i);
		}
		if (saveJisi(jisi)) {
			model.put(ViewKeyConstant.msg, MsgConstant.deleteSuccess);
		} else {
			model.put(ViewKeyConstant.alertmsg, MsgConstant.deleteFailed);
		}
		return dojisimusic(model, request);
	}
}
