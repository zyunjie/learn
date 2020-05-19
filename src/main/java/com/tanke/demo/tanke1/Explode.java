package com.tanke.demo.tanke1;

import java.awt.*;

/**
 * created by zyj on 2020/5/19
 */
public class Explode {
    private  int x, y;
    public static  int WIDTH=ResourceMgr.explodes[0].getWidth();
    public static int  HEIGHT=ResourceMgr.explodes[0].getHeight();

    private int step=0;
    private boolean living=true;
    TankeFrame tankeFrame= null;

    public void paint(Graphics graphics) {
        if (!living){
            this.tankeFrame.explodes.remove(this);
        }
        graphics.drawImage(ResourceMgr.explodes[step++],x,y,null);
        if (step>=ResourceMgr.explodes.length){
            this.living=false;
            step=0;
        }
    }


    public Explode(int x, int y, TankeFrame tankeFrame) {
        this.x = x;
        this.y = y;
        this.tankeFrame=tankeFrame;
    }



}
