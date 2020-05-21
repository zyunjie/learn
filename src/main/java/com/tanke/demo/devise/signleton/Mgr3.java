package com.tanke.demo.devise.signleton;

/**
 * created by zyj on 2020/5/21
 * 内部类实现 懒加载
 * 在加载外部类时内部类不会加载  在调用getinstance方法时加载
 */
public class Mgr3 {
    private Mgr3(){}
    private static class Mgr3Holder{
        private final static Mgr3 instance=new Mgr3();
    }
    public static Mgr3 getInstance(){
        return Mgr3Holder.instance;
    }

    public static void main(String[] args) {
        Mgr3 mgr3 = Mgr3.getInstance();
        Mgr3 mg = Mgr3.getInstance();
        System.out.println(mg==mgr3);

    }
}
