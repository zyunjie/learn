package com.tanke.demo.devise.signleton;

/**
 * created by zyj on 2020/5/21
 * 饿汉式单利
 */
public class Mgr {
    private static Mgr instace = new Mgr();
    private Mgr(){};
    public static Mgr getInstace(){
        return instace;
    }
}
