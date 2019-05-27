package com.robosh.model.dao.impl.SqlQueries;

public enum OrderSqlQueries {

    CREATE_ORDER("INSERT INTO `order`(address, user_user_id) values((?),(?));"),
    FIND_ORDER_BY_ID("SELECT * FROM `order`, user WHERE order_id = (?)"),
    FIND_ALL_ORDERS("SELECT * FROM `order`, user"),
    UPDATE_PAID_STATUS("UPDATE `order` SET `paid` = (?) WHERE (`order_id` = (?))"),
    GET_PAID_STATUS("SELECT paid FROM `order`WHERE (`order_id` = (?))"),
    DELETE_ORDER("DELETE FROM `order` WHERE (order_id = (?))");

    private String query;

    OrderSqlQueries(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }


}
