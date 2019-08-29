package com.hiraas.pm4j.pms;

import com.hiraas.pm4j.core.PmRowImpl;
import com.hiraas.pm4j.core.PmStringAttrImpl;
import lombok.Data;

@Data
public class CustomerRowPm extends PmRowImpl<CustomerDialogPm, CustomerDto> {

    public PmStringAttrImpl firstName = new PmStringAttrImpl(this);

    public PmStringAttrImpl lastName = new PmStringAttrImpl(this);


    public CustomerRowPm(CustomerDialogPm parent, CustomerDto dto) {
        super(parent);
        if (dto != null) {
            setPmBean(dto);
        }
    }

}
