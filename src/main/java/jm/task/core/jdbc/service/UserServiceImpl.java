package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kata", "root", "aA5771521");
            userDao = new UserDaoJDBCImpl(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createUsersTable() {
        try {
            userDao.createUsersTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        try {
            userDao.dropUsersTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {
            userDao.saveUser(name, lastName, age);
            System.out.println("User  с именем - " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        try {
            userDao.removeUserById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        try {
            return userDao.getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void cleanUsersTable() {
        try {
            userDao.cleanUsersTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
