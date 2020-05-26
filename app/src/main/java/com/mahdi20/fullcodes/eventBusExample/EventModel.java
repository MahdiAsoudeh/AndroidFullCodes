package com.mahdi20.fullcodes.eventBusExample;

public class EventModel {

    private String message;

    public EventModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}