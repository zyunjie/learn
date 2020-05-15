package com.tanke.demo.tanke1;

import java.awt.*;

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
        Color color = graphics.getColor();
        graphics.setColor(Color.white);
        graphics.fillRect(x,y,50,50);
        graphics.setColor(color);
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
        tf.bullets.add(new Bullet(this.x,this.y,this.dir,this.tf));

    }

    public TankeFrame getTf() {
        return tf;
    }

    public void setTf(TankeFrame tf) {
        this.tf = tf;
    }
}
