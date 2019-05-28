package com.robosh.service;

import com.robosh.model.dao.DaoFactory;
import com.robosh.model.dao.UserDao;
import com.robosh.model.entity.User;
import com.robosh.model.exceptions.EmailIsAlreadyTaken;
import com.robosh.model.exceptions.PhoneIsAlreadyTaken;

public class UserService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    public void createUser(User user) throws EmailIsAlreadyTaken, PhoneIsAlreadyTaken {
        try (UserDao dao = daoFactory.createUserDao()) {
            boolean isEmailTaken = dao.isEmailTaken(user.getEmail());
            boolean isPhoneTaken = dao.isPhoneTaken(user.getPhone());
            if (isEmailTaken) {
                throw new EmailIsAlreadyTaken("This email is already registered");
            }
            if (isPhoneTaken) {
                throw new PhoneIsAlreadyTaken("This phone number is already registered");
            }
            dao.create(user);
        }
    }

    public User getUserById(long id){
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.findById(id);
        }
    }

    public User getUserByEmailAndPassword(String email, String password) {
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.getUserByEmailAndPassword(email, password);
        }
    }

    public boolean isUserExist(final String email, final String password) {
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.isUserExist(email, password);
        }
    }

    public boolean isEmailTaken(final String email) {
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.isEmailTaken(email);
        }
    }

    public boolean isPhoneTaken(final String phone) {
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.isPhoneTaken(phone);
        }
    }

}
