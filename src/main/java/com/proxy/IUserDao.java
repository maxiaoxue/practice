package com.proxy;


/**
 * 1.如果是静态代理，代理类和目标类都要是实现
 * 2.如果是JDK动态代理，则只要目标类实现
 * */
public interface IUserDao {
    public void save();
}
