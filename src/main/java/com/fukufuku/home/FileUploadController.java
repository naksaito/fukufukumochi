package com.fukufuku.home;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

    @Value("${image.update.path}")
    private String imageUpdatePath;

    @RequestMapping(path = "/fileUpload", method = RequestMethod.GET)
    public String fileUpload() {
        return "fileUpload";
    }

    @RequestMapping(path = "/fileUpload", method = RequestMethod.POST)
    public String upload(@RequestParam MultipartFile upfile) {
        // ファイルが空の場合
        if (upfile.isEmpty()) {
            return "failure";
        }
        // ファイル名取得
        String fileName = upfile.getOriginalFilename();

        // ファイル格納
        try {
            File uploadFile = new File(imageUpdatePath + fileName);
            byte[] bytes = upfile.getBytes();

            BufferedOutputStream uploadFileStream = new BufferedOutputStream(new FileOutputStream(uploadFile));
            uploadFileStream.write(bytes);
            uploadFileStream.close();

        } catch (IOException e) {
            e.printStackTrace();
            return "failure";
        }
        return "success";
    }
}