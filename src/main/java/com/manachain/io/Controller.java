package com.manachain.io;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private static final String hi = "hi";

    @RequestMapping("/")
    public String root(){
        return "root ok";
    }
}
