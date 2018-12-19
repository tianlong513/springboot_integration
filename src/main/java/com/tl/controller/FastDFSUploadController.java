package com.tl.controller;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.tl.service.UserInfoService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @program: tl
 * @description:
 * @author:
 * @create: 2018-12-10 14:32
 **/
@RestController
public class FastDFSUploadController {
    @RequestMapping(value = "hello")
    public String Hello() {
        return "hello";
    }

    private UserInfoService userInfoService;

    @Value("${fastDfs.host}")
    private String hostIP;

    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    /**
     * fdfs单图片上传
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "pic")
    public String uploadPic(MultipartFile file) {

        StorePath storePath = null;
        try {
            storePath = fastFileStorageClient.uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String fileUrl = storePath.getFullPath();
        System.out.println(fileUrl);
        return fileUrl;
    }

    /**
     * fdfs多图片上传
     * @param files
     * @return
     */
    @RequestMapping(value = "pics")
    public String uploadPics(MultipartFile files[]) {

        StringBuffer str = new StringBuffer();
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            System.out.println(file);
            try {
                //上传文件
                StorePath storePath = fastFileStorageClient.uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), null);
                str = str.append(storePath.getFullPath()).append(",");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return str.deleteCharAt(str.length() - 1).toString();
    }
}
