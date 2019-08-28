package com.hiraas.pm4j.pms;

import java.util.ArrayList;
import java.util.List;


public class CustomerService {


    private static List<CustomerDto> customerRepo = new ArrayList<>();

    public CustomerService() {
        customerRepo.add(new CustomerDto(1L, "Franz Walter", "Steinmeier"));
        customerRepo.add(new CustomerDto(2L, "Gerhard", "Schröder"));
        customerRepo.add(new CustomerDto(3L, "Angela", "Merkel"));
        customerRepo.add(new CustomerDto(4L, "Keeene", "Maaßen"));
    }

    public List<CustomerDto> searchCustomer(String some) {
        List<CustomerDto> result = new ArrayList<>();

        if (some != null) {
            customerRepo.stream().forEach(customerDto -> {
                if (customerDto.getFirstName().contains(some) || customerDto.getLastName().contains(some)) {
                    result.add(customerDto);
                    return;
                }

            });
        }

        return result;
    }
}
