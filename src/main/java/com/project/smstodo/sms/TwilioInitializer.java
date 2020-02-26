package com.project.smstodo.sms;

import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

// injects TwilioConfiguration class in order to initialize and establish Twilio in application
@Configuration
public class TwilioInitializer {
    final private TwilioConfiguration twilioConfiguration;

    final private Countdown countdown;

    private final static Logger LOGGER = LoggerFactory.getLogger(TwilioInitializer.class);


    @Autowired
    public TwilioInitializer(TwilioConfiguration twilioConfiguration, Countdown countdown) {
        this.twilioConfiguration = twilioConfiguration;
        this.countdown = countdown;
        Twilio.init(
                twilioConfiguration.getAccountSid(),
                twilioConfiguration.getAuthToken()
        );
        LOGGER.info("Twilio initialized ...  with account sid {}", twilioConfiguration.getAccountSid());
    }
}
