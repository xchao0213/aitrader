package com.wozaizhao;

import org.knowm.xchange.bitstamp.dto.marketdata.BitstampTicker;
import org.knowm.xchange.bitstamp.service.BitstampMarketDataServiceRaw;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.bitstamp.BitstampExchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.service.marketdata.MarketDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class tService {

    private static final Logger log = LoggerFactory.getLogger(tService.class);

    @Autowired
    private tTickerRepository ttickerRepository;


    Exchange exchange = ExchangeFactory.INSTANCE.createExchange(BitstampExchange.class.getName());

    MarketDataService marketDataService = exchange.getMarketDataService();

    private static void generic(MarketDataService marketDataService, tTickerRepository ttickerRepository) throws IOException {
        Ticker ticker = marketDataService.getTicker(CurrencyPair.BTC_USD);
        System.out.println(ticker.toString());

        binanceTicker tt = new binanceTicker();
        tt.setCurrencyPair(ticker.getCurrencyPair().toString());
        tt.setOpen(ticker.getOpen());
        tt.setLast(ticker.getLast());
        tt.setBid(ticker.getBid());
        tt.setAsk(ticker.getAsk());
        tt.setHigh(ticker.getHigh());
        tt.setLow(ticker.getLow());
        tt.setVwap(ticker.getVwap());
        tt.setVolume(ticker.getVolume());
        tt.setQuoteVolume(ticker.getQuoteVolume());
        tt.setTimestamp(ticker.getTimestamp());

        ttickerRepository.save(tt);
    }

    private static void raw(BitstampMarketDataServiceRaw marketDataService) throws IOException {
        BitstampTicker bitstampTicker = marketDataService.getBitstampTicker(CurrencyPair.BTC_USD);
        System.out.println(bitstampTicker.toString());
    }

    @Scheduled(fixedRate = 6000)
    public void getTicker() throws IOException {
        generic(marketDataService, ttickerRepository);
//        raw((BitstampMarketDataServiceRaw) marketDataService);

    }

}


