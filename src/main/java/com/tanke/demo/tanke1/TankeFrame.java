package com.tanke.demo.tanke1;

import java.awt.*;
import java.awt.event.*;

/**
 * created by zyj on 2020/5/13
 */
public class TankeFrame extends Frame {

    int x=200, y=200;

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
        //调用重写的
        addKeyListener(new MyKeyListener());
    }

    //窗口重新绘制的时候自动执行这个方法
    @Override
    public void paint(Graphics graphics){
        graphics.fillRect(x,y,50,50);

        y +=10;
    }

    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent event){
//            x +=10;
//            repaint();
            System.out.println("key pressed");
        }
        @Override
        public void keyReleased(KeyEvent event){
            System.out.println("key released");
        }
    }

}
