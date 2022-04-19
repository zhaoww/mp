package com.banshan.wx.mp.model;

import lombok.Data;

import java.util.List;

/**
 * @author zhaoww
 * @since 2022/3/1
 */
@Data
public class WeatherDetailsInfoDto {
    private String publishTime;
    private List<Weather3HoursDetailsInfosDto> weather3HoursDetailsInfos;
}
