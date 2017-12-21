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

//        tTicker tt = new tTicker();
//        tt.setCurrencyPair("BTC/USD");
//        tt.setOpen(null);
//        tt.setLast(new BigDecimal(16306.82));
//        tt.setBid(new BigDecimal(16319.14));
//        tt.setAsk(new BigDecimal(16319.14));
//        tt.setHigh(new BigDecimal(17950.00));
//        tt.setLow(new BigDecimal(15343.04));
//        tt.setVolume(new BigDecimal(25948.23549891));
//        tt.setQuoteVolume(null);
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTimeInMillis(new Long("1513834285000"));
//
//        tt.setTimestamp(calendar.getTime());
//        ttickerRepository.save(tt);

        return "root ok";
    }

    @RequestMapping(path="/all")
    public @ResponseBody Iterable<tTicker> getAllTicker() {
        return ttickerRepository.findAll();
    }
}
