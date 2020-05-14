package com.tanke.demo.tanke1;

import com.sun.javafx.scene.DirtyBits;

import javax.xml.ws.RespectBinding;
import java.awt.*;
import java.awt.event.*;

/**
 * created by zyj on 2020/5/13
 */
public class TankeFrame extends Frame {

    MyTanke myTanke = new MyTanke(200,200,Dir.DOWN);
    Bullet bullet = new Bullet(300,300,Dir.UP);
    final  static int  FRAME_WIDTH=800,FRAME_HEIGHT=600;
    public TankeFrame() {
        //frame就是一个窗口类
//        Frame f = new Frame();
        setVisible(true);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        setTitle("tanke game");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //调用重写的
        addKeyListener(new MyKeyListener());
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
            myTanke.setMoving(true);
            if (bl) myTanke.setDir(Dir.LEFT);
            if (bu) myTanke.setDir(Dir.UP);
            if (br) myTanke.setDir(Dir.RIGHT);
            if (bd) myTanke.setDir(Dir.DOWN);
            if (!bl && !bu&& !br && !bd){myTanke.setMoving(false);};
        }
    }

    //解决闪屏问题
    Image offScreenImage=null;
    @Override
    public void update(Graphics g){
        if (offScreenImage==null){
            offScreenImage=this.createImage(FRAME_WIDTH,FRAME_HEIGHT);
        }
        Graphics graphicsOff= offScreenImage.getGraphics();
        Color c = graphicsOff.getColor();
        graphicsOff.setColor(Color.black);
        graphicsOff.fillRect(0,0,FRAME_WIDTH,FRAME_HEIGHT);
        graphicsOff.setColor(c);
        paint(graphicsOff);
        g.drawImage(offScreenImage,0,0,null);
    }

    //窗口重新绘制的时候自动执行这个方法
    @Override
    public void paint(Graphics graphics) {
        myTanke.paint(graphics);
        bullet.paint(graphics);
    }



}
