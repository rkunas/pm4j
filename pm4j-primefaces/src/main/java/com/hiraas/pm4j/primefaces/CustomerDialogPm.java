package com.hiraas.pm4j.primefaces;

import com.hiraas.pm4j.core.PmArrayList;
import com.hiraas.pm4j.core.PmCommandImpl;
import com.hiraas.pm4j.core.PmImpl;
import lombok.Getter;
import lombok.Setter;

public class CustomerDialogPm extends PmImpl {

    @Getter
    @Setter
    public PmArrayList<CustomerRowPm> customers = new PmArrayList<CustomerRowPm>();

    @Getter
    @Setter
    public PmCommandImpl<CustomerDialogPm> searchCommandPm = new PmCommandImpl<CustomerDialogPm>(this) {
        @Override
        protected void doItImpl() {

            CustomerRowPm row1 = new CustomerRowPm(CustomerDialogPm.this);
            row1.setPmBean(new CustomerDto("Hira"));
            customers.add(row1);
        }
    } ;

    public CustomerDialogPm(){
        super();
    }


}
