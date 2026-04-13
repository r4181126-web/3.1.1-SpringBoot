package Preproject.springBoot.dao;

import Preproject.springBoot.model.Users;
import java.util.List;

public interface UserDao {

    void saveUser(String name, String surName, String department, int salary, String password);

    void removeUserById(long id);

    List<Users> getAllUsers();

    void cleanUsersTable();

    void updateUser(Users user);

    Users getUserById(long id);
}
