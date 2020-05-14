package com.tanke.demo.tanke1;

import java.awt.*;
import java.util.Collection;

/**
 * created by zyj on 2020/5/14
 */
public class Bullet {
    private  int x, y;
    //每次移动速度
    final  int SPEED=1;
    Dir dir;
    private static  int WIDTH=20,HEIGHT=20;




    public void paint(Graphics graphics) {
        //画出子弹
        Color color = graphics.getColor();
        graphics.setColor(Color.red);
        graphics.fillOval(x,y,WIDTH,HEIGHT);
        graphics.setColor(color);
        move();

    }
    private void move() {
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


    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSPEED() {
        return SPEED;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }
}
