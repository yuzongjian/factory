package com.example.demo.controller;

import gnu.io.SerialPort;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

import static com.example.demo.utils.tools.portParameterOpen;
import static com.example.demo.utils.tools.uartReceiveDatafromSingleChipMachine;
import static com.example.demo.utils.tools.uartSendDatatoSerialPort;

/**
 * create by yuzongjian on 2019/6/10
 * blog:yuzongjian.top
 */
@RestController
@RequestMapping(value = "/machine")
@EnableAutoConfiguration
@CrossOrigin
public class machine {
    @RequestMapping(value = "/user")
    public void machine(){
    // 打开串口
    SerialPort serialPort = portParameterOpen("COM3", 4800);
    // 要发送的数据
    String dataSend = "【Java和51单片机串口通信测试，我能吞下玻璃而不伤身体！】";

    int i=1;
        while(true) {
        // 发送数据到单片机
        byte []datByte = dataSend.getBytes();
        uartSendDatatoSerialPort(serialPort, datByte);
        System.out.println("-------------------------------------------------------");
        System.out.println((i++) + ". 发送到串口的数据：" + dataSend);

        // 休眠300ms，等待单片机反应
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 从单片机接收到的数据
        byte[] dat = uartReceiveDatafromSingleChipMachine(serialPort);
        if(dat != null && dat.length > 0) {
            String dataReceive = null;
            try {
                dataReceive = new String(dat, "GB2312");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            System.out.println((i++) + ". 从串口接收的数据：" + dataReceive);
        } else {
            System.out.println("接收到的数据为空！");
        }
    }
}
}