package com.proxy.staticproxy;

import com.proxy.IUserDao;

public class UserDao implements IUserDao {
    public void save() {
        System.out.println("存入数据");
    }
}
