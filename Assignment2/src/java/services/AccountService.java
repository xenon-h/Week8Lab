/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.UserDB;
import models.Role;
import models.User;

/**
 *
 * @author 759005
 */
public class AccountService {
        public User login(String email, String password) {
        try {
            UserDB userDB = new UserDB();
            User user = userDB.get(email);
            if (password.equals(user.getPassword())) {
                return user;
            }
        } catch (Exception e) {
        }

        return null;
    }

    public Role getRole(String email) {
        try {
            UserDB userDB = new UserDB();
            User user = userDB.get(email);
            return user.getRole();
        } catch (Exception e) {
            return null;
        }

    }
}
