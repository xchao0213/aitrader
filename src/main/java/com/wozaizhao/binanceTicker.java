package com.wozaizhao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class binanceTicker extends tTicker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
}
