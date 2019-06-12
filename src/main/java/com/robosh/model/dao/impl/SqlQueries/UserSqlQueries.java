package com.robosh.model.dao.impl.SqlQueries;

public enum UserSqlQueries {
    CREATE_USER("INSERT INTO user " +
            "(first_name, last_name, phone, email, password) " +
            "VALUES ((?),(?),(?),(?),(?))"),
    FIND_USER_BY_ID("SELECT * FROM user WHERE user_id = (?)"),
    FIND_ALL_USERS("SELECT * FROM user"),
    UPDATE_USER_ROLE("UPDATE user SET role = (?) WHERE (user_id = (?))"),
    DELETE_USER("DELETE FROM user WHERE (user_id = (?))"),
    FIND_USER_BY_EMAIL_AND_PASSWORD("SELECT * FROM user WHERE email = (?) AND password = (?)"),
    FIND_PHONE("SELECT * FROM user WHERE phone = (?)"),
    FIND_EMAIL("SELECT * FROM user WHERE email = (?)");

    String query;

    UserSqlQueries(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
