package com.banshan.wx.mp.common.enums;

import lombok.Getter;

/**
 * 功能枚举
 *
 * @author 半山兄
 * @since 2022/03/28
 */
@Getter
public enum MsgFnEnum {
    /**
     * MsgFnEnum
     */
    WEATHER("天气", MsgTypeEnum.TEXT.getCode()),
    QR_CODE("二维码", MsgTypeEnum.IMAGE.getCode()),
    FN_ALL("功能大全", MsgTypeEnum.TEXT.getCode());

    /**
     * code
     */
    private final String code;

    /**
     * value
     */
    private final String value;

    /**
     * enum
     *
     * @param code  c
     * @param value v
     */
    MsgFnEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }
}
