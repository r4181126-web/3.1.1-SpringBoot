package Preproject.springBoot.service;

import Preproject.springBoot.model.Users;
import java.util.List;

    public interface UserService {
        void saveUser(Users user);

        void deleteUser(long id);

        List<Users> getAllUsers();

        void updateUser(Users user);

        Users getUserById(long id);
    }