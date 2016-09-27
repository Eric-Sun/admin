package com.j13.admin.util;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.j13.admin.core.AdminConstants;
import com.j13.admin.core.AdminException;
import com.j13.admin.net.DZ;
import com.j13.admin.net.ListDZResponse;
import com.j13.admin.net.SizeDZResponse;
import com.h13.slg.core.config.PropertiesConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class JaxManager {


    private String getBaseUrl() {
        String url = PropertiesConfiguration.getInstance().getStringValue(AdminConstants.JAX_SERVER_URL_KEY);
        return url;
    }


    public List<DZ> listDZ(String date, int pageNum, int size) throws AdminException {
        Map<String, String> innerParams = Maps.newHashMap();
        innerParams.put("date", date);
        innerParams.put("pageNum", pageNum + "");
        innerParams.put("size", size + "");


        Map<String, String> params = Maps.newHashMap();
        params.put("args", JSON.toJSONString(innerParams));
        params.put("act", "dz.listDZByDate");
        String url = getBaseUrl();
        String paramString = JSON.toJSONString(params);

        String rawResponse = InternetUtil.post(url, params);
        ListDZResponse dzAddResponse = JSON.parseObject(rawResponse, ListDZResponse.class);
        return dzAddResponse.getData();
    }


    public int sizeDZ(String date) throws AdminException {
        Map<String, String> innerParams = Maps.newHashMap();
        innerParams.put("date", date);


        Map<String, String> params = Maps.newHashMap();
        params.put("args", JSON.toJSONString(innerParams));
        params.put("act", "dz.sizeDZByDate");
        String url = getBaseUrl();
        String paramString = JSON.toJSONString(params);

        String rawResponse = InternetUtil.post(url, params);
        SizeDZResponse response = JSON.parseObject(rawResponse, SizeDZResponse.class);
        return response.getData();
    }
}
