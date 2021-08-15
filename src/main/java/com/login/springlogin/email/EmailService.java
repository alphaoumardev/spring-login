/*
  Created by:oumar
  Project:spring-login
  Name:EmailService
  Date: 8/14/2021
  Time: 4:06 PM
*/
package com.login.springlogin.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService implements EmailSender
{
    private final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    private final  JavaMailSender mailSender ;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    @Override
    @Async
    public void send(String to, String email)
    {
        try
        {
            assert false;
            MimeMessage message= mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");
            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject("Please Confirm your email");
            helper.setFrom("oumardialo98@gmail.com");
            mailSender.send(message);
        }
        catch (MessagingException e)
        {
            LOGGER.error("just failed to send the mail");
            throw new IllegalStateException("just failed to send the mail");
        }
    }
}
