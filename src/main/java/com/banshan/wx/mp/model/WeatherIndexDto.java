package com.banshan.wx.mp.model;

import lombok.Data;

/**
 *
 *
 * @author zhaoww
 * @since 2022/3/1
 */
@Data
public class WeatherIndexDto {
    private String abbreviation;
    private String alias;
    private String content;
    private String level;
    private String name;
}
