package com.robosh.service;

import com.robosh.model.dao.DaoFactory;
import com.robosh.model.dao.UserDao;
import com.robosh.model.entity.User;
import com.robosh.model.exceptions.EmailIsAlreadyTaken;
import com.robosh.model.exceptions.PhoneIsAlreadyTaken;
import com.robosh.model.exceptions.UserIsNotExist;

/**
 * Class UserService
 * realise logic manipulation
 * with db for class User
 *
 * @author Sasha
 *
 */
public class UserService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    /**
     * This method is used
     * to create user in db.
     * If user with such phone or email is exist,
     * it throw exception
     * @param user
     * @throws EmailIsAlreadyTaken
     * @throws PhoneIsAlreadyTaken
     */
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

    /**
     * This method is used to extract user from db by this id
     * @param id
     * @return User
     */
    public User getUserById(long id){
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.findById(id);
        }
    }

    /**
     * This method is used to extract user from db using email and password
     * @param email
     * @param password
     * @return User
     */
    public User getUserByEmailAndPassword(String email, String password) {
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.getUserByEmailAndPassword(email, password);
        }
    }

    /**
     * This method is used to check if user with such email and password exist.
     * If not exist, it throw UserIsNotExist exception.
     * @param email
     * @param password
     * @throws UserIsNotExist
     */
    public void isUserExist(final String email, final String password) throws UserIsNotExist {
        try (UserDao dao = daoFactory.createUserDao()) {
            if(!dao.isUserExist(email, password)){
                throw new UserIsNotExist();
            }
        }
    }

    /**
     * This method is used to check if user with such email exist.
     * @param email
     * @return boolean
     */
    public boolean isEmailTaken(final String email) {
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.isEmailTaken(email);
        }
    }

    /**
     * This method is used to check if user with such phone exist.
     * @param phone
     * @return boolean
     */
    public boolean isPhoneTaken(final String phone) {
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.isPhoneTaken(phone);
        }
    }

}
