package eu.kunas.pmj.examples.customer.test;

import eu.kunas.pmj.examples.customer.pms.CustomerDialogPm;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Kunas on 14.07.2015.
 */
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
