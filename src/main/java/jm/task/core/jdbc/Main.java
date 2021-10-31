package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        Util.getConnection();
        UserDaoJDBCImpl user = new UserDaoJDBCImpl();
        user.createUsersTable();
        user.saveUser("Alex", "Jhon", (byte) 50);
        user.saveUser("Josh", "Aby", (byte) 26);
        user.saveUser("Adaline", "Barden", (byte) 32);
        user.saveUser("Barbie", "Jhon", (byte) 22);
        for (User users: userService.getAllUsers()){
            System.out.println(users);
        }
        user.removeUserById(1);
        user.cleanUsersTable();
        user.dropUsersTable();
    }


}
