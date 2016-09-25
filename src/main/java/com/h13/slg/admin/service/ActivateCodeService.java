package com.h13.slg.admin.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.h13.slg.admin.core.ConfigurationConstants;
import com.h13.slg.admin.model.ActivateCode;
import com.h13.slg.admin.model.ActivateCodeGroup;
import com.h13.slg.admin.util.PassportUtil;
import com.h13.slg.core.transmission.Response;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by sunbo on 15-3-29.
 */
@Service
public class ActivateCodeService {


    public void create(String groupName, int count) {
        Map<String, Object> args = Maps.newHashMap();
        args.put("groupName", groupName);
        args.put("count", count);

        Response response = PassportUtil.remote("adminActivateCode", "create", args);

    }


    public List<ActivateCodeGroup> groupList() {
        List<ActivateCodeGroup> returnList = Lists.newLinkedList();
        Map<String, Object> args = Maps.newHashMap();
        Response response = PassportUtil.remote("adminActivateCode", "groupList", args);
        List<JSONObject> list = (List<JSONObject>) response.getData().get("list");
        for (JSONObject json : list) {
            ActivateCodeGroup acg = JSON.parseObject(JSON.toJSONString(json), ActivateCodeGroup.class);
            returnList.add(acg);
        }
        return returnList;
    }

    public void deleteGroup(int groupId) {
        Map<String, Object> args = Maps.newHashMap();
        args.put("groupId", groupId);

        Response response = PassportUtil.remote("adminActivateCode", "deleteGroup", args);

    }

    public List<ActivateCode> queryByGroupName(String groupName) {
        List<ActivateCode> returnList = Lists.newLinkedList();
        Map<String, Object> args = Maps.newHashMap();
        args.put("groupName", groupName);

        Response response = PassportUtil.remote("adminActivateCode", "queryByGroupName", args);
        List<JSONObject> jsonList = (List<JSONObject>) response.getData().get("list");
        for (JSONObject json : jsonList) {
            ActivateCode ac = JSON.parseObject(JSON.toJSONString(json), ActivateCode.class);
            returnList.add(ac);
        }
        return returnList;
    }
}
