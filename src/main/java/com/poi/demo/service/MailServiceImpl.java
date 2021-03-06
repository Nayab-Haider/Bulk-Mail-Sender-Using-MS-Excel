package com.poi.demo.service;

import com.poi.demo.util.MailModel;
import com.poi.demo.util.MailNotification;
import javafx.scene.shape.Path;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private MailNotification mailNotification;

    @Override
    public ResponseEntity<?> sendMail(MultipartFile file) {
        XSSFWorkbook workbook=null;
        List<String> recipients=new ArrayList<>();
        XSSFRow row=null;
        try {
             workbook = new XSSFWorkbook(file.getInputStream());
            XSSFSheet spreadsheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = spreadsheet.iterator();
            if(iterator.hasNext())
                iterator.next();
            int index=0;
            while (iterator.hasNext()){
                Row currentRow = iterator.next();
                Cell cell = currentRow.getCell(1);
                recipients.add(cell.toString());
                System.out.println(cell);
            }
            String[] recipientArr=new String[recipients.size()];
            MailModel mailModel=new MailModel(recipients.toArray(recipientArr),"mdnayab22@gmail.com","Testing","HELLLO");
            mailNotification.sendMail(mailModel);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Object>("Mail Sent Successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getTemplate(HttpServletRequest request, HttpServletResponse response) {
        String realPath = request.getServletContext().getRealPath("/static/");
        String basePath = System.getProperty("user.dir");
        java.nio.file.Path file = Paths.get(basePath+"\\src\\main\\resources\\static","apachePOI.xlsx");
        if(Files.exists(file)){
            response.setContentType("application/vnd.ms-excel");
            response.addHeader("Content-Disposition", "attachment; filename=+mailTemplate.xlsx");
            try {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
