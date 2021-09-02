package com.hasan.springbootrestapi.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {
    public final String UPLOAD_DIR = "D:\\Spring Boot\\spring_boot_rest_api_durgesh\\src\\main\\resources\\static\\images";

    public boolean isUpload(MultipartFile multipartFile) {
        boolean flag = false;

        try {

/*            // read
            InputStream inputStream = multipartFile.getInputStream();
            byte data[] = new byte[inputStream.available()];
            inputStream.read(data);

            //write
            FileOutputStream fileOutputStream = new FileOutputStream(UPLOAD_DIR + File.separator + multipartFile.getOriginalFilename());
            fileOutputStream.write(data);
            fileOutputStream.flush();
            fileOutputStream.close();*/

            // or
            Files.copy(
                    multipartFile.getInputStream(),
                    Paths.get(UPLOAD_DIR + File.separator + multipartFile.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING
            );

            flag = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }
}
