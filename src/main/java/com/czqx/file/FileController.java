package com.czqx.file;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {

    Logger log = LoggerFactory.getLogger(FileController.class);

    @Value("${fdfs.urlPath}")
    private String urlPath;
    @Autowired
    FastFileStorageClient fileStorageClient;
    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file){
        StorePath storePath = null;
        try {
            String originalFilename = file.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            storePath = fileStorageClient.uploadFile(file.getInputStream(), file.getSize(),extName , null);
        }catch (IOException e){
            log.error("上传失败");
        }
        return urlPath + storePath.getFullPath();
    }
}
