/**
 * 分页实体类
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
 * Create at: 2012-9-14 上午7:33:59
 * ============================================================================
 */
package com.jiazu.web.base.entity;

import java.util.List;

import org.apache.commons.lang3.StringUtils;


/**
 * @author Architect.bian
 *
 */
public class Pager {
	
	public enum OrderType{
		asc, desc
	}
	public static final int MAX_PAGE_SIZE = 500;// 每页最大记录数限制
	private int pageNumber = 1;// 当前页码
	private int pageSize = 20;// 每页记录数
	private int totalCount = 0;// 总记录数
	private int pageCount = 0;// 总页数
	private int listSize = 0;
//	private String property;// 查找属性名称
//	private String keyword;// 查找关键字
	private String orderBy = "createTime";// 排序字段
	private OrderType orderType = OrderType.desc;// 排序方式
//	private List<Object> list;// 数据List

	public Pager() {}

	/**
	 * @param i
	 */
	public Pager(int size) {
		this.pageSize = size;
	}

	/**
	 * @param pageNumber2
	 * @param i
	 */
	public Pager(int num, int i) {
		this(i);
		this.pageNumber = num;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		if (pageNumber < 1) {
			pageNumber = 1;
		}
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize < 1) {
			pageSize = 1;
		} else if(pageSize > MAX_PAGE_SIZE) {
			pageSize = MAX_PAGE_SIZE;
		}
		this.pageSize = pageSize;
	}
	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageCount() {
		pageCount = totalCount / pageSize;
		if (totalCount % pageSize > 0) {
			pageCount ++;
		}
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
//
//	public String getProperty() {
//		return property;
//	}
//
//	public void setProperty(String property) {
//		this.property = property;
//	}
//
//	public String getKeyword() {
//		return keyword;
//	}
//
//	public void setKeyword(String keyword) {
//		this.keyword = keyword;
//	}
	
	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}
//
//	public List getList() {
//		return list;
//	}
//
//	public void setList(List list) {
//		this.list = list;
//	}

	/**
	 * @return
	 */
	public int getStartIndex() {
		if (this.pageNumber > 0) {
			return (this.pageNumber - 1) * this.pageSize;
		} else {
			return 0;
		}
	}

	/**
	 * @param list
	 */
	public void refresh(List<?> list) {
		if (list != null) {
			this.setListSize(list.size());
		}
	}

	/**
	 * @param num
	 * @param i
	 * @return
	 */
	public static Pager getNewInstance(String num, int i) {
		if (StringUtils.isNumeric(num)) {
			return new Pager(Integer.valueOf(num), i);
		} else {
			return new Pager(1, i);
		}
	}

}
