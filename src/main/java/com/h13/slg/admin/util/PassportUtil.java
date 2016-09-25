package com.h13.slg.admin.util;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.h13.slg.admin.core.ConfigurationConstants;
import com.h13.slg.core.config.PropertiesConfiguration;
import com.h13.slg.core.exception.RequestFatalException;
import com.h13.slg.core.transmission.Response;
import com.h13.slg.core.transmission.passport.PassportResponse;
import com.h13.slg.core.transmission.passport.PassportResponseCode;
import com.h13.slg.core.util.HttpClientUtil;

import java.util.Date;
import java.util.Map;

/**
 * Created by sunbo on 14-11-11.
 */
public class PassportUtil {

    public static Response remote(String mod, String act, Map<String, Object> args) throws RequestFatalException {

        Map<String, String> data = Maps.newHashMap();
        data.put("mod", mod);
        data.put("act", act);
        data.put("token", "aaaa");
        data.put("aid", "0");
        data.put("args", JSON.toJSONString(args));

        HttpClientUtil client = new HttpClientUtil();
        String url = PropertiesConfiguration.getInstance().getStringValue(ConfigurationConstants.PASSPORT_URL);

        String targetUrl = url;
        String responseStr = client.post(targetUrl, data).trim();
        System.out.println(responseStr);
        Response passportResponse = JSON.parseObject(responseStr, Response.class);

        if (passportResponse.getCode() != PassportResponseCode.SUCCESS) {
            throw new RequestFatalException(passportResponse.getCode(), "url=" + targetUrl);
        }
        return passportResponse;
    }


}
