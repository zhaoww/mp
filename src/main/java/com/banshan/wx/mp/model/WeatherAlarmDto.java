package com.banshan.wx.mp.model;

import lombok.Data;

/**
 * @author zhaoww
 * @since 2022/3/1
 */
@Data
public class WeatherAlarmDto {
    private String alarmContent;
    private String alarmDesc;
    private String alarmId;
    private long alarmLevelNo;
    private String alarmLevelNoDesc;
    private long alarmType;
    private String alarmTypeDesc;
    private String precaution;
    private String publishTime;
}
