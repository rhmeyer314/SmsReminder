package com.project.smstodo.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:8000")
@RequestMapping("api/v1/sms")
public class TwilioController {

    private final TwilioService twilioService;

    @Autowired
    public TwilioController(TwilioService twilioService) {
        this.twilioService = twilioService;
    }

    @PostMapping
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {
        twilioService.sendSms(smsRequest);
    }
}
