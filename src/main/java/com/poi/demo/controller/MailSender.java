package com.poi.demo.controller;

import com.poi.demo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/demo")
public class MailSender {

    @Autowired
    private MailService mailService;

    @PostMapping("/mail")
    ResponseEntity<?> sendMail(@RequestParam("excelFile") MultipartFile file) {

        return mailService.sendMail(file);
    }

    @GetMapping("/get-template")
    ResponseEntity<?> getTemplate(HttpServletRequest request, HttpServletResponse response){
        return mailService.getTemplate(request,response);
    }
}
