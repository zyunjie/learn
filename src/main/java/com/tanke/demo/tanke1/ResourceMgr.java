package com.tanke.demo.tanke1;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * created by zyj on 2020/5/15
 */
public class ResourceMgr {

    public  static BufferedImage tankL,tankdU,tankR,tankD;
    static {
        try {
            tankL= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            tankdU= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            tankR= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
            tankD= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
