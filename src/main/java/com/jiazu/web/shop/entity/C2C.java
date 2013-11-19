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
 * Create at: 2012-8-18 上午9:24:47
 * ============================================================================
 */
package com.jiazu.web.shop.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jiazu.global.constants.EC2C;
import com.jiazu.global.constants.EStatus;
import com.jiazu.web.base.entity.BaseEntity;

/**
 * @author Architect.bian
 *
 */
@Component
public class C2C extends BaseEntity {

	private static final long serialVersionUID = -2974509248188985361L;
	
	private String groupuid;
	private String useruid;
	private String sn;
	private String name;
	private int number = 0;
	private double price = 0;
	private String desc;
	private String contactname;
	private String telephone;
	private String qq;
	private String address;
	private String littlethumb;//100*100
	private String thumb;//124*124
	private String bigthumb;//160*160
	private String img;//800*800
	private String originalimg;
	private double newrate;
	private int sortorder = 0;
	/**
	 * 首页显示
	 */
	private boolean isbest = false;
	private boolean istop = false;
	private boolean ishot = false;
	private EStatus status = EStatus.enable;
	private EC2C type;
	private List<Gallery> galleries;
	
	public String getGroupuid() {
		return groupuid;
	}
	public void setGroupuid(String groupuid) {
		this.groupuid = groupuid;
	}
	public String getUseruid() {
		return useruid;
	}
	public void setUseruid(String useruid) {
		this.useruid = useruid;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getContactname() {
		return contactname;
	}
	public void setContactname(String contactname) {
		this.contactname = contactname;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the littlethumb
	 */
	public String getLittlethumb() {
		return littlethumb;
	}
	/**
	 * @param littlethumb the littlethumb to set
	 */
	public void setLittlethumb(String littlethumb) {
		this.littlethumb = littlethumb;
	}
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	/**
	 * @return the bigthumb
	 */
	public String getBigthumb() {
		return bigthumb;
	}
	/**
	 * @param bigthumb the bigthumb to set
	 */
	public void setBigthumb(String bigthumb) {
		this.bigthumb = bigthumb;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getOriginalimg() {
		return originalimg;
	}
	public void setOriginalimg(String originalimg) {
		this.originalimg = originalimg;
	}
	public double getNewrate() {
		return newrate;
	}
	public void setNewrate(double newrate2) {
		this.newrate = newrate2;
	}
	public int getSortorder() {
		return sortorder;
	}
	public void setSortorder(int sortorder) {
		this.sortorder = sortorder;
	}
	public boolean isbest() {
		return isbest;
	}
	public void setIsbest(boolean isbest) {
		this.isbest = isbest;
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
	public EStatus getStatus() {
		return status;
	}
	public void setStatus(EStatus status) {
		this.status = status;
	}
	public EC2C getType() {
		return type;
	}
	public String getTypeName() {
		return EC2C.getName(type);
	}
	public void setType(EC2C type) {
		this.type = type;
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
		this.galleries = galleries;
	}
	
	
}
