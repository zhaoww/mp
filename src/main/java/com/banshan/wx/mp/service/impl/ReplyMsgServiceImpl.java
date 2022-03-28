package com.banshan.wx.mp.service.impl;

import com.banshan.wx.mp.dto.BaseMessage;
import com.banshan.wx.mp.dto.ImageMessage;
import com.banshan.wx.mp.dto.TextMessage;
import com.banshan.wx.mp.service.IQRCodeService;
import com.banshan.wx.mp.service.IReplyMsgService;
import com.banshan.wx.mp.service.IWeatherService;
import com.banshan.wx.mp.util.MessageUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

import static com.banshan.wx.mp.common.enums.MsgFnEnum.QR_CODE;
import static com.banshan.wx.mp.common.enums.MsgFnEnum.WEATHER;

/**
 * @author 半山兄
 * @since 2022/03/02
 */
@Service
public class ReplyMsgServiceImpl implements IReplyMsgService {
    @Value("${area.code}")
    private String areaCode;
    @Resource
    private IWeatherService weatherService;
    @Resource
    private IQRCodeService qrCodeService;

    @Override
    public String reply(Map<String, String> requestMap) {
        String resp = "";
        BaseMessage baseMessage = new BaseMessage();
        baseMessage.setFromUserName(requestMap.get("ToUserName"));
        baseMessage.setToUserName(requestMap.get("FromUserName"));
        baseMessage.setCreateTime(System.currentTimeMillis());
        baseMessage.setMsgType(requestMap.get("MsgType"));

        if (requestMap.get("Content").contains(WEATHER.getCode())) {
            String content = weatherService.getWeatherDtlInfo(areaCode);
            TextMessage textMessage = new TextMessage();
            BeanUtils.copyProperties(baseMessage, textMessage);
            textMessage.setContent(content);
            resp = MessageUtil.messageToXML(textMessage, TextMessage.class);
        } else if (requestMap.get("Content").contains(QR_CODE.getCode())) {
            qrCodeService.generateToPath();
            // todo 暴露图片地址
            String picUrl = "";
            ImageMessage imageMessage = new ImageMessage();
            BeanUtils.copyProperties(baseMessage, imageMessage);
            imageMessage.setPicUrl(picUrl);
            resp = MessageUtil.messageToXML(imageMessage, ImageMessage.class);
        } else {
            String content = requestMap.get("Content");
            TextMessage textMessage = new TextMessage();
            BeanUtils.copyProperties(baseMessage, textMessage);
            textMessage.setContent(content);
            resp = MessageUtil.messageToXML(textMessage, TextMessage.class);
        }
        return resp;
    }
}
