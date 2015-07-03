package eu.kunas.pmj.examples.customer.model;

/**
 * Created by Kunas on 03.07.2015.
 */
public class CustomerDto {

    private Long id;
    public String firstName;
    private String lastName;

    public CustomerDto() {

    }

    public CustomerDto(String muster, String muster1) {
        this.firstName = muster;
        this.lastName = muster1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
