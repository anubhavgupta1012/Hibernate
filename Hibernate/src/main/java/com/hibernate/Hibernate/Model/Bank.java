package com.hibernate.Hibernate.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Bank {
    @Id
    @Column(name = "IFSC_ID", unique = true)
    private String ifsc;
    private String bankName;

    @ManyToMany
    private List<Account> accountList=new ArrayList<>();

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
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
