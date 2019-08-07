package com.hiraas.pm4j.core.customer.test;

import eu.kunas.pmj.examples.DefaultTests;
import eu.kunas.pmj.examples.customer.pms.CustomerDialogPm;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * Created by Kunas on 14.07.2015.
 */
@Category({DefaultTests.class})
public class CustomerDialogPmTest {

    private CustomerDialogPm customerDialogPm = new CustomerDialogPm();

    @Before
    public void init(){
        customerDialogPm = new CustomerDialogPm();
    }

    @Test
    public void testCustomerSearch(){
        customerDialogPm.searchCommand.doIt();
    }


}
