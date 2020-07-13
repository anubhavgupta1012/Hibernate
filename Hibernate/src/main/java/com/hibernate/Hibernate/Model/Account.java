package com.hibernate.Hibernate.Model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
@Table(name = "ACCOUNT_TABLE")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ACCOUNT_ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "IFSC_CODE")
    private String ifsc;

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
        setIfsc();
        this.name = name;
        return this;
    }

    public String getIfsc() {
        return ifsc;
    }

    public Account setIfsc() {
        this.ifsc = UUID.randomUUID().toString().split("-")[0];
        return this;
    }

    public Account setIfsc(String ifsc) {
        this.ifsc = ifsc;
        return this;
    }
}
