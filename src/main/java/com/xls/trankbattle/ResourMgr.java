package com.xls.trankbattle;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class ResourMgr {
    public static BufferedImage tankL, tankR, tankU, tankD;
    public static BufferedImage bulletD, bulletU, bulletR, bulletL;
    public static BufferedImage[] explodes = new BufferedImage[17];
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
            for (int i = 0; i < 16 ; i++) {
                InputStream is = ResourMgr.class.getClassLoader().getResourceAsStream("images\\e"+(i+1)+".gif");
                explodes[i] = ImageIO.read(is);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
