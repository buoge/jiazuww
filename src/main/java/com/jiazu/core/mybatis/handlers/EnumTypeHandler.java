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
 * Create at: 2012-8-19 上午8:43:31
 * ============================================================================
 */
package com.jiazu.core.mybatis.handlers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import com.jiazu.global.constants.EAddress;
import com.jiazu.global.constants.EAdmin;
import com.jiazu.global.constants.EArticle;
import com.jiazu.global.constants.EB2C;
import com.jiazu.global.constants.EC2C;
import com.jiazu.global.constants.EContent;
import com.jiazu.global.constants.EEducation;
import com.jiazu.global.constants.EEvent;
import com.jiazu.global.constants.EGender;
import com.jiazu.global.constants.EMark;
import com.jiazu.global.constants.EMsg;
import com.jiazu.global.constants.EOrder;
import com.jiazu.global.constants.EOrderLogType;
import com.jiazu.global.constants.EPay;
import com.jiazu.global.constants.EShipping;
import com.jiazu.global.constants.EShow;
import com.jiazu.global.constants.EStatus;
import com.jiazu.global.constants.EWish;
import com.jiazu.global.utility.StrUtil;

/**
 * @author Architect.bian
 * 
 */
@MappedTypes(value = { EStatus.class, EGender.class, EEducation.class, EEvent.class, EMsg.class, EWish.class,
		EOrderLogType.class, EOrder.class, EAddress.class,EB2C.class,EC2C.class,EContent.class,EPay.class,EShipping.class,
		EArticle.class, EMark.class, EAdmin.class, EShow.class
})
public class EnumTypeHandler<E extends Enum<E>> extends BaseTypeHandler<E> {

	private Class<E> type;

	public EnumTypeHandler(Class<E> type) {
		this.type = type;
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
		if (jdbcType == null) {
			ps.setString(i, parameter.toString());
		} else {
			ps.setObject(i, parameter.name(), jdbcType.TYPE_CODE);
		}
	}

	@Override
	public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return getEnum(rs.getString(columnName));
	}

	@Override
	public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return getEnum(rs.getString(columnIndex));
	}

	@Override
	public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return getEnum(cs.getString(columnIndex));
	}

	@SuppressWarnings("unchecked")
	private E getEnum(String s) {
		Method method = null;
		E result = null;
		// Method[] ms = type.getMethods();
		// for (Method m : ms) {
		// if (m.getName() == "get") {
		// method = m;
		// }
		// }
		if (s == null) {
			return null;
		}
		try {
			method = type.getMethod("get", int.class);
			if (StrUtil.isNumeric(s)) {
				result = (E) method.invoke(type, Integer.parseInt(s));
			} else {
				result = Enum.valueOf(type, s);
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e1) {
			result = Enum.valueOf(type, s);
			e1.printStackTrace();
		}
		return result;
	}
}
