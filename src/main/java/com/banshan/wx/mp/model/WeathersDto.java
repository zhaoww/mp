package com.banshan.wx.mp.model;

import lombok.Data;

/**
 * @author zhaoww
 * @since 2022/3/1
 */
@Data
public class WeathersDto {
    private String date;
    private long img;
    private String sun_down_time;
    private String sun_rise_time;
    private String temp_day_c;
    private String temp_day_f;
    private String temp_night_c;
    private String temp_night_;
    private String wd;
    private String weather;
    private String week;
    private String ws;
}
