package com.banshan.wx.mp.service;

/**
 * 天气
 *
 * @author 半山兄
 * @since 2022/03/01
 */
public interface IWeatherService {
    /**
     * 获取天气信息
     *
     * @param areaCode
     * @return
     */
    String getWeatherDtlInfo(String areaCode);
}
