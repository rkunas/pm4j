package sample;

import com.hiraas.pm4j.middletier.FeedbackBucket;
import com.hiraas.pm4j.pms.CustomerDialogPm;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;

public class FacesCustomerDialogPm extends CustomerDialogPm implements Serializable {

    @Override
    public void triggerRoot(FeedbackBucket feedbackBucket) {
        FacesContext context = FacesContext.getCurrentInstance();

        feedbackBucket.getFeedbacks().stream().forEach(feedback ->
                context.addMessage(null, new FacesMessage(feedback.getSeverity().toString(), feedback.getMessage()))
        );

    }
}
