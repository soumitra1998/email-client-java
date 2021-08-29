package com.soumitra.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class MailController {
    @Autowired
    private MailService mailService;
    @GetMapping(value = "/sendmail")
    public String sendEmail(){
        return mailService.sendEmail();
    }
    @GetMapping(value = "/send")
    public String sendAttachment() throws MessagingException {
        return mailService.sendAttachment();
    }
}
