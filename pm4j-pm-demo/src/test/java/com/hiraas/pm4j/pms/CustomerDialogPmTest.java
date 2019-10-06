package com.hiraas.pm4j.pms;

import org.junit.Test;

public class CustomerDialogPmTest {

    @Test
    public void testDialog(){

        CustomerDialogPm customerDialogPm = new CustomerDialogPm();

        CustomerDto customerDto = new CustomerDto();
        customerDto.setFirstName("Demo");
        customerDto.setLastName("Last");
        customerDto.setAccount(2.0);

        customerDialogPm.customerDetailPm.setPmBean(customerDto);
    }
}
