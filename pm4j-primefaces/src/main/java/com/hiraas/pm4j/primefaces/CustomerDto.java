package com.hiraas.pm4j.primefaces;

import java.io.Serializable;

public class CustomerDto implements Serializable {

    private String firstName;

    public CustomerDto(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
