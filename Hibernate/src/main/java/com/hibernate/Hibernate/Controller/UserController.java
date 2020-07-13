package com.hibernate.Hibernate.Controller;

import com.hibernate.Hibernate.Model.Account;
import com.hibernate.Hibernate.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.SQLException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/add/{id}/{name}")
    public String getDepartmentId(@PathVariable String id, @PathVariable String name) throws SQLException, ClassNotFoundException {
        return userService.addAccount(id, name);
    }

    @RequestMapping("/getFirst")
    public Account getFirst() {
        return userService.FirstRow();
    }
}
