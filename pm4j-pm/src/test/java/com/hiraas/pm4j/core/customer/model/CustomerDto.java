package com.hiraas.pm4j.core.customer.model;

import java.io.Serializable;

@SuppressWarnings("MagicConstant")
public class CustomerDto implements Serializable {

    private Integer age;
    private Boolean company;
    private String coountry;
    private String firstName;
    private String lastName;

    public CustomerDto(){

    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getCompany() {
        return company;
    }

    public void setCompany(Boolean company) {
        this.company = company;
    }

    public String getCoountry() {
        return coountry;
    }

    public void setCoountry(String coountry) {
        this.coountry = coountry;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
