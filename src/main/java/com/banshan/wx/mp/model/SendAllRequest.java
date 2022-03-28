package com.banshan.wx.mp.model;

import lombok.Data;

import java.util.Map;

/**
 * {
 *    "filter":{
 *       "is_to_all":false,
 *       "tag_id":2
 *    },
 *    "text":{
 *       "content":"CONTENT"
 *    },
 *     "msgtype":"text"
 * }
 * @author 半山兄
 * @since 2022/03/02
 */
@Data
public class SendAllRequest {
    private Map<String, Object> filter;
    private Map<String, Object > text;
    private String msgtype;
}
