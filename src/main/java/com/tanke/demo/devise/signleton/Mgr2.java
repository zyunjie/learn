package com.tanke.demo.devise.signleton;

/**
 * created by zyj on 2020/5/21
 * 加锁的懒汉式
 * volatile 防止指令重拍  如果没有volatile 会在没有初始化的时候返回instance
 */
public class Mgr2 {

    private static volatile Mgr2 instance;

    private Mgr2() {
    }

    public static Mgr2 getInstance() {
        if (instance == null) {
            synchronized (Mgr2.class){
                if (instance==null) {
                    try {
                        Thread.sleep(200);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    instance = new Mgr2();
                }
            }

        }
        return instance;

    }
    public static void main(String[] args) {
        for(int i=0;i<10000;i++){
            new Thread(()->{
                System.out.println(Mgr2.getInstance().hashCode());
            }).start();
        }
    }
}
