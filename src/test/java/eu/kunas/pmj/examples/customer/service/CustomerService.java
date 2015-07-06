package eu.kunas.pmj.examples.customer.service;

import eu.kunas.pmj.examples.customer.model.CustomerDto;

/**
 * Created by Kunas on 06.07.2015.
 */
public class CustomerService {

    public CustomerDto createNewCustomer(){
        CustomerDto customerDto = new CustomerDto();
        return customerDto;
    }

    public CustomerDto loadCustomer(Long id){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setFirstName("Muster firstname");
        customerDto.setLastName("Muster lastname");
        return customerDto;
    }

}
