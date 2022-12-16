package com.tekup.ConfigSwager;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {
    private String uploadImgPlatsDir;

    public String getUploadImgPlatsDir() {
        return uploadImgPlatsDir;
    }

    public void setUploadImgPlatsDir(String uploadImgPlatsDir) {
        this.uploadImgPlatsDir = uploadImgPlatsDir;
    }
}
