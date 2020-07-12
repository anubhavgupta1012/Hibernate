package com.hibernate.Hibernate.Impl;

import com.hibernate.Hibernate.Model.Account;
import com.hibernate.Hibernate.service.UserService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service("userService")
public class UserServiceBean implements UserService {
    @PersistenceContext
    protected EntityManager entityManager;

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    private org.postgresql.jdbc.PgStatement setConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection c = DriverManager.
            getConnection(url, username, password);
        org.postgresql.jdbc.PgStatement stmt = (org.postgresql.jdbc.PgStatement) c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
            ResultSet.CONCUR_READ_ONLY);
        return stmt;
    }

    public SessionFactory getSessionFactory() {
        return entityManager.unwrap(Session.class).getSessionFactory();
    }

    @Override
    public String addAccount(String id, String name) {
        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        for (int i = 1; i < 11; i++) {
            Account account = new Account().setName("ANUBHAV" + i);
            session.save(account);
        }
        session.getTransaction().commit();
        session.close();
        return "done";
    }

    @Override
    public List FirstRow() {
        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Account account = new Account();
        //account.setId(1);
        account.setIfsc("1540a107");

        Example example = Example.create(account).enableLike();

        Criteria criteria = session.createCriteria(Account.class).add(example);
        List list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
}
