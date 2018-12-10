package com.tl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: tl
 * @description:
 * @author:
 * @create: 2018-12-10 14:32
 **/
@RestController
public class test {
    @RequestMapping(value = "hello")
    public String Hello() {
        return "hello12";
    }
}
