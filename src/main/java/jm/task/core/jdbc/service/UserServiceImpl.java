package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
        try {
            Connection connection = Util.getConnection();
            userDao = new UserDaoJDBCImpl(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createUsersTable() throws SQLException {
            userDao.createUsersTable();
    }

    @Override
    public void dropUsersTable() throws SQLException {
            userDao.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) throws SQLException {
            userDao.saveUser(name, lastName, age);
            System.out.println("User  с именем - " + name + " добавлен в базу данных");
    }

    @Override
    public void removeUserById(long id) throws SQLException {
            userDao.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
            return userDao.getAllUsers();
    }

    @Override
    public void cleanUsersTable() throws SQLException {
            userDao.cleanUsersTable();
    }
}
