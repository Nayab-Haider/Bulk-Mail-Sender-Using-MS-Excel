package com.poi.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public interface MailService {
    ResponseEntity<?> sendMail(MultipartFile file);
    ResponseEntity<?> getTemplate(HttpServletRequest request, HttpServletResponse response);
}
