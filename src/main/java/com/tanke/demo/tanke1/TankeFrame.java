package com.tanke.demo.tanke1;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * created by zyj on 2020/5/13
 */
public class TankeFrame extends Frame {

    MyTanke myTanke = new MyTanke(500,500,Dir.UP,this,Group.GOOD);
    ArrayList<Bullet> bullets = new ArrayList<>();
    ArrayList<MyTanke> myTankes = new ArrayList<>();
    ArrayList<Explode> explodes= new ArrayList<>();
    final  static int  FRAME_WIDTH=Integer.parseInt((String) PropertyMgr.get("FRAME_WIDTH"));
    final  static int  FRAME_HEIGHT=Integer.parseInt((String) PropertyMgr.get("FRAME_HEIGHT"));
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
                case KeyEvent.VK_CONTROL:
                    myTanke.fire();
                    break;
                default:
                    break;
            }
            setTankeDir();
        }

        private void setTankeDir() {
            myTanke.setMoving(true);
            if (bl) {
                myTanke.setDir(Dir.LEFT);
            }
            if (bu) {
                myTanke.setDir(Dir.UP);
            }
            if (br) {
                myTanke.setDir(Dir.RIGHT);
            }
            if (bd) {
                myTanke.setDir(Dir.DOWN);
            }
            if (!bl && !bu&& !br && !bd){myTanke.setMoving(false);}
        }
    }

    /**
    *@Author : zyj
    *@Date : 15:03 2020/5/15
    * 
    */
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
        Color color = graphics.getColor();
        graphics.setColor(Color.white);
        graphics.drawString("子弹数"+bullets.size(),10,60);
        graphics.setColor(color);
        myTanke.paint(graphics);
        for (int i=0;i<myTankes.size();i++){
            myTankes.get(i).paint(graphics);
        }
        for (int i=0;i<bullets.size();i++){
            bullets.get(i).paint(graphics);
        }
        for (int i=0;i<explodes.size();i++){
            explodes.get(i).paint(graphics);
        }
        for (int i=0;i<bullets.size();i++){
            for (int j=0;j<myTankes.size();j++) {
                bullets.get(i).collideWith(myTankes.get(j));
            }
        }
    }



}
