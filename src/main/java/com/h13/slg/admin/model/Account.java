package com.h13.slg.admin.model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 14-10-7
 * Time: 上午1:22
 * To change this template use File | Settings | File Templates.
 */
public class Account {

    private int id;
    private String name;
    private Date createtime;
    private int status;

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
