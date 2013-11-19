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
 * Create at: 2012-8-5 下午8:37:17
 * ============================================================================
 */
package com.jiazu.web.base.dao;

import java.util.List;
import java.util.Map;

/**
 * @author Architect.bian
 *
 */
public interface BaseDao<T> {
	
	/**
	 * 通过ID查询数据库，返回对象
	 * @param id 对应数据库中uid
	 * @return
	 */
	T get(String id);
	
	/**
	 * 将键值对作为参数查询数据库返回一个对象
	 * @param map
	 * @return
	 */
	T getOne(Map<String, Object> map);
	
	/**
	 * 将键值对作为参数查询数据库返回一组对象
	 * @param map
	 * @return
	 */
	List<T> getList(Map<String, Object> map);
	
	/**
	 * 将对象插入数据库
	 * @param t
	 */
	void insert(T t);
	
	/**
	 * 更新对象所有的属性
	 * @param t
	 */
	void update(T t);
	
	/**
	 * 针对性的更新某几个字段
	 * @param map
	 */
	void updateFields(Map<String, Object> map);
	
	/**
	 * 删除操作
	 * @param id
	 */
	void delete(String id);
	
	/**
	 * 某字段的增长值
	 * @param map
	 */
	//void increase(Map<String, Object> map);
	
}
