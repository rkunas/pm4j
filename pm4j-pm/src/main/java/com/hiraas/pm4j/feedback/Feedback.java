package com.hiraas.pm4j.feedback;


import java.io.Serializable;

public class Feedback implements Serializable {
    public enum Severity {
        INFO, WARNING, ERROR;
    }

    private Severity severity;
    private String message;

    public Feedback(Severity severity, String message) {
        this.severity = severity;
        this.message = message;
    }

    public Severity getSeverity() {
        return severity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }
}
