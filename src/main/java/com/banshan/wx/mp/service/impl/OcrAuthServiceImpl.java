package com.banshan.wx.mp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.banshan.wx.mp.service.IOcrAuthService;
import com.banshan.wx.mp.util.ocr.Base64Util;
import com.banshan.wx.mp.util.ocr.FileUtil;
import com.banshan.wx.mp.util.ocr.HttpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * ocr
 *
 * @author 半山兄
 * @since 2022/04/12
 */
@Service
public class OcrAuthServiceImpl implements IOcrAuthService {
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Value("${baidu.ocr.general_basic.url}")
    private String generalBasicUrl;

    @Value("${baidu.ocr.token.url}")
    private String tokenUrl;

    @Value("${baidu.ocr.clientId}")
    private String clientId;

    @Value("${baidu.ocr.clientSecret}")
    private String clientSecret;

    @Override
    public String getAuth() {
        String tokenKey = redisTemplate.opsForValue().get("BAIDU_OCR_ACCESS_TOKEN_KEY");
        return tokenKey != null ? tokenKey : getAuth(clientId, clientSecret);
    }

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    @Override
    public String generalBasic() {
        try {
            // 本地文件路径
            String filePath = "/Users/weiweizhao/Desktop/test.png";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);

            String imgParam = URLEncoder.encode(imgStr, "UTF-8");
            String param = "image=" + imgParam;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = getAuth();

            String result = HttpUtil.post(generalBasicUrl, accessToken, param);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取API访问token
     * 该token有一定的有效期，需要自行管理，当失效时需重新获取.
     *
     * @param ak - 百度云官网获取的 API Key
     * @param sk - 百度云官网获取的 Securet Key
     * @return assess_token 示例：
     * "24.460da4889caad24cccdb1fea17221975.2592000.1491995545.282335-1234567"
     */
    public String getAuth(String ak, String sk) {
        // 获取token地址
        String getAccessTokenUrl = tokenUrl
                // 1. grant_type为固定参数
                + "?grant_type=client_credentials"
                // 2. 官网获取的 API Key
                + "&client_id=" + ak
                // 3. 官网获取的 Secret Key
                + "&client_secret=" + sk;
        try {
            URL realUrl = new URL(getAccessTokenUrl);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.err.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            /**
             * 返回结果示例
             */
            System.err.println("result:" + result);
            JSONObject jsonObject = JSONObject.parseObject(result);
            return jsonObject.getString("access_token");
        } catch (Exception e) {
            System.err.printf("获取token失败！");
            e.printStackTrace(System.err);
        }
        return null;
    }
}
