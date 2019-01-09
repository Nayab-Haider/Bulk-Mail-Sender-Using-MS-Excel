package com.poi.demo.service;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Iterator;

@Service
public class MailServiceImpl implements MailService {

    @Override
    public ResponseEntity<?> sendMail(MultipartFile file) {
        XSSFWorkbook workbook=null;
        XSSFRow row=null;
        try {
             workbook = new XSSFWorkbook(file.getInputStream());
            XSSFSheet spreadsheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = spreadsheet.iterator();
            while (rowIterator.hasNext()) {
                row = (XSSFRow) rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    System.out.println(cell);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
