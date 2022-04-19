package com.banshan.wx.mp.model;

import lombok.Data;

/**
 * @author zhaoww
 * @since 2022/3/1
 */
@Data
public class EmailDto {
    //必填参数
    private String from;

    private String to;//接收方邮件

    private String subject;//主题

    private String content;//邮件内容

    //选填
    private String template;//模板

    private String cityId;

    private WeatherResponseDto weatherResponseDto;
}