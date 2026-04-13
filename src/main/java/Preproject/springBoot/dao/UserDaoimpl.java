package Preproject.springBoot.dao;

import Preproject.springBoot.model.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoimpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void saveUser(String name, String surName, String department, int salary, String password) {
        Users user = new Users(name, surName, department, salary, password);
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void removeUserById(long id) {
        Users users = entityManager.find(Users.class, id);
        if (users != null) {
            entityManager.remove(users);
        }
    }

    @Override
    public List<Users> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM Users u ORDER BY u.id", Users.class).getResultList();
    }

    @Override
    @Transactional
    public void cleanUsersTable() {
        Query query = entityManager.createQuery("DELETE FROM Users");
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void updateUser(Users user) {
        entityManager.merge(user);
    }

    @Override
    public Users getUserById(long id) {
        return entityManager.find(Users.class, id);
    }
}

