package com.tanke.demo.tanke1;

import java.awt.*;
import java.awt.event.*;

/**
 * created by zyj on 2020/5/13
 */
public class TankeFrame extends Frame {

    private  int x = 200, y = 200;
    //每次移动速度
    final  int SPEED=10;
    Dir dir = Dir.LEFT;

    public TankeFrame() {
        //frame就是一个窗口类
//        Frame f = new Frame();
        setVisible(true);
        setSize(800, 600);
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
    public void paint(Graphics graphics) {
        graphics.fillRect(x, y, 50, 50);
        switch (dir) {
            case LEFT:
                x-=SPEED;
                break;
            case UP:
                y-=SPEED;
                break;
            case RIGHT:
                x+=SPEED;
                break;
            case DOWN:
                y+=SPEED;
                break;
            default:
                break;
        }
//        y +=10;
    }

    class MyKeyListener extends KeyAdapter {
        //通过判断方向键是否为true确认往那个方向移动 或者斜向
        boolean bl = false;
        boolean br = false;
        boolean bu = false;
        boolean bd = false;

        @Override
        public void keyPressed(KeyEvent event) {
            //获取键代码
            int key = event.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
//                    x-=10;
                    bl = true;
                    break;
                case KeyEvent.VK_UP:
//                    y-=10;
                    bu = true;
                    break;
                case KeyEvent.VK_RIGHT:
//                    x+=10;
                    br = true;
                    break;
                case KeyEvent.VK_DOWN:
//                    y+=10;
                    bd = true;
                    break;
                default:
                    break;
            }
//            x +=10;
//            repaint();
            setTankeDir();
        }


        @Override
        public void keyReleased(KeyEvent event) {
            int key = event.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
//                    x-=10;
                    bl = false;
                    break;
                case KeyEvent.VK_UP:
//                    y-=10;
                    bu = false;
                    break;
                case KeyEvent.VK_RIGHT:
//                    x+=10;
                    br = false;
                    break;
                case KeyEvent.VK_DOWN:
//                    y+=10;
                    bd = false;
                    break;
                default:
                    break;
            }
            setTankeDir();
        }

        private void setTankeDir() {
            if (bl) dir = Dir.LEFT;
            if (bu) dir = Dir.UP;
            if (br) dir = Dir.RIGHT;
            if (bd) dir = Dir.DOWN;
        }
    }

}
