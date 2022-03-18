package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {

    public static void main(String[] args) {

        UserServiceImpl userService = new UserServiceImpl();
        User user1 = new User("Алексей", "Алексеев", (byte) 25);
        User user2 = new User("Петр", "Петров", (byte) 31);
        User user3 = new User("Иван", "Иванов", (byte) 40);
        User user4 = new User("Павел", "Павлов", (byte) 22);

        userService.createUsersTable();

        userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        userService.saveUser(user4.getName(), user4.getLastName(), user4.getAge());

        userService.removeUserById(3);

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();

        System.out.println("OK");
    }
}
