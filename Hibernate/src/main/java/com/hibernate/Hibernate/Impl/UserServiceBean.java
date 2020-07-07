package com.hibernate.Hibernate.Impl;

import com.hibernate.Hibernate.Model.Account;
import com.hibernate.Hibernate.Model.Address;
import com.hibernate.Hibernate.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        Address address1 = new Address("station Road1", "Deoria1", "274001");
        Address address2 = new Address("station Road2", "Deoria2", "274001");
        Address address3 = new Address("station Road3", "Deoria3", "274001");
        Address address4 = new Address("station Road4", "Deoria4", "274001");
        Address address5 = new Address("station Road5", "Deoria5", "274001");
        Address address6 = new Address("station Road5", "Deoria6", "274001");

        List<Address> one = new ArrayList<>();
        one.add(address1);
        one.add(address2);
        one.add(address3);
        List<Address> two = new ArrayList<>();
        two.add(address4);
        two.add(address5);
        List<Address> three = new ArrayList<>();
        three.add(address6);

        Account user1 = new Account().setName("ANUBHAV").setAddressList(one);
        Account user2 = new Account().setName("DHEERAJ").setAddressList(two);
        Account user3 = new Account().setName("SAGER").setAddressList(three);
        Account user4 = new Account().setName("SHAID");
        Account user5 = new Account().setName("NOWMAN");
        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user1);
        session.save(user2);
        session.save(user3);
        session.save(user4);
        session.save(user5);
        session.getTransaction().commit();
        session.close();
        return "done";
    }

    @Override
    public Account FirstRow() {
        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();
        Account account = session.get(Account.class, 1);
        session.close();
        return account;
    }
}
