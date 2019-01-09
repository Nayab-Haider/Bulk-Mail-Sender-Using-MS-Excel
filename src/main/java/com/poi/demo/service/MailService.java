package com.poi.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public interface MailService {
    ResponseEntity<?> sendMail(MultipartFile file);

}
