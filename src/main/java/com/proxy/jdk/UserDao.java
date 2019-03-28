package com.proxy.jdk;

import com.proxy.IUserDao;

public class UserDao implements IUserDao {
    public void save() {
        System.out.println("数据保存");
    }
}
