package com.banshan.wx.mp.service;

import java.util.Map;

/**
 * @author 半山兄
 * @since 2022/03/02
 */
public interface IReplyMsgService {
    /**
     * 回复
     *
     * @param requestMap
     * @return
     */
    String reply(Map<String, String> requestMap);
}
