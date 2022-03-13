package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {

    private static UserServiceImpl userService = new UserServiceImpl();

    public static void main(String[] args) {

        userService.createUsersTable();

        userService.saveUser("Алексей", "Алексеев", (byte) 25);
        userService.saveUser("Петр", "Петров", (byte) 31);
        userService.saveUser("Иван", "Иванов", (byte) 40);
        userService.saveUser("Павел", "Павлов", (byte) 22);

        userService.removeUserById(3);

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}
