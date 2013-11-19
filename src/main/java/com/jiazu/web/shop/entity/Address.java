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
 * Create at: 2012-8-18 上午8:53:08
 * ============================================================================
 */
package com.jiazu.web.shop.entity;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import com.jiazu.global.constants.EAddress;
import com.jiazu.web.base.entity.BaseEntity;

/**
 * @author Architect.bian
 *
 */
@Component
@JsonIgnoreProperties(value = {"oid", "tid", "toid", "createTime", "updateTime", "date", "time"})
public class Address extends BaseEntity {

	private static final long serialVersionUID = -7078513120438749971L;
	private String splitter = " ";
	@JsonIgnore
	private String space = "   ";

	private String useruid;
	private String consignee;
	private String email;
	private String province = "0";
	private String city = "0";
	private String district = "0";
	private String address = "";
	private String addressExact = "";
	private String zipcode;
	private String tel;
	private String mobile = "";
	private EAddress type;
	
	public String getUseruid() {
		return useruid;
	}
	public void setUseruid(String useruid) {
		this.useruid = useruid;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
		int i = address.indexOf(splitter) + 1;
		if (i >= 0) {
			this.setAddressExact(address.substring(i));
		}
	}
	public String getAddressExact() {
		return this.addressExact;
	}
	public void setAddressExact(String addressExact) {
		this.addressExact = addressExact;
	}
	public String getSplitter() {
		return splitter;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public EAddress getType() {
		return type;
	}
	public void setType(EAddress type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return this.getAddress() + space + this.getTel() + space + this.getConsignee();
	}
}
