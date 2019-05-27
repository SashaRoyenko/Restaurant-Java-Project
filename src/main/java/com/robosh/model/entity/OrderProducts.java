package com.robosh.model.entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderProducts {
    private long id;
    private User user;
    private List<Dish> dishList;
    private List<Drink> drinkList;

    public OrderProducts() {
        dishList = new ArrayList<>();
        drinkList = new ArrayList<>();
    }

    public OrderProducts(long id, User user, List<Dish> dishList, List<Drink> drinkList) {
        this.id =id;
        this.user = user;
        this.dishList = dishList;
        this.drinkList = drinkList;
    }

    public User getUser() {
        return user;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public List<Drink> getDrinkList() {
        return drinkList;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }

    public void setDrinkList(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    public static Builder newBuilder() {
        return new OrderProducts().new Builder();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void addDish(Dish dish) {
        dishList.add(dish);
    }

    public void addDrink(Drink drink) {
        drinkList.add(drink);
    }

    public class Builder {
        private Builder() {
        }

        public Builder setUser(User user) {
            OrderProducts.this.user = user;
            return this;
        }

        public Builder setId(long id) {
            OrderProducts.this.id = id;
            return this;
        }

        public Builder setDishList(List<Dish> dishList) {
            OrderProducts.this.dishList = dishList;
            return this;
        }

        public Builder setDrinkList(List<Drink> drinkList) {
            OrderProducts.this.drinkList = drinkList;
            return this;
        }

        public Builder addDish(Dish dish) {
            OrderProducts.this.dishList.add(dish);
            return this;
        }

        public Builder addDrink(Drink drink) {
            OrderProducts.this.drinkList.add(drink);
            return this;
        }

        public OrderProducts build(){
            return OrderProducts.this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderProducts that = (OrderProducts) o;
        return id == that.id &&
                Objects.equals(user, that.user) &&
                Objects.equals(dishList, that.dishList) &&
                Objects.equals(drinkList, that.drinkList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, dishList, drinkList);
    }

    @Override
    public String toString() {
        return "OrderProducts{" +
                "id=" + id +
                ", user=" + user +
                ", dishList=" + dishList +
                ", drinkList=" + drinkList +
                '}';
    }
}
