package com.hiraas.pm4j.pms;

import com.hiraas.pm4j.core.*;
import com.hiraas.pm4j.middletier.Feedback;
import com.hiraas.pm4j.middletier.FeedbackBucket;
import lombok.Data;

@Data
public class CustomerDetailPm extends PmBeanImpl<CustomerDialogPm, CustomerDto> {

    @PmTitle("Vorname")
    public PmStringAttrImpl firstName = new PmStringAttrImpl(this);

    @PmTitle("Nachname")
    public PmStringAttrImpl lastName = new PmStringAttrImpl(this);

    @PmTitle("Account")
    public PmDoubleAttrImpl account = new PmDoubleAttrImpl(this);

    @PmTitle("Speichern")
    public PmCommandImpl saveCommand = new PmCommandImpl(this) {
        @Override
        protected void doItImpl() {
            CustomerDetailPm.this.getPmParent().service.saveCustomer(getPmBean());
        }

        @Override
        public void afterDoItImpl(FeedbackBucket feedbackBucket) {
            feedbackBucket.addFeedback(Feedback.Severity.INFO,"Erfolgreich gespeichert !");
            CustomerDetailPm.this.getPmParent().triggerRoot(feedbackBucket);
        }
    };

    public CustomerDetailPm(CustomerDialogPm parent) {
        super(parent);

    }


}
