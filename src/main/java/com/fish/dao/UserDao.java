package com.fish.dao;

import com.fish.model.UserModel;

import java.util.List;

public interface UserDao {
    List<UserModel> getAllUsers();
    UserModel getUser(String id);
    boolean addUser(UserModel userModel);
    boolean updateUser(String id, String name);
    boolean deleteUser(String id);
}
