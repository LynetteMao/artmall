package com.artmall.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class FileUtils {

    private static String ROOT_PATH="/upload-dir";

    /**
     * 上传成功则返回存储地址String数组，否则返回null
     * @param multipartFiles
     * @return 放回存储地址字符串数组
     */
    public static String[] upFile(MultipartFile []multipartFiles){
        int len=multipartFiles.length;
        String path=makePath();
        String []apath=new String[len];
        for(int i=0;i<len;i++){
            apath[i]=path+multipartFiles[i].getOriginalFilename();
        }
        File []files=new File[len];
        for(int i=0;i<len;i++){
            files[i]=new File(apath[i]);
        }
        for(int i=0;i<len;i++){
            try {
                multipartFiles[i].transferTo(files[i]);
            } catch (IOException e) {
                if(i==len)i--;
                for(int j=i;j>=0;j--){
                    files[j].delete();
                }
                //ServerResponse<>
                return null;
            }
        }
        return apath;
    }

    /**
     * 删除文件
     * @param path
     */
    public static void deleteFiles(String []path){
        int len=path.length;
        for(int i=0;i<len;i++){
            File file=new File(path[i]);
            if(file.exists()){
                file.delete();
            }
        }
    }
    private static String CONF_PATH="D:\\github\\artmall\\artmall-common\\src\\main\\java\\com.artmall\\conf\\path_conf.properties";
    private static String CONF_saveRootFilePath_KEY="saveRootFilePath";
    private static String makePath(){
        String root="";
        try {
            Reader read=new FileReader(new File(CONF_PATH));
            Properties p=new Properties();
            p.load(read);
            root=p.getProperty(CONF_saveRootFilePath_KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String path=root+ROOT_PATH+"/"+DateUtil.getDays()+"/";
        File file=new File(path);
        if(!file.exists()) file.mkdirs();
        return path;
    }

}
