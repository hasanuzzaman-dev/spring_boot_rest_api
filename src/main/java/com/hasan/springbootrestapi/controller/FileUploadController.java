package com.hasan.springbootrestapi.controller;

import com.hasan.springbootrestapi.helper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        /*System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        System.out.println(file.getContentType());*/

        try {
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Request must contain a file!");
            }

            // file upload coding......
            boolean isFileUpload = fileUploadHelper.isUpload(file);
            if (isFileUpload) {
                // return ResponseEntity.ok("File upload successfully");
                return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/")
                        .path(file.getOriginalFilename()).toUriString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something wrong try again!");
    }
}
