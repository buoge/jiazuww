/**
 * Mybatis的Joda date类型转换处理
 * ============================================================================
 * 声明：北京旺族互联网科技有限公司版权所有
 * ----------------------------------------------------------------------------
 * Official Website: http://www.jiazuww.com
 * ----------------------------------------------------------------------------
 * Copyright: ? 2012 JiaZuWW All Rights Reserved.
 * ----------------------------------------------------------------------------
 * @version: 1.0
 * ----------------------------------------------------------------------------
 * @author: Greatbsky
 * ----------------------------------------------------------------------------
 * @email: verygreat@126.com
 * ----------------------------------------------------------------------------
 * Create at: 2012-8-9 上午11:16:57
 * ============================================================================
 */
package com.jiazu.core.mybatis.handlers;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;

/**
 * @author GreatHost
 *
 */
@MappedTypes(LocalDate.class)
//@MappedJdbcTypes(value = {JdbcType.DATE,JdbcType.TIME,JdbcType.TIMESTAMP})
public class JodaDateTypeHandler extends BaseTypeHandler<LocalDate> {

	/* (non-Javadoc)
	 * @see org.apache.ibatis.type.BaseTypeHandler#setNonNullParameter(java.sql.PreparedStatement, int, java.lang.Object, org.apache.ibatis.type.JdbcType)
	 */
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, LocalDate parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setDate(i, new Date(parameter.toDateTimeAtStartOfDay().toDate().getTime()));
	}

	/* (non-Javadoc)
	 * @see org.apache.ibatis.type.BaseTypeHandler#getNullableResult(java.sql.ResultSet, java.lang.String)
	 */
	@Override
	public LocalDate getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return getJodaTime(rs.getDate(columnName));
	}

	/* (non-Javadoc)
	 * @see org.apache.ibatis.type.BaseTypeHandler#getNullableResult(java.sql.ResultSet, int)
	 */
	@Override
	public LocalDate getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return getJodaTime(rs.getDate(columnIndex));
	}

	/* (non-Javadoc)
	 * @see org.apache.ibatis.type.BaseTypeHandler#getNullableResult(java.sql.CallableStatement, int)
	 */
	@Override
	public LocalDate getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return getJodaTime(cs.getDate(columnIndex));
	}

	private LocalDate getJodaTime(Date time) {
	    if (time != null) {
	      return new LocalDate(time.getTime(), DateTimeZone.forOffsetHours(8));
	    }
	    return null;
	}
}
