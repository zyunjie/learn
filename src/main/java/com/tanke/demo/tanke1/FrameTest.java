package com.tanke.demo.tanke1;

import org.springframework.beans.factory.annotation.Value;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * created by zyj on 2020/5/12
 * new 一个窗口
 */
public class FrameTest {


    public static void main(String[] args) throws InterruptedException {
        TankeFrame tf = new TankeFrame();
        int tanks= Integer.parseInt((String) PropertyMgr.get("InitTanks"));
//        初始化敌方坦克
        for (int i=0; i<tanks;i++){
            tf.myTankes.add(new MyTanke(50+i*80,200,Dir.DOWN,tf,Group.BAD));
        }
        while (true){
            Thread.sleep(50);
            tf.repaint();
        }
    }

}
