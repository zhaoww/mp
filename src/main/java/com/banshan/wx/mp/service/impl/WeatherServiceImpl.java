package com.banshan.wx.mp.service.impl;

import com.banshan.wx.mp.model.WeatherRealtimeDto;
import com.banshan.wx.mp.model.WeatherResponseDto;
import com.banshan.wx.mp.model.WeatherValueDto;
import com.banshan.wx.mp.model.WeathersDto;
import com.banshan.wx.mp.service.IWeatherService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 半山兄
 * @since 2022/03/01
 */
@Service
public class WeatherServiceImpl implements IWeatherService {

    @Value("${weather.url}")
    private String weatherUrl;

    @Resource
    private RestTemplate restTemplate;

    @Override
    public String getWeatherDtlInfo(String areaCode) {
        WeatherResponseDto dto = restTemplate.getForObject(weatherUrl + "?cityIds=" + areaCode, WeatherResponseDto.class);
        if (dto == null) {
            return "查询天气异常";
        }
        return buildContent(dto);
    }

    /**
     * todo 模版
     *
     * @param dto
     * @return
     */
    private String buildContent(WeatherResponseDto dto) {
        StringBuilder sb = new StringBuilder();
        if (!CollectionUtils.isEmpty(dto.getValue())) {
            WeatherValueDto weatherValueDto = dto.getValue().get(0);

            WeatherRealtimeDto weatherRealtimeDto = weatherValueDto.getRealtime();
            WeathersDto weathersDto = weatherValueDto.getWeathers().get(0);
            sb.append("今日").append(weatherValueDto.getCity()).append("天气").append(weathersDto.getWeather()).append("。")
                    .append("白天气温为").append(weathersDto.getTemp_day_c()).append("℃,")
                    .append("夜间气温为").append(weathersDto.getTemp_night_c()).append("℃,")
                    .append("当前体感温度为").append(weatherRealtimeDto.getTemp()).append("℃,")
                    .append(weatherRealtimeDto.getwD()).append(weatherRealtimeDto.getwS()).append("。");
        }
        return sb.toString();
    }

}
