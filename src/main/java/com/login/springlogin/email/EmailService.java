package com.login.springlogin.email;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class EmailService implements EmailSender
{
    private final  JavaMailSender mailSender ;
    private final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    @Async
    @Override
    public void send(String to, String email)
    {
        try
        {
            MimeMessage message= mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");
            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject("Please Confirm your email in your email box");
            helper.setFrom("oumardialo98@gmail.com");

            mailSender.send(message);
        }
        catch (MessagingException e)
        {
            LOGGER.error("Just failed to send the mail");
            throw new IllegalStateException("Just failed to send the mail from IllegalStatement");
        }
    }
}
