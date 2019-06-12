package com.robosh.model.entity;

import com.robosh.model.entity.enums.Role;

import java.util.Objects;

public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private Role role;


    public User() {
    }

    public User(long id, String firstName, String lastName, String email, String phone, String password, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public static Builder newBuilder() {
        return new User().new Builder();
    }

    public class Builder {
        private Builder() {
        }

        public Builder setId(long id) {
            User.this.id = id;
            return this;
        }

        public Builder setFirstName(String firstName) {
            User.this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            User.this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            User.this.email = email;
            return this;
        }

        public Builder setPhone(String phone) {
            User.this.phone = phone;
            return this;
        }

        public Builder setPassword(String password) {
            User.this.password = password;
            return this;
        }

        public Builder setRole(Role role) {
            User.this.role = role;
            return this;
        }

        public User build() {
//            User user = new User();
//            user.id = User.this.id;
//            user.firstName = User.this.firstName;
//            user.lastName = User.this.lastName;
//            user.email = User.this.email;
//            user.phone = User.this.phone;
//            user.password = User.this.password;
//            user.role = User.this.role;
            return User.this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                firstName.equals(user.firstName) &&
                lastName.equals(user.lastName) &&
                email.equals(user.email) &&
                phone.equals(user.phone) &&
                password.equals(user.password) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, phone, password, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
