package com.banshan.wx.mp.service;

/**
 * QR code
 *
 * @author 半山兄
 * @since 2022/03/23
 */
public interface IQRCodeService {
    /**
     * 生成二维码
     */
    void generateToPath();

    /**
     * 生成二维码数组
     *
     * @return bytes
     */
    byte[] generateToBytes();
}
