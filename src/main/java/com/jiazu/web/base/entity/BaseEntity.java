/**
 * 实体类 - 基类
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
 * Create at: 2012-8-4 下午6:40:22
 * ============================================================================
 */
package com.jiazu.web.base.entity;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.jiazu.global.utility.DateUtil;
import com.jiazu.global.utility.GlobalUtil;

/**
 * @author Architect.bian
 *
 */
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;//默认ID
	private int oid;//自增主键
	private String uid;//唯一ID
	private String tid;//时间ID：201207072359
	private String toid;//本时间tid内的自增ID
	
	private DateTime createTime;//创建时间
	private DateTime updateTime;//更新时间
	
	/**
	 * @return the id
	 */
	public String getId() {
		if (StringUtils.isNotEmpty(id)) {
			return id;
		} else if (oid > 0) {
			return String.valueOf(oid);
		} else {
			return uid;
		}
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the oid
	 */
	public int getOid() {
		return oid;
	}
	/**
	 * @param oid the oid to set
	 */
	public void setOid(int oid) {
		this.oid = oid;
	}
	/**
	 * @return the uid
	 */
	public String getUid() {
		if (StringUtils.isEmpty(uid)) {
			uid = GlobalUtil.getUUID();
			return uid;
		}
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * @return the tid
	 */
	public String getTid() {
		return tid;
	}
	/**
	 * @param tid the tid to set
	 */
	public void setTid(String tid) {
		this.tid = tid;
	}
	/**
	 * @return the toid
	 */
	public String getToid() {
		return toid;
	}
	/**
	 * @param toid the toid to set
	 */
	public void setToid(String toid) {
		this.toid = toid;
	}
	/**
	 * @return the createTime
	 */
	public DateTime getCreateTime() {
		if (createTime == null) {
			createTime = new DateTime();
		}
		createTime = createTime.withZone(DateTimeZone.forOffsetHours(8));
//		System.out.println("-------------------" + createTime);
		return createTime;
	}
	
	public String getTime() {
		if (createTime == null) {
			return "";
		}
		String time = "刚刚";
		if (createTime.plusSeconds(10).isAfterNow()) {
			//刚刚 10s内
		} else if (createTime.plusMinutes(1).isAfterNow()) {
			time = "10秒前";//一分钟内 10秒前
		} else if (createTime.plusMinutes(10).isAfterNow()) {
			time = "1分钟前";//10分钟内 一分钟前
		} else if (createTime.plusMinutes(30).isAfterNow()) {
			time = "10分钟前";//一分钟内 10秒前
		} else if (createTime.plusHours(1).isAfterNow()) {
			time = "30分钟前";//一分钟内 10秒前
		} else if (createTime.plusDays(1).isAfterNow()) {
			for (int i = 1; i < 24; i++) {
				if (createTime.plusHours(i + 1).isAfterNow()) {
					time = String.format("%d小时前", i);
					break;
				}
			}
		} else if (createTime.plusDays(1).isBeforeNow() && createTime.plusDays(2).isAfterNow()) {
			time = "一天前";//一分钟内 10秒前
		} else {
			time = createTime.toString(DateUtil.FORMAT_DATETIME_CHINA);
		}
		
		return time;
	}
	
	public String getDate() {
		return getCreateTime().toString(DateUtil.FORMAT_DATE_CHINA);
	}

	/**
	 * @param createTime the createTime to set
	 */
	@DateTimeFormat(iso=ISO.DATE)
	public void setCreateTime(DateTime createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the updateTime
	 */
	public DateTime getUpdateTime() {
		return updateTime;
	}
	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(DateTime updateTime) {
		this.updateTime = updateTime;
	}
	
	@Override
	public int hashCode() {
		return StringUtils.isEmpty(StringUtils.trim(uid)) ? System.identityHashCode(this) : uid.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if (this.hashCode() == o.hashCode()) {
			return true;
		} else {
			return false;
		}
	}

}
