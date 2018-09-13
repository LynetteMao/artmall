package com.artmall.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author
 * @create 2018-08-21 10:29
 **/
@ConfigurationProperties("storage")
public class StorageProperties {
    private String location = "image\\upload-dir";

    private String watermark = "image\\save-water-mark";

    private String imagedirectory = "image\\image-directory";




    public String getImagedirectory() {

        return imagedirectory;
    }

    public void setImagedirectory(String imagedirectory) {
        this.imagedirectory = imagedirectory;
    }

    public String getWatermark() {
        return watermark;
    }

    public void setWatermark(String watermark) {
        this.watermark = watermark;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
