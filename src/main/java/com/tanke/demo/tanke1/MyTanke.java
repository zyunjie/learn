package com.tanke.demo.tanke1;

import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * created by zyj on 2020/5/14
 */
public class MyTanke {
    private  int x, y;
    //每次移动速度
    final  int SPEED=5;
    Dir dir = Dir.LEFT;
    //坦克移动变量
    private boolean moving = false;

    public static  int WIDTH=ResourceMgr.tankL.getWidth();
    public static int  HEIGHT=ResourceMgr.tankL.getHeight();
    TankeFrame tf = null;
    

    public MyTanke(int x, int y, Dir dir,TankeFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf=tf;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void paint(Graphics graphics) {
        //画出坦克
        switch (dir) {
            case LEFT:
                graphics.drawImage(ResourceMgr.tankL,x,y, null);
                break;
            case UP:
                graphics.drawImage(ResourceMgr.tankdU,x,y, null);
                break;
            case RIGHT:
                graphics.drawImage(ResourceMgr.tankR,x,y, null);
                break;
            case DOWN:
                graphics.drawImage(ResourceMgr.tankD,x,y, null);
                break;
            default:
                break;
        }
        move();

    }

    private void move() {
        if (!moving){return;}
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
    }


    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void fire() {
        int bx=this.x+MyTanke.WIDTH/2-Bullet.WIDTH/2;
        int by=this.y+MyTanke.HEIGHT/2-Bullet.HEIGHT/2;
        tf.bullets.add(new Bullet(bx,by,this.dir,this.tf));

    }

    public TankeFrame getTf() {
        return tf;
    }

    public void setTf(TankeFrame tf) {
        this.tf = tf;
    }
}
