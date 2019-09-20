package com.hiraas.pm4j.core;

import com.hiraas.pm4j.middletier.FeedbackBucket;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.Serializable;

/**
 * Created by ramazan on 03.11.14.
 */
public abstract class PmCommandImpl<T_PM_PARENT extends PmImpl> extends PmImpl<T_PM_PARENT> implements Serializable {

    private static Log log = LogFactory.getLog(PmCommandImpl.class);

    public PmCommandImpl(final T_PM_PARENT parent) {
        super(parent);
    }

    public final void doIt() {
        FeedbackBucket newFeedbackBucketContainer = new FeedbackBucket();
        log.info(getPmParent().getClass().getSimpleName() + " - doIt");
        log.info(getPmParent().getClass().getSimpleName() + " - Validiere vor doIt");
        validate();
        log.info(getPmParent().getClass().getSimpleName() + " - Validierung abgeschlossen");
        if (getValid()) {
            log.info(getPmParent().getClass().getSimpleName() + " - Pm Command " + getTitle() + " ist valide");
            beforeDoIt();
            doItImpl();
            afterDoIt(newFeedbackBucketContainer);
        } else {
            log.info(getPmParent().getClass().getSimpleName() + " - Pm Command " + getTitle() + " ist nicht valide");
        }
        this.feedbackBucket = newFeedbackBucketContainer;
    }

    protected abstract void doItImpl();

    /**
     * Zum überschreiben durch den Entwickler
     */
    public void afterDoItImpl(FeedbackBucket feedbackBucket) {

    }

    protected final void afterDoIt(FeedbackBucket feedbackBucket){
        afterDoItImpl(feedbackBucket);
    }

    public void beforeDoItImpl(){

    }

    protected final void beforeDoIt(){
        beforeDoItImpl();
    }




}
