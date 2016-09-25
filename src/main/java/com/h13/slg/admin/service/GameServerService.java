package com.h13.slg.admin.service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.h13.slg.admin.core.ConfigurationConstants;
import com.h13.slg.admin.util.PassportUtil;
//import com.h13.slg.config.PropertiesConfiguration;
import com.h13.slg.core.exception.RequestFatalException;
import com.h13.slg.core.transmission.passport.PassportResponse;
import com.h13.slg.core.transmission.passport.PassportResponseCode;
import com.h13.slg.core.transmission.passport.model.GameServer;
import com.h13.slg.core.util.HttpClientUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by sunbo on 14-11-7.
 */
@Service
public class GameServerService {


    public List<GameServer> list() throws RequestFatalException {

        String targetUrl = "/gameserver/list";

        Map<String, String> data = Maps.newHashMap();
//        PassportResponse passportResponse = PassportUtil.remote(targetUrl, data);
//
//        Map<String, Object> responseData = passportResponse.getData();
//        Object gameServerListData = responseData.get("list");
//        List<GameServer> gameServerList = JSON.parseArray(JSON.toJSONString(gameServerListData), GameServer.class);
//        return gameServerList;
        return null;
    }

    public void create(String name, String ip, int port, String openTime, int status) throws RequestFatalException {
        String targetUrl = "/gameserver/create";
        Map<String, String> data = Maps.newHashMap();
        data.put("name", name);
        data.put("ip", ip);
        data.put("port", port + "");
        data.put("opentime", openTime);
        data.put("status", status + "");

//        PassportResponse passportResponse = PassportUtil.remote(targetUrl, data);

    }

    public void update(int id, String name, String ip, int port, String openTime, int status) throws RequestFatalException {
        String targetUrl = "/gameserver/update";
        Map<String, String> data = Maps.newHashMap();
        data.put("name", name);
        data.put("ip", ip);
        data.put("port", port + "");
        data.put("opentime", openTime);
        data.put("status", status + "");
        data.put("id", id + "");

//        PassportResponse passportResponse = PassportUtil.remote(targetUrl, data);
    }

    public GameServer get(int id) throws RequestFatalException {

//        String targetUrl = "/gameserver/" + id;
//        Map<String, String> data = Maps.newHashMap();
//        PassportResponse passportResponse = PassportUtil.remote(targetUrl, data);
//        Object gameServerObject = passportResponse.getData().get("gameServer");
//
//        GameServer gameServer = JSON.parseObject(JSON.toJSONString(gameServerObject), GameServer.class);
//        return gameServer;
        return null;
    }

    public void delete(int id) throws RequestFatalException {
//        String targetUrl = "/gameserver/delete";
//        Map<String, String> data = Maps.newHashMap();
//        data.put("id", id + "");
//        PassportResponse passportResponse = PassportUtil.remote(targetUrl, data);

    }
}
