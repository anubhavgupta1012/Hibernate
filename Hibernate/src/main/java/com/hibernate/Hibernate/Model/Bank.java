package com.hibernate.Hibernate.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Bank {
    @Id
    @Column(name = "IFSC_ID", unique = true)
    private String ifsc;
    @Column(name = "BANK_NAME")
    private String name;

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc() {
        String id = UUID.randomUUID().toString();
        this.ifsc = id.split("-")[0];
    }

    public String getName() {
        return name;
    }

    public Bank setName(String name) {
        setIfsc();
        this.name = name;
        return this;
    }
}
