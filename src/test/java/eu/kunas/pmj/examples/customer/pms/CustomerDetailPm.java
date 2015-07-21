package eu.kunas.pmj.examples.customer.pms;

import eu.kunas.pm4j.core.*;
import eu.kunas.pmj.examples.customer.model.CustomerDto;
import eu.kunas.pmj.examples.customer.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kunas on 03.07.2015.
 */
public class CustomerDetailPm extends PmBeanImpl<CustomerDialogPm,CustomerDto> {

    private CustomerService customerService = new CustomerService();

    public final PmIntegerAttrImpl<CustomerDetailPm> age = new PmIntegerAttrImpl<CustomerDetailPm>(this);

    public final PmBooleanAttrImpl<CustomerDetailPm> company = new PmBooleanAttrImpl<CustomerDetailPm>(this);

    public final PmStringAttrImpl<CustomerDetailPm> country = new PmStringAttrImpl<CustomerDetailPm>(this){
        @Override
        public List<PmOption> getPmOptions() {

            List<PmOption> optionList = new ArrayList<PmOption>();

            optionList.add(new PmOption(1L,"Das ist eine 1"));
            optionList.add(new PmOption(2L,"Das ist eine 2"));

            return optionList;
        }
    };

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

    public CustomerDetailPm(CustomerDialogPm parent){
        super(parent);
    }

    public CustomerDetailPm(){

    }

    @PmTitle("Save")
    public final PmCommandImpl<CustomerDetailPm> saveCommand = new PmCommandImpl<CustomerDetailPm>(this){
        @Override
        protected void doItImpl() {
            CustomerDto customerDto = getPmBean();
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
