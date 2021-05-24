package com.xls.trankbattle;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class ResourMgr {
    public static BufferedImage tankL, tankR, tankU, tankD;
    public static BufferedImage bulletD, bulletU, bulletR, bulletL;
    public static BufferedImage[] explodes = new BufferedImage[16];

    static {
        try {

            tankU = ImageIO.read(ResourMgr.class.getClassLoader().getResourceAsStream("images\\BadTank1.png"));
            tankD = ImagesUtil.rotateImage(tankU, 180);
            tankL = ImagesUtil.rotateImage(tankU, -90);
            tankR = ImagesUtil.rotateImage(tankU, 90);

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
