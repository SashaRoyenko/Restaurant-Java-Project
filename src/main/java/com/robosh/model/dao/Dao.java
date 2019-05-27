package com.robosh.model.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> extends AutoCloseable{
    //Create
    void create(T entity) throws SQLException;

    //Read
    T findById(long id) throws SQLException;

    List<T> findAll() throws SQLException;

    //Update
    void update(T t) throws SQLException;

    //Delete
    void delete(long id) throws SQLException;

    //Close
    void close();
}
