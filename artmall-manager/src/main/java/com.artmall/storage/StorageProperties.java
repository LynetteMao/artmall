package com.artmall.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author
 * @create 2018-08-21 10:29
 **/
@ConfigurationProperties("storage")
public class StorageProperties {
    private String location = "upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
