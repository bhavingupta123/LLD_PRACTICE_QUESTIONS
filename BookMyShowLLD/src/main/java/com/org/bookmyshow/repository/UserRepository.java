package com.org.bookmyshow.repository;

import com.org.bookmyshow.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    private List<User> userList = new ArrayList<>();

    public User getUserById(String userId){
        for (User user: userList
             ) {
            if (user.getUserId() == userId){
                return user;
            }
        }

        return null;
    }

}
