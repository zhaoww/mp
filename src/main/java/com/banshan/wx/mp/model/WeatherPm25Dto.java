package com.banshan.wx.mp.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 *
 *
 * @author zhaoww
 * @since 2022/3/1
 */
@Data
public class WeatherPm25Dto {
    private long advice;
    private long aqi;
    private long citycount;
    private long cityrank;
    private BigDecimal co;
    private long color;
    private long level;
    private long no2;
    private long o3;
    private String pm10;
    private String pm25;
    private String quality;
    private long so2;
    private long timestamp;
    private String upDateTime;
}
