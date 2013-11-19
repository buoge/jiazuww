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
 * Create at: 2012-9-2 下午3:09:16
 * ============================================================================
 */
package com.jiazu.web.shop.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.services.AlipayService;
import com.alipay.util.AlipayNotify;
import com.jiazu.global.constants.EB2C;
import com.jiazu.global.constants.EOrder;
import com.jiazu.global.constants.EPay;
import com.jiazu.global.constants.GlobalConstant;
import com.jiazu.global.constants.MapperConstant;
import com.jiazu.global.constants.MsgConstant;
import com.jiazu.global.constants.SysConf;
import com.jiazu.global.constants.ViewKeyConstant;
import com.jiazu.global.utility.DateUtil;
import com.jiazu.global.utility.StrUtil;
import com.jiazu.web.base.controller.BaseController;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.platform.entity.User;
import com.jiazu.web.platform.proxy.UserPX;
import com.jiazu.web.shop.entity.Address;
import com.jiazu.web.shop.entity.B2C;
import com.jiazu.web.shop.entity.Order;
import com.jiazu.web.shop.entity.OrderDetail;
import com.jiazu.web.shop.proxy.AddressPX;
import com.jiazu.web.shop.proxy.B2CPX;
import com.jiazu.web.shop.proxy.OrderPX;
import com.jiazu.web.shop.proxy.RegionPX;

/**
 * @author Architect.bian
 * 
 */
@Controller
public class OrderController extends BaseController {

