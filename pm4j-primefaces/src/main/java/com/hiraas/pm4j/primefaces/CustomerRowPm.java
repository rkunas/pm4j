package com.hiraas.pm4j.primefaces;

import com.hiraas.pm4j.core.PmRowImpl;
import com.hiraas.pm4j.core.PmStringAttrImpl;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CustomerRowPm extends PmRowImpl<CustomerDialogPm, CustomerDto> {

    public PmStringAttrImpl firstName = new PmStringAttrImpl(this);


    public CustomerRowPm(CustomerDialogPm parent, CustomerDto dto){
        super(parent);
        setPmBean(dto);
    }

}
