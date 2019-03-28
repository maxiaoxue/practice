package com.proxy.staticproxy;

import com.proxy.IUserDao;

public class ProxyUserDao implements IUserDao {

    IUserDao target;

    public ProxyUserDao(IUserDao target) {
        this.target = target;
    }

    public void save() {
        System.out.println("事务开始");
        target.save();
        System.out.println("事务结束");
    }

    public static void main(String[] args){
        IUserDao userDao = new UserDao();
        ProxyUserDao proxy = new ProxyUserDao(userDao);
        proxy.save();

    }
}
