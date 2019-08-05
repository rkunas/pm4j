package eu.kunas.pmj.examples.customer.pms;

import com.hiraas.pm4j.core.PmRowImpl;

/**
 * Created by Kunas on 14.07.2015.
 */
public class CustomerRowPm extends PmRowImpl<CustomerDialogPm,CustomerDto> {

    public CustomerRowPm(CustomerDialogPm customerDialogPm) {
        super(customerDialogPm);
    }
}
