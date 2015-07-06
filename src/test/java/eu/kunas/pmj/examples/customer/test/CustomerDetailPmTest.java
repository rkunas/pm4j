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
    public void before() {
        customerDetailPm = new CustomerDetailPm();
    }

    @Test
    public void testNewCommand() {
        customerDetailPm.newCommand.doIt();

        Assert.assertEquals(null, customerDetailPm.firstName.getValue());
        Assert.assertEquals(null, customerDetailPm.lastName.getValue());

    }

    @Test
    public void testLoadCommand() {
        customerDetailPm.loadCommand.doIt();

        Assert.assertEquals("Muster firstname", customerDetailPm.firstName.getValue());
        Assert.assertEquals("Muster lastname", customerDetailPm.lastName.getValue());
    }

    @Test
    public void testLoadCommandInvalidEmptyString() {
        customerDetailPm.loadCommand.doIt();

        customerDetailPm.firstName.setValue("");
        customerDetailPm.lastName.setValue(null);

        customerDetailPm.saveCommand.doIt();

        Assert.assertFalse(customerDetailPm.saveCommand.getValid());



    }




}
