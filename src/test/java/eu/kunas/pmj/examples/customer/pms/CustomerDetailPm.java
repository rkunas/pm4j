package eu.kunas.pmj.examples.customer.pms;

import eu.kunas.pm4j.core.PmBeanImpl;
import eu.kunas.pm4j.core.PmCommandImpl;
import eu.kunas.pm4j.core.PmStringAttrImpl;
import eu.kunas.pmj.examples.customer.model.CustomerDto;
import eu.kunas.pmj.examples.customer.service.CustomerService;

/**
 * Created by Kunas on 03.07.2015.
 */
public class CustomerDetailPm extends PmBeanImpl<CustomerDetailPm,CustomerDto> {

    private CustomerService customerService = new CustomerService();

    public final PmStringAttrImpl<CustomerDetailPm> firstName = new PmStringAttrImpl<CustomerDetailPm>(this){
        @Override
        public Boolean getRequired() {
            return true;
        }
    };

    public final PmStringAttrImpl<CustomerDetailPm> lastName = new PmStringAttrImpl<CustomerDetailPm>(this){
        @Override
        public Boolean getRequired() {
            return true;
        }
    };

    public CustomerDetailPm(){

    }

    public final PmCommandImpl<CustomerDetailPm> saveCommand = new PmCommandImpl<CustomerDetailPm>(this){
        @Override
        protected void doItImpl() {

        }

        @Override
        protected Boolean validateImpl() {

            firstName.validate();
            lastName.validate();

            return firstName.getValid() && lastName.getValid();
        }

        @Override
        public String getTitle() {
            return "Save";
        }

    };

    public final PmCommandImpl<CustomerDetailPm> loadCommand = new PmCommandImpl<CustomerDetailPm>(this) {
        @Override
        protected void doItImpl() {
            setPmBean(customerService.loadCustomer(1L));
        }

        @Override
        public String getTitle() {
            return "Load";
        }
    };

    public final PmCommandImpl<CustomerDetailPm> newCommand = new PmCommandImpl<CustomerDetailPm>(this) {
        @Override
        protected void doItImpl() {
            setPmBean(customerService.createNewCustomer());
        }

        @Override
        public String getTitle() {
            return "New";
        }
    };

}
