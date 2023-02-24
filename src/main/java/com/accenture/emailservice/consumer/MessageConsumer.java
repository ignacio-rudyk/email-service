package com.accenture.emailservice.consumer;

import com.accenture.emailservice.model.dto.MailTemplateDTO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @Autowired
    private Gson gson;

    @JmsListener(destination = "${queue.email.notification.transaction}")
    public void onMessage(String msg) {
        try {
            MailTemplateDTO mailTemplate = gson.fromJson(msg, MailTemplateDTO.class);
            System.out.println(mailTemplate);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

}