package com.hibernate.Hibernate.Model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.util.Date;

@Entity
@Table(name = "ACCOUNT_TABLE")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ACCOUNT_ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "JOIN_DATE")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date joinDate = new Date();
    @AttributeOverrides({
        @AttributeOverride(name = "street", column = @Column(name = "STREET_ING")),
        @AttributeOverride(name = "city", column = @Column(name = "CITY_ING"))
    })
    private Address address;


    public Account() {
    }

    public Account(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public Account setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Account setName(String name) {
        this.name = name;
        return this;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public Account setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Account setAddress(Address address) {
        this.address = address;
        return this;
    }
}
