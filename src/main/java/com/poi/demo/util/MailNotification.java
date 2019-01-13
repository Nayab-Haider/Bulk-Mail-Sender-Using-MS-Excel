package com.poi.demo.util;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import com.sun.xml.internal.org.jvnet.mimepull.MIMEMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
@Component
public class MailNotification {


//    @Autowired
//    private JavaMailSender emailSender;

    public boolean sendMail() {
//        MimeMessage message = null;
//        boolean isMailSend = false;
//        try {
//            message = emailSender.createMimeMessage();
//            MimeMessageHelper helper = null;
//            try {
//                helper = new MimeMessageHelper(message, true);
//            } catch (javax.mail.MessagingException e) {
//                e.printStackTrace();
//            }
//            if (mailModel.getTo() != null && !mailModel.getTo().equals("")) helper.setTo(mailModel.getTo());
//            if (mailModel.getMultipleTo() != null && mailModel.getMultipleTo().length > 0)
//                helper.setTo(mailModel.getMultipleTo());
//            if (mailModel.getCc() != null && mailModel.getCc().length > 0) helper.setCc(mailModel.getCc());
//            if (mailModel.getBcc() != null && mailModel.getBcc().length > 0) helper.setBcc(mailModel.getBcc());
//            helper.setFrom(mailModel.getFrom());
//            helper.setSubject(mailModel.getSubject());
//            helper.setText(mailModel.getMessage(), true);
//            emailSender.send(message);
//            isMailSend = true;
//        } catch (javax.mail.MessagingException e) {
//            e.printStackTrace();
//        }
//        return isMailSend;
        return false;
    }
}
