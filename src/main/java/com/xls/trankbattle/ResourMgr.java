package com.xls.trankbattle;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

public class ResourMgr {
    public static BufferedImage tankL, tankR, tankU, tankD;
    public static BufferedImage bulletD, bulletU, bulletR, bulletL;

    static {
        try {
            tankL = ImageIO.read(ResourMgr.class.getClassLoader().getResourceAsStream("images\\tankL.gif"));
            tankR = ImageIO.read(ResourMgr.class.getClassLoader().getResourceAsStream("images\\tankR.gif"));
            tankU = ImageIO.read(ResourMgr.class.getClassLoader().getResourceAsStream("images\\tankU.gif"));
            tankD = ImageIO.read(ResourMgr.class.getClassLoader().getResourceAsStream("images\\tankD.gif"));

            bulletD = ImageIO.read(ResourMgr.class.getClassLoader().getResourceAsStream("images\\bulletD.gif"));
            bulletU = ImageIO.read(ResourMgr.class.getClassLoader().getResourceAsStream("images\\bulletU.gif"));
            bulletR = ImageIO.read(ResourMgr.class.getClassLoader().getResourceAsStream("images\\bulletR.gif"));
            bulletL = ImageIO.read(ResourMgr.class.getClassLoader().getResourceAsStream("images\\bulletL.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
