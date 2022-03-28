package com.banshan.wx.mp.common.enums;

import lombok.Getter;

/**
 * 消息类型枚举
 *
 * @author 半山兄
 * @since 2022/03/28
 */
@Getter
public enum MsgTypeEnum {
    /**
     * MsgTypeEnum
     */
    TEXT("text"),
    IMAGE("image"),
    VOICE("voice"),
    VIDEO("video"),
    LINK("link"),
    NEWS("news");

    /**
     * code
     */
    private final String code;

    /**
     * enum
     *
     * @param code code
     */
    MsgTypeEnum(String code) {
        this.code = code;
    }
}
