package com.hibernate.Hibernate.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
public class Bank {
    @Id
    @Column(name = "IFSC_ID", unique = true)
    private String ifsc;
    private String bankName;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc() {
        String id = UUID.randomUUID().toString();
        this.ifsc = id.split("-")[0];
    }

    public String getBankName() {
        return bankName;
    }

    public Bank setBankName(String name) {
        setIfsc();
        this.bankName = name;
        return this;
    }
}
