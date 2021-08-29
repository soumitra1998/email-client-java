package com.soumitra.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;
    public String sendEmail(){

        SimpleMailMessage message =new SimpleMailMessage();
        message.setTo("programtrial145@gmail.com");
        message.setFrom("programtrial246@gmail.com");
        message.setSubject("this is test mail");
        message.setText("language should not be barrier for learning new technology");
        mailSender.send(message);

        System.out.println("send successfully");
        return "mail send sucessfully";
    }
    public String sendAttachment() throws MessagingException {
        MimeMessage message=mailSender.createMimeMessage();
        MimeMessageHelper messageHelper=new MimeMessageHelper(message,true);
        messageHelper.setTo("programtrial145@gmail.com");
        messageHelper.setFrom("programtrial246@gmail.com");
        messageHelper.setSubject("this is test mail to send attachment");
        messageHelper.setText("checkout this attachment");
        FileSystemResource file=new FileSystemResource(new File("C:\\Users\\soumi\\Downloads\\b.jpg"));
        messageHelper.addAttachment(file.getFilename(), file);
        mailSender.send(message);

        return "attachement send successfully";
    }

}
