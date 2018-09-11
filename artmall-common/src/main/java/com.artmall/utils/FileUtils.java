package com.artmall.utils;

import com.artmall.conf.Key;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class FileUtils {

    /**
     *  上传成功则返回存储地址String数组，否则返回null
     * @param path_sign 分类表识
     * @param multipartFiles 多个文件
     * @return
     */
    public static String[] upFile(String path_sign,MultipartFile []multipartFiles){
        int len=multipartFiles.length;
        String path=makePath(path_sign);
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
    private static String makePath(String path_sign){
        String path=Key.getValue(Key.saveFileRootPath)+"/"+path_sign+"/"+DateUtil.getDays()+"/";
        File file=new File(path);
        if(!file.exists()) file.mkdirs();
        return path;
    }

}
