package com.poi.demo.util;


import javax.mail.MessagingException;
import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class MailNotification {

    @Autowired
    private JavaMailSender emailSender;


    public MailNotification() {
    }


    public boolean sendMail(MailModel mailModel) {
        MimeMessage message = null;
        boolean isMailSend = false;
        try {
            message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            if (mailModel.getTo() != null && !mailModel.getTo().equals("")) helper.setTo(mailModel.getTo());
            if (mailModel.getMultipleTo() != null && mailModel.getMultipleTo().length > 0)
                helper.setTo(mailModel.getMultipleTo());
            if (mailModel.getCc() != null && mailModel.getCc().length > 0) helper.setCc(mailModel.getCc());
            if (mailModel.getBcc() != null && mailModel.getBcc().length > 0) helper.setBcc(mailModel.getBcc());
            helper.setFrom(mailModel.getFrom());
            helper.setSubject(mailModel.getSubject());
            helper.setText(mailModel.getMessage(), true);
            emailSender.send(message);
            isMailSend = true;
        } catch (MessagingException e) {
            isMailSend = false;
            e.printStackTrace();
        }
        return isMailSend;
    }

    public boolean sendMailWithAttachment(MailModel mailModel, String path) throws Exception {
        boolean isMailSend = false;
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(mailModel.getTo());
            helper.setFrom(mailModel.getFrom());
            helper.setSubject(mailModel.getSubject());
            helper.setText(mailModel.getMessage());

            FileSystemResource file = new FileSystemResource(new File(path));
            helper.addAttachment("Invoice", file);
            emailSender.send(message);
            isMailSend = true;

        } catch (MessagingException e) {
            isMailSend = false;
            e.printStackTrace();
        }
        return isMailSend;
    }
}
