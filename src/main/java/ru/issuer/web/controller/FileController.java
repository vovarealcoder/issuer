package ru.issuer.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class FileController {

    private final Logger logger = LoggerFactory.getLogger(FileController.class);

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String form() {
        return "upload";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile multipartFile) {
        if (!multipartFile.isEmpty()) {
            String property = System.getProperty("user.home");
            try {
                byte[] bytes = multipartFile.getBytes();
                String name = multipartFile.getOriginalFilename();
                File dir = new File(property + File.separator + "tmpfiles");
                if (!dir.exists()) {
                    dir.mkdir();
                }
                File cpFile = new File(dir.getAbsolutePath() + File.separator + name);
                try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(cpFile))) {
                    bufferedOutputStream.write(bytes);
                }
                return "success";
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
                return "fail";
            }
        }
        return "empty";
    }
}
