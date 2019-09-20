package com.hiraas.pm4j.pms;

import com.hiraas.pm4j.core.PmBeanImpl;
import com.hiraas.pm4j.core.PmCommandImpl;
import com.hiraas.pm4j.core.PmStringAttrImpl;
import com.hiraas.pm4j.core.PmTitle;
import com.hiraas.pm4j.middletier.Feedback;
import com.hiraas.pm4j.middletier.FeedbackBucket;
import lombok.Data;

@Data
public class CustomerDetailPm extends PmBeanImpl<CustomerDialogPm, CustomerDto> {

    @PmTitle("Vorname")
    public PmStringAttrImpl firstName = new PmStringAttrImpl(this);

    @PmTitle("Nachname")
    public PmStringAttrImpl lastName = new PmStringAttrImpl(this);

    @PmTitle("Speichern")
    public PmCommandImpl saveCommand = new PmCommandImpl(this) {
        @Override
        protected void doItImpl() {
            CustomerDetailPm.this.getPmParent().service.saveCustomer(getPmBean());
        }

        @Override
        public void afterDoItImpl(FeedbackBucket feedbackBucket) {
            feedbackBucket.addFeedback(Feedback.Severity.INFO,"Erfolgreich gespeichert !");
            CustomerDetailPm.this.getPmParent().createMessage(feedbackBucket);
        }
    };

    public CustomerDetailPm(CustomerDialogPm parent) {
        super(parent);

    }


}
