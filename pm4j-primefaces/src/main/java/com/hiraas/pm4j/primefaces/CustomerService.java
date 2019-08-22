package com.hiraas.pm4j.primefaces;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    private static List<CustomerDto> customerRepo = new ArrayList<>();

    public CustomerService(){
        customerRepo.add(new CustomerDto("Franz Walter","Steinmeier"));
        customerRepo.add(new CustomerDto("Gerhard", "Schröder"));
        customerRepo.add(new CustomerDto("Angela", "Merkel"));
        customerRepo.add(new CustomerDto("Keeene", "Maaßen"));
    }

    public List<CustomerDto> searchCustomer(String some){
        List<CustomerDto> result = new ArrayList<>();

        customerRepo.stream().forEach(customerDto -> {
            if(customerDto.getFirstName().contains(some) || customerDto.getLastName().contains(some)){
                result.add(customerDto);
                return;
            }

        });

        return result;
    }
}
