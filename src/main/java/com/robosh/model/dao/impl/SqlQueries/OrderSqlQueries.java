package com.robosh.model.dao.impl.SqlQueries;

public enum OrderSqlQueries {

    CREATE_ORDER("INSERT INTO `order`(address, user_user_id) values((?),(?));"),
    FIND_ORDER_BY_ID("SELECT * FROM `order`, user WHERE order_id = (?)"),
    FIND_ALL_ORDERS("SELECT * FROM `order`, user WHERE user_user_id = user_id"),
    UPDATE_PAID_STATUS("UPDATE `order` SET `paid` = true WHERE (`order_id` = (?))"),
    UPDATE_CHECK_STATUS("UPDATE `order` SET `checked` = true WHERE (`order_id` = (?))"),
    GET_PAID_STATUS("SELECT paid FROM `order`WHERE (`order_id` = (?))"),
    DELETE_ORDER("DELETE FROM `order` WHERE (order_id = (?))"),
    SELECT_UNCONFIRMED_ORDERS("SELECT * FROM `order`, user WHERE  user_user_id = user_id AND checked = false"),
    SELECT_PAID_ORDERS("SELECT * FROM `order`, user WHERE  user_user_id = user_id AND paid = true"),
    SELECT_USER_UNPAID_ORDERS("select * from `order`, user where user_user_id = user_id" +
            " AND checked = true AND paid = false AND user_id = ?");
    private String query;

    OrderSqlQueries(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }


}
