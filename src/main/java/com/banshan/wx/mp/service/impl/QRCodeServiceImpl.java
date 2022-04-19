package com.banshan.wx.mp.service.impl;

import com.banshan.wx.mp.service.IQRCodeService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 半山兄
 * @since 2022/03/23
 */
@Service
public class QRCodeServiceImpl implements IQRCodeService {
    private static final String QR_CODE_IMAGE_PATH = "/Users/weiweizhao/Desktop/MyQRCode.png";

    public static void main(String[] args) {

        new QRCodeServiceImpl().generateToPath();
        byte[] bytes = new QRCodeServiceImpl().generateToBytes();
        System.out.println(bytes);

    }

    @Override
    public void generateToPath() {
        try {
            BitMatrix bitMatrix = generate("大宝贝🤔", 350, 350);
            Path path = FileSystems.getDefault().getPath(QR_CODE_IMAGE_PATH);
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public byte[] generateToBytes() {
        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        try {
            BitMatrix bitMatrix = generate("大宝贝🤔", 350, 350);

            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pngOutputStream.toByteArray();
    }

    public BitMatrix generate(String text, int width, int height) throws WriterException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Map<EncodeHintType, String> hints = new HashMap<>(2);
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        return qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height, hints);
    }


}
