package eu.kunas.pmj.examples.customer.pms;

import eu.kunas.pm4j.core.PmArrayList;
import eu.kunas.pm4j.core.PmCommandImpl;
import eu.kunas.pm4j.core.PmImpl;
import eu.kunas.pmj.examples.customer.model.CustomerDto;
import eu.kunas.pmj.examples.customer.service.CustomerService;

/**
 * Created by Kunas on 14.07.2015.
 */
public class CustomerDialogPm extends PmImpl {

    private CustomerService customerService = new CustomerService();

    public final PmArrayList<CustomerRowPm> searchResultPm = new PmArrayList<CustomerRowPm>();

    public final PmCommandImpl<CustomerDialogPm> searchCommand = new PmCommandImpl<CustomerDialogPm>(this) {
        @Override
        protected void doItImpl() {

            for(CustomerDto customerDto : customerService.getAllCustomers()){
                CustomerRowPm rowPm = new CustomerRowPm(getPmParent());
                rowPm.setPmBean(customerDto);
                searchResultPm.add(rowPm);
            }
        }
    };

    public final CustomerDetailPm detailPm = new CustomerDetailPm(this);

    public CustomerDialogPm() {

    }
}
