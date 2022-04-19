package com.banshan.wx.mp.model;

import lombok.Data;

import java.util.List;

/**
 * @author zhaoww
 * @since 2022/3/1
 */
@Data
public class MailWeatherDto {
    private List<EmailDto> email;
}
