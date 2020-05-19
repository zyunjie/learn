package com.tanke.demo.tanke1;

import java.awt.*;
import java.util.Collection;

/**
 * created by zyj on 2020/5/14
 */
public class Bullet {
    private  int x, y;
    //每次移动速度
    final  int SPEED=10;
    Dir dir;
    public static  int WIDTH=ResourceMgr.bulletD.getWidth();
    public static int  HEIGHT=ResourceMgr.bulletD.getHeight();

    Rectangle rect = new Rectangle();
    private Group group = Group.BAD;
    TankeFrame tankeFrame= null;
    //子弹存活状态
    private boolean live= true;




    public void paint(Graphics graphics) {
        if (!live){
            tankeFrame.bullets.remove(this);
        }
        //画出子弹
        switch (dir) {
            case LEFT:
                graphics.drawImage(ResourceMgr.bulletL,x,y, null);
                break;
            case UP:
                graphics.drawImage(ResourceMgr.bulletU,x,y, null);
                break;
            case RIGHT:
                graphics.drawImage(ResourceMgr.bulletR,x,y, null);
                break;
            case DOWN:
                graphics.drawImage(ResourceMgr.bulletD,x,y, null);
                break;
            default:
                break;
        }
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
        rect.x=this.x;
        rect.y=this.y;
        if (x<0||y<0||x>TankeFrame.FRAME_WIDTH||y>TankeFrame.FRAME_HEIGHT){
            live=false;
        }
    }


    public Bullet(int x, int y, Dir dir,TankeFrame tankeFrame,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankeFrame=tankeFrame;
        this.group=group;
        rect.x=this.x;
        rect.y=this.y;
        rect.width=WIDTH;
        rect.height=HEIGHT;
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

    public void collideWith(MyTanke myTanke) {
        if (this.group==myTanke.getGroup()) return;
        //todo子弹和坦克中使用一个tectangle记录位置
        if (rect.intersects(myTanke.rect)){
            this.die();
            myTanke.die();
            int ex= myTanke.getX()+MyTanke.WIDTH/2-Explode.WIDTH/2;
            int ey= myTanke.getY()+MyTanke.HEIGHT/2-Explode.HEIGHT/2;
            tankeFrame.explodes.add(new Explode(ex,ey,this.tankeFrame));

        }
    }

    private void die() {
        this.live=false;
    }
}
