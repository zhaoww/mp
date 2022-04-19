package com.banshan.wx.mp.model;

import lombok.Data;

import java.util.List;

/**
 * @author zhaoww
 * @since 2022/3/1
 */
@Data
public class WeatherResponseDto {
    private int code;
    private String message;
    private String redirect;
    private List<WeatherValueDto> value;
}
