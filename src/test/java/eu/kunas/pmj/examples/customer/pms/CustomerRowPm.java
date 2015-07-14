package eu.kunas.pmj.examples.customer.pms;

import eu.kunas.pm4j.core.PmRowImpl;
import eu.kunas.pmj.examples.customer.model.CustomerDto;

/**
 * Created by Kunas on 14.07.2015.
 */
public class CustomerRowPm extends PmRowImpl<CustomerDialogPm,CustomerDto> {

    public CustomerRowPm(CustomerDialogPm customerDialogPm) {
        super(customerDialogPm);
    }
}
