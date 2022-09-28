package com.navercorp.pinpoint.metric.web.mybatis.typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class HistogramTypeHandler implements TypeHandler<List<Integer>> {
    @Override
    public void setParameter(PreparedStatement ps, int i, List<Integer> parameter, JdbcType jdbcType) throws SQLException {
        ps.setObject(i, parameter);
    }

    @Override
    public List<Integer> getResult(ResultSet rs, String columnName) throws SQLException {
        return (List<Integer>) rs.getObject(columnName);
    }

    @Override
    public List<Integer> getResult(ResultSet rs, int columnIndex) throws SQLException {
        return (List<Integer>) rs.getObject(columnIndex);
    }

    @Override
    public List<Integer> getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return (List<Integer>) cs.getObject(columnIndex);
    }
}
