package com.tanke.demo.tanke1;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * created by zyj on 2020/5/12
 * new 一个窗口
 */
public class FrameTest {

    public static void main(String[] args) {
        //frame就是一个窗口类
        Frame f = new Frame();
        f.setVisible(true);
        f.setSize(800,600);
        f.setResizable(false);
        f.setTitle("tanke game");
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
//                super.windowClosing(e);
                //系统退出
                System.exit(0);
            }
        });
    }

}
