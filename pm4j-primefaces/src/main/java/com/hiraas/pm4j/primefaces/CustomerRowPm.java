package com.hiraas.pm4j.primefaces;

import com.hiraas.pm4j.core.PmRowImpl;
import com.hiraas.pm4j.core.PmStringAttrImpl;
import lombok.Getter;
import lombok.Setter;

public class CustomerRowPm extends PmRowImpl<CustomerDialogPm, CustomerDto> {

    @Getter
    @Setter
    public PmStringAttrImpl firstName = new PmStringAttrImpl(this);


    public CustomerRowPm(CustomerDialogPm parent){
        super(parent);
    }

}
