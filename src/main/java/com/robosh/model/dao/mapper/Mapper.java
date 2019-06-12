package com.robosh.model.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Mapper<T> {
    T extractObjectFromResultSet(ResultSet resultSet) throws SQLException;
}
