package com.proxy.jdk;

import com.proxy.IUserDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    IUserDao dao;

    public ProxyFactory(IUserDao dao) {
        this.dao = dao;
    }

    public Object getProxyInstance(){

        return Proxy.newProxyInstance(dao.getClass().getClassLoader(),
                dao.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        System.out.println("开始事务");
                        Object returnValue = method.invoke(proxy,args);
                        System.out.println("结束事务");
                        return returnValue;
                    }
                });

    }

    public static void main(String[] args){
        IUserDao dao =  new UserDao();
        ProxyFactory proxyFactory = new ProxyFactory(dao);
        Object  o = proxyFactory.getProxyInstance();
        System.out.println(o);

    }
}
