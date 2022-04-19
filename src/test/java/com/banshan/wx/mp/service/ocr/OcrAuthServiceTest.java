package com.banshan.wx.mp.service.ocr;

import com.banshan.wx.mp.service.IOcrAuthService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author 半山兄
 * @since 2022/04/12
 */
@SpringBootTest
public class OcrAuthServiceTest {
    @Resource
    private IOcrAuthService ocrAuthService;

    @Test
    public void testGetAuth() {
        String auth = ocrAuthService.getAuth();
        System.out.println(auth);
    }

    @Test
    public void testGeneralBasic() {
        ocrAuthService.generalBasic();
    }
}
