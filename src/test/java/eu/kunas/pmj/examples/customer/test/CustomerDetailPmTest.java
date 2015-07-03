package eu.kunas.pmj.examples.customer.test;

import eu.kunas.pmj.examples.customer.pms.CustomerDetailPm;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Kunas on 03.07.2015.
 */
public class CustomerDetailPmTest {

    private CustomerDetailPm customerDetailPm;

    @Before
    public void before(){
        customerDetailPm = new CustomerDetailPm();
    }

    @Test
    public void testNewCommand(){
        customerDetailPm.newCommand.doIt();

        Assert.assertEquals("Muster", customerDetailPm.firstName.getValue());
        Assert.assertEquals("Muster", customerDetailPm.lastName.getValue());
    }


}
