package com.j13.admin.controller;

import com.google.common.base.Strings;
import com.j13.admin.model.Account;
import com.j13.admin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by sunbo on 15-3-31.
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;


    @RequestMapping("/query")
    public String query(Map<String, Object> model,
                        @RequestParam(value = "aid", defaultValue = "0") int aid,
                        @RequestParam(value = "name", defaultValue = "") String name) {
        Account account = null;
        if (aid != 0) {
            // aid
            account = accountService.queryById(aid);
        } else if (!Strings.isNullOrEmpty(name)) {
            //
            account = accountService.queryByName(name);
        } else {
            return "/account/query";
        }
        model.put("account", account);
        return "/account/query";
    }

    @RequestMapping("/preQuery")
    public String preQuery(HttpServletRequest request) {
        return "/account/query";
    }


    @RequestMapping("/lock")
    public String lock(@RequestParam(value = "aid") int aid) {

        accountService.lock(aid);

        return "forward:/account/query";
    }

    @RequestMapping("/unlock")
    public String unlock(@RequestParam(value="aid") int aid){
        accountService.unlock(aid);

        return "forward:/account/query";
    }

}


