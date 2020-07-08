package com.hibernate.Hibernate.Impl;

import com.hibernate.Hibernate.Model.Account;
import com.hibernate.Hibernate.Model.Address;
import com.hibernate.Hibernate.Model.Bank;
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
        Address address = new Address("station Road", "Deoria", "274001");
        Bank dbs = new Bank().setBankName("DBS");
        Bank pnb = new Bank().setBankName("PNB");
        Bank sbi = new Bank().setBankName("sbi");
        List list1 = new ArrayList();
        list1.add(dbs);
        List list2 = new ArrayList();
        list2.add(sbi);
        list2.add(pnb);
        Account user1 = new Account().setName("ANUBHAV").setBankList(list2);
        Account user2 = new Account().setName("DHEERAJ").setBankList(list1);
        Account user3 = new Account().setName("SAGER");
        Account user4 = new Account().setName("SHAID");
        Account user5 = new Account().setName("NOWMAN");
        SessionFactory sessionFactory = getSessionFactory();
        List<Account> listAccount1 = new ArrayList<>();
        listAccount1.add(user1);
        listAccount1.add(user2);
        listAccount1.add(user3);
        dbs.setAccountList(listAccount1);
        List<Account> listAccount2 = new ArrayList<>();
        listAccount2.add(user4);
        listAccount2.add(user5);
        pnb.setAccountList(listAccount2);
        List<Account> listAccount3 = new ArrayList<>();
        listAccount3.add(user1);
        listAccount3.add(user5);
        sbi.setAccountList(listAccount3);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user1);
        session.save(user2);
        session.save(user3);
        session.save(user4);
        session.save(user5);
        session.save(dbs);
        session.save(pnb);
        session.save(sbi);
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
