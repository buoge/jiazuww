/**
 * Mybatis的Joda datetime类型转换处理
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/**
 * @author GreatHost
 *
 */
@MappedTypes(DateTime.class)
//@MappedJdbcTypes(value = {JdbcType.DATE,JdbcType.TIME,JdbcType.TIMESTAMP})
public class JodaDateTimeTypeHandler extends BaseTypeHandler<DateTime> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, DateTime parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setTimestamp(i, new Timestamp(parameter.getMillis()));
	}

	@Override
	public DateTime getNullableResult(ResultSet rs, String columnName) throws SQLException {
	    return getJodaTime(rs.getTimestamp(columnName));
	}

	@Override
	public DateTime getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return getJodaTime(rs.getTimestamp(columnIndex));
	}

	@Override
	public DateTime getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return getJodaTime(cs.getTimestamp(columnIndex));
	}
	
	private DateTime getJodaTime(Timestamp stamp) {
	    if (stamp != null) {
	      return new DateTime(stamp.getTime(), DateTimeZone.forOffsetHours(8));
	    }
	    return null;
	}

}
