package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.sql.SQLException;

public class Main {
    private final static UserService userService = new UserServiceImpl();

    public static void main(String[] args) throws SQLException {
        userService.createUsersTable();

        userService.saveUser("Люк", "Скайвокер", (byte) 33);
        userService.saveUser("Дональд", "Дак", (byte) 99);
        userService.saveUser("Гарри", "Поттер", (byte) 19);
        userService.saveUser("Эвоки", "Мохнатик", (byte) 4);

        userService.removeUserById(2);

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}