	private static final String MYORDER = "/myorder";
	private static final String MYCART = "/mycart";
	private static final String ALIPAY_RETURN = "ALIPAY_RETURN";
	private static final String ALIPAY_NOTIFY = "ALIPAY_NOTIFY";

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = MYCART, method = RequestMethod.GET)
	public String mycart(Map<String, Object> model, HttpServletRequest request) {
		User u = getCurrUser(request);
		if (u != null) {
			model.put(ViewKeyConstant.list, OrderPX.getCart(u.getUid()).values());
		}
		return "cart";
	}

	@RequestMapping(value = MYCART, method = RequestMethod.POST, params = "!_method")
	public String cartAdd(Map<String, Object> model, String uid, int num, HttpServletRequest request) {
		User u = getCurrUser(request);
		if (u != null) {
			B2C b2c = B2CPX.get(uid);
			if (b2c != null) {
				b2c.setNumber(num);
				if (OrderPX.addCart(u.getUid(), b2c)) {
					model.put(ViewKeyConstant.msg, MsgConstant.addSuccess);
				}
			} else {
				model.put(ViewKeyConstant.msg, MsgConstant.err_goodsnotfound);
			}
			return prefixRedirect + MYCART;
		} else {
			return "/login";
		}
	}

	@RequestMapping(value = MYCART + "/update", method = RequestMethod.POST)
	public String cartUpdate(Map<String, Object> model, HttpServletRequest request) {
		User u = getCurrUser(request);
		if (u != null) {
			Map<String, B2C> map = OrderPX.getCart(u.getUid());
			for (String key : map.keySet()) {
				String num = request.getParameter("num" + map.get(key).getUid());
				if (StringUtils.isNumeric(num)) {
					map.get(key).setNumber(Integer.valueOf(num));
				}
			}
			if (OrderPX.saveCart(u.getUid(), map)) {
				model.put(ViewKeyConstant.msg, MsgConstant.saveSuccess);
			}
			return prefixRedirect + MYORDER;
		} else {
			return "/login";
		}
	}

	@RequestMapping(value = MYCART, method = RequestMethod.POST, params = "_method=delete")
	public String cartDelete(Map<String, Object> model, String uids, HttpServletRequest request) {
		User u = getCurrUser(request);
		if (u != null) {
			String uid = u.getUid();
			Map<String, B2C> map = OrderPX.getCart(uid);
			Set<String> keyset = map.keySet();
			for (String key : keyset) {
				String num = request.getParameter("num" + map.get(key).getUid());
				if (StringUtils.isNumeric(num)) {
					map.get(key).setNumber(Integer.valueOf(num));
				}
			}
			for (String k : uids.split(",")) {
				map.remove(k);
			}
			if (OrderPX.saveCart(uid, map)) {
				model.put(ViewKeyConstant.msg, MsgConstant.deleteSuccess);
			} else {
				model.put(ViewKeyConstant.msg, MsgConstant.deleteFailed);
			}
			mycart(model, request);
			return prefixRedirect + MYCART;
		}
		return "/login";
	}

	@RequestMapping(value = "/buy", method = RequestMethod.POST)
	public String buy(Map<String, Object> model, String uid, int num, HttpServletRequest request) {
		User u = getCurrUser(request);
		if (u != null) {
			List<B2C> cart = new ArrayList<>();
			B2C b2c = B2CPX.get(uid);
			if (b2c != null) {
				b2c.setNumber(num);
				cart.add(b2c);
				model.put(ViewKeyConstant.list, cart);
			}
			double money = 0;
			double fee = SysConf.ShippingFee;
			if (b2c.getType() == EB2C.money) {//设置运费
				fee = 0;
			}
			money += b2c.getShopprice() * b2c.getNumber();
			model.put(ViewKeyConstant.fee, fee);
			model.put(ViewKeyConstant.money, money);
			String useruid = u.getUid();
			model.put(ViewKeyConstant.addressList, AddressPX.getList(useruid));
			model.put(ViewKeyConstant.provinceList, RegionPX.getProvinceList());
			return "order";
		}
		return "/login";
	}

	@RequestMapping(value = MYORDER, method = RequestMethod.GET)
	public String order(Map<String, Object> model, HttpServletRequest request) {
		User u = getCurrUser(request);
		if (u != null) {
			String uid = u.getUid();
			Collection<B2C> cart = OrderPX.getCart(uid).values();
			double money = 0;
			double fee = 0;
			for (B2C b2c : cart) {
				money += b2c.getShopprice() * b2c.getNumber();
				// fee += b2c.getShippingfee();
				if (b2c.getType() != EB2C.money) {//设置运费
					fee = SysConf.ShippingFee;
				}
			}
			model.put(ViewKeyConstant.fee, fee);
			model.put(ViewKeyConstant.money, money);
			model.put(ViewKeyConstant.list, cart);
			model.put(ViewKeyConstant.addressList, AddressPX.getList(uid));
			model.put(ViewKeyConstant.provinceList, RegionPX.getProvinceList());
			return "order";
		}
		return "/login";
	}

	@RequestMapping(value = "orderview/{uid:.{32}}", method = RequestMethod.GET)
	public String orderView(Map<String, Object> model, @PathVariable String uid, String admin, HttpServletRequest request) {
		User u = getCurrUser(request);
		if (u != null || (StringUtils.isNotEmpty(admin) && "true".equals(admin))) {
			Order order = OrderPX.get(uid);
			double minusprice = order.getMinusprice();
			Collection<B2C> cart = new ArrayList<>();
			double money = 0;//总金额
			double fee = 0;
			for (OrderDetail item : order.getDetails()) {
				B2C b2c = B2CPX.get(item.getB2cuid());
				if (b2c != null) {
					money += b2c.getShopprice() * item.getNum();
					b2c.setNumber(item.getNum());
					if (b2c.getType() != EB2C.money) {//设置运费
						fee = SysConf.ShippingFee;
					}
					cart.add(b2c);
				}
			}
			model.put(ViewKeyConstant.order, order);
			model.put(ViewKeyConstant.fee, fee);
			model.put(ViewKeyConstant.minusprice, minusprice);
			model.put(ViewKeyConstant.money, money);
			model.put(ViewKeyConstant.list, cart);
			return "orderview";
		}
		return "/login";
	}

	/**
	 * 提交订单
	 * 
	 * @param address
	 * @param uids
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = MYORDER, method = RequestMethod.POST)
	public String order(String address, String[] uids, Map<String, Object> model, HttpServletRequest request) {
		User u = getCurrUser(request);
		if (u != null) {
			Address addr = AddressPX.get(StrUtil.trim(address, GlobalConstant.COMMA));
			double fee = 0;
			if (addr != null) {
				Order order = new Order(addr);
				order.setUseruid(u.getUid());
				order.setUserid(u.getUserid());
				order.setUsername(u.getName());
				order.setOrdersn(DateUtil.getNowForID() + StrUtil.getRandomString(6));
				order.setMemo(request.getParameter("memo"));
				double totalprice = 0;
				totalprice += order.getShippingfee();
				List<String> todelete = new ArrayList<>();
				for (String uid : uids) {
					B2C b2c = B2CPX.get(uid);
					if (b2c != null) {
						String strnum = request.getParameter("num" + b2c.getUid());
						if (StringUtils.isNumeric(strnum) && strnum.charAt(0) > '0') {
							int num = Integer.valueOf(strnum);
							order.getDetails().add(new OrderDetail(b2c, num));
							totalprice += b2c.getShopprice() * num;
							todelete.add(uid);
							if (b2c.getType() != EB2C.money) {//设置运费
								fee = SysConf.ShippingFee;
							}
						}
					}
				}
				order.setShippingfee(fee);
				order.setTotalprice(totalprice + order.getShippingfee());
				if (order.getDetails().size() > 0) {
					if (OrderPX.create(order)) {
						OrderPX.deleteCart(u.getUid(), todelete);
						return alipayto(model, order);// 转入支付宝
					}
				}
				model.put(ViewKeyConstant.msg, MsgConstant.submitFailed);
			} else {
				model.put(ViewKeyConstant.msg, "请填写收货地址！");
			}

			// 失败处理逻辑
			
			double money = 0;
			List<B2C> cart = new ArrayList<>();
			for (String uid : uids) {

				B2C b2c = B2CPX.get(uid);
				if (b2c != null) {
					String strnum = request.getParameter("num" + uid);
					int num = StringUtils.isNumeric(strnum) ? Integer.valueOf(strnum) : 0;
					b2c.setNumber(num);
					cart.add(b2c);
					money += b2c.getShopprice() * b2c.getNumber();
					if (b2c.getType() != EB2C.money) {//设置运费
						fee = SysConf.ShippingFee;
					}
				}
			}
			model.put(ViewKeyConstant.fee, fee);
			model.put(ViewKeyConstant.money, money);
			model.put(ViewKeyConstant.list, cart);
			String useruid = u.getUid();
			model.put(ViewKeyConstant.addressList, AddressPX.getList(useruid));
			model.put(ViewKeyConstant.provinceList, RegionPX.getProvinceList());
			return "order";
		}
		return "/login";
	}
	
	

	/**
	 * 支付宝支付
	 * 
	 * @param model
	 * @param order
	 * @return
	 */
	private String alipayto(Map<String, Object> model, Order order) {
		// 唯一订单号
		String out_trade_no = order.getOrdersn();
		// 订单名称，显示在支付宝收银台里的“商品名称”里，显示在支付宝的交易管理的“商品名称”的列表里。
		String subject = "";
		for (OrderDetail item : order.getDetails()) {
			subject += item.getB2cname();
		}
		// 订单描述、订单详细、订单备注，显示在支付宝收银台里的“商品描述”里
		String body = subject;
		// 订单总金额，显示在支付宝收银台里的“应付总额”里
		String price = String.valueOf(order.getLastTotalprice());
		// 物流费用，即运费。
		String logistics_fee = order.getLastTotalprice() > order.getShippingfee() ? String.valueOf(order.getShippingfee()) : "0";
		// 物流类型，三个值可选：EXPRESS（快递）、POST（平邮）、EMS（EMS）
		String logistics_type = "EXPRESS";
		// 物流支付方式，两个值可选：SELLER_PAY（卖家承担运费）、BUYER_PAY（买家承担运费）
		String logistics_payment = "SELLER_PAY";

		// 商品数量，建议默认为1，不改变值，把一次交易看成是一次下订单而非购买一件商品。
		String quantity = "1";

		// 扩展参数//

		// 买家收货信息（推荐作为必填）
		// 该功能作用在于买家已经在商户网站的下单流程中填过一次收货信息，而不需要买家在支付宝的付款流程中再次填写收货信息。
		// 若要使用该功能，请至少保证receive_name、receive_address有值
		String receive_name = order.getConsignee(); // 收货人姓名，如：张三
		String receive_address = order.getAddress(); // 收货人地址，如：XX省XXX市XXX区XXX路XXX小区XXX栋XXX单元XXX号
		String receive_zip = order.getZipcode(); // 收货人邮编，如：123456
		String receive_phone = order.getTel(); // 收货人电话号码，如：0571-81234567
		String receive_mobile = "";//order.getMobile(); // 收货人手机号码，如：13312341234
		String show_url = SysConf.WebSiteUrl + "/orderview/" + order.getUid();

		// ////////////////////////////////////////////////////////////////////////////////

		// 把请求参数打包成数组
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("payment_type", "1");
		sParaTemp.put("show_url", show_url);
		sParaTemp.put("out_trade_no", out_trade_no);
		sParaTemp.put("subject", subject);
		sParaTemp.put("body", body);
		sParaTemp.put("price", price);
		sParaTemp.put("logistics_fee", logistics_fee);
		sParaTemp.put("logistics_type", logistics_type);
		sParaTemp.put("logistics_payment", logistics_payment);
		sParaTemp.put("quantity", quantity);
		sParaTemp.put("receive_name", receive_name);
		sParaTemp.put("receive_address", receive_address);
		sParaTemp.put("receive_zip", receive_zip);
		sParaTemp.put("receive_phone", receive_phone);
		sParaTemp.put("receive_mobile", receive_mobile);
		log.debug("read params for alipay, totalprice:" + order.getTotalprice() + "minusprice:" + order.getMinusprice() + "logistics_fee:" + logistics_fee);
		log.debug("read params for alipay,sParaTemp:" + sParaTemp.toString());
		// 构造函数，生成请求URL
		model.put(ViewKeyConstant.html, AlipayService.trade_create_by_buyer(sParaTemp));
//		model.put(ViewKeyConstant.html, "<form id=\"alipaysubmit\" name=\"alipaysubmit\" action=\"https://mapi.alipay.com/gateway.do?_input_charset=UTF-8\" method=\"get\"><input type=\"hidden\" name=\"body\" value=\"卡宾正品cab卡宾正品cabbeen浅灰小been浅灰小V\"/><input type=\"hidden\" name=\"logistics_type\" value=\"EXPRESS\"/><input type=\"hidden\" name=\"logistics_fee\" value=\"0.00\"/><input type=\"hidden\" name=\"subject\" value=\"卡宾正品cab卡宾正品cabbeen浅灰小been浅灰小V\"/><input type=\"hidden\" name=\"sign_type\" value=\"MD5\"/><input type=\"hidden\" name=\"receive_address\" value=\"北京市北京市辖县密云县 诗圣杜甫\"/><input type=\"hidden\" name=\"notify_url\" value=\"http://www.jiazuww.cn/trade_create_by_buyer_jsp_utf8/notify_url.jsp\"/><input type=\"hidden\" name=\"receive_phone\" value=\"010-1230098890\"/><input type=\"hidden\" name=\"receive_name\" value=\"嘻嘻\"/><input type=\"hidden\" name=\"out_trade_no\" value=\"20121110185539z6s9ke\"/><input type=\"hidden\" name=\"return_url\" value=\"http://127.0.0.1:8080/alipay/return_url\"/><input type=\"hidden\" name=\"sign\" value=\"1f157898b3511818dc2affb0d7c45fa5\"/><input type=\"hidden\" name=\"_input_charset\" value=\"UTF-8\"/><input type=\"hidden\" name=\"price\" value=\"54.0\"/><input type=\"hidden\" name=\"service\" value=\"trade_create_by_buyer\"/><input type=\"hidden\" name=\"receive_mobile\" value=\"1920099909\"/><input type=\"hidden\" name=\"quantity\" value=\"1\"/><input type=\"hidden\" name=\"receive_zip\" value=\"100086\"/><input type=\"hidden\" name=\"logistics_payment\" value=\"SELLER_PAY\"/><input type=\"hidden\" name=\"payment_type\" value=\"1\"/><input type=\"hidden\" name=\"show_url\" value=\"http://www.jiazuww.com/b2c\"/><input type=\"submit\" value=\"确认\" style=\"display:none;\"></form>");
		return "alipayto";
	}

	@RequestMapping("myordersuccess")
	public String orderSuccess(Map<String, String> model) {
		return "myordersuccess";
	}

	@RequestMapping(value = "/alipay/return_url")
	public String alipayReturnCheck(Map<String, Object> model, HttpServletRequest request) {
		log.debug("/alipay/return_url:" + request.getRequestURI() + "?" + request.getQueryString());
		if (alipayNotifyHandler(model, request, ALIPAY_RETURN)) {
			model.put(ViewKeyConstant.msg, "恭喜您，支付成功！");
		} else {
			model.put(ViewKeyConstant.msg, "支付失败！");
		}
		return "myordersuccess";
	}
	
	
	@RequestMapping(value = "/alipay/notify_url")
	public @ResponseBody String alipayNotify(Map<String, Object> model, HttpServletRequest request) {
		log.debug("/alipay/notify_url:" + request.getRequestURI() + "?" + request.getQueryString());
		if (alipayNotifyHandler(model, request, ALIPAY_NOTIFY)) {
			return "success";
		} else {
			return "failed";
		}
	}
	
	@SuppressWarnings("unused")
	private boolean alipayNotifyHandler(Map<String, Object> model, HttpServletRequest request, String type) {
		try {
			Map<String, String> params = new HashMap<String, String>();
			Map<?, ?> requestParams = request.getParameterMap();
			for (Iterator<?> iter = requestParams.keySet().iterator(); iter.hasNext();) {
				String name = (String) iter.next();
				String[] values = (String[]) requestParams.get(name);
				String valueStr = "";
				for (int i = 0; i < values.length; i++) {
					valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
				}
				// 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
				//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8");
				params.put(name, valueStr);
			}

			// 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//

			String trade_no = request.getParameter("trade_no"); // 支付宝交易号
			String order_no = request.getParameter("out_trade_no"); // 获取订单号
			String total_fee = request.getParameter("price"); // 获取总金额
			String subject = request.getParameter("subject");//new String(request.getParameter("subject").getBytes("ISO-8859-1"), "UTF-8");// 商品名称、订单名称
			String body = "";
			if(request.getParameter("body") != null){
				body = new String(request.getParameter("body").getBytes("ISO-8859-1"), "UTF-8");//商品描述、订单备注、描述
			}
			String buyer_email = request.getParameter("buyer_email");		//买家支付宝账号
			String receive_name = "";//收货人姓名
			if(request.getParameter("receive_name") != null){
				receive_name = request.getParameter("receive_name");//new String(request.getParameter("receive_name").getBytes("ISO-8859-1"), "UTF-8");
			}
			String receive_address = "";//收货人地址
			if(request.getParameter("receive_address") != null){
				receive_address = request.getParameter("receive_address");//new String(request.getParameter("receive_address").getBytes("ISO-8859-1"), "UTF-8");
			}
			String receive_zip = "";//收货人邮编
			if(request.getParameter("receive_zip") != null){
				receive_zip = request.getParameter("receive_zip");//new String(request.getParameter("receive_zip").getBytes("ISO-8859-1"), "UTF-8");
			}
			String receive_phone = "";//收货人电话
			if(request.getParameter("receive_phone") != null){
				receive_phone = request.getParameter("receive_phone");//new String(request.getParameter("receive_phone").getBytes("ISO-8859-1"), "UTF-8");
			}
			String receive_mobile = "";//收货人手机
			if(request.getParameter("receive_mobile") != null){
				receive_mobile = request.getParameter("receive_mobile");//new String(request.getParameter("receive_mobile").getBytes("ISO-8859-1"), "UTF-8");
			}
			String trade_status = request.getParameter("trade_status");		//交易状态
			String refund_status = request.getParameter("refund_status");		//退款状态

			//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
			
			//计算得出通知验证结果
			boolean verify_result = AlipayNotify.verify(params);
			log.debug(type + " params:" + params.toString());
			if(verify_result){//验证成功
				if (StringUtils.isNotEmpty(refund_status)) {
					log.debug("get refund_status:" + refund_status + ",request type:" + type);
					if (type.equals(ALIPAY_RETURN)) {
						return alipayReturnRefundHandler(model, trade_no, order_no, refund_status);
					} else {
						return alipayNotifyRefundHandler(trade_no, order_no, refund_status);
					}
				} else {
					if (type.equals(ALIPAY_RETURN)) {
						return alipayReturnVerifyOkHandler(model, trade_no, order_no, trade_status);
					} else {
						return alipayNotifyVerifyOkHandler(trade_no, order_no, trade_status);
					}
				}
			}
			//该页面可做页面美工编辑
			model.put(ViewKeyConstant.ordersn, order_no);
			model.put(ViewKeyConstant.msg, "支付失败！");
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 异步调用的处理
	 * @param trade_no
	 * @param order_no
	 * @param trade_status
	 * @return
	 */
	protected boolean alipayNotifyVerifyOkHandler(String trade_no, String order_no, String trade_status) {
		//////////////////////////////////////////////////////////////////////////////////////////
		//请在这里加上商户的业务逻辑程序代码
		log.debug("before alipayNotifyVerifyOkHandler(trade_no:" + trade_no + ",order_no:" + order_no + ",trade_status:" + trade_status + ")");
		Order order = OrderPX.getBySN(order_no);
		order.setAlipayTradeNo(trade_no);
		//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
		if (order.getOrderstatus() == EOrder.success) {
			
		} else if(trade_status.equals("WAIT_BUYER_PAY")){
		//该判断表示买家已在支付宝交易管理中产生了交易记录，但没有付款
		
		//判断该笔订单是否在商户网站中已经做过处理（可参考“集成教程”中“3.4返回数据处理”）
		//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
		//如果有做过处理，不执行商户的业务程序
		
		} else if(trade_status.equals("WAIT_SELLER_SEND_GOODS")){
		//该判断表示买家已在支付宝交易管理中产生了交易记录且付款成功，但卖家没有发货
		order.setOrderstatus(EOrder.payed);
		//判断该笔订单是否在商户网站中已经做过处理（可参考“集成教程”中“3.4返回数据处理”）
		//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
		//如果有做过处理，不执行商户的业务程序
		
		} else if(trade_status.equals("WAIT_BUYER_CONFIRM_GOODS")){
		//该判断表示卖家已经发了货，但买家还没有做确认收货的操作
		order.setOrderstatus(EOrder.sending);
		//判断该笔订单是否在商户网站中已经做过处理（可参考“集成教程”中“3.4返回数据处理”）
		//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
		//如果有做过处理，不执行商户的业务程序
		
		} else if(trade_status.equals("TRADE_FINISHED")){
		//该判断表示买家已经确认收货，这笔交易完成
			return tradeSuccessHandler(order);
		//判断该笔订单是否在商户网站中已经做过处理（可参考“集成教程”中“3.4返回数据处理”）
		//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
		//如果有做过处理，不执行商户的业务程序
		
		}
		
		if (OrderPX.updateStatus(order.getUid(), order.getOrderstatus())) {
			return true;
		} else {
			return false;
		}
	}
	protected boolean alipayNotifyRefundHandler(String trade_no, String order_no, String refund_status) {
		log.debug("invoke alipayNotifyRefundHandler(trade_no:" + trade_no + ",order_no:" + order_no + ",refund_status:" + refund_status);
		Order order = OrderPX.getBySN(order_no);
		order.setAlipayTradeNo(trade_no);
		EPay status = getRefundStatus(refund_status);
		order.setPaystatus(status);
		if (status == EPay.REFUND_SUCCESS) {
			order.setOrderstatus(EOrder.failed);
		}
		log.debug("before OrderPX.updateStatus(" + order.getUid() + "," + status.name() + ")");
		if (OrderPX.update(order)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * alipay_return_url url回调时触发
	 * @param model
	 * @param trade_no
	 * @param order_no
	 * @param trade_status
	 * @return
	 */
	protected boolean alipayReturnVerifyOkHandler(Map<String, Object> model, String trade_no, String order_no,
			String trade_status) {
		//////////////////////////////////////////////////////////////////////////////////////////
		//请在这里加上商户的业务逻辑程序代码
		Order order = OrderPX.getBySN(order_no);
		order.setAlipayTradeNo(trade_no);

		//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
		
		if(trade_status.equals("WAIT_SELLER_SEND_GOODS")){
			//判断该笔订单是否在商户网站中已经做过处理（可参考“集成教程”中“3.4返回数据处理”）
				//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				//如果有做过处理，不执行商户的业务程序
			order.setPaystatus(EPay.payed);
			order.setOrderstatus(EOrder.payed);
		}

		if(trade_status.equals("TRADE_FINISHED") && order.getOrderstatus() != EOrder.success){
			order.setOrderstatus(EOrder.success);
			B2CPX.plusSellCount(order.getDetails());
			//判断该笔订单是否在商户网站中已经做过处理（可参考“集成教程”中“3.4返回数据处理”）
				//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				//如果有做过处理，不执行商户的业务程序
		}
		if (OrderPX.update(order)) {
			model.put(ViewKeyConstant.ordersn, order.getOrdersn());
			model.put(ViewKeyConstant.totalprice, order.getLastTotalprice());
			return true;
		} else {
			model.put(ViewKeyConstant.ordersn, order.getOrdersn());
			model.put(ViewKeyConstant.totalprice, order.getLastTotalprice());
			return false;
		}
		//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——

		//////////////////////////////////////////////////////////////////////////////////////////
	}
	protected boolean alipayReturnRefundHandler(Map<String, Object> model, String trade_no, String order_no,String refund_status) {
		log.debug("invoke alipayReturnRefundHandler(trade_no:" + trade_no + ",order_no:" + order_no + ",refund_status:" + refund_status);
		Order order = OrderPX.getBySN(order_no);
		order.setAlipayTradeNo(trade_no);
		EPay status = getRefundStatus(refund_status);
		order.setPaystatus(status);
		if (status == EPay.REFUND_SUCCESS) {
			order.setOrderstatus(EOrder.failed);
		}
		log.debug("before OrderPX.update(" + order.getUid() + "); refund_status:" + refund_status + ")");
		if (order.getOrderstatus() == EOrder.success) {
			return true;
		} else if (OrderPX.update(order)) {
			model.put(ViewKeyConstant.ordersn, order.getOrdersn());
			model.put(ViewKeyConstant.totalprice, order.getLastTotalprice());
			return true;
		} else {
			model.put(ViewKeyConstant.ordersn, order.getOrdersn());
			model.put(ViewKeyConstant.totalprice, order.getLastTotalprice());
			return false;
		}
		//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
		
		//////////////////////////////////////////////////////////////////////////////////////////
	}

	private EPay getRefundStatus(String refund_status) {
		log.debug("invoke getRefundStatus(" + refund_status + ")");
		if(refund_status.equals("WAIT_SELLER_AGREE")){
			return EPay.WAIT_SELLER_AGREE;
		} else if(refund_status.equals("SELLER_REFUSE_BUYER")){
			return EPay.SELLER_REFUSE_BUYER;
		} else if(refund_status.equals("WAIT_BUYER_RETURN_GOODS")){
			return EPay.WAIT_BUYER_RETURN_GOODS;
		} else if(refund_status.equals("WAIT_SELLER_CONFIRM_GOODS")){
			return EPay.WAIT_SELLER_CONFIRM_GOODS;
		} else if(refund_status.equals("REFUND_SUCCESS")){
			return EPay.REFUND_SUCCESS;
		} else {
			return EPay.REFUND_CLOSED;
		}
	}

	/**
	 * 订单成功结束处理操作，同时修改订单状态
	 * 
	 * @param order
	 * @return
	 */
	protected boolean tradeSuccessHandler(Order order) {
		log.debug(order.getUid() + " order status:" + order.getOrderstatus());
		order.setOrderstatus(EOrder.success);
		B2CPX.plusSellCount(order.getDetails());
		double usermoney = 0;
		for (OrderDetail item : order.getDetails()) {
			B2C b2c = B2CPX.get(item.getB2cuid());
			if (b2c != null) {
				log.debug("usermoney:" + usermoney + "type:" + EB2C.money.name() + "shopprice:" + b2c.getShopprice()
						+ " num:" + item.getNum());
				if (b2c.getType() == EB2C.money) {// 给会员增加金币
					usermoney += b2c.getShopprice() * item.getNum();
				}
			}
			if (usermoney > 0) {
				User user = UserPX.getUser(order.getUseruid());
				user.plusAccount(usermoney);
				UserPX.updateAccount(user.getUid(), user.getAccount());
			}
		}
		log.debug("before return OrderPX.updateStatus(" + order.getUid(), "," + order.getOrderstatus().name() + ")");
		return OrderPX.updateStatus(order.getUid(), order.getOrderstatus());
	}
	
	@RequestMapping(value = "/myhome/order", method = RequestMethod.GET)
	public String myorder(Map<String, Object> model, HttpServletRequest request) {
		User u = getCurrUser(request);
		if (u != null) {
			Pager pager = Pager.getNewInstance(request.getParameter("num"), 10);
			List<?> list = OrderPX.getList(u.getUid(), pager);
			model.put(ViewKeyConstant.list, list);
			pager.refresh(list);
			model.put(ViewKeyConstant.pager, pager);
		}
		return "myorder";
	}

	@RequestMapping(value = "/myhome/order/{uid:.{32}}", method = RequestMethod.POST)
	public String myorder(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		Order order = OrderPX.get(uid);
		if (order != null && order.getOrderstatus().equals(EOrder.sending) && OrderPX.updateStatus(uid, EOrder.success)) {
			model.put(ViewKeyConstant.msg, MsgConstant.doSuccess);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.doFailed);
		}
		return myorder(model, request);
	}

	@RequestMapping(value = {"/myhome/order/{uid:.{32}}/del"}, method = RequestMethod.GET)
	public String myorder_delete(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		if (OrderPX.delete(uid)) {
			model.put(ViewKeyConstant.msg, MsgConstant.doSuccess);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.doSuccess);
		}
		return myorder(model, request);
	}
	
	@RequestMapping(value = "/myhome/order/{uid:.{32}}/pay", method = RequestMethod.POST)
	public String myorder_pay(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		Order order = OrderPX.get(uid);
		if (order != null) {
			return alipayto(model, order);
		} else {
			model.put(ViewKeyConstant.errormsg, "订单不存在");
		}
		return "error";
	}
	
	@RequestMapping(value = "/admin/doorder", method = RequestMethod.GET)
	public String doorder(Map<String, Object> model, HttpServletRequest request) {
		Pager pager = Pager.getNewInstance(request.getParameter("num"), 20);
		List<Order> list = OrderPX.getList(pager);
		model.put(ViewKeyConstant.list, list);
		pager.refresh(list);
		model.put(ViewKeyConstant.pager, pager);
		return "doorder";
	}

	@RequestMapping(value = "/admin/doorder/search", method = RequestMethod.GET)
	public String doorder_search(Map<String, Object> model, String ordersn, String userid, String username, String orderstatus, String num) {
		Pager pager = Pager.getNewInstance(num, 20);
		Map<String, Object> map = getParamMap(pager);
		if (StringUtils.isNotEmpty(ordersn)) {
			map.put(MapperConstant.ordersn + MapperConstant.like, ordersn);
		}
		if (StringUtils.isNotEmpty(userid)) {
			map.put(MapperConstant.userid + MapperConstant.like, userid);//不存在的值
		}
		if (StringUtils.isNotEmpty(username)) {
			map.put(MapperConstant.username + MapperConstant.like, username);
		}
		if (StrUtil.isNumeric(orderstatus)) {
			map.put(MapperConstant.orderstatus, EOrder.get(Integer.valueOf(orderstatus)));
		}
		List<Order> list = OrderPX.getList(map);
		model.put(ViewKeyConstant.list, list);
		pager.refresh(list);
		model.put(ViewKeyConstant.pager, pager);
		model.put(ViewKeyConstant.ordersn, ordersn);
		model.put(ViewKeyConstant.userid, userid);
		model.put(ViewKeyConstant.username, username);
		model.put(ViewKeyConstant.orderstatus, orderstatus);
		return "doorder";
	}
	
	@RequestMapping(value = "/admin/doorder/{uid:.{32}}", method = RequestMethod.POST)
	public String doorder_update(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		if (OrderPX.updateStatus(uid, EOrder.sending)) {
			model.put(ViewKeyConstant.msg, MsgConstant.doSuccess);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.doSuccess);
		}
		return doorder(model, request);
	}

	@RequestMapping(value = "/admin/doorder/{uid:.{32}}/minusprice", method = RequestMethod.POST)
	public String doorder_minusprice(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		if (StrUtil.isNumeric(request.getParameter("minusprice")) && OrderPX.updateMinusprice(uid, Integer.valueOf(request.getParameter("minusprice")))) {
			model.put(ViewKeyConstant.msg, MsgConstant.doSuccess);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.doFailed);
		}
		return doorder(model, request);
	}

	@RequestMapping(value = {"/admin/doorder/{uid:.{32}}/del"}, method = RequestMethod.GET)
	public String doorder_delete(Map<String, Object> model, @PathVariable String uid, HttpServletRequest request) {
		if (OrderPX.delete(uid)) {
			model.put(ViewKeyConstant.msg, MsgConstant.doSuccess);
		} else {
			model.put(ViewKeyConstant.msg, MsgConstant.doSuccess);
		}
		return doorder(model, request);
	}
}
