package com.wozaizhao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class TController {

    @Autowired
    private tTickerRepository ttickerRepository;


    @RequestMapping("/")
    public String root(){


        return "root ok";
    }

    @RequestMapping(path="/all")
    public @ResponseBody Iterable<tTicker> getAllTicker() {
        return ttickerRepository.findAll();
    }
}
