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
 * Create at: 2012-12-8 上午8:16:22
 * ============================================================================
 */
package com.jiazu.web.platform.entity;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jiazu.global.constants.EStatus;
import com.jiazu.global.utility.GlobalUtil;
import com.jiazu.web.base.entity.BaseEntity;

/**
 * @author Architect.bian
 *
 */
@Component
@Scope("prototype")
public class Jisi extends BaseEntity {

	private static final long serialVersionUID = 1472652111350634263L;
	
	private String music;
	private int censerDuration;
	private int candleDucration;
	private DateTime censerTime;
	private DateTime candleTime;
	private ZupuMember member;
	private List<User> viewers = new ArrayList<>();
	private List<Flower> flowers = new ArrayList<>();
	private List<Music> musiclist = new ArrayList<>();
	private EStatus status = EStatus.enable;

	public String getMusic() {
		return music;
	}

	public void setMusic(String music) {
		this.music = music;
	}

	public int getCenserDuration() {
		return censerDuration;
	}

	public void setCenserDuration(int censerDuration) {
		this.censerDuration = censerDuration;
	}

	public int getCandleDucration() {
		return candleDucration;
	}

	public void setCandleDucration(int candleDucration) {
		this.candleDucration = candleDucration;
	}

	public DateTime getCenserTime() {
		return censerTime;
	}

	public void setCenserTime(DateTime censerTime) {
		this.censerTime = censerTime;
	}

	public DateTime getCandleTime() {
		return candleTime;
	}

	public void setCandleTime(DateTime candleTime) {
		this.candleTime = candleTime;
	}

	public ZupuMember getMember() {
		return member;
	}

	public void setMember(ZupuMember member) {
		this.member = member;
	}

	public List<User> getViewers() {
		return viewers;
	}

	public void setViewers(List<User> viewers) {
		this.viewers = viewers;
	}

	public List<Flower> getFlowers() {
		List<Flower> toremove = new ArrayList<>();
		for (Flower flower : flowers) {
			long leftMillis = (flower.getCreateTime().plusMinutes(flower.getDuration()).getMillis() - (new DateTime()).getMillis());
			if (leftMillis < 0) {
				toremove.add(flower);
			}
		}
		flowers.removeAll(toremove);
		return flowers;
	}

	public void setFlowers(List<Flower> flowers) {
		this.flowers = flowers;
	}

	public List<Music> getMusiclist() {
		return musiclist;
	}

	public void setMusiclist(List<Music> musiclist) {
		this.musiclist = musiclist;
	}

	public EStatus getStatus() {
		return status;
	}

	public void setStatus(EStatus status) {
		this.status = status;
	}

	/**
	 * @param flower
	 */
	public void addFlower(Flower flower) {
		flower.setUid(GlobalUtil.getUUID());
		flower.setCreateTime(new DateTime());
		this.flowers.add(flower);
	}

	/**
	 * @param defaultJisi
	 */
	public void setConfig(Jisi defaultJisi) {
		this.setCandleDucration(defaultJisi.getCandleDucration());
		this.setCenserDuration(defaultJisi.getCenserDuration());
		this.setMusic(defaultJisi.getMusic());
	}

	/**
	 * 
	 */
	public void init() {
		this.viewers.clear();
		this.flowers.clear();
		this.candleTime = null;
		this.censerTime = null;
		this.setCreateTime(new DateTime());
	}

}
