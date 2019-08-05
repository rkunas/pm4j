package eu.kunas.pmj.examples.customer.service;

import eu.kunas.pmj.examples.customer.pms.CustomerDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kunas on 06.07.2015.
 */
public class CustomerService {

    public CustomerDto createNewCustomer() {
        CustomerDto customerDto = new CustomerDto();
        return customerDto;
    }

    public CustomerDto loadCustomer(Long id) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setFirstName("Muster firstname");
        customerDto.setLastName("Muster lastname");
        return customerDto;
    }

    public List<CustomerDto> getAllCustomers() {

        List<CustomerDto> customers = new ArrayList<>();

        CustomerDto customerHeinz = new CustomerDto("Heinz", "Walter");
        CustomerDto customerFritz = new CustomerDto("Fritz", "M�ller");

        customers.add(customerFritz);
        customers.add(customerHeinz);

        return customers;

    }
}

