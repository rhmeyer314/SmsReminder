package com.project.smstodo.sms;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

// blueprint for sending messages
public class SmsRequest {

    @NotBlank
    private final String phoneNumber; // phone number that will receive sms message

    @NotBlank
    private final String message; // actual contents of sms message

    public SmsRequest(@JsonProperty("phoneNumber") String phoneNumber, @JsonProperty("message") String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "SmsRequest{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
