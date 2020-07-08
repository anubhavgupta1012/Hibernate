package com.hibernate.Hibernate.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @OneToOne
    @JoinColumn(name = "IFSC_ID")
    private Bank bank;

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

    public Bank getBank() {
        return bank;
    }

    public Account setBank(Bank bank) {
        this.bank = bank;
        return this;
    }
}
