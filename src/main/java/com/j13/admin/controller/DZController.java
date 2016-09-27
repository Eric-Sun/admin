package com.j13.admin.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.j13.admin.core.AdminException;
import com.j13.admin.net.DZ;
import com.j13.admin.service.DZService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dz")
public class DZController {

    @Autowired
    DZService dzService;

    @RequestMapping("/list")
    public String list(HttpServletRequest request, Map<String, Object> model) throws AdminException {


        return "/dz/list";
    }


    @RequestMapping("/listByDate")
    @ResponseBody
    public String listByDate(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) throws AdminException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        int draw = new Integer(request.getParameter("draw"));
        String date = request.getParameter("date");
        if (date == null)
            date = "09/16/2016";


        int start = new Integer(request.getParameter("start"));
        int length = new Integer(request.getParameter("length"));

        List<DZ> list = dzService.listDZ(date, start, length);
        int size = dzService.sizeDZ(date);
        model.put("draw", draw);
        model.put("recordsTotal", size);
        model.put("recordsFiltered", size);


        List<List<String>> l1 = Lists.newLinkedList();
        for (DZ dz : list) {
            List<String> ll1 = Lists.newLinkedList();
            ll1.add(dz.getContent());
            l1.add(ll1);
        }
        model.put("data", l1);
        return JSON.toJSONString(model);
    }
}
