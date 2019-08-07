package com.hiraas.pm4j.core;

import com.hiraas.pm4j.core.customer.pms.CustomerDialogPm;
import org.junit.Test;

public class TestPms {

    public CustomerDialogPm customerDialogPm = new CustomerDialogPm();

    @Test
    public void testPms(){
        customerDialogPm.searchCommand.doIt();
    }
}
