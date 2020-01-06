package com.ssq.infrastructure.service;

import com.ssq.infrastructure.core.log.LoggerBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Email
 *
 * @author sunsiquan
 * @date 2020-01-06
 */
@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public Boolean sendEmail(String from, String to, String title, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(title);
        message.setText(content);
        try {
            mailSender.send(message);
        } catch (Exception e) {
            LoggerBase.error(e.toString());
            return false;
        }
        return true;
    }
}
