package com.poi.demo.controller;

import com.poi.demo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/demo")
public class MailSender {

    @Autowired
    private MailService mailService;

    @PostMapping("/mail")
    ResponseEntity<?> sendMail(@RequestBody MultipartFile file) {

        return mailService.sendMail(file);
    }

}
