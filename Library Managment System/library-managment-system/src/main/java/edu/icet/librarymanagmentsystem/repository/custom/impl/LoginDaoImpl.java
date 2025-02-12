package edu.icet.librarymanagmentsystem.repository.custom.impl;


import edu.icet.librarymanagmentsystem.dbconnection.DBConnection;
import edu.icet.librarymanagmentsystem.dto.User;
import edu.icet.librarymanagmentsystem.entity.UserEntity;
import edu.icet.librarymanagmentsystem.repository.custom.LoginDao;
import edu.icet.librarymanagmentsystem.util.HibernateConfig;
import org.hibernate.Session;
import org.jasypt.util.text.BasicTextEncryptor;
import org.modelmapper.ModelMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class LoginDaoImpl implements LoginDao {

    public UserEntity authenticateUser(String email, String password) {
        try (Session session = HibernateConfig.getSession()) {
            session.beginTransaction();

            UserEntity user = session.createQuery("FROM UserEntity WHERE email = :email", UserEntity.class)
                    .setParameter("email", email)
                    .uniqueResult();

            session.getTransaction().commit();

            if (user != null) {
                BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
                basicTextEncryptor.setPassword("12345");
                String decryptedPassword = basicTextEncryptor.decrypt(user.getPassword());

                if (password.equals(decryptedPassword)) {
                    return user;
                }
            }
        }
        return null;
    }


    @Override
    public boolean save(UserEntity entity) throws SQLException {
        return false;
    }

    @Override
    public boolean update(UserEntity entity) throws SQLException {
        return false;
    }

    @Override
    public UserEntity search(String s) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(String s) throws SQLException {
        return false;
    }

    @Override
    public List<UserEntity> getAll() {
        return List.of();
    }
}

