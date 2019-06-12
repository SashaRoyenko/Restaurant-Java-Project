package com.robosh.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Dish {
    private long id;
    private String name;
    private float price;
    private short weight;
    private List<Ingredient> ingredientList = new ArrayList<>();

    public Dish() {
    }

    public Dish(long id, String name, float price, short weight, List<Ingredient> ingredientList) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.ingredientList = ingredientList;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public short getWeight() {
        return weight;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredientList.add(ingredient);
    }

    public static Builder newBuilder() {
        return new Dish().new Builder();
    }

    public class Builder {
        private Builder() {

        }

        public Builder setId(long id) {
            Dish.this.id = id;
            return this;
        }

        public Builder setName(String name) {
            Dish.this.name = name;
            return this;
        }

        public Builder setPrice(float price) {
            Dish.this.price = price;
            return this;
        }

        public Builder setWeight(short weight) {
            Dish.this.weight = weight;
            return this;
        }

        public Builder setIngredientList(List<Ingredient> ingredientList) {
            Dish.this.ingredientList = ingredientList;
            return this;
        }

        public Builder addIngredient(Ingredient ingredient) {
            Dish.this.ingredientList.add(ingredient);
            return this;
        }

        public Dish build() {
            return Dish.this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return id == dish.id &&
                Float.compare(dish.price, price) == 0 &&
                weight == dish.weight &&
                Objects.equals(name, dish.name) &&
                Objects.equals(ingredientList, dish.ingredientList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, weight, ingredientList);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", ingredientList=" + ingredientList +
                '}';
    }
}
