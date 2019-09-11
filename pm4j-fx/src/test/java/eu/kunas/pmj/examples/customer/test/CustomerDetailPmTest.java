package eu.kunas.pmj.examples.customer.test;

import eu.kunas.pmj.examples.customer.pms.CustomerDetailPm;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

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

        customerDetailPm.saveCommand.doIt();

        Assert.assertTrue(customerDetailPm.saveCommand.getValid());
    }

    @Test
    public void testLoadCommandInvalidEmptyString() {
        customerDetailPm.loadCommand.doIt();

        customerDetailPm.firstName.setValue("");
        customerDetailPm.lastName.setValue(null);

        Assert.assertTrue(customerDetailPm.firstName.getChanged());

        Assert.assertTrue(customerDetailPm.firstName.getEnabled());

        Assert.assertTrue(customerDetailPm.firstName.getVisible());

        customerDetailPm.country.setValue(customerDetailPm.country.getPmOptions().get(0).getLabel());

        customerDetailPm.saveCommand.doIt();

        Assert.assertFalse(customerDetailPm.saveCommand.getValid());

    }

    @Test
    public void testBeanWithoutReadFromPm() {
        customerDetailPm.loadCommand.doIt();
        customerDetailPm.firstName.setValue("Marcus");

        Assert.assertNotEquals(customerDetailPm.getPmBeanWithoutAttrRead().getFirstName(),customerDetailPm.firstName.getValue());

    }

    @Test
    public void testBeanReadFromPm() {
        customerDetailPm.loadCommand.doIt();
        customerDetailPm.firstName.setValue("Marcus");

        Assert.assertEquals(customerDetailPm.getPmBean().getFirstName(), customerDetailPm.firstName.getValue());

        System.out.println(customerDetailPm.getPmBean().getFirstName());
        System.out.println(customerDetailPm.firstName.getValue());
    }

    @Test
    public void testChangedAttribute() {
        customerDetailPm.loadCommand.doIt();
        customerDetailPm.firstName.setValue("Marcus");

        Assert.assertTrue(customerDetailPm.firstName.getChanged());

    }
}
