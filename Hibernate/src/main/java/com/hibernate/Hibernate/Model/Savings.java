package com.hibernate.Hibernate.Model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class Savings extends Account {

    private String savingsRate;

    public String getSavingsRate() {
        return savingsRate;
    }

    public Savings setSavingsRate(String savingsRate) {
        this.savingsRate = savingsRate;
        return this;
    }
}
