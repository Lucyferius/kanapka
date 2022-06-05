package com.study.kanapka.controller;

import com.study.kanapka.service.DefaultImageService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class ImageController {

    private final DefaultImageService imageService;

    public ImageController(DefaultImageService imageService){
        this.imageService = imageService;
    }

    @RequestMapping(value = "/image/{name}", method = RequestMethod.GET)
    public void getImage(@PathVariable(value = "name") String name,
                         HttpServletResponse response) throws IOException {
        if (name != null) {
            InputStream is = imageService.getImage(name);
            if (is != null) {
                response.setContentType(MediaType.IMAGE_PNG_VALUE);
                IOUtils.copy(is, response.getOutputStream());
            }
        }
    }
}
