package com.xls.trankbattle;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class ResourMgr {
    public static BufferedImage goodTankL, goodTankR, goodTankU, goodTankD;
    public static BufferedImage badTankL, badTankR, badTankU, badTankD;
    public static BufferedImage bulletD, bulletU, bulletR, bulletL;
    public static BufferedImage[] explodes = new BufferedImage[16];

    static {
        try {

            goodTankU = ImageIO.read(ResourMgr.class.getClassLoader().getResourceAsStream("images\\GoodTank1.png"));
            goodTankD = ImagesUtil.rotateImage(goodTankU, 180);
            goodTankL = ImagesUtil.rotateImage(goodTankU, -90);
            goodTankR = ImagesUtil.rotateImage(goodTankU, 90);

            badTankU = ImageIO.read(ResourMgr.class.getClassLoader().getResourceAsStream("images\\BadTank1.png"));
            badTankD = ImagesUtil.rotateImage(badTankU, 180);
            badTankL = ImagesUtil.rotateImage(badTankU, -90);
            badTankR = ImagesUtil.rotateImage(badTankU, 90);

            bulletU = ImageIO.read(ResourMgr.class.getClassLoader().getResourceAsStream("images\\bulletU.png"));
            bulletD = ImagesUtil.rotateImage(bulletU, 180);
            bulletL = ImagesUtil.rotateImage(bulletU, -90);
            bulletR = ImagesUtil.rotateImage(bulletU, 90);

            //爆炸图片显示
            for (int i = 0; i < 16; i++) {
                InputStream is = ResourMgr.class.getClassLoader().getResourceAsStream("images\\e" + (i + 1) + ".gif");
                explodes[i] = ImageIO.read(is);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
