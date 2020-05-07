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
        customerDto.setFriend(false);

        customerDialogPm.customerDetailPm.setPmBean(customerDto);

        CustomerDto customerDto2 = new CustomerDto();
        customerDto.setFirstName(null);
        customerDto.setLastName("Last");
        customerDto.setAccount(2.0);
        customerDto2.setFriend(true);

        customerDialogPm.customerDetailPm.setPmBean(customerDto2);

        System.out.println(customerDialogPm.customerDetailPm.firstName.getValue());

        System.out.println(customerDialogPm.getCustomerDetailPm().getPmBean().getFriend());
    }
}
