package com.tanke.demo.tanke1;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * created by zyj on 2020/5/13
 */
public class TankeFrame extends Frame {

    public TankeFrame(){
        //frame就是一个窗口类
//        Frame f = new Frame();
        setVisible(true);
        setSize(800,600);
        setResizable(false);
        setTitle("tanke game");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
//                super.windowClosing(e);
                //系统退出
                System.exit(0);
            }
        });
    }

    //窗口重新绘制的时候自动执行这个方法
    @Override
    public void paint(Graphics graphics){
        graphics.fillRect(200,200,50,50);
        System.out.println("hello world frame");
    }


}
