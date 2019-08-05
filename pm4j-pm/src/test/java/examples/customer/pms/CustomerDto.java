package eu.kunas.pmj.examples.customer.pms;

import java.io.Serializable;

public class CustomerDto implements Serializable {
    private Integer age;
    private Boolean company;
    private String country;
    private String firstName;
    private String lastName;

    public CustomerDto(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
