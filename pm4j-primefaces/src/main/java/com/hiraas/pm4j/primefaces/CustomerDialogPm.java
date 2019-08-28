package com.hiraas.pm4j.primefaces;

import com.hiraas.pm4j.core.*;
import lombok.Data;

import java.util.List;

@Data
public class CustomerDialogPm extends PmImpl {

    private CustomerService service = new CustomerService();

    public PmArrayList<CustomerRowPm> customers = new PmArrayList<CustomerRowPm>();

    public PmStringAttrImpl<CustomerDialogPm> searchText = new PmStringAttrImpl<>(this);

    public CustomerRowPm selectedRow = new CustomerRowPm(this,null);

    public PmCommandImpl<CustomerDialogPm> searchCommandPm = new PmCommandImpl<CustomerDialogPm>(this) {
        @Override
        protected void doItImpl() {

            List<CustomerDto> result = service.searchCustomer(searchText.getValue());
            customers.clear();
            customers.reset();

            System.out.println(searchText.getValue());

            result.stream().forEach(customer -> {
                CustomerRowPm row = new CustomerRowPm(CustomerDialogPm.this, customer);
                customers.add(row);
            });
        }
    };

    public PmCommandImpl<CustomerDialogPm> viewDetail = new PmCommandImpl<CustomerDialogPm>(this) {
        @Override
        protected void doItImpl() {
            System.out.println("Setting " + selectedRow.getPmBean().getLastName());
            customerDetailPm.setPmBean(selectedRow.getPmBean());
        }
    };

    public CustomerDetailPm customerDetailPm = new CustomerDetailPm(this);

    public CustomerDialogPm() {
        super();
    }


}
