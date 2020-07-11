package com.hibernate.Hibernate.Model;

import javax.persistence.Entity;

@Entity
public class Savings extends Account {

    private String savingsRate;
    private boolean transactionalRestriction;

    public boolean isTransactionalRestriction() {
        return transactionalRestriction;
    }

    public Savings setTransactionalRestriction(boolean transactionalRestriction) {
        this.transactionalRestriction = transactionalRestriction;
        return this;
    }

    public String getSavingsRate() {
        return savingsRate;
    }

    public Savings setSavingsRate(String savingsRate) {
        this.savingsRate = savingsRate;
        return this;
    }
}
