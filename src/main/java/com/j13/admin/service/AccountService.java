package com.j13.admin.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.j13.admin.model.Account;
import com.j13.admin.util.PassportUtil;
import com.h13.slg.core.transmission.Response;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by sunbo on 15-3-31.
 */
@Service
public class AccountService {


    public Account queryById(int aid) {
        Map<String, Object> args = Maps.newHashMap();
        args.put("aid", aid);

        Response response = PassportUtil.remote("adminAccount", "queryById", args);
        JSONObject json = (JSONObject) response.getData().get("account");
        return JSON.parseObject(json.toJSONString(), Account.class);
    }


    public Account queryByName(String name) {
        Map<String, Object> args = Maps.newHashMap();
        args.put("name", name);

        Response response = PassportUtil.remote("adminAccount", "queryByName", args);
        JSONObject json = (JSONObject) response.getData().get("account");
        return JSON.parseObject(json.toJSONString(), Account.class);
    }


    public void lock(int aid) {
        Map<String, Object> args = Maps.newHashMap();
        args.put("aid", aid);

        Response response = PassportUtil.remote("adminAccount", "lock", args);
        JSONObject json = (JSONObject) response.getData().get("list");
    }

    public void unlock(int aid) {
        Map<String, Object> args = Maps.newHashMap();
        args.put("aid", aid);

        Response response = PassportUtil.remote("adminAccount", "unlock", args);
        JSONObject json = (JSONObject) response.getData().get("list");
    }
}
