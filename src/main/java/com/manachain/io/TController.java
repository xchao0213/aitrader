package com.manachain.io;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Calendar;


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
