package com.hibernate.Hibernate.Model;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "Account_Entity")
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
    @ElementCollection
    @JoinTable(name = "ACCOUNT_JOIN_ADDRESS", joinColumns = @JoinColumn(name = "ACCOUNT_IDS"))
    @GenericGenerator(name = "myHilo", strategy = "sequence")
    @CollectionId(columns = @Column(name = "ADDRESS_ID"), type = @Type(type = "long"), generator = "myHilo")
    private List<Address> addressList = new ArrayList();

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

    public List<Address> getAddressList() {
        return addressList;
    }

    public Account setAddressList(List<Address> addressList) {
        this.addressList = addressList;
        return this;
    }
}
