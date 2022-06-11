package com.study.kanapka.service;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Component
public class DefaultImageService {
    private final String IMAGE_DIR = "images/";

    public String saveImage(MultipartFile multipartFile) {
        if (!multipartFile.isEmpty()) {
            try {
                byte[] bytes = multipartFile.getBytes();
                String currFileName = System.currentTimeMillis() + "." + FilenameUtils.getExtension(multipartFile.getOriginalFilename());
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(IMAGE_DIR + currFileName));
                stream.write(bytes);
                stream.close();
                return currFileName;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public boolean removeImage(String imgName) {
        File file = new File(IMAGE_DIR + imgName);
        if (!file.exists()) {
            return false;
        }
        return file.delete();
    }

    public InputStream getImage(String image) {
        try {
            return new FileInputStream(IMAGE_DIR + image);
        } catch (FileNotFoundException e) {
            try {
                return new FileInputStream(IMAGE_DIR + "Salad1.png");
            } catch (FileNotFoundException ex) {
                return null;
            }
        }
    }
}
