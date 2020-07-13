package com.hibernate.Hibernate.service;

import com.hibernate.Hibernate.Model.Account;

import java.sql.SQLException;

public interface UserService {

    public String addAccount(String id, String name) throws SQLException, ClassNotFoundException;

    Account FirstRow();
}
