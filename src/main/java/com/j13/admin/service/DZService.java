package com.j13.admin.service;

import com.j13.admin.core.AdminException;
import com.j13.admin.net.DZ;
import com.j13.admin.util.JaxManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DZService {

    private static int SIZE = 10;

    @Autowired
    JaxManager jaxManager;

    public List<DZ> listDZ(String date, int start, int length) throws AdminException {

        int pageNum = start / length;
        List<DZ> list = jaxManager.listDZ(date, pageNum, SIZE);

        return list;
    }

    public int sizeDZ(String date) throws AdminException {
        return jaxManager.sizeDZ(date);
    }
}
