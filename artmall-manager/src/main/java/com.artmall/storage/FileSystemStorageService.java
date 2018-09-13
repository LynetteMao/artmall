package com.artmall.storage;

import com.artmall.exception.StorageException;
import com.artmall.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author
 * @create 2018-08-20 16:18
 **/
@Service
public class FileSystemStorageService implements StorageService {
    private final Path rootLocation;
    private final Path watermarkLocationp;
    private final Path imagedirectoryLocation;

    public Path getImagedirectoryLocation() {
        return imagedirectoryLocation;
    }


    public Path getRootLocation() {
        return rootLocation;
    }
    public Path getWatermarkLocationp(){
        return watermarkLocationp;
    }

    //获取配置文件里面的地址
    @Autowired
    public FileSystemStorageService(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
        this.watermarkLocationp = Paths.get(properties.getWatermark());
        this.imagedirectoryLocation = Paths.get(properties.getImagedirectory());
    }

    @Override
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        }
        catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }

    /**
     * 单文件的上传
     * @param file
     * @return
     */
    @Override
    public String store(MultipartFile file,Path path)  {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());

            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + filename);

            }
            if (filename.contains("..")) {
                throw new StorageException(
                        "Cannot store file with relative path outside current directory "
                                + filename);            }

        try {
                InputStream inputStream = file.getInputStream();
                Files.copy(inputStream, path,
                            StandardCopyOption.REPLACE_EXISTING);
            return filename;
        } catch (IOException e) {
            throw new StorageException("Failed to store file " + filename, e);

        }

    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }


    public Path[] fileUpload(String path_sign,MultipartFile []file){
        int len=file.length;
        //为了区分每个不同类型的文件放在不同的文件夹

        Path []filePath=new Path[len];
//        String [] filePathByString = new String[len];
        Path path = null;
        //文件路径为路径加上文件名称
        for(int i=0;i<len;i++){
            path=makePath(path_sign,file[i].getOriginalFilename());
            filePath[i]=path;
        }
        //初始化文件
        File[]files=new File[len];

        for(int i=0;i<len;i++) {

            try {
                InputStream inputStream = file[i].getInputStream();
                Files.copy(inputStream, filePath[i],
                        StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                if (i == len)
                    i--;
                for (int j = i; j >= 0; j--) {
                    files[j].delete();
                }
                throw new StorageException("Failed to store file " + file[i].getOriginalFilename(), e);
            }
        }
        return filePath;

    }



    /**
     * 返回文件路径加文件名
     * @param path_sign
     * @param filename
     * @return
     */
    public Path makePath(String path_sign,String filename){
        File file=new File(this.rootLocation.resolve(path_sign).toString());
        if(!file.exists()) file.mkdirs();
        return file.toPath().resolve(filename);
    }

    public Path makeWatermarkPath(String path_sign, String filename){
        File file = new File(this.watermarkLocationp.resolve(path_sign).toString());
        if (!file.exists()) file.mkdirs();
        return file.toPath().resolve(filename);
    }

    @Override
    public Path makeImageDirectoryPath(String pathSign, String filename) {
        File file = new File(this.imagedirectoryLocation.resolve(pathSign).toString());
        if (!file.exists()) file.mkdirs();
        return file.toPath().resolve(filename);
    }


}


