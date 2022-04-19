package com.banshan.wx.mp.controller;

import com.banshan.wx.mp.service.IReplyMsgService;
import com.banshan.wx.mp.util.MessageUtil;
import com.banshan.wx.mp.util.SignUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 * 验证
 *
 * @author 半山兄
 * @since 2022/02/21
 */
@Controller
@Slf4j
public class SecurityController {

    @Resource
    private IReplyMsgService replyMsgService;

    @RequestMapping(value = "security", method = RequestMethod.GET, produces = "text/html;charset=utf-8")
    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "signature") String signature,
            @RequestParam(value = "timestamp") String timestamp,
            @RequestParam(value = "nonce") String nonce,
            @RequestParam(value = "echostr") String echostr) {
        try {
            if (SignUtil.checkSignature(signature, timestamp, nonce)) {
                log.info("验签成功");
                PrintWriter out = response.getWriter();
                out.print(echostr);
                out.close();
            } else {
                log.error("验签失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * post方法用于接收微信服务端消息
     *
     * @param request  req
     * @param response resp
     */
    @RequestMapping(value = "security", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            Map<String, String> requestMap = MessageUtil.parseXml(request);
            log.info("接收消息:" + requestMap);
            String resp = replyMsgService.reply(requestMap);
            log.info("发送消息:" + resp);
            PrintWriter out = response.getWriter();
            out.print(resp);
            out.close();
        } catch (Exception e) {
            log.error("error", e);
        }
    }
}
