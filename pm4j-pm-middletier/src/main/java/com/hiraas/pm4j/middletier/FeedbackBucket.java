package com.hiraas.pm4j.middletier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FeedbackBucket implements Serializable {

    private List<Feedback> feedbackList = new ArrayList();

    public String feedbacksAsString(){
        StringBuffer buffer = new StringBuffer();

        feedbackList.stream().forEach(feed ->{
            buffer.append(feed.getMessage() + " ");
        });

        return buffer.toString();
    }

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
