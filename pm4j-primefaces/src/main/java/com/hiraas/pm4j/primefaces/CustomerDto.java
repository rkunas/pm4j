package com.hiraas.pm4j.primefaces;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerDto implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;

    public CustomerDto(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public CustomerDto(){

    }

}
