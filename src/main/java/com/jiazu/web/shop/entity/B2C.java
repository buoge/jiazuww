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
 * Create at: 2012-8-18 上午8:42:47
 * ============================================================================
 */
package com.jiazu.web.shop.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jiazu.global.constants.EB2C;
import com.jiazu.global.constants.EShow;
import com.jiazu.web.base.entity.BaseEntity;
import com.jiazu.web.platform.entity.Comment;

/**
 * @author Architect.bian
 *
 */
@Component
public class B2C extends BaseEntity {

	private static final long serialVersionUID = -7709918183155296755L;
	private String catuid = "";
	private String sn;
	private String name;
	private int number;
	private double weight;
	private double marketprice;
	private double shopprice;
	private double shippingfee;
	private String keywords;
	private String brief;
	private String desc;
	private String littlethumb = "";//50*50
	private String thumb = "";
	private double rate = 5;
	private int sortorder = 0;
	private boolean isonsale;
	private boolean isbest = false;
	private boolean isnew = false;
	private boolean istop = false;
	private boolean ishot = false;
	private EB2C type;
	private EShow showtype = EShow.none;
	private int sellcount;
	private int buyercount;
	private int clickcount;
	private int commentscount = 0;
	private List<Gallery> galleries = new ArrayList<>();
	private List<Comment> comments = new ArrayList<>();
	
	public String getCatuid() {
		return catuid;
	}
	public void setCatuid(String catuid) {
		this.catuid = catuid;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getMarketprice() {
		return marketprice;
	}
	public void setMarketprice(double marketprice) {
		this.marketprice = marketprice;
	}
	public double getShopprice() {
		return shopprice;
	}
	public void setShopprice(double shopprice) {
		this.shopprice = shopprice;
	}
	public double getShippingfee() {
		return shippingfee;
	}
	public void setShippingfee(double shippingfee) {
		this.shippingfee = shippingfee;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getLittlethumb() {
		return littlethumb;
	}
	public void setLittlethumb(String littlethumb) {
		this.littlethumb = littlethumb;
	}
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public int getSortorder() {
		return sortorder;
	}
	public void setSortorder(int sortorder) {
		this.sortorder = sortorder;
	}
	public boolean isonsale() {
		return isonsale;
	}
	public void setIsonsale(boolean isonsale) {
		this.isonsale = isonsale;
	}
	public boolean isbest() {
		return isbest;
	}
	public void setIsbest(boolean isbest) {
		this.isbest = isbest;
	}
	public boolean isnew() {
		return isnew;
	}
	public void setIsnew(boolean isnew) {
		this.isnew = isnew;
	}
	public boolean istop() {
		return istop;
	}
	public void setIstop(boolean istop) {
		this.istop = istop;
	}
	public boolean ishot() {
		return ishot;
	}
	public void setIshot(boolean ishot) {
		this.ishot = ishot;
	}
	public EB2C getType() {
		return type;
	}
	public String getTypeName() {
		return EB2C.getName(type);
	}
	public void setType(EB2C type) {
		this.type = type;
	}
	public EShow getShowtype() {
		return showtype;
	}
	public void setShowtype(EShow showtype) {
		this.showtype = showtype;
	}
	public int getSellcount() {
		return sellcount;
	}
	public void setSellcount(int sellcount) {
		this.sellcount = sellcount;
	}
	public int getBuyercount() {
		return buyercount;
	}
	public void setBuyercount(int buyercount) {
		this.buyercount = buyercount;
	}
	public int getClickcount() {
		return clickcount;
	}
	public void setClickcount(int clickcount) {
		this.clickcount = clickcount;
	}
	public int getCommentscount() {
		return commentscount;
	}
	public void setCommentscount(int commentscount) {
		this.commentscount = commentscount;
	}
	/**
	 * @return the galleries
	 */
	public List<Gallery> getGalleries() {
		return galleries;
	}
	/**
	 * @param galleries the galleries to set
	 */
	public void setGalleries(List<Gallery> galleries) {
		if (galleries != null) {
			this.galleries = galleries;
		}
	}
	/**
	 * @return the comments
	 */
	public List<Comment> getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
}
