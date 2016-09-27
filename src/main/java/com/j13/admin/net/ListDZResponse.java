package com.j13.admin.net;

import java.util.List;

public class ListDZResponse extends BaseResponse {


    private List<DZ> data;

    public List<DZ> getData() {
        return data;
    }

    public void setData(List<DZ> data) {
        this.data = data;
    }
}

