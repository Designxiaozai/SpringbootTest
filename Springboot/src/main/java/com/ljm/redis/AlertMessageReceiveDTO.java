package com.ljm.redis;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;


import lombok.Data;

/**
 * 用来接收告警信息的DTO类
 */
@Data
@SuppressWarnings("all")
public class AlertMessageReceiveDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    private LinkedHashMap<String,String> labels;

    private Map labelIds;

    private Map annotations;

    private String startsAt;

    private String endsAt;

    private String generatorURL;

    private Boolean snmptrap;

    public String genHashKey() {

    	return UUID.randomUUID().toString();
    }
}
