package com.tanke.demo;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * created by zyj on 2020/5/15
 */
public class ImageTest {

    @Test
    void test() throws IOException {
        BufferedImage image = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
        assertNotNull(image);
    }
}
