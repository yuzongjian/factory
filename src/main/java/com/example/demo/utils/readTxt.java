package com.example.demo.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * create by yuzongjian on 2019/6/8
 * blog:yuzongjian.top
 */
public class readTxt {
    public static int readTxt(String number) {
        int result =0;
        try {
            File file = new File("C:\\Apache\\data.txt");
            if (file.isFile() && file.exists()) {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
                BufferedReader br = new BufferedReader(isr);
                String lineTxt = null;
                //存在返回1.解决了崩溃问题
                while ((lineTxt = br.readLine()) != null) {
                    System.out.println(lineTxt);
                    if(lineTxt.equals(number)){
                        result=1;
                        break;
                    }
                }
                br.close();
            } else {
                System.out.println("文件不存在!");
                //不存在返回2
                return 2;
            }
        } catch (Exception e) {
            //txt文件读取出错或者不存在返回3
            System.out.println("文件读取错误!");
            return 3;
        }
        return result;
    }
}
