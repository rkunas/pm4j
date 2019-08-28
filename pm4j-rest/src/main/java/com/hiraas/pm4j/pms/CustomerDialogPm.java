package com.hiraas.pm4j.pms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hiraas.pm4j.core.PmArrayList;
import com.hiraas.pm4j.core.PmCommandImpl;
import com.hiraas.pm4j.core.PmImpl;
import com.hiraas.pm4j.core.PmStringAttrImpl;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties({"service"})
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

            result.stream().forEach(customer -> {
                CustomerRowPm row = new CustomerRowPm(CustomerDialogPm.this, customer);
                customers.add(row);
            });
        }
    };

    public PmCommandImpl<CustomerDialogPm> viewDetailCommandPm = new PmCommandImpl<CustomerDialogPm>(this) {
        @Override
        protected void doItImpl() {
            customerDetailPm.setPmBean(selectedRow.getPmBean());
        }
    };

    public CustomerDetailPm customerDetailPm = new CustomerDetailPm(this);

    public CustomerDialogPm() {
        super();
    }


}
