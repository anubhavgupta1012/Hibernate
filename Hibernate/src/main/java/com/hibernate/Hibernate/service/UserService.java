package com.hibernate.Hibernate.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UserService {

    public String addAccount(String id, String name) throws SQLException, ClassNotFoundException;

    List<Map> FirstRow();
}
