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
    

    public MyTanke(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
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
        graphics.setColor(Color.red);
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
}
