package eu.kunas.pmj.examples.customer.pms;

import eu.kunas.pm4j.PmBeanImpl;
import eu.kunas.pm4j.PmCommandImpl;
import eu.kunas.pm4j.PmStringAttrImpl;
import eu.kunas.pmj.examples.customer.model.CustomerDto;

/**
 * Created by Kunas on 03.07.2015.
 */
public class CustomerDetailPm extends PmBeanImpl<CustomerDetailPm,CustomerDto> {

    public final PmStringAttrImpl<CustomerDetailPm> firstName = new PmStringAttrImpl<CustomerDetailPm>(this);

    public final PmStringAttrImpl<CustomerDetailPm> lastName = new PmStringAttrImpl<CustomerDetailPm>(this);



    public CustomerDetailPm(){

    }

    public final PmCommandImpl<CustomerDetailPm> saveCommand = new PmCommandImpl<CustomerDetailPm>(this){
        @Override
        protected void doItImpl() {
            // tu was
        }

        @Override
        public String getTitle() {
            return "Save";
        }
    };

    public final PmCommandImpl<CustomerDetailPm> newCommand = new PmCommandImpl<CustomerDetailPm>(this) {
        @Override
        protected void doItImpl() {
            // tu was


        }

        @Override
        public String getTitle() {
            return "New";
        }
    };

}
