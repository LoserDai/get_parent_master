package com.df.leeCode;

import java.io.File;

/**
 * @Author feng.dai
 * @package com.df.leeCode
 * @project LeeCodeDemo
 * @Date 2022/9/15 11:34
 */
public class Test01 {
    public static void main(String[] args) {
        String path = "D:\\FileSetUp\\图片文件";
        getFileName(path);
    }

    public static void getFileName(String path) {
        File file = new File(path);
        File[] listFiles = file.listFiles();
        for (File listFile : listFiles) {
            if (listFile.isFile()) {
                System.out.println("文件名：" + listFile.getName());
            }
            if (listFile.isDirectory()) {
                getFileName(listFile.getPath());
            }
        }
    }

}
