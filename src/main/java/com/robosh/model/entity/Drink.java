package com.robosh.model.entity;

import java.util.Objects;

public class Drink {
    private long id;
    private String name;
    private float price;
    private float volume;

    public Drink() {
    }

    public Drink(long id, String name, float price, float volume) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.volume = volume;
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

    public float getVolume() {
        return volume;
    }

    public static Builder newBuilder(){
        return new Drink().new Builder();
    }
    public class Builder {
        public Builder setId(long id) {
            Drink.this.id = id;
            return this;
        }

        public Builder setName(String name) {
            Drink.this.name = name;
            return this;
        }

        public Builder setPrice(float price) {

            Drink.this.price = price;
            return this;
        }

        public Builder setVolume(float volume) {
            Drink.this.volume = volume;
            return this;
        }

        public Drink build(){
            return Drink.this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drink drink = (Drink) o;
        return id == drink.id &&
                Float.compare(drink.price, price) == 0 &&
                Float.compare(drink.volume, volume) == 0 &&
                Objects.equals(name, drink.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, volume);
    }

    @Override
    public String toString() {
        return "Drink{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", volume=" + volume +
                '}';
    }
}
