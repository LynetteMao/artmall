package com.artmall.conf;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.Properties;

final public class Key {

    /**
     * 读取保存文件的根路径的键
     */
    public static String saveFileRootPath="saveFileRootPath";

    /**
     * 配置文件读取路径
     */
    private static String confPath="D:\\artmall\\artmall-common\\src\\main\\java\\com.artmall\\conf\\path_conf.properties";
    /**
     * 保存properties
     */
    private static Properties p=new Properties();

    /**
     * 返回对应的value
     * @param key
     * @return
     */
    public static String getValue(String key){
        String value="";
        try {
            Reader read=new FileReader(new File(confPath));
            p.load(read);
            value=p.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}