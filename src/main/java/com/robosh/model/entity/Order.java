package com.robosh.model.entity;

import java.util.Date;
import java.util.Objects;

public class Order {
    private long id;
    private String address;
    private Date date;
    private float bill;
    private boolean paid;
    private User user;

    public Order() {
    }

    public Order(long id, String address, Date date, float bill, boolean paid, User user) {
        this.id = id;
        this.user = user;
        this.address = address;
        this.date = date;
        this.bill = bill;
        this.paid = paid;
    }

    public long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public Date getDate() {
        return date;
    }

    public float getBill() {
        return bill;
    }


    public User getUser() {
        return user;
    }

    public boolean isPaid() {
        return paid;
    }

    public static Order.Builder newBuilder() {
        return new Order().new Builder();
    }

    public class Builder {
        private Builder() {
        }

        public Builder setId(long id) {
            Order.this.id = id;
            return this;
        }

        public Builder setUser(User user) {
            Order.this.user = user;
            return this;
        }

        public Builder setAddress(String address) {
            Order.this.address = address;
            return this;
        }

        public Builder setDate(Date date) {
            Order.this.date = date;
            return this;
        }

        public Builder setBill(float bill) {
            Order.this.bill = bill;
            return this;
        }

        public Builder setPaid(boolean paid) {
            Order.this.paid = paid;
            return this;
        }

        public Order build() {
            return Order.this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                Float.compare(order.bill, bill) == 0 &&
                paid == order.paid &&
                Objects.equals(address, order.address) &&
                Objects.equals(date, order.date) &&
                Objects.equals(user, order.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, date, bill, paid, user);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", date=" + date +
                ", bill=" + bill +
                ", paid=" + paid +
                ", user=" + user +
                '}';
    }
}
