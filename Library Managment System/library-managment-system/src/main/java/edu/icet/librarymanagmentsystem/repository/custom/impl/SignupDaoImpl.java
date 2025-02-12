package edu.icet.librarymanagmentsystem.repository.custom.impl;

import edu.icet.librarymanagmentsystem.dbconnection.DBConnection;
import edu.icet.librarymanagmentsystem.dto.User;
import edu.icet.librarymanagmentsystem.entity.UserEntity;
import edu.icet.librarymanagmentsystem.repository.custom.SignupDao;
import edu.icet.librarymanagmentsystem.util.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.modelmapper.ModelMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SignupDaoImpl implements SignupDao {


    public UserEntity checkemailrepeat(String email) {
        Session session = HibernateConfig.getSession();
        UserEntity user = null;

        try {
            user = session.createQuery("FROM UserEntity WHERE email = :email", UserEntity.class)
                    .setParameter("email", email)
                    .uniqueResult();
        } finally {
            session.close();
        }

        return user;
    }



    @Override
    public boolean registerUser(UserEntity newUser) throws SQLException {

        Session session = HibernateConfig.getSession();
        session.beginTransaction();
        session.persist(newUser);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public UserEntity generateUserID() {
        String newUserId;

        try (Session session = HibernateConfig.getSession()) {
            session.beginTransaction();

            String existId = session.createQuery("SELECT u.id FROM UserEntity u ORDER BY u.id DESC", String.class)
                    .setMaxResults(1)
                    .uniqueResult();

            if (existId != null) {
                int id = Integer.parseInt(existId.substring(1));
                newUserId = String.format("L%04d", id + 1);
            } else {
                newUserId = "L0001";
            }

            session.getTransaction().commit();
        }

        UserEntity newUser = new UserEntity();
        newUser.setId(newUserId);
        return newUser;
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
