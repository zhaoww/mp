package com.banshan.wx.mp.model;

/**
 *
 *
 * @author zhaoww
 * @since 2022/3/1
 */

import lombok.Data;

@Data
public class Weather3HoursDetailsInfosDto {
    private String endTime;
    private long highestTemperature;
    private long img;
    private String isRainFall;
    private long lowerestTemperature;
    private long precipitation;
    private String startTime;
    private String wd;
    private String weather;
    private String ws;
}
