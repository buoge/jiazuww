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
 * Create at: 2012-8-18 上午9:03:05
 * ============================================================================
 */
package com.jiazu.web.shop.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Component;

import com.jiazu.global.constants.EOrder;
import com.jiazu.global.constants.EPay;
import com.jiazu.global.constants.EShipping;
import com.jiazu.web.base.entity.BaseEntity;
import com.jiazu.web.platform.entity.User;

/**
 * @author Architect.bian
 *
 */
@Component
public class Order extends BaseEntity {

	private static final long serialVersionUID = 8821995248524490167L;
	private String useruid;
	private String userid;
	private String username;
	private String ordersn;
	private String AlipayTradeNo;
	private int totalamount = 0;
	private double unitprice = 0;
	private double minusprice = 0;
	private double totalprice = 0;
	private String shippingid = "";
	private String postscript = "";
	private double shippingfee = 0;
	private String shipping_name = "";
	private String consignee = "";
	private String province = "0";
	private String city = "0";
	private String district = "0";
	private String address;
	private String zipcode;
	private String tel = "";
	private String mobile = "";
	private String email = "";
	private String memo = "";
	private EOrder orderstatus = EOrder.init;
	private EShipping shippingstatus = EShipping.init;
	private EPay paystatus = EPay.init;
	private String payid = "";
	private String payname = "";
	private LocalDate exprdate;
	private List<OrderDetail> details = new ArrayList<>();
	private User user;
	
	public Order() { }
	
	/**
	 * @param addr
	 * @param uids
	 */
	public Order(Address addr) {
		this.consignee = addr.getConsignee();
		this.province = addr.getProvince();
		this.city = addr.getCity();
		this.district = addr.getDistrict();
		this.address = addr.getAddress();
		this.zipcode = addr.getZipcode();
		this.tel = addr.getTel();
		this.mobile = addr.getMobile();
		this.email = addr.getEmail();
	}
	
	public String getUseruid() {
		return useruid;
	}
	public void setUseruid(String useruid) {
		this.useruid = useruid;
	}
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOrdersn() {
		return ordersn;
	}
	public void setOrdersn(String ordersn) {
		this.ordersn = ordersn;
	}
	public String getAlipayTradeNo() {
		return AlipayTradeNo;
	}

	public void setAlipayTradeNo(String alipayTradeNo) {
		AlipayTradeNo = alipayTradeNo;
	}

	public int getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(int totalamount) {
		this.totalamount = totalamount;
	}
	public double getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}
	public double getMinusprice() {
		return minusprice;
	}

	public void setMinusprice(double minusprice) {
		this.minusprice = minusprice;
	}

	public double getTotalprice() {
		return totalprice;
	}
	public double getLastTotalprice() {
//		return totalprice - minusprice;
		return Double.valueOf(NumberUtils.createBigDecimal(String.valueOf(totalprice)).subtract(NumberUtils.createBigDecimal(String.valueOf(minusprice))).toString());
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public String getShippingid() {
		return shippingid;
	}
	public void setShippingid(String shippingid) {
		this.shippingid = shippingid;
	}
	public String getPostscript() {
		return postscript;
	}
	public void setPostscript(String postscript) {
		this.postscript = postscript;
	}
	public double getShippingfee() {
		return shippingfee;
	}
	public void setShippingfee(double shippingfee) {
		this.shippingfee = shippingfee;
	}
	public String getShipping_name() {
		return shipping_name;
	}
	public void setShipping_name(String shipping_name) {
		this.shipping_name = shipping_name;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public EOrder getOrderstatus() {
		return orderstatus;
	}
	public String getOrderstatusName() {
		return EOrder.getName(orderstatus);
	}
	public void setOrderstatus(EOrder orderstatus) {
		this.orderstatus = orderstatus;
	}
	public EShipping getShippingstatus() {
		return shippingstatus;
	}
	public void setShippingstatus(EShipping shippingstatus) {
		this.shippingstatus = shippingstatus;
	}
	public EPay getPaystatus() {
		return paystatus;
	}
	public String getRefundStatusName() {
		if (paystatus == EPay.init || paystatus == EPay.payed || paystatus == EPay.REFUND_CLOSED) {
			return null;
		}
		return EPay.getName(paystatus);
	}
	public void setPaystatus(EPay paystatus) {
		this.paystatus = paystatus;
	}
	public String getPayid() {
		return payid;
	}
	public void setPayid(String payid) {
		this.payid = payid;
	}
	public String getPayname() {
		return payname;
	}
	public void setPayname(String payname) {
		this.payname = payname;
	}
	public LocalDate getExprdate() {
		return exprdate;
	}
	public void setExprdate(LocalDate exprdate) {
		this.exprdate = exprdate;
	}
	public List<OrderDetail> getDetails() {
		return details;
	}
	public void setDetails(List<OrderDetail> details) {
		this.details = details;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
