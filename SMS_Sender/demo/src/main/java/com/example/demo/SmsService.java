package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import jakarta.annotation.PostConstruct;

@Service
public class SmsService {

    @Autowired
    private TwilioConfig twilioConfig;

    @PostConstruct
    public void init() {
        System.out.println("Account SID: " + twilioConfig.getAccountSid());
        System.out.println("Auth Token: " + twilioConfig.getAuthToken());
        System.out.println("Phone Number: " + twilioConfig.getPhoneNumber());

        Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());

    }

    public void sendSms(String to, String message) {
        Message.creator(
                new PhoneNumber(to),
                new PhoneNumber(twilioConfig.getPhoneNumber()),
                message).create();
    }
}
