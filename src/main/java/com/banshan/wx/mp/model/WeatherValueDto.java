package com.banshan.wx.mp.model;

import lombok.Data;

import java.util.List;

/**
 * @author zhaoww
 * @since 2022/3/1
 */
@Data
public class WeatherValueDto {
    private List<WeatherAlarmDto> alarms;
    private String city;
    private String cityid;
    private List<WeatherIndexDto> indexes;
    private WeatherPm25Dto pm25;
    private String provinceName;
    private WeatherRealtimeDto realtime;
    private WeatherDetailsInfoDto weatherDetailsInfo;
    private List<WeathersDto> weathers;
}
