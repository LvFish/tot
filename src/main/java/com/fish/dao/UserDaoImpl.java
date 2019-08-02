package com.fish.dao;

import com.fish.model.UserModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {
    @Resource(name = "myJdbc")
    private JdbcTemplate myJdbc;

    @Override
    public List<UserModel> getAllUsers() {
        String sql = "select * from user";
        return query(sql);
    }

    @Override
    public UserModel getUser(String id) {
        return null;
    }

    @Override
    public boolean addUser(UserModel userModel) {
        return false;
    }

    @Override
    public boolean updateUser(String id, String name) {
        return false;
    }

    @Override
    public boolean deleteUser(String id) {
        return false;
    }

    private List<UserModel> query(String sql) {
        final List<UserModel> userModels = new ArrayList<>();
        myJdbc.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);
                UserModel userModel = new UserModel(id, name, age);
                userModels.add(userModel);
            }
        });
        return userModels;
    }
}