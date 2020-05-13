package com.tanke.demo.tanke1;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * created by zyj on 2020/5/12
 * new 一个窗口
 */
public class FrameTest {

    public static void main(String[] args) throws InterruptedException {
        TankeFrame tf = new TankeFrame();
        while (true){
            Thread.sleep(50);
            tf.repaint();
        }
    }

}
