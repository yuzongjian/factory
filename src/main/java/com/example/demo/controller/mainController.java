package com.example.demo.controller;

import com.example.demo.utils.readTxt;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by yuzongjian on 2019/6/8
 * blog:yuzongjian.top
 */

@RestController
@RequestMapping(value = "/try")
@EnableAutoConfiguration
@CrossOrigin
public class mainController {
    @RequestMapping(value = "/user")
    public int getUsers(@RequestParam(value = "number", required = false) String number){
        System.out.println(number);
        if(number==null){
            return 0;
        }
        else{
            return readTxt.readTxt(number);
        }
    }
}
