package com.artmall.utils;

import java.util.Random;

public class Tools {
    /**
     * 随机生成验证码
     */
    public static String getRandomNum() {
        String sources = "0123456789";
        Random ran = new Random();
        StringBuffer flag = new StringBuffer();
        for (int j = 0; j < 6; j++)
            flag.append(sources.charAt(ran.nextInt(9)) + "");
        return (flag.toString());
    }

    /**
     * 检验key是否正确
     */
    public static boolean checkKey(String paraname, String key) {
        paraname = (null == paraname) ? "" : paraname;
        return MD5.md5(paraname + DateUtil.getDays() + ",fh,").equals(key);
    }
}
