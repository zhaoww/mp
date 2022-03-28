package com.banshan.wx.mp.job;

import com.alibaba.fastjson.JSONObject;
import com.banshan.wx.mp.service.IWeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import com.banshan.wx.mp.model.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * 天气信息推送
 *
 * @author 半山兄
 * @since 2022/03/01
 */
@Component
@Slf4j
public class PushWeatherJob {

    @Value("${area.code}")
    private String areaCode;

    @Value("${sendall.url}")
    private String sendAllUrl;

    @Value("${access.token}")
    private String accessToken;

    @Resource
    private IWeatherService weatherService;

    @Resource
    private RestTemplate restTemplate;

    /**
     * todo 个人版权限不够
     */
//    @Scheduled(cron = "0 15 8 * *")
    public void handle(){

        String weatherDtlInfo = weatherService.getWeatherDtlInfo( areaCode);
        System.out.println(weatherDtlInfo);

        String url = sendAllUrl+ "?access_token=" +accessToken;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> filterMap = new HashMap<>();
        filterMap.put("is_to_all", true);
        Map<String, Object> textMap = new HashMap<>();
        filterMap.put("content", "CONTENT");
        SendAllRequest request = new SendAllRequest();
        request.setFilter(filterMap);
        request.setText(textMap);
        request.setMsgtype("text");
        HttpEntity<SendAllRequest> httpEntity = new HttpEntity<>(request, headers);
        ResponseEntity<JSONObject> exchange = restTemplate.exchange(url, HttpMethod.POST, httpEntity, JSONObject.class);
        System.out.println(exchange);
    }
}
