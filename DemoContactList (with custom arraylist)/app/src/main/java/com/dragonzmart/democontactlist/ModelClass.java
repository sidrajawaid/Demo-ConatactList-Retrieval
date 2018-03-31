package com.dragonzmart.democontactlist;

/**
 * Created by Sidra on 12/18/2017.
 */

public class ModelClass {
    private String name;
    private String number;

    public ModelClass(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
