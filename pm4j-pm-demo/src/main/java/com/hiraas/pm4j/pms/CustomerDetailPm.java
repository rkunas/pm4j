package com.hiraas.pm4j.pms;

import com.hiraas.pm4j.core.PmBeanImpl;
import com.hiraas.pm4j.core.PmStringAttrImpl;
import lombok.Data;

@Data
public class CustomerDetailPm extends PmBeanImpl<CustomerDialogPm, CustomerDto> {

    public PmStringAttrImpl firstName = new PmStringAttrImpl(this);

    public PmStringAttrImpl lastName = new PmStringAttrImpl(this);

    public CustomerDetailPm(CustomerDialogPm parent) {
        super(parent);

    }


}
