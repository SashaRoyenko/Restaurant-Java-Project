package com.robosh.model.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> extends AutoCloseable{
    //Create
    void create(T entity);

    //Read
    T findById(long id);

    List<T> findAll();

    //Update
    void update(T t) throws SQLException;

    //Delete
    void delete(long id) throws SQLException;

    //Close
    void close();
}
