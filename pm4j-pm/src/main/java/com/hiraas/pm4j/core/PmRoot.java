package com.hiraas.pm4j.core;

import com.hiraas.pm4j.middletier.FeedbackBucket;

public class PmRoot<T_B extends PmImpl> extends PmImpl<T_B> {

    /**
     * Zum überschreiben durch die Jeweilige Technologie
     * @param feedbackBucket
     */
    public void triggerRoot(FeedbackBucket feedbackBucket) {

    }

    public PmRoot(T_B parent){
        super(parent);
    }
}
