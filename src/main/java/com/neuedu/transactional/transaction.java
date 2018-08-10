package com.neuedu.transactional;

import java.io.Serializable;

public class transaction implements Serializable {

    String personName;
    int Money;

    public transaction(String personName, int money) {
        this.personName = personName;
        Money = money;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getMoney() {
        return Money;
    }

    public void setMoney(int money) {
        Money = money;
    }

    public transaction() {
    }

}
