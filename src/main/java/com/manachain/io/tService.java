package com.manachain.io;


import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.bitstamp.BitstampExchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.service.marketdata.MarketDataService;

import java.io.IOException;

public class tService {
    Exchange bitstamp = ExchangeFactory.INSTANCE.createExchange(BitstampExchange.class.getName());

    MarketDataService marketDataService = bitstamp.getMarketDataService();

    public void getTicker() throws IOException{
        generic(marketDataService);

    }


    private static void generic(MarketDataService marketDataService) throws IOException {
        Ticker ticker = marketDataService.getTicker(CurrencyPair.BTC_USDT);
        System.out.println(ticker.toString());
    }

}


