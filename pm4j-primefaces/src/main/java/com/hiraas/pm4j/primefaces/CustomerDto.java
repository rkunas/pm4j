package com.hiraas.pm4j.primefaces;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerDto implements Serializable {

    private String firstName;
    private String lastName;

    public CustomerDto(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
