/**
 * 某用户的最新消息等等 用户与文章的映射标记状态实体
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
 * Create at: 2012-9-16 下午2:09:44
 * ============================================================================
 */
package com.jiazu.web.platform.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jiazu.global.constants.EArticle;
import com.jiazu.global.constants.EMark;
import com.jiazu.global.constants.EStatus;
import com.jiazu.web.base.entity.BaseEntity;

/**
 * @author Architect.bian
 *
 */
@Component
@Scope("prototype")
public class ArticleMark extends BaseEntity {

	private static final long serialVersionUID = 1579282796857668014L;

	private String useruid;
	private String articleuid;
	private String note;
	private EArticle type;
	private EMark marktype;
	private EStatus status;
	
	public String getUseruid() {
		return useruid;
	}
	public void setUseruid(String useruid) {
		this.useruid = useruid;
	}
	public String getArticleuid() {
		return articleuid;
	}
	public void setArticleuid(String articleuid) {
		this.articleuid = articleuid;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public EArticle getType() {
		return type;
	}
	public String getTypeName() {
		return EArticle.getName(type);
	}
	public void setType(EArticle type) {
		this.type = type;
	}
	public EMark getMarktype() {
		return marktype;
	}
	public String getMarktypeName() {
		return EMark.getName(marktype);
	}
	public void setMarktype(EMark marktype) {
		this.marktype = marktype;
	}
	public EStatus getStatus() {
		return status;
	}
	public void setStatus(EStatus status) {
		this.status = status;
	}
	
	
}
