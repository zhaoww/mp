package com.banshan.wx.mp.model;

import lombok.Data;

/**
 *
 *
 * @author zhaoww
 * @since 2022/3/1
 */
@Data
public class WeatherRealtimeDto {
    private long img;
    private long sD;
    private long sendibleTemp;
    private long temp;
    private String time;

    private String wD;
    private String wS;
    private String weather;
    private String ziwaixian;

    public String getwD() {
        return wD;
    }

    public void setwD(String wD) {
        this.wD = wD;
    }

    public String getwS() {
        return wS;
    }

    public void setwS(String wS) {
        this.wS = wS;
    }
}
