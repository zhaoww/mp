package com.banshan.wx.mp.service.job;

import com.banshan.wx.mp.job.PushWeatherJob;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author 半山兄
 * @since 2022/03/02
 */
@SpringBootTest
public class PushWeatherJobTest {
    @Resource
    private PushWeatherJob pushWeatherJob;

    @Test
    public void test() {
        pushWeatherJob.handle();
    }
}
