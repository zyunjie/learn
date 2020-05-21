package com.tanke.demo.devise.signleton;

/**
 * created by zyj on 2020/5/21
 * 懒汉式单利
 */
public class Mgr1 {
    private static Mgr1 instance;

    private Mgr1() {
    }

    public static Mgr1 getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            instance = new Mgr1();
        }
        return instance;

    }

    public static void main(String[] args) {
        for(int i=0;i<10000;i++){
            new Thread(()->{
                System.out.println(Mgr1.getInstance().hashCode());
            }).start();
        }
    }
}
