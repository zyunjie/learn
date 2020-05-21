package com.tanke.demo.tanke1;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.Random;

/**
 * created by zyj on 2020/5/14
 */
public class MyTanke {
    private  int x, y;
    //每次移动速度
    final  int SPEED=Integer.parseInt((String) PropertyMgr.get("tankSpeed"));
    Dir dir = Dir.LEFT;
    //坦克移动变量
    private boolean moving = true;
    private boolean living = true;

    private Random random=new Random();
    private Group group=Group.BAD;

    Rectangle rect = new Rectangle();

    public static  int WIDTH=ResourceMgr.tankL.getWidth();
    public static int  HEIGHT=ResourceMgr.tankL.getHeight();
    TankeFrame tf = null;
    

    public MyTanke(int x, int y, Dir dir,TankeFrame tf,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf=tf;
        this.group=group;

        rect.x=this.x;
        rect.y=this.y;
        rect.width=WIDTH;
        rect.height=HEIGHT;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void paint(Graphics graphics) {
        if (!living){tf.myTankes.remove(this);}
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

        if (this.group==Group.BAD&&random.nextInt(10)>8){this.fire();}
        if (this.group==Group.BAD &&random.nextInt(100)>95) {
            randomDir();
        }
        boundCheck();
        rect.x=this.x;
        rect.y=this.y;
    }

    private void boundCheck() {
        if (this.x<0)x=0;
        if(this.y<30)y=30;
        if (this.x>TankeFrame.FRAME_WIDTH-MyTanke.WIDTH)x=TankeFrame.FRAME_WIDTH-MyTanke.WIDTH;
        if (this.y>TankeFrame.FRAME_HEIGHT-MyTanke.HEIGHT)y=TankeFrame.FRAME_HEIGHT-MyTanke.HEIGHT;
    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
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
        tf.bullets.add(new Bullet(bx,by,this.dir,this.tf,this.getGroup()));

    }

    public void die() {
        this.living=false;
    }

    public TankeFrame getTf() {
        return tf;
    }

    public void setTf(TankeFrame tf) {
        this.tf = tf;
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

    public static int getWIDTH() {
        return WIDTH;
    }

    public static void setWIDTH(int WIDTH) {
        MyTanke.WIDTH = WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static void setHEIGHT(int HEIGHT) {
        MyTanke.HEIGHT = HEIGHT;
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
