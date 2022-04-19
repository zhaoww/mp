package com.banshan.wx.mp.service.weather;

import com.banshan.wx.mp.service.IWeatherService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author 半山兄
 * @since 2022/03/01
 */
@SpringBootTest
public class WeatherServiceTest {
    @Resource
    private IWeatherService weatherService;

    @Test
    public void test() {
        String url = "http://aider.meizu.com/app/weather/listWeather?cityIds=" + 101190101;
        String weatherDtlInfo = weatherService.getWeatherDtlInfo(url);
        System.out.println(weatherDtlInfo);
    }
}
