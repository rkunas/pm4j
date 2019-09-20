package com.hiraas.pm4j.feedback;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FeedbackBucket implements Serializable {

    private List<Feedback> feedbackList = new ArrayList<>();

    public FeedbackBucket(){

    }

    public void addFeedback(Feedback.Severity severity, String message){
        feedbackList.add(new Feedback(severity,message));
    }

    public void addFeedback(Feedback feedback){
        feedbackList.add(feedback);
    }

    public List<Feedback> getFeedbacks(){
        return feedbackList;
    }
}
