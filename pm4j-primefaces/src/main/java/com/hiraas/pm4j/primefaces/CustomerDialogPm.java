package com.hiraas.pm4j.primefaces;

import com.hiraas.pm4j.core.PmArrayList;
import com.hiraas.pm4j.core.PmCommandImpl;
import com.hiraas.pm4j.core.PmImpl;
import lombok.Data;

import java.util.List;

@Data
public class CustomerDialogPm extends PmImpl {

    private CustomerService service = new CustomerService();

    public PmArrayList<CustomerRowPm> customers = new PmArrayList<CustomerRowPm>();

    public PmCommandImpl<CustomerDialogPm> searchCommandPm = new PmCommandImpl<CustomerDialogPm>(this) {
        @Override
        protected void doItImpl() {

            List<CustomerDto> result = service.searchCustomer("e");
            customers.clear();

            result.stream().forEach(customer -> {
                CustomerRowPm row = new CustomerRowPm(CustomerDialogPm.this, customer);
                customers.add(row);
            });
        }
    };

    public CustomerDialogPm() {
        super();
    }


}
