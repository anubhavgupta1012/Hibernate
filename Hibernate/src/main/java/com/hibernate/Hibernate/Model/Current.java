package com.hibernate.Hibernate.Model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class Current extends Account {

    private String currentRate;

    public String getCurrentRate() {
        return currentRate;
    }

    public Current setCurrentRate(String currentRate) {
        this.currentRate = currentRate;
        return this;
    }
}
